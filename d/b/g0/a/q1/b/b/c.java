package d.b.g0.a.q1.b.b;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
/* loaded from: classes3.dex */
public class c extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public boolean f45952e;

    public c(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.f45952e = d.b.g0.a.q1.b.a.f45931b;
    }

    public void a(boolean z) {
        this.f45952e = d.b.g0.a.q1.b.a.f45931b && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f45952e) {
            d.b.g0.a.q1.b.a.i(this);
        }
        boolean e2 = d.b.g0.a.q1.b.a.e(this);
        if (e2) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (e2) {
            getWindow().clearFlags(8);
        }
    }
}
