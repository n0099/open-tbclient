package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Request;
/* loaded from: classes5.dex */
public class eo0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull do0 do0Var) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, do0Var)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(do0Var.a);
                Object obj = do0Var.e;
                if (obj != null) {
                    builder.tag(obj);
                }
                Headers.a aVar = do0Var.c;
                if (aVar != null) {
                    Headers c = aVar.c();
                    for (int i = 0; i < c.g(); i++) {
                        builder.addHeader(c.f(i), c.h(i));
                    }
                }
                String str = do0Var.b;
                builder.method(str, ao0.g(str, do0Var.d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + do0Var.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
