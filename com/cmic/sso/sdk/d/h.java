package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.o;
/* loaded from: classes12.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f54979b;

    /* renamed from: c  reason: collision with root package name */
    public static String f54980c;

    /* renamed from: d  reason: collision with root package name */
    public static long f54981d;
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
        a = m.a();
        f54981d = 0L;
    }

    public static void b(Context context, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, Long.valueOf(j2), str2}) == null) {
            String a2 = b.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            k.a a3 = k.a();
            a3.a("phonescripcache", a2);
            a3.a("phonescripstarttime", j2);
            a3.a("pre_sim_key", str2);
            a3.b();
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (TextUtils.isEmpty(f54979b)) {
                return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0L));
            }
            c.b("PhoneScripUtils", f54980c + " " + f54981d);
            return a(f54981d);
        }
        return invokeV.booleanValue;
    }

    public static void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
                f54979b = null;
                f54980c = null;
                f54981d = 0L;
            }
        }
    }

    public static long b() {
        InterceptResult invokeV;
        long a2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(f54979b)) {
                c.b("PhoneScripUtils", f54980c + " " + f54981d);
                a2 = f54981d;
            } else {
                String b2 = k.b("phonescripcache", "");
                a2 = k.a("phonescripstarttime", 0L);
                if (TextUtils.isEmpty(b2)) {
                    j2 = 0;
                    return Math.max(j2 / 1000, 0L);
                }
            }
            j2 = (a2 - currentTimeMillis) - 10000;
            return Math.max(j2 / 1000, 0L);
        }
        return invokeV.longValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a : invokeV.booleanValue;
    }

    public static void a(Context context, String str, long j2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j2), str2, str3}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j2 <= 0) {
            return;
        }
        c.b("PhoneScripUtils", "save phone scrip simKey = " + str2);
        f54979b = str;
        long j3 = j2 * 1000;
        f54981d = System.currentTimeMillis() + j3;
        c.b("sLifeTime", f54981d + "");
        f54980c = str2;
        if (!a && !"operator".equals(str3)) {
            o.a(new o.a(context, str, str2) { // from class: com.cmic.sso.sdk.d.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f54982b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f54983c;

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
                    this.a = context;
                    this.f54982b = str;
                    this.f54983c = str2;
                }

                @Override // com.cmic.sso.sdk.d.o.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                        h.b(this.a, this.f54982b, h.f54981d, this.f54983c);
                    }
                }
            });
        } else if (j3 > 3600000) {
            f54981d = System.currentTimeMillis() + 3600000;
        } else {
            f54981d = System.currentTimeMillis() + j3;
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f54979b)) {
                String b2 = k.b("phonescripcache", "");
                if (TextUtils.isEmpty(b2)) {
                    c.a("PhoneScripUtils", StringUtil.NULL_STRING);
                    return null;
                }
                f54981d = k.a("phonescripstarttime", 0L);
                f54980c = k.b("pre_sim_key", "");
                String b3 = b.b(context, b2);
                f54979b = b3;
                return b3;
            }
            return f54979b;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.b("PhoneScripUtils", j2 + "");
            c.b("PhoneScripUtils", currentTimeMillis + "");
            return j2 - currentTimeMillis > 10000;
        }
        return invokeJ.booleanValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(f54980c)) {
                b2 = f54980c;
            } else {
                b2 = k.b("pre_sim_key", "");
                f54980c = b2;
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
            if (a) {
                c.b("PhoneScripUtils", "phone is root");
                a(false, false);
            }
            return d();
        }
        return invokeL.booleanValue;
    }
}
