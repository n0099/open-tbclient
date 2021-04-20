package d.b.i0.b1.a.d;

import android.annotation.TargetApi;
import android.view.View;
import d.b.i0.b1.a.b;
/* loaded from: classes4.dex */
public class a extends b.C1179b {
    public a(View view) {
        super(view);
    }

    @Override // d.b.i0.b1.a.b.C1179b, d.b.i0.b1.a.b.a
    @TargetApi(11)
    public boolean a() {
        return this.f53288a.isHardwareAccelerated();
    }

    @Override // d.b.i0.b1.a.b.C1179b, d.b.i0.b1.a.b.a
    @TargetApi(14)
    public void c(int i) {
        this.f53288a.setScrollX(i);
    }
}
