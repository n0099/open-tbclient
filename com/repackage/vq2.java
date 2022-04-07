package com.repackage;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.gl2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class vq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(tq2 tq2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tq2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = sq2.e();
            if (tq2Var != null) {
                try {
                    e.put("page", tq2Var.b);
                } catch (JSONException e2) {
                    if (j03.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", sq2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(tq2 tq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tq2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (tq2Var != null) {
                try {
                    jSONObject.put("isH5Componet", tq2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (j03.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(tq2 tq2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tq2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(tq2Var, i, false, null, z, i2);
        }
    }

    public static void d(tq2 tq2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tq2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            cc3 cc3Var = new cc3();
            cc3Var.k(5L);
            cc3Var.i(i);
            if (!x63.d || z2) {
                cc3Var.f(a(tq2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            k73 k73Var = new k73();
            k73Var.p(cc3Var);
            k73Var.q(c73.n(i03.J().l()));
            k73Var.m(i03.J().getAppId());
            k73Var.s = tq2Var.b;
            k73Var.n(false);
            j03 a0 = j03.a0();
            gl2.a V = a0 == null ? null : a0.V();
            if (!x63.d || z2) {
                k73Var.s(valueOf);
                k73Var.r(V);
                k73Var.e(b(tq2Var));
                k73Var.e(j63.d().e());
                k73Var.e(j63.d().g());
            }
            c73.R(k73Var);
        }
    }
}
