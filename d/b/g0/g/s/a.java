package d.b.g0.g.s;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import d.b.g0.a.i2.k0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.b f48940a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.k0.h.a f48941b;

    /* renamed from: c  reason: collision with root package name */
    public Context f48942c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.e.d.c f48943d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.g.e.d.c f48944e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.e.d.c f48945f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.s.c f48946g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.g.s.e.b f48947h;
    public d.b.g0.g.s.e.a i;
    public d.b.g0.g.s.e.a j;
    public d.b.g0.g.s.b k;
    public f l = new C1002a();

    /* renamed from: d.b.g0.g.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1002a implements f {
        public C1002a() {
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
            d.b.g0.g.i0.b.a(a.this.f48943d, true, bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.b.g0.g.k0.h.b.p().n(a.this.f48941b)) {
                a.this.f48947h.errMsg = "showKeyboard:fail";
                d.b.g0.g.i0.b.a(a.this.f48943d, false, a.this.f48947h);
                return;
            }
            a.this.f48941b.j(a.this.f48946g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.g0.g.k0.h.b.p().s(a.this.f48941b)) {
                a.this.i.errMsg = "hideKeyboard:ok";
                d.b.g0.g.i0.b.a(a.this.f48944e, true, a.this.i);
                return;
            }
            a.this.i.errMsg = "hideKeyboard:fail";
            d.b.g0.g.i0.b.a(a.this.f48944e, false, a.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.k0.h.b.p().s(a.this.f48941b);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48952e;

        public e(String str) {
            this.f48952e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48941b.m(this.f48952e)) {
                a.this.j.errMsg = "updateKeyboard:ok";
                d.b.g0.g.i0.b.a(a.this.f48945f, true, a.this.j);
                return;
            }
            a.this.j.errMsg = "updateKeyboard:fail";
            d.b.g0.g.i0.b.a(a.this.f48945f, false, a.this.j);
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
        this.f48940a = bVar;
        Context appContext = AppRuntime.getAppContext();
        this.f48942c = appContext;
        d.b.g0.g.k0.h.a aVar = new d.b.g0.g.k0.h.a(appContext);
        this.f48941b = aVar;
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
        this.f48944e = F;
        if (F == null) {
            this.f48944e = new d.b.g0.g.e.d.c();
        }
        if (this.f48940a != null && (aVar = this.f48941b) != null && aVar.g()) {
            k0.X(new c());
            return;
        }
        d.b.g0.g.s.e.a aVar2 = this.i;
        aVar2.errMsg = "hideKeyboard:fail";
        d.b.g0.g.i0.b.a(this.f48944e, false, aVar2);
    }

    public void l(JsObject jsObject) {
        d.b.g0.g.k0.h.a aVar;
        this.f48947h = new d.b.g0.g.s.e.b();
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        this.f48943d = F;
        if (F == null) {
            this.f48943d = new d.b.g0.g.e.d.c();
        }
        if (this.f48940a != null && (aVar = this.f48941b) != null && !aVar.g()) {
            d.b.g0.g.s.c cVar = new d.b.g0.g.s.c();
            this.f48946g = cVar;
            try {
                if (cVar.a(this.f48943d)) {
                    k0.Y(new b(), 500L);
                } else {
                    this.f48947h.errMsg = "showKeyboard:fail";
                    d.b.g0.g.i0.b.a(this.f48943d, false, this.f48947h);
                }
                return;
            } catch (JSTypeMismatchException unused) {
                d.b.g0.g.s.e.b bVar = this.f48947h;
                bVar.errMsg = "showKeyboard:fail";
                d.b.g0.g.i0.b.a(this.f48943d, false, bVar);
                return;
            }
        }
        d.b.g0.g.s.e.b bVar2 = this.f48947h;
        bVar2.errMsg = "showKeyboard:fail";
        d.b.g0.g.i0.b.a(this.f48943d, false, bVar2);
    }

    public void m(JsObject jsObject) {
        this.j = new d.b.g0.g.s.e.a();
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        this.f48945f = F;
        if (F == null) {
            this.f48945f = new d.b.g0.g.e.d.c();
        }
        if (this.f48940a != null && this.f48941b != null) {
            k0.X(new e(this.f48945f.B("value")));
            return;
        }
        d.b.g0.g.s.e.a aVar = this.j;
        aVar.errMsg = "updateKeyboard:fail";
        d.b.g0.g.i0.b.a(this.f48945f, false, aVar);
    }
}
