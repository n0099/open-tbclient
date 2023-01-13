package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic;
    public static int a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f116a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f117a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        int i;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56379748, "Lcom/xiaomi/push/ae;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56379748, "Lcom/xiaomi/push/ae;");
                return;
            }
        }
        String str = ah.f118a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f116a = str;
        boolean contains = str.contains("2A2FE0D7");
        f117a = contains;
        boolean z = false;
        b = contains || "DEBUG".equalsIgnoreCase(f116a);
        c = "LOGABLE".equalsIgnoreCase(f116a);
        d = f116a.contains("YY");
        e = f116a.equalsIgnoreCase("TEST");
        f = "BETA".equalsIgnoreCase(f116a);
        String str2 = f116a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        g = z;
        a = 1;
        if (f116a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (!f116a.equalsIgnoreCase("ONEBOX")) {
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
    public static boolean m177a() {
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
