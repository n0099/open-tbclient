package com.google.zxing.client.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
/* loaded from: classes4.dex */
public final class ISBNResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ISBNResultParser() {
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
    public ISBNParsedResult parse(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            if (result.getBarcodeFormat() != BarcodeFormat.EAN_13) {
                return null;
            }
            String massagedText = ResultParser.getMassagedText(result);
            if (massagedText.length() != 13) {
                return null;
            }
            if (massagedText.startsWith("978") || massagedText.startsWith("979")) {
                return new ISBNParsedResult(massagedText);
            }
            return null;
        }
        return (ISBNParsedResult) invokeL.objValue;
    }
}
