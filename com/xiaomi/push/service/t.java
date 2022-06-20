package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.w;
import java.util.Locale;
/* loaded from: classes8.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f997a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public t(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f997a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.a = i;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if ("com.xiaomi.xmsf".equals(context)) {
                if (TextUtils.isEmpty(null)) {
                    String m553a = com.xiaomi.push.m.m553a("ro.miui.region");
                    return TextUtils.isEmpty(m553a) ? com.xiaomi.push.m.m553a("ro.product.locale.region") : m553a;
                }
                return null;
            }
            return com.xiaomi.push.m.b();
        }
        return (String) invokeL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return com.xiaomi.push.v.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m674a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? "com.xiaomi.xmsf".equals(context.getPackageName()) && a() : invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getPackageName().equals("com.xiaomi.xmsf") : invokeL.booleanValue;
    }

    public bg.b a(XMPushService xMPushService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xMPushService)) == null) {
            bg.b bVar = new bg.b(xMPushService);
            a(bVar, xMPushService, xMPushService.m589b(), "c");
            return bVar;
        }
        return (bg.b) invokeL.objValue;
    }

    public bg.b a(bg.b bVar, Context context, j jVar, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, context, jVar, str)) == null) {
            bVar.f926a = context.getPackageName();
            bVar.f929b = this.f997a;
            bVar.h = this.c;
            bVar.c = this.b;
            bVar.g = "5";
            bVar.d = "XMPUSH-PASS";
            bVar.f928a = false;
            w.a aVar = new w.a();
            aVar.a("sdk_ver", 48).a("cpvn", "4_9_0").a("cpvc", 40090).a("country_code", a.a(context).b()).a("region", a.a(context).a()).a("miui_vn", com.xiaomi.push.m.c()).a("miui_vc", Integer.valueOf(com.xiaomi.push.m.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.h.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(ax.m618a(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.h.a(context)));
            String a = a(context);
            if (!TextUtils.isEmpty(a)) {
                aVar.a("latest_country_code", a);
            }
            String d = com.xiaomi.push.m.d();
            if (!TextUtils.isEmpty(d)) {
                aVar.a("device_ch", d);
            }
            String e = com.xiaomi.push.m.e();
            if (!TextUtils.isEmpty(e)) {
                aVar.a("device_mfr", e);
            }
            bVar.e = aVar.toString();
            String str2 = b(context) ? "1000271" : this.d;
            w.a aVar2 = new w.a();
            aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a(NativeConstants.COMPONENT_SYNC_TEXT_VIEW, 1);
            if (m674a(context)) {
                aVar2.a("ab", str);
            }
            bVar.f = aVar2.toString();
            bVar.f925a = jVar;
            return bVar;
        }
        return (bg.b) invokeLLLL.objValue;
    }
}
