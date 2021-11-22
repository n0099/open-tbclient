package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f71567a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f108a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f109a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f71568b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f71569c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f71570d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f71571e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f71572f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f71573g;
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
        String str = ae.f110a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f108a = str;
        boolean contains = str.contains("2A2FE0D7");
        f109a = contains;
        boolean z = false;
        f71568b = contains || "DEBUG".equalsIgnoreCase(f108a);
        f71569c = "LOGABLE".equalsIgnoreCase(f108a);
        f71570d = f108a.contains("YY");
        f71571e = f108a.equalsIgnoreCase("TEST");
        f71572f = "BETA".equalsIgnoreCase(f108a);
        String str2 = f108a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f71573g = z;
        f71567a = 1;
        if (f108a.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (!f108a.equalsIgnoreCase("ONEBOX")) {
            f71567a = 1;
            return;
        } else {
            i2 = 3;
        }
        f71567a = i2;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f71567a : invokeV.intValue;
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f71567a = i2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m142a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f71567a == 2 : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f71567a == 3 : invokeV.booleanValue;
    }
}
