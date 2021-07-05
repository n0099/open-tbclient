package okhttp3.internal.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.http.auth.AUTH;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public final class CacheInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InternalCache cache;

    public CacheInterceptor(InternalCache internalCache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {internalCache};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cache = internalCache;
    }

    private Response cacheWritingResponse(CacheRequest cacheRequest, Response response) throws IOException {
        InterceptResult invokeLL;
        Sink body;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, cacheRequest, response)) == null) {
            if (cacheRequest == null || (body = cacheRequest.body()) == null) {
                return response;
            }
            return response.newBuilder().body(new RealResponseBody(response.header("Content-Type"), response.body().contentLength(), Okio.buffer(new Source(this, response.body().source(), cacheRequest, Okio.buffer(body)) { // from class: okhttp3.internal.cache.CacheInterceptor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean cacheRequestClosed;
                public final /* synthetic */ CacheInterceptor this$0;
                public final /* synthetic */ BufferedSink val$cacheBody;
                public final /* synthetic */ CacheRequest val$cacheRequest;
                public final /* synthetic */ BufferedSource val$source;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, cacheRequest, r9};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$source = r7;
                    this.val$cacheRequest = cacheRequest;
                    this.val$cacheBody = r9;
                }

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                            this.cacheRequestClosed = true;
                            this.val$cacheRequest.abort();
                        }
                        this.val$source.close();
                    }
                }

                @Override // okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    InterceptResult invokeLJ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLJ = interceptable2.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                        try {
                            long read = this.val$source.read(buffer, j);
                            if (read == -1) {
                                if (!this.cacheRequestClosed) {
                                    this.cacheRequestClosed = true;
                                    this.val$cacheBody.close();
                                }
                                return -1L;
                            }
                            buffer.copyTo(this.val$cacheBody.buffer(), buffer.size() - read, read);
                            this.val$cacheBody.emitCompleteSegments();
                            return read;
                        } catch (IOException e2) {
                            if (!this.cacheRequestClosed) {
                                this.cacheRequestClosed = true;
                                this.val$cacheRequest.abort();
                            }
                            throw e2;
                        }
                    }
                    return invokeLJ.longValue;
                }

                @Override // okio.Source
                public Timeout timeout() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.val$source.timeout() : (Timeout) invokeV.objValue;
                }
            }))).build();
        }
        return (Response) invokeLL.objValue;
    }

    public static Headers combine(Headers headers, Headers headers2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, headers, headers2)) == null) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                String name = headers.name(i2);
                String value = headers.value(i2);
                if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                    Internal.instance.addLenient(builder, name, value);
                }
            }
            int size2 = headers2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String name2 = headers2.name(i3);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    Internal.instance.addLenient(builder, name2, headers2.value(i3));
                }
            }
            return builder.build();
        }
        return (Headers) invokeLL.objValue;
    }

    public static boolean isContentSpecificHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str) : invokeL.booleanValue;
    }

    public static boolean isEndToEnd(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? (HTTP.CONN_DIRECTIVE.equalsIgnoreCase(str) || HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true : invokeL.booleanValue;
    }

    public static Response stripBody(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, response)) == null) ? (response == null || response.body() == null) ? response : response.newBuilder().body(null).build() : (Response) invokeL.objValue;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
            InternalCache internalCache = this.cache;
            Response response = internalCache != null ? internalCache.get(chain.request()) : null;
            CacheStrategy cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).get();
            Request request = cacheStrategy.networkRequest;
            Response response2 = cacheStrategy.cacheResponse;
            InternalCache internalCache2 = this.cache;
            if (internalCache2 != null) {
                internalCache2.trackResponse(cacheStrategy);
            }
            if (response != null && response2 == null) {
                Util.closeQuietly(response.body());
            }
            if (request == null && response2 == null) {
                return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            }
            if (request == null) {
                return response2.newBuilder().cacheResponse(stripBody(response2)).build();
            }
            try {
                Response proceed = chain.proceed(request);
                if (proceed == null && response != null) {
                }
                if (response2 != null) {
                    if (proceed.code() == 304) {
                        Response build = response2.newBuilder().headers(combine(response2.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(stripBody(response2)).networkResponse(stripBody(proceed)).build();
                        proceed.body().close();
                        this.cache.trackConditionalCacheHit();
                        this.cache.update(response2, build);
                        return build;
                    }
                    Util.closeQuietly(response2.body());
                }
                Response build2 = proceed.newBuilder().cacheResponse(stripBody(response2)).networkResponse(stripBody(proceed)).build();
                if (this.cache != null) {
                    if (HttpHeaders.hasBody(build2) && CacheStrategy.isCacheable(build2, request)) {
                        return cacheWritingResponse(this.cache.put(build2), build2);
                    }
                    if (HttpMethod.invalidatesCache(request.method())) {
                        try {
                            this.cache.remove(request);
                        } catch (IOException unused) {
                        }
                    }
                }
                return build2;
            } finally {
                if (response != null) {
                    Util.closeQuietly(response.body());
                }
            }
        }
        return (Response) invokeL.objValue;
    }
}
