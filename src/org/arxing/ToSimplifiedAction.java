package org.arxing;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;

public class ToSimplifiedAction extends AnAction {

    @Override public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getData(DataKeys.EDITOR);
        new Core().run(project, editor, false);
    }
}
