package d.b.h0.a.q1.b.b;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
/* loaded from: classes3.dex */
public class c extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public boolean f46281e;

    public c(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.f46281e = d.b.h0.a.q1.b.a.f46260b;
    }

    public void a(boolean z) {
        this.f46281e = d.b.h0.a.q1.b.a.f46260b && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f46281e) {
            d.b.h0.a.q1.b.a.i(this);
        }
        boolean e2 = d.b.h0.a.q1.b.a.e(this);
        if (e2) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (e2) {
            getWindow().clearFlags(8);
        }
    }
}
