plugins {
    id("java-platform")
    id("maven-publish")
}

val androidMaterial = "1.4.0"

val androidxActivityCompose = "1.4.0"
val androidxAppCompat = "1.4.0"
val androidxCompose = Versions.ANDROIDX_COMPOSE
val androidxCore = "1.7.0"
val androidxLifecycle = "2.4.0"


val junit = "4.13"
val androidxJunitExt = "1.1.3"
val androidxEspresso = "3.4.0"

dependencies {
    constraints {
        api("${Libs.ANDROID_MATERIAL}:$androidMaterial")

        api("${Libs.ANDROIDX_ACTIVITY_COMPOSE}:$androidxActivityCompose")
        api("${Libs.ANDROIDX_APPCOMPAT}:$androidxAppCompat")
        api("${Libs.ANDROIDX_CORE_KTX}:$androidxCore")

        api("${Libs.ANDROIDX_COMPOSE_MATERIAL}:$androidxCompose")
        api("${Libs.ANDROIDX_COMPOSE_UI}:$androidxCompose")
        api("${Libs.ANDROIDX_COMPOSE_UI_TOOLING_PREVIEW}:$androidxCompose")

        api("${Libs.ANDROIDX_LIFECYCLE_RUNTIME_KTX}:$androidxLifecycle")


        api("${Libs.JUNIT}:$junit")
        api("${Libs.ANDROIDX_EXT_JUNIT}:$androidxJunitExt")
        api("${Libs.ANDROIDX_ESPRESSO_CORE}:$androidxEspresso")
        api("${Libs.ANDROIDX_COMPOSE_TEST}:$androidxCompose")
        api("${Libs.ANDROIDX_COMPOSE_TOOLING}:$androidxCompose")
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}