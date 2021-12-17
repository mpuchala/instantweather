import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    const val GRADLE = "7.0.4"
    const val KOTLIN = "1.5.31"

    const val ANDROID_MATERIAL = "1.4.0"

    const val ANDROIDX_ACTIVITY_COMPOSE = "1.4.0"
    const val ANDROIDX_APPCOMPAT = "1.4.0"
    const val ANDROIDX_COMPOSE = "1.0.5"
    const val ANDROIDX_CORE = "1.7.0"
    const val ANDROIDX_LIFECYCLE = "2.4.0"

    const val JUNIT = "4.13"
    const val ANDROIDX_EXT_JUNIT = "1.1.3"
    const val ANDROIDX_ESPRESSO = "3.4.0"
}

object Libs {
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.ANDROID_MATERIAL}"

    const val ANDROIDX_ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY_COMPOSE}"
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:${Versions.ANDROIDX_APPCOMPAT}"
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE}"

    const val ANDROIDX_COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.ANDROIDX_COMPOSE}"
    const val ANDROIDX_COMPOSE_UI = "androidx.compose.ui:ui:${Versions.ANDROIDX_COMPOSE}"
    const val ANDROIDX_COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.ANDROIDX_COMPOSE}"

    const val ANDROIDX_LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ANDROIDX_LIFECYCLE}"

    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"

    val androidxCompose = listOf(
        ANDROIDX_COMPOSE_MATERIAL,
        ANDROIDX_COMPOSE_UI,
        ANDROIDX_COMPOSE_UI_TOOLING_PREVIEW
    )

    //Test
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ANDROIDX_EXT_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_EXT_JUNIT}"
    const val ANDROIDX_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ANDROIDX_ESPRESSO}"
    const val ANDROIDX_COMPOSE_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.ANDROIDX_COMPOSE}"
    const val ANDROIDX_COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.ANDROIDX_COMPOSE}"

    val testLibraries = listOf(
        JUNIT
    )

    val androidTestLibraries = listOf(
        ANDROIDX_EXT_JUNIT,
        ANDROIDX_ESPRESSO_CORE
    )

    val androidxComposeTestLibraries = arrayListOf(
        ANDROIDX_COMPOSE_TEST,
        ANDROIDX_COMPOSE_TOOLING
    )
}

private const val kapt = "kapt"
private const val implementation = "implementation"
private const val androidTestImplementation = "androidTestImplementation"
private const val testImplementation = "testImplementation"

fun DependencyHandler.kapt(dependencies: List<String>) =
    addDependencies(kapt, dependencies)

fun DependencyHandler.kapt(dependency: String) =
    add(kapt, dependency)

fun DependencyHandler.implementation(dependencies: List<String>) =
    addDependencies(implementation, dependencies)

fun DependencyHandler.implementation(dependency: String) =
    add(implementation, dependency)

fun DependencyHandler.androidTestImplementation(dependencies: List<String>) =
    addDependencies(androidTestImplementation, dependencies)

fun DependencyHandler.androidTestImplementation(dependency: String) =
    add(androidTestImplementation, dependency)

fun DependencyHandler.testImplementation(dependencies: List<String>) =
    addDependencies(testImplementation, dependencies)

fun DependencyHandler.testImplementation(dependency: String) =
    add(testImplementation, dependency)

private fun DependencyHandler.addDependencies(configurationName: String, list: List<String>) =
    list.forEach { dependency -> add(configurationName, dependency) }