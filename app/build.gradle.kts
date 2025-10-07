plugins { id("com.android.application"); id("org.jetbrains.kotlin.android") }
android {
    namespace = "com.weera.kplay"
    compileSdk = 35
    defaultConfig { applicationId = "com.weera.kplay"; minSdk = 24; targetSdk = 35; versionCode = 2; versionName = "1.1.0" }
    signingConfigs {
        create("release") {
            val ksPath = System.getenv("KEYSTORE_PATH") ?: ""
            val ksPass = System.getenv("KEYSTORE_PASSWORD") ?: ""
            val alias = System.getenv("KEY_ALIAS") ?: ""
            val keyPass = System.getenv("KEY_PASSWORD") ?: ""
            if (ksPath.isNotEmpty()) { storeFile = file(ksPath); storePassword = ksPass; keyAlias = alias; keyPassword = keyPass }
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
        debug { isMinifyEnabled = false }
    }
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.5.14" }
    packaging { resources.excludes += setOf("META-INF/DEPENDENCIES", "META-INF/LICENSE*", "META-INF/NOTICE*") }
}
dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2025.01.00")
    implementation(composeBom); androidTestImplementation(composeBom)
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.material3:material3:1.3.0")
    implementation("androidx.navigation:navigation-compose:2.8.3")
    val media3 = "1.4.1"
    implementation("androidx.media3:media3-exoplayer:$media3")
    implementation("androidx.media3:media3-ui:$media3")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
}
