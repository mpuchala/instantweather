plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
   //id("dagger.hilt.android.plugin")
}


android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        consumerProguardFiles(AppConfig.proguardConsumerRules)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //Local Unit Test
    testImplementation(Libs.JUNIT)

    //// Instrumentation tests
    androidTestImplementation(Libs.ANDROIDX_EXT_JUNIT)
    androidTestImplementation(Libs.ANDROIDX_ESPRESSO_CORE)
}