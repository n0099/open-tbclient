package d.a.q0.w2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final long f66560a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f66561b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f66562c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(185838335, "Ld/a/q0/w2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(185838335, "Ld/a/q0/w2/e;");
                return;
            }
        }
        f66560a = TimeUnit.DAYS.toMillis(1L);
        TimeUnit.HOURS.toMillis(1L);
        f66561b = TimeUnit.MINUTES.toMillis(1L);
        f66562c = TimeUnit.SECONDS.toMillis(1L);
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

    public static String c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) ? str.substring(i2 + 1) : (String) invokeLI.objValue;
    }

    public static long d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            try {
                return Long.parseLong(str.substring(0, i2));
            } catch (Exception unused) {
                return -1L;
            }
        }
        return invokeLI.longValue;
    }

    public static boolean e(long j, long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? j - j2 > ((long) i2) * f66561b : invokeCommon.booleanValue;
    }

    public static boolean f(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = f66560a;
            return j / j3 == j2 / j3;
        }
        return invokeCommon.booleanValue;
    }

    public static void g(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, str, i2) == null) {
            h(str, String.valueOf(i2));
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
