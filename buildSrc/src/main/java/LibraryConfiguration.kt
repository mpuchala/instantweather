import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

object LibraryConfiguration {

    fun configure(project: Project) {
        configureLibraryExtension(project)
        configureBaseDependencies(project)
    }

    private fun configureLibraryExtension(project: Project) {
        println("--Extension")
        project.extensions.getByType(LibraryExtension::class.java).apply {
            compileSdk = LibraryConfig.compileSdk

            defaultConfig {
                minSdk = LibraryConfig.minSdk
                targetSdk = LibraryConfig.targetSdk

                consumerProguardFiles(LibraryConfig.proguardConsumerRules)

                testInstrumentationRunner = AppConfig.androidTestInstrumentation
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }
    }

    private fun configureBaseDependencies(project: Project) {
        println("--Dependencies")
        project.dependencies {
            add(DependencyConfiguration.implementation, Libs.ANDROIDX_CORE_KTX)

            add(DependencyConfiguration.testImplementation, Libs.JUNIT)

            add(DependencyConfiguration.androidTestImplementation, Libs.ANDROIDX_EXT_JUNIT)
            add(DependencyConfiguration.androidTestImplementation, Libs.ANDROIDX_ESPRESSO_CORE)
        }
    }
}