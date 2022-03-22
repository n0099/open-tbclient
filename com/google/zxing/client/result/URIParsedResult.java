package com.google.zxing.client.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class URIParsedResult extends ParsedResult {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern USER_IN_HOST;
    public transient /* synthetic */ FieldHolder $fh;
    public final String title;
    public final String uri;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-431211978, "Lcom/google/zxing/client/result/URIParsedResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-431211978, "Lcom/google/zxing/client/result/URIParsedResult;");
                return;
            }
        }
        USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public URIParsedResult(String str, String str2) {
        super(ParsedResultType.URI);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
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
        this.uri = massageURI(str);
        this.title = str2;
    }

    public static boolean isColonFollowedByPortNumber(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            int i2 = i + 1;
            int indexOf = str.indexOf(47, i2);
            if (indexOf < 0) {
                indexOf = str.length();
            }
            return ResultParser.isSubstringOfDigits(str, i2, indexOf - i2);
        }
        return invokeLI.booleanValue;
    }

    public static String massageURI(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String trim = str.trim();
            int indexOf = trim.indexOf(58);
            if (indexOf < 0 || isColonFollowedByPortNumber(trim, indexOf)) {
                return "http://" + trim;
            }
            return trim;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder(30);
            ParsedResult.maybeAppend(this.title, sb);
            ParsedResult.maybeAppend(this.uri, sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public String getURI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.uri : (String) invokeV.objValue;
    }

    public boolean isPossiblyMaliciousURI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? USER_IN_HOST.matcher(this.uri).find() : invokeV.booleanValue;
    }
}
