package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
/* loaded from: classes9.dex */
public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        HttpCodec newStream = streamAllocation.newStream(this.client, chain, request, !request.method().equals("GET"));
        RealConnection connection = streamAllocation.connection();
        return realInterceptorChain.proceed(request.newBuilder().addressList(connection.routeList).fallbackConn(connection.isFallbackConn).build(), streamAllocation, newStream, connection);
    }
}
