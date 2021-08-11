package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes2.dex */
public class RandomStringUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Random RANDOM;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1506824409, "Lorg/apache/commons/lang3/RandomStringUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1506824409, "Lorg/apache/commons/lang3/RandomStringUtils;");
                return;
            }
        }
        RANDOM = new Random();
    }

    public RandomStringUtils() {
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

    public static String random(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? random(i2, false, false) : (String) invokeI.objValue;
    }

    public static String randomAlphabetic(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? random(i2, true, false) : (String) invokeI.objValue;
    }

    public static String randomAlphanumeric(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? random(i2, true, true) : (String) invokeI.objValue;
    }

    public static String randomAscii(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) ? random(i2, 32, 127, false, false) : (String) invokeI.objValue;
    }

    public static String randomGraph(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? random(i2, 33, 126, false, false) : (String) invokeI.objValue;
    }

    public static String randomNumeric(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? random(i2, false, true) : (String) invokeI.objValue;
    }

    public static String randomPrint(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) ? random(i2, 32, 126, false, false) : (String) invokeI.objValue;
    }

    public static String random(int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? random(i2, 0, 0, z, z2) : (String) invokeCommon.objValue;
    }

    public static String randomAlphabetic(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i2, i3)) == null) ? randomAlphabetic(RandomUtils.nextInt(i2, i3)) : (String) invokeII.objValue;
    }

    public static String randomAlphanumeric(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65548, null, i2, i3)) == null) ? randomAlphanumeric(RandomUtils.nextInt(i2, i3)) : (String) invokeII.objValue;
    }

    public static String randomAscii(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65550, null, i2, i3)) == null) ? randomAscii(RandomUtils.nextInt(i2, i3)) : (String) invokeII.objValue;
    }

    public static String randomGraph(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65552, null, i2, i3)) == null) ? randomGraph(RandomUtils.nextInt(i2, i3)) : (String) invokeII.objValue;
    }

    public static String randomNumeric(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65554, null, i2, i3)) == null) ? randomNumeric(RandomUtils.nextInt(i2, i3)) : (String) invokeII.objValue;
    }

    public static String randomPrint(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65556, null, i2, i3)) == null) ? randomPrint(RandomUtils.nextInt(i2, i3)) : (String) invokeII.objValue;
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? random(i2, i3, i4, z, z2, null, RANDOM) : (String) invokeCommon.objValue;
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2, char... cArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2), cArr})) == null) ? random(i2, i3, i4, z, z2, cArr, RANDOM) : (String) invokeCommon.objValue;
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2, char[] cArr, Random random) {
        InterceptResult invokeCommon;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2), cArr, random})) != null) {
            return (String) invokeCommon.objValue;
        }
        if (i2 == 0) {
            return "";
        }
        if (i2 >= 0) {
            if (cArr != null && cArr.length == 0) {
                throw new IllegalArgumentException("The chars array must not be empty");
            }
            if (i3 == 0 && i4 == 0) {
                if (cArr != null) {
                    i4 = cArr.length;
                } else if (z || z2) {
                    i4 = 123;
                    i3 = 32;
                } else {
                    i4 = Integer.MAX_VALUE;
                }
            } else if (i4 <= i3) {
                throw new IllegalArgumentException("Parameter end (" + i4 + ") must be greater than start (" + i3 + SmallTailInfo.EMOTION_SUFFIX);
            }
            char[] cArr2 = new char[i2];
            int i5 = i4 - i3;
            while (true) {
                int i6 = i2 - 1;
                if (i2 != 0) {
                    if (cArr == null) {
                        c2 = (char) (random.nextInt(i5) + i3);
                    } else {
                        c2 = cArr[random.nextInt(i5) + i3];
                    }
                    if ((z && Character.isLetter(c2)) || ((z2 && Character.isDigit(c2)) || (!z && !z2))) {
                        if (c2 < 56320 || c2 > 57343) {
                            if (c2 < 55296 || c2 > 56191) {
                                if (c2 < 56192 || c2 > 56319) {
                                    cArr2[i6] = c2;
                                }
                            } else if (i6 != 0) {
                                cArr2[i6] = (char) (random.nextInt(128) + 56320);
                                i6--;
                                cArr2[i6] = c2;
                            }
                        } else if (i6 != 0) {
                            cArr2[i6] = c2;
                            i6--;
                            cArr2[i6] = (char) (random.nextInt(128) + 55296);
                        }
                        i2 = i6;
                    }
                    i6++;
                    i2 = i6;
                } else {
                    return new String(cArr2);
                }
            }
        } else {
            throw new IllegalArgumentException("Requested random string length " + i2 + " is less than 0.");
        }
    }

    public static String random(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, str)) == null) {
            if (str == null) {
                return random(i2, 0, 0, false, false, null, RANDOM);
            }
            return random(i2, str.toCharArray());
        }
        return (String) invokeIL.objValue;
    }

    public static String random(int i2, char... cArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i2, cArr)) == null) {
            if (cArr == null) {
                return random(i2, 0, 0, false, false, null, RANDOM);
            }
            return random(i2, 0, cArr.length, false, false, cArr, RANDOM);
        }
        return (String) invokeIL.objValue;
    }
}
