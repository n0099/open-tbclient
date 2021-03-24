package d.b.g0.g.k0.j;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.p.d.f;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f48322h = k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public f f48323e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f48324f;

    /* renamed from: g  reason: collision with root package name */
    public e f48325g;

    /* renamed from: d.b.g0.g.k0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0978a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48326e;

        public RunnableC0978a(String str) {
            this.f48326e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48323e == null) {
                a.this.I();
            }
            if (!a.this.f48323e.a()) {
                a.this.f48323e.r();
            }
            a.this.f48323e.loadUrl(this.f48326e);
            a.this.G("open", new d.b.g0.g.k0.j.b(this.f48326e));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48323e == null || !a.this.f48323e.a()) {
                return;
            }
            a.this.f48323e.removeFromParent();
            a.this.f48323e.destroy();
            a.this.f48323e = null;
            a aVar = a.this;
            aVar.G(IntentConfig.CLOSE, new d.b.g0.g.k0.j.b(aVar.f48324f));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48329e;

        public c(String str) {
            this.f48329e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48323e != null) {
                if (TextUtils.equals("1", this.f48329e)) {
                    a.this.f48323e.h(true);
                } else {
                    a.this.f48323e.h(false);
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
        public String f48332a;

        /* renamed from: b  reason: collision with root package name */
        public String f48333b;

        /* renamed from: c  reason: collision with root package name */
        public long f48334c;

        /* renamed from: d  reason: collision with root package name */
        public long f48335d;

        public /* synthetic */ e(String str, String str2, long j, RunnableC0978a runnableC0978a) {
            this(str, str2, j);
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.f48332a + "', mGameName='" + this.f48333b + "', mStartLoadingTimestamp=" + this.f48334c + ", mFinishLoadingTimestamp=" + this.f48335d + '}';
        }

        public e(String str, String str2, long j) {
            this.f48332a = str;
            this.f48333b = str2;
            this.f48334c = j;
        }
    }

    public a(d.b.g0.g.i.b bVar) {
        super(bVar);
    }

    public static a H() {
        d.b.g0.g.i.a n = d.b.g0.g.m.a.m().n();
        if (n == null) {
            return null;
        }
        EventTarget t = n.t();
        if (t instanceof d.b.g0.g.e.c) {
            return ((d.b.g0.g.e.c) t).getWebViewManager();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final d.b.g0.g.k0.j.c F(String str, @NonNull String str2) {
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
            return new d.b.g0.g.k0.j.c(str, str2, "open:host not in white list");
        }
        return new d.b.g0.g.k0.j.c(str, str2, "open:url is invalid");
    }

    public final void G(String str, Object obj) {
        if (f48322h) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public final void I() {
        if (this.f48323e == null) {
            f b2 = d.b.g0.a.e0.w.d.L().V().b(d.b.g0.a.w0.a.c());
            this.f48323e = b2;
            b2.i(new d());
        }
    }

    public final boolean J(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.startsWith("http://") || lowerCase.startsWith("https://");
    }

    public void K() {
        if (this.f48325g == null) {
            if (f48322h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            if (f48322h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.f48325g.f48335d = System.currentTimeMillis();
        if (f48322h) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.f48325g);
        }
        d.b.g0.g.k0.j.d.a(O, this.f48325g);
        this.f48325g = null;
    }

    @JavascriptInterface
    public void close() {
        k0.X(new b());
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        String B = F.B("gameId");
        String B2 = F.B("gameName");
        if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(B2)) {
            this.f48325g = new e(B, B2, System.currentTimeMillis(), null);
            if (f48322h) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.f48325g);
            }
            d.b.g0.g.i0.b.a(F, true, null);
            return;
        }
        d.b.g0.g.i0.b.a(F, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            G("error", F(null, "1001"));
            return;
        }
        String C = F.C("url", null);
        if (!J(C)) {
            G("error", F(C, "1001"));
        } else if (!d.b.g0.a.s1.a.b.h(C)) {
            G("error", F(C, "1002"));
        } else {
            if (f48322h) {
                Log.i("GameWebViewApi", "open:" + C);
            }
            this.f48324f = C;
            k0.X(new RunnableC0978a(C));
        }
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            G("error", F(null, "1001"));
        } else {
            k0.X(new c(F.C("setCloseViewVisibility", null)));
        }
    }
}
