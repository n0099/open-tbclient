package d.b.h0.a.k0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.landingpage.XDetailPageJavaScript;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import d.b.h0.a.i2.k0;
import d.b.h0.a.j1.h;
import d.b.h0.a.j1.m.c;
import d.b.h0.a.k;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45774a = k.f45772a;

    /* renamed from: d.b.h0.a.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0749a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.k.a f45775e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45776f;

        public RunnableC0749a(d.b.h0.a.e0.k.a aVar, String str) {
            this.f45775e = aVar;
            this.f45776f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.c(this.f45775e, this.f45776f);
        }
    }

    public static void b(d.b.h0.a.e0.k.a aVar, d.b.h0.a.k0.b.a aVar2) {
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
                str = "var event = new Event('" + aVar2.f45777a + "');";
            } else {
                str = "var event = new Object();";
                str2 = e("event", "type", aVar2.f45777a);
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
            stringBuffer.append(XDetailPageJavaScript.STATIC_JAVASCRIPT_FUNC_OVER);
            format2 = stringBuffer.toString();
        } else {
            if (aVar.isWebView()) {
                format = String.format(Locale.getDefault(), "var %s = new Event('%s');", "event", aVar2.f45777a);
            } else {
                format = String.format(Locale.getDefault(), "var %s = new Object();", "event");
                str2 = e("event", "type", aVar2.f45777a);
            }
            format2 = String.format(Locale.getDefault(), "javascript:(function(){%s %s %s})();", format, str2 + aVar2.a("event"), String.format(Locale.getDefault(), "%s.dispatchEvent(%s);", g(aVar), "event"));
        }
        h.a("postMessage", "dispatchJSEvent buildEvent");
        if (f45774a) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action: " + format2);
        }
        if (aVar.isWebView()) {
            k0.X(new RunnableC0749a(aVar, format2));
        } else {
            c(aVar, format2);
        }
    }

    public static void c(d.b.h0.a.e0.k.a aVar, String str) {
        if (aVar.isDestroyed()) {
            if (f45774a) {
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

    public static String g(d.b.h0.a.e0.k.a aVar) {
        return aVar.isWebView() ? "document" : SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME;
    }
}
