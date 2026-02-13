plugins {
  alias(libs.plugins.lombok)
  alias(libs.plugins.shadow)
}

repositories {
}

dependencies {
  shadow(libs.avajeinject)

  implementation(libs.avajeinject)
  annotationProcessor(libs.avajeinject.processor)
}

tasks.shadowJar {
  configurations = listOf(project.configurations.shadow.get())

  enableAutoRelocation = true
  relocationPrefix = "me/empee/template/dependencies"

  mergeServiceFiles()

  duplicatesStrategy = DuplicatesStrategy.WARN
}