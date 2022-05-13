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
/* loaded from: classes6.dex */
public class lh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public Map<String, String> b;
    public Map<String, String> c;

    public lh0() {
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

    public static lh0 a(@NonNull HashMap<String, ?> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
            lh0 lh0Var = new lh0();
            if (hashMap.get("cmd_map") instanceof String) {
                JSONObject c = uy0.c((String) hashMap.get("cmd_map"));
                lh0Var.a = c;
                lh0Var.b = uy0.b(c);
            }
            if (hashMap.get("area_cmd") instanceof String) {
                lh0Var.c = uy0.b(uy0.c((String) hashMap.get("area_cmd")));
            }
            if (hashMap.get("charge_map") instanceof String) {
                uy0.b(uy0.c((String) hashMap.get("charge_map")));
            }
            if (hashMap.get("parallel_charge_urls") instanceof JSONObject) {
                uy0.b((JSONObject) hashMap.get("parallel_charge_urls"));
            }
            if (hashMap.get("defer_charge_urls") instanceof JSONObject) {
                uy0.b((JSONObject) hashMap.get("defer_charge_urls"));
            }
            return lh0Var;
        }
        return (lh0) invokeL.objValue;
    }
}
