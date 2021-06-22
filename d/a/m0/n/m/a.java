package d.a.m0.n.m;

import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.a.m0.n.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static void a(int i2, String str, String str2, int i3, JSONObject jSONObject) {
        c.b().G(b(i2), str, str2, i3, jSONObject, c(str, i3));
    }

    public static String b(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : "swanplugin" : "swandynamiclib" : "swangameconsole" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
    }

    public static boolean c(String str, int i2) {
        return TextUtils.equals(str, "cs_protocol") && (i2 != 2000);
    }
}
