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
/* loaded from: classes2.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private void writeContinuationFrames(int i2, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            while (j2 > 0) {
                int min = (int) Math.min(this.maxFrameSize, j2);
                long j3 = min;
                j2 -= j3;
                frameHeader(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
                this.sink.write(this.hpackBuffer, j3);
            }
        }
    }

    public static void writeMedium(BufferedSink bufferedSink, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, bufferedSink, i2) == null) {
            bufferedSink.writeByte((i2 >>> 16) & 255);
            bufferedSink.writeByte((i2 >>> 8) & 255);
            bufferedSink.writeByte(i2 & 255);
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

    public synchronized void data(boolean z, int i2, Buffer buffer, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), buffer, Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (!this.closed) {
                    dataFrame(i2, z ? (byte) 1 : (byte) 0, buffer, i3);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public void dataFrame(int i2, byte b2, Buffer buffer, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2), buffer, Integer.valueOf(i3)}) == null) {
            frameHeader(i2, i3, (byte) 0, b2);
            if (i3 > 0) {
                this.sink.write(buffer, i3);
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

    public void frameHeader(int i2, int i3, byte b2, byte b3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2), Byte.valueOf(b3)}) == null) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(false, i2, i3, b2, b3));
            }
            int i4 = this.maxFrameSize;
            if (i3 > i4) {
                throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            }
            if ((Integer.MIN_VALUE & i2) != 0) {
                throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i2));
            }
            writeMedium(this.sink, i3);
            this.sink.writeByte(b2 & 255);
            this.sink.writeByte(b3 & 255);
            this.sink.writeInt(i2 & Integer.MAX_VALUE);
        }
    }

    public synchronized void goAway(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, errorCode, bArr) == null) {
            synchronized (this) {
                if (!this.closed) {
                    if (errorCode.httpCode != -1) {
                        frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
                        this.sink.writeInt(i2);
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

    public synchronized void headers(int i2, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) {
            synchronized (this) {
                if (!this.closed) {
                    headers(false, i2, list);
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

    public synchronized void ping(boolean z, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            synchronized (this) {
                if (!this.closed) {
                    frameHeader(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
                    this.sink.writeInt(i2);
                    this.sink.writeInt(i3);
                    this.sink.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void pushPromise(int i2, int i3, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, list) == null) {
            synchronized (this) {
                if (!this.closed) {
                    this.hpackWriter.writeHeaders(list);
                    long size = this.hpackBuffer.size();
                    int min = (int) Math.min(this.maxFrameSize - 4, size);
                    long j2 = min;
                    int i4 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
                    frameHeader(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : (byte) 0);
                    this.sink.writeInt(i3 & Integer.MAX_VALUE);
                    this.sink.write(this.hpackBuffer, j2);
                    if (i4 > 0) {
                        writeContinuationFrames(i2, size - j2);
                    }
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void rstStream(int i2, ErrorCode errorCode) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, errorCode) == null) {
            synchronized (this) {
                if (!this.closed) {
                    if (errorCode.httpCode != -1) {
                        frameHeader(i2, 4, (byte) 3, (byte) 0);
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
                    int i2 = 0;
                    frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
                    while (i2 < 10) {
                        if (settings.isSet(i2)) {
                            this.sink.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                            this.sink.writeInt(settings.get(i2));
                        }
                        i2++;
                    }
                    this.sink.flush();
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void synReply(boolean z, int i2, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), list}) == null) {
            synchronized (this) {
                if (!this.closed) {
                    headers(z, i2, list);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void synStream(boolean z, int i2, int i3, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
            synchronized (this) {
                if (!this.closed) {
                    headers(z, i2, list);
                } else {
                    throw new IOException("closed");
                }
            }
        }
    }

    public synchronized void windowUpdate(int i2, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            synchronized (this) {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (j2 != 0 && j2 <= 2147483647L) {
                    frameHeader(i2, 4, (byte) 8, (byte) 0);
                    this.sink.writeInt((int) j2);
                    this.sink.flush();
                } else {
                    throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
                }
            }
        }
    }

    public void headers(boolean z, int i2, List<Header> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), list}) == null) {
            if (!this.closed) {
                this.hpackWriter.writeHeaders(list);
                long size = this.hpackBuffer.size();
                int min = (int) Math.min(this.maxFrameSize, size);
                long j2 = min;
                int i3 = (size > j2 ? 1 : (size == j2 ? 0 : -1));
                byte b2 = i3 == 0 ? (byte) 4 : (byte) 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                frameHeader(i2, min, (byte) 1, b2);
                this.sink.write(this.hpackBuffer, j2);
                if (i3 > 0) {
                    writeContinuationFrames(i2, size - j2);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }
}
