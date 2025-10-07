pluginManagement {
    repositories {
        // ต้องมี google() ตรงนี้เพื่อหา Android Gradle Plugin
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "KPlay"
include(":app")
