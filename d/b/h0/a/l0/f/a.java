package d.b.h0.a.l0.f;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45810a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f45811b;

    /* renamed from: d.b.h0.a.l0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0753a implements d.b.h0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f45812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45813f;

        /* renamed from: d.b.h0.a.l0.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0754a implements d.b.h0.a.i2.u0.b<Exception> {
            public C0754a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.b.h0.a.c0.c.i("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                d.b.h0.a.i2.u0.b bVar = C0753a.this.f45812e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public C0753a(a aVar, d.b.h0.a.i2.u0.b bVar, int i) {
            this.f45812e = bVar;
            this.f45813f = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc == null) {
                d.b.h0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                d.b.h0.a.i2.u0.b bVar = this.f45812e;
                if (bVar != null) {
                    bVar.onCallback(null);
                    return;
                }
                return;
            }
            d.b.h0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
            d.b.h0.a.b2.b.m(this.f45813f, new C0754a());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f45815e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45816f;

        /* renamed from: d.b.h0.a.l0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0755a implements d.b.h0.a.i2.u0.b<Exception> {
            public C0755a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.b.h0.a.i2.u0.b bVar = b.this.f45815e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public b(a aVar, d.b.h0.a.i2.u0.b bVar, int i) {
            this.f45815e = bVar;
            this.f45816f = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc != null) {
                d.b.h0.a.i2.u0.b bVar = this.f45815e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                    return;
                }
                return;
            }
            d.b.h0.a.l0.b.f(this.f45816f, new C0755a());
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
        if (f45811b == null) {
            synchronized (a.class) {
                if (f45811b == null) {
                    f45811b = new a();
                }
            }
        }
        return f45811b;
    }

    public final void b() {
        d.b.h0.a.b2.e.b.b().e(null, 0);
        d.b.h0.a.b2.e.b.b().e(null, 1);
        d.b.h0.a.l0.b.f(0, null);
        d.b.h0.a.l0.b.f(1, null);
    }

    public void c(@Nullable d.b.h0.a.i2.u0.b<Exception> bVar, int i) {
        d.b.h0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i);
        g(new C0753a(this, bVar, i), i);
    }

    public void e(int i, int i2) {
        if (f45810a) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        d.b.h0.a.b2.b.k(i, i2);
        d.b.h0.a.l0.b.e(i, i2);
    }

    public void f() {
        ExecutorUtilsExt.postOnElastic(new c(), "tryUpdateAllPresetCoresAsync", 2);
    }

    public final void g(@Nullable d.b.h0.a.i2.u0.b<Exception> bVar, int i) {
        d.b.h0.a.b2.e.b.b().e(new b(this, bVar, i), i);
    }
}
