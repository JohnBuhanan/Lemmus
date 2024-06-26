/*
 * © 2023 Match Group, LLC.
 */

import com.lemmus.extension.allProjects
import com.lemmus.extension.anvil
import com.lemmus.extension.applyOnce
import com.lemmus.extension.kotlinJvm
import com.lemmus.extension.kotlinLibrary
import com.lemmus.extension.libs
import com.lemmus.extension.moshi
import com.lemmus.extension.retrofit
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LemmusKotlinLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyOnce("kotlin")

            kotlinLibrary()
            kotlinJvm()
            allProjects()

            // detekt()
            circuitRuntime()

            extensions.create("lemmus", LemmusKotlinLibraryExtension::class.java, this)
        }
    }

    private fun Project.circuitRuntime() {
        dependencies {
            "implementation"(libs.circuitRuntime)
        }
    }
}

open class LemmusKotlinLibraryExtension(private val project: Project) {
    fun anvil() = project.anvil()

    fun moshi() = project.moshi()

    fun retrofit() = project.retrofit()
}
