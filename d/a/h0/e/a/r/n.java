package d.a.h0.e.a.r;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class n extends EventTargetImpl implements d.a.h0.g.a.c {
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public h f45927e;

    /* renamed from: f  reason: collision with root package name */
    public String f45928f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45929g;

    /* renamed from: h  reason: collision with root package name */
    public j f45930h;

    /* loaded from: classes3.dex */
    public class a implements j {
        public a() {
        }

        @Override // d.a.h0.e.a.r.j
        public void a() {
            n.this.dispatchEvent(new JSEvent("load"));
        }

        @Override // d.a.h0.e.a.r.j
        public void b(boolean z) {
            JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
            jSEvent.data = m.a(z);
            n.this.dispatchEvent(jSEvent);
        }

        @Override // d.a.h0.e.a.r.j
        public void onError(String str) {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = m.b(str);
            n.this.dispatchEvent(jSEvent);
        }
    }

    public n(d.a.h0.g.i.b bVar, JsObject jsObject) {
        super(bVar);
        this.adUnitId = "";
        this.f45930h = new a();
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f45928f = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f45928f)) {
            boolean g2 = d.a.h0.e.a.q.f.g();
            this.f45929g = g2;
            if (g2) {
                this.f45928f = d.a.h0.e.a.q.f.c();
                this.adUnitId = d.a.h0.e.a.q.f.d();
            }
            h hVar = new h(this.f45928f, this.adUnitId, this.f45929g);
            this.f45927e = hVar;
            hVar.t0(this.f45930h);
            loadAd(null);
            return;
        }
        bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (this.f45927e != null) {
            this.f45927e.s0(F);
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        d.a.h0.g.k0.e.b.d(this.f45927e.b0());
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (this.f45927e != null) {
            this.f45927e.u0(F);
        }
    }
}
