package d.a.m0.h.u;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.c f51463a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.h.o0.f.a f51464b;

    /* renamed from: c  reason: collision with root package name */
    public Context f51465c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.y.b.a f51466d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.y.b.a f51467e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.a.y.b.a f51468f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.h.u.c f51469g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.h.u.e.b f51470h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.h.u.e.a f51471i;
    public d.a.m0.h.u.e.a j;
    public d.a.m0.h.u.b k;
    public f l = new C1111a();

    /* renamed from: d.a.m0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1111a implements f {
        public C1111a() {
        }

        @Override // d.a.m0.h.u.a.f
        public void a() {
            a.this.j();
        }

        @Override // d.a.m0.h.u.a.f
        public void b(int i2) {
            d.a.m0.h.u.e.b bVar = new d.a.m0.h.u.e.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i2;
            d.a.m0.h.m0.c.a(a.this.f51466d, true, bVar);
        }

        @Override // d.a.m0.h.u.a.f
        public void c(String str) {
            if (a.this.k != null) {
                a.this.k.c(str);
            }
        }

        @Override // d.a.m0.h.u.a.f
        public void d(String str) {
            if (a.this.k != null) {
                a.this.k.b(str);
            }
        }

        @Override // d.a.m0.h.u.a.f
        public void e(String str) {
            if (a.this.k != null) {
                a.this.k.d(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.a.m0.h.o0.f.b.p().n(a.this.f51464b)) {
                a.this.f51470h.errMsg = "showKeyboard:fail";
                d.a.m0.h.m0.c.a(a.this.f51466d, false, a.this.f51470h);
                return;
            }
            a.this.f51464b.j(a.this.f51469g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.m0.h.o0.f.b.p().s(a.this.f51464b)) {
                a.this.f51471i.errMsg = "hideKeyboard:ok";
                d.a.m0.h.m0.c.a(a.this.f51467e, true, a.this.f51471i);
                return;
            }
            a.this.f51471i.errMsg = "hideKeyboard:fail";
            d.a.m0.h.m0.c.a(a.this.f51467e, false, a.this.f51471i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.h.o0.f.b.p().s(a.this.f51464b);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51476e;

        public e(String str) {
            this.f51476e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51464b.m(this.f51476e)) {
                a.this.j.errMsg = "updateKeyboard:ok";
                d.a.m0.h.m0.c.a(a.this.f51468f, true, a.this.j);
                return;
            }
            a.this.j.errMsg = "updateKeyboard:fail";
            d.a.m0.h.m0.c.a(a.this.f51468f, false, a.this.j);
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(d.a.m0.a.l0.c cVar, d.a.m0.h.u.b bVar) {
        this.k = null;
        this.f51463a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f51465c = appContext;
        d.a.m0.h.o0.f.a aVar = new d.a.m0.h.o0.f.a(appContext);
        this.f51464b = aVar;
        aVar.i(this.l);
        this.k = bVar;
    }

    public void j() {
        q0.b0(new d());
    }

    public void k(JsObject jsObject) {
        d.a.m0.h.o0.f.a aVar;
        this.f51471i = new d.a.m0.h.u.e.a();
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        this.f51467e = G;
        if (G == null) {
            this.f51467e = new d.a.m0.a.y.b.a();
        }
        if (this.f51463a != null && (aVar = this.f51464b) != null && aVar.g()) {
            q0.b0(new c());
            return;
        }
        d.a.m0.h.u.e.a aVar2 = this.f51471i;
        aVar2.errMsg = "hideKeyboard:fail";
        d.a.m0.h.m0.c.a(this.f51467e, false, aVar2);
    }

    public void l(JsObject jsObject) {
        d.a.m0.h.o0.f.a aVar;
        this.f51470h = new d.a.m0.h.u.e.b();
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        this.f51466d = G;
        if (G == null) {
            this.f51466d = new d.a.m0.a.y.b.a();
        }
        if (this.f51463a != null && (aVar = this.f51464b) != null && !aVar.g()) {
            d.a.m0.h.u.c cVar = new d.a.m0.h.u.c();
            this.f51469g = cVar;
            try {
                if (cVar.a(this.f51466d)) {
                    q0.c0(new b(), 500L);
                } else {
                    this.f51470h.errMsg = "showKeyboard:fail";
                    d.a.m0.h.m0.c.a(this.f51466d, false, this.f51470h);
                }
                return;
            } catch (JSTypeMismatchException unused) {
                d.a.m0.h.u.e.b bVar = this.f51470h;
                bVar.errMsg = "showKeyboard:fail";
                d.a.m0.h.m0.c.a(this.f51466d, false, bVar);
                return;
            }
        }
        d.a.m0.h.u.e.b bVar2 = this.f51470h;
        bVar2.errMsg = "showKeyboard:fail";
        d.a.m0.h.m0.c.a(this.f51466d, false, bVar2);
    }

    public void m(JsObject jsObject) {
        this.j = new d.a.m0.h.u.e.a();
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        this.f51468f = G;
        if (G == null) {
            this.f51468f = new d.a.m0.a.y.b.a();
        }
        if (this.f51463a != null && this.f51464b != null) {
            q0.b0(new e(this.f51468f.C("value")));
            return;
        }
        d.a.m0.h.u.e.a aVar = this.j;
        aVar.errMsg = "updateKeyboard:fail";
        d.a.m0.h.m0.c.a(this.f51468f, false, aVar);
    }
}
