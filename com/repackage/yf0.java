package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public Map<String, String> b;
    public Map<String, String> c;

    public yf0() {
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

    public static yf0 a(@NonNull HashMap<String, ?> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
            yf0 yf0Var = new yf0();
            if (hashMap.get("cmd_map") instanceof String) {
                JSONObject c = hx0.c((String) hashMap.get("cmd_map"));
                yf0Var.a = c;
                yf0Var.b = hx0.b(c);
            }
            if (hashMap.get("area_cmd") instanceof String) {
                yf0Var.c = hx0.b(hx0.c((String) hashMap.get("area_cmd")));
            }
            if (hashMap.get("charge_map") instanceof String) {
                hx0.b(hx0.c((String) hashMap.get("charge_map")));
            }
            if (hashMap.get("parallel_charge_urls") instanceof JSONObject) {
                hx0.b((JSONObject) hashMap.get("parallel_charge_urls"));
            }
            if (hashMap.get("defer_charge_urls") instanceof JSONObject) {
                hx0.b((JSONObject) hashMap.get("defer_charge_urls"));
            }
            return yf0Var;
        }
        return (yf0) invokeL.objValue;
    }
}
