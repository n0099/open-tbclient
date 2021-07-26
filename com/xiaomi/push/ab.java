package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f40099a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f103a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f104a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f40100b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f40101c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f40102d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f40103e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f40104f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f40105g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        int i2;
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
        String str = ae.f105a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f103a = str;
        boolean contains = str.contains("2A2FE0D7");
        f104a = contains;
        boolean z = false;
        f40100b = contains || "DEBUG".equalsIgnoreCase(f103a);
        f40101c = "LOGABLE".equalsIgnoreCase(f103a);
        f40102d = f103a.contains("YY");
        f40103e = f103a.equalsIgnoreCase("TEST");
        f40104f = "BETA".equalsIgnoreCase(f103a);
        String str2 = f103a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f40105g = z;
        f40099a = 1;
        if (f103a.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (!f103a.equalsIgnoreCase("ONEBOX")) {
            f40099a = 1;
            return;
        } else {
            i2 = 3;
        }
        f40099a = i2;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f40099a : invokeV.intValue;
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f40099a = i2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m139a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f40099a == 2 : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f40099a == 3 : invokeV.booleanValue;
    }
}
