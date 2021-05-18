package d.a.i0.h.a.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.i0.a.p.b.a.n;
import d.a.i0.f.i.r.i;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class e extends EventTargetImpl implements d.a.i0.h.a.f.b {
    @V8JavascriptField
    public String adUnitId;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.f.i.p.b f46937e;

    /* renamed from: f  reason: collision with root package name */
    public String f46938f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46939g;

    /* renamed from: h  reason: collision with root package name */
    public c f46940h;

    /* renamed from: i  reason: collision with root package name */
    public d f46941i;
    public Map<String, String> j;
    public d.a.i0.f.i.l.f k;
    public b l;
    public boolean m;
    public boolean n;
    public d.a.i0.a.w2.c o;
    public d.a.i0.f.i.p.a p;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.f.i.p.a {

        /* renamed from: d.a.i0.h.a.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0996a implements d.a.i0.a.w2.c {
            public C0996a() {
            }

            @Override // d.a.i0.a.w2.c
            public void f() {
                e.this.m = false;
                e.this.f46937e.i0();
            }

            @Override // d.a.i0.a.w2.c
            public void k() {
            }

            @Override // d.a.i0.a.w2.c
            public void n() {
                e.this.m = true;
                if (e.this.n) {
                    e.this.f46937e.P();
                }
            }
        }

        public a() {
        }

        @Override // d.a.i0.f.i.p.a
        public void a(boolean z, String str) {
            if (z) {
                e.this.dispatchEvent(new JSEvent("load"));
                if (e.this.f46940h != null) {
                    e.this.f46940h.c();
                }
                d.a.i0.h.a.f.a.b().c(16, "");
                d.a.i0.h.a.c.b(e.this.N(), "success");
                return;
            }
            if (e.this.f46940h != null) {
                e.this.f46940h.b(str);
            }
            d.a.i0.h.a.f.a.b().c(17, str);
            d.a.i0.h.a.c.c(e.this.N(), "fail", str);
        }

        @Override // d.a.i0.f.i.p.a
        public void b(boolean z, String str) {
            if (z) {
                if (e.this.f46941i != null) {
                    e.this.f46941i.c();
                }
                if (e.this.l == null) {
                    e.this.l = new b(e.this, null);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    AppRuntime.getAppContext().registerReceiver(e.this.l, intentFilter);
                }
                if (e.this.o == null) {
                    e.this.o = new C0996a();
                    e.O(e.this.o);
                }
            } else if (e.this.f46941i != null) {
                e.this.f46941i.b(str);
            }
        }

        @Override // d.a.i0.f.i.p.a
        public void c(boolean z, int i2) {
            JSEvent jSEvent = new JSEvent(IntentConfig.CLOSE);
            jSEvent.data = f.a(z);
            e.this.dispatchEvent(jSEvent);
            d.a.i0.h.a.c.a(e.this.N(), "pageclose", i2);
            e.this.destroy();
        }

        @Override // d.a.i0.f.i.p.a
        public void onClick(int i2) {
            d.a.i0.h.a.c.a(e.this.N(), PrefetchEvent.STATE_CLICK, i2);
        }

        @Override // d.a.i0.f.i.p.a
        public void onError(String str) {
            JSEvent jSEvent = new JSEvent("error");
            jSEvent.data = f.b(str);
            e.this.dispatchEvent(jSEvent);
            d.a.i0.f.i.q.b.k(e.this.j, str);
            e.this.destroy();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                e.this.n = true;
                if (e.this.m) {
                    e.this.f46937e.P();
                }
            } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                e.this.n = false;
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this();
        }
    }

    public e(d.a.i0.a.l0.c cVar, JsObject jsObject) {
        super(cVar);
        this.adUnitId = "";
        this.j = new TreeMap();
        this.n = true;
        this.p = new a();
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.f46938f = G.C("appSid");
        }
        if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.f46938f)) {
            boolean g2 = i.g();
            this.f46939g = g2;
            if (g2) {
                this.f46938f = i.c();
                this.adUnitId = i.d();
            }
            this.j = d.a.i0.f.i.q.b.a("video", "game", this.f46938f, this.adUnitId, this.f46939g);
            this.k = new d.a.i0.h.a.a();
            d.a.i0.f.i.p.b bVar = new d.a.i0.f.i.p.b(d.a.i0.a.g1.f.V().getActivity(), this.f46938f, this.adUnitId, this.f46939g, this.p, this.k);
            this.f46937e = bVar;
            bVar.k0(this.j);
            loadAd(null);
            return;
        }
        cVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void O(d.a.i0.a.w2.c cVar) {
        n X = d.a.i0.a.g1.f.V().X();
        if (X != null) {
            X.e(cVar);
        }
    }

    public static void P(d.a.i0.a.w2.c cVar) {
        n X = d.a.i0.a.g1.f.V().X();
        if (X != null) {
            X.f(cVar);
        }
    }

    public String N() {
        return this.f46939g ? "gdtvideo" : "video";
    }

    public final void destroy() {
        if (this.l != null) {
            AppRuntime.getAppContext().unregisterReceiver(this.l);
            this.l = null;
        }
        d.a.i0.a.w2.c cVar = this.o;
        if (cVar != null) {
            P(cVar);
            this.o = null;
        }
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        this.f46940h = c.d(d.a.i0.a.y.b.a.G(jsObject));
        d.a.i0.h.a.f.a.b().a(this.f46940h);
        if (this.f46937e != null) {
            this.f46937e.e0();
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        d.a.i0.h.a.c.d(N());
        this.f46941i = d.d(d.a.i0.a.y.b.a.G(jsObject));
        if (this.f46937e != null) {
            this.f46937e.l0();
        }
    }
}
