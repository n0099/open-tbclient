package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class StringUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CR = "\r";
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String LF = "\n";
    public static final int PAD_LIMIT = 8192;
    public static final String SPACE = " ";
    public transient /* synthetic */ FieldHolder $fh;

    public StringUtils() {
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

    public static String abbreviate(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) ? abbreviate(str, 0, i2) : (String) invokeLI.objValue;
    }

    public static String abbreviateMiddle(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, str, str2, i2)) == null) {
            if (isEmpty(str) || isEmpty(str2) || i2 >= str.length() || i2 < str2.length() + 2) {
                return str;
            }
            int length = i2 - str2.length();
            int i3 = length / 2;
            int i4 = (length % 2) + i3;
            int length2 = str.length() - i3;
            StringBuilder sb = new StringBuilder(i2);
            sb.append(str.substring(0, i4));
            sb.append(str2);
            sb.append(str.substring(length2));
            return sb.toString();
        }
        return (String) invokeLLI.objValue;
    }

    public static String appendIfMissing(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, charSequence, Boolean.valueOf(z), charSequenceArr})) == null) {
            if (str == null || isEmpty(charSequence) || endsWith(str, charSequence, z)) {
                return str;
            }
            if (charSequenceArr != null && charSequenceArr.length > 0) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (endsWith(str, charSequence2, z)) {
                        return str;
                    }
                }
            }
            return str + charSequence.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String appendIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, charSequence, charSequenceArr)) == null) ? appendIfMissing(str, charSequence, true, charSequenceArr) : (String) invokeLLL.objValue;
    }

    public static String capitalize(String str) {
        InterceptResult invokeL;
        int length;
        char charAt;
        char titleCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null || (length = str.length()) == 0 || charAt == (titleCase = Character.toTitleCase((charAt = str.charAt(0))))) {
                return str;
            }
            char[] cArr = new char[length];
            cArr[0] = titleCase;
            str.getChars(1, length, cArr, 1);
            return String.valueOf(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static String center(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i2)) == null) ? center(str, i2, (char) WebvttCueParser.CHAR_SPACE) : (String) invokeLI.objValue;
    }

    public static String chomp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (isEmpty(str)) {
                return str;
            }
            if (str.length() == 1) {
                char charAt = str.charAt(0);
                return (charAt == '\r' || charAt == '\n') ? "" : str;
            }
            int length = str.length() - 1;
            char charAt2 = str.charAt(length);
            if (charAt2 == '\n') {
                if (str.charAt(length - 1) == '\r') {
                    length--;
                }
            } else if (charAt2 != '\r') {
                length++;
            }
            return str.substring(0, length);
        }
        return (String) invokeL.objValue;
    }

    public static String chop(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            if (length < 2) {
                return "";
            }
            int i2 = length - 1;
            String substring = str.substring(0, i2);
            if (str.charAt(i2) == '\n') {
                int i3 = i2 - 1;
                if (substring.charAt(i3) == '\r') {
                    return substring.substring(0, i3);
                }
            }
            return substring;
        }
        return (String) invokeL.objValue;
    }

    public static int compare(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) ? compare(str, str2, true) : invokeLL.intValue;
    }

    public static int compareIgnoreCase(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, str, str2)) == null) ? compareIgnoreCase(str, str2, true) : invokeLL.intValue;
    }

    public static boolean contains(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, charSequence, i2)) == null) ? !isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i2, 0) >= 0 : invokeLI.booleanValue;
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, charSequence, cArr)) == null) {
            if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
                int length = charSequence.length();
                int length2 = cArr.length;
                int i2 = length - 1;
                int i3 = length2 - 1;
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = charSequence.charAt(i4);
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (cArr[i5] == charAt) {
                            if (!Character.isHighSurrogate(charAt) || i5 == i3) {
                                return true;
                            }
                            if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, charSequence, charSequence2)) == null) {
            if (charSequence != null && charSequence2 != null) {
                int length = charSequence2.length();
                int length2 = charSequence.length() - length;
                for (int i2 = 0; i2 <= length2; i2++) {
                    if (CharSequenceUtils.regionMatches(charSequence, true, i2, charSequence2, 0, length)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, charSequence, cArr)) == null) {
            if (charSequence != null && cArr != null) {
                int length = charSequence.length();
                int i2 = length - 1;
                int length2 = cArr.length;
                int i3 = length2 - 1;
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = charSequence.charAt(i4);
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (cArr[i5] == charAt) {
                            if (!Character.isHighSurrogate(charAt) || i5 == i3) {
                                return false;
                            }
                            if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, charSequence, cArr)) == null) {
            if (cArr == null || charSequence == null) {
                return false;
            }
            if (charSequence.length() == 0) {
                return true;
            }
            return cArr.length != 0 && indexOfAnyBut(charSequence, cArr) == -1;
        }
        return invokeLL.booleanValue;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, charSequence)) == null) {
            if (isEmpty(charSequence)) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(charSequence.charAt(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void convertRemainingAccentCharacters(StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, sb) == null) {
            for (int i2 = 0; i2 < sb.length(); i2++) {
                if (sb.charAt(i2) == 321) {
                    sb.deleteCharAt(i2);
                    sb.insert(i2, 'L');
                } else if (sb.charAt(i2) == 322) {
                    sb.deleteCharAt(i2);
                    sb.insert(i2, 'l');
                }
            }
        }
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65567, null, charSequence, charSequence2)) != null) {
            return invokeLL.intValue;
        }
        int i2 = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            int indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, i2);
            if (indexOf == -1) {
                return i3;
            }
            i3++;
            i2 = indexOf + charSequence2.length();
        }
    }

    public static <T extends CharSequence> T defaultIfBlank(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, t, t2)) == null) ? isBlank(t) ? t2 : t : (T) invokeLL.objValue;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, t, t2)) == null) ? isEmpty(t) ? t2 : t : (T) invokeLL.objValue;
    }

    public static String defaultString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    public static String defaultString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, str, str2)) == null) ? str == null ? str2 : str : (String) invokeLL.objValue;
    }

    public static String deleteWhitespace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            if (isEmpty(str)) {
                return str;
            }
            int length = str.length();
            char[] cArr = new char[length];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Character.isWhitespace(str.charAt(i3))) {
                    cArr[i2] = str.charAt(i3);
                    i2++;
                }
            }
            return i2 == length ? str : new String(cArr, 0, i2);
        }
        return (String) invokeL.objValue;
    }

    public static String difference(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, str, str2)) == null) {
            if (str == null) {
                return str2;
            }
            if (str2 == null) {
                return str;
            }
            int indexOfDifference = indexOfDifference(str, str2);
            return indexOfDifference == -1 ? "" : str2.substring(indexOfDifference);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, charSequence, charSequence2)) == null) ? endsWith(charSequence, charSequence2, false) : invokeLL.booleanValue;
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, charSequence, charSequenceArr)) == null) {
            if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (endsWith(charSequence, charSequence2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, charSequence, charSequence2)) == null) ? endsWith(charSequence, charSequence2, true) : invokeLL.booleanValue;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, charSequence, charSequence2)) == null) {
            if (charSequence == charSequence2) {
                return true;
            }
            if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
                return false;
            }
            if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
                return charSequence.equals(charSequence2);
            }
            return CharSequenceUtils.regionMatches(charSequence, false, 0, charSequence2, 0, charSequence.length());
        }
        return invokeLL.booleanValue;
    }

    public static boolean equalsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, charSequence, charSequenceArr)) == null) {
            if (ArrayUtils.isNotEmpty(charSequenceArr)) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (equals(charSequence, charSequence2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean equalsAnyIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65580, null, charSequence, charSequenceArr)) == null) {
            if (ArrayUtils.isNotEmpty(charSequenceArr)) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (equalsIgnoreCase(charSequence, charSequence2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, charSequence, charSequence2)) == null) {
            if (charSequence == null || charSequence2 == null) {
                return charSequence == charSequence2;
            } else if (charSequence == charSequence2) {
                return true;
            } else {
                if (charSequence.length() != charSequence2.length()) {
                    return false;
                }
                return CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, charSequence.length());
            }
        }
        return invokeLL.booleanValue;
    }

    public static String getCommonPrefix(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, strArr)) == null) {
            if (strArr == null || strArr.length == 0) {
                return "";
            }
            int indexOfDifference = indexOfDifference(strArr);
            return indexOfDifference == -1 ? strArr[0] == null ? "" : strArr[0] : indexOfDifference == 0 ? "" : strArr[0].substring(0, indexOfDifference);
        }
        return (String) invokeL.objValue;
    }

    public static int getFuzzyDistance(CharSequence charSequence, CharSequence charSequence2, Locale locale) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65583, null, charSequence, charSequence2, locale)) == null) {
            if (charSequence == null || charSequence2 == null) {
                throw new IllegalArgumentException("Strings must not be null");
            }
            if (locale != null) {
                String lowerCase = charSequence.toString().toLowerCase(locale);
                String lowerCase2 = charSequence2.toString().toLowerCase(locale);
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < lowerCase2.length(); i5++) {
                    char charAt = lowerCase2.charAt(i5);
                    boolean z = false;
                    while (i4 < lowerCase.length() && !z) {
                        if (charAt == lowerCase.charAt(i4)) {
                            i3++;
                            if (i2 + 1 == i4) {
                                i3 += 2;
                            }
                            z = true;
                            i2 = i4;
                        }
                        i4++;
                    }
                }
                return i3;
            }
            throw new IllegalArgumentException("Locale must not be null");
        }
        return invokeLLL.intValue;
    }

    public static double getJaroWinklerDistance(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        int[] matches;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65584, null, charSequence, charSequence2)) == null) {
            if (charSequence != null && charSequence2 != null) {
                double d2 = matches(charSequence, charSequence2)[0];
                if (d2 == 0.0d) {
                    return 0.0d;
                }
                double length = (((d2 / charSequence.length()) + (d2 / charSequence2.length())) + ((d2 - matches[1]) / d2)) / 3.0d;
                if (length >= 0.7d) {
                    length += Math.min(0.1d, 1.0d / matches[3]) * matches[2] * (1.0d - length);
                }
                return Math.round(length * 100.0d) / 100.0d;
            }
            throw new IllegalArgumentException("Strings must not be null");
        }
        return invokeLL.doubleValue;
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65585, null, charSequence, charSequence2)) == null) {
            if (charSequence != null && charSequence2 != null) {
                int length = charSequence.length();
                int length2 = charSequence2.length();
                if (length == 0) {
                    return length2;
                }
                if (length2 == 0) {
                    return length;
                }
                if (length > length2) {
                    length2 = charSequence.length();
                    length = length2;
                } else {
                    charSequence2 = charSequence;
                    charSequence = charSequence2;
                }
                int i2 = length + 1;
                int[] iArr = new int[i2];
                int[] iArr2 = new int[i2];
                for (int i3 = 0; i3 <= length; i3++) {
                    iArr[i3] = i3;
                }
                int i4 = 1;
                while (i4 <= length2) {
                    char charAt = charSequence.charAt(i4 - 1);
                    iArr2[0] = i4;
                    for (int i5 = 1; i5 <= length; i5++) {
                        int i6 = i5 - 1;
                        iArr2[i5] = Math.min(Math.min(iArr2[i6] + 1, iArr[i5] + 1), iArr[i6] + (charSequence2.charAt(i6) == charAt ? 0 : 1));
                    }
                    i4++;
                    int[] iArr3 = iArr;
                    iArr = iArr2;
                    iArr2 = iArr3;
                }
                return iArr[length];
            }
            throw new IllegalArgumentException("Strings must not be null");
        }
        return invokeLL.intValue;
    }

    public static int indexOf(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65587, null, charSequence, i2)) == null) {
            if (isEmpty(charSequence)) {
                return -1;
            }
            return CharSequenceUtils.indexOf(charSequence, i2, 0);
        }
        return invokeLI.intValue;
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, charSequence, cArr)) == null) {
            if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
                int length = charSequence.length();
                int i2 = length - 1;
                int length2 = cArr.length;
                int i3 = length2 - 1;
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = charSequence.charAt(i4);
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (cArr[i5] == charAt && (i4 >= i2 || i5 >= i3 || !Character.isHighSurrogate(charAt) || cArr[i5 + 1] == charSequence.charAt(i4 + 1))) {
                            return i4;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65595, null, charSequence, cArr)) == null) {
            if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
                int length = charSequence.length();
                int i2 = length - 1;
                int length2 = cArr.length;
                int i3 = length2 - 1;
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = charSequence.charAt(i4);
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (cArr[i5] != charAt || (i4 < i2 && i5 < i3 && Character.isHighSurrogate(charAt) && cArr[i5 + 1] != charSequence.charAt(i4 + 1))) {
                        }
                    }
                    return i4;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65596, null, charSequence, charSequence2)) == null) {
            if (charSequence == charSequence2) {
                return -1;
            }
            int i2 = 0;
            if (charSequence != null && charSequence2 != null) {
                while (i2 < charSequence.length() && i2 < charSequence2.length() && charSequence.charAt(i2) == charSequence2.charAt(i2)) {
                    i2++;
                }
                if (i2 >= charSequence2.length() && i2 >= charSequence.length()) {
                    return -1;
                }
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65598, null, charSequence, charSequence2)) == null) ? indexOfIgnoreCase(charSequence, charSequence2, 0) : invokeLL.intValue;
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, charSequence)) == null) {
            if (charSequence == null || isEmpty(charSequence)) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isLowerCase(charSequence.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, charSequence)) == null) {
            if (charSequence == null || isEmpty(charSequence)) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isUpperCase(charSequence.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAlpha(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, charSequence)) == null) {
            if (isEmpty(charSequence)) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isLetter(charSequence.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65603, null, charSequence)) == null) {
            if (charSequence == null) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isLetter(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, charSequence)) == null) {
            if (isEmpty(charSequence)) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isLetterOrDigit(charSequence.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65605, null, charSequence)) == null) {
            if (charSequence == null) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isLetterOrDigit(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAnyBlank(CharSequence... charSequenceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, charSequenceArr)) == null) {
            if (ArrayUtils.isEmpty(charSequenceArr)) {
                return true;
            }
            for (CharSequence charSequence : charSequenceArr) {
                if (isBlank(charSequence)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAnyEmpty(CharSequence... charSequenceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, charSequenceArr)) == null) {
            if (ArrayUtils.isEmpty(charSequenceArr)) {
                return true;
            }
            for (CharSequence charSequence : charSequenceArr) {
                if (isEmpty(charSequence)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, charSequence)) == null) {
            if (charSequence == null) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!CharUtils.isAsciiPrintable(charSequence.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isBlank(CharSequence charSequence) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, charSequence)) == null) {
            if (charSequence != null && (length = charSequence.length()) != 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (!Character.isWhitespace(charSequence.charAt(i2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65610, null, charSequence)) == null) ? charSequence == null || charSequence.length() == 0 : invokeL.booleanValue;
    }

    public static boolean isNoneBlank(CharSequence... charSequenceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65611, null, charSequenceArr)) == null) ? !isAnyBlank(charSequenceArr) : invokeL.booleanValue;
    }

    public static boolean isNoneEmpty(CharSequence... charSequenceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65612, null, charSequenceArr)) == null) ? !isAnyEmpty(charSequenceArr) : invokeL.booleanValue;
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65613, null, charSequence)) == null) ? !isBlank(charSequence) : invokeL.booleanValue;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65614, null, charSequence)) == null) ? !isEmpty(charSequence) : invokeL.booleanValue;
    }

    public static boolean isNumeric(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, null, charSequence)) == null) {
            if (isEmpty(charSequence)) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isDigit(charSequence.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, charSequence)) == null) {
            if (charSequence == null) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isDigit(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, null, charSequence)) == null) {
            if (charSequence == null) {
                return false;
            }
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(charSequence.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static <T> String join(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65634, null, tArr)) == null) ? join(tArr, (String) null) : (String) invokeL.objValue;
    }

    public static String joinWith(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65641, null, str, objArr)) == null) {
            if (objArr != null) {
                String defaultString = defaultString(str, "");
                StringBuilder sb = new StringBuilder();
                Iterator it = Arrays.asList(objArr).iterator();
                while (it.hasNext()) {
                    sb.append(ObjectUtils.toString(it.next()));
                    if (it.hasNext()) {
                        sb.append(defaultString);
                    }
                }
                return sb.toString();
            }
            throw new IllegalArgumentException("Object varargs must not be null");
        }
        return (String) invokeLL.objValue;
    }

    public static int lastIndexOf(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65642, null, charSequence, i2)) == null) {
            if (isEmpty(charSequence)) {
                return -1;
            }
            return CharSequenceUtils.lastIndexOf(charSequence, i2, charSequence.length());
        }
        return invokeLI.intValue;
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65646, null, charSequence, charSequenceArr)) == null) {
            int i2 = -1;
            if (charSequence != null && charSequenceArr != null) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (charSequence2 != null && (lastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length())) > i2) {
                        i2 = lastIndexOf;
                    }
                }
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65647, null, charSequence, charSequence2)) == null) {
            if (charSequence == null || charSequence2 == null) {
                return -1;
            }
            return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
        }
        return invokeLL.intValue;
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65649, null, charSequence, charSequence2, i2)) == null) ? ordinalIndexOf(charSequence, charSequence2, i2, true) : invokeLLI.intValue;
    }

    public static String left(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65650, null, str, i2)) == null) {
            if (str == null) {
                return null;
            }
            return i2 < 0 ? "" : str.length() <= i2 ? str : str.substring(0, i2);
        }
        return (String) invokeLI.objValue;
    }

    public static String leftPad(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65651, null, str, i2)) == null) ? leftPad(str, i2, (char) WebvttCueParser.CHAR_SPACE) : (String) invokeLI.objValue;
    }

    public static int length(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65654, null, charSequence)) == null) {
            if (charSequence == null) {
                return 0;
            }
            return charSequence.length();
        }
        return invokeL.intValue;
    }

    public static String lowerCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65655, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return str.toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        CharSequence charSequence3;
        CharSequence charSequence4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65657, null, charSequence, charSequence2)) == null) {
            if (charSequence.length() > charSequence2.length()) {
                charSequence4 = charSequence;
                charSequence3 = charSequence2;
            } else {
                charSequence3 = charSequence;
                charSequence4 = charSequence2;
            }
            int max = Math.max((charSequence4.length() / 2) - 1, 0);
            int[] iArr = new int[charSequence3.length()];
            Arrays.fill(iArr, -1);
            boolean[] zArr = new boolean[charSequence4.length()];
            int i2 = 0;
            for (int i3 = 0; i3 < charSequence3.length(); i3++) {
                char charAt = charSequence3.charAt(i3);
                int max2 = Math.max(i3 - max, 0);
                int min = Math.min(i3 + max + 1, charSequence4.length());
                while (true) {
                    if (max2 >= min) {
                        break;
                    }
                    if (!zArr[max2] && charAt == charSequence4.charAt(max2)) {
                        iArr[i3] = max2;
                        zArr[max2] = true;
                        i2++;
                        break;
                    }
                    max2++;
                }
            }
            char[] cArr = new char[i2];
            char[] cArr2 = new char[i2];
            int i4 = 0;
            for (int i5 = 0; i5 < charSequence3.length(); i5++) {
                if (iArr[i5] != -1) {
                    cArr[i4] = charSequence3.charAt(i5);
                    i4++;
                }
            }
            int i6 = 0;
            for (int i7 = 0; i7 < charSequence4.length(); i7++) {
                if (zArr[i7]) {
                    cArr2[i6] = charSequence4.charAt(i7);
                    i6++;
                }
            }
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                if (cArr[i9] != cArr2[i9]) {
                    i8++;
                }
            }
            int i10 = 0;
            for (int i11 = 0; i11 < charSequence3.length() && charSequence.charAt(i11) == charSequence2.charAt(i11); i11++) {
                i10++;
            }
            return new int[]{i2, i8 / 2, i10, charSequence4.length()};
        }
        return (int[]) invokeLL.objValue;
    }

    public static String mid(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65658, null, str, i2, i3)) == null) {
            if (str == null) {
                return null;
            }
            if (i3 < 0 || i2 > str.length()) {
                return "";
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int i4 = i3 + i2;
            if (str.length() <= i4) {
                return str.substring(i2);
            }
            return str.substring(i2, i4);
        }
        return (String) invokeLII.objValue;
    }

    public static String normalizeSpace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65659, null, str)) == null) {
            if (isEmpty(str)) {
                return str;
            }
            int length = str.length();
            char[] cArr = new char[length];
            boolean z = true;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = str.charAt(i4);
                if (Character.isWhitespace(charAt)) {
                    if (i3 == 0 && !z) {
                        cArr[i2] = " ".charAt(0);
                        i2++;
                    }
                    i3++;
                } else {
                    int i5 = i2 + 1;
                    if (charAt == 160) {
                        charAt = WebvttCueParser.CHAR_SPACE;
                    }
                    cArr[i2] = charAt;
                    i2 = i5;
                    z = false;
                    i3 = 0;
                }
            }
            if (z) {
                return "";
            }
            return new String(cArr, 0, i2 - (i3 <= 0 ? 0 : 1)).trim();
        }
        return (String) invokeL.objValue;
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65660, null, charSequence, charSequence2, i2)) == null) ? ordinalIndexOf(charSequence, charSequence2, i2, false) : invokeLLI.intValue;
    }

    public static String overlay(String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65662, null, str, str2, i2, i3)) == null) {
            if (str == null) {
                return null;
            }
            if (str2 == null) {
                str2 = "";
            }
            int length = str.length();
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > length) {
                i2 = length;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 > length) {
                i3 = length;
            }
            if (i2 > i3) {
                int i4 = i3;
                i3 = i2;
                i2 = i4;
            }
            StringBuilder sb = new StringBuilder(((length + i2) - i3) + str2.length() + 1);
            sb.append(str.substring(0, i2));
            sb.append(str2);
            sb.append(str.substring(i3));
            return sb.toString();
        }
        return (String) invokeLLII.objValue;
    }

    public static String prependIfMissing(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65663, null, new Object[]{str, charSequence, Boolean.valueOf(z), charSequenceArr})) == null) {
            if (str == null || isEmpty(charSequence) || startsWith(str, charSequence, z)) {
                return str;
            }
            if (charSequenceArr != null && charSequenceArr.length > 0) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (startsWith(str, charSequence2, z)) {
                        return str;
                    }
                }
            }
            return charSequence.toString() + str;
        }
        return (String) invokeCommon.objValue;
    }

    public static String prependIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65665, null, str, charSequence, charSequenceArr)) == null) ? prependIfMissing(str, charSequence, true, charSequenceArr) : (String) invokeLLL.objValue;
    }

    public static String remove(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65667, null, str, str2)) == null) ? (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1) : (String) invokeLL.objValue;
    }

    public static String removeAll(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65668, null, str, str2)) == null) ? replaceAll(str, str2, "") : (String) invokeLL.objValue;
    }

    public static String removeEnd(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65669, null, str, str2)) == null) ? (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length()) : (String) invokeLL.objValue;
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65670, null, str, str2)) == null) ? (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) ? str : str.substring(0, str.length() - str2.length()) : (String) invokeLL.objValue;
    }

    public static String removeFirst(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65671, null, str, str2)) == null) ? replaceFirst(str, str2, "") : (String) invokeLL.objValue;
    }

    public static String removeIgnoreCase(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65672, null, str, str2)) == null) ? (isEmpty(str) || isEmpty(str2)) ? str : replaceIgnoreCase(str, str2, "", -1) : (String) invokeLL.objValue;
    }

    public static String removePattern(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65673, null, str, str2)) == null) ? replacePattern(str, str2, "") : (String) invokeLL.objValue;
    }

    public static String removeStart(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65674, null, str, str2)) == null) ? (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) ? str : str.substring(str2.length()) : (String) invokeLL.objValue;
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65675, null, str, str2)) == null) ? (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) ? str : str.substring(str2.length()) : (String) invokeLL.objValue;
    }

    public static String repeat(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65677, null, str, i2)) == null) {
            if (str == null) {
                return null;
            }
            if (i2 <= 0) {
                return "";
            }
            int length = str.length();
            if (i2 == 1 || length == 0) {
                return str;
            }
            if (length != 1 || i2 > 8192) {
                int i3 = length * i2;
                if (length != 1) {
                    if (length != 2) {
                        StringBuilder sb = new StringBuilder(i3);
                        for (int i4 = 0; i4 < i2; i4++) {
                            sb.append(str);
                        }
                        return sb.toString();
                    }
                    char charAt = str.charAt(0);
                    char charAt2 = str.charAt(1);
                    char[] cArr = new char[i3];
                    for (int i5 = (i2 * 2) - 2; i5 >= 0; i5 = (i5 - 1) - 1) {
                        cArr[i5] = charAt;
                        cArr[i5 + 1] = charAt2;
                    }
                    return new String(cArr);
                }
                return repeat(str.charAt(0), i2);
            }
            return repeat(str.charAt(0), i2);
        }
        return (String) invokeLI.objValue;
    }

    public static String replace(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65679, null, str, str2, str3)) == null) ? replace(str, str2, str3, -1) : (String) invokeLLL.objValue;
    }

    public static String replaceAll(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65682, null, str, str2, str3)) == null) ? (str == null || str2 == null || str3 == null) ? str : str.replaceAll(str2, str3) : (String) invokeLLL.objValue;
    }

    public static String replaceChars(String str, char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65683, null, new Object[]{str, Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (str == null) {
                return null;
            }
            return str.replace(c2, c3);
        }
        return (String) invokeCommon.objValue;
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65685, null, str, strArr, strArr2)) == null) ? replaceEach(str, strArr, strArr2, false, 0) : (String) invokeLLL.objValue;
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65687, null, str, strArr, strArr2)) == null) {
            return replaceEach(str, strArr, strArr2, true, strArr == null ? 0 : strArr.length);
        }
        return (String) invokeLLL.objValue;
    }

    public static String replaceFirst(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65688, null, str, str2, str3)) == null) ? (str == null || str2 == null || str3 == null) ? str : str.replaceFirst(str2, str3) : (String) invokeLLL.objValue;
    }

    public static String replaceIgnoreCase(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65689, null, str, str2, str3)) == null) ? replaceIgnoreCase(str, str2, str3, -1) : (String) invokeLLL.objValue;
    }

    public static String replaceOnce(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65691, null, str, str2, str3)) == null) ? replace(str, str2, str3, 1) : (String) invokeLLL.objValue;
    }

    public static String replaceOnceIgnoreCase(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65692, null, str, str2, str3)) == null) ? replaceIgnoreCase(str, str2, str3, 1) : (String) invokeLLL.objValue;
    }

    public static String replacePattern(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65693, null, str, str2, str3)) == null) ? (str == null || str2 == null || str3 == null) ? str : Pattern.compile(str2, 32).matcher(str).replaceAll(str3) : (String) invokeLLL.objValue;
    }

    public static String reverse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65694, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return new StringBuilder(str).reverse().toString();
        }
        return (String) invokeL.objValue;
    }

    public static String reverseDelimited(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65695, null, new Object[]{str, Character.valueOf(c2)})) == null) {
            if (str == null) {
                return null;
            }
            String[] split = split(str, c2);
            ArrayUtils.reverse(split);
            return join(split, c2);
        }
        return (String) invokeCommon.objValue;
    }

    public static String right(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65696, null, str, i2)) == null) {
            if (str == null) {
                return null;
            }
            return i2 < 0 ? "" : str.length() <= i2 ? str : str.substring(str.length() - i2);
        }
        return (String) invokeLI.objValue;
    }

    public static String rightPad(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65697, null, str, i2)) == null) ? rightPad(str, i2, (char) WebvttCueParser.CHAR_SPACE) : (String) invokeLI.objValue;
    }

    public static String rotate(String str, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65700, null, str, i2)) == null) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            if (i2 == 0 || length == 0 || (i3 = i2 % length) == 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder(length);
            int i4 = -i3;
            sb.append(substring(str, i4));
            sb.append(substring(str, 0, i4));
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public static String[] split(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65701, null, str)) == null) ? split(str, null, -1) : (String[]) invokeL.objValue;
    }

    public static String[] splitByCharacterType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65705, null, str)) == null) ? splitByCharacterType(str, false) : (String[]) invokeL.objValue;
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65707, null, str)) == null) ? splitByCharacterType(str, true) : (String[]) invokeL.objValue;
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65708, null, str, str2)) == null) ? splitByWholeSeparatorWorker(str, str2, -1, false) : (String[]) invokeLL.objValue;
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65710, null, str, str2)) == null) ? splitByWholeSeparatorWorker(str, str2, -1, true) : (String[]) invokeLL.objValue;
    }

    public static String[] splitByWholeSeparatorWorker(String str, String str2, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65712, null, new Object[]{str, str2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            if (length == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            if (str2 != null && !"".equals(str2)) {
                int length2 = str2.length();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < length) {
                    i3 = str.indexOf(str2, i4);
                    if (i3 > -1) {
                        if (i3 > i4) {
                            i5++;
                            if (i5 == i2) {
                                arrayList.add(str.substring(i4));
                            } else {
                                arrayList.add(str.substring(i4, i3));
                            }
                        } else if (z) {
                            i5++;
                            if (i5 == i2) {
                                arrayList.add(str.substring(i4));
                                i3 = length;
                            } else {
                                arrayList.add("");
                            }
                        }
                        i4 = i3 + length2;
                    } else {
                        arrayList.add(str.substring(i4));
                    }
                    i3 = length;
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return splitWorker(str, null, i2, z);
        }
        return (String[]) invokeCommon.objValue;
    }

    public static String[] splitPreserveAllTokens(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65713, null, str)) == null) ? splitWorker(str, null, -1, true) : (String[]) invokeL.objValue;
    }

    public static String[] splitWorker(String str, char c2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65717, null, new Object[]{str, Character.valueOf(c2), Boolean.valueOf(z)})) == null) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            if (length == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            boolean z2 = false;
            boolean z3 = false;
            int i3 = 0;
            while (i2 < length) {
                if (str.charAt(i2) == c2) {
                    if (z2 || z) {
                        arrayList.add(str.substring(i3, i2));
                        z2 = false;
                        z3 = true;
                    }
                    i3 = i2 + 1;
                    i2 = i3;
                } else {
                    i2++;
                    z2 = true;
                    z3 = false;
                }
            }
            if (z2 || (z && z3)) {
                arrayList.add(str.substring(i3, i2));
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeCommon.objValue;
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65719, null, charSequence, charSequence2)) == null) ? startsWith(charSequence, charSequence2, false) : invokeLL.booleanValue;
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65721, null, charSequence, charSequenceArr)) == null) {
            if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (startsWith(charSequence, charSequence2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65722, null, charSequence, charSequence2)) == null) ? startsWith(charSequence, charSequence2, true) : invokeLL.booleanValue;
    }

    public static String strip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65723, null, str)) == null) ? strip(str, null) : (String) invokeL.objValue;
    }

    public static String stripAccents(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65725, null, str)) == null) {
            if (str == null) {
                return null;
            }
            Pattern compile = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            StringBuilder sb = new StringBuilder(Normalizer.normalize(str, Normalizer.Form.NFD));
            convertRemainingAccentCharacters(sb);
            return compile.matcher(sb).replaceAll("");
        }
        return (String) invokeL.objValue;
    }

    public static String[] stripAll(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65726, null, strArr)) == null) ? stripAll(strArr, null) : (String[]) invokeL.objValue;
    }

    public static String stripEnd(String str, String str2) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65728, null, str, str2)) == null) {
            if (str == null || (length = str.length()) == 0) {
                return str;
            }
            if (str2 == null) {
                while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                    length--;
                }
            } else if (str2.isEmpty()) {
                return str;
            } else {
                while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                    length--;
                }
            }
            return str.substring(0, length);
        }
        return (String) invokeLL.objValue;
    }

    public static String stripStart(String str, String str2) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65729, null, str, str2)) == null) {
            if (str == null || (length = str.length()) == 0) {
                return str;
            }
            int i2 = 0;
            if (str2 == null) {
                while (i2 != length && Character.isWhitespace(str.charAt(i2))) {
                    i2++;
                }
            } else if (str2.isEmpty()) {
                return str;
            } else {
                while (i2 != length && str2.indexOf(str.charAt(i2)) != -1) {
                    i2++;
                }
            }
            return str.substring(i2);
        }
        return (String) invokeLL.objValue;
    }

    public static String stripToEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65730, null, str)) == null) ? str == null ? "" : strip(str, null) : (String) invokeL.objValue;
    }

    public static String stripToNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65731, null, str)) == null) {
            if (str == null) {
                return null;
            }
            String strip = strip(str, null);
            if (strip.isEmpty()) {
                return null;
            }
            return strip;
        }
        return (String) invokeL.objValue;
    }

    public static String substring(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65732, null, str, i2)) == null) {
            if (str == null) {
                return null;
            }
            if (i2 < 0) {
                i2 += str.length();
            }
            if (i2 < 0) {
                i2 = 0;
            }
            return i2 > str.length() ? "" : str.substring(i2);
        }
        return (String) invokeLI.objValue;
    }

    public static String substringAfter(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65734, null, str, str2)) == null) ? isEmpty(str) ? str : (str2 == null || (indexOf = str.indexOf(str2)) == -1) ? "" : str.substring(indexOf + str2.length()) : (String) invokeLL.objValue;
    }

    public static String substringAfterLast(String str, String str2) {
        InterceptResult invokeLL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65735, null, str, str2)) == null) ? isEmpty(str) ? str : (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) ? "" : str.substring(lastIndexOf + str2.length()) : (String) invokeLL.objValue;
    }

    public static String substringBefore(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65736, null, str, str2)) == null) {
            if (isEmpty(str) || str2 == null) {
                return str;
            }
            if (str2.isEmpty()) {
                return "";
            }
            int indexOf = str.indexOf(str2);
            return indexOf == -1 ? str : str.substring(0, indexOf);
        }
        return (String) invokeLL.objValue;
    }

    public static String substringBeforeLast(String str, String str2) {
        InterceptResult invokeLL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65737, null, str, str2)) == null) ? (isEmpty(str) || isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1) ? str : str.substring(0, lastIndexOf) : (String) invokeLL.objValue;
    }

    public static String substringBetween(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65738, null, str, str2)) == null) ? substringBetween(str, str2, str2) : (String) invokeLL.objValue;
    }

    public static String[] substringsBetween(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        int indexOf;
        int i2;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65740, null, str, str2, str3)) == null) {
            if (str == null || isEmpty(str2) || isEmpty(str3)) {
                return null;
            }
            int length = str.length();
            if (length == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            int length2 = str3.length();
            int length3 = str2.length();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < length - length2 && (indexOf = str.indexOf(str2, i3)) >= 0 && (indexOf2 = str.indexOf(str3, (i2 = indexOf + length3))) >= 0) {
                arrayList.add(str.substring(i2, indexOf2));
                i3 = indexOf2 + length2;
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeLLL.objValue;
    }

    public static String swapCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65741, null, str)) == null) {
            if (isEmpty(str)) {
                return str;
            }
            char[] charArray = str.toCharArray();
            for (int i2 = 0; i2 < charArray.length; i2++) {
                char c2 = charArray[i2];
                if (Character.isUpperCase(c2)) {
                    charArray[i2] = Character.toLowerCase(c2);
                } else if (Character.isTitleCase(c2)) {
                    charArray[i2] = Character.toLowerCase(c2);
                } else if (Character.isLowerCase(c2)) {
                    charArray[i2] = Character.toUpperCase(c2);
                }
            }
            return new String(charArray);
        }
        return (String) invokeL.objValue;
    }

    public static String toEncodedString(byte[] bArr, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65742, null, bArr, charset)) == null) {
            if (charset == null) {
                charset = Charset.defaultCharset();
            }
            return new String(bArr, charset);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static String toString(byte[] bArr, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65743, null, bArr, str)) == null) {
            return str != null ? new String(bArr, str) : new String(bArr, Charset.defaultCharset());
        }
        return (String) invokeLL.objValue;
    }

    public static String trim(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65744, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return str.trim();
        }
        return (String) invokeL.objValue;
    }

    public static String trimToEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65745, null, str)) == null) ? str == null ? "" : str.trim() : (String) invokeL.objValue;
    }

    public static String trimToNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65746, null, str)) == null) {
            String trim = trim(str);
            if (isEmpty(trim)) {
                return null;
            }
            return trim;
        }
        return (String) invokeL.objValue;
    }

    public static String truncate(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65747, null, str, i2)) == null) ? truncate(str, 0, i2) : (String) invokeLI.objValue;
    }

    public static String uncapitalize(String str) {
        InterceptResult invokeL;
        int length;
        char charAt;
        char lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65749, null, str)) == null) {
            if (str == null || (length = str.length()) == 0 || charAt == (lowerCase = Character.toLowerCase((charAt = str.charAt(0))))) {
                return str;
            }
            char[] cArr = new char[length];
            cArr[0] = lowerCase;
            str.getChars(1, length, cArr, 1);
            return String.valueOf(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static String upperCase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65750, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return str.toUpperCase();
        }
        return (String) invokeL.objValue;
    }

    public static String wrap(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65752, null, new Object[]{str, Character.valueOf(c2)})) == null) {
            if (isEmpty(str) || c2 == 0) {
                return str;
            }
            return c2 + str + c2;
        }
        return (String) invokeCommon.objValue;
    }

    public static String wrapIfMissing(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65754, null, new Object[]{str, Character.valueOf(c2)})) == null) {
            if (isEmpty(str) || c2 == 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.length() + 2);
            if (str.charAt(0) != c2) {
                sb.append(c2);
            }
            sb.append(str);
            if (str.charAt(str.length() - 1) != c2) {
                sb.append(c2);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String abbreviate(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i2, i3)) == null) {
            if (str == null) {
                return null;
            }
            if (i3 >= 4) {
                if (str.length() <= i3) {
                    return str;
                }
                if (i2 > str.length()) {
                    i2 = str.length();
                }
                int i4 = i3 - 3;
                if (str.length() - i2 < i4) {
                    i2 = str.length() - i4;
                }
                if (i2 <= 4) {
                    return str.substring(0, i4) + "...";
                } else if (i3 >= 7) {
                    if ((i3 + i2) - 3 < str.length()) {
                        return "..." + abbreviate(str.substring(i2), i4);
                    }
                    return "..." + str.substring(str.length() - i4);
                } else {
                    throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
                }
            }
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        }
        return (String) invokeLII.objValue;
    }

    public static String center(String str, int i2, char c2) {
        InterceptResult invokeCommon;
        int length;
        int length2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, Integer.valueOf(i2), Character.valueOf(c2)})) == null) ? (str == null || i2 <= 0 || (length2 = i2 - (length = str.length())) <= 0) ? str : rightPad(leftPad(str, length + (length2 / 2), c2), i2, c2) : (String) invokeCommon.objValue;
    }

    public static int compare(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65551, null, str, str2, z)) == null) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return z ? -1 : 1;
            } else if (str2 == null) {
                return z ? 1 : -1;
            } else {
                return str.compareTo(str2);
            }
        }
        return invokeLLZ.intValue;
    }

    public static int compareIgnoreCase(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65553, null, str, str2, z)) == null) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return z ? -1 : 1;
            } else if (str2 == null) {
                return z ? 1 : -1;
            } else {
                return str.compareToIgnoreCase(str2);
            }
        }
        return invokeLLZ.intValue;
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65575, null, charSequence, charSequence2, z)) == null) {
            if (charSequence == null || charSequence2 == null) {
                return charSequence == null && charSequence2 == null;
            } else if (charSequence2.length() > charSequence.length()) {
                return false;
            } else {
                return CharSequenceUtils.regionMatches(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65599, null, charSequence, charSequence2, i2)) == null) {
            if (charSequence != null && charSequence2 != null) {
                if (i2 < 0) {
                    i2 = 0;
                }
                int length = (charSequence.length() - charSequence2.length()) + 1;
                if (i2 > length) {
                    return -1;
                }
                if (charSequence2.length() == 0) {
                    return i2;
                }
                while (i2 < length) {
                    if (CharSequenceUtils.regionMatches(charSequence, true, i2, charSequence2, 0, charSequence2.length())) {
                        return i2;
                    }
                    i2++;
                }
            }
            return -1;
        }
        return invokeLLI.intValue;
    }

    public static String join(Object[] objArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65635, null, new Object[]{objArr, Character.valueOf(c2)})) == null) {
            if (objArr == null) {
                return null;
            }
            return join(objArr, c2, 0, objArr.length);
        }
        return (String) invokeCommon.objValue;
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65648, null, charSequence, charSequence2, i2)) == null) {
            if (charSequence != null && charSequence2 != null) {
                if (i2 > charSequence.length() - charSequence2.length()) {
                    i2 = charSequence.length() - charSequence2.length();
                }
                if (i2 < 0) {
                    return -1;
                }
                if (charSequence2.length() == 0) {
                    return i2;
                }
                while (i2 >= 0) {
                    if (CharSequenceUtils.regionMatches(charSequence, true, i2, charSequence2, 0, charSequence2.length())) {
                        return i2;
                    }
                    i2--;
                }
            }
            return -1;
        }
        return invokeLLI.intValue;
    }

    public static String leftPad(String str, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65652, null, new Object[]{str, Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            if (str == null) {
                return null;
            }
            int length = i2 - str.length();
            if (length <= 0) {
                return str;
            }
            if (length > 8192) {
                return leftPad(str, i2, String.valueOf(c2));
            }
            return repeat(c2, length).concat(str);
        }
        return (String) invokeCommon.objValue;
    }

    public static String lowerCase(String str, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65656, null, str, locale)) == null) {
            if (str == null) {
                return null;
            }
            return str.toLowerCase(locale);
        }
        return (String) invokeLL.objValue;
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65661, null, new Object[]{charSequence, charSequence2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (charSequence == null || charSequence2 == null || i2 <= 0) {
                return r0;
            }
            int i3 = 0;
            if (charSequence2.length() == 0) {
                if (z) {
                    return charSequence.length();
                }
                return 0;
            }
            r0 = z ? charSequence.length() : -1;
            do {
                if (z) {
                    r0 = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, r0 - 1);
                } else {
                    r0 = CharSequenceUtils.indexOf(charSequence, charSequence2, r0 + 1);
                }
                if (r0 < 0) {
                    return r0;
                }
                i3++;
            } while (i3 < i2);
            return r0;
        }
        return invokeCommon.intValue;
    }

    public static String replace(String str, String str2, String str3, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65680, null, str, str2, str3, i2)) == null) ? replace(str, str2, str3, i2, false) : (String) invokeLLLI.objValue;
    }

    public static String replaceChars(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65684, null, str, str2, str3)) == null) {
            if (isEmpty(str) || isEmpty(str2)) {
                return str;
            }
            if (str3 == null) {
                str3 = "";
            }
            int length = str3.length();
            int length2 = str.length();
            StringBuilder sb = new StringBuilder(length2);
            boolean z = false;
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt = str.charAt(i2);
                int indexOf = str2.indexOf(charAt);
                if (indexOf >= 0) {
                    if (indexOf < length) {
                        sb.append(str3.charAt(indexOf));
                    }
                    z = true;
                } else {
                    sb.append(charAt);
                }
            }
            return z ? sb.toString() : str;
        }
        return (String) invokeLLL.objValue;
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i2) {
        InterceptResult invokeCommon;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65686, null, new Object[]{str, strArr, strArr2, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (str == null || str.isEmpty() || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
                return str;
            }
            if (i2 >= 0) {
                int length2 = strArr.length;
                int length3 = strArr2.length;
                if (length2 == length3) {
                    boolean[] zArr = new boolean[length2];
                    int i3 = -1;
                    int i4 = -1;
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (!zArr[i5] && strArr[i5] != null && !strArr[i5].isEmpty() && strArr2[i5] != null) {
                            int indexOf = str.indexOf(strArr[i5]);
                            if (indexOf == -1) {
                                zArr[i5] = true;
                            } else if (i3 == -1 || indexOf < i3) {
                                i4 = i5;
                                i3 = indexOf;
                            }
                        }
                    }
                    if (i3 == -1) {
                        return str;
                    }
                    int i6 = 0;
                    for (int i7 = 0; i7 < strArr.length; i7++) {
                        if (strArr[i7] != null && strArr2[i7] != null && (length = strArr2[i7].length() - strArr[i7].length()) > 0) {
                            i6 += length * 3;
                        }
                    }
                    StringBuilder sb = new StringBuilder(str.length() + Math.min(i6, str.length() / 5));
                    int i8 = 0;
                    while (i3 != -1) {
                        while (i8 < i3) {
                            sb.append(str.charAt(i8));
                            i8++;
                        }
                        sb.append(strArr2[i4]);
                        i8 = strArr[i4].length() + i3;
                        i3 = -1;
                        i4 = -1;
                        for (int i9 = 0; i9 < length2; i9++) {
                            if (!zArr[i9] && strArr[i9] != null && !strArr[i9].isEmpty() && strArr2[i9] != null) {
                                int indexOf2 = str.indexOf(strArr[i9], i8);
                                if (indexOf2 == -1) {
                                    zArr[i9] = true;
                                } else if (i3 == -1 || indexOf2 < i3) {
                                    i4 = i9;
                                    i3 = indexOf2;
                                }
                            }
                        }
                    }
                    int length4 = str.length();
                    while (i8 < length4) {
                        sb.append(str.charAt(i8));
                        i8++;
                    }
                    String sb2 = sb.toString();
                    return !z ? sb2 : replaceEach(sb2, strArr, strArr2, z, i2 - 1);
                }
                throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
            }
            throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
        }
        return (String) invokeCommon.objValue;
    }

    public static String replaceIgnoreCase(String str, String str2, String str3, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65690, null, str, str2, str3, i2)) == null) ? replace(str, str2, str3, i2, true) : (String) invokeLLLI.objValue;
    }

    public static String rightPad(String str, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65698, null, new Object[]{str, Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            if (str == null) {
                return null;
            }
            int length = i2 - str.length();
            if (length <= 0) {
                return str;
            }
            if (length > 8192) {
                return rightPad(str, i2, String.valueOf(c2));
            }
            return str.concat(repeat(c2, length));
        }
        return (String) invokeCommon.objValue;
    }

    public static String[] split(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65702, null, new Object[]{str, Character.valueOf(c2)})) == null) ? splitWorker(str, c2, false) : (String[]) invokeCommon.objValue;
    }

    public static String[] splitByCharacterType(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65706, null, str, z)) == null) {
            if (str == null) {
                return null;
            }
            if (str.isEmpty()) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            char[] charArray = str.toCharArray();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int type = Character.getType(charArray[0]);
            for (int i3 = 1; i3 < charArray.length; i3++) {
                int type2 = Character.getType(charArray[i3]);
                if (type2 != type) {
                    if (z && type2 == 2 && type == 1) {
                        int i4 = i3 - 1;
                        if (i4 != i2) {
                            arrayList.add(new String(charArray, i2, i4 - i2));
                            i2 = i4;
                        }
                    } else {
                        arrayList.add(new String(charArray, i2, i3 - i2));
                        i2 = i3;
                    }
                    type = type2;
                }
            }
            arrayList.add(new String(charArray, i2, charArray.length - i2));
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeLZ.objValue;
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65709, null, str, str2, i2)) == null) ? splitByWholeSeparatorWorker(str, str2, i2, false) : (String[]) invokeLLI.objValue;
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65711, null, str, str2, i2)) == null) ? splitByWholeSeparatorWorker(str, str2, i2, true) : (String[]) invokeLLI.objValue;
    }

    public static String[] splitPreserveAllTokens(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65714, null, new Object[]{str, Character.valueOf(c2)})) == null) ? splitWorker(str, c2, true) : (String[]) invokeCommon.objValue;
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65720, null, charSequence, charSequence2, z)) == null) {
            if (charSequence == null || charSequence2 == null) {
                return charSequence == null && charSequence2 == null;
            } else if (charSequence2.length() > charSequence.length()) {
                return false;
            } else {
                return CharSequenceUtils.regionMatches(charSequence, z, 0, charSequence2, 0, charSequence2.length());
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static String strip(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65724, null, str, str2)) == null) ? isEmpty(str) ? str : stripEnd(stripStart(str, str2), str2) : (String) invokeLL.objValue;
    }

    public static String[] stripAll(String[] strArr, String str) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65727, null, strArr, str)) == null) {
            if (strArr == null || (length = strArr.length) == 0) {
                return strArr;
            }
            String[] strArr2 = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr2[i2] = strip(strArr[i2], str);
            }
            return strArr2;
        }
        return (String[]) invokeLL.objValue;
    }

    public static String substringBetween(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65739, null, str, str2, str3)) == null) {
            if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
                return null;
            }
            return str.substring(indexOf + str2.length(), indexOf2);
        }
        return (String) invokeLLL.objValue;
    }

    public static String truncate(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65748, null, str, i2, i3)) == null) {
            if (i2 >= 0) {
                if (i3 >= 0) {
                    if (str == null) {
                        return null;
                    }
                    if (i2 > str.length()) {
                        return "";
                    }
                    if (str.length() > i3) {
                        int i4 = i3 + i2;
                        if (i4 > str.length()) {
                            i4 = str.length();
                        }
                        return str.substring(i2, i4);
                    }
                    return str.substring(i2);
                }
                throw new IllegalArgumentException("maxWith cannot be negative");
            }
            throw new IllegalArgumentException("offset cannot be negative");
        }
        return (String) invokeLII.objValue;
    }

    public static String upperCase(String str, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65751, null, str, locale)) == null) {
            if (str == null) {
                return null;
            }
            return str.toUpperCase(locale);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, charSequence, charSequence2)) == null) ? (charSequence == null || charSequence2 == null || CharSequenceUtils.indexOf(charSequence, charSequence2, 0) < 0) ? false : true : invokeLL.booleanValue;
    }

    public static int indexOf(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65588, null, charSequence, i2, i3)) == null) {
            if (isEmpty(charSequence)) {
                return -1;
            }
            return CharSequenceUtils.indexOf(charSequence, i2, i3);
        }
        return invokeLII.intValue;
    }

    public static String join(long[] jArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65632, null, new Object[]{jArr, Character.valueOf(c2)})) == null) {
            if (jArr == null) {
                return null;
            }
            return join(jArr, c2, 0, jArr.length);
        }
        return (String) invokeCommon.objValue;
    }

    public static int lastIndexOf(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65643, null, charSequence, i2, i3)) == null) {
            if (isEmpty(charSequence)) {
                return -1;
            }
            return CharSequenceUtils.lastIndexOf(charSequence, i2, i3);
        }
        return invokeLII.intValue;
    }

    public static String remove(String str, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65666, null, new Object[]{str, Character.valueOf(c2)})) == null) {
            if (isEmpty(str) || str.indexOf(c2) == -1) {
                return str;
            }
            char[] charArray = str.toCharArray();
            int i2 = 0;
            for (int i3 = 0; i3 < charArray.length; i3++) {
                if (charArray[i3] != c2) {
                    charArray[i2] = charArray[i3];
                    i2++;
                }
            }
            return new String(charArray, 0, i2);
        }
        return (String) invokeCommon.objValue;
    }

    public static String replace(String str, String str2, String str3, int i2, boolean z) {
        InterceptResult invokeCommon;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65681, null, new Object[]{str, str2, str3, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (isEmpty(str) || isEmpty(str2) || str3 == null || i2 == 0) {
                return str;
            }
            if (z) {
                str4 = str.toLowerCase();
                str2 = str2.toLowerCase();
            } else {
                str4 = str;
            }
            int i3 = 0;
            int indexOf = str4.indexOf(str2, 0);
            if (indexOf == -1) {
                return str;
            }
            int length = str2.length();
            int length2 = str3.length() - length;
            if (length2 < 0) {
                length2 = 0;
            }
            int i4 = 64;
            if (i2 < 0) {
                i4 = 16;
            } else if (i2 <= 64) {
                i4 = i2;
            }
            StringBuilder sb = new StringBuilder(str.length() + (length2 * i4));
            while (indexOf != -1) {
                sb.append(str.substring(i3, indexOf));
                sb.append(str3);
                i3 = indexOf + length;
                i2--;
                if (i2 == 0) {
                    break;
                }
                indexOf = str4.indexOf(str2, i3);
            }
            sb.append(str.substring(i3));
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String[] split(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65703, null, str, str2)) == null) ? splitWorker(str, str2, -1, false) : (String[]) invokeLL.objValue;
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65715, null, str, str2)) == null) ? splitWorker(str, str2, -1, true) : (String[]) invokeLL.objValue;
    }

    public static String wrap(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65753, null, str, str2)) == null) ? (isEmpty(str) || isEmpty(str2)) ? str : str2.concat(str).concat(str2) : (String) invokeLL.objValue;
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, charSequence, str)) == null) {
            if (charSequence == null || str == null) {
                return false;
            }
            return containsOnly(charSequence, str.toCharArray());
        }
        return invokeLL.booleanValue;
    }

    public static int countMatches(CharSequence charSequence, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{charSequence, Character.valueOf(c2)})) == null) {
            if (isEmpty(charSequence)) {
                return 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                if (c2 == charSequence.charAt(i3)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, charSequenceArr)) == null) {
            if (charSequenceArr != null && charSequenceArr.length > 1) {
                int length = charSequenceArr.length;
                int i2 = Integer.MAX_VALUE;
                boolean z = true;
                int i3 = 0;
                boolean z2 = false;
                for (int i4 = 0; i4 < length; i4++) {
                    if (charSequenceArr[i4] == null) {
                        i2 = 0;
                        z2 = true;
                    } else {
                        i2 = Math.min(charSequenceArr[i4].length(), i2);
                        i3 = Math.max(charSequenceArr[i4].length(), i3);
                        z = false;
                    }
                }
                if (!z && (i3 != 0 || z2)) {
                    if (i2 == 0) {
                        return 0;
                    }
                    int i5 = -1;
                    for (int i6 = 0; i6 < i2; i6++) {
                        char charAt = charSequenceArr[0].charAt(i6);
                        int i7 = 1;
                        while (true) {
                            if (i7 >= length) {
                                break;
                            } else if (charSequenceArr[i7].charAt(i6) != charAt) {
                                i5 = i6;
                                break;
                            } else {
                                i7++;
                            }
                        }
                        if (i5 != -1) {
                            break;
                        }
                    }
                    return (i5 != -1 || i2 == i3) ? i5 : i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String join(int[] iArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65630, null, new Object[]{iArr, Character.valueOf(c2)})) == null) {
            if (iArr == null) {
                return null;
            }
            return join(iArr, c2, 0, iArr.length);
        }
        return (String) invokeCommon.objValue;
    }

    public static String[] split(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65704, null, str, str2, i2)) == null) ? splitWorker(str, str2, i2, false) : (String[]) invokeLLI.objValue;
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65716, null, str, str2, i2)) == null) ? splitWorker(str, str2, i2, true) : (String[]) invokeLLI.objValue;
    }

    public static String substring(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65733, null, str, i2, i3)) == null) {
            if (str == null) {
                return null;
            }
            if (i3 < 0) {
                i3 += str.length();
            }
            if (i2 < 0) {
                i2 += str.length();
            }
            if (i3 > str.length()) {
                i3 = str.length();
            }
            if (i2 > i3) {
                return "";
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            return str.substring(i2, i3);
        }
        return (String) invokeLII.objValue;
    }

    public static String center(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65546, null, str, i2, str2)) == null) {
            if (str == null || i2 <= 0) {
                return str;
            }
            if (isEmpty(str2)) {
                str2 = " ";
            }
            int length = str.length();
            int i3 = i2 - length;
            return i3 <= 0 ? str : rightPad(leftPad(str, length + (i3 / 2), str2), i2, str2);
        }
        return (String) invokeLIL.objValue;
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, charSequence, charSequence2)) == null) {
            if (charSequence == null || charSequence2 == null) {
                return -1;
            }
            return CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
        }
        return invokeLL.intValue;
    }

    public static String join(short[] sArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65639, null, new Object[]{sArr, Character.valueOf(c2)})) == null) {
            if (sArr == null) {
                return null;
            }
            return join(sArr, c2, 0, sArr.length);
        }
        return (String) invokeCommon.objValue;
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65644, null, charSequence, charSequence2)) == null) {
            if (charSequence == null || charSequence2 == null) {
                return -1;
            }
            return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
        }
        return invokeLL.intValue;
    }

    public static String leftPad(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65653, null, str, i2, str2)) == null) {
            if (str == null) {
                return null;
            }
            if (isEmpty(str2)) {
                str2 = " ";
            }
            int length = str2.length();
            int length2 = i2 - str.length();
            if (length2 <= 0) {
                return str;
            }
            if (length != 1 || length2 > 8192) {
                if (length2 == length) {
                    return str2.concat(str);
                }
                if (length2 < length) {
                    return str2.substring(0, length2).concat(str);
                }
                char[] cArr = new char[length2];
                char[] charArray = str2.toCharArray();
                for (int i3 = 0; i3 < length2; i3++) {
                    cArr[i3] = charArray[i3 % length];
                }
                return new String(cArr).concat(str);
            }
            return leftPad(str, i2, str2.charAt(0));
        }
        return (String) invokeLIL.objValue;
    }

    public static String rightPad(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65699, null, str, i2, str2)) == null) {
            if (str == null) {
                return null;
            }
            if (isEmpty(str2)) {
                str2 = " ";
            }
            int length = str2.length();
            int length2 = i2 - str.length();
            if (length2 <= 0) {
                return str;
            }
            if (length != 1 || length2 > 8192) {
                if (length2 == length) {
                    return str.concat(str2);
                }
                if (length2 < length) {
                    return str.concat(str2.substring(0, length2));
                }
                char[] cArr = new char[length2];
                char[] charArray = str2.toCharArray();
                for (int i3 = 0; i3 < length2; i3++) {
                    cArr[i3] = charArray[i3 % length];
                }
                return str.concat(new String(cArr));
            }
            return rightPad(str, i2, str2.charAt(0));
        }
        return (String) invokeLIL.objValue;
    }

    public static String appendIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, charSequence, charSequenceArr)) == null) ? appendIfMissing(str, charSequence, false, charSequenceArr) : (String) invokeLLL.objValue;
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65590, null, charSequence, charSequence2, i2)) == null) {
            if (charSequence == null || charSequence2 == null) {
                return -1;
            }
            return CharSequenceUtils.indexOf(charSequence, charSequence2, i2);
        }
        return invokeLLI.intValue;
    }

    public static String join(byte[] bArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65622, null, new Object[]{bArr, Character.valueOf(c2)})) == null) {
            if (bArr == null) {
                return null;
            }
            return join(bArr, c2, 0, bArr.length);
        }
        return (String) invokeCommon.objValue;
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65645, null, charSequence, charSequence2, i2)) == null) {
            if (charSequence == null || charSequence2 == null) {
                return -1;
            }
            return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i2);
        }
        return invokeLLI.intValue;
    }

    public static String prependIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65664, null, str, charSequence, charSequenceArr)) == null) ? prependIfMissing(str, charSequence, false, charSequenceArr) : (String) invokeLLL.objValue;
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, charSequence, str)) == null) {
            if (charSequence == null || str == null) {
                return true;
            }
            return containsNone(charSequence, str.toCharArray());
        }
        return invokeLL.booleanValue;
    }

    public static String join(char[] cArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65624, null, new Object[]{cArr, Character.valueOf(c2)})) == null) {
            if (cArr == null) {
                return null;
            }
            return join(cArr, c2, 0, cArr.length);
        }
        return (String) invokeCommon.objValue;
    }

    @Deprecated
    public static String chomp(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) ? removeEnd(str, str2) : (String) invokeLL.objValue;
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, charSequence, charSequence2)) == null) {
            if (charSequence2 == null) {
                return false;
            }
            return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
        }
        return invokeLL.booleanValue;
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65591, null, charSequence, str)) == null) {
            if (isEmpty(charSequence) || isEmpty(str)) {
                return -1;
            }
            return indexOfAny(charSequence, str.toCharArray());
        }
        return invokeLL.intValue;
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65594, null, charSequence, charSequence2)) == null) {
            if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
                int length = charSequence.length();
                int i2 = 0;
                while (i2 < length) {
                    char charAt = charSequence.charAt(i2);
                    boolean z = CharSequenceUtils.indexOf(charSequence2, charAt, 0) >= 0;
                    int i3 = i2 + 1;
                    if (i3 < length && Character.isHighSurrogate(charAt)) {
                        char charAt2 = charSequence.charAt(i3);
                        if (z && CharSequenceUtils.indexOf(charSequence2, charAt2, 0) < 0) {
                            return i2;
                        }
                    } else if (!z) {
                        return i2;
                    }
                    i2 = i3;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static String join(float[] fArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65628, null, new Object[]{fArr, Character.valueOf(c2)})) == null) {
            if (fArr == null) {
                return null;
            }
            return join(fArr, c2, 0, fArr.length);
        }
        return (String) invokeCommon.objValue;
    }

    public static String[] splitWorker(String str, String str2, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65718, null, new Object[]{str, str2, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            if (length == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            ArrayList arrayList = new ArrayList();
            if (str2 == null) {
                i5 = 0;
                z4 = false;
                z5 = false;
                i6 = 0;
                int i7 = 1;
                while (i5 < length) {
                    if (Character.isWhitespace(str.charAt(i5))) {
                        if (z4 || z) {
                            int i8 = i7 + 1;
                            if (i7 == i2) {
                                i5 = length;
                                z5 = false;
                            } else {
                                z5 = true;
                            }
                            arrayList.add(str.substring(i6, i5));
                            i7 = i8;
                            z4 = false;
                        }
                        i6 = i5 + 1;
                        i5 = i6;
                    } else {
                        i5++;
                        z4 = true;
                        z5 = false;
                    }
                }
            } else {
                if (str2.length() == 1) {
                    char charAt = str2.charAt(0);
                    i3 = 0;
                    z2 = false;
                    z3 = false;
                    i4 = 0;
                    int i9 = 1;
                    while (i3 < length) {
                        if (str.charAt(i3) == charAt) {
                            if (z2 || z) {
                                int i10 = i9 + 1;
                                if (i9 == i2) {
                                    i3 = length;
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                arrayList.add(str.substring(i4, i3));
                                i9 = i10;
                                z2 = false;
                            }
                            i4 = i3 + 1;
                            i3 = i4;
                        } else {
                            i3++;
                            z2 = true;
                            z3 = false;
                        }
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                    z3 = false;
                    i4 = 0;
                    int i11 = 1;
                    while (i3 < length) {
                        if (str2.indexOf(str.charAt(i3)) >= 0) {
                            if (z2 || z) {
                                int i12 = i11 + 1;
                                if (i11 == i2) {
                                    i3 = length;
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                arrayList.add(str.substring(i4, i3));
                                i11 = i12;
                                z2 = false;
                            }
                            i4 = i3 + 1;
                            i3 = i4;
                        } else {
                            i3++;
                            z2 = true;
                            z3 = false;
                        }
                    }
                }
                i5 = i3;
                z4 = z2;
                z5 = z3;
                i6 = i4;
            }
            if (z4 || (z && z5)) {
                arrayList.add(str.substring(i6, i5));
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeCommon.objValue;
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, charSequence, charSequenceArr)) == null) {
            if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
                for (CharSequence charSequence2 : charSequenceArr) {
                    if (contains(charSequence, charSequence2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String join(double[] dArr, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65626, null, new Object[]{dArr, Character.valueOf(c2)})) == null) {
            if (dArr == null) {
                return null;
            }
            return join(dArr, c2, 0, dArr.length);
        }
        return (String) invokeCommon.objValue;
    }

    public static String wrapIfMissing(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65755, null, str, str2)) == null) {
            if (isEmpty(str) || isEmpty(str2)) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.length() + str2.length() + str2.length());
            if (!str.startsWith(str2)) {
                sb.append(str2);
            }
            sb.append(str);
            if (!str.endsWith(str2)) {
                sb.append(str2);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65593, null, charSequence, charSequenceArr)) == null) {
            if (charSequence == null || charSequenceArr == null) {
                return -1;
            }
            int i2 = Integer.MAX_VALUE;
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0)) != -1 && indexOf < i2) {
                    i2 = indexOf;
                }
            }
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static String join(Object[] objArr, char c2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65636, null, new Object[]{objArr, Character.valueOf(c2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (objArr == null) {
                return null;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(c2);
                }
                if (objArr[i5] != null) {
                    sb.append(objArr[i5]);
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        int i4;
        CharSequence charSequence3;
        CharSequence charSequence4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65586, null, charSequence, charSequence2, i2)) == null) {
            if (charSequence == null || charSequence2 == null) {
                throw new IllegalArgumentException("Strings must not be null");
            }
            if (i2 >= 0) {
                int length = charSequence.length();
                int length2 = charSequence2.length();
                if (length == 0) {
                    if (length2 <= i2) {
                        return length2;
                    }
                    return -1;
                } else if (length2 == 0) {
                    if (length <= i2) {
                        return length;
                    }
                    return -1;
                } else if (Math.abs(length - length2) > i2) {
                    return -1;
                } else {
                    if (length > length2) {
                        i4 = charSequence.length();
                        i3 = length2;
                        charSequence4 = charSequence;
                        charSequence3 = charSequence2;
                    } else {
                        i3 = length;
                        i4 = length2;
                        charSequence3 = charSequence;
                        charSequence4 = charSequence2;
                    }
                    int i5 = i3 + 1;
                    int[] iArr = new int[i5];
                    int[] iArr2 = new int[i5];
                    int min = Math.min(i3, i2) + 1;
                    char c2 = 0;
                    for (int i6 = 0; i6 < min; i6++) {
                        iArr[i6] = i6;
                    }
                    int i7 = Integer.MAX_VALUE;
                    Arrays.fill(iArr, min, i5, Integer.MAX_VALUE);
                    Arrays.fill(iArr2, Integer.MAX_VALUE);
                    int i8 = 1;
                    while (i8 <= i4) {
                        char charAt = charSequence4.charAt(i8 - 1);
                        iArr2[c2] = i8;
                        int max = Math.max(1, i8 - i2);
                        int min2 = i8 > i7 - i2 ? i3 : Math.min(i3, i8 + i2);
                        if (max > min2) {
                            return -1;
                        }
                        if (max > 1) {
                            iArr2[max - 1] = i7;
                        }
                        while (max <= min2) {
                            int i9 = max - 1;
                            if (charSequence3.charAt(i9) == charAt) {
                                iArr2[max] = iArr[i9];
                            } else {
                                iArr2[max] = Math.min(Math.min(iArr2[i9], iArr[max]), iArr[i9]) + 1;
                            }
                            max++;
                        }
                        i8++;
                        c2 = 0;
                        i7 = Integer.MAX_VALUE;
                        int[] iArr3 = iArr2;
                        iArr2 = iArr;
                        iArr = iArr3;
                    }
                    if (iArr[i3] <= i2) {
                        return iArr[i3];
                    }
                    return -1;
                }
            }
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        return invokeLLI.intValue;
    }

    public static String repeat(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65678, null, str, str2, i2)) == null) {
            if (str != null && str2 != null) {
                return removeEnd(repeat(str + str2, i2), str2);
            }
            return repeat(str, i2);
        }
        return (String) invokeLLI.objValue;
    }

    public static String join(long[] jArr, char c2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65633, null, new Object[]{jArr, Character.valueOf(c2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (jArr == null) {
                return null;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(c2);
                }
                sb.append(jArr[i5]);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String repeat(char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65676, null, new Object[]{Character.valueOf(c2), Integer.valueOf(i2)})) == null) {
            if (i2 <= 0) {
                return "";
            }
            char[] cArr = new char[i2];
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                cArr[i3] = c2;
            }
            return new String(cArr);
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(int[] iArr, char c2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65631, null, new Object[]{iArr, Character.valueOf(c2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (iArr == null) {
                return null;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(c2);
                }
                sb.append(iArr[i5]);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(byte[] bArr, char c2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65623, null, new Object[]{bArr, Character.valueOf(c2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (bArr == null) {
                return null;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(c2);
                }
                sb.append((int) bArr[i5]);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(short[] sArr, char c2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65640, null, new Object[]{sArr, Character.valueOf(c2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (sArr == null) {
                return null;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(c2);
                }
                sb.append((int) sArr[i5]);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(char[] cArr, char c2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65625, null, new Object[]{cArr, Character.valueOf(c2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (cArr == null) {
                return null;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(c2);
                }
                sb.append(cArr[i5]);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(double[] dArr, char c2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65627, null, new Object[]{dArr, Character.valueOf(c2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (dArr == null) {
                return null;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(c2);
                }
                sb.append(dArr[i5]);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(float[] fArr, char c2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65629, null, new Object[]{fArr, Character.valueOf(c2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (fArr == null) {
                return null;
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(c2);
                }
                sb.append(fArr[i5]);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(Object[] objArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65637, null, objArr, str)) == null) {
            if (objArr == null) {
                return null;
            }
            return join(objArr, str, 0, objArr.length);
        }
        return (String) invokeLL.objValue;
    }

    public static String join(Object[] objArr, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65638, null, objArr, str, i2, i3)) == null) {
            if (objArr == null) {
                return null;
            }
            if (str == null) {
                str = "";
            }
            int i4 = i3 - i2;
            if (i4 <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(i4 * 16);
            for (int i5 = i2; i5 < i3; i5++) {
                if (i5 > i2) {
                    sb.append(str);
                }
                if (objArr[i5] != null) {
                    sb.append(objArr[i5]);
                }
            }
            return sb.toString();
        }
        return (String) invokeLLII.objValue;
    }

    public static String join(Iterator<?> it, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65620, null, new Object[]{it, Character.valueOf(c2)})) == null) {
            if (it == null) {
                return null;
            }
            if (it.hasNext()) {
                Object next = it.next();
                if (!it.hasNext()) {
                    return ObjectUtils.toString(next);
                }
                StringBuilder sb = new StringBuilder(256);
                if (next != null) {
                    sb.append(next);
                }
                while (it.hasNext()) {
                    sb.append(c2);
                    Object next2 = it.next();
                    if (next2 != null) {
                        sb.append(next2);
                    }
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(Iterator<?> it, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65621, null, it, str)) == null) {
            if (it == null) {
                return null;
            }
            if (it.hasNext()) {
                Object next = it.next();
                if (!it.hasNext()) {
                    return ObjectUtils.toString(next);
                }
                StringBuilder sb = new StringBuilder(256);
                if (next != null) {
                    sb.append(next);
                }
                while (it.hasNext()) {
                    if (str != null) {
                        sb.append(str);
                    }
                    Object next2 = it.next();
                    if (next2 != null) {
                        sb.append(next2);
                    }
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String join(Iterable<?> iterable, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65618, null, new Object[]{iterable, Character.valueOf(c2)})) == null) {
            if (iterable == null) {
                return null;
            }
            return join(iterable.iterator(), c2);
        }
        return (String) invokeCommon.objValue;
    }

    public static String join(Iterable<?> iterable, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65619, null, iterable, str)) == null) {
            if (iterable == null) {
                return null;
            }
            return join(iterable.iterator(), str);
        }
        return (String) invokeLL.objValue;
    }
}
