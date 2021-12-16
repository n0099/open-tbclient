package com.kuaishou.weapon.un;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, context) == null) {
            try {
                String str2 = r0.a + r0.f57407d;
                String e2 = s0.e(context);
                if (!TextUtils.isEmpty(e2)) {
                    str2 = str2 + "?" + e2;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                m1 m1Var = new m1(context);
                JSONObject jSONObject = new JSONObject();
                String b2 = m1Var.b(str);
                if (!TextUtils.isEmpty(b2)) {
                    jSONObject.put("data", b2);
                }
                new p1(context, null).a(str2, jSONObject.toString().getBytes());
            } catch (Exception e3) {
                l1.a(e3);
            }
        }
    }
}
