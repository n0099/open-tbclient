package d.b.g0.g.e;

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
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import d.b.g0.g.c.h;
import d.b.g0.g.f.g;
import d.b.g0.g.l.e;
import d.b.g0.g.x.d;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public final class c extends EventTargetImpl {
    public static final boolean w = k.f45051a;
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.g.i.b f48092e;
    @V8JavascriptField
    public d.b.g0.g.l.a env;

    /* renamed from: f  reason: collision with root package name */
    public e f48093f;

    /* renamed from: g  reason: collision with root package name */
    public d f48094g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.g.x.b f48095h;
    public JsObject i;
    public d.b.g0.g.x.e j;
    public d.b.g0.g.s.a k;
    public d.b.g0.g.s.b l;
    public d.b.g0.g.d0.a m;
    public d.b.g0.g.h0.d n;
    public d.b.g0.g.a.c o;
    public d.b.g0.g.w.i.a p;
    public g q;
    public d.b.g0.g.a0.a r;
    public DesktopGuideApi s;
    public d.b.g0.g.y.a t;
    public d.b.g0.g.k0.j.a u;
    public d.b.g0.g.b.b v;

    public c(d.b.g0.g.i.b bVar) {
        super(bVar);
        this.domain = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        this.i = null;
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
        this.f48092e = bVar;
        this.env = new d.b.g0.g.l.a();
        B();
    }

    @NonNull
    public final d.b.g0.g.d0.a A() {
        if (this.m == null) {
            this.m = new d.b.g0.g.d0.a(this.f48092e);
        }
        return this.m;
    }

    public final void B() {
        this.l = new d.b.g0.g.s.b(this.f48092e);
    }

    public void C(JsObject jsObject) {
        this.i = jsObject;
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        d.b.g0.g.j.a.b(jsObject);
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.f48095h == null) {
            this.f48095h = new d.b.g0.g.x.b(this.f48092e);
        }
        this.f48095h.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        A().h(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        d.b.g0.g.d0.d.d.a(this.f48092e, "clearStorageSync", "", A().a());
    }

    @JavascriptInterface
    public d.b.g0.g.w.i.c connectSocket(JsObject jsObject) {
        if (this.p == null) {
            this.p = new d.b.g0.g.w.i.a(this.f48092e);
        }
        return this.p.a(jsObject);
    }

    @JavascriptInterface
    public d.b.g0.g.a.b createBannerAd(JsObject jsObject) {
        return d.b.g0.a.w0.a.b().a(this.f48092e, jsObject);
    }

    @JavascriptInterface
    public d.b.g0.g.c.g createInnerAudioContext() {
        return new d.b.g0.g.c.g(this.f48092e);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.f48092e, jsObject);
    }

    @JavascriptInterface
    public d.b.g0.g.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.o == null) {
            d.b.g0.g.a.c c2 = d.b.g0.a.w0.a.b().c(this.f48092e, jsObject);
            this.o = c2;
            if (c2 == null) {
                this.o = new d.b.g0.g.a.a();
            }
        }
        return this.o;
    }

    @JavascriptInterface
    public d.b.g0.g.k0.f.b.b createUserInfoButton(JsObject jsObject) {
        return new d.b.g0.g.k0.f.b.b(jsObject, this.f48092e);
    }

    @JavascriptInterface
    public d.b.g0.g.w.e.b downloadFile(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        d.b.g0.g.w.a d2 = d.b.g0.g.w.f.b.b().d(this.f48092e, F, 2);
        if (d2 instanceof d.b.g0.g.w.e.b) {
            d.b.g0.g.w.e.b bVar = (d.b.g0.g.w.e.b) d2;
            bVar.K(F);
            return bVar;
        }
        d.b.g0.g.w.e.b bVar2 = new d.b.g0.g.w.e.b(this.f48092e, F);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (w) {
            this.f48092e.a0().b("exit from java side.");
        }
        if (jsObject == null) {
            return;
        }
        d.b.g0.g.e.d.b bVar = new d.b.g0.g.e.d.b();
        d.b.g0.g.e.d.a e2 = d.b.g0.g.e.d.a.e(d.b.g0.g.e.d.c.F(jsObject));
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            bVar.errMsg = String.format("%s:%s", "exit", com.alipay.sdk.util.e.f1969a);
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
    public String getAPIs(int i) {
        if (w) {
            return d.b.g0.a.m1.a.a.n() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public d.b.g0.g.b.b getAntiAddiction() {
        if (this.v == null) {
            this.v = new d.b.g0.g.b.b(this.f48092e);
        }
        return this.v;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return d.b.g0.a.x0.b.b.a(this.f48092e);
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.f48093f == null) {
            this.f48093f = new e((d.b.g0.g.i.a) this.f48092e);
        }
        return this.f48093f;
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.f48094g == null) {
            this.f48094g = new d((d.b.g0.g.i.a) this.f48092e);
        }
        return this.f48094g;
    }

    @JavascriptInterface
    public d.b.g0.g.x.e getOpenDataContext() {
        if (this.j == null) {
            d.b.g0.g.x.e eVar = new d.b.g0.g.x.e(this.f48092e);
            this.j = eVar;
            eVar.canvas = this.i;
            this.i = null;
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
    public d.b.g0.g.d0.d.c getStorageInfoSync() {
        return A().b();
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return d.b.g0.g.d0.d.d.a(this.f48092e, "getStorageSync", str, A().c(str));
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        d.b.g0.g.j0.a.d(jsObject);
    }

    @JavascriptInterface
    public d.b.g0.g.h0.d getUpdateManager(JsObject jsObject) {
        if (this.n == null) {
            this.n = new d.b.g0.g.h0.d(jsObject);
        }
        return this.n;
    }

    @JavascriptInterface
    public d.b.g0.g.a0.a getVideoRecorderManager() {
        if (this.r == null) {
            this.r = new d.b.g0.g.a0.a(this.f48092e);
        }
        return this.r;
    }

    @JavascriptInterface
    public d.b.g0.g.k0.j.a getWebViewManager() {
        if (this.u == null) {
            this.u = new d.b.g0.g.k0.j.a(this.f48092e);
        }
        return this.u;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        d.b.g0.g.s.a aVar = this.k;
        if (aVar != null) {
            aVar.k(jsObject);
        }
    }

    @JavascriptInterface
    public d.b.g0.g.f0.c loadSubpackage(JsObject jsObject) {
        d.b.g0.g.f0.c cVar = new d.b.g0.g.f0.c(this.f48092e);
        cVar.H(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        d.b.g0.g.v.a v = f.V().v();
        if (v != null) {
            v.c(d.b.g0.g.e.d.c.F(jsObject));
        }
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        d.b.g0.g.g.a.a((c) this.f48092e.t(), jsObject);
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.t == null) {
            this.t = new d.b.g0.g.y.a();
        }
        this.t.d(jsObject);
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        A().o(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        d.b.g0.g.d0.d.d.a(this.f48092e, "removeStorageSync", str, A().e(str));
    }

    @JavascriptInterface
    public d.b.g0.g.w.g.c request(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        d.b.g0.g.w.a d2 = d.b.g0.g.w.f.b.b().d(this.f48092e, F, 1);
        if (d2 instanceof d.b.g0.g.w.g.c) {
            d.b.g0.g.w.g.c cVar = (d.b.g0.g.w.g.c) d2;
            cVar.K(F);
            return cVar;
        }
        d.b.g0.g.w.g.c cVar2 = new d.b.g0.g.w.g.c(this.f48092e, F);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.q == null) {
            this.q = new g(this.f48092e);
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
        this.f48092e.setPreferredFramesPerSecond(s);
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        A().p(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        d.b.g0.g.d0.d.d.a(this.f48092e, "setStorageSync", str, A().f(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new d.b.g0.g.b0.b.a(jsObject).m();
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.s == null) {
            this.s = new DesktopGuideApi(this.f48092e);
        }
        this.s.v(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.k == null) {
            this.k = new d.b.g0.g.s.a(this.f48092e, this.l);
        }
        this.k.l(jsObject);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        d.b.g0.g.s.a aVar = this.k;
        if (aVar != null) {
            aVar.m(jsObject);
        }
    }

    @JavascriptInterface
    public d.b.g0.g.w.h.b uploadFile(JsObject jsObject) {
        d.b.g0.g.w.h.b bVar = new d.b.g0.g.w.h.b(this.f48092e, d.b.g0.g.e.d.c.F(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void hideKeyboard() {
        d.b.g0.g.s.a aVar = this.k;
        if (aVar != null) {
            aVar.k(null);
        }
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        d.b.g0.g.d0.d.d.a(this.f48092e, "setStorageSync", str, A().f(str, null));
    }

    @JavascriptInterface
    public void updateKeyboard() {
        d.b.g0.g.s.a aVar = this.k;
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
            this.k = new d.b.g0.g.s.a(this.f48092e, this.l);
        }
        this.k.l(null);
    }
}
