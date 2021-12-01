package okhttp3.internal.http2;

import android.net.http.Headers;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
/* loaded from: classes3.dex */
public final class Http2Codec implements HttpCodec {
    public static /* synthetic */ Interceptable $ic;
    public static final ByteString CONNECTION;
    public static final ByteString ENCODING;
    public static final ByteString HOST;
    public static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS;
    public static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS;
    public static final ByteString KEEP_ALIVE;
    public static final ByteString PROXY_CONNECTION;
    public static final ByteString TE;
    public static final ByteString TRANSFER_ENCODING;
    public static final ByteString UPGRADE;
    public transient /* synthetic */ FieldHolder $fh;
    public final Interceptor.Chain chain;
    public final Http2Connection connection;
    public final Protocol protocol;
    public Http2Stream stream;
    public final StreamAllocation streamAllocation;

    /* loaded from: classes3.dex */
    public class StreamFinishingSource extends ForwardingSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long bytesRead;
        public boolean completed;
        public final /* synthetic */ Http2Codec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StreamFinishingSource(Http2Codec http2Codec, Source source) {
            super(source);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http2Codec, source};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Source) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http2Codec;
            this.completed = false;
            this.bytesRead = 0L;
        }

        private void endOfInput(IOException iOException) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, iOException) == null) || this.completed) {
                return;
            }
            this.completed = true;
            Http2Codec http2Codec = this.this$0;
            http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.close();
                endOfInput(null);
            }
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j2)) == null) {
                try {
                    long read = delegate().read(buffer, j2);
                    if (read > 0) {
                        this.bytesRead += read;
                    }
                    return read;
                } catch (IOException e2) {
                    endOfInput(e2);
                    throw e2;
                }
            }
            return invokeLJ.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-922806684, "Lokhttp3/internal/http2/Http2Codec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-922806684, "Lokhttp3/internal/http2/Http2Codec;");
                return;
            }
        }
        CONNECTION = ByteString.encodeUtf8("connection");
        HOST = ByteString.encodeUtf8("host");
        KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
        PROXY_CONNECTION = ByteString.encodeUtf8(Headers.PROXY_CONNECTION);
        TRANSFER_ENCODING = ByteString.encodeUtf8(Headers.TRANSFER_ENCODING);
        TE = ByteString.encodeUtf8("te");
        ENCODING = ByteString.encodeUtf8("encoding");
        ByteString encodeUtf8 = ByteString.encodeUtf8("upgrade");
        UPGRADE = encodeUtf8;
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, encodeUtf8, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY);
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        Protocol protocol;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient, chain, streamAllocation, http2Connection};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.chain = chain;
        this.streamAllocation = streamAllocation;
        this.connection = http2Connection;
        if (okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.protocol = protocol;
    }

    public static List<Header> http2HeadersList(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, request)) == null) {
            okhttp3.Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
            arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
            String header = request.header("Host");
            if (header != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i2).toLowerCase(Locale.US));
                if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                    arrayList.add(new Header(encodeUtf8, headers.value(i2)));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Response.Builder readHttp2HeadersList(List<Header> list, Protocol protocol) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, protocol)) == null) {
            Headers.Builder builder = new Headers.Builder();
            int size = list.size();
            StatusLine statusLine = null;
            for (int i2 = 0; i2 < size; i2++) {
                Header header = list.get(i2);
                if (header == null) {
                    if (statusLine != null && statusLine.code == 100) {
                        builder = new Headers.Builder();
                        statusLine = null;
                    }
                } else {
                    ByteString byteString = header.name;
                    String utf8 = header.value.utf8();
                    if (byteString.equals(Header.RESPONSE_STATUS)) {
                        statusLine = StatusLine.parse("HTTP/1.1 " + utf8);
                    } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                        Internal.instance.addLenient(builder, byteString.utf8(), utf8);
                    }
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
        return (Response.Builder) invokeLL.objValue;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        Http2Stream http2Stream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (http2Stream = this.stream) == null) {
            return;
        }
        http2Stream.closeLater(ErrorCode.CANCEL);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request request, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, j2)) == null) ? this.stream.getSink() : (Sink) invokeLJ.objValue;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.stream.getSink().close();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.connection.flush();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, response)) == null) {
            StreamAllocation streamAllocation = this.streamAllocation;
            streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
            return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), Okio.buffer(new StreamFinishingSource(this, this.stream.getSource())));
        }
        return (ResponseBody) invokeL.objValue;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeResponseHeaders(), this.protocol);
            if (z && Internal.instance.code(readHttp2HeadersList) == 100) {
                return null;
            }
            return readHttp2HeadersList;
        }
        return (Response.Builder) invokeZ.objValue;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, request) == null) && this.stream == null) {
            Http2Stream newStream = this.connection.newStream(http2HeadersList(request), request.body() != null);
            this.stream = newStream;
            newStream.readTimeout().timeout(this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }
}
