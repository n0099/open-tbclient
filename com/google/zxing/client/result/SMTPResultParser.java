package com.google.zxing.client.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Result;
/* loaded from: classes4.dex */
public final class SMTPResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SMTPResultParser() {
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
    public EmailAddressParsedResult parse(Result result) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            if (massagedText.startsWith("smtp:") || massagedText.startsWith("SMTP:")) {
                String substring = massagedText.substring(5);
                int indexOf = substring.indexOf(58);
                if (indexOf >= 0) {
                    String substring2 = substring.substring(indexOf + 1);
                    substring = substring.substring(0, indexOf);
                    int indexOf2 = substring2.indexOf(58);
                    if (indexOf2 >= 0) {
                        String substring3 = substring2.substring(indexOf2 + 1);
                        str = substring2.substring(0, indexOf2);
                        str2 = substring3;
                    } else {
                        str2 = null;
                        str = substring2;
                    }
                } else {
                    str = null;
                    str2 = null;
                }
                return new EmailAddressParsedResult(new String[]{substring}, null, null, str, str2);
            }
            return null;
        }
        return (EmailAddressParsedResult) invokeL.objValue;
    }
}
