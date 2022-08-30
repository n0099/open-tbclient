package com.google.zxing.client.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.Result;
/* loaded from: classes7.dex */
public final class WifiResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WifiResultParser() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public WifiParsedResult parse(Result result) {
        InterceptResult invokeL;
        String matchSinglePrefixedField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            if (!massagedText.startsWith("WIFI:") || (matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("S:", massagedText, WebvttCueParser.CHAR_SEMI_COLON, false)) == null || matchSinglePrefixedField.isEmpty()) {
                return null;
            }
            String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("P:", massagedText, WebvttCueParser.CHAR_SEMI_COLON, false);
            String matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("T:", massagedText, WebvttCueParser.CHAR_SEMI_COLON, false);
            if (matchSinglePrefixedField3 == null) {
                matchSinglePrefixedField3 = "nopass";
            }
            return new WifiParsedResult(matchSinglePrefixedField3, matchSinglePrefixedField, matchSinglePrefixedField2, Boolean.parseBoolean(ResultParser.matchSinglePrefixedField("H:", massagedText, WebvttCueParser.CHAR_SEMI_COLON, false)));
        }
        return (WifiParsedResult) invokeL.objValue;
    }
}
