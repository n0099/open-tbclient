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
/* loaded from: classes7.dex */
public class yi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yi0() {
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
            map.put("_client_version", hh0.a().q());
            map.put("uid", hh0.a().m());
            map.put("cuid", hh0.a().b());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", hh0.e());
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put("_os_version", Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(new jo0().c()));
            map.put("imei", hh0.a().p());
            map.put(HttpRequest.ANDROID_ID, hh0.a().a());
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                yx0.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, mo0<zi0> mo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, mo0Var) == null) {
            to0 f = to0.f(h11.a(a(map).toString().getBytes()));
            uo0 uo0Var = new uo0();
            uo0Var.a("Content-Encoding", "gzip");
            uo0Var.a("Content-Type", "application/json");
            uo0Var.k("https://afdconf.baidu.com/afd/download");
            uo0Var.g(3000);
            uo0Var.i(3000);
            uo0Var.j(3000);
            uo0Var.f(f);
            co0.b().a().a(uo0Var, mo0Var);
        }
    }
}
