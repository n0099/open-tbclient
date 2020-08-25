package tv.chushou.zues.widget.edittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
/* loaded from: classes6.dex */
public class PastedEditText extends AppCompatEditText {
    private a oOa;
    private b oOb;

    /* loaded from: classes6.dex */
    public interface a {
        void emv();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean emw();
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
        if (i == 16908322 && this.oOa != null) {
            this.oOa.emv();
        }
        return onTextContextMenuItem;
    }

    public void setListener(a aVar) {
        this.oOa = aVar;
    }

    public void setResizeListener(b bVar) {
        this.oOb = bVar;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.oOb != null && this.oOb.emw()) {
            return true;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
