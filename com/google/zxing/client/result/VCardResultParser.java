package com.google.zxing.client.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;
import com.google.zxing.Result;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class VCardResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern BEGIN_VCARD;
    public static final Pattern COMMA;
    public static final Pattern CR_LF_SPACE_TAB;
    public static final Pattern EQUALS;
    public static final Pattern NEWLINE_ESCAPE;
    public static final Pattern SEMICOLON;
    public static final Pattern SEMICOLON_OR_COMMA;
    public static final Pattern UNESCAPED_SEMICOLONS;
    public static final Pattern VCARD_ESCAPES;
    public static final Pattern VCARD_LIKE_DATE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(844611246, "Lcom/google/zxing/client/result/VCardResultParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(844611246, "Lcom/google/zxing/client/result/VCardResultParser;");
                return;
            }
        }
        BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
        VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
        CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
        NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
        VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
        EQUALS = Pattern.compile("=");
        SEMICOLON = Pattern.compile(ParamableElem.DIVIDE_PARAM);
        UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
        COMMA = Pattern.compile(",");
        SEMICOLON_OR_COMMA = Pattern.compile("[;,]");
    }

    public VCardResultParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String decodeQuotedPrintable(CharSequence charSequence, String str) {
        InterceptResult invokeLL;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, charSequence, str)) == null) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(length);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (i < length) {
                char charAt2 = charSequence.charAt(i);
                if (charAt2 != '\n' && charAt2 != '\r') {
                    if (charAt2 != '=') {
                        maybeAppendFragment(byteArrayOutputStream, str, sb);
                        sb.append(charAt2);
                    } else if (i < length - 2 && (charAt = charSequence.charAt(i + 1)) != '\r' && charAt != '\n') {
                        i += 2;
                        char charAt3 = charSequence.charAt(i);
                        int parseHexDigit = ResultParser.parseHexDigit(charAt);
                        int parseHexDigit2 = ResultParser.parseHexDigit(charAt3);
                        if (parseHexDigit >= 0 && parseHexDigit2 >= 0) {
                            byteArrayOutputStream.write((parseHexDigit << 4) + parseHexDigit2);
                        }
                    }
                }
                i++;
            }
            maybeAppendFragment(byteArrayOutputStream, str, sb);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static void formatNames(Iterable<List<String>> iterable) {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, iterable) == null) || iterable == null) {
            return;
        }
        for (List<String> list : iterable) {
            String str = list.get(0);
            String[] strArr = new String[5];
            int i = 0;
            int i2 = 0;
            while (i < 4 && (indexOf = str.indexOf(59, i2)) >= 0) {
                strArr[i] = str.substring(i2, indexOf);
                i++;
                i2 = indexOf + 1;
            }
            strArr[i] = str.substring(i2);
            StringBuilder sb = new StringBuilder(100);
            maybeAppendComponent(strArr, 3, sb);
            maybeAppendComponent(strArr, 1, sb);
            maybeAppendComponent(strArr, 2, sb);
            maybeAppendComponent(strArr, 0, sb);
            maybeAppendComponent(strArr, 4, sb);
            list.set(0, sb.toString().trim());
        }
    }

    public static boolean isLikeVCardDate(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence)) == null) ? charSequence == null || VCARD_LIKE_DATE.matcher(charSequence).matches() : invokeL.booleanValue;
    }

    public static List<String> matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{charSequence, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField(charSequence, str, z, z2);
            if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
                return null;
            }
            return matchVCardPrefixedField.get(0);
        }
        return (List) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cc, code lost:
        r4 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<List<String>> matchVCardPrefixedField(CharSequence charSequence, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        ArrayList arrayList;
        boolean z3;
        String str2;
        int indexOf;
        String replaceAll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{charSequence, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int length = str.length();
            int i = 0;
            int i2 = 0;
            ArrayList arrayList2 = null;
            while (i2 < length) {
                Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
                if (i2 > 0) {
                    i2--;
                }
                if (!matcher.find(i2)) {
                    break;
                }
                int end = matcher.end(i);
                String group = matcher.group(1);
                if (group != null) {
                    String[] split = SEMICOLON.split(group);
                    int length2 = split.length;
                    int i3 = 0;
                    arrayList = null;
                    z3 = false;
                    str2 = null;
                    while (i3 < length2) {
                        String str3 = split[i3];
                        if (arrayList == null) {
                            arrayList = new ArrayList(1);
                        }
                        arrayList.add(str3);
                        String[] split2 = EQUALS.split(str3, 2);
                        if (split2.length > 1) {
                            String str4 = split2[i];
                            String str5 = split2[1];
                            if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str5)) {
                                z3 = true;
                            } else if ("CHARSET".equalsIgnoreCase(str4)) {
                                str2 = str5;
                            }
                        }
                        i3++;
                        i = 0;
                    }
                } else {
                    arrayList = null;
                    z3 = false;
                    str2 = null;
                }
                int i4 = end;
                while (true) {
                    indexOf = str.indexOf(10, i4);
                    if (indexOf >= 0) {
                        if (indexOf < str.length() - 1) {
                            int i5 = indexOf + 1;
                            if (str.charAt(i5) == ' ' || str.charAt(i5) == '\t') {
                                i4 = indexOf + 2;
                            }
                        }
                        if (!z3 || ((indexOf <= 0 || str.charAt(indexOf - 1) != '=') && (indexOf < 2 || str.charAt(indexOf - 2) != '='))) {
                            break;
                        }
                        i4 = indexOf + 1;
                    } else {
                        break;
                    }
                }
                if (indexOf > end) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (indexOf > 0 && str.charAt(indexOf - 1) == '\r') {
                        indexOf--;
                    }
                    String substring = str.substring(end, indexOf);
                    if (z) {
                        substring = substring.trim();
                    }
                    if (z3) {
                        replaceAll = decodeQuotedPrintable(substring, str2);
                        if (z2) {
                            replaceAll = UNESCAPED_SEMICOLONS.matcher(replaceAll).replaceAll("\n").trim();
                        }
                    } else {
                        if (z2) {
                            substring = UNESCAPED_SEMICOLONS.matcher(substring).replaceAll("\n").trim();
                        }
                        replaceAll = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(replaceAll);
                        arrayList2.add(arrayList3);
                    } else {
                        arrayList.add(0, replaceAll);
                        arrayList2.add(arrayList);
                        i2 = indexOf + 1;
                        i = 0;
                    }
                }
                i2 = indexOf + 1;
                i = 0;
            }
            return arrayList2;
        }
        return (List) invokeCommon.objValue;
    }

    public static void maybeAppendComponent(String[] strArr, int i, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65543, null, strArr, i, sb) == null) || strArr[i] == null || strArr[i].isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(WebvttCueParser.CHAR_SPACE);
        }
        sb.append(strArr[i]);
    }

    public static void maybeAppendFragment(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, byteArrayOutputStream, str, sb) == null) || byteArrayOutputStream.size() <= 0) {
            return;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (str == null) {
            str2 = new String(byteArray, Charset.forName("UTF-8"));
        } else {
            try {
                str2 = new String(byteArray, str);
            } catch (UnsupportedEncodingException unused) {
                str2 = new String(byteArray, Charset.forName("UTF-8"));
            }
        }
        byteArrayOutputStream.reset();
        sb.append(str2);
    }

    public static String toPrimaryValue(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        return (String) invokeL.objValue;
    }

    public static String[] toPrimaryValues(Collection<List<String>> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, collection)) == null) {
            if (collection == null || collection.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            for (List<String> list : collection) {
                String str = list.get(0);
                if (str != null && !str.isEmpty()) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[collection.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    public static String[] toTypes(Collection<List<String>> collection) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, collection)) == null) {
            if (collection == null || collection.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            for (List<String> list : collection) {
                int i = 1;
                while (true) {
                    if (i >= list.size()) {
                        str = null;
                        break;
                    }
                    str = list.get(i);
                    int indexOf = str.indexOf(61);
                    if (indexOf >= 0) {
                        if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                            str = str.substring(indexOf + 1);
                            break;
                        }
                        i++;
                    }
                }
                arrayList.add(str);
            }
            return (String[]) arrayList.toArray(new String[collection.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            Matcher matcher = BEGIN_VCARD.matcher(massagedText);
            if (matcher.find() && matcher.start() == 0) {
                List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField("FN", massagedText, true, false);
                if (matchVCardPrefixedField == null) {
                    matchVCardPrefixedField = matchVCardPrefixedField("N", massagedText, true, false);
                    formatNames(matchVCardPrefixedField);
                }
                List<String> matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NICKNAME", massagedText, true, false);
                String[] split = matchSingleVCardPrefixedField == null ? null : COMMA.split(matchSingleVCardPrefixedField.get(0));
                List<List<String>> matchVCardPrefixedField2 = matchVCardPrefixedField("TEL", massagedText, true, false);
                List<List<String>> matchVCardPrefixedField3 = matchVCardPrefixedField("EMAIL", massagedText, true, false);
                List<String> matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField(WebvttDecoder.COMMENT_START, massagedText, false, false);
                List<List<String>> matchVCardPrefixedField4 = matchVCardPrefixedField("ADR", massagedText, true, true);
                List<String> matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("ORG", massagedText, true, true);
                List<String> matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("BDAY", massagedText, true, false);
                List<String> list = (matchSingleVCardPrefixedField4 == null || isLikeVCardDate(matchSingleVCardPrefixedField4.get(0))) ? matchSingleVCardPrefixedField4 : null;
                List<String> matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("TITLE", massagedText, true, false);
                List<List<String>> matchVCardPrefixedField5 = matchVCardPrefixedField("URL", massagedText, true, false);
                List<String> matchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("IMPP", massagedText, true, false);
                List<String> matchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField(BdSailorConfig.SAILOR_BASE_GEO, massagedText, true, false);
                String[] split2 = matchSingleVCardPrefixedField7 == null ? null : SEMICOLON_OR_COMMA.split(matchSingleVCardPrefixedField7.get(0));
                return new AddressBookParsedResult(toPrimaryValues(matchVCardPrefixedField), split, null, toPrimaryValues(matchVCardPrefixedField2), toTypes(matchVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField3), toTypes(matchVCardPrefixedField3), toPrimaryValue(matchSingleVCardPrefixedField6), toPrimaryValue(matchSingleVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField4), toTypes(matchVCardPrefixedField4), toPrimaryValue(matchSingleVCardPrefixedField3), toPrimaryValue(list), toPrimaryValue(matchSingleVCardPrefixedField5), toPrimaryValues(matchVCardPrefixedField5), (split2 == null || split2.length == 2) ? split2 : null);
            }
            return null;
        }
        return (AddressBookParsedResult) invokeL.objValue;
    }
}
