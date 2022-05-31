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
public class sa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable pa4<JSONArray> pa4Var, @Nullable pa4<JSONObject> pa4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, pa4Var, pa4Var2)) == null) ? b(Node.values(), pa4Var, pa4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable pa4<JSONArray> pa4Var, @Nullable pa4<JSONObject> pa4Var2) {
        InterceptResult invokeLLL;
        ra4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, pa4Var, pa4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(pa4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(pa4Var2));
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

    public static void c(JSONObject jSONObject, a74 a74Var, @Nullable a74 a74Var2, @Nullable a74 a74Var3) {
        o64 b;
        qa4 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, jSONObject, a74Var, a74Var2, a74Var3) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = ta4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), a74Var, a74Var2, a74Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), a74Var, a74Var2, a74Var3);
                }
            }
        }
        if (!lb4.a || (b = q64.b()) == null) {
            return;
        }
        b.C();
    }
}
