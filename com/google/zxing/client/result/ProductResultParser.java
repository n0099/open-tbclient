package com.google.zxing.client.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;
/* loaded from: classes5.dex */
public final class ProductResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ProductResultParser() {
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
    public ProductParsedResult parse(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result)) == null) {
            BarcodeFormat barcodeFormat = result.getBarcodeFormat();
            if (barcodeFormat == BarcodeFormat.UPC_A || barcodeFormat == BarcodeFormat.UPC_E || barcodeFormat == BarcodeFormat.EAN_8 || barcodeFormat == BarcodeFormat.EAN_13) {
                String massagedText = ResultParser.getMassagedText(result);
                if (ResultParser.isStringOfDigits(massagedText, massagedText.length())) {
                    return new ProductParsedResult(massagedText, (barcodeFormat == BarcodeFormat.UPC_E && massagedText.length() == 8) ? UPCEReader.convertUPCEtoUPCA(massagedText) : massagedText);
                }
                return null;
            }
            return null;
        }
        return (ProductParsedResult) invokeL.objValue;
    }
}
