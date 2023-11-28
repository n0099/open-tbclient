package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cg() {
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

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("result", 0) == 1) {
                    JSONObject jSONObject2 = new JSONObject(new bn(context).a(jSONObject.getString("dataRsp")));
                    String string = jSONObject2.getString("conjure");
                    if (jSONObject2.getInt("status") == 1) {
                        bx.a(context, string);
                        bx.b(context, string);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            try {
                String str3 = cu.a + cu.f;
                String a = cv.a(context);
                if (!TextUtils.isEmpty(a)) {
                    if (cu.a() && str2 != null) {
                        str3 = str3 + "?logId=" + str2 + "&" + a;
                    } else {
                        str3 = str3 + "?" + a;
                    }
                }
                String str4 = str3;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z) {
                    jSONObject = new JSONObject();
                    String c = new bn(context).c(str);
                    if (!TextUtils.isEmpty(c)) {
                        jSONObject.put("data", c);
                    }
                } else {
                    jSONObject = new JSONObject(str);
                }
                n.a().a(new k(context, WeaponHI.cookieData, WeaponHI.encryENV, str4, jSONObject, new j(context) { // from class: com.kuaishou.weapon.p0.cg.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    @Override // com.kuaishou.weapon.p0.j
                    public final void b(String str5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str5) == null) {
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = context;
                    }

                    @Override // com.kuaishou.weapon.p0.j
                    public final void a(String str5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str5) == null) {
                            cg.a(this.a, str5);
                        }
                    }
                }));
            } catch (Exception unused) {
            }
        }
    }
}
