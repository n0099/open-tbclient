package d.a.h0.e.a.r;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.h0.e.a.a;
import d.a.h0.e.a.r.f;
/* loaded from: classes3.dex */
public class c extends EventTargetImpl implements d.a.h0.g.a.b, f.a, a.e {
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.g.i.b f45872e;

    /* renamed from: f  reason: collision with root package name */
    public String f45873f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45874g;

    /* renamed from: h  reason: collision with root package name */
    public e f45875h;

    /* renamed from: i  reason: collision with root package name */
    public String f45876i;
    public boolean j;
    public i k;
    @V8JavascriptField
    public f style;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = d.a(c.this.f45876i);
            c.this.dispatchEvent(jSEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i {
        public b() {
        }

        @Override // d.a.h0.e.a.r.i
        public void a() {
            c.this.dispatchEvent(new JSEvent("load"));
        }

        @Override // d.a.h0.e.a.r.i
        public void b(f fVar) {
            JSEvent jSEvent = new JSEvent("resize");
            jSEvent.data = d.b(fVar);
            c.this.dispatchEvent(jSEvent);
        }

        @Override // d.a.h0.e.a.r.i
        public void onError(String str) {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = d.a(str);
            c.this.dispatchEvent(jSEvent);
        }
    }

    public c(d.a.h0.g.i.b bVar, JsObject jsObject) {
        super(bVar);
        f fVar;
        this.style = null;
        this.k = new b();
        this.f45872e = bVar;
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f45873f = F.B("appSid");
            d.a.h0.g.e.d.c w = F.w("style");
            if (w != null) {
                this.style = new f(w);
            }
        }
        boolean e2 = d.a.h0.e.a.q.f.e();
        this.j = e2;
        if (e2) {
            this.f45873f = d.a.h0.e.a.q.f.a();
            this.adUnitId = d.a.h0.e.a.q.f.b();
        }
        if (B()) {
            if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f45873f) && (fVar = this.style) != null) {
                e eVar = new e(this.f45873f, this.adUnitId, fVar, this, this.j);
                this.f45875h = eVar;
                eVar.C(this.k);
                f fVar2 = this.style;
                if (fVar2 != null) {
                    fVar2.b(this);
                    return;
                }
                return;
            }
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean B() {
        if (TextUtils.isEmpty(this.f45876i)) {
            d.a.h0.g.i0.c A = d.a.h0.g.i0.c.A();
            if (!A.k()) {
                if (!A.l()) {
                    if (A.t(this.adUnitId)) {
                        this.f45876i = "3010011";
                    }
                } else {
                    this.f45876i = "3010013";
                }
            } else {
                this.f45876i = "3010012";
            }
        }
        if (TextUtils.isEmpty(this.f45876i)) {
            return true;
        }
        this.f45872e.postOnJSThread(new a());
        d.a.h0.g.k0.e.b.c(this.j ? "gdtbanner" : "banner", "reject", this.f45876i);
        return false;
    }

    @Override // d.a.h0.e.a.a.e
    public void d() {
        destroy();
    }

    @JavascriptInterface
    public void destroy() {
        this.f45874g = true;
        removeEventListener("error", null);
        removeEventListener("load", null);
        removeEventListener("resize", null);
        e eVar = this.f45875h;
        if (eVar != null) {
            eVar.t();
            this.f45875h = null;
        }
    }

    @JavascriptInterface
    public void hide() {
        e eVar = this.f45875h;
        if (eVar != null) {
            eVar.u();
        }
    }

    @Override // d.a.h0.e.a.r.f.a
    public void k(String str) {
        e eVar;
        if (this.f45874g || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (eVar = this.f45875h) == null) {
            return;
        }
        eVar.D(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        d.a.h0.g.k0.e.b.d(this.j ? "gdtbanner" : "banner");
        if (!B() || this.f45875h == null) {
            return;
        }
        d.a.h0.g.i0.c.A().E();
        this.f45875h.v(jsObject);
    }
}
