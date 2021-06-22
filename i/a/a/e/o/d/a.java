package i.a.a.e.o.d;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import i.a.a.e.n.h;
/* loaded from: classes8.dex */
public class a extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public Context f72298e;

    public a(Context context, int i2) {
        super(context, i2);
        this.f72298e = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        View currentFocus = getCurrentFocus();
        if (currentFocus instanceof EditText) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        if (h.f72272a.a(this.f72298e)) {
            super.dismiss();
        }
    }
}
