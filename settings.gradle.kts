import dev.scaffoldit.hytale.wire.HytaleManifest

rootProject.name = "Hytale-Template"

plugins {
  id("dev.scaffoldit") version "0.2.14"
}

val serverVersion = providers.gradleProperty("server.version").get()
val pluginMainClass = providers.gradleProperty("plugin.mainClass").get()
val pluginVersion = providers.gradleProperty("plugin.version").get()

common {
  dependencies {
    compileOnly("com.hypixel.hytale:Server:${serverVersion}")
  }

  repositories {
    maven("https://maven.hytale.com/release")
  }

  include("multiplehud", "models")
}

hytale {
  include("core")

  usePatchline("release")
  useVersion("latest")

  manifest {
    Main = pluginMainClass
    Version = pluginVersion

    Name = rootProject.name
    ServerVersion = serverVersion

    Group = "MrEmPee"

    Description = "A really beautiful template system"
    Website = "https://github.com/Mr-EmPee/Hytale-Template"

    IncludesAssetPack = false

    Authors = listOf(
      HytaleManifest.Author("Mr. EmPee", "empee@null.com", "https://github.com/Mr-EmPee")
    )
  }
}
