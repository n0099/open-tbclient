package com.dxmpay.apollon.restnet.http;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class HttpDefines$HttpMethod {
    public static final /* synthetic */ HttpDefines$HttpMethod[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HttpDefines$HttpMethod DELETE;
    public static final HttpDefines$HttpMethod GET;
    public static final HttpDefines$HttpMethod HEAD;
    public static final HttpDefines$HttpMethod OPTIONS;
    public static final HttpDefines$HttpMethod POST;
    public static final HttpDefines$HttpMethod PUT;
    public static final HttpDefines$HttpMethod TRACE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1031233395, "Lcom/dxmpay/apollon/restnet/http/HttpDefines$HttpMethod;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1031233395, "Lcom/dxmpay/apollon/restnet/http/HttpDefines$HttpMethod;");
                return;
            }
        }
        GET = new HttpDefines$HttpMethod("GET", 0);
        POST = new HttpDefines$HttpMethod("POST", 1);
        HEAD = new HttpDefines$HttpMethod("HEAD", 2);
        OPTIONS = new HttpDefines$HttpMethod(HttpOptions.METHOD_NAME, 3);
        PUT = new HttpDefines$HttpMethod(HttpPut.METHOD_NAME, 4);
        DELETE = new HttpDefines$HttpMethod(HttpDelete.METHOD_NAME, 5);
        HttpDefines$HttpMethod httpDefines$HttpMethod = new HttpDefines$HttpMethod(HttpTrace.METHOD_NAME, 6);
        TRACE = httpDefines$HttpMethod;
        $VALUES = new HttpDefines$HttpMethod[]{GET, POST, HEAD, OPTIONS, PUT, DELETE, httpDefines$HttpMethod};
    }

    public HttpDefines$HttpMethod(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static HttpDefines$HttpMethod valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HttpDefines$HttpMethod) Enum.valueOf(HttpDefines$HttpMethod.class, str) : (HttpDefines$HttpMethod) invokeL.objValue;
    }

    public static HttpDefines$HttpMethod[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HttpDefines$HttpMethod[]) $VALUES.clone() : (HttpDefines$HttpMethod[]) invokeV.objValue;
    }
}
