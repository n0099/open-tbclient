package com.repackage;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ni0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ni0() {
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

    public final JSONObject a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            map.put("_client_version", bh0.a().q());
            map.put("uid", bh0.a().m());
            map.put("cuid", bh0.a().b());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", bh0.e());
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put("_os_version", Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(new wn0().c()));
            map.put("imei", bh0.a().p());
            map.put(HttpRequest.ANDROID_ID, bh0.a().a());
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                lx0.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, zn0<oi0> zn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, zn0Var) == null) {
            go0 f = go0.f(t01.a(a(map).toString().getBytes()));
            ho0 ho0Var = new ho0();
            ho0Var.a("Content-Encoding", "gzip");
            ho0Var.a("Content-Type", "application/json");
            ho0Var.k("https://afdconf.baidu.com/afd/download");
            ho0Var.g(3000);
            ho0Var.i(3000);
            ho0Var.j(3000);
            ho0Var.f(f);
            pn0.b().a().a(ho0Var, zn0Var);
        }
    }
}
