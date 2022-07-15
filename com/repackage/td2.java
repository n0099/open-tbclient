package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class td2 {
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

    public td2() {
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
    public static td2 a(@NonNull el2 el2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, el2Var)) == null) {
            td2 td2Var = new td2();
            td2Var.a = el2Var.H();
            td2Var.c = el2Var.K();
            td2Var.d = el2Var.Q();
            td2Var.f = el2Var.G();
            td2Var.i = el2Var.T();
            td2Var.h = el2Var.p1();
            td2Var.e = System.currentTimeMillis();
            td2Var.g = String.valueOf(el2Var.getType());
            td2Var.b = el2Var.I();
            td2Var.j = el2Var.v1();
            return td2Var;
        }
        return (td2) invokeL.objValue;
    }

    public static td2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            td2 td2Var = new td2();
            td2Var.a = jSONObject.optString("bundle_id");
            td2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                td2Var.b = optJSONObject.optString("appkey");
                td2Var.g = optJSONObject.optString("pkg_type");
                td2Var.c = optJSONObject.optString("app_name");
                td2Var.d = optJSONObject.optString("app_icon");
                td2Var.j = optJSONObject.optString("version_code");
                td2Var.f = optJSONObject.optInt("frame_type");
                td2Var.h = optJSONObject.optInt("pay_protected");
            }
            return td2Var;
        }
        return (td2) invokeL.objValue;
    }
}
