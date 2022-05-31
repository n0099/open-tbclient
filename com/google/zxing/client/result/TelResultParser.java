package com.google.zxing.client.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Result;
/* loaded from: classes4.dex */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            if (massagedText.startsWith("tel:") || massagedText.startsWith("TEL:")) {
                if (massagedText.startsWith("TEL:")) {
                    str = "tel:" + massagedText.substring(4);
                } else {
                    str = massagedText;
                }
                int indexOf = massagedText.indexOf(63, 4);
                return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, null);
            }
            return null;
        }
        return (TelParsedResult) invokeL.objValue;
    }
}
