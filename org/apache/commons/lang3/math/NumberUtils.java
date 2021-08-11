package org.apache.commons.lang3.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
/* loaded from: classes2.dex */
public class NumberUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Byte BYTE_MINUS_ONE;
    public static final Byte BYTE_ONE;
    public static final Byte BYTE_ZERO;
    public static final Double DOUBLE_MINUS_ONE;
    public static final Double DOUBLE_ONE;
    public static final Double DOUBLE_ZERO;
    public static final Float FLOAT_MINUS_ONE;
    public static final Float FLOAT_ONE;
    public static final Float FLOAT_ZERO;
    public static final Integer INTEGER_MINUS_ONE;
    public static final Integer INTEGER_ONE;
    public static final Integer INTEGER_ZERO;
    public static final Long LONG_MINUS_ONE;
    public static final Long LONG_ONE;
    public static final Long LONG_ZERO;
    public static final Short SHORT_MINUS_ONE;
    public static final Short SHORT_ONE;
    public static final Short SHORT_ZERO;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1122425985, "Lorg/apache/commons/lang3/math/NumberUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1122425985, "Lorg/apache/commons/lang3/math/NumberUtils;");
                return;
            }
        }
        LONG_ZERO = 0L;
        LONG_ONE = 1L;
        LONG_MINUS_ONE = -1L;
        INTEGER_ZERO = 0;
        INTEGER_ONE = 1;
        INTEGER_MINUS_ONE = -1;
        SHORT_ZERO = (short) 0;
        SHORT_ONE = (short) 1;
        SHORT_MINUS_ONE = (short) -1;
        BYTE_ZERO = (byte) 0;
        BYTE_ONE = (byte) 1;
        BYTE_MINUS_ONE = (byte) -1;
        DOUBLE_ZERO = Double.valueOf(0.0d);
        DOUBLE_ONE = Double.valueOf(1.0d);
        DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
        FLOAT_ZERO = Float.valueOf(0.0f);
        FLOAT_ONE = Float.valueOf(1.0f);
        FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    }

    public NumberUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int compare(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) ? b2 - b3 : invokeCommon.intValue;
    }

    public static int compare(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i2 == i3) {
                return 0;
            }
            return i2 < i3 ? -1 : 1;
        }
        return invokeII.intValue;
    }

    public static int compare(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 < 0 ? -1 : 1;
        }
        return invokeCommon.intValue;
    }

    public static int compare(short s, short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Short.valueOf(s), Short.valueOf(s2)})) == null) {
            if (s == s2) {
                return 0;
            }
            return s < s2 ? -1 : 1;
        }
        return invokeCommon.intValue;
    }

    public static BigDecimal createBigDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (!StringUtils.isBlank(str)) {
                if (!str.trim().startsWith("--")) {
                    return new BigDecimal(str);
                }
                throw new NumberFormatException(str + " is not a valid number.");
            }
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return (BigDecimal) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BigInteger createBigInteger(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, str)) != null) {
            return (BigInteger) invokeL.objValue;
        }
        if (str == null) {
            return null;
        }
        int i3 = 10;
        int i4 = 0;
        boolean z = true;
        if (str.startsWith("-")) {
            i4 = 1;
        } else {
            z = false;
        }
        if (str.startsWith("0x", i4) || str.startsWith("0X", i4)) {
            i4 += 2;
        } else if (!str.startsWith("#", i4)) {
            if (str.startsWith("0", i4) && str.length() > (i2 = i4 + 1)) {
                i3 = 8;
                i4 = i2;
            }
            BigInteger bigInteger = new BigInteger(str.substring(i4), i3);
            return !z ? bigInteger.negate() : bigInteger;
        } else {
            i4++;
        }
        i3 = 16;
        BigInteger bigInteger2 = new BigInteger(str.substring(i4), i3);
        if (!z) {
        }
    }

    public static Double createDouble(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Double.valueOf(str);
        }
        return (Double) invokeL.objValue;
    }

    public static Float createFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Float.valueOf(str);
        }
        return (Float) invokeL.objValue;
    }

    public static Integer createInteger(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Integer.decode(str);
        }
        return (Integer) invokeL.objValue;
    }

    public static Long createLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Long.decode(str);
        }
        return (Long) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x013a, code lost:
        if (r1 == 'l') goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Number createNumber(String str) throws NumberFormatException {
        InterceptResult invokeL;
        int i2;
        String mantissa;
        String str2;
        Float createFloat;
        Double createDouble;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            String str3 = null;
            if (str == null) {
                return null;
            }
            if (!StringUtils.isBlank(str)) {
                String[] strArr = {"0x", "0X", "-0x", "-0X", "#", "-#"};
                char c2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= 6) {
                        i2 = 0;
                        break;
                    }
                    String str4 = strArr[i3];
                    if (str.startsWith(str4)) {
                        i2 = str4.length() + 0;
                        break;
                    }
                    i3++;
                }
                if (i2 > 0) {
                    int i4 = i2;
                    while (i2 < str.length() && (c2 = str.charAt(i2)) == '0') {
                        i4++;
                        i2++;
                    }
                    int length = str.length() - i4;
                    if (length > 16 || (length == 16 && c2 > '7')) {
                        return createBigInteger(str);
                    }
                    if (length <= 8 && (length != 8 || c2 <= '7')) {
                        return createInteger(str);
                    }
                    return createLong(str);
                }
                char charAt = str.charAt(str.length() - 1);
                int indexOf = str.indexOf(46);
                int indexOf2 = str.indexOf(101) + str.indexOf(69) + 1;
                if (indexOf > -1) {
                    if (indexOf2 > -1) {
                        if (indexOf2 >= indexOf && indexOf2 <= str.length()) {
                            str2 = str.substring(indexOf + 1, indexOf2);
                        } else {
                            throw new NumberFormatException(str + " is not a valid number.");
                        }
                    } else {
                        str2 = str.substring(indexOf + 1);
                    }
                    mantissa = getMantissa(str, indexOf);
                } else {
                    if (indexOf2 > -1) {
                        if (indexOf2 <= str.length()) {
                            mantissa = getMantissa(str, indexOf2);
                        } else {
                            throw new NumberFormatException(str + " is not a valid number.");
                        }
                    } else {
                        mantissa = getMantissa(str);
                    }
                    str2 = null;
                }
                if (!Character.isDigit(charAt) && charAt != '.') {
                    if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                        str3 = str.substring(indexOf2 + 1, str.length() - 1);
                    }
                    String substring = str.substring(0, str.length() - 1);
                    boolean z = isAllZeros(mantissa) && isAllZeros(str3);
                    if (charAt != 'D') {
                        if (charAt != 'F') {
                            if (charAt != 'L') {
                                if (charAt != 'd') {
                                    if (charAt != 'f') {
                                    }
                                }
                            }
                            if (str2 == null && str3 == null && ((substring.charAt(0) == '-' && isDigits(substring.substring(1))) || isDigits(substring))) {
                                try {
                                    return createLong(substring);
                                } catch (NumberFormatException unused) {
                                    return createBigInteger(substring);
                                }
                            }
                            throw new NumberFormatException(str + " is not a valid number.");
                        }
                        try {
                            Float createFloat2 = createFloat(str);
                            if (!createFloat2.isInfinite()) {
                                if (createFloat2.floatValue() != 0.0f || z) {
                                    return createFloat2;
                                }
                            }
                        } catch (NumberFormatException unused2) {
                        }
                    }
                    try {
                        Double createDouble2 = createDouble(str);
                        if (!createDouble2.isInfinite()) {
                            if (createDouble2.floatValue() != 0.0d || z) {
                                return createDouble2;
                            }
                        }
                    } catch (NumberFormatException unused3) {
                    }
                    try {
                        return createBigDecimal(substring);
                    } catch (NumberFormatException unused4) {
                        throw new NumberFormatException(str + " is not a valid number.");
                    }
                }
                if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                    str3 = str.substring(indexOf2 + 1, str.length());
                }
                if (str2 == null && str3 == null) {
                    try {
                        try {
                            return createInteger(str);
                        } catch (NumberFormatException unused5) {
                            return createLong(str);
                        }
                    } catch (NumberFormatException unused6) {
                        return createBigInteger(str);
                    }
                }
                if (isAllZeros(mantissa) && isAllZeros(str3)) {
                    c2 = 1;
                }
                try {
                    createFloat = createFloat(str);
                    createDouble = createDouble(str);
                } catch (NumberFormatException unused7) {
                }
                if (createFloat.isInfinite() || ((createFloat.floatValue() == 0.0f && c2 == 0) || !createFloat.toString().equals(createDouble.toString()))) {
                    if (!createDouble.isInfinite() && (createDouble.doubleValue() != 0.0d || c2 != 0)) {
                        BigDecimal createBigDecimal = createBigDecimal(str);
                        return createBigDecimal.compareTo(BigDecimal.valueOf(createDouble.doubleValue())) == 0 ? createDouble : createBigDecimal;
                    }
                    return createBigDecimal(str);
                }
                return createFloat;
            }
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return (Number) invokeL.objValue;
    }

    public static String getMantissa(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? getMantissa(str, str.length()) : (String) invokeL.objValue;
    }

    public static boolean isAllZeros(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (str == null) {
                return true;
            }
            for (int length = str.length() - 1; length >= 0; length--) {
                if (str.charAt(length) != '0') {
                    return false;
                }
            }
            return str.length() > 0;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00e8, code lost:
        if (r0[r3] != 'F') goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00ea, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00ef, code lost:
        if (r0[r3] == 'l') goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x00f5, code lost:
        if (r0[r3] != 'L') goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00f8, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00f9, code lost:
        if (r13 == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00fb, code lost:
        if (r14 != false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00fd, code lost:
        if (r15 != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00ff, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0101, code lost:
        if (r8 != false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0103, code lost:
        if (r13 == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0105, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0127, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0143, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:?, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a8, code lost:
        if (r3 >= r0.length) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ac, code lost:
        if (r0[r3] < '0') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00b0, code lost:
        if (r0[r3] > '9') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00b4, code lost:
        if (org.apache.commons.lang3.SystemUtils.IS_JAVA_1_6 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00b6, code lost:
        if (r7 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00b8, code lost:
        if (r15 != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ba, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00bb, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00be, code lost:
        if (r0[r3] == 'e') goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00c2, code lost:
        if (r0[r3] != 'E') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00c7, code lost:
        if (r0[r3] != '.') goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00c9, code lost:
        if (r15 != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00cb, code lost:
        if (r14 == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00ce, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00cf, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00d0, code lost:
        if (r8 != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00d6, code lost:
        if (r0[r3] == 'd') goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00dc, code lost:
        if (r0[r3] == 'D') goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00e2, code lost:
        if (r0[r3] == 'f') goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isCreatable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65552, null, str)) != null) {
            return invokeL.booleanValue;
        }
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z = true;
        int i2 = (charArray[0] == '-' || charArray[0] == '+') ? 1 : 0;
        boolean z2 = i2 == 1 && charArray[0] == '+';
        int i3 = i2 + 1;
        if (length > i3 && charArray[i2] == '0') {
            if (charArray[i3] == 'x' || charArray[i3] == 'X') {
                int i4 = i2 + 2;
                if (i4 == length) {
                    return false;
                }
                while (i4 < charArray.length) {
                    if ((charArray[i4] < '0' || charArray[i4] > '9') && ((charArray[i4] < 'a' || charArray[i4] > 'f') && (charArray[i4] < 'A' || charArray[i4] > 'F'))) {
                        return false;
                    }
                    i4++;
                }
                return true;
            } else if (Character.isDigit(charArray[i3])) {
                while (i3 < charArray.length) {
                    if (charArray[i3] < '0' || charArray[i3] > '7') {
                        return false;
                    }
                    i3++;
                }
                return true;
            }
        }
        int i5 = length - 1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (i2 >= i5 && (i2 >= i5 + 1 || !z3 || z4)) {
                break;
            }
            if (charArray[i2] >= '0' && charArray[i2] <= '9') {
                z3 = false;
                z4 = true;
            } else if (charArray[i2] == '.') {
                if (z6 || z5) {
                    break;
                }
                z6 = true;
            } else if (charArray[i2] != 'e' && charArray[i2] != 'E') {
                if (charArray[i2] != '+' && charArray[i2] != '-') {
                    return false;
                }
                z3 = false;
                z4 = false;
            } else if (z5 || !z4) {
                return false;
            } else {
                z3 = true;
                z5 = true;
            }
            i2++;
            z = true;
        }
    }

    public static boolean isDigits(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? StringUtils.isNumeric(str) : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? isCreatable(str) : invokeL.booleanValue;
    }

    public static boolean isParsable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
                return false;
            }
            if (str.charAt(0) == '-') {
                if (str.length() == 1) {
                    return false;
                }
                return withDecimalsParsing(str, 1);
            }
            return withDecimalsParsing(str, 0);
        }
        return invokeL.booleanValue;
    }

    public static byte max(byte b2, byte b3, byte b4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4)})) == null) {
            if (b3 > b2) {
                b2 = b3;
            }
            return b4 > b2 ? b4 : b2;
        }
        return invokeCommon.byteValue;
    }

    public static int max(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65562, null, i2, i3, i4)) == null) {
            if (i3 > i2) {
                i2 = i3;
            }
            return i4 > i2 ? i4 : i2;
        }
        return invokeIII.intValue;
    }

    public static long max(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            if (j3 > j2) {
                j2 = j3;
            }
            return j4 > j2 ? j4 : j2;
        }
        return invokeCommon.longValue;
    }

    public static long max(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, jArr)) == null) {
            validateArray(jArr);
            long j2 = jArr[0];
            for (int i2 = 1; i2 < jArr.length; i2++) {
                if (jArr[i2] > j2) {
                    j2 = jArr[i2];
                }
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static short max(short s, short s2, short s3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{Short.valueOf(s), Short.valueOf(s2), Short.valueOf(s3)})) == null) {
            if (s2 > s) {
                s = s2;
            }
            return s3 > s ? s3 : s;
        }
        return invokeCommon.shortValue;
    }

    public static byte min(byte b2, byte b3, byte b4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65568, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4)})) == null) {
            if (b3 < b2) {
                b2 = b3;
            }
            return b4 < b2 ? b4 : b2;
        }
        return invokeCommon.byteValue;
    }

    public static int min(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65574, null, i2, i3, i4)) == null) {
            if (i3 < i2) {
                i2 = i3;
            }
            return i4 < i2 ? i4 : i2;
        }
        return invokeIII.intValue;
    }

    public static long min(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            if (j3 < j2) {
                j2 = j3;
            }
            return j4 < j2 ? j4 : j2;
        }
        return invokeCommon.longValue;
    }

    public static long min(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, jArr)) == null) {
            validateArray(jArr);
            long j2 = jArr[0];
            for (int i2 = 1; i2 < jArr.length; i2++) {
                if (jArr[i2] < j2) {
                    j2 = jArr[i2];
                }
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static short min(short s, short s2, short s3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65578, null, new Object[]{Short.valueOf(s), Short.valueOf(s2), Short.valueOf(s3)})) == null) {
            if (s2 < s) {
                s = s2;
            }
            return s3 < s ? s3 : s;
        }
        return invokeCommon.shortValue;
    }

    public static byte toByte(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) ? toByte(str, (byte) 0) : invokeL.byteValue;
    }

    public static double toDouble(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) ? toDouble(str, 0.0d) : invokeL.doubleValue;
    }

    public static float toFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) ? toFloat(str, 0.0f) : invokeL.floatValue;
    }

    public static int toInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65586, null, str)) == null) ? toInt(str, 0) : invokeL.intValue;
    }

    public static long toLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65588, null, str)) == null) ? toLong(str, 0L) : invokeL.longValue;
    }

    public static short toShort(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65590, null, str)) == null) ? toShort(str, (short) 0) : invokeL.shortValue;
    }

    public static void validateArray(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, null, obj) == null) {
            if (obj != null) {
                Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
                return;
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
    }

    public static boolean withDecimalsParsing(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65593, null, str, i2)) == null) {
            int i3 = 0;
            while (i2 < str.length()) {
                boolean z = str.charAt(i2) == '.';
                if (z) {
                    i3++;
                }
                if (i3 > 1) {
                    return false;
                }
                if (!z && !Character.isDigit(str.charAt(i2))) {
                    return false;
                }
                i2++;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static String getMantissa(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, str, i2)) == null) {
            char charAt = str.charAt(0);
            return charAt == '-' || charAt == '+' ? str.substring(1, i2) : str.substring(0, i2);
        }
        return (String) invokeLI.objValue;
    }

    public static byte toByte(String str, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65581, null, new Object[]{str, Byte.valueOf(b2)})) == null) {
            if (str == null) {
                return b2;
            }
            try {
                return Byte.parseByte(str);
            } catch (NumberFormatException unused) {
                return b2;
            }
        }
        return invokeCommon.byteValue;
    }

    public static double toDouble(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, null, new Object[]{str, Double.valueOf(d2)})) == null) {
            if (str == null) {
                return d2;
            }
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                return d2;
            }
        }
        return invokeCommon.doubleValue;
    }

    public static float toFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65585, null, str, f2)) == null) {
            if (str == null) {
                return f2;
            }
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                return f2;
            }
        }
        return invokeLF.floatValue;
    }

    public static int toInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65587, null, str, i2)) == null) {
            if (str == null) {
                return i2;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static long toLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65589, null, str, j2)) == null) {
            if (str == null) {
                return j2;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return j2;
            }
        }
        return invokeLJ.longValue;
    }

    public static short toShort(String str, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65591, null, new Object[]{str, Short.valueOf(s)})) == null) {
            if (str == null) {
                return s;
            }
            try {
                return Short.parseShort(str);
            } catch (NumberFormatException unused) {
                return s;
            }
        }
        return invokeCommon.shortValue;
    }

    public static int max(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, iArr)) == null) {
            validateArray(iArr);
            int i2 = iArr[0];
            for (int i3 = 1; i3 < iArr.length; i3++) {
                if (iArr[i3] > i2) {
                    i2 = iArr[i3];
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int min(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, iArr)) == null) {
            validateArray(iArr);
            int i2 = iArr[0];
            for (int i3 = 1; i3 < iArr.length; i3++) {
                if (iArr[i3] < i2) {
                    i2 = iArr[i3];
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static short max(short... sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, sArr)) == null) {
            validateArray(sArr);
            short s = sArr[0];
            for (int i2 = 1; i2 < sArr.length; i2++) {
                if (sArr[i2] > s) {
                    s = sArr[i2];
                }
            }
            return s;
        }
        return invokeL.shortValue;
    }

    public static short min(short... sArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, sArr)) == null) {
            validateArray(sArr);
            short s = sArr[0];
            for (int i2 = 1; i2 < sArr.length; i2++) {
                if (sArr[i2] < s) {
                    s = sArr[i2];
                }
            }
            return s;
        }
        return invokeL.shortValue;
    }

    public static byte max(byte... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bArr)) == null) {
            validateArray(bArr);
            byte b2 = bArr[0];
            for (int i2 = 1; i2 < bArr.length; i2++) {
                if (bArr[i2] > b2) {
                    b2 = bArr[i2];
                }
            }
            return b2;
        }
        return invokeL.byteValue;
    }

    public static byte min(byte... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, bArr)) == null) {
            validateArray(bArr);
            byte b2 = bArr[0];
            for (int i2 = 1; i2 < bArr.length; i2++) {
                if (bArr[i2] < b2) {
                    b2 = bArr[i2];
                }
            }
            return b2;
        }
        return invokeL.byteValue;
    }

    public static double max(double... dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, dArr)) == null) {
            validateArray(dArr);
            double d2 = dArr[0];
            for (int i2 = 1; i2 < dArr.length; i2++) {
                if (Double.isNaN(dArr[i2])) {
                    return Double.NaN;
                }
                if (dArr[i2] > d2) {
                    d2 = dArr[i2];
                }
            }
            return d2;
        }
        return invokeL.doubleValue;
    }

    public static double min(double... dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, dArr)) == null) {
            validateArray(dArr);
            double d2 = dArr[0];
            for (int i2 = 1; i2 < dArr.length; i2++) {
                if (Double.isNaN(dArr[i2])) {
                    return Double.NaN;
                }
                if (dArr[i2] < d2) {
                    d2 = dArr[i2];
                }
            }
            return d2;
        }
        return invokeL.doubleValue;
    }

    public static float max(float... fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, fArr)) == null) {
            validateArray(fArr);
            float f2 = fArr[0];
            for (int i2 = 1; i2 < fArr.length; i2++) {
                if (Float.isNaN(fArr[i2])) {
                    return Float.NaN;
                }
                if (fArr[i2] > f2) {
                    f2 = fArr[i2];
                }
            }
            return f2;
        }
        return invokeL.floatValue;
    }

    public static float min(float... fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, fArr)) == null) {
            validateArray(fArr);
            float f2 = fArr[0];
            for (int i2 = 1; i2 < fArr.length; i2++) {
                if (Float.isNaN(fArr[i2])) {
                    return Float.NaN;
                }
                if (fArr[i2] < f2) {
                    f2 = fArr[i2];
                }
            }
            return f2;
        }
        return invokeL.floatValue;
    }

    public static double max(double d2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) ? Math.max(Math.max(d2, d3), d4) : invokeCommon.doubleValue;
    }

    public static double min(double d2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) ? Math.min(Math.min(d2, d3), d4) : invokeCommon.doubleValue;
    }

    public static float max(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.max(Math.max(f2, f3), f4) : invokeCommon.floatValue;
    }

    public static float min(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.min(Math.min(f2, f3), f4) : invokeCommon.floatValue;
    }
}
