package d.b.g0.l.p;

import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.b.g0.l.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static void a(int i, String str, String str2, int i2, JSONObject jSONObject) {
        f.b().z(b(i), str, str2, i2, jSONObject);
    }

    public static String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "swanplugin" : "swandynamiclib" : "swangameconsole" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
    }
}
