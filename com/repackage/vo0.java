package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Request;
/* loaded from: classes7.dex */
public class vo0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull uo0 uo0Var) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uo0Var)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(uo0Var.a);
                Object obj = uo0Var.e;
                if (obj != null) {
                    builder.tag(obj);
                }
                Headers.a aVar = uo0Var.c;
                if (aVar != null) {
                    Headers c = aVar.c();
                    for (int i = 0; i < c.g(); i++) {
                        builder.addHeader(c.f(i), c.h(i));
                    }
                }
                String str = uo0Var.b;
                builder.method(str, ro0.g(str, uo0Var.d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + uo0Var.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
