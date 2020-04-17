package tv.chushou.zues.widget.edittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
/* loaded from: classes5.dex */
public class PastedEditText extends AppCompatEditText {
    private a ntA;
    private b ntB;

    /* loaded from: classes5.dex */
    public interface a {
        void dKg();
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean dKh();
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
        if (i == 16908322 && this.ntA != null) {
            this.ntA.dKg();
        }
        return onTextContextMenuItem;
    }

    public void setListener(a aVar) {
        this.ntA = aVar;
    }

    public void setResizeListener(b bVar) {
        this.ntB = bVar;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.ntB != null && this.ntB.dKh()) {
            return true;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
