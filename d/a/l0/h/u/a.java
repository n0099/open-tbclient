package d.a.l0.h.u;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.c f51355a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.h.o0.f.a f51356b;

    /* renamed from: c  reason: collision with root package name */
    public Context f51357c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.y.b.a f51358d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.y.b.a f51359e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.y.b.a f51360f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.h.u.c f51361g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.h.u.e.b f51362h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.l0.h.u.e.a f51363i;
    public d.a.l0.h.u.e.a j;
    public d.a.l0.h.u.b k;
    public f l = new C1108a();

    /* renamed from: d.a.l0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1108a implements f {
        public C1108a() {
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
            d.a.l0.h.m0.c.a(a.this.f51358d, true, bVar);
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
            if (!d.a.l0.h.o0.f.b.p().n(a.this.f51356b)) {
                a.this.f51362h.errMsg = "showKeyboard:fail";
                d.a.l0.h.m0.c.a(a.this.f51358d, false, a.this.f51362h);
                return;
            }
            a.this.f51356b.j(a.this.f51361g);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.h.o0.f.b.p().s(a.this.f51356b)) {
                a.this.f51363i.errMsg = "hideKeyboard:ok";
                d.a.l0.h.m0.c.a(a.this.f51359e, true, a.this.f51363i);
                return;
            }
            a.this.f51363i.errMsg = "hideKeyboard:fail";
            d.a.l0.h.m0.c.a(a.this.f51359e, false, a.this.f51363i);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.h.o0.f.b.p().s(a.this.f51356b);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51368e;

        public e(String str) {
            this.f51368e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51356b.m(this.f51368e)) {
                a.this.j.errMsg = "updateKeyboard:ok";
                d.a.l0.h.m0.c.a(a.this.f51360f, true, a.this.j);
                return;
            }
            a.this.j.errMsg = "updateKeyboard:fail";
            d.a.l0.h.m0.c.a(a.this.f51360f, false, a.this.j);
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
        this.f51355a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f51357c = appContext;
        d.a.l0.h.o0.f.a aVar = new d.a.l0.h.o0.f.a(appContext);
        this.f51356b = aVar;
        aVar.i(this.l);
        this.k = bVar;
    }

    public void j() {
        q0.b0(new d());
    }

    public void k(JsObject jsObject) {
        d.a.l0.h.o0.f.a aVar;
        this.f51363i = new d.a.l0.h.u.e.a();
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        this.f51359e = G;
        if (G == null) {
            this.f51359e = new d.a.l0.a.y.b.a();
        }
        if (this.f51355a != null && (aVar = this.f51356b) != null && aVar.g()) {
            q0.b0(new c());
            return;
        }
        d.a.l0.h.u.e.a aVar2 = this.f51363i;
        aVar2.errMsg = "hideKeyboard:fail";
        d.a.l0.h.m0.c.a(this.f51359e, false, aVar2);
    }

    public void l(JsObject jsObject) {
        d.a.l0.h.o0.f.a aVar;
        this.f51362h = new d.a.l0.h.u.e.b();
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        this.f51358d = G;
        if (G == null) {
            this.f51358d = new d.a.l0.a.y.b.a();
        }
        if (this.f51355a != null && (aVar = this.f51356b) != null && !aVar.g()) {
            d.a.l0.h.u.c cVar = new d.a.l0.h.u.c();
            this.f51361g = cVar;
            try {
                if (cVar.a(this.f51358d)) {
                    q0.c0(new b(), 500L);
                } else {
                    this.f51362h.errMsg = "showKeyboard:fail";
                    d.a.l0.h.m0.c.a(this.f51358d, false, this.f51362h);
                }
                return;
            } catch (JSTypeMismatchException unused) {
                d.a.l0.h.u.e.b bVar = this.f51362h;
                bVar.errMsg = "showKeyboard:fail";
                d.a.l0.h.m0.c.a(this.f51358d, false, bVar);
                return;
            }
        }
        d.a.l0.h.u.e.b bVar2 = this.f51362h;
        bVar2.errMsg = "showKeyboard:fail";
        d.a.l0.h.m0.c.a(this.f51358d, false, bVar2);
    }

    public void m(JsObject jsObject) {
        this.j = new d.a.l0.h.u.e.a();
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        this.f51360f = G;
        if (G == null) {
            this.f51360f = new d.a.l0.a.y.b.a();
        }
        if (this.f51355a != null && this.f51356b != null) {
            q0.b0(new e(this.f51360f.C("value")));
            return;
        }
        d.a.l0.h.u.e.a aVar = this.j;
        aVar.errMsg = "updateKeyboard:fail";
        d.a.l0.h.m0.c.a(this.f51360f, false, aVar);
    }
}
