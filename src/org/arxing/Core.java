package org.arxing;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.spreada.utils.chinese.ZHConverter;

class Core {

    void convert(AnActionEvent e, boolean toTraditional) {
        Project project = e.getProject();
        VirtualFile virtualFile = e.getData(DataKeys.VIRTUAL_FILE);
        project.save();
        Editor editor = e.getData(DataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();
        final String newText = ZHConverter.convert(selectedText, toTraditional ? ZHConverter.TRADITIONAL : ZHConverter.SIMPLIFIED);
        Document document = editor.getDocument();
        new Thread(() -> document.replaceString(selectionModel.getSelectionStart(), selectionModel.getSelectionEnd(), newText)).start();
        virtualFile.refresh(false, false);
    }
}
