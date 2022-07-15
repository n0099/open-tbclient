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
public class ig0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public Map<String, String> b;
    public Map<String, String> c;

    public ig0() {
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

    public static ig0 a(@NonNull HashMap<String, ?> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
            ig0 ig0Var = new ig0();
            if (hashMap.get("cmd_map") instanceof String) {
                JSONObject c = yx0.c((String) hashMap.get("cmd_map"));
                ig0Var.a = c;
                ig0Var.b = yx0.b(c);
            }
            if (hashMap.get("area_cmd") instanceof String) {
                ig0Var.c = yx0.b(yx0.c((String) hashMap.get("area_cmd")));
            }
            if (hashMap.get("charge_map") instanceof String) {
                yx0.b(yx0.c((String) hashMap.get("charge_map")));
            }
            if (hashMap.get("parallel_charge_urls") instanceof JSONObject) {
                yx0.b((JSONObject) hashMap.get("parallel_charge_urls"));
            }
            if (hashMap.get("defer_charge_urls") instanceof JSONObject) {
                yx0.b((JSONObject) hashMap.get("defer_charge_urls"));
            }
            return ig0Var;
        }
        return (ig0) invokeL.objValue;
    }
}
