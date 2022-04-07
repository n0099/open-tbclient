package com.google.zxing.client.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class SMSParsedResult extends ParsedResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String body;
    public final String[] numbers;
    public final String subject;
    public final String[] vias;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ParsedResultType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.numbers = new String[]{str};
        this.vias = new String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.body : (String) invokeV.objValue;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder(100);
            ParsedResult.maybeAppend(this.numbers, sb);
            ParsedResult.maybeAppend(this.subject, sb);
            ParsedResult.maybeAppend(this.body, sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String[] getNumbers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.numbers : (String[]) invokeV.objValue;
    }

    public String getSMSURI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_SMS);
            boolean z = true;
            for (int i = 0; i < this.numbers.length; i++) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(this.numbers[i]);
                String[] strArr = this.vias;
                if (strArr != null && strArr[i] != null) {
                    sb.append(";via=");
                    sb.append(this.vias[i]);
                }
            }
            boolean z2 = this.body != null;
            boolean z3 = this.subject != null;
            if (z2 || z3) {
                sb.append('?');
                if (z2) {
                    sb.append("body=");
                    sb.append(this.body);
                }
                if (z3) {
                    if (z2) {
                        sb.append('&');
                    }
                    sb.append("subject=");
                    sb.append(this.subject);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getSubject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.subject : (String) invokeV.objValue;
    }

    public String[] getVias() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.vias : (String[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr, strArr2, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ParsedResultType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }
}
