import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.internal.plugins.LibraryPlugin
import org.gradle.api.artifacts.dsl.DependencyHandler


class InstantWeatherPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.forEach { plugin ->
            val pluginName = plugin::class.java.simpleName
            when (plugin) {
                is AppPlugin ->
                    configurePlugin(pluginName, project, AppConfiguration::configure)
                is LibraryPlugin ->
                    configurePlugin(pluginName, project, LibraryConfiguration::configure)
            }
        }
    }

    private fun configurePlugin(name: String, project: Project, block: (project: Project) -> Unit) {
        println("---Configure $name")
        block(project)
    }
}

fun DependencyHandler.add(dependencies: Map<String, Any>) {
    dependencies
        .forEach { (configurationName, dependencyNotation) ->
            this.add(configurationName, dependencyNotation)
        }
}