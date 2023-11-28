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
/* loaded from: classes10.dex */
public class ch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;

    public ch(Context context, int i) {
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
                JSONObject a2 = new cm(str, ck.l).a(this.a);
                if (a2 != null && (a = a()) != null && a.length() != 0) {
                    a2.put("module_section", a);
                    return a2.toString();
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (h.a(this.a, "re_po_rt").b(df.y, 1) == 1) {
                    try {
                        JSONArray a = new x().a(this.a);
                        if (a != null && a.length() > 0) {
                            jSONObject.put("10000", a);
                            jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Hj().Hi()));
                            jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Hj().getSdkVersion()));
                            jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Hj().getAppId()));
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
