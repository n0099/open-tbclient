package d.a.l0.a.o0.d;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.Locale;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47580b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f47581a;

    /* renamed from: d.a.l0.a.o0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0839a extends d.a.l0.a.o0.c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.f.a f47582g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47583h;

        public C0839a(d.a.l0.a.h0.f.a aVar, String str) {
            this.f47582g = aVar;
            this.f47583h = str;
        }

        @Override // d.a.l0.a.o0.c
        public void c() {
            a.this.e(this.f47582g, this.f47583h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.f.a f47585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47586f;

        public b(d.a.l0.a.h0.f.a aVar, String str) {
            this.f47585e = aVar;
            this.f47586f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.e(this.f47585e, this.f47586f);
        }
    }

    public String b(d.a.l0.a.h0.f.a aVar) {
        String format;
        String c2;
        if (aVar == null || TextUtils.isEmpty(this.f47581a)) {
            return null;
        }
        Locale locale = Locale.getDefault();
        if (aVar.isWebView()) {
            format = String.format(locale, "var %s = new Event('%s');", "event", this.f47581a);
            c2 = "";
        } else {
            format = String.format(locale, "var %s = new Object();", "event");
            c2 = d.a.l0.a.o0.a.c("event", "type", this.f47581a);
        }
        return String.format(locale, "javascript:(function(){%s %s %s})();", format, c2 + f("event"), String.format(locale, "%s.dispatchEvent(%s);", d.a.l0.a.o0.a.e(aVar), "event"));
    }

    public void c(d.a.l0.a.h0.f.a aVar) {
        if (aVar == null) {
            return;
        }
        d.a.l0.a.r1.g.a("postMessage", "dispatchJSEvent start.");
        String b2 = b(aVar);
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        d.a.l0.a.r1.g.a("postMessage", "dispatchJSEvent buildEvent");
        if (f47580b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action: " + b2);
        }
        d(aVar, b2);
    }

    public void d(d.a.l0.a.h0.f.a aVar, String str) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.isWebView()) {
            if (d.a.l0.a.r1.l.e.a()) {
                d.a.l0.a.o0.b.b().c(new C0839a(aVar, str), null);
                return;
            } else {
                q0.b0(new b(aVar, str));
                return;
            }
        }
        e(aVar, str);
    }

    public final void e(d.a.l0.a.h0.f.a aVar, String str) {
        if (aVar.isDestroyed()) {
            if (f47580b) {
                Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                return;
            }
            return;
        }
        aVar.evaluateJavascript(str, null);
        d.a.l0.a.r1.g.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    public abstract String f(String str);
}
