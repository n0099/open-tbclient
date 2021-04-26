package d.r.b.a.a.i.g;

import d.r.b.a.a.f.d.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static Map<String, Object> a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next));
            }
            return hashMap;
        } catch (Exception e2) {
            d.e("JsonUtils", "getMapForJson Exception:" + e2.getLocalizedMessage(), new Object[0]);
            return null;
        }
    }
}
