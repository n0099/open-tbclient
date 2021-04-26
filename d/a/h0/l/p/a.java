package d.a.h0.l.p;

import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.a.h0.l.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static void a(int i2, String str, String str2, int i3, JSONObject jSONObject) {
        f.b().t(b(i2), str, str2, i3, jSONObject);
    }

    public static String b(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : "swanplugin" : "swandynamiclib" : "swangameconsole" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
    }
}
