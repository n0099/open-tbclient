package tv.chushou.zues.widget.edittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
/* loaded from: classes4.dex */
public class PastedEditText extends AppCompatEditText {
    private a nWM;
    private b nWN;

    /* loaded from: classes4.dex */
    public interface a {
        void dPm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean dPn();
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
        if (i == 16908322 && this.nWM != null) {
            this.nWM.dPm();
        }
        return onTextContextMenuItem;
    }

    public void setListener(a aVar) {
        this.nWM = aVar;
    }

    public void setResizeListener(b bVar) {
        this.nWN = bVar;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.nWN != null && this.nWN.dPn()) {
            return true;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
