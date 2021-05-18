package d.a.i0.a.n0.h;

import android.app.Activity;
import android.util.Log;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
/* loaded from: classes2.dex */
public abstract class a implements d.a.i0.a.g1.k.a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43422a = k.f43025a;

    @Override // d.a.i0.a.g1.k.a
    public void a(boolean z, Activity activity) {
        if (c.a() && !z) {
            long currentTimeMillis = f43422a ? System.currentTimeMillis() : 0L;
            boolean C = n0.C();
            if (f43422a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("DiskCleanerLifecycleObserver", "detect all process is on baground cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            if (C) {
                boolean n = e.n();
                d.a.i0.a.e0.d.h("DiskCleanerLifecycleObserver", "all app process in background，run clean task");
                d.a.i0.a.n0.f.c().d().u(null, n, 16);
                e.p(false);
            }
        }
    }
}
