package com.google.zxing.client.result;

import com.android.internal.http.multipart.Part;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Result;
import java.util.ArrayList;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes11.dex */
public final class AddressBookAUResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AddressBookAUResultParser() {
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

    public static String[] matchMultipleValuePrefix(String str, int i2, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i2), str2, Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = null;
            for (int i3 = 1; i3 <= i2; i3++) {
                String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField(str + i3 + ':', str2, CharUtils.CR, z);
                if (matchSinglePrefixedField == null) {
                    break;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList(i2);
                }
                arrayList.add(matchSinglePrefixedField);
            }
            if (arrayList == null) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            if (massagedText.contains("MEMORY") && massagedText.contains(Part.CRLF)) {
                String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("NAME1:", massagedText, CharUtils.CR, true);
                String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("NAME2:", massagedText, CharUtils.CR, true);
                String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
                String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_MAIL, 3, massagedText, true);
                String matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("MEMORY:", massagedText, CharUtils.CR, false);
                String matchSinglePrefixedField4 = ResultParser.matchSinglePrefixedField("ADD:", massagedText, CharUtils.CR, true);
                return new AddressBookParsedResult(ResultParser.maybeWrap(matchSinglePrefixedField), null, matchSinglePrefixedField2, matchMultipleValuePrefix, null, matchMultipleValuePrefix2, null, null, matchSinglePrefixedField3, matchSinglePrefixedField4 != null ? new String[]{matchSinglePrefixedField4} : null, null, null, null, null, null, null);
            }
            return null;
        }
        return (AddressBookParsedResult) invokeL.objValue;
    }
}
