package d.a.m0.h.o0.h;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.view.webview.GameWebViewManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.a.k;
import d.a.m0.a.p.e.f;
import d.a.m0.a.v2.q0;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f51414h = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public f f51415e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f51416f;

    /* renamed from: g  reason: collision with root package name */
    public e f51417g;

    /* renamed from: d.a.m0.h.o0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1106a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51418e;

        public RunnableC1106a(String str) {
            this.f51418e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51415e == null) {
                a.this.H();
            }
            if (!a.this.f51415e.d()) {
                a.this.f51415e.J();
            }
            a.this.f51415e.loadUrl(this.f51418e);
            a.this.F("open", new d.a.m0.h.o0.h.b(this.f51418e));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51415e == null || !a.this.f51415e.d()) {
                return;
            }
            a.this.f51415e.removeFromParent();
            a.this.f51415e.destroy();
            a.this.f51415e = null;
            a aVar = a.this;
            aVar.F(IntentConfig.CLOSE, new d.a.m0.h.o0.h.b(aVar.f51416f));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51421e;

        public c(String str) {
            this.f51421e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51415e != null) {
                if (TextUtils.equals("1", this.f51421e)) {
                    a.this.f51415e.h(true);
                } else {
                    a.this.f51415e.h(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.close();
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f51424a;

        /* renamed from: b  reason: collision with root package name */
        public String f51425b;

        /* renamed from: c  reason: collision with root package name */
        public long f51426c;

        /* renamed from: d  reason: collision with root package name */
        public long f51427d;

        public /* synthetic */ e(String str, String str2, long j, RunnableC1106a runnableC1106a) {
            this(str, str2, j);
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.f51424a + "', mGameName='" + this.f51425b + "', mStartLoadingTimestamp=" + this.f51426c + ", mFinishLoadingTimestamp=" + this.f51427d + '}';
        }

        public e(String str, String str2, long j) {
            this.f51424a = str;
            this.f51425b = str2;
            this.f51426c = j;
        }
    }

    public a(d.a.m0.a.l0.c cVar) {
        super(cVar);
    }

    public static a G() {
        d.a.m0.a.l0.a n = d.a.m0.h.o.c.m().n();
        if (n == null) {
            return null;
        }
        EventTarget p = n.p();
        if (p instanceof d.a.m0.h.d.b) {
            return ((d.a.m0.h.d.b) p).getWebViewManager();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final d.a.m0.h.o0.h.c E(String str, @NonNull String str2) {
        char c2;
        switch (str2.hashCode()) {
            case 1507424:
                if (str2.equals("1001")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1507425:
                if (str2.equals("1002")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                return null;
            }
            return new d.a.m0.h.o0.h.c(str, str2, "open:host not in white list");
        }
        return new d.a.m0.h.o0.h.c(str, str2, "open:url is invalid");
    }

    public final void F(String str, Object obj) {
        if (f51414h) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public final void H() {
        if (this.f51415e == null) {
            GameWebViewManager gameWebViewManager = new GameWebViewManager(d.a.m0.a.c1.a.b());
            this.f51415e = gameWebViewManager;
            gameWebViewManager.j(new d());
        }
    }

    public final boolean I(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.startsWith("http://") || lowerCase.startsWith("https://");
    }

    public void J() {
        if (this.f51417g == null) {
            if (f51414h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            if (f51414h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.f51417g.f51427d = System.currentTimeMillis();
        if (f51414h) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.f51417g);
        }
        d.a.m0.h.o0.h.d.a(Q, this.f51417g);
        this.f51417g = null;
    }

    @JavascriptInterface
    public void close() {
        q0.b0(new b());
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        String C = G.C("gameId");
        String C2 = G.C("gameName");
        if (!TextUtils.isEmpty(C) && !TextUtils.isEmpty(C2)) {
            this.f51417g = new e(C, C2, System.currentTimeMillis(), null);
            if (f51414h) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.f51417g);
            }
            d.a.m0.h.m0.c.a(G, true, null);
            return;
        }
        d.a.m0.h.m0.c.a(G, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            F("error", E(null, "1001"));
            return;
        }
        String D = G.D("url", null);
        if (!I(D)) {
            F("error", E(D, "1001"));
        } else if (!d.a.m0.a.b2.a.b.h(D)) {
            F("error", E(D, "1002"));
        } else {
            if (f51414h) {
                Log.i("GameWebViewApi", "open:" + D);
            }
            this.f51416f = D;
            q0.b0(new RunnableC1106a(D));
        }
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            F("error", E(null, "1001"));
        } else {
            q0.b0(new c(G.D("setCloseViewVisibility", null)));
        }
    }
}
