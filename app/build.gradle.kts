plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.compileSdk

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

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.ANDROIDX_COMPOSE
    }

    packagingOptions {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

dependencies {
    /*api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))
    androidTestApi(platform(project(":depconstraints")))*/

    implementation(project(":ui:common"))

    implementation(Libs.ANDROID_MATERIAL)

    implementation(Libs.ANDROIDX_ACTIVITY_COMPOSE)
    implementation(Libs.ANDROIDX_APPCOMPAT)
    implementation(Libs.ANDROIDX_COMPOSE_UI)
    implementation(Libs.ANDROIDX_COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Libs.ANDROIDX_COMPOSE_MATERIAL)
    implementation(Libs.ANDROIDX_CORE_KTX)
    implementation(Libs.ANDROIDX_LIFECYCLE_RUNTIME_KTX)

    //Local Unit Test
    testImplementation(Libs.JUNIT)

    //// Instrumentation tests
    androidTestImplementation(Libs.ANDROIDX_EXT_JUNIT)
    androidTestImplementation(Libs.ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(Libs.ANDROIDX_COMPOSE_TEST)
    debugImplementation(Libs.ANDROIDX_COMPOSE_TOOLING)
}