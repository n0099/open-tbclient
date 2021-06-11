package d.a.n0.c1.a.d;

import android.annotation.TargetApi;
import android.view.View;
import d.a.n0.c1.a.b;
/* loaded from: classes4.dex */
public class a extends b.C1286b {
    public a(View view) {
        super(view);
    }

    @Override // d.a.n0.c1.a.b.C1286b, d.a.n0.c1.a.b.a
    @TargetApi(11)
    public boolean a() {
        return this.f56001a.isHardwareAccelerated();
    }

    @Override // d.a.n0.c1.a.b.C1286b, d.a.n0.c1.a.b.a
    @TargetApi(14)
    public void c(int i2) {
        this.f56001a.setScrollX(i2);
    }
}
