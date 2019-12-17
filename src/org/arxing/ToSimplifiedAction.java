package org.arxing;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class ToSimplifiedAction extends AnAction {

    @Override public void actionPerformed(AnActionEvent e) {
        new Core().convert(e, false);
    }
}
