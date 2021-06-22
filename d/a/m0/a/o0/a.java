package d.a.m0.a.o0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public static void a(d.a.m0.a.h0.f.a aVar, d.a.m0.a.o0.d.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return;
        }
        aVar2.c(aVar);
    }

    @NonNull
    public static String b(@Nullable String str, @Nullable String str2, @Nullable Object obj) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || obj == null) {
            return "";
        }
        if (!(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Long) && !(obj instanceof Boolean)) {
            return c(str, str2, String.valueOf(obj));
        }
        return str + "." + str2 + " = " + obj + ";";
    }

    public static String c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        String quote = JSONObject.quote(str3);
        return str + "." + str2 + " = " + quote + ";";
    }

    public static String d(String str, String str2, JSONObject jSONObject) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || jSONObject == null) ? "" : String.format(Locale.getDefault(), "%s.%s = %s;", str, str2, jSONObject);
    }

    public static String e(d.a.m0.a.h0.f.a aVar) {
        return aVar.isWebView() ? "document" : SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME;
    }
}
