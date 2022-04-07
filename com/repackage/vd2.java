package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class vd2 {
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

    public vd2() {
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
    public static vd2 a(@NonNull gl2 gl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gl2Var)) == null) {
            vd2 vd2Var = new vd2();
            vd2Var.a = gl2Var.H();
            vd2Var.c = gl2Var.K();
            vd2Var.d = gl2Var.Q();
            vd2Var.f = gl2Var.G();
            vd2Var.i = gl2Var.T();
            vd2Var.h = gl2Var.p1();
            vd2Var.e = System.currentTimeMillis();
            vd2Var.g = String.valueOf(gl2Var.getType());
            vd2Var.b = gl2Var.I();
            vd2Var.j = gl2Var.v1();
            return vd2Var;
        }
        return (vd2) invokeL.objValue;
    }

    public static vd2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            vd2 vd2Var = new vd2();
            vd2Var.a = jSONObject.optString("bundle_id");
            vd2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                vd2Var.b = optJSONObject.optString("appkey");
                vd2Var.g = optJSONObject.optString("pkg_type");
                vd2Var.c = optJSONObject.optString("app_name");
                vd2Var.d = optJSONObject.optString("app_icon");
                vd2Var.j = optJSONObject.optString("version_code");
                vd2Var.f = optJSONObject.optInt("frame_type");
                vd2Var.h = optJSONObject.optInt("pay_protected");
            }
            return vd2Var;
        }
        return (vd2) invokeL.objValue;
    }
}
