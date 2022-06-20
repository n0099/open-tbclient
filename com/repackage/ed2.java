package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ed2 {
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

    public ed2() {
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
    public static ed2 a(@NonNull pk2 pk2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pk2Var)) == null) {
            ed2 ed2Var = new ed2();
            ed2Var.a = pk2Var.H();
            ed2Var.c = pk2Var.K();
            ed2Var.d = pk2Var.Q();
            ed2Var.f = pk2Var.G();
            ed2Var.i = pk2Var.T();
            ed2Var.h = pk2Var.p1();
            ed2Var.e = System.currentTimeMillis();
            ed2Var.g = String.valueOf(pk2Var.getType());
            ed2Var.b = pk2Var.I();
            ed2Var.j = pk2Var.v1();
            return ed2Var;
        }
        return (ed2) invokeL.objValue;
    }

    public static ed2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ed2 ed2Var = new ed2();
            ed2Var.a = jSONObject.optString("bundle_id");
            ed2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                ed2Var.b = optJSONObject.optString("appkey");
                ed2Var.g = optJSONObject.optString("pkg_type");
                ed2Var.c = optJSONObject.optString("app_name");
                ed2Var.d = optJSONObject.optString("app_icon");
                ed2Var.j = optJSONObject.optString("version_code");
                ed2Var.f = optJSONObject.optInt("frame_type");
                ed2Var.h = optJSONObject.optInt("pay_protected");
            }
            return ed2Var;
        }
        return (ed2) invokeL.objValue;
    }
}
