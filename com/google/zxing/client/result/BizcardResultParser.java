package com.google.zxing.client.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.Result;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class BizcardResultParser extends AbstractDoCoMoResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BizcardResultParser() {
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

    public static String buildName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (str == null) {
                return str2;
            }
            if (str2 == null) {
                return str;
            }
            return str + WebvttCueParser.CHAR_SPACE + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String[] buildPhoneNumbers(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            ArrayList arrayList = new ArrayList(3);
            if (str != null) {
                arrayList.add(str);
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[size]);
        }
        return (String[]) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            if (massagedText.startsWith("BIZCARD:")) {
                String buildName = buildName(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("N:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("X:", massagedText, true));
                String matchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("T:", massagedText, true);
                return new AddressBookParsedResult(ResultParser.maybeWrap(buildName), null, null, buildPhoneNumbers(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("B:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("M:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("F:", massagedText, true)), null, ResultParser.maybeWrap(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("E:", massagedText, true)), null, null, null, AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("A:", massagedText, true), null, AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("C:", massagedText, true), null, matchSingleDoCoMoPrefixedField, null, null);
            }
            return null;
        }
        return (AddressBookParsedResult) invokeL.objValue;
    }
}
