package com.gs.emm

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiParameter
import com.intellij.psi.util.PsiTreeUtil

/**
 * author: gayan
 * created: 2023-09-06
 **/
class CodeAnalyzer (private val editor: Editor) {
    fun analyzeCode(): List<MethodInfo>{
        val file = editor.document.let { editor.project?.let { it1 -> PsiDocumentManager.getInstance(it1).getPsiFile(it) } }

        val methodInfo = mutableListOf<MethodInfo>();

        if ( file != null )
        {
            val methods = PsiTreeUtil.findChildrenOfType( file, PsiMethod::class.java )

            for ( method in methods )
            {
                val methodName = method.name ?: continue

                val parameters = method.parameterList.parameters.mapNotNull { fetchParameterInfo( it ) }

                methodInfo.add( MethodInfo( methodName, parameters ) )
            }
        }

        return methodInfo;
    }

    private fun fetchParameterInfo(parameter: PsiParameter): ParameterInfo{
        return ParameterInfo( parameter.name ?: "", parameter.typeElement?.text ?: "" )
    }
}