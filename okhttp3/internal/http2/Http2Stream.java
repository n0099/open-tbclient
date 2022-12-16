package okhttp3.internal.http2;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.data.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes9.dex */
public final class Http2Stream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long bytesLeftInWriteWindow;
    public final Http2Connection connection;
    public ErrorCode errorCode;
    public boolean hasResponseHeaders;
    public Header.Listener headersListener;
    public final Deque<Headers> headersQueue;
    public final int id;
    public final StreamTimeout readTimeout;
    public final FramingSink sink;
    public final FramingSource source;
    public long unacknowledgedBytesRead;
    public final StreamTimeout writeTimeout;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1365971684, "Lokhttp3/internal/http2/Http2Stream;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1365971684, "Lokhttp3/internal/http2/Http2Stream;");
        }
    }

    /* loaded from: classes9.dex */
    public final class FramingSink implements Sink {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic = null;
        public static final long EMIT_BUFFER_SIZE = 16384;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean closed;
        public boolean finished;
        public final Buffer sendBuffer;
        public final /* synthetic */ Http2Stream this$0;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1973843741, "Lokhttp3/internal/http2/Http2Stream$FramingSink;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1973843741, "Lokhttp3/internal/http2/Http2Stream$FramingSink;");
            }
        }

        public FramingSink(Http2Stream http2Stream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http2Stream};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = http2Stream;
            this.sendBuffer = new Buffer();
        }

        private void emitFrame(boolean z) throws IOException {
            long min;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
                synchronized (this.this$0) {
                    this.this$0.writeTimeout.enter();
                    while (this.this$0.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && this.this$0.errorCode == null) {
                        this.this$0.waitForIo();
                    }
                    this.this$0.writeTimeout.exitAndThrowIfTimedOut();
                    this.this$0.checkOutNotClosed();
                    min = Math.min(this.this$0.bytesLeftInWriteWindow, this.sendBuffer.size());
                    this.this$0.bytesLeftInWriteWindow -= min;
                }
                this.this$0.writeTimeout.enter();
                try {
                    Http2Connection http2Connection = this.this$0.connection;
                    int i = this.this$0.id;
                    if (z && min == this.sendBuffer.size()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    http2Connection.writeData(i, z2, this.sendBuffer, min);
                } finally {
                    this.this$0.writeTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0) {
                    if (this.closed) {
                        return;
                    }
                    if (!this.this$0.sink.finished) {
                        if (this.sendBuffer.size() > 0) {
                            while (this.sendBuffer.size() > 0) {
                                emitFrame(true);
                            }
                        } else {
                            Http2Stream http2Stream = this.this$0;
                            http2Stream.connection.writeData(http2Stream.id, true, null, 0L);
                        }
                    }
                    synchronized (this.this$0) {
                        this.closed = true;
                    }
                    this.this$0.connection.flush();
                    this.this$0.cancelStreamIfNecessary();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.this$0) {
                    this.this$0.checkOutNotClosed();
                }
                while (this.sendBuffer.size() > 0) {
                    emitFrame(false);
                    this.this$0.connection.flush();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.this$0.writeTimeout;
            }
            return (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                this.sendBuffer.write(buffer, j);
                while (this.sendBuffer.size() >= 16384) {
                    emitFrame(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class FramingSource implements Source {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean closed;
        public boolean finished;
        public final long maxByteCount;
        public final Buffer readBuffer;
        public final Buffer receiveBuffer;
        public final /* synthetic */ Http2Stream this$0;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1690199451, "Lokhttp3/internal/http2/Http2Stream$FramingSource;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1690199451, "Lokhttp3/internal/http2/Http2Stream$FramingSource;");
            }
        }

        public FramingSource(Http2Stream http2Stream, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http2Stream, Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = http2Stream;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = j;
        }

        private void updateConnectionFlowControl(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
                this.this$0.connection.updateConnectionFlowControl(j);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Header.Listener listener;
            ArrayList<Headers> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0) {
                    this.closed = true;
                    size = this.readBuffer.size();
                    this.readBuffer.clear();
                    listener = null;
                    if (!this.this$0.headersQueue.isEmpty() && this.this$0.headersListener != null) {
                        ArrayList arrayList2 = new ArrayList(this.this$0.headersQueue);
                        this.this$0.headersQueue.clear();
                        listener = this.this$0.headersListener;
                        arrayList = arrayList2;
                    } else {
                        arrayList = null;
                    }
                    this.this$0.notifyAll();
                }
                if (size > 0) {
                    updateConnectionFlowControl(size);
                }
                this.this$0.cancelStreamIfNecessary();
                if (listener != null) {
                    for (Headers headers : arrayList) {
                        listener.onHeaders(headers);
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00cf, code lost:
            if (r11 == (-1)) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d1, code lost:
            updateConnectionFlowControl(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00d5, code lost:
            if (r0 != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00dd, code lost:
            throw new okhttp3.internal.http2.StreamResetException(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            ErrorCode errorCode;
            long read;
            Headers headers;
            Header.Listener listener;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                while (true) {
                    synchronized (this.this$0) {
                        this.this$0.readTimeout.enter();
                        if (this.this$0.errorCode != null) {
                            errorCode = this.this$0.errorCode;
                        } else {
                            errorCode = null;
                        }
                        if (this.closed) {
                            break;
                        }
                        if (!this.this$0.headersQueue.isEmpty() && this.this$0.headersListener != null) {
                            headers = (Headers) this.this$0.headersQueue.removeFirst();
                            listener = this.this$0.headersListener;
                            read = -1;
                        } else {
                            if (this.readBuffer.size() > 0) {
                                read = this.readBuffer.read(buffer, Math.min(j, this.readBuffer.size()));
                                this.this$0.unacknowledgedBytesRead += read;
                                if (errorCode == null && this.this$0.unacknowledgedBytesRead >= this.this$0.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                    this.this$0.connection.writeWindowUpdateLater(this.this$0.id, this.this$0.unacknowledgedBytesRead);
                                    this.this$0.unacknowledgedBytesRead = 0L;
                                }
                            } else if (!this.finished && errorCode == null) {
                                this.this$0.waitForIo();
                                this.this$0.readTimeout.exitAndThrowIfTimedOut();
                            } else {
                                read = -1;
                            }
                            headers = null;
                            listener = null;
                        }
                        this.this$0.readTimeout.exitAndThrowIfTimedOut();
                        if (headers == null || listener == null) {
                            break;
                        }
                        listener.onHeaders(headers);
                    }
                }
            } else {
                return invokeLJ.longValue;
            }
        }

        public void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, bufferedSource, j) == null) {
                while (j > 0) {
                    synchronized (this.this$0) {
                        z = this.finished;
                        z2 = true;
                        if (this.readBuffer.size() + j > this.maxByteCount) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    }
                    if (z3) {
                        bufferedSource.skip(j);
                        this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j);
                        return;
                    } else {
                        long read = bufferedSource.read(this.receiveBuffer, j);
                        if (read != -1) {
                            j -= read;
                            synchronized (this.this$0) {
                                if (this.closed) {
                                    j2 = this.receiveBuffer.size();
                                    this.receiveBuffer.clear();
                                } else {
                                    if (this.readBuffer.size() != 0) {
                                        z2 = false;
                                    }
                                    this.readBuffer.writeAll(this.receiveBuffer);
                                    if (z2) {
                                        this.this$0.notifyAll();
                                    }
                                    j2 = 0;
                                }
                            }
                            if (j2 > 0) {
                                updateConnectionFlowControl(j2);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.this$0.readTimeout;
            }
            return (Timeout) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class StreamTimeout extends AsyncTimeout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream http2Stream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {http2Stream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = http2Stream;
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException(a.O);
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
            return (IOException) invokeL.objValue;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !exit()) {
                return;
            }
            throw newTimeoutException(null);
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.closeLater(ErrorCode.CANCEL);
                this.this$0.connection.sendDegradedPingLater();
            }
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable Headers headers) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), http2Connection, Boolean.valueOf(z), Boolean.valueOf(z2), headers};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.unacknowledgedBytesRead = 0L;
        this.headersQueue = new ArrayDeque();
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        this.errorCode = null;
        if (http2Connection != null) {
            this.id = i;
            this.connection = http2Connection;
            this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
            this.source = new FramingSource(this, http2Connection.okHttpSettings.getInitialWindowSize());
            FramingSink framingSink = new FramingSink(this);
            this.sink = framingSink;
            this.source.finished = z2;
            framingSink.finished = z;
            if (headers != null) {
                this.headersQueue.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
            return;
        }
        throw new NullPointerException("connection == null");
    }

    public void addBytesToWriteWindow(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.bytesLeftInWriteWindow += j;
            if (j > 0) {
                notifyAll();
            }
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, errorCode) != null) || !closeInternal(errorCode)) {
            return;
        }
        this.connection.writeSynReset(this.id, errorCode);
    }

    public void closeLater(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, errorCode) != null) || !closeInternal(errorCode)) {
            return;
        }
        this.connection.writeSynResetLater(this.id, errorCode);
    }

    public void receiveHeaders(List<Header> list) {
        boolean isOpen;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            synchronized (this) {
                this.hasResponseHeaders = true;
                this.headersQueue.add(Util.toHeaders(list));
                isOpen = isOpen();
                notifyAll();
            }
            if (!isOpen) {
                this.connection.removeStream(this.id);
            }
        }
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, errorCode) == null) {
            synchronized (this) {
                if (this.errorCode == null) {
                    this.errorCode = errorCode;
                    notifyAll();
                }
            }
        }
    }

    public synchronized void setHeadersListener(Header.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, listener) == null) {
            synchronized (this) {
                this.headersListener = listener;
                if (!this.headersQueue.isEmpty() && listener != null) {
                    notifyAll();
                }
            }
        }
    }

    private boolean closeInternal(ErrorCode errorCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, errorCode)) == null) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.finished && this.sink.finished) {
                    return false;
                }
                this.errorCode = errorCode;
                notifyAll();
                this.connection.removeStream(this.id);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (!this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed)) {
                    z = true;
                } else {
                    z = false;
                }
                isOpen = isOpen();
            }
            if (z) {
                close(ErrorCode.CANCEL);
            } else if (!isOpen) {
                this.connection.removeStream(this.id);
            }
        }
    }

    public void checkOutNotClosed() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FramingSink framingSink = this.sink;
            if (!framingSink.closed) {
                if (!framingSink.finished) {
                    if (this.errorCode == null) {
                        return;
                    }
                    throw new StreamResetException(this.errorCode);
                }
                throw new IOException("stream finished");
            }
            throw new IOException("stream closed");
        }
    }

    public synchronized boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                }
                if ((this.source.finished || this.source.closed) && (this.sink.finished || this.sink.closed)) {
                    if (this.hasResponseHeaders) {
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public Http2Connection getConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.connection;
        }
        return (Http2Connection) invokeV.objValue;
    }

    public synchronized ErrorCode getErrorCode() {
        InterceptResult invokeV;
        ErrorCode errorCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                errorCode = this.errorCode;
            }
            return errorCode;
        }
        return (ErrorCode) invokeV.objValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.id;
        }
        return invokeV.intValue;
    }

    public Sink getSink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
            return this.sink;
        }
        return (Sink) invokeV.objValue;
    }

    public Source getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.source;
        }
        return (Source) invokeV.objValue;
    }

    public boolean isLocallyInitiated() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if ((this.id & 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (this.connection.client == z) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Timeout readTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.readTimeout;
        }
        return (Timeout) invokeV.objValue;
    }

    public void receiveFin() {
        boolean isOpen;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.source.finished = true;
                isOpen = isOpen();
                notifyAll();
            }
            if (!isOpen) {
                this.connection.removeStream(this.id);
            }
        }
    }

    public void waitForIo() throws InterruptedIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        }
    }

    public Timeout writeTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.writeTimeout;
        }
        return (Timeout) invokeV.objValue;
    }

    public void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, bufferedSource, i) == null) {
            this.source.receive(bufferedSource, i);
        }
    }

    public synchronized Headers takeHeaders() throws IOException {
        InterceptResult invokeV;
        Headers removeFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                this.readTimeout.enter();
                while (this.headersQueue.isEmpty() && this.errorCode == null) {
                    waitForIo();
                }
                this.readTimeout.exitAndThrowIfTimedOut();
                if (!this.headersQueue.isEmpty()) {
                    removeFirst = this.headersQueue.removeFirst();
                } else {
                    throw new StreamResetException(this.errorCode);
                }
            }
            return removeFirst;
        }
        return (Headers) invokeV.objValue;
    }

    public void writeHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048596, this, list, z) == null) {
            if (list != null) {
                synchronized (this) {
                    z2 = true;
                    this.hasResponseHeaders = true;
                    if (!z) {
                        this.sink.finished = true;
                        z3 = true;
                        z4 = true;
                    } else {
                        z3 = false;
                        z4 = false;
                    }
                }
                if (!z3) {
                    synchronized (this.connection) {
                        if (this.connection.bytesLeftInWriteWindow != 0) {
                            z2 = false;
                        }
                    }
                    z3 = z2;
                }
                this.connection.writeSynReply(this.id, z4, list);
                if (z3) {
                    this.connection.flush();
                    return;
                }
                return;
            }
            throw new NullPointerException("headers == null");
        }
    }
}
