package com.google.zxing.client.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Result;
/* loaded from: classes4.dex */
public final class SMSTOMMSTOResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SMSTOMMSTOResultParser() {
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
    public SMSParsedResult parse(Result result) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            if (massagedText.startsWith("smsto:") || massagedText.startsWith("SMSTO:") || massagedText.startsWith("mmsto:") || massagedText.startsWith("MMSTO:")) {
                String substring = massagedText.substring(6);
                int indexOf = substring.indexOf(58);
                if (indexOf >= 0) {
                    str = substring.substring(indexOf + 1);
                    substring = substring.substring(0, indexOf);
                } else {
                    str = null;
                }
                return new SMSParsedResult(substring, (String) null, (String) null, str);
            }
            return null;
        }
        return (SMSParsedResult) invokeL.objValue;
    }
}
