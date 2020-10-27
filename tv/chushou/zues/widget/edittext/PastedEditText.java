package tv.chushou.zues.widget.edittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
/* loaded from: classes6.dex */
public class PastedEditText extends AppCompatEditText {
    private a qeC;
    private b qeD;

    /* loaded from: classes6.dex */
    public interface a {
        void eEl();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean eEm();
    }

    public PastedEditText(Context context) {
        super(context);
    }

    public PastedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322 && this.qeC != null) {
            this.qeC.eEl();
        }
        return onTextContextMenuItem;
    }

    public void setListener(a aVar) {
        this.qeC = aVar;
    }

    public void setResizeListener(b bVar) {
        this.qeD = bVar;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.qeD != null && this.qeD.eEm()) {
            return true;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
