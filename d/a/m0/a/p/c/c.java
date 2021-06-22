package d.a.m0.a.p.c;

import android.content.Context;
/* loaded from: classes2.dex */
public class c implements d.a.m0.a.p.d.f {
    @Override // d.a.m0.a.p.d.f
    public void a(Context context, int i2) {
        d.a.m0.a.k2.g.h.a().putInt("fontSizeLevel", i2);
    }

    @Override // d.a.m0.a.p.d.f
    public int b(Context context) {
        return d.a.m0.a.k2.g.h.a().getInt("fontSizeLevel", 1);
    }
}
