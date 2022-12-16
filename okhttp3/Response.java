package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import org.apache.http.auth.AUTH;
/* loaded from: classes9.dex */
public final class Response implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final ResponseBody body;
    @Nullable
    public volatile CacheControl cacheControl;
    @Nullable
    public final Response cacheResponse;
    public final int code;
    @Nullable
    public final Handshake handshake;
    public final Headers headers;
    public final String message;
    @Nullable
    public final Response networkResponse;
    @Nullable
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sentRequestAtMillis;

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public ResponseBody body;
        @Nullable
        public Response cacheResponse;
        public int code;
        @Nullable
        public Handshake handshake;
        public Headers.Builder headers;
        public String message;
        @Nullable
        public Response networkResponse;
        @Nullable
        public Response priorResponse;
        @Nullable
        public Protocol protocol;
        public long receivedResponseAtMillis;
        @Nullable
        public Request request;
        public long sentRequestAtMillis;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        public Builder(Response response) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {response};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.code = -1;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.handshake = response.handshake;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
        }

        private void checkPriorResponse(Response response) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65538, this, response) != null) || response.body == null) {
                return;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        public Builder body(@Nullable ResponseBody responseBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseBody)) == null) {
                this.body = responseBody;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder cacheResponse(@Nullable Response response) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, response)) == null) {
                if (response != null) {
                    checkSupportResponse("cacheResponse", response);
                }
                this.cacheResponse = response;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder code(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.code = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder handshake(@Nullable Handshake handshake) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, handshake)) == null) {
                this.handshake = handshake;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder headers(Headers headers) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, headers)) == null) {
                this.headers = headers.newBuilder();
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder message(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.message = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder networkResponse(@Nullable Response response) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, response)) == null) {
                if (response != null) {
                    checkSupportResponse("networkResponse", response);
                }
                this.networkResponse = response;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder priorResponse(@Nullable Response response) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, response)) == null) {
                if (response != null) {
                    checkPriorResponse(response);
                }
                this.priorResponse = response;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder protocol(Protocol protocol) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, protocol)) == null) {
                this.protocol = protocol;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder receivedResponseAtMillis(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
                this.receivedResponseAtMillis = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder removeHeader(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.headers.removeAll(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder request(Request request) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, request)) == null) {
                this.request = request;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder sentRequestAtMillis(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
                this.sentRequestAtMillis = j;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        private void checkSupportResponse(String str, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, str, response) == null) {
                if (response.body == null) {
                    if (response.networkResponse == null) {
                        if (response.cacheResponse == null) {
                            if (response.priorResponse == null) {
                                return;
                            }
                            throw new IllegalArgumentException(str + ".priorResponse != null");
                        }
                        throw new IllegalArgumentException(str + ".cacheResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".networkResponse != null");
                }
                throw new IllegalArgumentException(str + ".body != null");
            }
        }

        public Builder addHeader(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.headers.add(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder header(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                this.headers.set(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Response build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.request != null) {
                    if (this.protocol != null) {
                        if (this.code >= 0) {
                            if (this.message != null) {
                                return new Response(this);
                            }
                            throw new IllegalStateException("message == null");
                        }
                        throw new IllegalStateException("code < 0: " + this.code);
                    }
                    throw new IllegalStateException("protocol == null");
                }
                throw new IllegalStateException("request == null");
            }
            return (Response) invokeV.objValue;
        }
    }

    public Response(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.request = builder.request;
        this.protocol = builder.protocol;
        this.code = builder.code;
        this.message = builder.message;
        this.handshake = builder.handshake;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.networkResponse = builder.networkResponse;
        this.cacheResponse = builder.cacheResponse;
        this.priorResponse = builder.priorResponse;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
    }

    public ResponseBody peekBody(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            BufferedSource source = this.body.source();
            source.request(j);
            Buffer clone = source.buffer().clone();
            if (clone.size() > j) {
                Buffer buffer = new Buffer();
                buffer.write(clone, j);
                clone.clear();
                clone = buffer;
            }
            return ResponseBody.create(this.body.contentType(), clone.size(), clone);
        }
        return (ResponseBody) invokeJ.objValue;
    }

    @Nullable
    public ResponseBody body() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.body;
        }
        return (ResponseBody) invokeV.objValue;
    }

    public CacheControl cacheControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CacheControl cacheControl = this.cacheControl;
            if (cacheControl == null) {
                CacheControl parse = CacheControl.parse(this.headers);
                this.cacheControl = parse;
                return parse;
            }
            return cacheControl;
        }
        return (CacheControl) invokeV.objValue;
    }

    @Nullable
    public Response cacheResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.cacheResponse;
        }
        return (Response) invokeV.objValue;
    }

    public List<Challenge> challenges() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.code;
            if (i == 401) {
                str = AUTH.WWW_AUTH;
            } else if (i == 407) {
                str = AUTH.PROXY_AUTH;
            } else {
                return Collections.emptyList();
            }
            return HttpHeaders.parseChallenges(headers(), str);
        }
        return (List) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ResponseBody responseBody = this.body;
            if (responseBody != null) {
                responseBody.close();
                return;
            }
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
    }

    public int code() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.code;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Handshake handshake() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.handshake;
        }
        return (Handshake) invokeV.objValue;
    }

    public Headers headers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.headers;
        }
        return (Headers) invokeV.objValue;
    }

    public boolean isRedirect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i = this.code;
            if (i == 307 || i == 308) {
                return true;
            }
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    return true;
                default:
                    return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isSuccessful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.code;
            if (i >= 200 && i < 300) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String message() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.message;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public Response networkResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.networkResponse;
        }
        return (Response) invokeV.objValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new Builder(this);
        }
        return (Builder) invokeV.objValue;
    }

    @Nullable
    public Response priorResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.priorResponse;
        }
        return (Response) invokeV.objValue;
    }

    public Protocol protocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.protocol;
        }
        return (Protocol) invokeV.objValue;
    }

    public long receivedResponseAtMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.receivedResponseAtMillis;
        }
        return invokeV.longValue;
    }

    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.request;
        }
        return (Request) invokeV.objValue;
    }

    public long sentRequestAtMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.sentRequestAtMillis;
        }
        return invokeV.longValue;
    }

    @Nullable
    public String header(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return header(str, null);
        }
        return (String) invokeL.objValue;
    }

    public List<String> headers(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return this.headers.values(str);
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String str3 = this.headers.get(str);
            if (str3 != null) {
                return str3;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
        }
        return (String) invokeV.objValue;
    }
}
