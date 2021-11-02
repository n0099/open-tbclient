package com.google.zxing.client.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public abstract class ResultParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern AMPERSAND;
    public static final String BYTE_ORDER_MARK = "\ufeff";
    public static final Pattern DIGITS;
    public static final Pattern EQUALS;
    public static final ResultParser[] PARSERS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1505461398, "Lcom/google/zxing/client/result/ResultParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1505461398, "Lcom/google/zxing/client/result/ResultParser;");
                return;
            }
        }
        PARSERS = new ResultParser[]{new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser()};
        DIGITS = Pattern.compile("\\d+");
        AMPERSAND = Pattern.compile("&");
        EQUALS = Pattern.compile("=");
    }

    public ResultParser() {
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

    public static void appendKeyValue(CharSequence charSequence, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, charSequence, map) == null) {
            String[] split = EQUALS.split(charSequence, 2);
            if (split.length == 2) {
                try {
                    map.put(split[0], urlDecode(split[1]));
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public static int countPrecedingBackslashes(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, charSequence, i2)) == null) {
            int i3 = 0;
            for (int i4 = i2 - 1; i4 >= 0 && charSequence.charAt(i4) == '\\'; i4--) {
                i3++;
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    public static String getMassagedText(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, result)) == null) {
            String text = result.getText();
            return text.startsWith(BYTE_ORDER_MARK) ? text.substring(1) : text;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isStringOfDigits(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, charSequence, i2)) == null) ? charSequence != null && i2 > 0 && i2 == charSequence.length() && DIGITS.matcher(charSequence).matches() : invokeLI.booleanValue;
    }

    public static boolean isSubstringOfDigits(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, charSequence, i2, i3)) == null) ? charSequence != null && i3 > 0 && charSequence.length() >= (i4 = i3 + i2) && DIGITS.matcher(charSequence.subSequence(i2, i4)).matches() : invokeLII.booleanValue;
    }

    public static String[] matchPrefixedField(String str, String str2, char c2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, Character.valueOf(c2), Boolean.valueOf(z)})) == null) {
            int length = str2.length();
            ArrayList arrayList = null;
            int i2 = 0;
            while (i2 < length) {
                int indexOf = str2.indexOf(str, i2);
                if (indexOf < 0) {
                    break;
                }
                int length2 = indexOf + str.length();
                ArrayList arrayList2 = arrayList;
                boolean z2 = true;
                int i3 = length2;
                while (z2) {
                    int indexOf2 = str2.indexOf(c2, i3);
                    if (indexOf2 < 0) {
                        i3 = str2.length();
                    } else if (countPrecedingBackslashes(str2, indexOf2) % 2 != 0) {
                        i3 = indexOf2 + 1;
                    } else {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList(3);
                        }
                        String unescapeBackslash = unescapeBackslash(str2.substring(length2, indexOf2));
                        if (z) {
                            unescapeBackslash = unescapeBackslash.trim();
                        }
                        if (!unescapeBackslash.isEmpty()) {
                            arrayList2.add(unescapeBackslash);
                        }
                        i3 = indexOf2 + 1;
                    }
                    z2 = false;
                }
                i2 = i3;
                arrayList = arrayList2;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeCommon.objValue;
    }

    public static String matchSinglePrefixedField(String str, String str2, char c2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, Character.valueOf(c2), Boolean.valueOf(z)})) == null) {
            String[] matchPrefixedField = matchPrefixedField(str, str2, c2, z);
            if (matchPrefixedField == null) {
                return null;
            }
            return matchPrefixedField[0];
        }
        return (String) invokeCommon.objValue;
    }

    public static void maybeAppend(String str, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, str, sb) == null) || str == null) {
            return;
        }
        sb.append('\n');
        sb.append(str);
    }

    public static String[] maybeWrap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return new String[]{str};
        }
        return (String[]) invokeL.objValue;
    }

    public static int parseHexDigit(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                char c3 = 'a';
                if (c2 < 'a' || c2 > 'f') {
                    c3 = 'A';
                    if (c2 < 'A' || c2 > 'F') {
                        return -1;
                    }
                }
                return (c2 - c3) + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    public static Map<String, String> parseNameValuePairs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            int indexOf = str.indexOf(63);
            if (indexOf < 0) {
                return null;
            }
            HashMap hashMap = new HashMap(3);
            for (String str2 : AMPERSAND.split(str.substring(indexOf + 1))) {
                appendKeyValue(str2, hashMap);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static ParsedResult parseResult(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, result)) == null) {
            for (ResultParser resultParser : PARSERS) {
                ParsedResult parse = resultParser.parse(result);
                if (parse != null) {
                    return parse;
                }
            }
            return new TextParsedResult(result.getText(), null);
        }
        return (ParsedResult) invokeL.objValue;
    }

    public static String unescapeBackslash(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            int indexOf = str.indexOf(92);
            if (indexOf < 0) {
                return str;
            }
            int length = str.length();
            StringBuilder sb = new StringBuilder(length - 1);
            sb.append(str.toCharArray(), 0, indexOf);
            boolean z = false;
            while (indexOf < length) {
                char charAt = str.charAt(indexOf);
                if (z || charAt != '\\') {
                    sb.append(charAt);
                    z = false;
                } else {
                    z = true;
                }
                indexOf++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String urlDecode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            try {
                return URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public abstract ParsedResult parse(Result result);

    public static void maybeAppend(String[] strArr, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, strArr, sb) == null) || strArr == null) {
            return;
        }
        for (String str : strArr) {
            sb.append('\n');
            sb.append(str);
        }
    }
}
