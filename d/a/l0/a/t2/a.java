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
    public static final boolean f48472a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static int f48473b = 0;

    /* renamed from: d.a.l0.a.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0886a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48475f;

        public RunnableC0886a(int i2, int i3) {
            this.f48474e = i2;
            this.f48475f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(this.f48474e, this.f48475f);
        }
    }

    public static void b(int i2, int i3) {
        d.a.l0.a.p0.e.a.d().e(i2, i3);
        j.f();
        if (i2 == 0) {
            f48473b = 2;
        } else if (i3 > i2) {
            f48473b = 1;
            b.m().i();
            e.a.a();
            d.a.l0.a.h0.s.a.d();
        }
        if (f48472a) {
            Log.d("SwanAppUpgradeManager", "App onUpgrade on thread: " + Thread.currentThread());
        }
    }

    public static int c() {
        return f48473b;
    }

    public static void d(int i2, int i3) {
        if (d.a.l0.a.c1.a.Z().l()) {
            q.j(new RunnableC0886a(i2, i3), "onUpgradeOperation");
        } else {
            b(i2, i3);
        }
    }
}
