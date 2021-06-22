package d.a.m0.a.p0.e;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47799a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f47800b;

    /* renamed from: d.a.m0.a.p0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0852a implements d.a.m0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f47801e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47802f;

        /* renamed from: d.a.m0.a.p0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0853a implements d.a.m0.a.v2.e1.b<Exception> {
            public C0853a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.i("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                d.a.m0.a.v2.e1.b bVar = C0852a.this.f47801e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public C0852a(a aVar, d.a.m0.a.v2.e1.b bVar, int i2) {
            this.f47801e = bVar;
            this.f47802f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc == null) {
                d.h("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                d.a.m0.a.v2.e1.b bVar = this.f47801e;
                if (bVar != null) {
                    bVar.onCallback(null);
                    return;
                }
                return;
            }
            d.h("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
            d.a.m0.a.m2.b.o(this.f47802f, new C0853a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f47804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47805f;

        /* renamed from: d.a.m0.a.p0.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0854a implements d.a.m0.a.v2.e1.b<Exception> {
            public C0854a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.a.m0.a.v2.e1.b bVar = b.this.f47804e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public b(a aVar, d.a.m0.a.v2.e1.b bVar, int i2) {
            this.f47804e = bVar;
            this.f47805f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc != null) {
                d.a.m0.a.v2.e1.b bVar = this.f47804e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                    return;
                }
                return;
            }
            d.a.m0.a.p0.b.h(this.f47805f, new C0854a());
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
        if (f47800b == null) {
            synchronized (a.class) {
                if (f47800b == null) {
                    f47800b = new a();
                }
            }
        }
        return f47800b;
    }

    public final void b() {
        d.a.m0.a.m2.e.b.b().e(null, 0);
        d.a.m0.a.m2.e.b.b().e(null, 1);
        d.a.m0.a.p0.b.h(0, null);
        d.a.m0.a.p0.b.h(1, null);
    }

    public void c(@Nullable d.a.m0.a.v2.e1.b<Exception> bVar, int i2) {
        d.h("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i2);
        g(new C0852a(this, bVar, i2), i2);
    }

    public void e(int i2, int i3) {
        if (f47799a) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
        }
        d.a.m0.a.m2.b.l(i2, i3);
        d.a.m0.a.p0.b.g(i2, i3);
    }

    public void f() {
        ExecutorUtilsExt.postOnElastic(new c(), "tryUpdateAllPresetCoresAsync", 2);
    }

    public final void g(@Nullable d.a.m0.a.v2.e1.b<Exception> bVar, int i2) {
        d.a.m0.a.m2.e.b.b().e(new b(this, bVar, i2), i2);
    }
}
