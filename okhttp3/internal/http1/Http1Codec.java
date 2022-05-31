package okhttp3.internal.http1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes8.dex */
public final class Http1Codec implements HttpCodec {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_LIMIT = 262144;
    public static final int STATE_CLOSED = 6;
    public static final int STATE_IDLE = 0;
    public static final int STATE_OPEN_REQUEST_BODY = 1;
    public static final int STATE_OPEN_RESPONSE_BODY = 4;
    public static final int STATE_READING_RESPONSE_BODY = 5;
    public static final int STATE_READ_RESPONSE_HEADERS = 3;
    public static final int STATE_WRITING_REQUEST_BODY = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient client;
    public long headerLimit;
    public final BufferedSink sink;
    public final BufferedSource source;
    public int state;
    public final StreamAllocation streamAllocation;

    /* renamed from: okhttp3.internal.http1.Http1Codec$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public final class ChunkedSink implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean closed;
        public final /* synthetic */ Http1Codec this$0;
        public final ForwardingTimeout timeout;

        public ChunkedSink(Http1Codec http1Codec) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http1Codec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http1Codec;
            this.timeout = new ForwardingTimeout(this.this$0.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    this.this$0.sink.writeUtf8("0\r\n\r\n");
                    this.this$0.detachTimeout(this.timeout);
                    this.this$0.state = 3;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this) {
                    if (this.closed) {
                        return;
                    }
                    this.this$0.sink.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.timeout : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                if (this.closed) {
                    throw new IllegalStateException("closed");
                }
                if (j == 0) {
                    return;
                }
                this.this$0.sink.writeHexadecimalUnsignedLong(j);
                this.this$0.sink.writeUtf8("\r\n");
                this.this$0.sink.write(buffer, j);
                this.this$0.sink.writeUtf8("\r\n");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class ChunkedSource extends AbstractSource {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long NO_CHUNK_YET = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public long bytesRemainingInChunk;
        public boolean hasMoreChunks;
        public final /* synthetic */ Http1Codec this$0;
        public final HttpUrl url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1Codec http1Codec, HttpUrl httpUrl) {
            super(http1Codec, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http1Codec, httpUrl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Http1Codec) objArr2[0], (AnonymousClass1) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http1Codec;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.url = httpUrl;
        }

        private void readChunkSize() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                if (this.bytesRemainingInChunk != -1) {
                    this.this$0.source.readUtf8LineStrict();
                }
                try {
                    this.bytesRemainingInChunk = this.this$0.source.readHexadecimalUnsignedLong();
                    String trim = this.this$0.source.readUtf8LineStrict().trim();
                    if (this.bytesRemainingInChunk >= 0 && (trim.isEmpty() || trim.startsWith(ParamableElem.DIVIDE_PARAM))) {
                        if (this.bytesRemainingInChunk == 0) {
                            this.hasMoreChunks = false;
                            HttpHeaders.receiveHeaders(this.this$0.client.cookieJar(), this.url, this.this$0.readHeaders());
                            endOfInput(true, null);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
                } catch (NumberFormatException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.closed) {
                        if (this.hasMoreChunks) {
                            long j2 = this.bytesRemainingInChunk;
                            if (j2 == 0 || j2 == -1) {
                                readChunkSize();
                                if (!this.hasMoreChunks) {
                                    return -1L;
                                }
                            }
                            long read = super.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                            if (read != -1) {
                                this.bytesRemainingInChunk -= read;
                                return read;
                            }
                            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                            endOfInput(false, protocolException);
                            throw protocolException;
                        }
                        return -1L;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class FixedLengthSink implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long bytesRemaining;
        public boolean closed;
        public final /* synthetic */ Http1Codec this$0;
        public final ForwardingTimeout timeout;

        public FixedLengthSink(Http1Codec http1Codec, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http1Codec, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http1Codec;
            this.timeout = new ForwardingTimeout(this.this$0.sink.timeout());
            this.bytesRemaining = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining <= 0) {
                this.this$0.detachTimeout(this.timeout);
                this.this$0.state = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.timeout : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                if (!this.closed) {
                    Util.checkOffsetAndCount(buffer.size(), 0L, j);
                    if (j <= this.bytesRemaining) {
                        this.this$0.sink.write(buffer, j);
                        this.bytesRemaining -= j;
                        return;
                    }
                    throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
                }
                throw new IllegalStateException("closed");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class FixedLengthSource extends AbstractSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long bytesRemaining;
        public final /* synthetic */ Http1Codec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1Codec http1Codec, long j) throws IOException {
            super(http1Codec, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http1Codec, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Http1Codec) objArr2[0], (AnonymousClass1) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http1Codec;
            this.bytesRemaining = j;
            if (j == 0) {
                endOfInput(true, null);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.closed) {
                        long j2 = this.bytesRemaining;
                        if (j2 == 0) {
                            return -1L;
                        }
                        long read = super.read(buffer, Math.min(j2, j));
                        if (read != -1) {
                            long j3 = this.bytesRemaining - read;
                            this.bytesRemaining = j3;
                            if (j3 == 0) {
                                endOfInput(true, null);
                            }
                            return read;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        endOfInput(false, protocolException);
                        throw protocolException;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }
    }

    /* loaded from: classes8.dex */
    public class UnknownLengthSource extends AbstractSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean inputExhausted;
        public final /* synthetic */ Http1Codec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(Http1Codec http1Codec) {
            super(http1Codec, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http1Codec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Http1Codec) objArr2[0], (AnonymousClass1) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http1Codec;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                endOfInput(false, null);
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j >= 0) {
                    if (!this.closed) {
                        if (this.inputExhausted) {
                            return -1L;
                        }
                        long read = super.read(buffer, j);
                        if (read == -1) {
                            this.inputExhausted = true;
                            endOfInput(true, null);
                            return -1L;
                        }
                        return read;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient, streamAllocation, bufferedSource, bufferedSink};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = 0;
        this.headerLimit = 262144L;
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    private String readHeaderLine() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
            this.headerLimit -= readUtf8LineStrict.length();
            return readUtf8LineStrict;
        }
        return (String) invokeV.objValue;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        RealConnection connection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (connection = this.streamAllocation.connection()) == null) {
            return;
        }
        connection.cancel();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request request, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, j)) == null) {
            if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
                return newChunkedSink();
            }
            if (j != -1) {
                return newFixedLengthSink(j);
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        return (Sink) invokeLJ.objValue;
    }

    public void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forwardingTimeout) == null) {
            Timeout delegate = forwardingTimeout.delegate();
            forwardingTimeout.setDelegate(Timeout.NONE);
            delegate.clearDeadline();
            delegate.clearTimeout();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.sink.flush();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.sink.flush();
        }
    }

    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.state == 6 : invokeV.booleanValue;
    }

    public Sink newChunkedSink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.state == 1) {
                this.state = 2;
                return new ChunkedSink(this);
            }
            throw new IllegalStateException("state: " + this.state);
        }
        return (Sink) invokeV.objValue;
    }

    public Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, httpUrl)) == null) {
            if (this.state == 4) {
                this.state = 5;
                return new ChunkedSource(this, httpUrl);
            }
            throw new IllegalStateException("state: " + this.state);
        }
        return (Source) invokeL.objValue;
    }

    public Sink newFixedLengthSink(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            if (this.state == 1) {
                this.state = 2;
                return new FixedLengthSink(this, j);
            }
            throw new IllegalStateException("state: " + this.state);
        }
        return (Sink) invokeJ.objValue;
    }

    public Source newFixedLengthSource(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (this.state == 4) {
                this.state = 5;
                return new FixedLengthSource(this, j);
            }
            throw new IllegalStateException("state: " + this.state);
        }
        return (Source) invokeJ.objValue;
    }

    public Source newUnknownLengthSource() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.state == 4) {
                StreamAllocation streamAllocation = this.streamAllocation;
                if (streamAllocation != null) {
                    this.state = 5;
                    streamAllocation.noNewStreams();
                    return new UnknownLengthSource(this);
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            throw new IllegalStateException("state: " + this.state);
        }
        return (Source) invokeV.objValue;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, response)) == null) {
            StreamAllocation streamAllocation = this.streamAllocation;
            streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
            String header = response.header("Content-Type");
            if (!HttpHeaders.hasBody(response)) {
                return new RealResponseBody(header, 0L, Okio.buffer(newFixedLengthSource(0L)));
            }
            if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
                return new RealResponseBody(header, -1L, Okio.buffer(newChunkedSource(response.request().url())));
            }
            long contentLength = HttpHeaders.contentLength(response);
            if (contentLength != -1) {
                return new RealResponseBody(header, contentLength, Okio.buffer(newFixedLengthSource(contentLength)));
            }
            return new RealResponseBody(header, -1L, Okio.buffer(newUnknownLengthSource()));
        }
        return (ResponseBody) invokeL.objValue;
    }

    public Headers readHeaders() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048588, this)) != null) {
            return (Headers) invokeV.objValue;
        }
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() != 0) {
                Internal.instance.addLenient(builder, readHeaderLine);
            } else {
                return builder.build();
            }
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            int i = this.state;
            if (i != 1 && i != 3) {
                throw new IllegalStateException("state: " + this.state);
            }
            try {
                StatusLine parse = StatusLine.parse(readHeaderLine());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.state = 3;
                    return headers;
                }
                this.state = 4;
                return headers;
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
                iOException.initCause(e);
                throw iOException;
            }
        }
        return (Response.Builder) invokeZ.objValue;
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, headers, str) == null) {
            if (this.state == 0) {
                this.sink.writeUtf8(str).writeUtf8("\r\n");
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
                }
                this.sink.writeUtf8("\r\n");
                this.state = 1;
                return;
            }
            throw new IllegalStateException("state: " + this.state);
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, request) == null) {
            writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
        }
    }

    /* loaded from: classes8.dex */
    public abstract class AbstractSource implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long bytesRead;
        public boolean closed;
        public final /* synthetic */ Http1Codec this$0;
        public final ForwardingTimeout timeout;

        public AbstractSource(Http1Codec http1Codec) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http1Codec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http1Codec;
            this.timeout = new ForwardingTimeout(this.this$0.source.timeout());
            this.bytesRead = 0L;
        }

        public final void endOfInput(boolean z, IOException iOException) throws IOException {
            Http1Codec http1Codec;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, iOException) == null) || (i = (http1Codec = this.this$0).state) == 6) {
                return;
            }
            if (i == 5) {
                http1Codec.detachTimeout(this.timeout);
                Http1Codec http1Codec2 = this.this$0;
                http1Codec2.state = 6;
                StreamAllocation streamAllocation = http1Codec2.streamAllocation;
                if (streamAllocation != null) {
                    streamAllocation.streamFinished(!z, http1Codec2, this.bytesRead, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + this.this$0.state);
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                try {
                    long read = this.this$0.source.read(buffer, j);
                    if (read > 0) {
                        this.bytesRead += read;
                    }
                    return read;
                } catch (IOException e) {
                    endOfInput(false, e);
                    throw e;
                }
            }
            return invokeLJ.longValue;
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.timeout : (Timeout) invokeV.objValue;
        }

        public /* synthetic */ AbstractSource(Http1Codec http1Codec, AnonymousClass1 anonymousClass1) {
            this(http1Codec);
        }
    }
}
