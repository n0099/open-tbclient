package com.kuaishou.weapon.un;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g1() {
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

    public static void a(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, context) == null) {
            try {
                String str2 = r0.a + r0.d;
                String e = s0.e(context);
                if (!TextUtils.isEmpty(e)) {
                    str2 = str2 + "?" + e;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                m1 m1Var = new m1(context);
                JSONObject jSONObject = new JSONObject();
                String b = m1Var.b(str);
                if (!TextUtils.isEmpty(b)) {
                    jSONObject.put("data", b);
                }
                new p1(context, null).a(str2, jSONObject.toString().getBytes());
            } catch (Exception e2) {
                l1.a(e2);
            }
        }
    }
}
