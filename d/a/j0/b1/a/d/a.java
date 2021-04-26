package d.a.j0.b1.a.d;

import android.annotation.TargetApi;
import android.view.View;
import d.a.j0.b1.a.b;
/* loaded from: classes4.dex */
public class a extends b.C1141b {
    public a(View view) {
        super(view);
    }

    @Override // d.a.j0.b1.a.b.C1141b, d.a.j0.b1.a.b.a
    @TargetApi(11)
    public boolean a() {
        return this.f51455a.isHardwareAccelerated();
    }

    @Override // d.a.j0.b1.a.b.C1141b, d.a.j0.b1.a.b.a
    @TargetApi(14)
    public void c(int i2) {
        this.f51455a.setScrollX(i2);
    }
}
