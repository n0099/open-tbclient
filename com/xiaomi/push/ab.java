package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f76950a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f107a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f108a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f76951b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f76952c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f76953d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f76954e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f76955f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f76956g;
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
        String str = ae.f109a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f107a = str;
        boolean contains = str.contains("2A2FE0D7");
        f108a = contains;
        boolean z = false;
        f76951b = contains || "DEBUG".equalsIgnoreCase(f107a);
        f76952c = "LOGABLE".equalsIgnoreCase(f107a);
        f76953d = f107a.contains("YY");
        f76954e = f107a.equalsIgnoreCase("TEST");
        f76955f = "BETA".equalsIgnoreCase(f107a);
        String str2 = f107a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        f76956g = z;
        f76950a = 1;
        if (f107a.equalsIgnoreCase("SANDBOX")) {
            i2 = 2;
        } else if (!f107a.equalsIgnoreCase("ONEBOX")) {
            f76950a = 1;
            return;
        } else {
            i2 = 3;
        }
        f76950a = i2;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f76950a : invokeV.intValue;
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f76950a = i2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m142a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f76950a == 2 : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f76950a == 3 : invokeV.booleanValue;
    }
}
