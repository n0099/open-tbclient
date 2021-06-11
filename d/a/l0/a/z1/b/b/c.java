package d.a.l0.a.z1.b.b;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
/* loaded from: classes3.dex */
public class c extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public boolean f49736e;

    public c(@NonNull Context context, @StyleRes int i2) {
        super(context, i2);
        this.f49736e = d.a.l0.a.z1.b.a.f49714b;
    }

    public void a(boolean z) {
        this.f49736e = d.a.l0.a.z1.b.a.f49714b && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f49736e) {
            d.a.l0.a.z1.b.a.i(this);
        }
        boolean e2 = d.a.l0.a.z1.b.a.e(this);
        if (e2) {
            getWindow().setFlags(8, 8);
        }
        super.show();
        if (e2) {
            getWindow().clearFlags(8);
        }
    }
}
