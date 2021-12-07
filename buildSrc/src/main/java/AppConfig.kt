object AppConfig {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    const val versionCode = 10000
    const val versionName = "1.0.0"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
}

object LibraryConfig {
    const val compileSdk = AppConfig.compileSdk
    const val minSdk = AppConfig.minSdk
    const val targetSdk = AppConfig.targetSdk
    const val versionCode = 10000
    const val versionName = "1.0.0"

    const val proguardConsumerRules =  "consumer-rules.pro"
}