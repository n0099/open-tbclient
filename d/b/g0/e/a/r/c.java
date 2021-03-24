package d.b.g0.e.a.r;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import d.b.g0.e.a.a;
import d.b.g0.e.a.r.f;
/* loaded from: classes3.dex */
public class c extends EventTargetImpl implements d.b.g0.g.a.b, f.a, a.e {
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.g.i.b f47693e;

    /* renamed from: f  reason: collision with root package name */
    public String f47694f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47695g;

    /* renamed from: h  reason: collision with root package name */
    public e f47696h;
    public String i;
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
            jSEvent.data = d.a(c.this.i);
            c.this.dispatchEvent(jSEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i {
        public b() {
        }

        @Override // d.b.g0.e.a.r.i
        public void a() {
            c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
        }

        @Override // d.b.g0.e.a.r.i
        public void b(f fVar) {
            JSEvent jSEvent = new JSEvent("resize");
            jSEvent.data = d.b(fVar);
            c.this.dispatchEvent(jSEvent);
        }

        @Override // d.b.g0.e.a.r.i
        public void onError(String str) {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = d.a(str);
            c.this.dispatchEvent(jSEvent);
        }
    }

    public c(d.b.g0.g.i.b bVar, JsObject jsObject) {
        super(bVar);
        f fVar;
        this.style = null;
        this.k = new b();
        this.f47693e = bVar;
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f47694f = F.B("appSid");
            d.b.g0.g.e.d.c w = F.w("style");
            if (w != null) {
                this.style = new f(w);
            }
        }
        boolean e2 = d.b.g0.e.a.q.f.e();
        this.j = e2;
        if (e2) {
            this.f47694f = d.b.g0.e.a.q.f.a();
            this.adUnitId = d.b.g0.e.a.q.f.b();
        }
        if (B()) {
            if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f47694f) && (fVar = this.style) != null) {
                e eVar = new e(this.f47694f, this.adUnitId, fVar, this, this.j);
                this.f47696h = eVar;
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
        if (TextUtils.isEmpty(this.i)) {
            d.b.g0.g.i0.c A = d.b.g0.g.i0.c.A();
            if (!A.k()) {
                if (!A.l()) {
                    if (A.t(this.adUnitId)) {
                        this.i = "3010011";
                    }
                } else {
                    this.i = "3010013";
                }
            } else {
                this.i = "3010012";
            }
        }
        if (TextUtils.isEmpty(this.i)) {
            return true;
        }
        this.f47693e.postOnJSThread(new a());
        d.b.g0.g.k0.e.b.c(this.j ? "gdtbanner" : "banner", "reject", this.i);
        return false;
    }

    @JavascriptInterface
    public void destroy() {
        this.f47695g = true;
        removeEventListener("error", null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener("resize", null);
        e eVar = this.f47696h;
        if (eVar != null) {
            eVar.t();
            this.f47696h = null;
        }
    }

    @Override // d.b.g0.e.a.a.e
    public void g() {
        destroy();
    }

    @JavascriptInterface
    public void hide() {
        e eVar = this.f47696h;
        if (eVar != null) {
            eVar.u();
        }
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        d.b.g0.g.k0.e.b.d(this.j ? "gdtbanner" : "banner");
        if (!B() || this.f47696h == null) {
            return;
        }
        d.b.g0.g.i0.c.A().E();
        this.f47696h.v(jsObject);
    }

    @Override // d.b.g0.e.a.r.f.a
    public void v(String str) {
        e eVar;
        if (this.f47695g || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (eVar = this.f47696h) == null) {
            return;
        }
        eVar.D(str);
    }
}
