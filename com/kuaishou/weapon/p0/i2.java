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
/* loaded from: classes8.dex */
public class i2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;

    public i2(Context context, int i) {
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
        JSONArray a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                if (i.a(this.a, "re_po_rt").a(f3.y, 1) == 1 && (a = new y().a(this.a)) != null && a.length() > 0) {
                    jSONObject.put("10000", a);
                    try {
                        jSONObject.put("11203", h1.b(com.kwad.sdk.c.b.xm().xk()));
                        jSONObject.put("11301", h1.c(com.kwad.sdk.c.b.xm().xl()));
                        jSONObject.put("11302", h1.c(com.kwad.sdk.c.b.xm().getSdkVersion()));
                        jSONObject.put("11303", h1.c(com.kwad.sdk.c.b.xm().getAppId()));
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            } catch (Throwable unused2) {
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
