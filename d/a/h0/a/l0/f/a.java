package d.a.h0.a.l0.f;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43139a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f43140b;

    /* renamed from: d.a.h0.a.l0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0692a implements d.a.h0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f43141e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43142f;

        /* renamed from: d.a.h0.a.l0.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0693a implements d.a.h0.a.i2.u0.b<Exception> {
            public C0693a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.a.h0.a.c0.c.i("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                d.a.h0.a.i2.u0.b bVar = C0692a.this.f43141e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public C0692a(a aVar, d.a.h0.a.i2.u0.b bVar, int i2) {
            this.f43141e = bVar;
            this.f43142f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc == null) {
                d.a.h0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                d.a.h0.a.i2.u0.b bVar = this.f43141e;
                if (bVar != null) {
                    bVar.onCallback(null);
                    return;
                }
                return;
            }
            d.a.h0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
            d.a.h0.a.b2.b.m(this.f43142f, new C0693a());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f43144e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43145f;

        /* renamed from: d.a.h0.a.l0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0694a implements d.a.h0.a.i2.u0.b<Exception> {
            public C0694a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.a.h0.a.i2.u0.b bVar = b.this.f43144e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public b(a aVar, d.a.h0.a.i2.u0.b bVar, int i2) {
            this.f43144e = bVar;
            this.f43145f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc != null) {
                d.a.h0.a.i2.u0.b bVar = this.f43144e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                    return;
                }
                return;
            }
            d.a.h0.a.l0.b.f(this.f43145f, new C0694a());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    public static a d() {
        if (f43140b == null) {
            synchronized (a.class) {
                if (f43140b == null) {
                    f43140b = new a();
                }
            }
        }
        return f43140b;
    }

    public final void b() {
        d.a.h0.a.b2.e.b.b().e(null, 0);
        d.a.h0.a.b2.e.b.b().e(null, 1);
        d.a.h0.a.l0.b.f(0, null);
        d.a.h0.a.l0.b.f(1, null);
    }

    public void c(@Nullable d.a.h0.a.i2.u0.b<Exception> bVar, int i2) {
        d.a.h0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i2);
        g(new C0692a(this, bVar, i2), i2);
    }

    public void e(int i2, int i3) {
        if (f43139a) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
        }
        d.a.h0.a.b2.b.k(i2, i3);
        d.a.h0.a.l0.b.e(i2, i3);
    }

    public void f() {
        ExecutorUtilsExt.postOnElastic(new c(), "tryUpdateAllPresetCoresAsync", 2);
    }

    public final void g(@Nullable d.a.h0.a.i2.u0.b<Exception> bVar, int i2) {
        d.a.h0.a.b2.e.b.b().e(new b(this, bVar, i2), i2);
    }
}
