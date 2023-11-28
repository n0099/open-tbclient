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
public class cp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cp() {
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
                a(context, str, null, false, true);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            try {
                String str3 = cu.a + cu.e;
                String a = cv.a(context);
                if (!TextUtils.isEmpty(a)) {
                    if (cu.a() && str2 != null) {
                        str3 = str3 + "?logId=" + str2 + "&" + a;
                    } else {
                        str3 = str3 + "?" + a;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z2) {
                    jSONObject = new JSONObject();
                    String c = new bn(context).c(str);
                    if (!TextUtils.isEmpty(c)) {
                        jSONObject.put("data", c);
                    }
                } else {
                    jSONObject = new JSONObject(str);
                }
                l a2 = l.a(context);
                m mVar = new m(str3, jSONObject);
                mVar.a(WeaponHI.cookieData);
                mVar.b(WeaponHI.encryENV);
                a2.b(mVar, new j(str2, context, z) { // from class: com.kuaishou.weapon.p0.cp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ Context b;
                    public final /* synthetic */ boolean c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str2, context, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = str2;
                        this.b = context;
                        this.c = z;
                    }

                    @Override // com.kuaishou.weapon.p0.j
                    public final void a(String str4) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, str4) == null) && !TextUtils.isEmpty(this.a)) {
                            try {
                                if (this.a.equals(ck.b)) {
                                    df.a(this.b).a(System.currentTimeMillis());
                                } else if (this.a.equals(ck.c)) {
                                    df.a(this.b).a(df.bj, System.currentTimeMillis());
                                } else if (this.a.equals(ck.d)) {
                                    df.a(this.b).a(df.bi, System.currentTimeMillis());
                                } else if (this.a.equals(ck.g)) {
                                    df.a(this.b).a(df.bm, System.currentTimeMillis());
                                } else if (this.a.equals(ck.i)) {
                                    df.a(this.b).a(df.bh, System.currentTimeMillis());
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }

                    @Override // com.kuaishou.weapon.p0.j
                    public final void b(String str4) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str4) == null) && this.c) {
                            TextUtils.isEmpty(this.a);
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }
}
