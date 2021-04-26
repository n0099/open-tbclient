package d.a.h0.l.m;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.node.Node;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static JSONObject a(@Nullable c<JSONArray> cVar, @Nullable c<JSONObject> cVar2) {
        return b(Node.values(), cVar, cVar2);
    }

    public static JSONObject b(Node[] nodeArr, @Nullable c<JSONArray> cVar, @Nullable c<JSONObject> cVar2) {
        e provider;
        if (nodeArr == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Node node : nodeArr) {
                if (node != null && (provider = Node.getProvider(node)) != null) {
                    if (node.isDataArray()) {
                        jSONObject.put(node.getName(), provider.b(cVar));
                    } else {
                        jSONObject.put(node.getName(), provider.a(cVar2));
                    }
                }
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (d.a.h0.l.f.f47117a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void c(JSONObject jSONObject, d.a.h0.l.h.g gVar, @Nullable d.a.h0.l.h.g gVar2, @Nullable d.a.h0.l.h.g gVar3) {
        d a2;
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a2 = g.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a2.a(jSONObject.optJSONArray(next), gVar, gVar2, gVar3);
                } else {
                    a2.b(jSONObject.optJSONObject(next), gVar, gVar2, gVar3);
                }
            }
        }
    }
}
