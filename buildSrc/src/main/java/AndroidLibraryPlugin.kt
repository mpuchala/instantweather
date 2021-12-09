import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.dependencies

private const val ANDROID_LIBRARY_EXTENSION_NAME = "androidLibrary"

class AndroidLibraryPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            addAndroidLibraryExtension()
            applyPlugins()
            androidConfig()
            dependenciesConfig()

            afterEvaluate {
                val androidLibrary =
                    project.extensions.findByName(ANDROID_LIBRARY_EXTENSION_NAME) as? AndroidLibraryExtension
            }
        }
    }
}

private fun Project.addAndroidLibraryExtension() {
    extensions.create(ANDROID_LIBRARY_EXTENSION_NAME, AndroidLibraryExtension::class.java)
}

private fun Project.applyPlugins() {
    println("-apply plugins")
    plugins.run {
        apply("com.android.library")
        apply("kotlin-android")
        apply("kotlin-kapt")
    }
}

private fun Project.androidConfig() {
    println("-android config")
    val android = extensions.getByType(LibraryExtension::class.java)

    android.run {
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

        /*kotlinOptions {

        }*/
    }
}

private fun Project.dependenciesConfig() {
    println("-dependencies config")
    dependencies {
        implementation(Libs.ANDROIDX_CORE_KTX)

        testImplementation(Libs.testLibraries)
        androidTestImplementation(Libs.androidTestLibraries)
    }
}