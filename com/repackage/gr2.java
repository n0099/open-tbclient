package com.repackage;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.rl2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(er2 er2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{er2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = dr2.e();
            if (er2Var != null) {
                try {
                    e.put("page", er2Var.b);
                } catch (JSONException e2) {
                    if (u03.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", dr2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(er2 er2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, er2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (er2Var != null) {
                try {
                    jSONObject.put("isH5Componet", er2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (u03.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(er2 er2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{er2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(er2Var, i, false, null, z, i2);
        }
    }

    public static void d(er2 er2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{er2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            nc3 nc3Var = new nc3();
            nc3Var.k(5L);
            nc3Var.i(i);
            if (!i73.d || z2) {
                nc3Var.f(a(er2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            v73 v73Var = new v73();
            v73Var.p(nc3Var);
            v73Var.q(n73.n(t03.J().l()));
            v73Var.m(t03.J().getAppId());
            v73Var.s = er2Var.b;
            v73Var.n(false);
            u03 a0 = u03.a0();
            rl2.a V = a0 == null ? null : a0.V();
            if (!i73.d || z2) {
                v73Var.s(valueOf);
                v73Var.r(V);
                v73Var.e(b(er2Var));
                v73Var.e(u63.d().e());
                v73Var.e(u63.d().g());
            }
            n73.R(v73Var);
        }
    }
}
