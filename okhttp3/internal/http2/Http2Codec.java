package okhttp3.internal.http2;

import android.net.http.Headers;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
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
/* loaded from: classes7.dex */
public final class Http2Codec implements HttpCodec {
    public static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS;
    public static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS;
    public static final ByteString UPGRADE;
    public final Interceptor.Chain chain;
    public final Http2Connection connection;
    public final Protocol protocol;
    public Http2Stream stream;
    public final StreamAllocation streamAllocation;
    public static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
    public static final ByteString HOST = ByteString.encodeUtf8("host");
    public static final ByteString KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
    public static final ByteString PROXY_CONNECTION = ByteString.encodeUtf8(Headers.PROXY_CONNECTION);
    public static final ByteString TRANSFER_ENCODING = ByteString.encodeUtf8(Headers.TRANSFER_ENCODING);
    public static final ByteString TE = ByteString.encodeUtf8("te");
    public static final ByteString ENCODING = ByteString.encodeUtf8("encoding");

    /* loaded from: classes7.dex */
    public class StreamFinishingSource extends ForwardingSource {
        public long bytesRead;
        public boolean completed;

        public StreamFinishingSource(Source source) {
            super(source);
            this.completed = false;
            this.bytesRead = 0L;
        }

        private void endOfInput(IOException iOException) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            Http2Codec http2Codec = Http2Codec.this;
            http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            endOfInput(null);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = delegate().read(buffer, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e2) {
                endOfInput(e2);
                throw e2;
            }
        }
    }

    static {
        ByteString encodeUtf8 = ByteString.encodeUtf8(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
        UPGRADE = encodeUtf8;
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, encodeUtf8, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY);
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        Protocol protocol;
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

    public static Response.Builder readHttp2HeadersList(List<Header> list, Protocol protocol) throws IOException {
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

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation = this.streamAllocation;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), Okio.buffer(new StreamFinishingSource(this.stream.getSource())));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeResponseHeaders(), this.protocol);
        if (z && Internal.instance.code(readHttp2HeadersList) == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream != null) {
            return;
        }
        Http2Stream newStream = this.connection.newStream(http2HeadersList(request), request.body() != null);
        this.stream = newStream;
        newStream.readTimeout().timeout(this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    }
}
