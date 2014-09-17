package com.genymotion

import main.groovy.com.genymotion.GenymotionAdmin
import main.groovy.com.genymotion.GenymotionConfig
import main.groovy.com.genymotion.GenymotionDevices
import org.gradle.api.Project
import org.gradle.api.Plugin


class GenymotionGradlePlugin implements Plugin<Project> {

    void apply(Project project) {

        println "adding Genymotion plugin"
        project.extensions.create('genymotion', GenymotionPluginExtension, project);
        project.genymotion.extensions.create('config', GenymotionConfig); //the extension name have to be different from the original nested element's name (receiver)
        project.genymotion.extensions.create('admin', GenymotionAdmin); //the extension name have to be different from the original nested element's name (receiver)
        project.genymotion.extensions.create('devices', GenymotionDevices); //the extension name have to be different from the original nested element's name (receiver)

        project.task('genymotion', type: GenymotionTask)
        project.task('cmd', type: CmdTask)

        if(project.plugins.hasPlugin('android')){

            println "Android plugin detected"

            project.tasks.whenTaskAdded { theTask ->
                if("connectedAndroidTest".toString().equals(theTask.name.toString())){
                    println "Adding genymotion dependency"
                    theTask.dependsOn("genymotion")
                }
            }
        }

    }
}