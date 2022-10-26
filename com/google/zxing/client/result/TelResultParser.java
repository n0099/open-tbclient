package com.google.zxing.client.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Result;
/* loaded from: classes7.dex */
public final class TelResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TelResultParser() {
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
    public TelParsedResult parse(Result result) {
        InterceptResult invokeL;
        String str;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            if (!massagedText.startsWith("tel:") && !massagedText.startsWith("TEL:")) {
                return null;
            }
            if (massagedText.startsWith("TEL:")) {
                str = "tel:" + massagedText.substring(4);
            } else {
                str = massagedText;
            }
            int indexOf = massagedText.indexOf(63, 4);
            if (indexOf < 0) {
                substring = massagedText.substring(4);
            } else {
                substring = massagedText.substring(4, indexOf);
            }
            return new TelParsedResult(substring, str, null);
        }
        return (TelParsedResult) invokeL.objValue;
    }
}
