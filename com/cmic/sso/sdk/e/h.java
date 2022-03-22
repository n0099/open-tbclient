package com.cmic.sso.sdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.n;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f38482b;

    /* renamed from: c  reason: collision with root package name */
    public static long f38483c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1436790077, "Lcom/cmic/sso/sdk/e/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1436790077, "Lcom/cmic/sso/sdk/e/h;");
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                return !TextUtils.isEmpty(k.b("phonescripcache", "")) && a(k.a("phonescripstarttime", 0L));
            }
            c.b("PhoneScripUtils", f38482b + " " + f38483c);
            return a(f38483c);
        }
        return invokeV.booleanValue;
    }

    public static void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
                a = null;
                f38482b = null;
                f38483c = 0L;
            }
        }
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
            a3.a("phonescripversion", 2);
            a3.a("pre_sim_key", str2);
            a3.b();
        }
    }

    public static void a(Context context, String str, long j, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, Long.valueOf(j), str2, str3}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j <= 0) {
            return;
        }
        c.b("PhoneScripUtils", "save phone scrip simKey = " + str2);
        a = str;
        long j2 = j * 1000;
        f38483c = System.currentTimeMillis() + j2;
        c.b("sLifeTime", f38483c + "");
        f38482b = str2;
        if (!"operator".equals(str3)) {
            n.a(new n.a(context, str, str2) { // from class: com.cmic.sso.sdk.e.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f38484b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f38485c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, str, str2};
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
                    this.f38484b = str;
                    this.f38485c = str2;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                        h.b(this.a, this.f38484b, h.f38483c, this.f38485c);
                    }
                }
            });
        } else if (j2 > 3600000) {
            f38483c = System.currentTimeMillis() + 3600000;
        } else {
            f38483c = System.currentTimeMillis() + j2;
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (TextUtils.isEmpty(a)) {
                String b2 = k.b("phonescripcache", "");
                if (TextUtils.isEmpty(b2)) {
                    c.a("PhoneScripUtils", StringUtil.NULL_STRING);
                    return null;
                }
                f38483c = k.a("phonescripstarttime", 0L);
                f38482b = k.b("pre_sim_key", "");
                String b3 = b.b(context, b2);
                a = b3;
                return b3;
            }
            return a;
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

    public static long a() {
        InterceptResult invokeV;
        long a2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(a)) {
                c.b("PhoneScripUtils", f38482b + " " + f38483c);
                a2 = f38483c;
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

    public static int a(String str) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(f38482b)) {
                b2 = f38482b;
            } else {
                b2 = k.b("pre_sim_key", "");
                f38482b = b2;
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
            if (k.a("phonescripversion", 0) != 2 && a2 != 0) {
                a(true, false);
                b.a();
                c.b("PhoneScripUtils", "phoneScriptVersion change");
                return false;
            } else if (a2 != 1) {
                if (a2 == 2) {
                    a(true, false);
                }
                return false;
            } else {
                return c();
            }
        }
        return invokeL.booleanValue;
    }
}
