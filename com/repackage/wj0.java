package com.repackage;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wj0() {
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
            map.put("_client_version", hi0.a().q());
            map.put("uid", hi0.a().m());
            map.put("cuid", hi0.a().b());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", hi0.e());
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(new fp0().c()));
            map.put("imei", hi0.a().p());
            map.put(HttpRequest.ANDROID_ID, hi0.a().a());
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                uy0.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, ip0<xj0> ip0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, ip0Var) == null) {
            pp0 f = pp0.f(s11.a(a(map).toString().getBytes()));
            qp0 qp0Var = new qp0();
            qp0Var.a("Content-Encoding", "gzip");
            qp0Var.a("Content-Type", "application/json");
            qp0Var.k("https://afdconf.baidu.com/afd/download");
            qp0Var.g(3000);
            qp0Var.i(3000);
            qp0Var.j(3000);
            qp0Var.f(f);
            yo0.b().a().a(qp0Var, ip0Var);
        }
    }
}
