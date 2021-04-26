package d.a.h0.g.s;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import d.a.h0.a.i2.k0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.b f46763a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.g.k0.h.a f46764b;

    /* renamed from: c  reason: collision with root package name */
    public Context f46765c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.g.e.d.c f46766d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.g.e.d.c f46767e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.g.e.d.c f46768f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.g.s.c f46769g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.g.s.e.b f46770h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.g.s.e.a f46771i;
    public d.a.h0.g.s.e.a j;
    public d.a.h0.g.s.b k;
    public f l = new C0961a();

    /* renamed from: d.a.h0.g.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0961a implements f {
        public C0961a() {
        }

        @Override // d.a.h0.g.s.a.f
        public void a() {
            a.this.j();
        }

        @Override // d.a.h0.g.s.a.f
        public void b(int i2) {
            d.a.h0.g.s.e.b bVar = new d.a.h0.g.s.e.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i2;
            d.a.h0.g.i0.b.a(a.this.f46766d, true, bVar);
        }

        @Override // d.a.h0.g.s.a.f
        public void c(String str) {
            if (a.this.k != null) {
                a.this.k.c(str);
            }
        }

        @Override // d.a.h0.g.s.a.f
        public void d(String str) {
            if (a.this.k != null) {
                a.this.k.b(str);
            }
        }

        @Override // d.a.h0.g.s.a.f
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
            if (!d.a.h0.g.k0.h.b.p().n(a.this.f46764b)) {
                a.this.f46770h.errMsg = "showKeyboard:fail";
                d.a.h0.g.i0.b.a(a.this.f46766d, false, a.this.f46770h);
                return;
            }
            a.this.f46764b.j(a.this.f46769g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.h0.g.k0.h.b.p().s(a.this.f46764b)) {
                a.this.f46771i.errMsg = "hideKeyboard:ok";
                d.a.h0.g.i0.b.a(a.this.f46767e, true, a.this.f46771i);
                return;
            }
            a.this.f46771i.errMsg = "hideKeyboard:fail";
            d.a.h0.g.i0.b.a(a.this.f46767e, false, a.this.f46771i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.g.k0.h.b.p().s(a.this.f46764b);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46776e;

        public e(String str) {
            this.f46776e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46764b.m(this.f46776e)) {
                a.this.j.errMsg = "updateKeyboard:ok";
                d.a.h0.g.i0.b.a(a.this.f46768f, true, a.this.j);
                return;
            }
            a.this.j.errMsg = "updateKeyboard:fail";
            d.a.h0.g.i0.b.a(a.this.f46768f, false, a.this.j);
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

    public a(d.a.h0.g.i.b bVar, d.a.h0.g.s.b bVar2) {
        this.k = null;
        this.f46763a = bVar;
        Context appContext = AppRuntime.getAppContext();
        this.f46765c = appContext;
        d.a.h0.g.k0.h.a aVar = new d.a.h0.g.k0.h.a(appContext);
        this.f46764b = aVar;
        aVar.i(this.l);
        this.k = bVar2;
    }

    public void j() {
        k0.X(new d());
    }

    public void k(JsObject jsObject) {
        d.a.h0.g.k0.h.a aVar;
        this.f46771i = new d.a.h0.g.s.e.a();
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        this.f46767e = F;
        if (F == null) {
            this.f46767e = new d.a.h0.g.e.d.c();
        }
        if (this.f46763a != null && (aVar = this.f46764b) != null && aVar.g()) {
            k0.X(new c());
            return;
        }
        d.a.h0.g.s.e.a aVar2 = this.f46771i;
        aVar2.errMsg = "hideKeyboard:fail";
        d.a.h0.g.i0.b.a(this.f46767e, false, aVar2);
    }

    public void l(JsObject jsObject) {
        d.a.h0.g.k0.h.a aVar;
        this.f46770h = new d.a.h0.g.s.e.b();
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        this.f46766d = F;
        if (F == null) {
            this.f46766d = new d.a.h0.g.e.d.c();
        }
        if (this.f46763a != null && (aVar = this.f46764b) != null && !aVar.g()) {
            d.a.h0.g.s.c cVar = new d.a.h0.g.s.c();
            this.f46769g = cVar;
            try {
                if (cVar.a(this.f46766d)) {
                    k0.Y(new b(), 500L);
                } else {
                    this.f46770h.errMsg = "showKeyboard:fail";
                    d.a.h0.g.i0.b.a(this.f46766d, false, this.f46770h);
                }
                return;
            } catch (JSTypeMismatchException unused) {
                d.a.h0.g.s.e.b bVar = this.f46770h;
                bVar.errMsg = "showKeyboard:fail";
                d.a.h0.g.i0.b.a(this.f46766d, false, bVar);
                return;
            }
        }
        d.a.h0.g.s.e.b bVar2 = this.f46770h;
        bVar2.errMsg = "showKeyboard:fail";
        d.a.h0.g.i0.b.a(this.f46766d, false, bVar2);
    }

    public void m(JsObject jsObject) {
        this.j = new d.a.h0.g.s.e.a();
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        this.f46768f = F;
        if (F == null) {
            this.f46768f = new d.a.h0.g.e.d.c();
        }
        if (this.f46763a != null && this.f46764b != null) {
            k0.X(new e(this.f46768f.B("value")));
            return;
        }
        d.a.h0.g.s.e.a aVar = this.j;
        aVar.errMsg = "updateKeyboard:fail";
        d.a.h0.g.i0.b.a(this.f46768f, false, aVar);
    }
}
