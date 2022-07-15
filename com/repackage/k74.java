package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.RequestBody;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes6.dex */
public class k74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HttpRequestBuilder a(@NonNull i74 i74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, i74Var)) == null) ? b(i74Var, null) : (HttpRequestBuilder) invokeL.objValue;
    }

    @NonNull
    public static HttpRequestBuilder b(@NonNull i74 i74Var, @Nullable j74 j74Var) {
        InterceptResult invokeLL;
        HttpCommonRequestBuilder o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, i74Var, j74Var)) == null) {
            if (j74Var == null) {
                j74Var = j74.g();
            }
            String str = i74Var.b;
            char c = 65535;
            switch (str.hashCode()) {
                case -531492226:
                    if (str.equals(HttpOptions.METHOD_NAME)) {
                        c = 2;
                        break;
                    }
                    break;
                case 70454:
                    if (str.equals("GET")) {
                        c = 0;
                        break;
                    }
                    break;
                case 79599:
                    if (str.equals(HttpPut.METHOD_NAME)) {
                        c = 4;
                        break;
                    }
                    break;
                case 2213344:
                    if (str.equals("HEAD")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2461856:
                    if (str.equals("POST")) {
                        c = 3;
                        break;
                    }
                    break;
                case 80083237:
                    if (str.equals(HttpTrace.METHOD_NAME)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (str.equals("CONNECT")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return j74Var.getRequest();
                case 1:
                    return j74Var.headerRequest();
                case 2:
                    o = j74Var.o();
                    break;
                case 3:
                    o = j74Var.postRequest();
                    break;
                case 4:
                    o = j74Var.putRequest();
                    break;
                case 5:
                    o = j74Var.deleteRequest();
                    break;
                case 6:
                    o = j74Var.y();
                    break;
                case 7:
                    o = j74Var.a();
                    break;
                default:
                    return j74Var.getRequest();
            }
            RequestBody requestBody = i74Var.d;
            if (requestBody != null) {
                o.requestBody(requestBody);
            }
            return o;
        }
        return (HttpRequestBuilder) invokeLL.objValue;
    }
}
