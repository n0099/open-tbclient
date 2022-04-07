package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Request;
/* loaded from: classes7.dex */
public class rp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull qp0 qp0Var) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qp0Var)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(qp0Var.a);
                Object obj = qp0Var.e;
                if (obj != null) {
                    builder.tag(obj);
                }
                Headers.a aVar = qp0Var.c;
                if (aVar != null) {
                    Headers c = aVar.c();
                    for (int i = 0; i < c.g(); i++) {
                        builder.addHeader(c.f(i), c.h(i));
                    }
                }
                String str = qp0Var.b;
                builder.method(str, np0.g(str, qp0Var.d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + qp0Var.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
