package d.b.g0.a.p.c;

import android.content.res.Resources;
/* loaded from: classes2.dex */
public abstract class a {
    public boolean a() {
        return d.b.g0.a.a2.g.h.a().getBoolean("PREFS_NIGHT_MODE", false);
    }

    public Resources b() {
        return null;
    }

    public abstract void c(boolean z);

    public void d(boolean z) {
    }

    public void e(boolean z) {
        d.b.g0.a.a2.g.h.a().putBoolean("PREFS_NIGHT_MODE", z);
    }

    public void f(Object obj, d.b.g0.a.x1.a aVar) {
    }

    public void g(Object obj) {
    }
}
