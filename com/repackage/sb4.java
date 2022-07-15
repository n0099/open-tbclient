package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable pb4<JSONArray> pb4Var, @Nullable pb4<JSONObject> pb4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, pb4Var, pb4Var2)) == null) ? b(Node.values(), pb4Var, pb4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable pb4<JSONArray> pb4Var, @Nullable pb4<JSONObject> pb4Var2) {
        InterceptResult invokeLLL;
        rb4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, pb4Var, pb4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(pb4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(pb4Var2));
                        }
                    }
                }
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void c(JSONObject jSONObject, a84 a84Var, @Nullable a84 a84Var2, @Nullable a84 a84Var3) {
        o74 b;
        qb4 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, jSONObject, a84Var, a84Var2, a84Var3) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = tb4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), a84Var, a84Var2, a84Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), a84Var, a84Var2, a84Var3);
                }
            }
        }
        if (!lc4.a || (b = q74.b()) == null) {
            return;
        }
        b.C();
    }
}
