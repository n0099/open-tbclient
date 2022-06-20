package com.repackage;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.pk2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class eq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(cq2 cq2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{cq2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = bq2.e();
            if (cq2Var != null) {
                try {
                    e.put("page", cq2Var.b);
                } catch (JSONException e2) {
                    if (sz2.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", bq2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(cq2 cq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cq2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (cq2Var != null) {
                try {
                    jSONObject.put("isH5Componet", cq2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (sz2.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(cq2 cq2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{cq2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(cq2Var, i, false, null, z, i2);
        }
    }

    public static void d(cq2 cq2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{cq2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            lb3 lb3Var = new lb3();
            lb3Var.k(5L);
            lb3Var.i(i);
            if (!g63.d || z2) {
                lb3Var.f(a(cq2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            t63 t63Var = new t63();
            t63Var.p(lb3Var);
            t63Var.q(l63.n(rz2.K().l()));
            t63Var.m(rz2.K().getAppId());
            t63Var.s = cq2Var.b;
            t63Var.n(false);
            sz2 b0 = sz2.b0();
            pk2.a W = b0 == null ? null : b0.W();
            if (!g63.d || z2) {
                t63Var.s(valueOf);
                t63Var.r(W);
                t63Var.e(b(cq2Var));
                t63Var.e(s53.d().e());
                t63Var.e(s53.d().g());
            }
            l63.R(t63Var);
        }
    }
}
