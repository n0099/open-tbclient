package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public az6 a;
    public ArrayList<bz6> b;

    public cz6() {
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

    public static cz6 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            cz6 cz6Var = new cz6();
            JSONObject optJSONObject = jSONObject.optJSONObject("guide_content");
            JSONArray optJSONArray = jSONObject.optJSONArray("hot_topic");
            cz6Var.a = az6.a(optJSONObject);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                cz6Var.b = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        bz6 a = bz6.a(optJSONArray.getJSONObject(i));
                        if (a != null) {
                            cz6Var.b.add(a);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return cz6Var;
        }
        return (cz6) invokeL.objValue;
    }
}
