package org.apache.commons.lang3.text;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
/* loaded from: classes4.dex */
public class WordUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WordUtils() {
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

    public static String capitalize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? capitalize(str, null) : (String) invokeL.objValue;
    }

    public static String capitalizeFully(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? capitalizeFully(str, null) : (String) invokeL.objValue;
    }

    public static boolean containsAllWords(CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, charSequence, charSequenceArr)) == null) {
            if (StringUtils.isEmpty(charSequence) || ArrayUtils.isEmpty(charSequenceArr)) {
                return false;
            }
            for (CharSequence charSequence2 : charSequenceArr) {
                if (StringUtils.isBlank(charSequence2)) {
                    return false;
                }
                if (!Pattern.compile(".*\\b" + ((Object) charSequence2) + "\\b.*").matcher(charSequence).matches()) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static String initials(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? initials(str, null) : (String) invokeL.objValue;
    }

    public static boolean isDelimiter(char c2, char[] cArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Character.valueOf(c2), cArr})) == null) {
            if (cArr == null) {
                return Character.isWhitespace(c2);
            }
            for (char c3 : cArr) {
                if (c2 == c3) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static String swapCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            char[] charArray = str.toCharArray();
            boolean z = true;
            for (int i2 = 0; i2 < charArray.length; i2++) {
                char c2 = charArray[i2];
                if (Character.isUpperCase(c2)) {
                    charArray[i2] = Character.toLowerCase(c2);
                } else if (Character.isTitleCase(c2)) {
                    charArray[i2] = Character.toLowerCase(c2);
                } else {
                    if (!Character.isLowerCase(c2)) {
                        z = Character.isWhitespace(c2);
                    } else if (z) {
                        charArray[i2] = Character.toTitleCase(c2);
                    } else {
                        charArray[i2] = Character.toUpperCase(c2);
                    }
                }
                z = false;
            }
            return new String(charArray);
        }
        return (String) invokeL.objValue;
    }

    public static String uncapitalize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? uncapitalize(str, null) : (String) invokeL.objValue;
    }

    public static String wrap(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, str, i2)) == null) ? wrap(str, i2, null, false) : (String) invokeLI.objValue;
    }

    public static String capitalize(String str, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, cArr)) == null) {
            int length = cArr == null ? -1 : cArr.length;
            if (StringUtils.isEmpty(str) || length == 0) {
                return str;
            }
            char[] charArray = str.toCharArray();
            boolean z = true;
            for (int i2 = 0; i2 < charArray.length; i2++) {
                char c2 = charArray[i2];
                if (isDelimiter(c2, cArr)) {
                    z = true;
                } else if (z) {
                    charArray[i2] = Character.toTitleCase(c2);
                    z = false;
                }
            }
            return new String(charArray);
        }
        return (String) invokeLL.objValue;
    }

    public static String capitalizeFully(String str, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, cArr)) == null) {
            return (StringUtils.isEmpty(str) || (cArr == null ? -1 : cArr.length) == 0) ? str : capitalize(str.toLowerCase(), cArr);
        }
        return (String) invokeLL.objValue;
    }

    public static String initials(String str, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, cArr)) == null) {
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (cArr == null || cArr.length != 0) {
                int length = str.length();
                char[] cArr2 = new char[(length / 2) + 1];
                int i2 = 0;
                boolean z = true;
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = str.charAt(i3);
                    if (isDelimiter(charAt, cArr)) {
                        z = true;
                    } else if (z) {
                        cArr2[i2] = charAt;
                        i2++;
                        z = false;
                    }
                }
                return new String(cArr2, 0, i2);
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String uncapitalize(String str, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, cArr)) == null) {
            int length = cArr == null ? -1 : cArr.length;
            if (StringUtils.isEmpty(str) || length == 0) {
                return str;
            }
            char[] charArray = str.toCharArray();
            boolean z = true;
            for (int i2 = 0; i2 < charArray.length; i2++) {
                char c2 = charArray[i2];
                if (isDelimiter(c2, cArr)) {
                    z = true;
                } else if (z) {
                    charArray[i2] = Character.toLowerCase(c2);
                    z = false;
                }
            }
            return new String(charArray);
        }
        return (String) invokeLL.objValue;
    }

    public static String wrap(String str, int i2, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{str, Integer.valueOf(i2), str2, Boolean.valueOf(z)})) == null) ? wrap(str, i2, str2, z, " ") : (String) invokeCommon.objValue;
    }

    public static String wrap(String str, int i2, String str2, boolean z, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{str, Integer.valueOf(i2), str2, Boolean.valueOf(z), str3})) == null) {
            if (str == null) {
                return null;
            }
            if (str2 == null) {
                str2 = SystemUtils.LINE_SEPARATOR;
            }
            if (i2 < 1) {
                i2 = 1;
            }
            if (StringUtils.isBlank(str3)) {
                str3 = " ";
            }
            Pattern compile = Pattern.compile(str3);
            int length = str.length();
            int i3 = 0;
            StringBuilder sb = new StringBuilder(length + 32);
            while (i3 < length) {
                int i4 = -1;
                int i5 = i3 + i2;
                Matcher matcher = compile.matcher(str.substring(i3, Math.min(i5 + 1, length)));
                if (matcher.find()) {
                    if (matcher.start() == 0) {
                        i3 += matcher.end();
                    } else {
                        i4 = matcher.start();
                    }
                }
                if (length - i3 <= i2) {
                    break;
                }
                while (matcher.find()) {
                    i4 = matcher.start() + i3;
                }
                if (i4 >= i3) {
                    sb.append(str.substring(i3, i4));
                    sb.append(str2);
                } else if (z) {
                    sb.append(str.substring(i3, i5));
                    sb.append(str2);
                    i3 = i5;
                } else {
                    Matcher matcher2 = compile.matcher(str.substring(i5));
                    if (matcher2.find()) {
                        i4 = matcher2.start() + i3 + i2;
                    }
                    if (i4 >= 0) {
                        sb.append(str.substring(i3, i4));
                        sb.append(str2);
                    } else {
                        sb.append(str.substring(i3));
                        i3 = length;
                    }
                }
                i3 = i4 + 1;
            }
            sb.append(str.substring(i3));
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }
}
