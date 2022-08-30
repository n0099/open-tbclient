package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.kuaishou.weapon.p0.k
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.kuaishou.weapon.p0.k
        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h2.a(this.a, str);
            }
        }
    }

    public h2() {
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
                if (jSONObject.optInt(TiebaStatic.LogFields.RESULT, 0) == 1) {
                    JSONObject jSONObject2 = new JSONObject(new n1(context).a(jSONObject.getString("dataRsp")));
                    String string = jSONObject2.getString("conjure");
                    if (jSONObject2.getInt("status") == 1) {
                        x1.a(context, string);
                        x1.b(context, string);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        JSONObject jSONObject;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            try {
                String str4 = v2.a + v2.f;
                String d = w2.d(context);
                if (!TextUtils.isEmpty(d)) {
                    if (!v2.b() || str2 == null) {
                        str3 = str4 + "?" + d;
                    } else {
                        str3 = str4 + "?logId=" + str2 + "&" + d;
                    }
                    str4 = str3;
                }
                String str5 = str4;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z) {
                    jSONObject = new JSONObject();
                    String b = new n1(context).b(str);
                    if (!TextUtils.isEmpty(b)) {
                        jSONObject.put("data", b);
                    }
                } else {
                    jSONObject = new JSONObject(str);
                }
                o.a().a(new l(context, WeaponHI.cookieData, WeaponHI.encryENV, str5, jSONObject, new a(context)));
            } catch (Exception unused) {
            }
        }
    }
}
