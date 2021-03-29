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
    public static final boolean f48323h = k.f45051a;

    /* renamed from: e  reason: collision with root package name */
    public f f48324e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f48325f;

    /* renamed from: g  reason: collision with root package name */
    public e f48326g;

    /* renamed from: d.b.g0.g.k0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0979a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48327e;

        public RunnableC0979a(String str) {
            this.f48327e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48324e == null) {
                a.this.I();
            }
            if (!a.this.f48324e.a()) {
                a.this.f48324e.r();
            }
            a.this.f48324e.loadUrl(this.f48327e);
            a.this.G("open", new d.b.g0.g.k0.j.b(this.f48327e));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48324e == null || !a.this.f48324e.a()) {
                return;
            }
            a.this.f48324e.removeFromParent();
            a.this.f48324e.destroy();
            a.this.f48324e = null;
            a aVar = a.this;
            aVar.G(IntentConfig.CLOSE, new d.b.g0.g.k0.j.b(aVar.f48325f));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48330e;

        public c(String str) {
            this.f48330e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48324e != null) {
                if (TextUtils.equals("1", this.f48330e)) {
                    a.this.f48324e.h(true);
                } else {
                    a.this.f48324e.h(false);
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
        public String f48333a;

        /* renamed from: b  reason: collision with root package name */
        public String f48334b;

        /* renamed from: c  reason: collision with root package name */
        public long f48335c;

        /* renamed from: d  reason: collision with root package name */
        public long f48336d;

        public /* synthetic */ e(String str, String str2, long j, RunnableC0979a runnableC0979a) {
            this(str, str2, j);
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.f48333a + "', mGameName='" + this.f48334b + "', mStartLoadingTimestamp=" + this.f48335c + ", mFinishLoadingTimestamp=" + this.f48336d + '}';
        }

        public e(String str, String str2, long j) {
            this.f48333a = str;
            this.f48334b = str2;
            this.f48335c = j;
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
        if (f48323h) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public final void I() {
        if (this.f48324e == null) {
            f b2 = d.b.g0.a.e0.w.d.L().V().b(d.b.g0.a.w0.a.c());
            this.f48324e = b2;
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
        if (this.f48326g == null) {
            if (f48323h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            if (f48323h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.f48326g.f48336d = System.currentTimeMillis();
        if (f48323h) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.f48326g);
        }
        d.b.g0.g.k0.j.d.a(O, this.f48326g);
        this.f48326g = null;
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
            this.f48326g = new e(B, B2, System.currentTimeMillis(), null);
            if (f48323h) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.f48326g);
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
            if (f48323h) {
                Log.i("GameWebViewApi", "open:" + C);
            }
            this.f48325f = C;
            k0.X(new RunnableC0979a(C));
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
