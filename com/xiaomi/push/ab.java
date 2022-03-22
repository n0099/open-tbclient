package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f84a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f85a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44084b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44085c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44086d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44087e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44088f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44089g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        int i;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56379841, "Lcom/xiaomi/push/ab;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56379841, "Lcom/xiaomi/push/ab;");
                return;
            }
        }
        String str = ae.f86a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f84a = str;
        boolean contains = str.contains("2A2FE0D7");
        f85a = contains;
        boolean z = false;
        f44084b = contains || "DEBUG".equalsIgnoreCase(f84a);
        f44085c = "LOGABLE".equalsIgnoreCase(f84a);
        f44086d = f84a.contains("YY");
        f44087e = f84a.equalsIgnoreCase("TEST");
        f44088f = "BETA".equalsIgnoreCase(f84a);
        String str2 = f84a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f44089g = z;
        a = 1;
        if (f84a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f84a.equalsIgnoreCase("ONEBOX")) {
            a = 1;
            return;
        } else {
            i = 3;
        }
        a = i;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : invokeV.intValue;
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            a = i;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m181a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a == 2 : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a == 3 : invokeV.booleanValue;
    }
}
