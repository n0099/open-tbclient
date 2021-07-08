package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.o;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f32646a;

    /* renamed from: b  reason: collision with root package name */
    public static String f32647b;

    /* renamed from: c  reason: collision with root package name */
    public static String f32648c;

    /* renamed from: d  reason: collision with root package name */
    public static long f32649d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1436819868, "Lcom/cmic/sso/sdk/d/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1436819868, "Lcom/cmic/sso/sdk/d/h;");
                return;
            }
        }
        f32646a = m.a();
        f32649d = 0L;
    }

    public static void b(Context context, String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, Long.valueOf(j), str2}) == null) {
            String a2 = b.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            k.a a3 = k.a();
            a3.a("phonescripcache", a2);
            a3.a("phonescripstarttime", j);
            a3.a("pre_sim_key", str2);
            a3.b();
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (TextUtils.isEmpty(f32647b)) {
                return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0L));
            }
            c.b("PhoneScripUtils", f32648c + " " + f32649d);
            return a(f32649d);
        }
        return invokeV.booleanValue;
    }

    public static void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            k.a a2 = k.a();
            a2.a("phonescripstarttime");
            a2.a("phonescripcache");
            a2.a("pre_sim_key");
            if (z2) {
                a2.a();
            } else {
                a2.b();
            }
            if (z) {
                f32647b = null;
                f32648c = null;
                f32649d = 0L;
            }
        }
    }

    public static long b() {
        InterceptResult invokeV;
        long a2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(f32647b)) {
                c.b("PhoneScripUtils", f32648c + " " + f32649d);
                a2 = f32649d;
            } else {
                String b2 = k.b("phonescripcache", "");
                a2 = k.a("phonescripstarttime", 0L);
                if (TextUtils.isEmpty(b2)) {
                    j = 0;
                    return Math.max(j / 1000, 0L);
                }
            }
            j = (a2 - currentTimeMillis) - 10000;
            return Math.max(j / 1000, 0L);
        }
        return invokeV.longValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f32646a : invokeV.booleanValue;
    }

    public static void a(Context context, String str, long j, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j), str2, str3}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j <= 0) {
            return;
        }
        c.b("PhoneScripUtils", "save phone scrip simKey = " + str2);
        f32647b = str;
        long j2 = j * 1000;
        f32649d = System.currentTimeMillis() + j2;
        c.b("sLifeTime", f32649d + "");
        f32648c = str2;
        if (!f32646a && !"operator".equals(str3)) {
            o.a(new o.a(context, str, str2) { // from class: com.cmic.sso.sdk.d.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f32650a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f32651b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f32652c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32650a = context;
                    this.f32651b = str;
                    this.f32652c = str2;
                }

                @Override // com.cmic.sso.sdk.d.o.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                        h.b(this.f32650a, this.f32651b, h.f32649d, this.f32652c);
                    }
                }
            });
        } else if (j2 > 3600000) {
            f32649d = System.currentTimeMillis() + 3600000;
        } else {
            f32649d = System.currentTimeMillis() + j2;
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f32647b)) {
                String b2 = k.b("phonescripcache", "");
                if (TextUtils.isEmpty(b2)) {
                    c.a("PhoneScripUtils", StringUtil.NULL_STRING);
                    return null;
                }
                f32649d = k.a("phonescripstarttime", 0L);
                f32648c = k.b("pre_sim_key", "");
                String b3 = b.b(context, b2);
                f32647b = b3;
                return b3;
            }
            return f32647b;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.b("PhoneScripUtils", j + "");
            c.b("PhoneScripUtils", currentTimeMillis + "");
            return j - currentTimeMillis > 10000;
        }
        return invokeJ.booleanValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(f32648c)) {
                b2 = f32648c;
            } else {
                b2 = k.b("pre_sim_key", "");
                f32648c = b2;
            }
            if (TextUtils.isEmpty(b2)) {
                return 0;
            }
            return b2.equals(str) ? 1 : 2;
        }
        return invokeL.intValue;
    }

    public static boolean a(com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            int a2 = a(aVar.b("scripKey"));
            aVar.a("imsiState", a2 + "");
            c.b("PhoneScripUtils", "simState = " + a2);
            if (a2 != 1) {
                if (a2 == 2) {
                    a(true, false);
                }
                return false;
            }
            if (f32646a) {
                c.b("PhoneScripUtils", "phone is root");
                a(false, false);
            }
            return d();
        }
        return invokeL.booleanValue;
    }
}
