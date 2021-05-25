package d.a.l0.a.p0.e;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44017a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f44018b;

    /* renamed from: d.a.l0.a.p0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0793a implements d.a.l0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f44019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44020f;

        /* renamed from: d.a.l0.a.p0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0794a implements d.a.l0.a.v2.e1.b<Exception> {
            public C0794a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.i("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                d.a.l0.a.v2.e1.b bVar = C0793a.this.f44019e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public C0793a(a aVar, d.a.l0.a.v2.e1.b bVar, int i2) {
            this.f44019e = bVar;
            this.f44020f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc == null) {
                d.h("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                d.a.l0.a.v2.e1.b bVar = this.f44019e;
                if (bVar != null) {
                    bVar.onCallback(null);
                    return;
                }
                return;
            }
            d.h("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
            d.a.l0.a.m2.b.o(this.f44020f, new C0794a());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f44022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44023f;

        /* renamed from: d.a.l0.a.p0.e.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0795a implements d.a.l0.a.v2.e1.b<Exception> {
            public C0795a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                d.a.l0.a.v2.e1.b bVar = b.this.f44022e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                }
            }
        }

        public b(a aVar, d.a.l0.a.v2.e1.b bVar, int i2) {
            this.f44022e = bVar;
            this.f44023f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            if (exc != null) {
                d.a.l0.a.v2.e1.b bVar = this.f44022e;
                if (bVar != null) {
                    bVar.onCallback(exc);
                    return;
                }
                return;
            }
            d.a.l0.a.p0.b.h(this.f44023f, new C0795a());
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
        if (f44018b == null) {
            synchronized (a.class) {
                if (f44018b == null) {
                    f44018b = new a();
                }
            }
        }
        return f44018b;
    }

    public final void b() {
        d.a.l0.a.m2.e.b.b().e(null, 0);
        d.a.l0.a.m2.e.b.b().e(null, 1);
        d.a.l0.a.p0.b.h(0, null);
        d.a.l0.a.p0.b.h(1, null);
    }

    public void c(@Nullable d.a.l0.a.v2.e1.b<Exception> bVar, int i2) {
        d.h("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i2);
        g(new C0793a(this, bVar, i2), i2);
    }

    public void e(int i2, int i3) {
        if (f44017a) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
        }
        d.a.l0.a.m2.b.l(i2, i3);
        d.a.l0.a.p0.b.g(i2, i3);
    }

    public void f() {
        ExecutorUtilsExt.postOnElastic(new c(), "tryUpdateAllPresetCoresAsync", 2);
    }

    public final void g(@Nullable d.a.l0.a.v2.e1.b<Exception> bVar, int i2) {
        d.a.l0.a.m2.e.b.b().e(new b(this, bVar, i2), i2);
    }
}
