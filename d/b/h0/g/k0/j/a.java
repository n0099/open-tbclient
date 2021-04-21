package d.b.h0.g.k0.j;

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
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.p.d.f;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49044h = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public f f49045e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f49046f;

    /* renamed from: g  reason: collision with root package name */
    public e f49047g;

    /* renamed from: d.b.h0.g.k0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1011a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49048e;

        public RunnableC1011a(String str) {
            this.f49048e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49045e == null) {
                a.this.I();
            }
            if (!a.this.f49045e.a()) {
                a.this.f49045e.r();
            }
            a.this.f49045e.loadUrl(this.f49048e);
            a.this.G("open", new d.b.h0.g.k0.j.b(this.f49048e));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49045e == null || !a.this.f49045e.a()) {
                return;
            }
            a.this.f49045e.removeFromParent();
            a.this.f49045e.destroy();
            a.this.f49045e = null;
            a aVar = a.this;
            aVar.G(IntentConfig.CLOSE, new d.b.h0.g.k0.j.b(aVar.f49046f));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49051e;

        public c(String str) {
            this.f49051e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49045e != null) {
                if (TextUtils.equals("1", this.f49051e)) {
                    a.this.f49045e.h(true);
                } else {
                    a.this.f49045e.h(false);
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
        public String f49054a;

        /* renamed from: b  reason: collision with root package name */
        public String f49055b;

        /* renamed from: c  reason: collision with root package name */
        public long f49056c;

        /* renamed from: d  reason: collision with root package name */
        public long f49057d;

        public /* synthetic */ e(String str, String str2, long j, RunnableC1011a runnableC1011a) {
            this(str, str2, j);
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.f49054a + "', mGameName='" + this.f49055b + "', mStartLoadingTimestamp=" + this.f49056c + ", mFinishLoadingTimestamp=" + this.f49057d + '}';
        }

        public e(String str, String str2, long j) {
            this.f49054a = str;
            this.f49055b = str2;
            this.f49056c = j;
        }
    }

    public a(d.b.h0.g.i.b bVar) {
        super(bVar);
    }

    public static a H() {
        d.b.h0.g.i.a n = d.b.h0.g.m.a.m().n();
        if (n == null) {
            return null;
        }
        EventTarget t = n.t();
        if (t instanceof d.b.h0.g.e.c) {
            return ((d.b.h0.g.e.c) t).getWebViewManager();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final d.b.h0.g.k0.j.c F(String str, @NonNull String str2) {
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
            return new d.b.h0.g.k0.j.c(str, str2, "open:host not in white list");
        }
        return new d.b.h0.g.k0.j.c(str, str2, "open:url is invalid");
    }

    public final void G(String str, Object obj) {
        if (f49044h) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public final void I() {
        if (this.f49045e == null) {
            f b2 = d.b.h0.a.e0.w.d.L().V().b(d.b.h0.a.w0.a.c());
            this.f49045e = b2;
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
        if (this.f49047g == null) {
            if (f49044h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null) {
            if (f49044h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.f49047g.f49057d = System.currentTimeMillis();
        if (f49044h) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.f49047g);
        }
        d.b.h0.g.k0.j.d.a(O, this.f49047g);
        this.f49047g = null;
    }

    @JavascriptInterface
    public void close() {
        k0.X(new b());
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        String B = F.B("gameId");
        String B2 = F.B("gameName");
        if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(B2)) {
            this.f49047g = new e(B, B2, System.currentTimeMillis(), null);
            if (f49044h) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.f49047g);
            }
            d.b.h0.g.i0.b.a(F, true, null);
            return;
        }
        d.b.h0.g.i0.b.a(F, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            G("error", F(null, "1001"));
            return;
        }
        String C = F.C("url", null);
        if (!J(C)) {
            G("error", F(C, "1001"));
        } else if (!d.b.h0.a.s1.a.b.h(C)) {
            G("error", F(C, "1002"));
        } else {
            if (f49044h) {
                Log.i("GameWebViewApi", "open:" + C);
            }
            this.f49046f = C;
            k0.X(new RunnableC1011a(C));
        }
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            G("error", F(null, "1001"));
        } else {
            k0.X(new c(F.C("setCloseViewVisibility", null)));
        }
    }
}
