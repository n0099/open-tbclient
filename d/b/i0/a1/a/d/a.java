package d.b.i0.a1.a.d;

import android.annotation.TargetApi;
import android.view.View;
import d.b.i0.a1.a.b;
/* loaded from: classes3.dex */
public class a extends b.C1120b {
    public a(View view) {
        super(view);
    }

    @Override // d.b.i0.a1.a.b.C1120b, d.b.i0.a1.a.b.a
    @TargetApi(11)
    public boolean a() {
        return this.f51868a.isHardwareAccelerated();
    }

    @Override // d.b.i0.a1.a.b.C1120b, d.b.i0.a1.a.b.a
    @TargetApi(14)
    public void c(int i) {
        this.f51868a.setScrollX(i);
    }
}
