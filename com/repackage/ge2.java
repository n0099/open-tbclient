package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ge2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;
    public String g;
    public int h;
    public String i;
    public String j;

    public ge2() {
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

    @NonNull
    public static ge2 a(@NonNull rl2 rl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rl2Var)) == null) {
            ge2 ge2Var = new ge2();
            ge2Var.a = rl2Var.H();
            ge2Var.c = rl2Var.K();
            ge2Var.d = rl2Var.Q();
            ge2Var.f = rl2Var.G();
            ge2Var.i = rl2Var.T();
            ge2Var.h = rl2Var.p1();
            ge2Var.e = System.currentTimeMillis();
            ge2Var.g = String.valueOf(rl2Var.getType());
            ge2Var.b = rl2Var.I();
            ge2Var.j = rl2Var.v1();
            return ge2Var;
        }
        return (ge2) invokeL.objValue;
    }

    public static ge2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ge2 ge2Var = new ge2();
            ge2Var.a = jSONObject.optString("bundle_id");
            ge2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                ge2Var.b = optJSONObject.optString("appkey");
                ge2Var.g = optJSONObject.optString("pkg_type");
                ge2Var.c = optJSONObject.optString("app_name");
                ge2Var.d = optJSONObject.optString("app_icon");
                ge2Var.j = optJSONObject.optString("version_code");
                ge2Var.f = optJSONObject.optInt("frame_type");
                ge2Var.h = optJSONObject.optInt("pay_protected");
            }
            return ge2Var;
        }
        return (ge2) invokeL.objValue;
    }
}
