import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryPlugin : Plugin<Project> {

    private val Project.androidLibrary: AndroidLibraryExtension
        get() = extensions.findByName(AndroidLibraryExtension.NAME) as? AndroidLibraryExtension
            ?: throw(NullPointerException("${AndroidLibraryExtension.NAME} missing"))

    override fun apply(project: Project) {
        with(project) {
            addAndroidLibraryExtension()

            afterEvaluate {
                androidLibrary.let { androidLibrary ->
                    android(androidLibrary)
                    dependencies(androidLibrary)
                }
            }

            applyPlugins()
        }
    }
}

private fun Project.addAndroidLibraryExtension() {
    extensions.create(AndroidLibraryExtension.NAME, AndroidLibraryExtension::class.java)
}

private fun Project.applyPlugins() {
    println("- apply plugins")
    plugins.run {
        apply("com.android.library")
        apply("kotlin-android")
        apply("kotlin-kapt")
    }
}

private fun Project.android(androidLibrary: AndroidLibraryExtension) {
    println("- android")
    configure<LibraryExtension> {
        compileSdk = LibraryConfig.compileSdk

        defaultConfig {
            minSdk = LibraryConfig.minSdk
            targetSdk = LibraryConfig.targetSdk

            consumerProguardFiles(LibraryConfig.proguardConsumerRules)

            testInstrumentationRunner = AppConfig.androidTestInstrumentation
        }

        compileOptions {
            sourceCompatibility = LibraryConfig.javaVersion
            targetCompatibility = LibraryConfig.javaVersion
        }

        if (androidLibrary.compose) {
            androidCompose(this)
        }
    }
}

private fun Project.androidCompose(android: LibraryExtension) {
    println("- android Compose")
    android.run {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = Versions.ANDROIDX_COMPOSE
        }
    }
}

private fun Project.dependencies(androidLibrary: AndroidLibraryExtension) {
    println("- dependencies")
    dependencies {
        implementation(Libs.ANDROIDX_CORE_KTX)

        testImplementation(Libs.testLibraries)
        androidTestImplementation(Libs.androidTestLibraries)
    }

    if (androidLibrary.compose) {
        dependenciesCompose()
    }
}

private fun Project.dependenciesCompose() {
    println("- dependencies Compose")
    dependencies {
        implementation(Libs.androidxCompose)
        androidTestImplementation(Libs.androidxComposeTestLibraries)
    }
}