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
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
/* loaded from: classes8.dex */
public final class Http2Stream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long bytesLeftInWriteWindow;
    public final Http2Connection connection;
    public ErrorCode errorCode;
    public boolean hasResponseHeaders;
    public final int id;
    public final StreamTimeout readTimeout;
    public final List<Header> requestHeaders;
    public List<Header> responseHeaders;
    public final FramingSink sink;
    public final FramingSource source;
    public long unacknowledgedBytesRead;
    public final StreamTimeout writeTimeout;

    /* loaded from: classes8.dex */
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
                    this.this$0.connection.writeData(this.this$0.id, z && min == this.sendBuffer.size(), this.sendBuffer, min);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.writeTimeout : (Timeout) invokeV.objValue;
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

    /* loaded from: classes8.dex */
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

        private void waitUntilReadable() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                this.this$0.readTimeout.enter();
                while (this.readBuffer.size() == 0 && !this.finished && !this.closed && this.this$0.errorCode == null) {
                    try {
                        this.this$0.waitForIo();
                    } finally {
                        this.this$0.readTimeout.exitAndThrowIfTimedOut();
                    }
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0) {
                    this.closed = true;
                    size = this.readBuffer.size();
                    this.readBuffer.clear();
                    this.this$0.notifyAll();
                }
                if (size > 0) {
                    updateConnectionFlowControl(size);
                }
                this.this$0.cancelStreamIfNecessary();
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            ErrorCode errorCode;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                if (j >= 0) {
                    synchronized (this.this$0) {
                        waitUntilReadable();
                        if (!this.closed) {
                            errorCode = this.this$0.errorCode;
                            if (this.readBuffer.size() > 0) {
                                j2 = this.readBuffer.read(buffer, Math.min(j, this.readBuffer.size()));
                                this.this$0.unacknowledgedBytesRead += j2;
                            } else {
                                j2 = -1;
                            }
                            if (errorCode == null && this.this$0.unacknowledgedBytesRead >= this.this$0.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                this.this$0.connection.writeWindowUpdateLater(this.this$0.id, this.this$0.unacknowledgedBytesRead);
                                this.this$0.unacknowledgedBytesRead = 0L;
                            }
                        } else {
                            throw new IOException("stream closed");
                        }
                    }
                    if (j2 != -1) {
                        updateConnectionFlowControl(j2);
                        return j2;
                    } else if (errorCode == null) {
                        return -1L;
                    } else {
                        throw new StreamResetException(errorCode);
                    }
                }
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }

        public void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, bufferedSource, j) == null) {
                while (j > 0) {
                    synchronized (this.this$0) {
                        z = this.finished;
                        z2 = true;
                        z3 = this.readBuffer.size() + j > this.maxByteCount;
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
                                if (this.readBuffer.size() != 0) {
                                    z2 = false;
                                }
                                this.readBuffer.writeAll(this.receiveBuffer);
                                if (z2) {
                                    this.this$0.notifyAll();
                                }
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.readTimeout : (Timeout) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
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

        public void exitAndThrowIfTimedOut() throws IOException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
            return (IOException) invokeL.objValue;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.closeLater(ErrorCode.CANCEL);
            }
        }
    }

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

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), http2Connection, Boolean.valueOf(z), Boolean.valueOf(z2), list};
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
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        this.errorCode = null;
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.id = i;
            this.connection = http2Connection;
            this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
            this.source = new FramingSource(this, http2Connection.okHttpSettings.getInitialWindowSize());
            FramingSink framingSink = new FramingSink(this);
            this.sink = framingSink;
            this.source.finished = z2;
            framingSink.finished = z;
            this.requestHeaders = list;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    private boolean closeInternal(ErrorCode errorCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, errorCode)) == null) {
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

    public void addBytesToWriteWindow(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.bytesLeftInWriteWindow += j;
            if (j > 0) {
                notifyAll();
            }
        }
    }

    public void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                z = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
                isOpen = isOpen();
            }
            if (z) {
                close(ErrorCode.CANCEL);
            } else if (isOpen) {
            } else {
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
                    if (this.errorCode != null) {
                        throw new StreamResetException(this.errorCode);
                    }
                    return;
                }
                throw new IOException("stream finished");
            }
            throw new IOException("stream closed");
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, errorCode) == null) && closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, errorCode) == null) && closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    public Http2Connection getConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.connection : (Http2Connection) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.id : invokeV.intValue;
    }

    public List<Header> getRequestHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.requestHeaders : (List) invokeV.objValue;
    }

    public Sink getSink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.source : (Source) invokeV.objValue;
    }

    public boolean isLocallyInitiated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.connection.client == ((this.id & 1) == 1);
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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

    public Timeout readTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.readTimeout : (Timeout) invokeV.objValue;
    }

    public void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, bufferedSource, i) == null) {
            this.source.receive(bufferedSource, i);
        }
    }

    public void receiveFin() {
        boolean isOpen;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                this.source.finished = true;
                isOpen = isOpen();
                notifyAll();
            }
            if (isOpen) {
                return;
            }
            this.connection.removeStream(this.id);
        }
    }

    public void receiveHeaders(List<Header> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            synchronized (this) {
                z = true;
                this.hasResponseHeaders = true;
                if (this.responseHeaders == null) {
                    this.responseHeaders = list;
                    z = isOpen();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.responseHeaders);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.responseHeaders = arrayList;
                }
            }
            if (z) {
                return;
            }
            this.connection.removeStream(this.id);
        }
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, errorCode) == null) {
            synchronized (this) {
                if (this.errorCode == null) {
                    this.errorCode = errorCode;
                    notifyAll();
                }
            }
        }
    }

    public void sendResponseHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, list, z) == null) {
            if (list != null) {
                synchronized (this) {
                    z2 = true;
                    this.hasResponseHeaders = true;
                    if (z) {
                        z3 = false;
                        z4 = false;
                    } else {
                        this.sink.finished = true;
                        z3 = true;
                        z4 = true;
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
            throw new NullPointerException("responseHeaders == null");
        }
    }

    public synchronized List<Header> takeResponseHeaders() throws IOException {
        InterceptResult invokeV;
        List<Header> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this) {
                if (isLocallyInitiated()) {
                    this.readTimeout.enter();
                    while (this.responseHeaders == null && this.errorCode == null) {
                        waitForIo();
                    }
                    this.readTimeout.exitAndThrowIfTimedOut();
                    list = this.responseHeaders;
                    if (list != null) {
                        this.responseHeaders = null;
                    } else {
                        throw new StreamResetException(this.errorCode);
                    }
                } else {
                    throw new IllegalStateException("servers cannot read response headers");
                }
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public void waitForIo() throws InterruptedIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.writeTimeout : (Timeout) invokeV.objValue;
    }
}
