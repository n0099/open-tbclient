package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public double b;
    public List<String> c;
    public int d;
    public int e;

    public q88() {
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

    public static q88 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            q88 q88Var = new q88();
            q88Var.a = jSONObject.optInt("label_measure") == 2;
            q88Var.b = jSONObject.optDouble("show_width_scale", 1.0d);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_pic_list");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        db7.a(arrayList, optJSONObject.optString("pic"));
                    }
                }
            }
            q88Var.c = arrayList;
            q88Var.d = jSONObject.optInt("width");
            q88Var.e = jSONObject.optInt("height");
            return q88Var;
        }
        return (q88) invokeL.objValue;
    }
}
