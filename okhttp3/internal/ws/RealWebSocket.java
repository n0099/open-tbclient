package okhttp3.internal.ws;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.apache.http.protocol.HTTP;
/* loaded from: classes8.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long MAX_QUEUE_SIZE = 16777216;
    public static final List<Protocol> ONLY_HTTP1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean awaitingPong;
    public Call call;
    public ScheduledFuture<?> cancelFuture;
    public boolean enqueuedClose;
    public ScheduledExecutorService executor;
    public boolean failed;
    public final String key;
    public final WebSocketListener listener;
    public final ArrayDeque<Object> messageAndCloseQueue;
    public final Request originalRequest;
    public final long pingIntervalMillis;
    public final ArrayDeque<ByteString> pongQueue;
    public long queueSize;
    public final Random random;
    public WebSocketReader reader;
    public int receivedCloseCode;
    public String receivedCloseReason;
    public int receivedPingCount;
    public int receivedPongCount;
    public int sentPingCount;
    public Streams streams;
    public WebSocketWriter writer;
    public final Runnable writerRunnable;

    /* loaded from: classes8.dex */
    public final class CancelRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RealWebSocket this$0;

        public CancelRunnable(RealWebSocket realWebSocket) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {realWebSocket};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = realWebSocket;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class Close {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long cancelAfterCloseMillis;
        public final int code;
        public final ByteString reason;

        public Close(int i, ByteString byteString, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), byteString, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    /* loaded from: classes8.dex */
    public static final class Message {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteString data;
        public final int formatOpcode;

        public Message(int i, ByteString byteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), byteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    /* loaded from: classes8.dex */
    public final class PingRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RealWebSocket this$0;

        public PingRunnable(RealWebSocket realWebSocket) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {realWebSocket};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = realWebSocket;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.writePingFrame();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class Streams implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), bufferedSource, bufferedSink};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-139599521, "Lokhttp3/internal/ws/RealWebSocket;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-139599521, "Lokhttp3/internal/ws/RealWebSocket;");
                return;
            }
        }
        ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {request, webSocketListener, random, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if ("GET".equals(request.method())) {
            this.originalRequest = request;
            this.listener = webSocketListener;
            this.random = random;
            this.pingIntervalMillis = j;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.key = ByteString.of(bArr).base64();
            this.writerRunnable = new Runnable(this) { // from class: okhttp3.internal.ws.RealWebSocket.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RealWebSocket this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        do {
                            try {
                            } catch (IOException e2) {
                                this.this$0.failWebSocket(e2, null);
                                return;
                            }
                        } while (this.this$0.writeOneFrame());
                    }
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (scheduledExecutorService = this.executor) == null) {
            return;
        }
        scheduledExecutorService.execute(this.writerRunnable);
    }

    public void awaitTermination(int i, TimeUnit timeUnit) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, timeUnit) == null) {
            this.executor.awaitTermination(i, timeUnit);
        }
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.call.cancel();
        }
    }

    public void checkResponse(Response response) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, response) == null) {
            if (response.code() == 101) {
                String header = response.header(HTTP.CONN_DIRECTIVE);
                if ("Upgrade".equalsIgnoreCase(header)) {
                    String header2 = response.header("Upgrade");
                    if ("websocket".equalsIgnoreCase(header2)) {
                        String header3 = response.header("Sec-WebSocket-Accept");
                        String base64 = ByteString.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                        if (base64.equals(header3)) {
                            return;
                        }
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
                    }
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
                }
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
            }
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, str)) == null) ? close(i, str, 60000L) : invokeIL.booleanValue;
    }

    public void connect(OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, okHttpClient) == null) {
            OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
            Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header(HTTP.CONN_DIRECTIVE, "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
            Call newWebSocketCall = Internal.instance.newWebSocketCall(build, build2);
            this.call = newWebSocketCall;
            newWebSocketCall.enqueue(new Callback(this, build2) { // from class: okhttp3.internal.ws.RealWebSocket.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RealWebSocket this$0;
                public final /* synthetic */ Request val$request;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, build2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$request = build2;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                        this.this$0.failWebSocket(iOException, null);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                        try {
                            this.this$0.checkResponse(response);
                            StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                            streamAllocation.noNewStreams();
                            Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                            try {
                                this.this$0.listener.onOpen(this.this$0, response);
                                this.this$0.initReaderAndWriter("OkHttp WebSocket " + this.val$request.url().redact(), newWebSocketStreams);
                                streamAllocation.connection().socket().setSoTimeout(0);
                                this.this$0.loopReader();
                            } catch (Exception e2) {
                                this.this$0.failWebSocket(e2, null);
                            }
                        } catch (ProtocolException e3) {
                            this.this$0.failWebSocket(e3, response);
                            Util.closeQuietly(response);
                        }
                    }
                }
            });
        }
    }

    public void failWebSocket(Exception exc, @Nullable Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, exc, response) == null) {
            synchronized (this) {
                if (this.failed) {
                    return;
                }
                this.failed = true;
                Streams streams = this.streams;
                this.streams = null;
                if (this.cancelFuture != null) {
                    this.cancelFuture.cancel(false);
                }
                if (this.executor != null) {
                    this.executor.shutdown();
                }
                try {
                    this.listener.onFailure(this, exc, response);
                } finally {
                    Util.closeQuietly(streams);
                }
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, streams) == null) {
            synchronized (this) {
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
                this.executor = scheduledThreadPoolExecutor;
                if (this.pingIntervalMillis != 0) {
                    scheduledThreadPoolExecutor.scheduleAtFixedRate(new PingRunnable(this), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
            }
            this.reader = new WebSocketReader(streams.client, streams.source, this);
        }
    }

    public void loopReader() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            while (this.receivedCloseCode == -1) {
                this.reader.processNextFrame();
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        Streams streams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
            if (i != -1) {
                synchronized (this) {
                    if (this.receivedCloseCode == -1) {
                        this.receivedCloseCode = i;
                        this.receivedCloseReason = str;
                        streams = null;
                        if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                            Streams streams2 = this.streams;
                            this.streams = null;
                            if (this.cancelFuture != null) {
                                this.cancelFuture.cancel(false);
                            }
                            this.executor.shutdown();
                            streams = streams2;
                        }
                    } else {
                        throw new IllegalStateException("already closed");
                    }
                }
                try {
                    this.listener.onClosing(this, i, str);
                    if (streams != null) {
                        this.listener.onClosed(this, i, str);
                    }
                    return;
                } finally {
                    Util.closeQuietly(streams);
                }
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.listener.onMessage(this, str);
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, byteString) == null) {
            synchronized (this) {
                if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                    this.pongQueue.add(byteString);
                    runWriter();
                    this.receivedPingCount++;
                }
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, byteString) == null) {
            synchronized (this) {
                this.receivedPongCount++;
                this.awaitingPong = false;
            }
        }
    }

    public synchronized boolean pong(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, byteString)) == null) {
            synchronized (this) {
                if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                    this.pongQueue.add(byteString);
                    runWriter();
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean processNextFrame() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                this.reader.processNextFrame();
                return this.receivedCloseCode == -1;
            } catch (Exception e2) {
                failWebSocket(e2, null);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                j = this.queueSize;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public synchronized int receivedPingCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this) {
                i = this.receivedPingCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int receivedPongCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                i = this.receivedPongCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.originalRequest : (Request) invokeV.objValue;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (str != null) {
                return send(ByteString.encodeUtf8(str), 1);
            }
            throw new NullPointerException("text == null");
        }
        return invokeL.booleanValue;
    }

    public synchronized int sentPingCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                i = this.sentPingCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void tearDown() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ScheduledFuture<?> scheduledFuture = this.cancelFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.executor.shutdown();
            this.executor.awaitTermination(10L, TimeUnit.SECONDS);
        }
    }

    public boolean writeOneFrame() throws IOException {
        InterceptResult invokeV;
        Streams streams;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            synchronized (this) {
                if (this.failed) {
                    return false;
                }
                WebSocketWriter webSocketWriter = this.writer;
                ByteString poll = this.pongQueue.poll();
                int i = -1;
                Message message = null;
                if (poll == null) {
                    Object poll2 = this.messageAndCloseQueue.poll();
                    if (poll2 instanceof Close) {
                        int i2 = this.receivedCloseCode;
                        str = this.receivedCloseReason;
                        if (i2 != -1) {
                            Streams streams2 = this.streams;
                            this.streams = null;
                            this.executor.shutdown();
                            message = poll2;
                            i = i2;
                            streams = streams2;
                        } else {
                            this.cancelFuture = this.executor.schedule(new CancelRunnable(this), ((Close) poll2).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                            i = i2;
                            streams = null;
                        }
                    } else if (poll2 == null) {
                        return false;
                    } else {
                        streams = null;
                        str = null;
                    }
                    message = poll2;
                } else {
                    streams = null;
                    str = null;
                }
                try {
                    if (poll != null) {
                        webSocketWriter.writePong(poll);
                    } else if (message instanceof Message) {
                        ByteString byteString = message.data;
                        BufferedSink buffer = Okio.buffer(webSocketWriter.newMessageSink(message.formatOpcode, byteString.size()));
                        buffer.write(byteString);
                        buffer.close();
                        synchronized (this) {
                            this.queueSize -= byteString.size();
                        }
                    } else if (message instanceof Close) {
                        Close close = (Close) message;
                        webSocketWriter.writeClose(close.code, close.reason);
                        if (streams != null) {
                            this.listener.onClosed(this, i, str);
                        }
                    } else {
                        throw new AssertionError();
                    }
                    return true;
                } finally {
                    Util.closeQuietly(streams);
                }
            }
        }
        return invokeV.booleanValue;
    }

    public void writePingFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                int i = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                if (i != -1) {
                    failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
                    return;
                }
                try {
                    webSocketWriter.writePing(ByteString.EMPTY);
                } catch (IOException e2) {
                    failWebSocket(e2, null);
                }
            }
        }
    }

    public synchronized boolean close(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            synchronized (this) {
                WebSocketProtocol.validateCloseCode(i);
                ByteString byteString = null;
                if (str != null) {
                    byteString = ByteString.encodeUtf8(str);
                    if (byteString.size() > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: " + str);
                    }
                }
                if (!this.failed && !this.enqueuedClose) {
                    this.enqueuedClose = true;
                    this.messageAndCloseQueue.add(new Close(i, byteString, j));
                    runWriter();
                    return true;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, byteString) == null) {
            this.listener.onMessage(this, byteString);
        }
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, byteString)) == null) {
            if (byteString != null) {
                return send(byteString, 2);
            }
            throw new NullPointerException("bytes == null");
        }
        return invokeL.booleanValue;
    }

    private synchronized boolean send(ByteString byteString, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, byteString, i)) == null) {
            synchronized (this) {
                if (!this.failed && !this.enqueuedClose) {
                    if (this.queueSize + byteString.size() > 16777216) {
                        close(1001, null);
                        return false;
                    }
                    this.queueSize += byteString.size();
                    this.messageAndCloseQueue.add(new Message(i, byteString));
                    runWriter();
                    return true;
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }
}
