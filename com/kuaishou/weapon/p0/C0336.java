package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼᐧ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0336 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.weapon.p0.ʼᐧ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class C0337 implements InterfaceC0353 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ boolean f121;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ String f122;

        public C0337(boolean z, String str) {
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
            this.f121 = z;
            this.f122 = str;
        }

        @Override // com.kuaishou.weapon.p0.InterfaceC0353
        /* renamed from: ʻ */
        public final void mo239(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f121) {
                TextUtils.isEmpty(this.f122);
            }
        }

        @Override // com.kuaishou.weapon.p0.InterfaceC0353
        /* renamed from: ʼ */
        public final void mo240(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    public C0336() {
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
    public static void m282(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            try {
                m283(context, str, null, false, true);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m283(Context context, String str, String str2, boolean z, boolean z2) {
        JSONObject jSONObject;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            try {
                String str3 = C0345.f141 + C0345.f145;
                String m363 = C0355.m363(context);
                if (!TextUtils.isEmpty(m363)) {
                    if (!C0345.m301() || str2 == null) {
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
                    sb.append(m363);
                    str3 = sb.toString();
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z2) {
                    jSONObject = new JSONObject();
                    String m150 = new C0297(context).m150(str);
                    if (!TextUtils.isEmpty(m150)) {
                        jSONObject.put("data", m150);
                    }
                } else {
                    jSONObject = new JSONObject(str);
                }
                C0346.m302().mo312(new C0348(str3, jSONObject), new C0337(z, str2));
            } catch (Throwable unused) {
            }
        }
    }
}
