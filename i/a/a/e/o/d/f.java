package i.a.a.e.o.d;

import android.app.Dialog;
import android.content.Context;
import i.a.a.e.n.h;
/* loaded from: classes8.dex */
public class f extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public Context f72343e;

    public f(Context context, int i2) {
        super(context, i2);
        this.f72343e = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (h.f72272a.a(this.f72343e)) {
            super.dismiss();
        }
    }
}
