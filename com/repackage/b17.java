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
public class b17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z07 a;
    public ArrayList<a17> b;

    public b17() {
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

    public static b17 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b17 b17Var = new b17();
            JSONObject optJSONObject = jSONObject.optJSONObject("guide_content");
            JSONArray optJSONArray = jSONObject.optJSONArray("hot_topic");
            b17Var.a = z07.a(optJSONObject);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b17Var.b = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        a17 a = a17.a(optJSONArray.getJSONObject(i));
                        if (a != null) {
                            b17Var.b.add(a);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return b17Var;
        }
        return (b17) invokeL.objValue;
    }
}
