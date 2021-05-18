package d.a.i0.h.d;

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
import d.a.i0.a.k;
import d.a.i0.a.l0.c;
import d.a.i0.a.r0.e;
import d.a.i0.h.c.g;
import d.a.i0.h.c.h;
import d.a.i0.h.f.f;
import d.a.i0.h.k0.j;
import d.a.i0.h.z.d;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public final class b extends EventTargetImpl {
    public static final boolean y = k.f43025a;
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public c f47094e;
    @V8JavascriptField
    public d.a.i0.a.r0.a env;

    /* renamed from: f  reason: collision with root package name */
    public e f47095f;

    /* renamed from: g  reason: collision with root package name */
    public d f47096g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.h.z.b f47097h;

    /* renamed from: i  reason: collision with root package name */
    public JsObject f47098i;
    public d.a.i0.h.z.e j;
    public d.a.i0.h.u.a k;
    public d.a.i0.h.u.b l;
    public d.a.i0.h.g0.b m;
    public d.a.i0.h.l0.d n;
    public d.a.i0.h.a.f.b o;
    public d.a.i0.h.y.h.a p;
    public f q;
    public d.a.i0.h.d0.a r;
    public DesktopGuideApi s;
    public d.a.i0.h.b0.a t;
    public d.a.i0.h.o0.h.a u;
    public d.a.i0.h.b.b v;
    public d.a.i0.h.i.a w;
    public d.a.i0.h.a0.a x;

    public b(c cVar) {
        super(cVar);
        this.domain = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
        this.f47098i = null;
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
        this.w = null;
        this.x = null;
        this.f47094e = cVar;
        this.env = new d.a.i0.a.r0.a();
        A();
    }

    public final void A() {
        this.l = new d.a.i0.h.u.b(this.f47094e);
    }

    public void B(JsObject jsObject) {
        this.f47098i = jsObject;
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        d.a.i0.h.l.a.b(jsObject);
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.f47097h == null) {
            this.f47097h = new d.a.i0.h.z.b(this.f47094e);
        }
        this.f47097h.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        z().h(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        d.a.i0.h.g0.f.d.a(this.f47094e, "clearStorageSync", "", z().a());
    }

    @JavascriptInterface
    public d.a.i0.h.y.h.c connectSocket(JsObject jsObject) {
        if (this.p == null) {
            this.p = new d.a.i0.h.y.h.a(this.f47094e);
        }
        return this.p.a(jsObject);
    }

    @JavascriptInterface
    public d.a.i0.h.a.e.d createBannerAd(JsObject jsObject) {
        return new d.a.i0.h.a.e.a(this.f47094e, jsObject);
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        return new g(this.f47094e);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.f47094e, jsObject);
    }

    @JavascriptInterface
    public d.a.i0.h.a.f.b createRewardedVideoAd(JsObject jsObject) {
        if (this.o == null) {
            this.o = new d.a.i0.h.a.f.e(this.f47094e, jsObject);
        }
        return this.o;
    }

    @JavascriptInterface
    public d.a.i0.h.k0.g createUDPSocket() {
        return j.f47260c.b(this.f47094e);
    }

    @JavascriptInterface
    public d.a.i0.h.o0.d.b.b createUserInfoButton(JsObject jsObject) {
        return new d.a.i0.h.o0.d.b.b(jsObject, this.f47094e);
    }

    @JavascriptInterface
    public d.a.i0.h.y.d.b downloadFile(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        d.a.i0.h.y.a d2 = d.a.i0.h.y.e.b.b().d(this.f47094e, G, 2);
        if (d2 instanceof d.a.i0.h.y.d.b) {
            d.a.i0.h.y.d.b bVar = (d.a.i0.h.y.d.b) d2;
            bVar.J(G);
            return bVar;
        }
        d.a.i0.h.y.d.b bVar2 = new d.a.i0.h.y.d.b(this.f47094e, G);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (y) {
            this.f47094e.A().b("exit from java side.");
        }
        if (jsObject == null) {
            return;
        }
        d.a.i0.h.d.c.b bVar = new d.a.i0.h.d.c.b();
        d.a.i0.h.d.c.a e2 = d.a.i0.h.d.c.a.e(d.a.i0.a.y.b.a.G(jsObject));
        SwanAppActivity activity = d.a.i0.a.g1.f.V().getActivity();
        if (activity == null) {
            bVar.errMsg = String.format("%s:%s", "exit", com.alipay.sdk.util.e.f1950a);
            e2.b(bVar);
            return;
        }
        bVar.errMsg = String.format("%s:%s", "exit", "ok");
        e2.d(bVar);
        activity.finishAndRemoveTask();
    }

    @JavascriptInterface
    public void exitVoIPChat(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.d(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i2) {
        if (y) {
            return d.a.i0.a.u1.a.a.p() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i2) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i2);
    }

    @JavascriptInterface
    public d.a.i0.h.b.b getAntiAddiction() {
        if (this.v == null) {
            this.v = new d.a.i0.h.b.b(this.f47094e);
        }
        return this.v;
    }

    @JavascriptInterface
    public d.a.i0.h.i.a getDownloadApp(JsObject jsObject) {
        if (this.w == null) {
            this.w = new d.a.i0.h.i.a(this.f47094e, d.a.i0.a.y.b.a.G(jsObject));
        }
        return this.w;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return d.a.i0.a.d1.b.b.a(this.f47094e);
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.f47095f == null) {
            this.f47095f = new e((d.a.i0.a.l0.a) this.f47094e);
        }
        return this.f47095f;
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.f47096g == null) {
            this.f47096g = new d((d.a.i0.a.l0.a) this.f47094e);
        }
        return this.f47096g;
    }

    @JavascriptInterface
    public d.a.i0.h.z.e getOpenDataContext() {
        if (this.j == null) {
            d.a.i0.h.z.e eVar = new d.a.i0.h.z.e(this.f47094e);
            this.j = eVar;
            eVar.canvas = this.f47098i;
            this.f47098i = null;
        }
        return this.j;
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        z().k(jsObject);
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        z().l(jsObject);
    }

    @JavascriptInterface
    public d.a.i0.h.g0.f.c getStorageInfoSync() {
        return z().b();
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return d.a.i0.h.g0.f.d.a(this.f47094e, "getStorageSync", str, z().c(str));
    }

    @JavascriptInterface
    public void getSwanGameDuration(JsObject jsObject) {
        d.a.i0.h.j.a.a(jsObject);
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        d.a.i0.h.n0.a.d(jsObject);
    }

    @JavascriptInterface
    public d.a.i0.h.l0.d getUpdateManager(JsObject jsObject) {
        if (this.n == null) {
            this.n = new d.a.i0.h.l0.d(jsObject);
        }
        return this.n;
    }

    @JavascriptInterface
    public d.a.i0.h.d0.a getVideoRecorderManager() {
        if (this.r == null) {
            this.r = new d.a.i0.h.d0.a(this.f47094e);
        }
        return this.r;
    }

    @JavascriptInterface
    public d.a.i0.h.o0.h.a getWebViewManager() {
        if (this.u == null) {
            this.u = new d.a.i0.h.o0.h.a(this.f47094e);
        }
        return this.u;
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        d.a.i0.h.u.a aVar = this.k;
        if (aVar != null) {
            aVar.k(jsObject);
        }
    }

    @JavascriptInterface
    public void joinVoIPChat(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.b(jsObject);
    }

    @JavascriptInterface
    public d.a.i0.h.i0.c loadSubpackage(JsObject jsObject) {
        d.a.i0.h.i0.c cVar = new d.a.i0.h.i0.c(this.f47094e);
        cVar.G(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        d.a.i0.a.p.b.a.k H = d.a.i0.a.g1.f.V().H();
        if (H != null) {
            H.a(d.a.i0.a.y.b.a.G(jsObject));
        }
    }

    @JavascriptInterface
    public void offVoIPChatInterrupted(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.a(jsObject);
    }

    @JavascriptInterface
    public void offVoIPChatMembersChanged(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.g(jsObject);
    }

    @JavascriptInterface
    public void offVoIPChatSpeakersChanged(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.i(jsObject);
    }

    @JavascriptInterface
    public void onVoIPChatInterrupted(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.c(jsObject);
    }

    @JavascriptInterface
    public void onVoIPChatMembersChanged(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.h(jsObject);
    }

    @JavascriptInterface
    public void onVoIPChatSpeakersChanged(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.k(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        d.a.i0.h.g.a.a((b) this.f47094e.p(), jsObject);
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.t == null) {
            this.t = new d.a.i0.h.b0.a();
        }
        this.t.d(jsObject);
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        z().o(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        d.a.i0.h.g0.f.d.a(this.f47094e, "removeStorageSync", str, z().e(str));
    }

    @JavascriptInterface
    public d.a.i0.h.y.f.c request(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        d.a.i0.h.y.a d2 = d.a.i0.h.y.e.b.b().d(this.f47094e, G, 1);
        if (d2 instanceof d.a.i0.h.y.f.c) {
            d.a.i0.h.y.f.c cVar = (d.a.i0.h.y.f.c) d2;
            cVar.J(G);
            return cVar;
        }
        d.a.i0.h.y.f.c cVar2 = new d.a.i0.h.y.f.c(this.f47094e, G);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.q == null) {
            this.q = new f(this.f47094e);
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
        this.f47094e.setPreferredFramesPerSecond(s);
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        z().p(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        d.a.i0.h.g0.f.d.a(this.f47094e, "setStorageSync", str, z().f(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new d.a.i0.h.e0.b.a(jsObject).m();
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.s == null) {
            this.s = new DesktopGuideApi(this.f47094e);
        }
        this.s.v(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.k == null) {
            this.k = new d.a.i0.h.u.a(this.f47094e, this.l);
        }
        this.k.l(jsObject);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        d.a.i0.h.u.a aVar = this.k;
        if (aVar != null) {
            aVar.m(jsObject);
        }
    }

    @JavascriptInterface
    public void updateVoIPChatMuteConfig(JsObject jsObject) {
        if (this.x == null) {
            this.x = d.a.i0.h.a0.b.f46944a.a();
        }
        this.x.e(jsObject);
    }

    @JavascriptInterface
    public d.a.i0.h.y.g.b uploadFile(JsObject jsObject) {
        d.a.i0.h.y.g.b bVar = new d.a.i0.h.y.g.b(this.f47094e, d.a.i0.a.y.b.a.G(jsObject));
        bVar.start();
        return bVar;
    }

    @NonNull
    public final d.a.i0.h.g0.b z() {
        if (this.m == null) {
            this.m = new d.a.i0.h.g0.b(this.f47094e);
        }
        return this.m;
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void hideKeyboard() {
        d.a.i0.h.u.a aVar = this.k;
        if (aVar != null) {
            aVar.k(null);
        }
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        d.a.i0.h.g0.f.d.a(this.f47094e, "setStorageSync", str, z().f(str, null));
    }

    @JavascriptInterface
    public void updateKeyboard() {
        d.a.i0.h.u.a aVar = this.k;
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
            this.k = new d.a.i0.h.u.a(this.f47094e, this.l);
        }
        this.k.l(null);
    }
}
