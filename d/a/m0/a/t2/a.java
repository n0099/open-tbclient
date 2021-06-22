package d.a.m0.a.t2;

import android.util.Log;
import d.a.m0.a.c1.b;
import d.a.m0.a.h2.e;
import d.a.m0.a.k;
import d.a.m0.a.v2.j;
import d.a.m0.a.v2.q;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48580a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static int f48581b = 0;

    /* renamed from: d.a.m0.a.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0889a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48582e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48583f;

        public RunnableC0889a(int i2, int i3) {
            this.f48582e = i2;
            this.f48583f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(this.f48582e, this.f48583f);
        }
    }

    public static void b(int i2, int i3) {
        d.a.m0.a.p0.e.a.d().e(i2, i3);
        j.f();
        if (i2 == 0) {
            f48581b = 2;
        } else if (i3 > i2) {
            f48581b = 1;
            b.m().i();
            e.a.a();
            d.a.m0.a.h0.s.a.d();
        }
        if (f48580a) {
            Log.d("SwanAppUpgradeManager", "App onUpgrade on thread: " + Thread.currentThread());
        }
    }

    public static int c() {
        return f48581b;
    }

    public static void d(int i2, int i3) {
        if (d.a.m0.a.c1.a.Z().l()) {
            q.j(new RunnableC0889a(i2, i3), "onUpgradeOperation");
        } else {
            b(i2, i3);
        }
    }
}
