package org.arxing;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.spreada.utils.chinese.ZHConverter;

public class ToTraditionalAction extends AnAction {

    @Override public void actionPerformed(AnActionEvent e) {
        new Core().convert(e, true);
    }
}
