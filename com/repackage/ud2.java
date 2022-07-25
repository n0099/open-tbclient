package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ud2 {
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

    public ud2() {
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
    public static ud2 a(@NonNull fl2 fl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fl2Var)) == null) {
            ud2 ud2Var = new ud2();
            ud2Var.a = fl2Var.H();
            ud2Var.c = fl2Var.K();
            ud2Var.d = fl2Var.Q();
            ud2Var.f = fl2Var.G();
            ud2Var.i = fl2Var.T();
            ud2Var.h = fl2Var.p1();
            ud2Var.e = System.currentTimeMillis();
            ud2Var.g = String.valueOf(fl2Var.getType());
            ud2Var.b = fl2Var.I();
            ud2Var.j = fl2Var.v1();
            return ud2Var;
        }
        return (ud2) invokeL.objValue;
    }

    public static ud2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ud2 ud2Var = new ud2();
            ud2Var.a = jSONObject.optString("bundle_id");
            ud2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                ud2Var.b = optJSONObject.optString("appkey");
                ud2Var.g = optJSONObject.optString("pkg_type");
                ud2Var.c = optJSONObject.optString("app_name");
                ud2Var.d = optJSONObject.optString("app_icon");
                ud2Var.j = optJSONObject.optString("version_code");
                ud2Var.f = optJSONObject.optInt("frame_type");
                ud2Var.h = optJSONObject.optInt("pay_protected");
            }
            return ud2Var;
        }
        return (ud2) invokeL.objValue;
    }
}
