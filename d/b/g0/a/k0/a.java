package d.b.g0.a.k0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.h;
import d.b.g0.a.j1.m.c;
import d.b.g0.a.k;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45053a = k.f45051a;

    /* renamed from: d.b.g0.a.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0717a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.k.a f45054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45055f;

        public RunnableC0717a(d.b.g0.a.e0.k.a aVar, String str) {
            this.f45054e = aVar;
            this.f45055f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.c(this.f45054e, this.f45055f);
        }
    }

    public static void b(d.b.g0.a.e0.k.a aVar, d.b.g0.a.k0.b.a aVar2) {
        String format;
        String format2;
        String str;
        if (aVar == null || aVar2 == null) {
            return;
        }
        h.a("postMessage", "dispatchJSEvent start.");
        String str2 = "";
        if (c.e()) {
            if (aVar.isWebView()) {
                str = "var event = new Event('" + aVar2.f45056a + "');";
            } else {
                str = "var event = new Object();";
                str2 = e("event", "type", aVar2.f45056a);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("javascript:(function(){");
            stringBuffer.append(str);
            stringBuffer.append(" ");
            stringBuffer.append(str2);
            stringBuffer.append(aVar2.a("event"));
            stringBuffer.append(" ");
            stringBuffer.append(g(aVar));
            stringBuffer.append(".dispatchEvent(");
            stringBuffer.append("event");
            stringBuffer.append(");");
            stringBuffer.append("})();");
            format2 = stringBuffer.toString();
        } else {
            if (aVar.isWebView()) {
                format = String.format(Locale.getDefault(), "var %s = new Event('%s');", "event", aVar2.f45056a);
            } else {
                format = String.format(Locale.getDefault(), "var %s = new Object();", "event");
                str2 = e("event", "type", aVar2.f45056a);
            }
            format2 = String.format(Locale.getDefault(), "javascript:(function(){%s %s %s})();", format, str2 + aVar2.a("event"), String.format(Locale.getDefault(), "%s.dispatchEvent(%s);", g(aVar), "event"));
        }
        h.a("postMessage", "dispatchJSEvent buildEvent");
        if (f45053a) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action: " + format2);
        }
        if (aVar.isWebView()) {
            k0.X(new RunnableC0717a(aVar, format2));
        } else {
            c(aVar, format2);
        }
    }

    public static void c(d.b.g0.a.e0.k.a aVar, String str) {
        if (aVar.isDestroyed()) {
            if (f45053a) {
                Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                return;
            }
            return;
        }
        aVar.evaluateJavascript(str, null);
        h.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    @NonNull
    public static String d(@Nullable String str, @Nullable String str2, @Nullable Object obj) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || obj == null) {
            return "";
        }
        if (!(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Long) && !(obj instanceof Boolean)) {
            return e(str, str2, String.valueOf(obj));
        }
        if (c.e()) {
            return str + "." + str2 + " = " + obj + ";";
        }
        return String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, obj);
    }

    public static String e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        String quote = JSONObject.quote(str3);
        if (c.e()) {
            return str + "." + str2 + " = " + quote + ";";
        }
        return String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, quote);
    }

    public static String f(String str, String str2, JSONObject jSONObject) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jSONObject == null) ? "" : String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, jSONObject);
    }

    public static String g(d.b.g0.a.e0.k.a aVar) {
        return aVar.isWebView() ? "document" : SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME;
    }
}
