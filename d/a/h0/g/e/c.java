package d.a.h0.g.e;

import android.os.Build;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
import d.a.h0.a.k;
import d.a.h0.a.z0.f;
import d.a.h0.g.c.h;
import d.a.h0.g.f.g;
import d.a.h0.g.l.e;
import d.a.h0.g.x.d;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public final class c extends EventTargetImpl {
    public static final boolean w = k.f43101a;
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.g.i.b f46283e;
    @V8JavascriptField
    public d.a.h0.g.l.a env;

    /* renamed from: f  reason: collision with root package name */
    public e f46284f;

    /* renamed from: g  reason: collision with root package name */
    public d f46285g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.g.x.b f46286h;

    /* renamed from: i  reason: collision with root package name */
    public JsObject f46287i;
    public d.a.h0.g.x.e j;
    public d.a.h0.g.s.a k;
    public d.a.h0.g.s.b l;
    public d.a.h0.g.d0.a m;
    public d.a.h0.g.h0.d n;
    public d.a.h0.g.a.c o;
    public d.a.h0.g.w.i.a p;
    public g q;
    public d.a.h0.g.a0.a r;
    public DesktopGuideApi s;
    public d.a.h0.g.y.a t;
    public d.a.h0.g.k0.j.a u;
    public d.a.h0.g.b.b v;

    public c(d.a.h0.g.i.b bVar) {
        super(bVar);
        this.domain = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        this.f46287i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.f46283e = bVar;
        this.env = new d.a.h0.g.l.a();
        B();
    }

    @NonNull
    public final d.a.h0.g.d0.a A() {
        if (this.m == null) {
            this.m = new d.a.h0.g.d0.a(this.f46283e);
        }
        return this.m;
    }

    public final void B() {
        this.l = new d.a.h0.g.s.b(this.f46283e);
    }

    public void C(JsObject jsObject) {
        this.f46287i = jsObject;
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        d.a.h0.g.j.a.b(jsObject);
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.f46286h == null) {
            this.f46286h = new d.a.h0.g.x.b(this.f46283e);
        }
        this.f46286h.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        A().h(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        d.a.h0.g.d0.d.d.a(this.f46283e, "clearStorageSync", "", A().a());
    }

    @JavascriptInterface
    public d.a.h0.g.w.i.c connectSocket(JsObject jsObject) {
        if (this.p == null) {
            this.p = new d.a.h0.g.w.i.a(this.f46283e);
        }
        return this.p.a(jsObject);
    }

    @JavascriptInterface
    public d.a.h0.g.a.b createBannerAd(JsObject jsObject) {
        return d.a.h0.a.w0.a.b().c(this.f46283e, jsObject);
    }

    @JavascriptInterface
    public d.a.h0.g.c.g createInnerAudioContext() {
        return new d.a.h0.g.c.g(this.f46283e);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.f46283e, jsObject);
    }

    @JavascriptInterface
    public d.a.h0.g.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.o == null) {
            d.a.h0.g.a.c b2 = d.a.h0.a.w0.a.b().b(this.f46283e, jsObject);
            this.o = b2;
            if (b2 == null) {
                this.o = new d.a.h0.g.a.a();
            }
        }
        return this.o;
    }

    @JavascriptInterface
    public d.a.h0.g.k0.f.b.b createUserInfoButton(JsObject jsObject) {
        return new d.a.h0.g.k0.f.b.b(jsObject, this.f46283e);
    }

    @JavascriptInterface
    public d.a.h0.g.w.e.b downloadFile(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        d.a.h0.g.w.a d2 = d.a.h0.g.w.f.b.b().d(this.f46283e, F, 2);
        if (d2 instanceof d.a.h0.g.w.e.b) {
            d.a.h0.g.w.e.b bVar = (d.a.h0.g.w.e.b) d2;
            bVar.K(F);
            return bVar;
        }
        d.a.h0.g.w.e.b bVar2 = new d.a.h0.g.w.e.b(this.f46283e, F);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (w) {
            this.f46283e.y().b("exit from java side.");
        }
        if (jsObject == null) {
            return;
        }
        d.a.h0.g.e.d.b bVar = new d.a.h0.g.e.d.b();
        d.a.h0.g.e.d.a e2 = d.a.h0.g.e.d.a.e(d.a.h0.g.e.d.c.F(jsObject));
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            bVar.errMsg = String.format("%s:%s", "exit", com.alipay.sdk.util.e.f1950a);
            e2.b(bVar);
            return;
        }
        bVar.errMsg = String.format("%s:%s", "exit", "ok");
        e2.d(bVar);
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAndRemoveTask();
        } else {
            activity.finish();
        }
    }

    @JavascriptInterface
    public String getAPIs(int i2) {
        if (w) {
            return d.a.h0.a.m1.a.a.n() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i2) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i2);
    }

    @JavascriptInterface
    public d.a.h0.g.b.b getAntiAddiction() {
        if (this.v == null) {
            this.v = new d.a.h0.g.b.b(this.f46283e);
        }
        return this.v;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return d.a.h0.a.x0.b.b.a(this.f46283e);
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.f46284f == null) {
            this.f46284f = new e((d.a.h0.g.i.a) this.f46283e);
        }
        return this.f46284f;
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.f46285g == null) {
            this.f46285g = new d((d.a.h0.g.i.a) this.f46283e);
        }
        return this.f46285g;
    }

    @JavascriptInterface
    public d.a.h0.g.x.e getOpenDataContext() {
        if (this.j == null) {
            d.a.h0.g.x.e eVar = new d.a.h0.g.x.e(this.f46283e);
            this.j = eVar;
            eVar.canvas = this.f46287i;
            this.f46287i = null;
        }
        return this.j;
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        A().k(jsObject);
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        A().l(jsObject);
    }

    @JavascriptInterface
    public d.a.h0.g.d0.d.c getStorageInfoSync() {
        return A().b();
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return d.a.h0.g.d0.d.d.a(this.f46283e, "getStorageSync", str, A().c(str));
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        d.a.h0.g.j0.a.d(jsObject);
    }

    @JavascriptInterface
    public d.a.h0.g.h0.d getUpdateManager(JsObject jsObject) {
        if (this.n == null) {
            this.n = new d.a.h0.g.h0.d(jsObject);
        }
        return this.n;
    }

    @JavascriptInterface
    public d.a.h0.g.a0.a getVideoRecorderManager() {
        if (this.r == null) {
            this.r = new d.a.h0.g.a0.a(this.f46283e);
        }
        return this.r;
    }

    @JavascriptInterface
    public d.a.h0.g.k0.j.a getWebViewManager() {
        if (this.u == null) {
            this.u = new d.a.h0.g.k0.j.a(this.f46283e);
        }
        return this.u;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        d.a.h0.g.s.a aVar = this.k;
        if (aVar != null) {
            aVar.k(jsObject);
        }
    }

    @JavascriptInterface
    public d.a.h0.g.f0.c loadSubpackage(JsObject jsObject) {
        d.a.h0.g.f0.c cVar = new d.a.h0.g.f0.c(this.f46283e);
        cVar.H(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        d.a.h0.g.v.a H = f.V().H();
        if (H != null) {
            H.c(d.a.h0.g.e.d.c.F(jsObject));
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        d.a.h0.g.g.a.a((c) this.f46283e.o(), jsObject);
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.t == null) {
            this.t = new d.a.h0.g.y.a();
        }
        this.t.d(jsObject);
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        A().o(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        d.a.h0.g.d0.d.d.a(this.f46283e, "removeStorageSync", str, A().e(str));
    }

    @JavascriptInterface
    public d.a.h0.g.w.g.c request(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        d.a.h0.g.w.a d2 = d.a.h0.g.w.f.b.b().d(this.f46283e, F, 1);
        if (d2 instanceof d.a.h0.g.w.g.c) {
            d.a.h0.g.w.g.c cVar = (d.a.h0.g.w.g.c) d2;
            cVar.K(F);
            return cVar;
        }
        d.a.h0.g.w.g.c cVar2 = new d.a.h0.g.w.g.c(this.f46283e, F);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.q == null) {
            this.q = new g(this.f46283e);
        }
        this.q.i(jsObject);
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        new h(jsObject);
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s < 1 || s > 60) {
            return;
        }
        this.f46283e.setPreferredFramesPerSecond(s);
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        A().p(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        d.a.h0.g.d0.d.d.a(this.f46283e, "setStorageSync", str, A().f(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new d.a.h0.g.b0.b.a(jsObject).m();
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.s == null) {
            this.s = new DesktopGuideApi(this.f46283e);
        }
        this.s.v(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.k == null) {
            this.k = new d.a.h0.g.s.a(this.f46283e, this.l);
        }
        this.k.l(jsObject);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        d.a.h0.g.s.a aVar = this.k;
        if (aVar != null) {
            aVar.m(jsObject);
        }
    }

    @JavascriptInterface
    public d.a.h0.g.w.h.b uploadFile(JsObject jsObject) {
        d.a.h0.g.w.h.b bVar = new d.a.h0.g.w.h.b(this.f46283e, d.a.h0.g.e.d.c.F(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void hideKeyboard() {
        d.a.h0.g.s.a aVar = this.k;
        if (aVar != null) {
            aVar.k(null);
        }
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        d.a.h0.g.d0.d.d.a(this.f46283e, "setStorageSync", str, A().f(str, null));
    }

    @JavascriptInterface
    public void updateKeyboard() {
        d.a.h0.g.s.a aVar = this.k;
        if (aVar != null) {
            aVar.m(null);
        }
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.k == null) {
            this.k = new d.a.h0.g.s.a(this.f46283e, this.l);
        }
        this.k.l(null);
    }
}
