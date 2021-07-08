package d.a.n0.n.j;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.n.j.i.l;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable c<JSONArray> cVar, @Nullable c<JSONObject> cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cVar, cVar2)) == null) ? b(Node.values(), cVar, cVar2) : (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable c<JSONArray> cVar, @Nullable c<JSONObject> cVar2) {
        InterceptResult invokeLLL;
        e provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, cVar, cVar2)) == null) {
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
                if (d.a.n0.n.c.f50608a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void c(JSONObject jSONObject, d.a.n0.n.f.g gVar, @Nullable d.a.n0.n.f.g gVar2, @Nullable d.a.n0.n.f.g gVar3) {
        d.a.n0.n.a b2;
        d a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, jSONObject, gVar, gVar2, gVar3) == null) || jSONObject == null) {
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
        if (!l.f50778a || (b2 = d.a.n0.n.c.b()) == null) {
            return;
        }
        b2.z();
    }
}
