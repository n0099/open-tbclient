package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.av;
import java.util.Locale;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f967a;

    /* renamed from: b  reason: collision with root package name */
    public final String f61668b;

    /* renamed from: c  reason: collision with root package name */
    public final String f61669c;

    /* renamed from: d  reason: collision with root package name */
    public final String f61670d;

    /* renamed from: e  reason: collision with root package name */
    public final String f61671e;

    /* renamed from: f  reason: collision with root package name */
    public final String f61672f;

    public l(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f967a = str;
        this.f61668b = str2;
        this.f61669c = str3;
        this.f61670d = str4;
        this.f61671e = str5;
        this.f61672f = str6;
        this.a = i2;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return com.xiaomi.push.t.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? "com.xiaomi.xmsf".equals(context.getPackageName()) && a() : invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getPackageName().equals("com.xiaomi.xmsf") : invokeL.booleanValue;
    }

    public av.b a(XMPushService xMPushService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xMPushService)) == null) {
            av.b bVar = new av.b(xMPushService);
            a(bVar, xMPushService, xMPushService.b(), "c");
            return bVar;
        }
        return (av.b) invokeL.objValue;
    }

    public av.b a(av.b bVar, Context context, e eVar, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, context, eVar, str)) == null) {
            bVar.f916a = context.getPackageName();
            bVar.f919b = this.f967a;
            bVar.f61636h = this.f61669c;
            bVar.f61631c = this.f61668b;
            bVar.f61635g = "5";
            bVar.f61632d = "XMPUSH-PASS";
            bVar.f918a = false;
            bVar.f61633e = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s", "sdk_ver", 43, "cpvn", "3_8_5", "cpvc", 30805, "aapn", b(context) ? com.xiaomi.push.g.b(context) : "", "country_code", a.a(context).b(), "region", a.a(context).a());
            bVar.f61634f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", "appid", b(context) ? "1000271" : this.f61670d, "locale", Locale.getDefault().toString(), com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_MIID, com.xiaomi.push.t.a(context));
            if (a(context)) {
                bVar.f61634f += String.format(",%1$s:%2$s", "ab", str);
            }
            bVar.f915a = eVar;
            return bVar;
        }
        return (av.b) invokeLLLL.objValue;
    }
}
