package d.a.l0.n.j;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.node.Node;
import d.a.l0.n.j.i.l;
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
            if (d.a.l0.n.c.f47984a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void c(JSONObject jSONObject, d.a.l0.n.f.g gVar, @Nullable d.a.l0.n.f.g gVar2, @Nullable d.a.l0.n.f.g gVar3) {
        d.a.l0.n.a b2;
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
        if (!l.f48154a || (b2 = d.a.l0.n.c.b()) == null) {
            return;
        }
        b2.z();
    }
}
