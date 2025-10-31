plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.mycomposeapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mycomposeapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}

// Hanya ada satu blok dependencies
dependencies {
    // Dependensi inti Android dan KTX dari version catalog
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Gunakan BOM (Bill of Materials) untuk mengatur versi Jetpack Compose.
    // Anda hanya perlu salah satu, dari version catalog (libs) atau manual.
    // Kita gunakan yang dari version catalog.
    implementation(platform(libs.androidx.compose.bom))

    // Setelah menggunakan BOM, Anda tidak perlu menentukan versi untuk pustaka Compose lainnya.
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Dependensi untuk testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom)) // BOM juga untuk testing
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    // Dependensi untuk debug
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // CATATAN: Baris-baris di bawah ini redundan karena sudah diatur oleh BOM dan version catalog.
    // Sebaiknya dihapus untuk menjaga kebersihan kode.
    // implementation(platform("androidx.compose:compose-bom:2024.10.00"))
    // implementation("androidx.compose.ui:ui")
    // implementation("androidx.compose.material3:material3")
    // implementation("androidx.compose.ui:ui-tooling-preview")
    // debugImplementation("androidx.compose.ui:ui-tooling")
    // implementation("androidx.activity:activity-compose:1.9.0")
}
