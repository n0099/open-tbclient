package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Request;
/* loaded from: classes6.dex */
public class io0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Request.Builder a(@NonNull ho0 ho0Var) throws RequestError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ho0Var)) == null) {
            Request.Builder builder = new Request.Builder();
            try {
                builder.url(ho0Var.a);
                Object obj = ho0Var.e;
                if (obj != null) {
                    builder.tag(obj);
                }
                Headers.a aVar = ho0Var.c;
                if (aVar != null) {
                    Headers c = aVar.c();
                    for (int i = 0; i < c.g(); i++) {
                        builder.addHeader(c.f(i), c.h(i));
                    }
                }
                String str = ho0Var.b;
                builder.method(str, eo0.g(str, ho0Var.d));
                return builder;
            } catch (Throwable th) {
                throw new RequestError("Invalid request url: " + ho0Var.a, th);
            }
        }
        return (Request.Builder) invokeL.objValue;
    }
}
