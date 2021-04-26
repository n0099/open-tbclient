package d.a.h0.a.q1.b.b;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
/* loaded from: classes3.dex */
public class c extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public boolean f43631e;

    public c(@NonNull Context context, @StyleRes int i2) {
        super(context, i2);
        this.f43631e = d.a.h0.a.q1.b.a.f43609b;
    }

    public void a(boolean z) {
        this.f43631e = d.a.h0.a.q1.b.a.f43609b && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f43631e) {
            d.a.h0.a.q1.b.a.i(this);
        }
        boolean e2 = d.a.h0.a.q1.b.a.e(this);
        if (e2) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (e2) {
            getWindow().clearFlags(8);
        }
    }
}
