package d.b.g0.e.a.r;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
/* loaded from: classes3.dex */
public class n extends EventTargetImpl implements d.b.g0.g.a.c {
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public h f48138e;

    /* renamed from: f  reason: collision with root package name */
    public String f48139f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48140g;

    /* renamed from: h  reason: collision with root package name */
    public j f48141h;

    /* loaded from: classes3.dex */
    public class a implements j {
        public a() {
        }

        @Override // d.b.g0.e.a.r.j
        public void a() {
            n.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
        }

        @Override // d.b.g0.e.a.r.j
        public void b(boolean z) {
            JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
            jSEvent.data = m.a(z);
            n.this.dispatchEvent(jSEvent);
        }

        @Override // d.b.g0.e.a.r.j
        public void onError(String str) {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = m.b(str);
            n.this.dispatchEvent(jSEvent);
        }
    }

    public n(d.b.g0.g.i.b bVar, JsObject jsObject) {
        super(bVar);
        this.adUnitId = "";
        this.f48141h = new a();
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.f48139f = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f48139f)) {
            boolean g2 = d.b.g0.e.a.q.f.g();
            this.f48140g = g2;
            if (g2) {
                this.f48139f = d.b.g0.e.a.q.f.c();
                this.adUnitId = d.b.g0.e.a.q.f.d();
            }
            h hVar = new h(this.f48139f, this.adUnitId, this.f48140g);
            this.f48138e = hVar;
            hVar.t0(this.f48141h);
            loadAd(null);
            return;
        }
        bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (this.f48138e != null) {
            this.f48138e.s0(F);
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        d.b.g0.g.k0.e.b.d(this.f48138e.b0());
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (this.f48138e != null) {
            this.f48138e.u0(F);
        }
    }
}
