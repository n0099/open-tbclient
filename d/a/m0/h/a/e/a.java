package d.a.m0.h.a.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.f.i.l.f;
import d.a.m0.f.i.r.i;
import d.a.m0.h.a.e.c;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl implements d, c.a {
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public String f50881e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.a.l0.c f50882f;

    /* renamed from: g  reason: collision with root package name */
    public String f50883g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50884h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.f.i.i.b f50885i;
    public f j;
    public boolean k;
    public Map<String, String> l;
    public d.a.m0.h.a.f.d m;
    public d.a.m0.f.i.i.f n;
    @V8JavascriptField
    public c style;

    /* renamed from: d.a.m0.h.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1065a implements d.a.m0.f.i.i.f {
        public C1065a() {
        }

        @Override // d.a.m0.f.i.i.f
        public void a(boolean z, String str) {
            if (z) {
                a.this.dispatchEvent(new JSEvent("load"));
                d.a.m0.h.a.c.b(a.this.k ? "gdtbanner" : "banner", "success");
                return;
            }
            d.a.m0.h.a.c.c(a.this.k ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
        }

        @Override // d.a.m0.f.i.i.f
        public void b(int i2, int i3) {
            JSEvent jSEvent = new JSEvent("resize");
            jSEvent.data = d.a.m0.h.a.e.b.b(i2, i3);
            a.this.dispatchEvent(jSEvent);
        }

        @Override // d.a.m0.f.i.i.f
        public void onClick() {
            if (a.this.k) {
                d.a.m0.h.a.c.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }

        @Override // d.a.m0.f.i.i.f
        public void onClose() {
            a.this.destroy();
            d.a.m0.h.m0.d A = d.a.m0.h.m0.d.A();
            String str = a.this.adUnitId;
            A.K(str, "" + System.currentTimeMillis());
            d.a.m0.h.a.c.b(a.this.k ? "gdtbanner" : "banner", IntentConfig.CLOSE);
        }

        @Override // d.a.m0.f.i.i.f
        public void onError(String str) {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = d.a.m0.h.a.e.b.a(str);
            a.this.dispatchEvent(jSEvent);
            d.a.m0.f.i.q.b.k(a.this.l, str);
        }

        @Override // d.a.m0.f.i.i.f
        public void onShow(boolean z) {
            if (a.this.m == null) {
                return;
            }
            if (z) {
                a.this.m.c();
            } else {
                a.this.m.b("3010010");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = d.a.m0.h.a.e.b.a(a.this.f50883g);
            a.this.dispatchEvent(jSEvent);
            d.a.m0.f.i.q.b.k(a.this.l, a.this.f50883g);
        }
    }

    public a(d.a.m0.a.l0.c cVar, JsObject jsObject) {
        super(cVar);
        this.style = null;
        this.l = new TreeMap();
        this.n = new C1065a();
        this.f50882f = cVar;
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.f50881e = G.C("appSid");
            d.a.m0.a.y.b.a x = G.x("style");
            if (x != null) {
                this.style = new c(x);
            }
        }
        boolean e2 = i.e();
        this.k = e2;
        if (e2) {
            this.f50881e = i.a();
            this.adUnitId = i.b();
        }
        Map<String, String> a2 = d.a.m0.f.i.q.b.a("banner", "game", this.f50881e, this.adUnitId, this.k);
        this.l = a2;
        d.a.m0.f.i.q.b.m("loadApi", a2);
        if (D()) {
            if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f50881e) && this.style != null) {
                d.a.m0.h.a.a aVar = new d.a.m0.h.a.a();
                this.j = aVar;
                d.a.m0.f.i.i.b bVar = new d.a.m0.f.i.i.b(this.f50881e, this.adUnitId, this.n, aVar);
                this.f50885i = bVar;
                bVar.F(this.l);
                c cVar2 = this.style;
                if (cVar2 != null) {
                    this.f50885i.E(cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                    this.style.b(this);
                }
                d.a.m0.h.a.c.b(this.k ? "gdtbanner" : "banner", null);
                return;
            }
            cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean D() {
        if (TextUtils.isEmpty(this.f50883g)) {
            d.a.m0.h.m0.d A = d.a.m0.h.m0.d.A();
            if (!A.k()) {
                if (!A.l()) {
                    if (A.t(this.adUnitId)) {
                        this.f50883g = "3010011";
                    }
                } else {
                    this.f50883g = "3010013";
                }
            } else {
                this.f50883g = "3010012";
            }
        }
        if (TextUtils.isEmpty(this.f50883g)) {
            return true;
        }
        this.f50882f.postOnJSThread(new b());
        d.a.m0.h.a.c.c("banner", "reject", this.f50883g);
        return false;
    }

    @JavascriptInterface
    public void destroy() {
        this.f50884h = true;
        removeEventListener("error", null);
        removeEventListener("load", null);
        removeEventListener("resize", null);
        d.a.m0.f.i.i.b bVar = this.f50885i;
        if (bVar != null) {
            bVar.y();
            this.f50885i = null;
        }
    }

    @JavascriptInterface
    public void hide() {
        d.a.m0.f.i.i.b bVar = this.f50885i;
        if (bVar != null) {
            bVar.B();
        }
    }

    @Override // d.a.m0.h.a.e.c.a
    public void i(String str) {
        d.a.m0.f.i.i.b bVar;
        if (this.f50884h || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (bVar = this.f50885i) == null) {
            return;
        }
        bVar.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        d.a.m0.h.a.c.d(this.k ? "gdtbanner" : "banner");
        d.a.m0.f.i.q.b.m("showApi", this.l);
        if (!D() || this.f50885i == null) {
            return;
        }
        d.a.m0.h.m0.d.A().E();
        this.m = d.a.m0.h.a.f.d.d(d.a.m0.a.y.b.a.G(jsObject));
        this.f50885i.G(jsObject);
    }
}
