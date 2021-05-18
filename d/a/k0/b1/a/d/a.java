package d.a.k0.b1.a.d;

import android.annotation.TargetApi;
import android.view.View;
import d.a.k0.b1.a.b;
/* loaded from: classes4.dex */
public class a extends b.C1213b {
    public a(View view) {
        super(view);
    }

    @Override // d.a.k0.b1.a.b.C1213b, d.a.k0.b1.a.b.a
    @TargetApi(11)
    public boolean a() {
        return this.f52154a.isHardwareAccelerated();
    }

    @Override // d.a.k0.b1.a.b.C1213b, d.a.k0.b1.a.b.a
    @TargetApi(14)
    public void c(int i2) {
        this.f52154a.setScrollX(i2);
    }
}
