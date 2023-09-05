package com.gs.emm

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

/**
 * author: gayan
 * created: 2023-09-05
 **/
class EMMToolWindow : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val panel = ToolWindowPanel(project)
        val content = ContentFactory.getInstance().createContent( panel, null, false )
        toolWindow.contentManager.addContent( content )
    }
}