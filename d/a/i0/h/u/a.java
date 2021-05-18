package d.a.i0.h.u;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import d.a.i0.a.v2.q0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.c f47505a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.h.o0.f.a f47506b;

    /* renamed from: c  reason: collision with root package name */
    public Context f47507c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.y.b.a f47508d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.y.b.a f47509e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.y.b.a f47510f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.h.u.c f47511g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.h.u.e.b f47512h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.h.u.e.a f47513i;
    public d.a.i0.h.u.e.a j;
    public d.a.i0.h.u.b k;
    public f l = new C1041a();

    /* renamed from: d.a.i0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1041a implements f {
        public C1041a() {
        }

        @Override // d.a.i0.h.u.a.f
        public void a() {
            a.this.j();
        }

        @Override // d.a.i0.h.u.a.f
        public void b(int i2) {
            d.a.i0.h.u.e.b bVar = new d.a.i0.h.u.e.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i2;
            d.a.i0.h.m0.c.a(a.this.f47508d, true, bVar);
        }

        @Override // d.a.i0.h.u.a.f
        public void c(String str) {
            if (a.this.k != null) {
                a.this.k.c(str);
            }
        }

        @Override // d.a.i0.h.u.a.f
        public void d(String str) {
            if (a.this.k != null) {
                a.this.k.b(str);
            }
        }

        @Override // d.a.i0.h.u.a.f
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
            if (!d.a.i0.h.o0.f.b.p().n(a.this.f47506b)) {
                a.this.f47512h.errMsg = "showKeyboard:fail";
                d.a.i0.h.m0.c.a(a.this.f47508d, false, a.this.f47512h);
                return;
            }
            a.this.f47506b.j(a.this.f47511g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.i0.h.o0.f.b.p().s(a.this.f47506b)) {
                a.this.f47513i.errMsg = "hideKeyboard:ok";
                d.a.i0.h.m0.c.a(a.this.f47509e, true, a.this.f47513i);
                return;
            }
            a.this.f47513i.errMsg = "hideKeyboard:fail";
            d.a.i0.h.m0.c.a(a.this.f47509e, false, a.this.f47513i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.h.o0.f.b.p().s(a.this.f47506b);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47518e;

        public e(String str) {
            this.f47518e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47506b.m(this.f47518e)) {
                a.this.j.errMsg = "updateKeyboard:ok";
                d.a.i0.h.m0.c.a(a.this.f47510f, true, a.this.j);
                return;
            }
            a.this.j.errMsg = "updateKeyboard:fail";
            d.a.i0.h.m0.c.a(a.this.f47510f, false, a.this.j);
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

    public a(d.a.i0.a.l0.c cVar, d.a.i0.h.u.b bVar) {
        this.k = null;
        this.f47505a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f47507c = appContext;
        d.a.i0.h.o0.f.a aVar = new d.a.i0.h.o0.f.a(appContext);
        this.f47506b = aVar;
        aVar.i(this.l);
        this.k = bVar;
    }

    public void j() {
        q0.b0(new d());
    }

    public void k(JsObject jsObject) {
        d.a.i0.h.o0.f.a aVar;
        this.f47513i = new d.a.i0.h.u.e.a();
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        this.f47509e = G;
        if (G == null) {
            this.f47509e = new d.a.i0.a.y.b.a();
        }
        if (this.f47505a != null && (aVar = this.f47506b) != null && aVar.g()) {
            q0.b0(new c());
            return;
        }
        d.a.i0.h.u.e.a aVar2 = this.f47513i;
        aVar2.errMsg = "hideKeyboard:fail";
        d.a.i0.h.m0.c.a(this.f47509e, false, aVar2);
    }

    public void l(JsObject jsObject) {
        d.a.i0.h.o0.f.a aVar;
        this.f47512h = new d.a.i0.h.u.e.b();
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        this.f47508d = G;
        if (G == null) {
            this.f47508d = new d.a.i0.a.y.b.a();
        }
        if (this.f47505a != null && (aVar = this.f47506b) != null && !aVar.g()) {
            d.a.i0.h.u.c cVar = new d.a.i0.h.u.c();
            this.f47511g = cVar;
            try {
                if (cVar.a(this.f47508d)) {
                    q0.c0(new b(), 500L);
                } else {
                    this.f47512h.errMsg = "showKeyboard:fail";
                    d.a.i0.h.m0.c.a(this.f47508d, false, this.f47512h);
                }
                return;
            } catch (JSTypeMismatchException unused) {
                d.a.i0.h.u.e.b bVar = this.f47512h;
                bVar.errMsg = "showKeyboard:fail";
                d.a.i0.h.m0.c.a(this.f47508d, false, bVar);
                return;
            }
        }
        d.a.i0.h.u.e.b bVar2 = this.f47512h;
        bVar2.errMsg = "showKeyboard:fail";
        d.a.i0.h.m0.c.a(this.f47508d, false, bVar2);
    }

    public void m(JsObject jsObject) {
        this.j = new d.a.i0.h.u.e.a();
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        this.f47510f = G;
        if (G == null) {
            this.f47510f = new d.a.i0.a.y.b.a();
        }
        if (this.f47505a != null && this.f47506b != null) {
            q0.b0(new e(this.f47510f.C("value")));
            return;
        }
        d.a.i0.h.u.e.a aVar = this.j;
        aVar.errMsg = "updateKeyboard:fail";
        d.a.i0.h.m0.c.a(this.f47510f, false, aVar);
    }
}
