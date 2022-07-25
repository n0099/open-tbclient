package com.repackage;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.fl2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class uq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(sq2 sq2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{sq2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = rq2.e();
            if (sq2Var != null) {
                try {
                    e.put("page", sq2Var.b);
                } catch (JSONException e2) {
                    if (i03.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", rq2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(sq2 sq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sq2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (sq2Var != null) {
                try {
                    jSONObject.put("isH5Componet", sq2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (i03.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(sq2 sq2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{sq2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(sq2Var, i, false, null, z, i2);
        }
    }

    public static void d(sq2 sq2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{sq2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            bc3 bc3Var = new bc3();
            bc3Var.k(5L);
            bc3Var.i(i);
            if (!w63.d || z2) {
                bc3Var.f(a(sq2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            j73 j73Var = new j73();
            j73Var.p(bc3Var);
            j73Var.q(b73.n(h03.K().k()));
            j73Var.m(h03.K().getAppId());
            j73Var.s = sq2Var.b;
            j73Var.n(false);
            i03 b0 = i03.b0();
            fl2.a W = b0 == null ? null : b0.W();
            if (!w63.d || z2) {
                j73Var.s(valueOf);
                j73Var.r(W);
                j73Var.e(b(sq2Var));
                j73Var.e(i63.d().e());
                j73Var.e(i63.d().g());
            }
            b73.R(j73Var);
        }
    }
}
