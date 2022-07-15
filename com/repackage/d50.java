package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f50;
import com.repackage.p50;
import java.io.IOException;
/* loaded from: classes5.dex */
public class d50 implements f50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final m50 a;
    public k50 b;
    public boolean c;

    public d50(j50 j50Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j50Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p50.b b = p50.b();
        b.c(j50Var);
        this.a = b.b();
    }

    @Override // com.repackage.f50
    public Response a(f50.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (!this.c) {
                s50 s50Var = (s50) aVar;
                Request request = aVar.request();
                request.getNetworkStatRecord().requestBodyLength = request.body() == null ? 0L : request.body().contentLength();
                k50 c = c(request);
                this.b = c;
                return s50Var.b(request, c);
            }
            throw new IOException("The request has been cancelled.");
        }
        return (Response) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = true;
            k50 k50Var = this.b;
            if (k50Var != null) {
                k50Var.disconnect();
            }
        }
    }

    public final k50 c(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) ? this.a.a(request) : (k50) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : invokeV.booleanValue;
    }
}
