package com.google.zxing.client.result;

import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import com.google.zxing.Result;
import java.util.List;
/* loaded from: classes5.dex */
public final class VEventResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VEventResultParser() {
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

    public static String matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, charSequence, str, z)) == null) {
            List<String> matchSingleVCardPrefixedField = VCardResultParser.matchSingleVCardPrefixedField(charSequence, str, z, false);
            if (matchSingleVCardPrefixedField == null || matchSingleVCardPrefixedField.isEmpty()) {
                return null;
            }
            return matchSingleVCardPrefixedField.get(0);
        }
        return (String) invokeLLZ.objValue;
    }

    public static String[] matchVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, charSequence, str, z)) == null) {
            List<List<String>> matchVCardPrefixedField = VCardResultParser.matchVCardPrefixedField(charSequence, str, z, false);
            if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
                return null;
            }
            int size = matchVCardPrefixedField.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = matchVCardPrefixedField.get(i).get(0);
            }
            return strArr;
        }
        return (String[]) invokeLLZ.objValue;
    }

    public static String stripMailto(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str != null ? (str.startsWith(WebView.SCHEME_MAILTO) || str.startsWith("MAILTO:")) ? str.substring(7) : str : str : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public CalendarParsedResult parse(Result result) {
        InterceptResult invokeL;
        double parseDouble;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            if (massagedText.indexOf("BEGIN:VEVENT") < 0) {
                return null;
            }
            String matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("SUMMARY", massagedText, true);
            String matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("DTSTART", massagedText, true);
            if (matchSingleVCardPrefixedField2 == null) {
                return null;
            }
            String matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("DTEND", massagedText, true);
            String matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("DURATION", massagedText, true);
            String matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("LOCATION", massagedText, true);
            String stripMailto = stripMailto(matchSingleVCardPrefixedField("ORGANIZER", massagedText, true));
            String[] matchVCardPrefixedField = matchVCardPrefixedField("ATTENDEE", massagedText, true);
            if (matchVCardPrefixedField != null) {
                for (int i = 0; i < matchVCardPrefixedField.length; i++) {
                    matchVCardPrefixedField[i] = stripMailto(matchVCardPrefixedField[i]);
                }
            }
            String matchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("DESCRIPTION", massagedText, true);
            String matchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField(BdSailorConfig.SAILOR_BASE_GEO, massagedText, true);
            double d = Double.NaN;
            if (matchSingleVCardPrefixedField7 == null) {
                parseDouble = Double.NaN;
            } else {
                int indexOf = matchSingleVCardPrefixedField7.indexOf(59);
                if (indexOf < 0) {
                    return null;
                }
                try {
                    d = Double.parseDouble(matchSingleVCardPrefixedField7.substring(0, indexOf));
                    parseDouble = Double.parseDouble(matchSingleVCardPrefixedField7.substring(indexOf + 1));
                } catch (NumberFormatException | IllegalArgumentException unused) {
                    return null;
                }
            }
            return new CalendarParsedResult(matchSingleVCardPrefixedField, matchSingleVCardPrefixedField2, matchSingleVCardPrefixedField3, matchSingleVCardPrefixedField4, matchSingleVCardPrefixedField5, stripMailto, matchVCardPrefixedField, matchSingleVCardPrefixedField6, d, parseDouble);
        }
        return (CalendarParsedResult) invokeL.objValue;
    }
}
