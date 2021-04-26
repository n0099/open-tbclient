package d.a.a0.k.b;

import android.content.Context;
import android.content.pm.PackageManager;
import com.heytap.mcssdk.mode.CommandMessage;
import d.a.a0.n.g;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    public static final void a(d.a.a0.k.a.c cVar) {
        if (cVar != null) {
            cVar.e("channel", "cashiersdk");
            cVar.e("deviceType", "ANDROID");
            cVar.e(CommandMessage.SDK_VERSION, "2.7.4");
            cVar.e("appVersion", d());
            cVar.e("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        }
    }

    public static final void b(d.a.a0.k.a.c cVar, String str) {
        if (cVar != null) {
            boolean z = false;
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                return;
            }
            String b2 = cVar.b("Cookie");
            String str2 = "BDUSS=" + str;
            if ((b2 == null || StringsKt__StringsJVMKt.isBlank(b2)) ? true : true) {
                cVar.e("Cookie", str2);
                return;
            }
            cVar.e("Cookie", b2 + "; " + str2);
        }
    }

    public static final d.a.a0.k.a.b c(JSONObject jSONObject) {
        d.a.a0.k.a.b bVar = new d.a.a0.k.a.b();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bVar.e(next, jSONObject.optString(next));
            }
        }
        return bVar;
    }

    public static final String d() {
        Context a2 = g.a();
        Intrinsics.checkExpressionValueIsNotNull(a2, "SdkRunTime.getAppContext()");
        PackageManager packageManager = a2.getPackageManager();
        try {
            Context a3 = g.a();
            Intrinsics.checkExpressionValueIsNotNull(a3, "SdkRunTime.getAppContext()");
            String str = packageManager.getPackageInfo(a3.getPackageName(), 0).versionName;
            Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.versionName");
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
