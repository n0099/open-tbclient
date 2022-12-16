package okhttp3.internal.connection;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
/* loaded from: classes9.dex */
public final class ConnectInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.client = okHttpClient;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
            RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
            Request request = realInterceptorChain.request();
            StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
            HttpCodec newStream = streamAllocation.newStream(this.client, chain, !request.method().equals("GET"));
            RealConnection connection = streamAllocation.connection();
            return realInterceptorChain.proceed(request.newBuilder().addressList(connection.routeList).fallbackConn(connection.isFallbackConn).addressIndex(connection.addressIndex).isMultiConnectTriggered(connection.isMultiConnectTriggered).build(), streamAllocation, newStream, connection);
        }
        return (Response) invokeL.objValue;
    }
}
