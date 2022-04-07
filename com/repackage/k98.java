package com.repackage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class k98 {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public static final long b;
    public static final long c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755603929, "Lcom/repackage/k98;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755603929, "Lcom/repackage/k98;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(1L);
        TimeUnit.HOURS.toMillis(1L);
        b = TimeUnit.MINUTES.toMillis(1L);
        c = TimeUnit.SECONDS.toMillis(1L);
    }

    public static int a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                return 0;
            }
            try {
                return Integer.parseInt(b2);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Nullable
    public static String b(@NonNull String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String string = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getString(str, null);
            if (TextUtils.isEmpty(string) || (indexOf = string.indexOf(",")) == -1 || !f(d(string, indexOf), System.currentTimeMillis())) {
                return null;
            }
            try {
                return c(string, indexOf);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) ? str.substring(i + 1) : (String) invokeLI.objValue;
    }

    public static long d(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            try {
                return Long.parseLong(str.substring(0, i));
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeLI.longValue;
    }

    public static boolean e(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) ? j - j2 > ((long) i) * b : invokeCommon.booleanValue;
    }

    public static boolean f(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = a;
            return j / j3 == j2 / j3;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, str, i) == null) {
            h(str, String.valueOf(i));
        }
    }

    public static void h(@NonNull String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).edit();
            edit.putString(str, System.currentTimeMillis() + "," + str2);
            edit.apply();
        }
    }
}
