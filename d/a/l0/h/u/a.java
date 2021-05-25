package d.a.l0.h.u;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.c f47681a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.h.o0.f.a f47682b;

    /* renamed from: c  reason: collision with root package name */
    public Context f47683c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.y.b.a f47684d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.y.b.a f47685e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.y.b.a f47686f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.h.u.c f47687g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.h.u.e.b f47688h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.l0.h.u.e.a f47689i;
    public d.a.l0.h.u.e.a j;
    public d.a.l0.h.u.b k;
    public f l = new C1052a();

    /* renamed from: d.a.l0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1052a implements f {
        public C1052a() {
        }

        @Override // d.a.l0.h.u.a.f
        public void a() {
            a.this.j();
        }

        @Override // d.a.l0.h.u.a.f
        public void b(int i2) {
            d.a.l0.h.u.e.b bVar = new d.a.l0.h.u.e.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i2;
            d.a.l0.h.m0.c.a(a.this.f47684d, true, bVar);
        }

        @Override // d.a.l0.h.u.a.f
        public void c(String str) {
            if (a.this.k != null) {
                a.this.k.c(str);
            }
        }

        @Override // d.a.l0.h.u.a.f
        public void d(String str) {
            if (a.this.k != null) {
                a.this.k.b(str);
            }
        }

        @Override // d.a.l0.h.u.a.f
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
            if (!d.a.l0.h.o0.f.b.p().n(a.this.f47682b)) {
                a.this.f47688h.errMsg = "showKeyboard:fail";
                d.a.l0.h.m0.c.a(a.this.f47684d, false, a.this.f47688h);
                return;
            }
            a.this.f47682b.j(a.this.f47687g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.h.o0.f.b.p().s(a.this.f47682b)) {
                a.this.f47689i.errMsg = "hideKeyboard:ok";
                d.a.l0.h.m0.c.a(a.this.f47685e, true, a.this.f47689i);
                return;
            }
            a.this.f47689i.errMsg = "hideKeyboard:fail";
            d.a.l0.h.m0.c.a(a.this.f47685e, false, a.this.f47689i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.h.o0.f.b.p().s(a.this.f47682b);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47694e;

        public e(String str) {
            this.f47694e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47682b.m(this.f47694e)) {
                a.this.j.errMsg = "updateKeyboard:ok";
                d.a.l0.h.m0.c.a(a.this.f47686f, true, a.this.j);
                return;
            }
            a.this.j.errMsg = "updateKeyboard:fail";
            d.a.l0.h.m0.c.a(a.this.f47686f, false, a.this.j);
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

    public a(d.a.l0.a.l0.c cVar, d.a.l0.h.u.b bVar) {
        this.k = null;
        this.f47681a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f47683c = appContext;
        d.a.l0.h.o0.f.a aVar = new d.a.l0.h.o0.f.a(appContext);
        this.f47682b = aVar;
        aVar.i(this.l);
        this.k = bVar;
    }

    public void j() {
        q0.b0(new d());
    }

    public void k(JsObject jsObject) {
        d.a.l0.h.o0.f.a aVar;
        this.f47689i = new d.a.l0.h.u.e.a();
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        this.f47685e = G;
        if (G == null) {
            this.f47685e = new d.a.l0.a.y.b.a();
        }
        if (this.f47681a != null && (aVar = this.f47682b) != null && aVar.g()) {
            q0.b0(new c());
            return;
        }
        d.a.l0.h.u.e.a aVar2 = this.f47689i;
        aVar2.errMsg = "hideKeyboard:fail";
        d.a.l0.h.m0.c.a(this.f47685e, false, aVar2);
    }

    public void l(JsObject jsObject) {
        d.a.l0.h.o0.f.a aVar;
        this.f47688h = new d.a.l0.h.u.e.b();
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        this.f47684d = G;
        if (G == null) {
            this.f47684d = new d.a.l0.a.y.b.a();
        }
        if (this.f47681a != null && (aVar = this.f47682b) != null && !aVar.g()) {
            d.a.l0.h.u.c cVar = new d.a.l0.h.u.c();
            this.f47687g = cVar;
            try {
                if (cVar.a(this.f47684d)) {
                    q0.c0(new b(), 500L);
                } else {
                    this.f47688h.errMsg = "showKeyboard:fail";
                    d.a.l0.h.m0.c.a(this.f47684d, false, this.f47688h);
                }
                return;
            } catch (JSTypeMismatchException unused) {
                d.a.l0.h.u.e.b bVar = this.f47688h;
                bVar.errMsg = "showKeyboard:fail";
                d.a.l0.h.m0.c.a(this.f47684d, false, bVar);
                return;
            }
        }
        d.a.l0.h.u.e.b bVar2 = this.f47688h;
        bVar2.errMsg = "showKeyboard:fail";
        d.a.l0.h.m0.c.a(this.f47684d, false, bVar2);
    }

    public void m(JsObject jsObject) {
        this.j = new d.a.l0.h.u.e.a();
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        this.f47686f = G;
        if (G == null) {
            this.f47686f = new d.a.l0.a.y.b.a();
        }
        if (this.f47681a != null && this.f47682b != null) {
            q0.b0(new e(this.f47686f.C("value")));
            return;
        }
        d.a.l0.h.u.e.a aVar = this.j;
        aVar.errMsg = "updateKeyboard:fail";
        d.a.l0.h.m0.c.a(this.f47686f, false, aVar);
    }
}
