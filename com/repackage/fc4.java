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
/* loaded from: classes6.dex */
public class fc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable cc4<JSONArray> cc4Var, @Nullable cc4<JSONObject> cc4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cc4Var, cc4Var2)) == null) ? b(Node.values(), cc4Var, cc4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable cc4<JSONArray> cc4Var, @Nullable cc4<JSONObject> cc4Var2) {
        InterceptResult invokeLLL;
        ec4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, cc4Var, cc4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(cc4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(cc4Var2));
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

    public static void c(JSONObject jSONObject, n84 n84Var, @Nullable n84 n84Var2, @Nullable n84 n84Var3) {
        b84 b;
        dc4 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, jSONObject, n84Var, n84Var2, n84Var3) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = gc4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), n84Var, n84Var2, n84Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), n84Var, n84Var2, n84Var3);
                }
            }
        }
        if (!yc4.a || (b = d84.b()) == null) {
            return;
        }
        b.C();
    }
}
