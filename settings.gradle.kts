dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Instant Weather"

include(
    ":app",
    ":data",
    ":model"
)

include(
    ":ui:common"
)

include(
    ":features:search",
    ":features:details-day"
)
