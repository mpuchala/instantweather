plugins {
    id("java-library")
    kotlin("jvm")
}

dependencies {
    //implementation(Libs.ANDROIDX_CORE_KTX)
    implementation(Libs.KOTLIN_STDLIB)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}