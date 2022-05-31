package com.repackage;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ek2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tp2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(rp2 rp2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{rp2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = qp2.e();
            if (rp2Var != null) {
                try {
                    e.put("page", rp2Var.b);
                } catch (JSONException e2) {
                    if (hz2.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", qp2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(rp2 rp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rp2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (rp2Var != null) {
                try {
                    jSONObject.put("isH5Componet", rp2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (hz2.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(rp2 rp2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{rp2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(rp2Var, i, false, null, z, i2);
        }
    }

    public static void d(rp2 rp2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{rp2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            ab3 ab3Var = new ab3();
            ab3Var.k(5L);
            ab3Var.i(i);
            if (!v53.d || z2) {
                ab3Var.f(a(rp2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            i63 i63Var = new i63();
            i63Var.p(ab3Var);
            i63Var.q(a63.n(gz2.J().l()));
            i63Var.m(gz2.J().getAppId());
            i63Var.s = rp2Var.b;
            i63Var.n(false);
            hz2 a0 = hz2.a0();
            ek2.a V = a0 == null ? null : a0.V();
            if (!v53.d || z2) {
                i63Var.s(valueOf);
                i63Var.r(V);
                i63Var.e(b(rp2Var));
                i63Var.e(h53.d().e());
                i63Var.e(h53.d().g());
            }
            a63.R(i63Var);
        }
    }
}
