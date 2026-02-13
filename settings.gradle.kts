import dev.scaffoldit.hytale.wire.HytaleManifest

rootProject.name = "Hytale-Template"

plugins {
  id("dev.scaffoldit") version "0.2.+"
}

hytale {
  usePatchline("release")
  useVersion("latest")

  repositories {
  }

  dependencies {
  }

  manifest {
    Version = "1.0.0"

    Group = "MrEmPee"
    Main = "me.empee.template.TemplatePlugin"

    Name = "TemplatePlugin"
    Description = "A really beautiful template system"
    Website = "https://github.com/Mr-EmPee/Hytale-Template"

    IncludesAssetPack = false

    Authors = listOf(
      HytaleManifest.Author("Mr. EmPee", "empee@null.com", "https://github.com/Mr-EmPee")
    )
  }
}