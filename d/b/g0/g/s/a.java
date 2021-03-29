package d.b.g0.g.s;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import d.b.g0.a.i2.k0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.b f48548a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.k0.h.a f48549b;

    /* renamed from: c  reason: collision with root package name */
    public Context f48550c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.e.d.c f48551d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.g.e.d.c f48552e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.e.d.c f48553f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.s.c f48554g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.g.s.e.b f48555h;
    public d.b.g0.g.s.e.a i;
    public d.b.g0.g.s.e.a j;
    public d.b.g0.g.s.b k;
    public f l = new C0990a();

    /* renamed from: d.b.g0.g.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0990a implements f {
        public C0990a() {
        }

        @Override // d.b.g0.g.s.a.f
        public void a(String str) {
            if (a.this.k != null) {
                a.this.k.c(str);
            }
        }

        @Override // d.b.g0.g.s.a.f
        public void b(String str) {
            if (a.this.k != null) {
                a.this.k.b(str);
            }
        }

        @Override // d.b.g0.g.s.a.f
        public void c(String str) {
            if (a.this.k != null) {
                a.this.k.d(str);
            }
        }

        @Override // d.b.g0.g.s.a.f
        public void d() {
            a.this.j();
        }

        @Override // d.b.g0.g.s.a.f
        public void e(int i) {
            d.b.g0.g.s.e.b bVar = new d.b.g0.g.s.e.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            d.b.g0.g.i0.b.a(a.this.f48551d, true, bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.b.g0.g.k0.h.b.p().n(a.this.f48549b)) {
                a.this.f48555h.errMsg = "showKeyboard:fail";
                d.b.g0.g.i0.b.a(a.this.f48551d, false, a.this.f48555h);
                return;
            }
            a.this.f48549b.j(a.this.f48554g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.g0.g.k0.h.b.p().s(a.this.f48549b)) {
                a.this.i.errMsg = "hideKeyboard:ok";
                d.b.g0.g.i0.b.a(a.this.f48552e, true, a.this.i);
                return;
            }
            a.this.i.errMsg = "hideKeyboard:fail";
            d.b.g0.g.i0.b.a(a.this.f48552e, false, a.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.k0.h.b.p().s(a.this.f48549b);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48560e;

        public e(String str) {
            this.f48560e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48549b.m(this.f48560e)) {
                a.this.j.errMsg = "updateKeyboard:ok";
                d.b.g0.g.i0.b.a(a.this.f48553f, true, a.this.j);
                return;
            }
            a.this.j.errMsg = "updateKeyboard:fail";
            d.b.g0.g.i0.b.a(a.this.f48553f, false, a.this.j);
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(String str);

        void b(String str);

        void c(String str);

        void d();

        void e(int i);
    }

    public a(d.b.g0.g.i.b bVar, d.b.g0.g.s.b bVar2) {
        this.k = null;
        this.f48548a = bVar;
        Context appContext = AppRuntime.getAppContext();
        this.f48550c = appContext;
        d.b.g0.g.k0.h.a aVar = new d.b.g0.g.k0.h.a(appContext);
        this.f48549b = aVar;
        aVar.i(this.l);
        this.k = bVar2;
    }

    public void j() {
        k0.X(new d());
    }

    public void k(JsObject jsObject) {
        d.b.g0.g.k0.h.a aVar;
        this.i = new d.b.g0.g.s.e.a();
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        this.f48552e = F;
        if (F == null) {
            this.f48552e = new d.b.g0.g.e.d.c();
        }
        if (this.f48548a != null && (aVar = this.f48549b) != null && aVar.g()) {
            k0.X(new c());
            return;
        }
        d.b.g0.g.s.e.a aVar2 = this.i;
        aVar2.errMsg = "hideKeyboard:fail";
        d.b.g0.g.i0.b.a(this.f48552e, false, aVar2);
    }

    public void l(JsObject jsObject) {
        d.b.g0.g.k0.h.a aVar;
        this.f48555h = new d.b.g0.g.s.e.b();
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        this.f48551d = F;
        if (F == null) {
            this.f48551d = new d.b.g0.g.e.d.c();
        }
        if (this.f48548a != null && (aVar = this.f48549b) != null && !aVar.g()) {
            d.b.g0.g.s.c cVar = new d.b.g0.g.s.c();
            this.f48554g = cVar;
            try {
                if (cVar.a(this.f48551d)) {
                    k0.Y(new b(), 500L);
                } else {
                    this.f48555h.errMsg = "showKeyboard:fail";
                    d.b.g0.g.i0.b.a(this.f48551d, false, this.f48555h);
                }
                return;
            } catch (JSTypeMismatchException unused) {
                d.b.g0.g.s.e.b bVar = this.f48555h;
                bVar.errMsg = "showKeyboard:fail";
                d.b.g0.g.i0.b.a(this.f48551d, false, bVar);
                return;
            }
        }
        d.b.g0.g.s.e.b bVar2 = this.f48555h;
        bVar2.errMsg = "showKeyboard:fail";
        d.b.g0.g.i0.b.a(this.f48551d, false, bVar2);
    }

    public void m(JsObject jsObject) {
        this.j = new d.b.g0.g.s.e.a();
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        this.f48553f = F;
        if (F == null) {
            this.f48553f = new d.b.g0.g.e.d.c();
        }
        if (this.f48548a != null && this.f48549b != null) {
            k0.X(new e(this.f48553f.B("value")));
            return;
        }
        d.b.g0.g.s.e.a aVar = this.j;
        aVar.errMsg = "updateKeyboard:fail";
        d.b.g0.g.i0.b.a(this.f48553f, false, aVar);
    }
}
