package d.a.h0.g.k0.j;

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
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.p.d.f;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46521h = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public f f46522e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f46523f;

    /* renamed from: g  reason: collision with root package name */
    public e f46524g;

    /* renamed from: d.a.h0.g.k0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0950a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46525e;

        public RunnableC0950a(String str) {
            this.f46525e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46522e == null) {
                a.this.I();
            }
            if (!a.this.f46522e.a()) {
                a.this.f46522e.H();
            }
            a.this.f46522e.loadUrl(this.f46525e);
            a.this.G("open", new d.a.h0.g.k0.j.b(this.f46525e));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46522e == null || !a.this.f46522e.a()) {
                return;
            }
            a.this.f46522e.removeFromParent();
            a.this.f46522e.destroy();
            a.this.f46522e = null;
            a aVar = a.this;
            aVar.G(IntentConfig.CLOSE, new d.a.h0.g.k0.j.b(aVar.f46523f));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46528e;

        public c(String str) {
            this.f46528e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46522e != null) {
                if (TextUtils.equals("1", this.f46528e)) {
                    a.this.f46522e.h(true);
                } else {
                    a.this.f46522e.h(false);
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
        public String f46531a;

        /* renamed from: b  reason: collision with root package name */
        public String f46532b;

        /* renamed from: c  reason: collision with root package name */
        public long f46533c;

        /* renamed from: d  reason: collision with root package name */
        public long f46534d;

        public /* synthetic */ e(String str, String str2, long j, RunnableC0950a runnableC0950a) {
            this(str, str2, j);
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.f46531a + "', mGameName='" + this.f46532b + "', mStartLoadingTimestamp=" + this.f46533c + ", mFinishLoadingTimestamp=" + this.f46534d + '}';
        }

        public e(String str, String str2, long j) {
            this.f46531a = str;
            this.f46532b = str2;
            this.f46533c = j;
        }
    }

    public a(d.a.h0.g.i.b bVar) {
        super(bVar);
    }

    public static a H() {
        d.a.h0.g.i.a n = d.a.h0.g.m.a.m().n();
        if (n == null) {
            return null;
        }
        EventTarget o = n.o();
        if (o instanceof d.a.h0.g.e.c) {
            return ((d.a.h0.g.e.c) o).getWebViewManager();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final d.a.h0.g.k0.j.c F(String str, @NonNull String str2) {
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
            return new d.a.h0.g.k0.j.c(str, str2, "open:host not in white list");
        }
        return new d.a.h0.g.k0.j.c(str, str2, "open:url is invalid");
    }

    public final void G(String str, Object obj) {
        if (f46521h) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public final void I() {
        if (this.f46522e == null) {
            f a2 = d.a.h0.a.e0.w.d.L().V().a(d.a.h0.a.w0.a.c());
            this.f46522e = a2;
            a2.i(new d());
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
        if (this.f46524g == null) {
            if (f46521h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            if (f46521h) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.f46524g.f46534d = System.currentTimeMillis();
        if (f46521h) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.f46524g);
        }
        d.a.h0.g.k0.j.d.a(O, this.f46524g);
        this.f46524g = null;
    }

    @JavascriptInterface
    public void close() {
        k0.X(new b());
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        String B = F.B("gameId");
        String B2 = F.B("gameName");
        if (!TextUtils.isEmpty(B) && !TextUtils.isEmpty(B2)) {
            this.f46524g = new e(B, B2, System.currentTimeMillis(), null);
            if (f46521h) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.f46524g);
            }
            d.a.h0.g.i0.b.a(F, true, null);
            return;
        }
        d.a.h0.g.i0.b.a(F, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            G("error", F(null, "1001"));
            return;
        }
        String C = F.C("url", null);
        if (!J(C)) {
            G("error", F(C, "1001"));
        } else if (!d.a.h0.a.s1.a.b.h(C)) {
            G("error", F(C, "1002"));
        } else {
            if (f46521h) {
                Log.i("GameWebViewApi", "open:" + C);
            }
            this.f46523f = C;
            k0.X(new RunnableC0950a(C));
        }
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            G("error", F(null, "1001"));
        } else {
            k0.X(new c(F.C("setCloseViewVisibility", null)));
        }
    }
}
