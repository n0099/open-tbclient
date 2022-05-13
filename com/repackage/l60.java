package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n60;
import com.repackage.x60;
import java.io.IOException;
/* loaded from: classes6.dex */
public class l60 implements n60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final u60 a;
    public s60 b;
    public boolean c;

    public l60(r60 r60Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r60Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        x60.b b = x60.b();
        b.c(r60Var);
        this.a = b.b();
    }

    @Override // com.repackage.n60
    public Response a(n60.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (!this.c) {
                a70 a70Var = (a70) aVar;
                Request request = aVar.request();
                request.getNetworkStatRecord().requestBodyLength = request.body() == null ? 0L : request.body().contentLength();
                s60 c = c(request);
                this.b = c;
                return a70Var.b(request, c);
            }
            throw new IOException("The request has been cancelled.");
        }
        return (Response) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = true;
            s60 s60Var = this.b;
            if (s60Var != null) {
                s60Var.disconnect();
            }
        }
    }

    public final s60 c(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) ? this.a.a(request) : (s60) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : invokeV.booleanValue;
    }
}
