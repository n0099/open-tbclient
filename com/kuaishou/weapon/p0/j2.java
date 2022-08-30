package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;

    public j2(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = i;
    }

    public String a(String str) {
        InterceptResult invokeL;
        JSONObject a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject a2 = new n2(str, l2.j).a(this.a);
                if (a2 == null || (a = a()) == null) {
                    return null;
                }
                a2.put("module_section", a);
                return a2.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        JSONArray d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                i a = i.a(this.a, "re_po_rt");
                int a2 = a.a(f3.o, 0);
                boolean b = a.b("a1_p_s_p_s");
                boolean b2 = a.b("a1_p_s_p_s_c_b");
                if (a2 == 1 && ((b || b2) && (d = new x(this.a).d(0)) != null)) {
                    jSONObject.put("10000", d);
                    try {
                        jSONObject.put("11301", h1.c(com.kwad.sdk.c.b.xm().xl()));
                        jSONObject.put("11302", h1.c(com.kwad.sdk.c.b.xm().getSdkVersion()));
                        jSONObject.put("11303", h1.c(com.kwad.sdk.c.b.xm().getAppId()));
                    } catch (Throwable unused) {
                    }
                    jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                    jSONObject.put("11017", jSONObject.toString().length());
                    return jSONObject;
                }
            } catch (Throwable unused2) {
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
