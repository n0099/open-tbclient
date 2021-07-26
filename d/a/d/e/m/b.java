package d.a.d.e.m;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, str, z)) == null) {
            if (str == null) {
                return z;
            }
            try {
                return Boolean.parseBoolean(str);
            } catch (Exception unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static double b(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Double.valueOf(d2)})) == null) {
            if (str == null) {
                return d2;
            }
            try {
                return Double.parseDouble(str);
            } catch (Exception unused) {
                return d2;
            }
        }
        return invokeCommon.doubleValue;
    }

    public static float c(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, str, f2)) == null) {
            if (str == null) {
                return f2;
            }
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return f2;
            }
        }
        return invokeLF.floatValue;
    }

    public static int d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            if (str == null) {
                return i2;
            }
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static int e(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3)) == null) {
            if (str == null) {
                return i2;
            }
            try {
                return Integer.parseInt(str, i3);
            } catch (Exception unused) {
                return i2;
            }
        }
        return invokeLII.intValue;
    }

    public static long f(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, str, j)) == null) {
            if (str == null) {
                return j;
            }
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return j;
            }
        }
        return invokeLJ.longValue;
    }
}
