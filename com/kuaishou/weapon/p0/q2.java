package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = str;
        }

        @Override // com.kuaishou.weapon.p0.k
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a) {
                TextUtils.isEmpty(this.b);
            }
        }

        @Override // com.kuaishou.weapon.p0.k
        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    public q2() {
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
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            try {
                String str3 = v2.a + v2.e;
                String d = w2.d(context);
                if (!TextUtils.isEmpty(d)) {
                    if (!v2.b() || str2 == null) {
                        sb = new StringBuilder();
                        sb.append(str3);
                        sb.append("?");
                    } else {
                        sb = new StringBuilder();
                        sb.append(str3);
                        sb.append("?logId=");
                        sb.append(str2);
                        sb.append("&");
                    }
                    sb.append(d);
                    str3 = sb.toString();
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z2) {
                    jSONObject = new JSONObject();
                    String b = new n1(context).b(str);
                    if (!TextUtils.isEmpty(b)) {
                        jSONObject.put("data", b);
                    }
                } else {
                    jSONObject = new JSONObject(str);
                }
                m a2 = m.a(context);
                n nVar = new n(str3, jSONObject);
                nVar.a(WeaponHI.cookieData);
                nVar.b(WeaponHI.encryENV);
                a2.b(nVar, new a(z, str2));
            } catch (Throwable unused) {
            }
        }
    }
}
