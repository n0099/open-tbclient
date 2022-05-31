package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tc2 {
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

    public tc2() {
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
    public static tc2 a(@NonNull ek2 ek2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ek2Var)) == null) {
            tc2 tc2Var = new tc2();
            tc2Var.a = ek2Var.H();
            tc2Var.c = ek2Var.K();
            tc2Var.d = ek2Var.Q();
            tc2Var.f = ek2Var.G();
            tc2Var.i = ek2Var.T();
            tc2Var.h = ek2Var.p1();
            tc2Var.e = System.currentTimeMillis();
            tc2Var.g = String.valueOf(ek2Var.getType());
            tc2Var.b = ek2Var.I();
            tc2Var.j = ek2Var.v1();
            return tc2Var;
        }
        return (tc2) invokeL.objValue;
    }

    public static tc2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            tc2 tc2Var = new tc2();
            tc2Var.a = jSONObject.optString("bundle_id");
            tc2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                tc2Var.b = optJSONObject.optString("appkey");
                tc2Var.g = optJSONObject.optString("pkg_type");
                tc2Var.c = optJSONObject.optString("app_name");
                tc2Var.d = optJSONObject.optString("app_icon");
                tc2Var.j = optJSONObject.optString("version_code");
                tc2Var.f = optJSONObject.optInt("frame_type");
                tc2Var.h = optJSONObject.optInt("pay_protected");
            }
            return tc2Var;
        }
        return (tc2) invokeL.objValue;
    }
}
