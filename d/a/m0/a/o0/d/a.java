package d.a.m0.a.o0.d;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import java.util.Locale;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47688b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f47689a;

    /* renamed from: d.a.m0.a.o0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0842a extends d.a.m0.a.o0.c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.f.a f47690g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47691h;

        public C0842a(d.a.m0.a.h0.f.a aVar, String str) {
            this.f47690g = aVar;
            this.f47691h = str;
        }

        @Override // d.a.m0.a.o0.c
        public void c() {
            a.this.e(this.f47690g, this.f47691h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.f.a f47693e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47694f;

        public b(d.a.m0.a.h0.f.a aVar, String str) {
            this.f47693e = aVar;
            this.f47694f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.e(this.f47693e, this.f47694f);
        }
    }

    public String b(d.a.m0.a.h0.f.a aVar) {
        String format;
        String c2;
        if (aVar == null || TextUtils.isEmpty(this.f47689a)) {
            return null;
        }
        Locale locale = Locale.getDefault();
        if (aVar.isWebView()) {
            format = String.format(locale, "var %s = new Event('%s');", "event", this.f47689a);
            c2 = "";
        } else {
            format = String.format(locale, "var %s = new Object();", "event");
            c2 = d.a.m0.a.o0.a.c("event", "type", this.f47689a);
        }
        return String.format(locale, "javascript:(function(){%s %s %s})();", format, c2 + f("event"), String.format(locale, "%s.dispatchEvent(%s);", d.a.m0.a.o0.a.e(aVar), "event"));
    }

    public void c(d.a.m0.a.h0.f.a aVar) {
        if (aVar == null) {
            return;
        }
        d.a.m0.a.r1.g.a("postMessage", "dispatchJSEvent start.");
        String b2 = b(aVar);
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        d.a.m0.a.r1.g.a("postMessage", "dispatchJSEvent buildEvent");
        if (f47688b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action: " + b2);
        }
        d(aVar, b2);
    }

    public void d(d.a.m0.a.h0.f.a aVar, String str) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.isWebView()) {
            if (d.a.m0.a.r1.l.e.a()) {
                d.a.m0.a.o0.b.b().c(new C0842a(aVar, str), null);
                return;
            } else {
                q0.b0(new b(aVar, str));
                return;
            }
        }
        e(aVar, str);
    }

    public final void e(d.a.m0.a.h0.f.a aVar, String str) {
        if (aVar.isDestroyed()) {
            if (f47688b) {
                Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                return;
            }
            return;
        }
        aVar.evaluateJavascript(str, null);
        d.a.m0.a.r1.g.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    public abstract String f(String str);
}
