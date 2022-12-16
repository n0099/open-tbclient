package okhttp3.internal.http2;

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
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
/* loaded from: classes9.dex */
public final class Http2Connection implements Closeable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AWAIT_PING = 3;
    public static final int DEGRADED_PING = 2;
    public static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    public static final ExecutorService listenerExecutor;
    public transient /* synthetic */ FieldHolder $fh;
    public long awaitPingsSent;
    public long awaitPongsReceived;
    public long bytesLeftInWriteWindow;
    public final boolean client;
    public final Set<Integer> currentPushRequests;
    public long degradedPingsSent;
    public long degradedPongDeadlineNs;
    public long degradedPongsReceived;
    public final String hostname;
    public long intervalPingsSent;
    public long intervalPongsReceived;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public Settings okHttpSettings;
    public final Settings peerSettings;
    public final ExecutorService pushExecutor;
    public final PushObserver pushObserver;
    public final ReaderRunnable readerRunnable;
    public boolean shutdown;
    public final Socket socket;
    public final Map<Integer, Http2Stream> streams;
    public long unacknowledgedBytesRead;
    public final Http2Writer writer;
    public final ScheduledExecutorService writerExecutor;

    public boolean pushedStream(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? i != 0 && (i & 1) == 0 : invokeI.booleanValue;
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean client;
        public String hostname;
        public Listener listener;
        public int pingIntervalMillis;
        public PushObserver pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;

        public Builder(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
            this.client = z;
        }

        public Http2Connection build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Http2Connection(this);
            }
            return (Http2Connection) invokeV.objValue;
        }

        public Builder listener(Listener listener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listener)) == null) {
                this.listener = listener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder pingIntervalMillis(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.pingIntervalMillis = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pushObserver)) == null) {
                this.pushObserver = pushObserver;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder socket(Socket socket) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, socket)) == null) {
                return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
            }
            return (Builder) invokeL.objValue;
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, socket, str, bufferedSource, bufferedSink)) == null) {
                this.socket = socket;
                this.hostname = str;
                this.source = bufferedSource;
                this.sink = bufferedSink;
                return this;
            }
            return (Builder) invokeLLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class IntervalPingRunnable extends NamedRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Http2Connection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntervalPingRunnable(Http2Connection http2Connection) {
            super("OkHttp %s ping", http2Connection.hostname);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http2Connection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http2Connection;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0) {
                    if (this.this$0.intervalPongsReceived < this.this$0.intervalPingsSent) {
                        z = true;
                    } else {
                        Http2Connection.access$208(this.this$0);
                        z = false;
                    }
                }
                if (!z) {
                    this.this$0.writePing(false, 1, 0);
                } else {
                    this.this$0.failConnection();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class Listener {
        public static /* synthetic */ Interceptable $ic;
        public static final Listener REFUSE_INCOMING_STREAMS;
        public transient /* synthetic */ FieldHolder $fh;

        public void onSettings(Http2Connection http2Connection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, http2Connection) == null) {
            }
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-363301664, "Lokhttp3/internal/http2/Http2Connection$Listener;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-363301664, "Lokhttp3/internal/http2/Http2Connection$Listener;");
                    return;
                }
            }
            REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection.Listener.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // okhttp3.internal.http2.Http2Connection.Listener
                public void onStream(Http2Stream http2Stream) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, http2Stream) == null) {
                        http2Stream.close(ErrorCode.REFUSED_STREAM);
                    }
                }
            };
        }

        public Listener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class PingRunnable extends NamedRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int payload1;
        public final int payload2;
        public final boolean reply;
        public final /* synthetic */ Http2Connection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PingRunnable(Http2Connection http2Connection, boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", http2Connection.hostname, Integer.valueOf(i), Integer.valueOf(i2));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http2Connection, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http2Connection;
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.writePing(this.reply, this.payload1, this.payload2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Http2Reader reader;
        public final /* synthetic */ Http2Connection this$0;

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, byteString, str2, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            super("OkHttp %s", http2Connection.hostname);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http2Connection, http2Reader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (i == 0) {
                    synchronized (this.this$0) {
                        this.this$0.bytesLeftInWriteWindow += j;
                        this.this$0.notifyAll();
                    }
                    return;
                }
                Http2Stream stream = this.this$0.getStream(i);
                if (stream != null) {
                    synchronized (stream) {
                        stream.addBytesToWriteWindow(j);
                    }
                }
            }
        }

        public void applyAndAckSettings(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, settings) == null) {
                synchronized (this.this$0.writer) {
                    synchronized (this.this$0) {
                        int initialWindowSize = this.this$0.peerSettings.getInitialWindowSize();
                        if (z) {
                            this.this$0.peerSettings.clear();
                        }
                        this.this$0.peerSettings.merge(settings);
                        int initialWindowSize2 = this.this$0.peerSettings.getInitialWindowSize();
                        http2StreamArr = null;
                        if (initialWindowSize2 != -1 && initialWindowSize2 != initialWindowSize) {
                            j = initialWindowSize2 - initialWindowSize;
                            if (!this.this$0.streams.isEmpty()) {
                                http2StreamArr = (Http2Stream[]) this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);
                            }
                        } else {
                            j = 0;
                        }
                    }
                    try {
                        this.this$0.writer.applyAndAckSettings(this.this$0.peerSettings);
                    } catch (IOException unused) {
                        this.this$0.failConnection();
                    }
                }
                if (http2StreamArr != null) {
                    for (Http2Stream http2Stream : http2StreamArr) {
                        synchronized (http2Stream) {
                            http2Stream.addBytesToWriteWindow(j);
                        }
                    }
                }
                Http2Connection.listenerExecutor.execute(new NamedRunnable(this, "OkHttp %s settings", this.this$0.hostname) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ReaderRunnable this$1;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], (Object[]) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Http2Connection http2Connection = this.this$1.this$0;
                            http2Connection.listener.onSettings(http2Connection);
                        }
                    }
                });
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), bufferedSource, Integer.valueOf(i2)}) == null) {
                if (this.this$0.pushedStream(i)) {
                    this.this$0.pushDataLater(i, bufferedSource, i2, z);
                    return;
                }
                Http2Stream stream = this.this$0.getStream(i);
                if (stream == null) {
                    this.this$0.writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                    long j = i2;
                    this.this$0.updateConnectionFlowControl(j);
                    bufferedSource.skip(j);
                    return;
                }
                stream.receiveData(bufferedSource, i2);
                if (z) {
                    stream.receiveFin();
                }
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            Http2Connection http2Connection;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
                try {
                    try {
                        this.reader.readConnectionPreface(this);
                        while (this.reader.nextFrame(false, this)) {
                        }
                        errorCode = ErrorCode.NO_ERROR;
                        try {
                            try {
                                errorCode2 = ErrorCode.CANCEL;
                                http2Connection = this.this$0;
                            } catch (IOException unused) {
                                errorCode = ErrorCode.PROTOCOL_ERROR;
                                errorCode2 = ErrorCode.PROTOCOL_ERROR;
                                http2Connection = this.this$0;
                                http2Connection.close(errorCode, errorCode2);
                                Util.closeQuietly(this.reader);
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                this.this$0.close(errorCode, errorCode3);
                            } catch (IOException unused2) {
                            }
                            Util.closeQuietly(this.reader);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode3;
                    this.this$0.close(errorCode, errorCode3);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
                http2Connection.close(errorCode, errorCode2);
                Util.closeQuietly(this.reader);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, errorCode, byteString) == null) {
                byteString.size();
                synchronized (this.this$0) {
                    http2StreamArr = (Http2Stream[]) this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);
                    this.this$0.shutdown = true;
                }
                for (Http2Stream http2Stream : http2StreamArr) {
                    if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                        http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                        this.this$0.removeStream(http2Stream.getId());
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<Header> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), list}) == null) {
                if (this.this$0.pushedStream(i)) {
                    this.this$0.pushHeadersLater(i, list, z);
                    return;
                }
                synchronized (this.this$0) {
                    Http2Stream stream = this.this$0.getStream(i);
                    if (stream == null) {
                        if (this.this$0.shutdown) {
                            return;
                        }
                        if (i <= this.this$0.lastGoodStreamId) {
                            return;
                        }
                        if (i % 2 == this.this$0.nextStreamId % 2) {
                            return;
                        }
                        Http2Stream http2Stream = new Http2Stream(i, this.this$0, false, z, Util.toHeaders(list));
                        this.this$0.lastGoodStreamId = i;
                        this.this$0.streams.put(Integer.valueOf(i), http2Stream);
                        Http2Connection.listenerExecutor.execute(new NamedRunnable(this, "OkHttp %s stream %d", new Object[]{this.this$0.hostname, Integer.valueOf(i)}, http2Stream) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ReaderRunnable this$1;
                            public final /* synthetic */ Http2Stream val$newStream;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r9, r10);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r9, r10, http2Stream};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((String) objArr2[0], (Object[]) objArr2[1]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$newStream = http2Stream;
                            }

                            @Override // okhttp3.internal.NamedRunnable
                            public void execute() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.this$1.this$0.listener.onStream(this.val$newStream);
                                    } catch (IOException e) {
                                        Platform platform = Platform.get();
                                        platform.log(4, "Http2Connection.Listener failure for " + this.this$1.this$0.hostname, e);
                                        try {
                                            this.val$newStream.close(ErrorCode.PROTOCOL_ERROR);
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                            }
                        });
                        return;
                    }
                    stream.receiveHeaders(list);
                    if (z) {
                        stream.receiveFin();
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                if (z) {
                    synchronized (this.this$0) {
                        try {
                            if (i == 1) {
                                Http2Connection.access$108(this.this$0);
                            } else if (i == 2) {
                                Http2Connection.access$608(this.this$0);
                            } else if (i == 3) {
                                Http2Connection.access$708(this.this$0);
                                this.this$0.notifyAll();
                            }
                        } finally {
                        }
                    }
                    return;
                }
                try {
                    this.this$0.writerExecutor.execute(new PingRunnable(this.this$0, true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, list) == null) {
                this.this$0.pushRequestLater(i2, list);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048586, this, i, errorCode) == null) {
                if (this.this$0.pushedStream(i)) {
                    this.this$0.pushResetLater(i, errorCode);
                    return;
                }
                Http2Stream removeStream = this.this$0.removeStream(i);
                if (removeStream != null) {
                    removeStream.receiveRstStream(errorCode);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean z, Settings settings) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048587, this, z, settings) == null) {
                try {
                    this.this$0.writerExecutor.execute(new NamedRunnable(this, "OkHttp %s ACK Settings", new Object[]{this.this$0.hostname}, z, settings) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ReaderRunnable this$1;
                        public final /* synthetic */ boolean val$clearPrevious;
                        public final /* synthetic */ Settings val$settings;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, r10, Boolean.valueOf(z), settings};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], (Object[]) objArr2[1]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$clearPrevious = z;
                            this.val$settings = settings;
                        }

                        @Override // okhttp3.internal.NamedRunnable
                        public void execute() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$1.applyAndAckSettings(this.val$clearPrevious, this.val$settings);
                            }
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1507627262, "Lokhttp3/internal/http2/Http2Connection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1507627262, "Lokhttp3/internal/http2/Http2Connection;");
                return;
            }
        }
        listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    }

    public void sendDegradedPingLater() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                if (this.degradedPongsReceived < this.degradedPingsSent) {
                    return;
                }
                this.degradedPingsSent++;
                this.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
                try {
                    this.writerExecutor.execute(new NamedRunnable(this, "OkHttp %s ping", this.hostname) { // from class: okhttp3.internal.http2.Http2Connection.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Http2Connection this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, r10};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], (Object[]) objArr2[1]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // okhttp3.internal.NamedRunnable
                        public void execute() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.writePing(false, 2, 0);
                            }
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public Http2Connection(Builder builder) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.streams = new LinkedHashMap();
        this.intervalPingsSent = 0L;
        this.intervalPongsReceived = 0L;
        this.degradedPingsSent = 0L;
        this.degradedPongsReceived = 0L;
        this.awaitPingsSent = 0L;
        this.awaitPongsReceived = 0L;
        this.degradedPongDeadlineNs = 0L;
        this.unacknowledgedBytesRead = 0L;
        this.okHttpSettings = new Settings();
        this.peerSettings = new Settings();
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = builder.pushObserver;
        boolean z = builder.client;
        this.client = z;
        this.listener = builder.listener;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        this.nextStreamId = i;
        if (builder.client) {
            this.nextStreamId = i + 2;
        }
        if (builder.client) {
            this.okHttpSettings.set(7, 16777216);
        }
        this.hostname = builder.hostname;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", this.hostname), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder.pingIntervalMillis != 0) {
            IntervalPingRunnable intervalPingRunnable = new IntervalPingRunnable(this);
            int i4 = builder.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, i4, i4, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.hostname), true));
        this.peerSettings.set(7, 65535);
        this.peerSettings.set(5, 16384);
        this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize();
        this.socket = builder.socket;
        this.writer = new Http2Writer(builder.sink, this.client);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.source, this.client));
    }

    public static /* synthetic */ long access$108(Http2Connection http2Connection) {
        long j = http2Connection.intervalPongsReceived;
        http2Connection.intervalPongsReceived = 1 + j;
        return j;
    }

    public static /* synthetic */ long access$208(Http2Connection http2Connection) {
        long j = http2Connection.intervalPingsSent;
        http2Connection.intervalPingsSent = 1 + j;
        return j;
    }

    public static /* synthetic */ long access$608(Http2Connection http2Connection) {
        long j = http2Connection.degradedPongsReceived;
        http2Connection.degradedPongsReceived = 1 + j;
        return j;
    }

    public static /* synthetic */ long access$708(Http2Connection http2Connection) {
        long j = http2Connection.awaitPongsReceived;
        http2Connection.awaitPongsReceived = 1 + j;
        return j;
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, namedRunnable) == null) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.pushExecutor.execute(namedRunnable);
                }
            }
        }
    }

    public synchronized Http2Stream getStream(int i) {
        InterceptResult invokeI;
        Http2Stream http2Stream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            synchronized (this) {
                http2Stream = this.streams.get(Integer.valueOf(i));
            }
            return http2Stream;
        }
        return (Http2Stream) invokeI.objValue;
    }

    public synchronized boolean isHealthy(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            synchronized (this) {
                if (this.shutdown) {
                    return false;
                }
                if (this.degradedPongsReceived < this.degradedPingsSent) {
                    if (j >= this.degradedPongDeadlineNs) {
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeJ.booleanValue;
    }

    public synchronized Http2Stream removeStream(int i) {
        InterceptResult invokeI;
        Http2Stream remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            synchronized (this) {
                remove = this.streams.remove(Integer.valueOf(i));
                notifyAll();
            }
            return remove;
        }
        return (Http2Stream) invokeI.objValue;
    }

    public void setSettings(Settings settings) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, settings) == null) {
            synchronized (this.writer) {
                synchronized (this) {
                    if (!this.shutdown) {
                        this.okHttpSettings.merge(settings);
                    } else {
                        throw new ConnectionShutdownException();
                    }
                }
                this.writer.settings(settings);
            }
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, errorCode) == null) {
            synchronized (this.writer) {
                synchronized (this) {
                    if (this.shutdown) {
                        return;
                    }
                    this.shutdown = true;
                    this.writer.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public synchronized void updateConnectionFlowControl(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            synchronized (this) {
                long j2 = this.unacknowledgedBytesRead + j;
                this.unacknowledgedBytesRead = j2;
                if (j2 >= this.okHttpSettings.getInitialWindowSize() / 2) {
                    writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
                    this.unacknowledgedBytesRead = 0L;
                }
            }
        }
    }

    public Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, z)) == null) {
            return newStream(0, list, z);
        }
        return (Http2Stream) invokeLZ.objValue;
    }

    public void pushResetLater(int i, ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, errorCode) == null) {
            pushExecutorExecute(new NamedRunnable(this, "OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, errorCode) { // from class: okhttp3.internal.http2.Http2Connection.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Http2Connection this$0;
                public final /* synthetic */ ErrorCode val$errorCode;
                public final /* synthetic */ int val$streamId;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10, Integer.valueOf(i), errorCode};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (Object[]) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$streamId = i;
                    this.val$errorCode = errorCode;
                }

                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.pushObserver.onReset(this.val$streamId, this.val$errorCode);
                        synchronized (this.this$0) {
                            this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
                        }
                    }
                }
            });
        }
    }

    public void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i, errorCode) == null) {
            this.writer.rstStream(i, errorCode);
        }
    }

    public void writeSynResetLater(int i, ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i, errorCode) == null) {
            try {
                this.writerExecutor.execute(new NamedRunnable(this, "OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}, i, errorCode) { // from class: okhttp3.internal.http2.Http2Connection.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Http2Connection this$0;
                    public final /* synthetic */ ErrorCode val$errorCode;
                    public final /* synthetic */ int val$streamId;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10, Integer.valueOf(i), errorCode};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], (Object[]) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$streamId = i;
                        this.val$errorCode = errorCode;
                    }

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.this$0.writeSynReset(this.val$streamId, this.val$errorCode);
                            } catch (IOException unused) {
                                this.this$0.failConnection();
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            try {
                close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }

    public synchronized void awaitPong() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                while (this.awaitPongsReceived < this.awaitPingsSent) {
                    wait();
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
        }
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.writer.flush();
        }
    }

    public Protocol getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Protocol.HTTP_2;
        }
        return (Protocol) invokeV.objValue;
    }

    public synchronized int maxConcurrentStreams() {
        InterceptResult invokeV;
        int maxConcurrentStreams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                maxConcurrentStreams = this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
            }
            return maxConcurrentStreams;
        }
        return invokeV.intValue;
    }

    public synchronized int openStreamCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                size = this.streams.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public void start() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            start(true);
        }
    }

    public void writePing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this) {
                this.awaitPingsSent++;
            }
            writePing(false, 3, 1330343787);
        }
    }

    public void writePingAndAwaitPong() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            writePing();
            awaitPong();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047 A[Catch: all -> 0x0079, TryCatch #1 {, blocks: (B:6:0x000a, B:26:0x0053, B:30:0x0062, B:27:0x0059, B:29:0x005d, B:34:0x006b, B:35:0x0072, B:7:0x000b, B:9:0x0012, B:10:0x0017, B:12:0x001b, B:14:0x002f, B:16:0x0037, B:21:0x0041, B:23:0x0047, B:24:0x0050, B:36:0x0073, B:37:0x0078), top: B:48:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Http2Stream newStream(int i, List<Header> list, boolean z) throws IOException {
        InterceptResult invokeCommon;
        int i2;
        Http2Stream http2Stream;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{Integer.valueOf(i), list, Boolean.valueOf(z)})) == null) {
            boolean z3 = !z;
            synchronized (this.writer) {
                synchronized (this) {
                    if (this.nextStreamId > 1073741823) {
                        shutdown(ErrorCode.REFUSED_STREAM);
                    }
                    if (!this.shutdown) {
                        i2 = this.nextStreamId;
                        this.nextStreamId += 2;
                        http2Stream = new Http2Stream(i2, this, z3, false, null);
                        if (z && this.bytesLeftInWriteWindow != 0 && http2Stream.bytesLeftInWriteWindow != 0) {
                            z2 = false;
                            if (http2Stream.isOpen()) {
                                this.streams.put(Integer.valueOf(i2), http2Stream);
                            }
                        }
                        z2 = true;
                        if (http2Stream.isOpen()) {
                        }
                    } else {
                        throw new ConnectionShutdownException();
                    }
                }
                if (i == 0) {
                    this.writer.synStream(z3, i2, i, list);
                } else if (!this.client) {
                    this.writer.pushPromise(i, i2, list);
                } else {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
            }
            if (z2) {
                this.writer.flush();
            }
            return http2Stream;
        }
        return (Http2Stream) invokeCommon.objValue;
    }

    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, errorCode, errorCode2) == null) {
            Http2Stream[] http2StreamArr = null;
            try {
                shutdown(errorCode);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            synchronized (this) {
                if (!this.streams.isEmpty()) {
                    http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                    this.streams.clear();
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    try {
                        http2Stream.close(errorCode2);
                    } catch (IOException e2) {
                        if (e != null) {
                            e = e2;
                        }
                    }
                }
            }
            try {
                this.writer.close();
            } catch (IOException e3) {
                if (e == null) {
                    e = e3;
                }
            }
            try {
                this.socket.close();
            } catch (IOException e4) {
                e = e4;
            }
            this.writerExecutor.shutdown();
            this.pushExecutor.shutdown();
            if (e == null) {
                return;
            }
            throw e;
        }
    }

    public void pushDataLater(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), bufferedSource, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Buffer buffer = new Buffer();
            long j = i2;
            bufferedSource.require(j);
            bufferedSource.read(buffer, j);
            if (buffer.size() == j) {
                pushExecutorExecute(new NamedRunnable(this, "OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, buffer, i2, z) { // from class: okhttp3.internal.http2.Http2Connection.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Http2Connection this$0;
                    public final /* synthetic */ Buffer val$buffer;
                    public final /* synthetic */ int val$byteCount;
                    public final /* synthetic */ boolean val$inFinished;
                    public final /* synthetic */ int val$streamId;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10, Integer.valueOf(i), buffer, Integer.valueOf(i2), Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], (Object[]) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$streamId = i;
                        this.val$buffer = buffer;
                        this.val$byteCount = i2;
                        this.val$inFinished = z;
                    }

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                boolean onData = this.this$0.pushObserver.onData(this.val$streamId, this.val$buffer, this.val$byteCount, this.val$inFinished);
                                if (onData) {
                                    this.this$0.writer.rstStream(this.val$streamId, ErrorCode.CANCEL);
                                }
                                if (onData || this.val$inFinished) {
                                    synchronized (this.this$0) {
                                        this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
                                    }
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
                return;
            }
            throw new IOException(buffer.size() + " != " + i2);
        }
    }

    public void pushHeadersLater(int i, List<Header> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            try {
                pushExecutorExecute(new NamedRunnable(this, "OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, list, z) { // from class: okhttp3.internal.http2.Http2Connection.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Http2Connection this$0;
                    public final /* synthetic */ boolean val$inFinished;
                    public final /* synthetic */ List val$requestHeaders;
                    public final /* synthetic */ int val$streamId;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10, Integer.valueOf(i), list, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], (Object[]) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$streamId = i;
                        this.val$requestHeaders = list;
                        this.val$inFinished = z;
                    }

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            boolean onHeaders = this.this$0.pushObserver.onHeaders(this.val$streamId, this.val$requestHeaders, this.val$inFinished);
                            if (onHeaders) {
                                try {
                                    this.this$0.writer.rstStream(this.val$streamId, ErrorCode.CANCEL);
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            if (onHeaders || this.val$inFinished) {
                                synchronized (this.this$0) {
                                    this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
                                }
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), list, Boolean.valueOf(z)})) == null) {
            if (!this.client) {
                return newStream(i, list, z);
            }
            throw new IllegalStateException("Client cannot push requests.");
        }
        return (Http2Stream) invokeCommon.objValue;
    }

    public void writePing(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            try {
                this.writer.ping(z, i, i2);
            } catch (IOException unused) {
                failConnection();
            }
        }
    }

    public void pushRequestLater(int i, List<Header> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, list) == null) {
            synchronized (this) {
                if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                    writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                this.currentPushRequests.add(Integer.valueOf(i));
                try {
                    pushExecutorExecute(new NamedRunnable(this, "OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, list) { // from class: okhttp3.internal.http2.Http2Connection.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Http2Connection this$0;
                        public final /* synthetic */ List val$requestHeaders;
                        public final /* synthetic */ int val$streamId;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, r10, Integer.valueOf(i), list};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], (Object[]) objArr2[1]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$streamId = i;
                            this.val$requestHeaders = list;
                        }

                        @Override // okhttp3.internal.NamedRunnable
                        public void execute() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.pushObserver.onRequest(this.val$streamId, this.val$requestHeaders)) {
                                try {
                                    this.this$0.writer.rstStream(this.val$streamId, ErrorCode.CANCEL);
                                    synchronized (this.this$0) {
                                        this.this$0.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
                                    }
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }

    public void start(boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                this.writer.connectionPreface();
                this.writer.settings(this.okHttpSettings);
                int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
                if (initialWindowSize != 65535) {
                    this.writer.windowUpdate(0, initialWindowSize - 65535);
                }
            }
            new Thread(this.readerRunnable).start();
        }
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) throws IOException {
        int min;
        long j2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), buffer, Long.valueOf(j)}) == null) {
            if (j == 0) {
                this.writer.data(z, i, buffer, 0);
                return;
            }
            while (j > 0) {
                synchronized (this) {
                    while (this.bytesLeftInWriteWindow <= 0) {
                        try {
                            if (this.streams.containsKey(Integer.valueOf(i))) {
                                wait();
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                    min = Math.min((int) Math.min(j, this.bytesLeftInWriteWindow), this.writer.maxDataLength());
                    j2 = min;
                    this.bytesLeftInWriteWindow -= j2;
                }
                j -= j2;
                Http2Writer http2Writer = this.writer;
                if (z && j == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                http2Writer.data(z2, i, buffer, min);
            }
        }
    }

    public void writeSynReply(int i, boolean z, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), list}) == null) {
            this.writer.synReply(z, i, list);
        }
    }

    public void writeWindowUpdateLater(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            try {
                this.writerExecutor.execute(new NamedRunnable(this, "OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}, i, j) { // from class: okhttp3.internal.http2.Http2Connection.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Http2Connection this$0;
                    public final /* synthetic */ int val$streamId;
                    public final /* synthetic */ long val$unacknowledgedBytesRead;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10, Integer.valueOf(i), Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], (Object[]) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$streamId = i;
                        this.val$unacknowledgedBytesRead = j;
                    }

                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.this$0.writer.windowUpdate(this.val$streamId, this.val$unacknowledgedBytesRead);
                            } catch (IOException unused) {
                                this.this$0.failConnection();
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }
}
