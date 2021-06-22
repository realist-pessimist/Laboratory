import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //Kotlin
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    private const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    // App dependencies
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    private const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    private const val annotation = "androidx.annotation:annotation:${Versions.androidXAnnotations}"
    private const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    private const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    private const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.androidXLegacySupport}"

    // Architecture Components
    private const val room = "androidx.room:room-runtime:${Versions.room}"
    private const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    private const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.archLifecycle}"
    private const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.archLifecycle}"
    private const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    private const val testCore = "androidx.test:core:${Versions.androidXTestCore}"
    private const val fragment = "androidx.fragment:fragment:${Versions.fragment}"

    //Compiler Components
    private const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // Dependencies for local unit tests
    private const val junit = "junit:junit:${Versions.junit}"
    private const val archTestCore = "androidx.arch.core:core-testing:${Versions.archTesting}"
    private const val junitKtx = "androidx.test.ext:junit-ktx:${Versions.androidXTestExtKotlinRunner}"
    private const val testKtxCore = "androidx.test:core-ktx:${Versions.androidXTestCore}"
    private const val testCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    private const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    // Other unit test dependencies
    private const val hamcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"

    // Core library
    private const val androidTestCore = "androidx.test:core:1.3.0"

    // AndroidJUnitRunner and JUnit Rules
    private const val androidTestRunner = "androidx.test:runner:1.3.0"
    private const val androidTestRules = "androidx.test:rules:1.3.0"

    // Assertions
    private const val androidJunit = "androidx.test.ext:junit:${Versions.androidXTestExtKotlinRunner}"
    private const val truthX = "androidx.test.ext:truth:${Versions.truth}"
    private const val truth = "com.google.truth:truth:1.0.1"

    // Espresso dependencies
    private const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // Debug dependencies
    private const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragment}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(fragment)
        add(fragmentKtx)
        add(testCore)
        add(appcompat)
        add(cardView)
        add(material)
        add(recyclerView)
        add(annotation)
        add(coroutines)
        add(timber)
        add(legacySupport)
        add(room)
        add(roomKtx)
        add(lifecycleViewModel)
        add(lifecycleLiveData)
        add(navigationFragment)
        add(navigationUI)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(archTestCore)
        add(junitKtx)
        add(testKtxCore)
        add(robolectric)
        add(hamcrest)
        add(testCoroutines)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(androidTestCore)
        add(androidTestRunner)
        add(androidTestRules)
        add(androidJunit)
        add(truthX)
        add(truth)
        add(espresso)
    }

    val compilerLibraries = arrayListOf<String>().apply{
        add(roomCompiler)
    }

    val debugLibraries = arrayListOf<String>().apply{
        add(fragmentTesting)
    }
}

//Util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation (list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}