package d.b.j0.b1.a.d;

import android.annotation.TargetApi;
import android.view.View;
import d.b.j0.b1.a.b;
/* loaded from: classes4.dex */
public class a extends b.C1202b {
    public a(View view) {
        super(view);
    }

    @Override // d.b.j0.b1.a.b.C1202b, d.b.j0.b1.a.b.a
    @TargetApi(11)
    public boolean a() {
        return this.f53709a.isHardwareAccelerated();
    }

    @Override // d.b.j0.b1.a.b.C1202b, d.b.j0.b1.a.b.a
    @TargetApi(14)
    public void c(int i) {
        this.f53709a.setScrollX(i);
    }
}
