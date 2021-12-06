object Versions {
    const val GRADLE = "7.0.3"
    const val KOTLIN = "1.5.21"

    const val ANDROD_MATERIAL = "1.4.0"

    const val ANDROIDX_ACTIVITY_COMPOSE = "1.4.0"
    const val ANDROIDX_APPCOMPAT = "1.4.0"
    const val ANDROIDX_COMPOSE = "1.0.1"
    const val ANDROIDX_CORE = "1.7.0"
    const val ANDROIDX_LIFECYCLE = "2.4.0"

    const val JUNIT = "4.13"
    const val ANDROIDX_EXT_JUNIT = "1.1.3"
    const val ANDROIDX_ESPRESSO = "3.4.0"
}

object Libs {
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.ANDROD_MATERIAL}"

    const val ANDROIDX_ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY_COMPOSE}"
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:${Versions.ANDROIDX_APPCOMPAT}"
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE}"

    const val ANDROIDX_COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.ANDROIDX_COMPOSE}"
    const val ANDROIDX_COMPOSE_UI = "androidx.compose.ui:ui:${Versions.ANDROIDX_COMPOSE}"
    const val ANDROIDX_COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.ANDROIDX_COMPOSE}"

    const val ANDROIDX_LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ANDROIDX_LIFECYCLE}"

    //Test
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ANDROIDX_EXT_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_EXT_JUNIT}"
    const val ANDROIDX_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ANDROIDX_ESPRESSO}"
    const val ANDROIDX_COMPOSE_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.ANDROIDX_COMPOSE}"
    const val ANDROIDX_COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.ANDROIDX_COMPOSE}"
}