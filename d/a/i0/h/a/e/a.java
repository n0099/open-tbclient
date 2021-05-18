package d.a.i0.h.a.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.i0.f.i.l.f;
import d.a.i0.f.i.r.i;
import d.a.i0.h.a.e.c;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl implements d, c.a {
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public String f46923e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.l0.c f46924f;

    /* renamed from: g  reason: collision with root package name */
    public String f46925g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46926h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.f.i.i.b f46927i;
    public f j;
    public boolean k;
    public Map<String, String> l;
    public d.a.i0.h.a.f.d m;
    public d.a.i0.f.i.i.f n;
    @V8JavascriptField
    public c style;

    /* renamed from: d.a.i0.h.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0995a implements d.a.i0.f.i.i.f {
        public C0995a() {
        }

        @Override // d.a.i0.f.i.i.f
        public void a(boolean z, String str) {
            if (z) {
                a.this.dispatchEvent(new JSEvent("load"));
                d.a.i0.h.a.c.b(a.this.k ? "gdtbanner" : "banner", "success");
                return;
            }
            d.a.i0.h.a.c.c(a.this.k ? "gdtbanner" : "banner", "fail", str);
        }

        @Override // d.a.i0.f.i.i.f
        public void b(int i2, int i3) {
            JSEvent jSEvent = new JSEvent("resize");
            jSEvent.data = d.a.i0.h.a.e.b.b(i2, i3);
            a.this.dispatchEvent(jSEvent);
        }

        @Override // d.a.i0.f.i.i.f
        public void onClick() {
            if (a.this.k) {
                d.a.i0.h.a.c.b("gdtbanner", PrefetchEvent.STATE_CLICK);
            }
        }

        @Override // d.a.i0.f.i.i.f
        public void onClose() {
            a.this.destroy();
            d.a.i0.h.m0.d A = d.a.i0.h.m0.d.A();
            String str = a.this.adUnitId;
            A.K(str, "" + System.currentTimeMillis());
            d.a.i0.h.a.c.b(a.this.k ? "gdtbanner" : "banner", IntentConfig.CLOSE);
        }

        @Override // d.a.i0.f.i.i.f
        public void onError(String str) {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = d.a.i0.h.a.e.b.a(str);
            a.this.dispatchEvent(jSEvent);
            d.a.i0.f.i.q.b.k(a.this.l, str);
        }

        @Override // d.a.i0.f.i.i.f
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
            jSEvent.data = d.a.i0.h.a.e.b.a(a.this.f46925g);
            a.this.dispatchEvent(jSEvent);
            d.a.i0.f.i.q.b.k(a.this.l, a.this.f46925g);
        }
    }

    public a(d.a.i0.a.l0.c cVar, JsObject jsObject) {
        super(cVar);
        this.style = null;
        this.l = new TreeMap();
        this.n = new C0995a();
        this.f46924f = cVar;
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.f46923e = G.C("appSid");
            d.a.i0.a.y.b.a x = G.x("style");
            if (x != null) {
                this.style = new c(x);
            }
        }
        boolean e2 = i.e();
        this.k = e2;
        if (e2) {
            this.f46923e = i.a();
            this.adUnitId = i.b();
        }
        Map<String, String> a2 = d.a.i0.f.i.q.b.a("banner", "game", this.f46923e, this.adUnitId, this.k);
        this.l = a2;
        d.a.i0.f.i.q.b.m("loadApi", a2);
        if (D()) {
            if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f46923e) && this.style != null) {
                d.a.i0.h.a.a aVar = new d.a.i0.h.a.a();
                this.j = aVar;
                d.a.i0.f.i.i.b bVar = new d.a.i0.f.i.i.b(this.f46923e, this.adUnitId, this.n, aVar);
                this.f46927i = bVar;
                bVar.F(this.l);
                c cVar2 = this.style;
                if (cVar2 != null) {
                    this.f46927i.E(cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                    this.style.b(this);
                }
                d.a.i0.h.a.c.b(this.k ? "gdtbanner" : "banner", null);
                return;
            }
            cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean D() {
        if (TextUtils.isEmpty(this.f46925g)) {
            d.a.i0.h.m0.d A = d.a.i0.h.m0.d.A();
            if (!A.k()) {
                if (!A.l()) {
                    if (A.t(this.adUnitId)) {
                        this.f46925g = "3010011";
                    }
                } else {
                    this.f46925g = "3010013";
                }
            } else {
                this.f46925g = "3010012";
            }
        }
        if (TextUtils.isEmpty(this.f46925g)) {
            return true;
        }
        this.f46924f.postOnJSThread(new b());
        d.a.i0.h.a.c.c("banner", "reject", this.f46925g);
        return false;
    }

    @JavascriptInterface
    public void destroy() {
        this.f46926h = true;
        removeEventListener("error", null);
        removeEventListener("load", null);
        removeEventListener("resize", null);
        d.a.i0.f.i.i.b bVar = this.f46927i;
        if (bVar != null) {
            bVar.y();
            this.f46927i = null;
        }
    }

    @JavascriptInterface
    public void hide() {
        d.a.i0.f.i.i.b bVar = this.f46927i;
        if (bVar != null) {
            bVar.B();
        }
    }

    @Override // d.a.i0.h.a.e.c.a
    public void i(String str) {
        d.a.i0.f.i.i.b bVar;
        if (this.f46926h || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (bVar = this.f46927i) == null) {
            return;
        }
        bVar.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        d.a.i0.h.a.c.d(this.k ? "gdtbanner" : "banner");
        d.a.i0.f.i.q.b.m("showApi", this.l);
        if (!D() || this.f46927i == null) {
            return;
        }
        d.a.i0.h.m0.d.A().E();
        this.m = d.a.i0.h.a.f.d.d(d.a.i0.a.y.b.a.G(jsObject));
        this.f46927i.G(jsObject);
    }
}
