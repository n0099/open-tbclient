package d.b.h0.g.s;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import d.b.h0.a.i2.k0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.i.b f49269a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.g.k0.h.a f49270b;

    /* renamed from: c  reason: collision with root package name */
    public Context f49271c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.g.e.d.c f49272d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.g.e.d.c f49273e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g.e.d.c f49274f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.g.s.c f49275g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.g.s.e.b f49276h;
    public d.b.h0.g.s.e.a i;
    public d.b.h0.g.s.e.a j;
    public d.b.h0.g.s.b k;
    public f l = new C1022a();

    /* renamed from: d.b.h0.g.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1022a implements f {
        public C1022a() {
        }

        @Override // d.b.h0.g.s.a.f
        public void a(String str) {
            if (a.this.k != null) {
                a.this.k.c(str);
            }
        }

        @Override // d.b.h0.g.s.a.f
        public void b(String str) {
            if (a.this.k != null) {
                a.this.k.b(str);
            }
        }

        @Override // d.b.h0.g.s.a.f
        public void c(String str) {
            if (a.this.k != null) {
                a.this.k.d(str);
            }
        }

        @Override // d.b.h0.g.s.a.f
        public void d() {
            a.this.j();
        }

        @Override // d.b.h0.g.s.a.f
        public void e(int i) {
            d.b.h0.g.s.e.b bVar = new d.b.h0.g.s.e.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            d.b.h0.g.i0.b.a(a.this.f49272d, true, bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.b.h0.g.k0.h.b.p().n(a.this.f49270b)) {
                a.this.f49276h.errMsg = "showKeyboard:fail";
                d.b.h0.g.i0.b.a(a.this.f49272d, false, a.this.f49276h);
                return;
            }
            a.this.f49270b.j(a.this.f49275g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.h0.g.k0.h.b.p().s(a.this.f49270b)) {
                a.this.i.errMsg = "hideKeyboard:ok";
                d.b.h0.g.i0.b.a(a.this.f49273e, true, a.this.i);
                return;
            }
            a.this.i.errMsg = "hideKeyboard:fail";
            d.b.h0.g.i0.b.a(a.this.f49273e, false, a.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.g.k0.h.b.p().s(a.this.f49270b);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49281e;

        public e(String str) {
            this.f49281e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49270b.m(this.f49281e)) {
                a.this.j.errMsg = "updateKeyboard:ok";
                d.b.h0.g.i0.b.a(a.this.f49274f, true, a.this.j);
                return;
            }
            a.this.j.errMsg = "updateKeyboard:fail";
            d.b.h0.g.i0.b.a(a.this.f49274f, false, a.this.j);
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

    public a(d.b.h0.g.i.b bVar, d.b.h0.g.s.b bVar2) {
        this.k = null;
        this.f49269a = bVar;
        Context appContext = AppRuntime.getAppContext();
        this.f49271c = appContext;
        d.b.h0.g.k0.h.a aVar = new d.b.h0.g.k0.h.a(appContext);
        this.f49270b = aVar;
        aVar.i(this.l);
        this.k = bVar2;
    }

    public void j() {
        k0.X(new d());
    }

    public void k(JsObject jsObject) {
        d.b.h0.g.k0.h.a aVar;
        this.i = new d.b.h0.g.s.e.a();
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        this.f49273e = F;
        if (F == null) {
            this.f49273e = new d.b.h0.g.e.d.c();
        }
        if (this.f49269a != null && (aVar = this.f49270b) != null && aVar.g()) {
            k0.X(new c());
            return;
        }
        d.b.h0.g.s.e.a aVar2 = this.i;
        aVar2.errMsg = "hideKeyboard:fail";
        d.b.h0.g.i0.b.a(this.f49273e, false, aVar2);
    }

    public void l(JsObject jsObject) {
        d.b.h0.g.k0.h.a aVar;
        this.f49276h = new d.b.h0.g.s.e.b();
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        this.f49272d = F;
        if (F == null) {
            this.f49272d = new d.b.h0.g.e.d.c();
        }
        if (this.f49269a != null && (aVar = this.f49270b) != null && !aVar.g()) {
            d.b.h0.g.s.c cVar = new d.b.h0.g.s.c();
            this.f49275g = cVar;
            try {
                if (cVar.a(this.f49272d)) {
                    k0.Y(new b(), 500L);
                } else {
                    this.f49276h.errMsg = "showKeyboard:fail";
                    d.b.h0.g.i0.b.a(this.f49272d, false, this.f49276h);
                }
                return;
            } catch (JSTypeMismatchException unused) {
                d.b.h0.g.s.e.b bVar = this.f49276h;
                bVar.errMsg = "showKeyboard:fail";
                d.b.h0.g.i0.b.a(this.f49272d, false, bVar);
                return;
            }
        }
        d.b.h0.g.s.e.b bVar2 = this.f49276h;
        bVar2.errMsg = "showKeyboard:fail";
        d.b.h0.g.i0.b.a(this.f49272d, false, bVar2);
    }

    public void m(JsObject jsObject) {
        this.j = new d.b.h0.g.s.e.a();
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        this.f49274f = F;
        if (F == null) {
            this.f49274f = new d.b.h0.g.e.d.c();
        }
        if (this.f49269a != null && this.f49270b != null) {
            k0.X(new e(this.f49274f.B("value")));
            return;
        }
        d.b.h0.g.s.e.a aVar = this.j;
        aVar.errMsg = "updateKeyboard:fail";
        d.b.h0.g.i0.b.a(this.f49274f, false, aVar);
    }
}
