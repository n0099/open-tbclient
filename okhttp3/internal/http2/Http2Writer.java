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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;
/* loaded from: classes8.dex */
public final class Http2Writer implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean client;
    public boolean closed;
    public final Buffer hpackBuffer;
    public final Hpack.Writer hpackWriter;
    public int maxFrameSize;
    public final BufferedSink sink;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2118923913, "Lokhttp3/internal/http2/Http2Writer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2118923913, "Lokhttp3/internal/http2/Http2Writer;");
                return;
            }
        }
        logger = Logger.getLogger(Http2.class.getName());
    }

    public Http2Writer(BufferedSink bufferedSink, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSink, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sink = bufferedSink;
        this.client = z;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(buffer);
        this.maxFrameSize = 16384;
    }

    private void writeContinuationFrames(int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            while (j > 0) {
                int min = (int) Math.min(this.maxFrameSize, j);
                long j2 = min;
                j -= j2;
                frameHeader(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
                this.sink.write(this.hpackBuffer, j2);
            }
        }
    }

    public static void writeMedium(BufferedSink bufferedSink, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, bufferedSink, i) == null) {
            bufferedSink.writeByte((i >>> 16) & 255);
            bufferedSink.writeByte((i >>> 8) & 255);
            bufferedSink.writeByte(i & 255);
        }
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, settings) == null) {
            synchronized (this) {
                if (!this.closed) {
                    this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                    if (settings.getHeaderTableSize() != -1) {
                        this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
                    }
                    frameHeader(0, 0, (byte) 4, (byte) 1);
                    this.sink.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.closed = true;
                this.sink.close();
            }
        }
    }

    public synchronized void connectionPreface() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!this.closed) {
                    if (this.client) {
                        if (logger.isLoggable(Level.FINE)) {
                            logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                        }
                        this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                        this.sink.flush();
                        return;
                    }
                    return;
                }
                throw new IOException("closed");
            }
        }
    }

    public synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), buffer, Integer.valueOf(i2)}) == null) {
            synchronized (this) {
                if (!this.closed) {
                    dataFrame(i, z ? (byte) 1 : (byte) 0, buffer, i2);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public void dataFrame(int i, byte b2, Buffer buffer, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Byte.valueOf(b2), buffer, Integer.valueOf(i2)}) == null) {
            frameHeader(i, i2, (byte) 0, b2);
            if (i2 > 0) {
                this.sink.write(buffer, i2);
            }
        }
    }

    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!this.closed) {
                    this.sink.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public void frameHeader(int i, int i2, byte b2, byte b3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Byte.valueOf(b2), Byte.valueOf(b3)}) == null) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(false, i, i2, b2, b3));
            }
            int i3 = this.maxFrameSize;
            if (i2 > i3) {
                throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            if ((Integer.MIN_VALUE & i) != 0) {
                throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i));
            }
            writeMedium(this.sink, i2);
            this.sink.writeByte(b2 & 255);
            this.sink.writeByte(b3 & 255);
            this.sink.writeInt(i & Integer.MAX_VALUE);
        }
    }

    public synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i, errorCode, bArr) == null) {
            synchronized (this) {
                if (!this.closed) {
                    if (errorCode.httpCode != -1) {
                        frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
                        this.sink.writeInt(i);
                        this.sink.writeInt(errorCode.httpCode);
                        if (bArr.length > 0) {
                            this.sink.write(bArr);
                        }
                        this.sink.flush();
                    } else {
                        throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void headers(int i, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, list) == null) {
            synchronized (this) {
                if (!this.closed) {
                    headers(false, i, list);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public int maxDataLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.maxFrameSize : invokeV.intValue;
    }

    public synchronized void ping(boolean z, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            synchronized (this) {
                if (!this.closed) {
                    frameHeader(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                    this.sink.writeInt(i);
                    this.sink.writeInt(i2);
                    this.sink.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void pushPromise(int i, int i2, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i, i2, list) == null) {
            synchronized (this) {
                if (!this.closed) {
                    this.hpackWriter.writeHeaders(list);
                    long size = this.hpackBuffer.size();
                    int min = (int) Math.min(this.maxFrameSize - 4, size);
                    long j = min;
                    int i3 = (size > j ? 1 : (size == j ? 0 : -1));
                    frameHeader(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
                    this.sink.writeInt(i2 & Integer.MAX_VALUE);
                    this.sink.write(this.hpackBuffer, j);
                    if (i3 > 0) {
                        writeContinuationFrames(i, size - j);
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, errorCode) == null) {
            synchronized (this) {
                if (!this.closed) {
                    if (errorCode.httpCode != -1) {
                        frameHeader(i, 4, (byte) 3, (byte) 0);
                        this.sink.writeInt(errorCode.httpCode);
                        this.sink.flush();
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void settings(Settings settings) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, settings) == null) {
            synchronized (this) {
                if (!this.closed) {
                    int i = 0;
                    frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
                    while (i < 10) {
                        if (settings.isSet(i)) {
                            this.sink.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                            this.sink.writeInt(settings.get(i));
                        }
                        i++;
                    }
                    this.sink.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), list}) == null) {
            synchronized (this) {
                if (!this.closed) {
                    headers(z, i, list);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void synStream(boolean z, int i, int i2, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), list}) == null) {
            synchronized (this) {
                if (!this.closed) {
                    headers(z, i, list);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void windowUpdate(int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (j != 0 && j <= 2147483647L) {
                    frameHeader(i, 4, (byte) 8, (byte) 0);
                    this.sink.writeInt((int) j);
                    this.sink.flush();
                } else {
                    throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
                }
            }
        }
    }

    public void headers(boolean z, int i, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), list}) == null) {
            if (!this.closed) {
                this.hpackWriter.writeHeaders(list);
                long size = this.hpackBuffer.size();
                int min = (int) Math.min(this.maxFrameSize, size);
                long j = min;
                int i2 = (size > j ? 1 : (size == j ? 0 : -1));
                byte b2 = i2 == 0 ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                frameHeader(i, min, (byte) 1, b2);
                this.sink.write(this.hpackBuffer, j);
                if (i2 > 0) {
                    writeContinuationFrames(i, size - j);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }
}
