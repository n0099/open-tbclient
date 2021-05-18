package d.a.i0.a.p0.e;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43841a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f43842b;

    /* renamed from: d.a.i0.a.p0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0782a implements d.a.i0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f43843e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43844f;

        /* renamed from: d.a.i0.a.p0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0783a implements d.a.i0.a.v2.e1.b<Exception> {
            public C0783a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.i("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                d.a.i0.a.v2.e1.b bVar = C0782a.this.f43843e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public C0782a(a aVar, d.a.i0.a.v2.e1.b bVar, int i2) {
            this.f43843e = bVar;
            this.f43844f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc == null) {
                d.h("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                d.a.i0.a.v2.e1.b bVar = this.f43843e;
                if (bVar != null) {
                    bVar.onCallback(null);
                    return;
                }
                return;
            }
            d.h("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
            d.a.i0.a.m2.b.o(this.f43844f, new C0783a());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f43846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43847f;

        /* renamed from: d.a.i0.a.p0.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0784a implements d.a.i0.a.v2.e1.b<Exception> {
            public C0784a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.a.i0.a.v2.e1.b bVar = b.this.f43846e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public b(a aVar, d.a.i0.a.v2.e1.b bVar, int i2) {
            this.f43846e = bVar;
            this.f43847f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc != null) {
                d.a.i0.a.v2.e1.b bVar = this.f43846e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                    return;
                }
                return;
            }
            d.a.i0.a.p0.b.h(this.f43847f, new C0784a());
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
        if (f43842b == null) {
            synchronized (a.class) {
                if (f43842b == null) {
                    f43842b = new a();
                }
            }
        }
        return f43842b;
    }

    public final void b() {
        d.a.i0.a.m2.e.b.b().e(null, 0);
        d.a.i0.a.m2.e.b.b().e(null, 1);
        d.a.i0.a.p0.b.h(0, null);
        d.a.i0.a.p0.b.h(1, null);
    }

    public void c(@Nullable d.a.i0.a.v2.e1.b<Exception> bVar, int i2) {
        d.h("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i2);
        g(new C0782a(this, bVar, i2), i2);
    }

    public void e(int i2, int i3) {
        if (f43841a) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
        }
        d.a.i0.a.m2.b.l(i2, i3);
        d.a.i0.a.p0.b.g(i2, i3);
    }

    public void f() {
        ExecutorUtilsExt.postOnElastic(new c(), "tryUpdateAllPresetCoresAsync", 2);
    }

    public final void g(@Nullable d.a.i0.a.v2.e1.b<Exception> bVar, int i2) {
        d.a.i0.a.m2.e.b.b().e(new b(this, bVar, i2), i2);
    }
}
