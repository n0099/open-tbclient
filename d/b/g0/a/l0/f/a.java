package d.b.g0.a.l0.f;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45088a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f45089b;

    /* renamed from: d.b.g0.a.l0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0720a implements d.b.g0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f45090e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45091f;

        /* renamed from: d.b.g0.a.l0.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0721a implements d.b.g0.a.i2.u0.b<Exception> {
            public C0721a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.b.g0.a.c0.c.i("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                d.b.g0.a.i2.u0.b bVar = C0720a.this.f45090e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public C0720a(a aVar, d.b.g0.a.i2.u0.b bVar, int i) {
            this.f45090e = bVar;
            this.f45091f = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc == null) {
                d.b.g0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                d.b.g0.a.i2.u0.b bVar = this.f45090e;
                if (bVar != null) {
                    bVar.onCallback(null);
                    return;
                }
                return;
            }
            d.b.g0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
            d.b.g0.a.b2.b.m(this.f45091f, new C0721a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f45093e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45094f;

        /* renamed from: d.b.g0.a.l0.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0722a implements d.b.g0.a.i2.u0.b<Exception> {
            public C0722a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.b.g0.a.i2.u0.b bVar = b.this.f45093e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public b(a aVar, d.b.g0.a.i2.u0.b bVar, int i) {
            this.f45093e = bVar;
            this.f45094f = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc != null) {
                d.b.g0.a.i2.u0.b bVar = this.f45093e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                    return;
                }
                return;
            }
            d.b.g0.a.l0.b.f(this.f45094f, new C0722a());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    public static a d() {
        if (f45089b == null) {
            synchronized (a.class) {
                if (f45089b == null) {
                    f45089b = new a();
                }
            }
        }
        return f45089b;
    }

    public final void b() {
        d.b.g0.a.b2.e.b.b().e(null, 0);
        d.b.g0.a.b2.e.b.b().e(null, 1);
        d.b.g0.a.l0.b.f(0, null);
        d.b.g0.a.l0.b.f(1, null);
    }

    public void c(@Nullable d.b.g0.a.i2.u0.b<Exception> bVar, int i) {
        d.b.g0.a.c0.c.h("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i);
        g(new C0720a(this, bVar, i), i);
    }

    public void e(int i, int i2) {
        if (f45088a) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        d.b.g0.a.b2.b.k(i, i2);
        d.b.g0.a.l0.b.e(i, i2);
    }

    public void f() {
        ExecutorUtilsExt.postOnElastic(new c(), "tryUpdateAllPresetCoresAsync", 2);
    }

    public final void g(@Nullable d.b.g0.a.i2.u0.b<Exception> bVar, int i) {
        d.b.g0.a.b2.e.b.b().e(new b(this, bVar, i), i);
    }
}
