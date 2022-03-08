package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.DebugKt;
import org.apache.commons.lang3.math.NumberUtils;
/* loaded from: classes9.dex */
public class BooleanUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BooleanUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean and(boolean... zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zArr)) == null) {
            if (zArr != null) {
                if (zArr.length != 0) {
                    for (boolean z : zArr) {
                        if (!z) {
                            return false;
                        }
                    }
                    return true;
                }
                throw new IllegalArgumentException("Array is empty");
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return invokeL.booleanValue;
    }

    public static int compare(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z == z2) {
                return 0;
            }
            return z ? 1 : -1;
        }
        return invokeCommon.intValue;
    }

    public static boolean isFalse(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bool)) == null) ? Boolean.FALSE.equals(bool) : invokeL.booleanValue;
    }

    public static boolean isNotFalse(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bool)) == null) ? !isFalse(bool) : invokeL.booleanValue;
    }

    public static boolean isNotTrue(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bool)) == null) ? !isTrue(bool) : invokeL.booleanValue;
    }

    public static boolean isTrue(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bool)) == null) ? Boolean.TRUE.equals(bool) : invokeL.booleanValue;
    }

    public static Boolean negate(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bool)) == null) {
            if (bool == null) {
                return null;
            }
            return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static boolean or(boolean... zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, zArr)) == null) {
            if (zArr != null) {
                if (zArr.length != 0) {
                    for (boolean z : zArr) {
                        if (z) {
                            return true;
                        }
                    }
                    return false;
                }
                throw new IllegalArgumentException("Array is empty");
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return invokeL.booleanValue;
    }

    public static boolean toBoolean(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? i2 != 0 : invokeI.booleanValue;
    }

    public static boolean toBoolean(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bool)) == null) ? bool != null && bool.booleanValue() : invokeL.booleanValue;
    }

    public static boolean toBooleanDefaultIfNull(Boolean bool, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65553, null, bool, z)) == null) ? bool == null ? z : bool.booleanValue() : invokeLZ.booleanValue;
    }

    public static Boolean toBooleanObject(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) ? i2 == 0 ? Boolean.FALSE : Boolean.TRUE : (Boolean) invokeI.objValue;
    }

    public static int toInteger(Boolean bool, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(65560, null, bool, i2, i3, i4)) == null) ? bool == null ? i4 : bool.booleanValue() ? i2 : i3 : invokeLIII.intValue;
    }

    public static int toInteger(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65561, null, z)) == null) ? z ? 1 : 0 : invokeZ.intValue;
    }

    public static int toInteger(boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? z ? i2 : i3 : invokeCommon.intValue;
    }

    public static Integer toIntegerObject(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65565, null, z)) == null) ? z ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO : (Integer) invokeZ.objValue;
    }

    public static Integer toIntegerObject(boolean z, Integer num, Integer num2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{Boolean.valueOf(z), num, num2})) == null) ? z ? num : num2 : (Integer) invokeCommon.objValue;
    }

    public static String toString(Boolean bool, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65567, null, bool, str, str2, str3)) == null) ? bool == null ? str3 : bool.booleanValue() ? str : str2 : (String) invokeLLLL.objValue;
    }

    public static String toString(boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65568, null, new Object[]{Boolean.valueOf(z), str, str2})) == null) ? z ? str : str2 : (String) invokeCommon.objValue;
    }

    public static String toStringOnOff(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, bool)) == null) ? toString(bool, DebugKt.DEBUG_PROPERTY_VALUE_ON, DebugKt.DEBUG_PROPERTY_VALUE_OFF, null) : (String) invokeL.objValue;
    }

    public static String toStringTrueFalse(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, bool)) == null) ? toString(bool, "true", "false", null) : (String) invokeL.objValue;
    }

    public static String toStringYesNo(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, bool)) == null) ? toString(bool, "yes", "no", null) : (String) invokeL.objValue;
    }

    public static boolean xor(boolean... zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, zArr)) == null) {
            if (zArr != null) {
                if (zArr.length != 0) {
                    boolean z = false;
                    for (boolean z2 : zArr) {
                        z ^= z2;
                    }
                    return z;
                }
                throw new IllegalArgumentException("Array is empty");
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return invokeL.booleanValue;
    }

    public static boolean toBoolean(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65548, null, i2, i3, i4)) == null) {
            if (i2 == i3) {
                return true;
            }
            if (i2 == i4) {
                return false;
            }
            throw new IllegalArgumentException("The Integer did not match either specified value");
        }
        return invokeIII.booleanValue;
    }

    public static Boolean toBooleanObject(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, num)) == null) {
            if (num == null) {
                return null;
            }
            return num.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static Integer toIntegerObject(Boolean bool) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bool)) == null) {
            if (bool == null) {
                return null;
            }
            return bool.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
        }
        return (Integer) invokeL.objValue;
    }

    public static String toStringOnOff(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65570, null, z)) == null) ? toString(z, DebugKt.DEBUG_PROPERTY_VALUE_ON, DebugKt.DEBUG_PROPERTY_VALUE_OFF) : (String) invokeZ.objValue;
    }

    public static String toStringTrueFalse(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65572, null, z)) == null) ? toString(z, "true", "false") : (String) invokeZ.objValue;
    }

    public static String toStringYesNo(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65574, null, z)) == null) ? toString(z, "yes", "no") : (String) invokeZ.objValue;
    }

    public static boolean toBoolean(Integer num, Integer num2, Integer num3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, num, num2, num3)) == null) {
            if (num == null) {
                if (num2 == null) {
                    return true;
                }
                if (num3 == null) {
                    return false;
                }
            } else if (num.equals(num2)) {
                return true;
            } else {
                if (num.equals(num3)) {
                    return false;
                }
            }
            throw new IllegalArgumentException("The Integer did not match either specified value");
        }
        return invokeLLL.booleanValue;
    }

    public static Boolean toBooleanObject(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65555, null, i2, i3, i4, i5)) == null) {
            if (i2 == i3) {
                return Boolean.TRUE;
            }
            if (i2 == i4) {
                return Boolean.FALSE;
            }
            if (i2 == i5) {
                return null;
            }
            throw new IllegalArgumentException("The Integer did not match any specified value");
        }
        return (Boolean) invokeIIII.objValue;
    }

    public static Integer toIntegerObject(Boolean bool, Integer num, Integer num2, Integer num3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65564, null, bool, num, num2, num3)) == null) ? bool == null ? num3 : bool.booleanValue() ? num : num2 : (Integer) invokeLLLL.objValue;
    }

    public static Boolean and(Boolean... boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, boolArr)) == null) {
            if (boolArr != null) {
                if (boolArr.length != 0) {
                    try {
                        return and(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (NullPointerException unused) {
                        throw new IllegalArgumentException("The array must not contain any null elements");
                    }
                }
                throw new IllegalArgumentException("Array is empty");
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return (Boolean) invokeL.objValue;
    }

    public static Boolean or(Boolean... boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, boolArr)) == null) {
            if (boolArr != null) {
                if (boolArr.length != 0) {
                    try {
                        return or(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (NullPointerException unused) {
                        throw new IllegalArgumentException("The array must not contain any null elements");
                    }
                }
                throw new IllegalArgumentException("Array is empty");
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return (Boolean) invokeL.objValue;
    }

    public static Boolean xor(Boolean... boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, boolArr)) == null) {
            if (boolArr != null) {
                if (boolArr.length != 0) {
                    try {
                        return xor(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (NullPointerException unused) {
                        throw new IllegalArgumentException("The array must not contain any null elements");
                    }
                }
                throw new IllegalArgumentException("Array is empty");
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return (Boolean) invokeL.objValue;
    }

    public static boolean toBoolean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? toBooleanObject(str) == Boolean.TRUE : invokeL.booleanValue;
    }

    public static Boolean toBooleanObject(Integer num, Integer num2, Integer num3, Integer num4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65557, null, num, num2, num3, num4)) == null) {
            if (num == null) {
                if (num2 == null) {
                    return Boolean.TRUE;
                }
                if (num3 == null) {
                    return Boolean.FALSE;
                }
                if (num4 == null) {
                    return null;
                }
            } else if (num.equals(num2)) {
                return Boolean.TRUE;
            } else {
                if (num.equals(num3)) {
                    return Boolean.FALSE;
                }
                if (num.equals(num4)) {
                    return null;
                }
            }
            throw new IllegalArgumentException("The Integer did not match any specified value");
        }
        return (Boolean) invokeLLLL.objValue;
    }

    public static boolean toBoolean(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, str, str2, str3)) == null) {
            if (str == str2) {
                return true;
            }
            if (str == str3) {
                return false;
            }
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
                if (str.equals(str3)) {
                    return false;
                }
            }
            throw new IllegalArgumentException("The String did not match either specified value");
        }
        return invokeLLL.booleanValue;
    }

    public static Boolean toBooleanObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (str == "true") {
                return Boolean.TRUE;
            }
            if (str == null) {
                return null;
            }
            int length = str.length();
            if (length == 1) {
                char charAt = str.charAt(0);
                if (charAt == 'y' || charAt == 'Y' || charAt == 't' || charAt == 'T') {
                    return Boolean.TRUE;
                }
                if (charAt == 'n' || charAt == 'N' || charAt == 'f' || charAt == 'F') {
                    return Boolean.FALSE;
                }
                return null;
            } else if (length == 2) {
                char charAt2 = str.charAt(0);
                char charAt3 = str.charAt(1);
                if ((charAt2 == 'o' || charAt2 == 'O') && (charAt3 == 'n' || charAt3 == 'N')) {
                    return Boolean.TRUE;
                }
                if (charAt2 == 'n' || charAt2 == 'N') {
                    if (charAt3 == 'o' || charAt3 == 'O') {
                        return Boolean.FALSE;
                    }
                    return null;
                }
                return null;
            } else if (length == 3) {
                char charAt4 = str.charAt(0);
                char charAt5 = str.charAt(1);
                char charAt6 = str.charAt(2);
                if ((charAt4 == 'y' || charAt4 == 'Y') && ((charAt5 == 'e' || charAt5 == 'E') && (charAt6 == 's' || charAt6 == 'S'))) {
                    return Boolean.TRUE;
                }
                if (charAt4 == 'o' || charAt4 == 'O') {
                    if (charAt5 == 'f' || charAt5 == 'F') {
                        if (charAt6 == 'f' || charAt6 == 'F') {
                            return Boolean.FALSE;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } else if (length == 4) {
                char charAt7 = str.charAt(0);
                char charAt8 = str.charAt(1);
                char charAt9 = str.charAt(2);
                char charAt10 = str.charAt(3);
                if (charAt7 == 't' || charAt7 == 'T') {
                    if (charAt8 == 'r' || charAt8 == 'R') {
                        if (charAt9 == 'u' || charAt9 == 'U') {
                            if (charAt10 == 'e' || charAt10 == 'E') {
                                return Boolean.TRUE;
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } else if (length != 5) {
                return null;
            } else {
                char charAt11 = str.charAt(0);
                char charAt12 = str.charAt(1);
                char charAt13 = str.charAt(2);
                char charAt14 = str.charAt(3);
                char charAt15 = str.charAt(4);
                if (charAt11 == 'f' || charAt11 == 'F') {
                    if (charAt12 == 'a' || charAt12 == 'A') {
                        if (charAt13 == 'l' || charAt13 == 'L') {
                            if (charAt14 == 's' || charAt14 == 'S') {
                                if (charAt15 == 'e' || charAt15 == 'E') {
                                    return Boolean.FALSE;
                                }
                                return null;
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
        }
        return (Boolean) invokeL.objValue;
    }

    public static Boolean toBooleanObject(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65559, null, str, str2, str3, str4)) == null) {
            if (str == null) {
                if (str2 == null) {
                    return Boolean.TRUE;
                }
                if (str3 == null) {
                    return Boolean.FALSE;
                }
                if (str4 == null) {
                    return null;
                }
            } else if (str.equals(str2)) {
                return Boolean.TRUE;
            } else {
                if (str.equals(str3)) {
                    return Boolean.FALSE;
                }
                if (str.equals(str4)) {
                    return null;
                }
            }
            throw new IllegalArgumentException("The String did not match any specified value");
        }
        return (Boolean) invokeLLLL.objValue;
    }
}
