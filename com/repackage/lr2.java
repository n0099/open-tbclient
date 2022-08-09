package com.repackage;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.wl2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(jr2 jr2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{jr2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = ir2.e();
            if (jr2Var != null) {
                try {
                    e.put("page", jr2Var.b);
                } catch (JSONException e2) {
                    if (z03.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", ir2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(jr2 jr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jr2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (jr2Var != null) {
                try {
                    jSONObject.put("isH5Componet", jr2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (z03.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(jr2 jr2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{jr2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(jr2Var, i, false, null, z, i2);
        }
    }

    public static void d(jr2 jr2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{jr2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            sc3 sc3Var = new sc3();
            sc3Var.k(5L);
            sc3Var.i(i);
            if (!n73.d || z2) {
                sc3Var.f(a(jr2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            a83 a83Var = new a83();
            a83Var.p(sc3Var);
            a83Var.q(s73.n(y03.K().k()));
            a83Var.m(y03.K().getAppId());
            a83Var.s = jr2Var.b;
            a83Var.n(false);
            z03 b0 = z03.b0();
            wl2.a W = b0 == null ? null : b0.W();
            if (!n73.d || z2) {
                a83Var.s(valueOf);
                a83Var.r(W);
                a83Var.e(b(jr2Var));
                a83Var.e(z63.d().e());
                a83Var.e(z63.d().g());
            }
            s73.R(a83Var);
        }
    }
}
