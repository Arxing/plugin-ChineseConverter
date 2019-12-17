package org.arxing;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.spreada.utils.chinese.ZHConverter;

class Core {

    void run(Project project, Editor editor, boolean toTraditional) {
        if (project == null)
            return;
        if (editor == null)
            return;
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();
        final String newText = ZHConverter.convert(selectedText, toTraditional ? ZHConverter.TRADITIONAL : ZHConverter.SIMPLIFIED);
        WriteCommandAction.runWriteCommandAction(project, () -> {
            int start = selectionModel.getSelectionStart();
            int end = selectionModel.getSelectionEnd();
            editor.getDocument().replaceString(start, end, newText);
        });
    }
}
