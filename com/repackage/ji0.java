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
public class ji0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ji0() {
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
            map.put("_client_version", xg0.a().q());
            map.put("uid", xg0.a().m());
            map.put("cuid", xg0.a().b());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", xg0.e());
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put("_os_version", Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(new sn0().c()));
            map.put("imei", xg0.a().p());
            map.put(HttpRequest.ANDROID_ID, xg0.a().a());
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hx0.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, vn0<ki0> vn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, vn0Var) == null) {
            co0 f = co0.f(p01.a(a(map).toString().getBytes()));
            do0 do0Var = new do0();
            do0Var.a("Content-Encoding", "gzip");
            do0Var.a("Content-Type", "application/json");
            do0Var.k("https://afdconf.baidu.com/afd/download");
            do0Var.g(3000);
            do0Var.i(3000);
            do0Var.j(3000);
            do0Var.f(f);
            ln0.b().a().a(do0Var, vn0Var);
        }
    }
}
