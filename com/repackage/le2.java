package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class le2 {
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

    public le2() {
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
    public static le2 a(@NonNull wl2 wl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wl2Var)) == null) {
            le2 le2Var = new le2();
            le2Var.a = wl2Var.H();
            le2Var.c = wl2Var.K();
            le2Var.d = wl2Var.Q();
            le2Var.f = wl2Var.G();
            le2Var.i = wl2Var.T();
            le2Var.h = wl2Var.p1();
            le2Var.e = System.currentTimeMillis();
            le2Var.g = String.valueOf(wl2Var.getType());
            le2Var.b = wl2Var.I();
            le2Var.j = wl2Var.v1();
            return le2Var;
        }
        return (le2) invokeL.objValue;
    }

    public static le2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            le2 le2Var = new le2();
            le2Var.a = jSONObject.optString("bundle_id");
            le2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                le2Var.b = optJSONObject.optString("appkey");
                le2Var.g = optJSONObject.optString("pkg_type");
                le2Var.c = optJSONObject.optString("app_name");
                le2Var.d = optJSONObject.optString("app_icon");
                le2Var.j = optJSONObject.optString("version_code");
                le2Var.f = optJSONObject.optInt("frame_type");
                le2Var.h = optJSONObject.optInt("pay_protected");
            }
            return le2Var;
        }
        return (le2) invokeL.objValue;
    }
}
