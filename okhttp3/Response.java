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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.auth.AUTH;
/* loaded from: classes9.dex */
public final class Response implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final ResponseBody body;
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

    public Response(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @Nullable
    public ResponseBody body() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.body : (ResponseBody) invokeV.objValue;
    }

    public CacheControl cacheControl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CacheControl cacheControl = this.cacheControl;
            if (cacheControl != null) {
                return cacheControl;
            }
            CacheControl parse = CacheControl.parse(this.headers);
            this.cacheControl = parse;
            return parse;
        }
        return (CacheControl) invokeV.objValue;
    }

    @Nullable
    public Response cacheResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cacheResponse : (Response) invokeV.objValue;
    }

    public List<Challenge> challenges() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.code;
            if (i2 == 401) {
                str = AUTH.WWW_AUTH;
            } else if (i2 != 407) {
                return Collections.emptyList();
            } else {
                str = AUTH.PROXY_AUTH;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.code : invokeV.intValue;
    }

    public Handshake handshake() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.handshake : (Handshake) invokeV.objValue;
    }

    @Nullable
    public String header(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? header(str, null) : (String) invokeL.objValue;
    }

    public List<String> headers(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? this.headers.values(str) : (List) invokeL.objValue;
    }

    public boolean isRedirect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.code;
            if (i2 == 307 || i2 == 308) {
                return true;
            }
            switch (i2) {
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
            int i2 = this.code;
            return i2 >= 200 && i2 < 300;
        }
        return invokeV.booleanValue;
    }

    public String message() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    @Nullable
    public Response networkResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.networkResponse : (Response) invokeV.objValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new Builder(this) : (Builder) invokeV.objValue;
    }

    public ResponseBody peekBody(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
            BufferedSource source = this.body.source();
            source.request(j2);
            Buffer clone = source.buffer().clone();
            if (clone.size() > j2) {
                Buffer buffer = new Buffer();
                buffer.write(clone, j2);
                clone.clear();
                clone = buffer;
            }
            return ResponseBody.create(this.body.contentType(), clone.size(), clone);
        }
        return (ResponseBody) invokeJ.objValue;
    }

    @Nullable
    public Response priorResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.priorResponse : (Response) invokeV.objValue;
    }

    public Protocol protocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.protocol : (Protocol) invokeV.objValue;
    }

    public long receivedResponseAtMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.receivedResponseAtMillis : invokeV.longValue;
    }

    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.request : (Request) invokeV.objValue;
    }

    public long sentRequestAtMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.sentRequestAtMillis : invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String str3 = this.headers.get(str);
            return str3 != null ? str3 : str2;
        }
        return (String) invokeLL.objValue;
    }

    public Headers headers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.headers : (Headers) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ResponseBody body;
        public Response cacheResponse;
        public int code;
        @Nullable
        public Handshake handshake;
        public Headers.Builder headers;
        public String message;
        public Response networkResponse;
        public Response priorResponse;
        public Protocol protocol;
        public long receivedResponseAtMillis;
        public Request request;
        public long sentRequestAtMillis;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private void checkPriorResponse(Response response) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65538, this, response) == null) && response.body != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
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

        public Builder body(@Nullable ResponseBody responseBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseBody)) == null) {
                this.body = responseBody;
                return this;
            }
            return (Builder) invokeL.objValue;
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

        public Builder code(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.code = i2;
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

        public Builder header(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
                this.headers.set(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
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

        public Builder receivedResponseAtMillis(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
                this.receivedResponseAtMillis = j2;
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

        public Builder sentRequestAtMillis(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j2)) == null) {
                this.sentRequestAtMillis = j2;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder(Response response) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {response};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    }
}
