package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼˉ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0326 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.weapon.p0.ʼˉ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class C0327 implements InterfaceC0353 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ Context f70;

        public C0327(Context context) {
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
            this.f70 = context;
        }

        @Override // com.kuaishou.weapon.p0.InterfaceC0353
        /* renamed from: ʻ  reason: contains not printable characters */
        public final void mo239(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.kuaishou.weapon.p0.InterfaceC0353
        /* renamed from: ʼ  reason: contains not printable characters */
        public final void mo240(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                C0326.m237(this.f70, str);
            }
        }
    }

    public C0326() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m237(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("result", 0) == 1) {
                    JSONObject jSONObject2 = new JSONObject(new C0297(context).m148(jSONObject.getString("dataRsp")));
                    String string = jSONObject2.getString("conjure");
                    if (jSONObject2.getInt("status") == 1) {
                        C0314.m216(context, string);
                        C0314.m218(context, string);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m238(Context context, String str, String str2, boolean z) {
        JSONObject jSONObject;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            try {
                String str4 = C0345.f141 + C0345.f146;
                String m363 = C0355.m363(context);
                if (!TextUtils.isEmpty(m363)) {
                    if (!C0345.m301() || str2 == null) {
                        str3 = str4 + "?" + m363;
                    } else {
                        str3 = str4 + "?logId=" + str2 + "&" + m363;
                    }
                    str4 = str3;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z) {
                    jSONObject = new JSONObject();
                    String m150 = new C0297(context).m150(str);
                    if (!TextUtils.isEmpty(m150)) {
                        jSONObject.put("data", m150);
                    }
                } else {
                    jSONObject = new JSONObject(str);
                }
                C0358.m366().m367(new RunnableC0343(str4, jSONObject, new C0327(context)));
            } catch (Exception unused) {
            }
        }
    }
}
