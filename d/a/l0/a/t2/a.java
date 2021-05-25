package d.a.l0.a.t2;

import android.util.Log;
import d.a.l0.a.c1.b;
import d.a.l0.a.h2.e;
import d.a.l0.a.k;
import d.a.l0.a.v2.j;
import d.a.l0.a.v2.q;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44798a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static int f44799b = 0;

    /* renamed from: d.a.l0.a.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0830a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44800e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44801f;

        public RunnableC0830a(int i2, int i3) {
            this.f44800e = i2;
            this.f44801f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(this.f44800e, this.f44801f);
        }
    }

    public static void b(int i2, int i3) {
        d.a.l0.a.p0.e.a.d().e(i2, i3);
        j.f();
        if (i2 == 0) {
            f44799b = 2;
        } else if (i3 > i2) {
            f44799b = 1;
            b.m().i();
            e.a.a();
            d.a.l0.a.h0.s.a.d();
        }
        if (f44798a) {
            Log.d("SwanAppUpgradeManager", "App onUpgrade on thread: " + Thread.currentThread());
        }
    }

    public static int c() {
        return f44799b;
    }

    public static void d(int i2, int i3) {
        if (d.a.l0.a.c1.a.Z().l()) {
            q.j(new RunnableC0830a(i2, i3), "onUpgradeOperation");
        } else {
            b(i2, i3);
        }
    }
}
