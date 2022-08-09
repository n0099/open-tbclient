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
public class ui0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ui0() {
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
            map.put("_client_version", dh0.a().t());
            map.put("uid", dh0.a().p());
            map.put("cuid", dh0.a().b());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", dh0.e());
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put("_os_version", Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(new ho0().c()));
            map.put("imei", dh0.a().s());
            map.put(HttpRequest.ANDROID_ID, dh0.a().a());
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                xx0.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, ko0<vi0> ko0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, ko0Var) == null) {
            ro0 f = ro0.f(i11.a(a(map).toString().getBytes()));
            so0 so0Var = new so0();
            so0Var.a("Content-Encoding", "gzip");
            so0Var.a("Content-Type", "application/json");
            so0Var.k("https://afdconf.baidu.com/afd/download");
            so0Var.g(3000);
            so0Var.i(3000);
            so0Var.j(3000);
            so0Var.f(f);
            zn0.b().a().a(so0Var, ko0Var);
        }
    }
}
