import dev.scaffoldit.hytale.wire.HytaleManifest

rootProject.name = "Hytale-Template"

plugins {
  id("dev.scaffoldit") version "0.2.+"
}

common {
  dependencies {
    compileOnly("com.hypixel.hytale:Server:+")
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

  val pluginMainClass = providers.gradleProperty("plugin.mainClass").get()

  manifest {
    Version = providers.gradleProperty("version").get()

    Group = "MrEmPee"
    Main = pluginMainClass

    Name = "TemplatePlugin"
    Description = "A really beautiful template system"
    Website = "https://github.com/Mr-EmPee/Hytale-Template"

    IncludesAssetPack = false

    Authors = listOf(
      HytaleManifest.Author("Mr. EmPee", "empee@null.com", "https://github.com/Mr-EmPee")
    )
  }
}
