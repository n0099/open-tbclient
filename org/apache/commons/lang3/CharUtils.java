package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CharUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] CHAR_STRING_ARRAY;
    public static final char CR = '\r';
    public static final char[] HEX_DIGITS;
    public static final char LF = '\n';
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(852073211, "Lorg/apache/commons/lang3/CharUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(852073211, "Lorg/apache/commons/lang3/CharUtils;");
                return;
            }
        }
        CHAR_STRING_ARRAY = new String[128];
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char c2 = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c2 >= strArr.length) {
                return;
            }
            strArr[c2] = String.valueOf(c2);
            c2 = (char) (c2 + 1);
        }
    }

    public CharUtils() {
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

    public static int compare(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) ? c2 - c3 : invokeCommon.intValue;
    }

    public static boolean isAscii(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 < 128 : invokeCommon.booleanValue;
    }

    public static boolean isAsciiAlpha(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Character.valueOf(c2)})) == null) ? isAsciiAlphaUpper(c2) || isAsciiAlphaLower(c2) : invokeCommon.booleanValue;
    }

    public static boolean isAsciiAlphaLower(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= 'a' && c2 <= 'z' : invokeCommon.booleanValue;
    }

    public static boolean isAsciiAlphaUpper(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= 'A' && c2 <= 'Z' : invokeCommon.booleanValue;
    }

    public static boolean isAsciiAlphanumeric(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Character.valueOf(c2)})) == null) ? isAsciiAlpha(c2) || isAsciiNumeric(c2) : invokeCommon.booleanValue;
    }

    public static boolean isAsciiControl(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 < ' ' || c2 == 127 : invokeCommon.booleanValue;
    }

    public static boolean isAsciiNumeric(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= '0' && c2 <= '9' : invokeCommon.booleanValue;
    }

    public static boolean isAsciiPrintable(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= ' ' && c2 < 127 : invokeCommon.booleanValue;
    }

    public static char toChar(Character ch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ch)) == null) {
            if (ch != null) {
                return ch.charValue();
            }
            throw new IllegalArgumentException("The Character must not be null");
        }
        return invokeL.charValue;
    }

    @Deprecated
    public static Character toCharacterObject(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Character.valueOf(c2)})) == null) ? Character.valueOf(c2) : (Character) invokeCommon.objValue;
    }

    public static int toIntValue(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (isAsciiNumeric(c2)) {
                return c2 - '0';
            }
            throw new IllegalArgumentException("The character " + c2 + " is not in the range '0' - '9'");
        }
        return invokeCommon.intValue;
    }

    public static String toString(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < 128) {
                return CHAR_STRING_ARRAY[c2];
            }
            return new String(new char[]{c2});
        }
        return (String) invokeCommon.objValue;
    }

    public static String unicodeEscaped(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{Character.valueOf(c2)})) == null) {
            StringBuilder sb = new StringBuilder(6);
            sb.append("\\u");
            sb.append(HEX_DIGITS[(c2 >> '\f') & 15]);
            sb.append(HEX_DIGITS[(c2 >> '\b') & 15]);
            sb.append(HEX_DIGITS[(c2 >> 4) & 15]);
            sb.append(HEX_DIGITS[c2 & 15]);
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static Character toCharacterObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (StringUtils.isEmpty(str)) {
                return null;
            }
            return Character.valueOf(str.charAt(0));
        }
        return (Character) invokeL.objValue;
    }

    public static char toChar(Character ch, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{ch, Character.valueOf(c2)})) == null) ? ch == null ? c2 : ch.charValue() : invokeCommon.charValue;
    }

    public static int toIntValue(char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Character.valueOf(c2), Integer.valueOf(i2)})) == null) ? !isAsciiNumeric(c2) ? i2 : c2 - '0' : invokeCommon.intValue;
    }

    public static String toString(Character ch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, ch)) == null) {
            if (ch == null) {
                return null;
            }
            return toString(ch.charValue());
        }
        return (String) invokeL.objValue;
    }

    public static char toChar(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (!StringUtils.isEmpty(str)) {
                return str.charAt(0);
            }
            throw new IllegalArgumentException("The String must not be empty");
        }
        return invokeL.charValue;
    }

    public static int toIntValue(Character ch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, ch)) == null) {
            if (ch != null) {
                return toIntValue(ch.charValue());
            }
            throw new IllegalArgumentException("The character must not be null");
        }
        return invokeL.intValue;
    }

    public static int toIntValue(Character ch, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, ch, i2)) == null) ? ch == null ? i2 : toIntValue(ch.charValue(), i2) : invokeLI.intValue;
    }

    public static char toChar(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{str, Character.valueOf(c2)})) == null) ? StringUtils.isEmpty(str) ? c2 : str.charAt(0) : invokeCommon.charValue;
    }

    public static String unicodeEscaped(Character ch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, ch)) == null) {
            if (ch == null) {
                return null;
            }
            return unicodeEscaped(ch.charValue());
        }
        return (String) invokeL.objValue;
    }
}
