import com.android.build.gradle.AppExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

object AppConfiguration {

    fun configure(project: Project) {
        configureAppExtension(project)
        configureDependencies(project)
    }

    private fun configureAppExtension(project: Project) {
        println("--Extension")
        project.extensions.getByType(AppExtension::class.java).apply {
            compileSdkVersion(AppConfig.compileSdk)

            defaultConfig {
                applicationId = "eu.flowcode.instantweather"
                minSdk = AppConfig.minSdk
                targetSdk = AppConfig.targetSdk

                versionCode = AppConfig.versionCode
                versionName = AppConfig.versionName

                testInstrumentationRunner = AppConfig.androidTestInstrumentation

                vectorDrawables {
                    useSupportLibrary = true
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            composeOptions {
                kotlinCompilerExtensionVersion = Versions.ANDROIDX_COMPOSE
            }

            packagingOptions {
                resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }

            buildFeatures.apply {
                compose = true
            }
        }
    }

    private fun configureDependencies(project: Project) {
        println("--Dependencies")
        project.dependencies {
            add(DependencyConfiguration.implementation, Libs.ANDROID_MATERIAL)
            add(DependencyConfiguration.implementation, Libs.ANDROIDX_ACTIVITY_COMPOSE)
            add(DependencyConfiguration.implementation, Libs.ANDROIDX_APPCOMPAT)
            add(Dependencies.ANDROIDX_COMPOSE)
            add(DependencyConfiguration.implementation, Libs.ANDROIDX_CORE_KTX)
            add(DependencyConfiguration.implementation, Libs.ANDROIDX_LIFECYCLE_RUNTIME_KTX)

            add(DependencyConfiguration.testImplementation, Libs.JUNIT)

            add(DependencyConfiguration.androidTestImplementation, Libs.ANDROIDX_EXT_JUNIT)
            add(DependencyConfiguration.androidTestImplementation, Libs.ANDROIDX_ESPRESSO_CORE)
            add(DependencyConfiguration.androidTestImplementation, Libs.ANDROIDX_COMPOSE_TEST)
            add(DependencyConfiguration.debugImplementation, Libs.ANDROIDX_COMPOSE_TOOLING)
        }
    }
}