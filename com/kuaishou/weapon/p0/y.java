package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public JSONArray a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                String a = h1.a();
                if (!TextUtils.isEmpty(a) && !a.startsWith("RISK")) {
                    JSONArray jSONArray2 = new JSONArray(a);
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("1", jSONArray2.getJSONObject(i).getString("appName"));
                        jSONObject.put("2", jSONArray2.getJSONObject(i).getString("pkgName"));
                        jSONObject.put("3", jSONArray2.getJSONObject(i).getString("appVersion"));
                        jSONObject.put("5", jSONArray2.getJSONObject(i).getString("system_app"));
                        jSONObject.put("6", jSONArray2.getJSONObject(i).getString("firstInstallTime"));
                        jSONObject.put("7", jSONArray2.getJSONObject(i).getString("lastUpdateTime"));
                        jSONArray.put(jSONObject);
                    }
                    return jSONArray;
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }
}
