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
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;
    public static String b = null;
    public static long c = 0;
    public static int d = -1;
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

    public static int a(String str) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(b)) {
                b2 = b;
            } else {
                b2 = k.b("pre_sim_key", "");
                b = b2;
            }
            if (TextUtils.isEmpty(b2)) {
                return 0;
            }
            if (b2.equals(str)) {
                return 1;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static long a() {
        InterceptResult invokeV;
        long a2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(a)) {
                c.b("PhoneScripUtils", b + " " + c);
                a2 = c;
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

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (!TextUtils.isEmpty(a)) {
                c.b("PhoneScripUtils", b + " " + c);
                return a(c);
            }
            String b2 = k.b("phonescripcache", "");
            long a2 = k.a("phonescripstarttime", 0L);
            if (!TextUtils.isEmpty(b2) && a(a2)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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
                c = k.a("phonescripstarttime", 0L);
                b = k.b("pre_sim_key", "");
                d = k.a("phonescripversion", -1);
                String b3 = b.b(context, b2);
                a = b3;
                return b3;
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str, long j, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, Long.valueOf(j), str2, str3}) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j > 0) {
            c.b("PhoneScripUtils", "save phone scrip simKey = " + str2);
            a = str;
            long j2 = j * 1000;
            c = System.currentTimeMillis() + j2;
            c.b("sLifeTime", c + "");
            b = str2;
            d = 2;
            if (!"operator".equals(str3)) {
                n.a(new n.a(context, str, str2) { // from class: com.cmic.sso.sdk.e.h.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;
                    public final /* synthetic */ String b;
                    public final /* synthetic */ String c;

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
                        this.b = str;
                        this.c = str2;
                    }

                    @Override // com.cmic.sso.sdk.e.n.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            c.b("PhoneScripUtils", "start save scrip to sp in sub thread");
                            h.b(this.a, this.b, h.c, this.c);
                        }
                    }
                });
            } else if (j2 > 3600000) {
                c = System.currentTimeMillis() + 3600000;
            } else {
                c = System.currentTimeMillis() + j2;
            }
        }
    }

    public static void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            k.a a2 = k.a();
            a2.a("phonescripstarttime");
            a2.a("phonescripcache");
            a2.a("pre_sim_key");
            a2.a("phonescripversion");
            if (z2) {
                a2.a();
            } else {
                a2.b();
            }
            if (z) {
                a = null;
                b = null;
                c = 0L;
                d = -1;
            }
        }
    }

    public static boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.b("PhoneScripUtils", j + "");
            c.b("PhoneScripUtils", currentTimeMillis + "");
            if (j - currentTimeMillis > 10000) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public static boolean a(com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            int a2 = a(aVar.b("scripKey"));
            aVar.a("imsiState", a2 + "");
            c.b("PhoneScripUtils", "simState = " + a2);
            if (a2 == 0) {
                return false;
            }
            if (d == -1) {
                d = k.a("phonescripversion", -1);
            }
            if (d != 2) {
                a(true, false);
                b.a();
                c.b("PhoneScripUtils", "phoneScriptVersion change");
                return false;
            } else if (a2 == 2) {
                a(true, false);
                return false;
            } else {
                return c();
            }
        }
        return invokeL.booleanValue;
    }

    public static void b(Context context, String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, Long.valueOf(j), str2}) == null) {
            String a2 = b.a(context, str);
            if (!TextUtils.isEmpty(a2)) {
                k.a a3 = k.a();
                a3.a("phonescripcache", a2);
                a3.a("phonescripstarttime", j);
                a3.a("phonescripversion", 2);
                a3.a("pre_sim_key", str2);
                a3.b();
            }
        }
    }
}
