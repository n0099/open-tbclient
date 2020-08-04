package tv.chushou.zues.widget.edittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
/* loaded from: classes6.dex */
public class PastedEditText extends AppCompatEditText {
    private a oui;
    private b ouj;

    /* loaded from: classes6.dex */
    public interface a {
        void eas();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean eat();
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
        if (i == 16908322 && this.oui != null) {
            this.oui.eas();
        }
        return onTextContextMenuItem;
    }

    public void setListener(a aVar) {
        this.oui = aVar;
    }

    public void setResizeListener(b bVar) {
        this.ouj = bVar;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.ouj != null && this.ouj.eat()) {
            return true;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }
}
