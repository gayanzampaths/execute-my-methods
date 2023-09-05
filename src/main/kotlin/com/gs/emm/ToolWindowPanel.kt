package com.gs.emm

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import java.awt.BorderLayout
import javax.swing.JLabel
import javax.swing.JPanel

/**
 * author: gayan
 * created: 2023-09-05
 **/
class ToolWindowPanel(project: Project) : JPanel() {
    init {
        layout = BorderLayout()
        add(JLabel("Test Label"), BorderLayout.WEST)

        val methodInfo = fetchMethodInfo(project)

        println(methodInfo)
    }

    private fun fetchMethodInfo(project: Project): List<MethodInfo>
    {
        val editor = FileEditorManager.getInstance(project).selectedTextEditor
        if ( editor != null )
        {
            return CodeAnalyzer(editor).analyzeCode()
        }
        else
        {
            return emptyList()
        }
    }
}