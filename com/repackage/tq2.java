package com.repackage;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.el2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(rq2 rq2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{rq2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = qq2.e();
            if (rq2Var != null) {
                try {
                    e.put("page", rq2Var.b);
                } catch (JSONException e2) {
                    if (h03.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", qq2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(rq2 rq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rq2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (rq2Var != null) {
                try {
                    jSONObject.put("isH5Componet", rq2Var.g == 0 ? "0" : "1");
                } catch (JSONException e) {
                    if (h03.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(rq2 rq2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{rq2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(rq2Var, i, false, null, z, i2);
        }
    }

    public static void d(rq2 rq2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{rq2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            ac3 ac3Var = new ac3();
            ac3Var.k(5L);
            ac3Var.i(i);
            if (!v63.d || z2) {
                ac3Var.f(a(rq2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            i73 i73Var = new i73();
            i73Var.p(ac3Var);
            i73Var.q(a73.n(g03.K().k()));
            i73Var.m(g03.K().getAppId());
            i73Var.s = rq2Var.b;
            i73Var.n(false);
            h03 b0 = h03.b0();
            el2.a W = b0 == null ? null : b0.W();
            if (!v63.d || z2) {
                i73Var.s(valueOf);
                i73Var.r(W);
                i73Var.e(b(rq2Var));
                i73Var.e(h63.d().e());
                i73Var.e(h63.d().g());
            }
            a73.R(i73Var);
        }
    }
}
