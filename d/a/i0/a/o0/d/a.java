package d.a.i0.a.o0.d;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import java.util.Locale;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43730b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f43731a;

    /* renamed from: d.a.i0.a.o0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0772a extends d.a.i0.a.o0.c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.f.a f43732g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43733h;

        public C0772a(d.a.i0.a.h0.f.a aVar, String str) {
            this.f43732g = aVar;
            this.f43733h = str;
        }

        @Override // d.a.i0.a.o0.c
        public void c() {
            a.this.e(this.f43732g, this.f43733h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.f.a f43735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43736f;

        public b(d.a.i0.a.h0.f.a aVar, String str) {
            this.f43735e = aVar;
            this.f43736f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.e(this.f43735e, this.f43736f);
        }
    }

    public String b(d.a.i0.a.h0.f.a aVar) {
        String format;
        String c2;
        if (aVar == null || TextUtils.isEmpty(this.f43731a)) {
            return null;
        }
        Locale locale = Locale.getDefault();
        if (aVar.isWebView()) {
            format = String.format(locale, "var %s = new Event('%s');", "event", this.f43731a);
            c2 = "";
        } else {
            format = String.format(locale, "var %s = new Object();", "event");
            c2 = d.a.i0.a.o0.a.c("event", "type", this.f43731a);
        }
        return String.format(locale, "javascript:(function(){%s %s %s})();", format, c2 + f("event"), String.format(locale, "%s.dispatchEvent(%s);", d.a.i0.a.o0.a.e(aVar), "event"));
    }

    public void c(d.a.i0.a.h0.f.a aVar) {
        if (aVar == null) {
            return;
        }
        d.a.i0.a.r1.g.a("postMessage", "dispatchJSEvent start.");
        String b2 = b(aVar);
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        d.a.i0.a.r1.g.a("postMessage", "dispatchJSEvent buildEvent");
        if (f43730b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action: " + b2);
        }
        d(aVar, b2);
    }

    public void d(d.a.i0.a.h0.f.a aVar, String str) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.isWebView()) {
            if (d.a.i0.a.r1.l.e.a()) {
                d.a.i0.a.o0.b.b().c(new C0772a(aVar, str), null);
                return;
            } else {
                q0.b0(new b(aVar, str));
                return;
            }
        }
        e(aVar, str);
    }

    public final void e(d.a.i0.a.h0.f.a aVar, String str) {
        if (aVar.isDestroyed()) {
            if (f43730b) {
                Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                return;
            }
            return;
        }
        aVar.evaluateJavascript(str, null);
        d.a.i0.a.r1.g.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    public abstract String f(String str);
}
