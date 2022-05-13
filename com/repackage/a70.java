package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n60;
import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public final class a70 implements n60.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<n60> a;
    public s60 b;
    public final int c;
    public final Request d;
    public final Call e;
    public int f;

    public a70(List<n60> list, s60 s60Var, int i, Request request, Call call) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, s60Var, Integer.valueOf(i), request, call};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.b = s60Var;
        this.c = i;
        this.d = request;
        this.e = call;
    }

    @Override // com.repackage.n60.a
    public Response a(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) ? b(request, this.b) : (Response) invokeL.objValue;
    }

    public Response b(Request request, s60 s60Var) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, s60Var)) == null) {
            if (this.c < this.a.size()) {
                this.f++;
                a70 a70Var = new a70(this.a, s60Var, this.c + 1, request, this.e);
                n60 n60Var = this.a.get(this.c);
                Response a = n60Var.a(a70Var);
                if (a != null) {
                    if (a.body() != null) {
                        a.getStatRecord().responseLength = a.body().contentLength();
                        a.getStatRecord().finishTs = System.currentTimeMillis();
                        MediaType contentType = a.body().contentType();
                        if (contentType != null) {
                            a.getStatRecord().contentType = contentType.toString();
                        }
                        return a;
                    }
                    throw new IllegalStateException("interceptor " + n60Var + " returned a response with no body");
                }
                throw new NullPointerException("interceptor " + n60Var + " returned null");
            }
            throw new AssertionError();
        }
        return (Response) invokeLL.objValue;
    }

    public Call call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (Call) invokeV.objValue;
    }

    @Override // com.repackage.n60.a
    public s60 connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (s60) invokeV.objValue;
    }

    @Override // com.repackage.n60.a
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (Request) invokeV.objValue;
    }
}
