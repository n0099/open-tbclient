package com.google.zxing.client.result;

import com.baidu.tbadk.core.util.ColdStartStatsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.util.HashMap;
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public final class ExpandedProductResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ExpandedProductResultParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String findAIvalue(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
            if (str.charAt(i) != '(') {
                return null;
            }
            String substring = str.substring(i + 1);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < substring.length(); i2++) {
                char charAt = substring.charAt(i2);
                if (charAt == ')') {
                    return sb.toString();
                }
                if (charAt < '0' || charAt > '9') {
                    return null;
                }
                sb.append(charAt);
            }
            return sb.toString();
        }
        return (String) invokeIL.objValue;
    }

    public static String findValue(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(i);
            for (int i2 = 0; i2 < substring.length(); i2++) {
                char charAt = substring.charAt(i2);
                if (charAt == '(') {
                    if (findAIvalue(i2, substring) != null) {
                        break;
                    }
                    sb.append('(');
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return (String) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01ff, code lost:
        if (r1.equals("10") != false) goto L33;
     */
    @Override // com.google.zxing.client.result.ResultParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExpandedProductParsedResult parse(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            ExpandedProductParsedResult expandedProductParsedResult = null;
            if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
                return null;
            }
            String massagedText = ResultParser.getMassagedText(result);
            HashMap hashMap = new HashMap();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            int i = 0;
            while (i < massagedText.length()) {
                String findAIvalue = findAIvalue(i, massagedText);
                if (findAIvalue == null) {
                    return expandedProductParsedResult;
                }
                char c = 2;
                int length = i + findAIvalue.length() + 2;
                String findValue = findValue(length, massagedText);
                int length2 = length + findValue.length();
                int hashCode = findAIvalue.hashCode();
                String str14 = str11;
                String str15 = str10;
                if (hashCode == 1536) {
                    if (findAIvalue.equals("00")) {
                        c = 0;
                    }
                    c = 65535;
                } else if (hashCode == 1537) {
                    if (findAIvalue.equals("01")) {
                        c = 1;
                    }
                    c = 65535;
                } else if (hashCode != 1567) {
                    if (hashCode == 1568) {
                        if (findAIvalue.equals("11")) {
                            c = 3;
                        }
                        c = 65535;
                    } else if (hashCode == 1570) {
                        if (findAIvalue.equals("13")) {
                            c = 4;
                        }
                        c = 65535;
                    } else if (hashCode == 1572) {
                        if (findAIvalue.equals("15")) {
                            c = 5;
                        }
                        c = 65535;
                    } else if (hashCode != 1574) {
                        switch (hashCode) {
                            case 1567966:
                                if (findAIvalue.equals("3100")) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567967:
                                if (findAIvalue.equals("3101")) {
                                    c = '\b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567968:
                                if (findAIvalue.equals("3102")) {
                                    c = '\t';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567969:
                                if (findAIvalue.equals("3103")) {
                                    c = '\n';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567970:
                                if (findAIvalue.equals("3104")) {
                                    c = 11;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567971:
                                if (findAIvalue.equals("3105")) {
                                    c = '\f';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567972:
                                if (findAIvalue.equals("3106")) {
                                    c = '\r';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567973:
                                if (findAIvalue.equals("3107")) {
                                    c = 14;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567974:
                                if (findAIvalue.equals("3108")) {
                                    c = 15;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1567975:
                                if (findAIvalue.equals("3109")) {
                                    c = 16;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                switch (hashCode) {
                                    case 1568927:
                                        if (findAIvalue.equals("3200")) {
                                            c = 17;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568928:
                                        if (findAIvalue.equals("3201")) {
                                            c = 18;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568929:
                                        if (findAIvalue.equals("3202")) {
                                            c = 19;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568930:
                                        if (findAIvalue.equals("3203")) {
                                            c = 20;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568931:
                                        if (findAIvalue.equals("3204")) {
                                            c = 21;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568932:
                                        if (findAIvalue.equals(ColdStartStatsUtil.COLD_START_STATS_ID)) {
                                            c = 22;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568933:
                                        if (findAIvalue.equals("3206")) {
                                            c = 23;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568934:
                                        if (findAIvalue.equals("3207")) {
                                            c = 24;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568935:
                                        if (findAIvalue.equals("3208")) {
                                            c = 25;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1568936:
                                        if (findAIvalue.equals("3209")) {
                                            c = 26;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 1575716:
                                                if (findAIvalue.equals("3920")) {
                                                    c = 27;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            case 1575717:
                                                if (findAIvalue.equals("3921")) {
                                                    c = DecodedBitStreamParser.FS;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            case 1575718:
                                                if (findAIvalue.equals("3922")) {
                                                    c = DecodedBitStreamParser.GS;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            case 1575719:
                                                if (findAIvalue.equals("3923")) {
                                                    c = DecodedBitStreamParser.RS;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            default:
                                                switch (hashCode) {
                                                    case 1575747:
                                                        if (findAIvalue.equals("3930")) {
                                                            c = 31;
                                                            break;
                                                        }
                                                        c = 65535;
                                                        break;
                                                    case 1575748:
                                                        if (findAIvalue.equals("3931")) {
                                                            c = WebvttCueParser.CHAR_SPACE;
                                                            break;
                                                        }
                                                        c = 65535;
                                                        break;
                                                    case 1575749:
                                                        if (findAIvalue.equals("3932")) {
                                                            c = '!';
                                                            break;
                                                        }
                                                        c = 65535;
                                                        break;
                                                    case 1575750:
                                                        if (findAIvalue.equals("3933")) {
                                                            c = Typography.quote;
                                                            break;
                                                        }
                                                        c = 65535;
                                                        break;
                                                    default:
                                                        c = 65535;
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        if (findAIvalue.equals("17")) {
                            c = 6;
                        }
                        c = 65535;
                    }
                }
                switch (c) {
                    case 0:
                        str2 = findValue;
                        i = length2;
                        str11 = str14;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    case 1:
                        str = findValue;
                        i = length2;
                        str11 = str14;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    case 2:
                        str3 = findValue;
                        i = length2;
                        str11 = str14;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    case 3:
                        str4 = findValue;
                        i = length2;
                        str11 = str14;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    case 4:
                        str5 = findValue;
                        i = length2;
                        str11 = str14;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    case 5:
                        str6 = findValue;
                        i = length2;
                        str11 = str14;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    case 6:
                        str7 = findValue;
                        i = length2;
                        str11 = str14;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
                    case 16:
                        str10 = findAIvalue.substring(3);
                        str9 = ExpandedProductParsedResult.KILOGRAM;
                        break;
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                        str10 = findAIvalue.substring(3);
                        str9 = ExpandedProductParsedResult.POUND;
                        break;
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                        str12 = findAIvalue.substring(3);
                        str11 = findValue;
                        i = length2;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    case 31:
                    case ' ':
                    case '!':
                    case '\"':
                        if (findValue.length() < 4) {
                            return null;
                        }
                        str11 = findValue.substring(3);
                        str13 = findValue.substring(0, 3);
                        str12 = findAIvalue.substring(3);
                        i = length2;
                        str10 = str15;
                        expandedProductParsedResult = null;
                    default:
                        hashMap.put(findAIvalue, findValue);
                        i = length2;
                        str11 = str14;
                        str10 = str15;
                        expandedProductParsedResult = null;
                }
                str8 = findValue;
                i = length2;
                str11 = str14;
                expandedProductParsedResult = null;
            }
            return new ExpandedProductParsedResult(massagedText, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashMap);
        }
        return (ExpandedProductParsedResult) invokeL.objValue;
    }
}
