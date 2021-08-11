package okhttp3.internal.http;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public final class CallServerInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean forWebSocket;

    /* loaded from: classes2.dex */
    public static final class CountingSink extends ForwardingSink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long successfulCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountingSink(Sink sink) {
            super(sink);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sink};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Sink) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, buffer, j2) == null) {
                super.write(buffer, j2);
                this.successfulCount += j2;
            }
        }
    }

    public CallServerInterceptor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Response build;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
            RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
            HttpCodec httpStream = realInterceptorChain.httpStream();
            StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
            RealConnection realConnection = (RealConnection) realInterceptorChain.connection();
            Request request = realInterceptorChain.request();
            long currentTimeMillis = System.currentTimeMillis();
            realInterceptorChain.eventListener().requestHeadersStart(realInterceptorChain.call());
            httpStream.writeRequestHeaders(request);
            realInterceptorChain.eventListener().requestHeadersEnd(realInterceptorChain.call(), request);
            Response.Builder builder = null;
            if (HttpMethod.permitsRequestBody(request.method()) && request.body() != null) {
                if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(request.header(HTTP.EXPECT_DIRECTIVE))) {
                    httpStream.flushRequest();
                    realInterceptorChain.eventListener().responseHeadersStart(realInterceptorChain.call());
                    builder = httpStream.readResponseHeaders(true);
                }
                if (builder == null) {
                    realInterceptorChain.eventListener().requestBodyStart(realInterceptorChain.call());
                    CountingSink countingSink = new CountingSink(httpStream.createRequestBody(request, request.body().contentLength()));
                    BufferedSink buffer = Okio.buffer(countingSink);
                    request.body().writeTo(buffer);
                    buffer.close();
                    realInterceptorChain.eventListener().requestBodyEnd(realInterceptorChain.call(), countingSink.successfulCount);
                } else if (!realConnection.isMultiplexed()) {
                    streamAllocation.noNewStreams();
                }
            }
            httpStream.finishRequest();
            if (builder == null) {
                realInterceptorChain.eventListener().responseHeadersStart(realInterceptorChain.call());
                builder = httpStream.readResponseHeaders(false);
            }
            Response build2 = builder.request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            int code = build2.code();
            if (code == 100) {
                build2 = httpStream.readResponseHeaders(false).request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                code = build2.code();
            }
            realInterceptorChain.eventListener().responseHeadersEnd(realInterceptorChain.call(), build2);
            if (this.forWebSocket && code == 101) {
                build = build2.newBuilder().body(Util.EMPTY_RESPONSE).build();
            } else {
                build = build2.newBuilder().body(httpStream.openResponseBody(build2)).build();
            }
            if (IntentConfig.CLOSE.equalsIgnoreCase(build.request().header(HTTP.CONN_DIRECTIVE)) || IntentConfig.CLOSE.equalsIgnoreCase(build.header(HTTP.CONN_DIRECTIVE))) {
                streamAllocation.noNewStreams();
            }
            if ((code == 204 || code == 205) && build.body().contentLength() > 0) {
                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + build.body().contentLength());
            }
            return build;
        }
        return (Response) invokeL.objValue;
    }
}
