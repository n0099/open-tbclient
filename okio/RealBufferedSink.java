package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public final class RealBufferedSink implements BufferedSink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Buffer buffer;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sink};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.buffer = new Buffer();
        if (sink != null) {
            this.sink = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // okio.BufferedSink
    public Buffer buffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.buffer : (Buffer) invokeV.objValue;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (this.buffer.size > 0) {
                this.sink.write(this.buffer, this.buffer.size);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.closed) {
                long size = this.buffer.size();
                if (size > 0) {
                    this.sink.write(this.buffer, size);
                }
                return this;
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeV.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.closed) {
                long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    this.sink.write(this.buffer, completeSegmentByteCount);
                }
                return this;
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeV.objValue;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.closed) {
                Buffer buffer = this.buffer;
                long j2 = buffer.size;
                if (j2 > 0) {
                    this.sink.write(buffer, j2);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !this.closed : invokeV.booleanValue;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new OutputStream(this) { // from class: okio.RealBufferedSink.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RealBufferedSink this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.close();
                }
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    RealBufferedSink realBufferedSink = this.this$0;
                    if (realBufferedSink.closed) {
                        return;
                    }
                    realBufferedSink.flush();
                }
            }

            public String toString() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.this$0 + ".outputStream()";
                }
                return (String) invokeV2.objValue;
            }

            @Override // java.io.OutputStream
            public void write(int i2) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048579, this, i2) == null) {
                    RealBufferedSink realBufferedSink = this.this$0;
                    if (!realBufferedSink.closed) {
                        realBufferedSink.buffer.writeByte((int) ((byte) i2));
                        this.this$0.emitCompleteSegments();
                        return;
                    }
                    throw new IOException("closed");
                }
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048580, this, bArr, i2, i3) == null) {
                    RealBufferedSink realBufferedSink = this.this$0;
                    if (!realBufferedSink.closed) {
                        realBufferedSink.buffer.write(bArr, i2, i3);
                        this.this$0.emitCompleteSegments();
                        return;
                    }
                    throw new IOException("closed");
                }
            }
        } : (OutputStream) invokeV.objValue;
    }

    @Override // okio.Sink
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.sink.timeout() : (Timeout) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "buffer(" + this.sink + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, buffer, j2) == null) {
            if (!this.closed) {
                this.buffer.write(buffer, j2);
                emitCompleteSegments();
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048591, this, source)) != null) {
            return invokeL.longValue;
        }
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long read = source.read(this.buffer, 8192L);
            if (read == -1) {
                return j2;
            }
            j2 += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (!this.closed) {
                this.buffer.writeByte(i2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeI.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeDecimalLong(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j2)) == null) {
            if (!this.closed) {
                this.buffer.writeDecimalLong(j2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeJ.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j2)) == null) {
            if (!this.closed) {
                this.buffer.writeHexadecimalUnsignedLong(j2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeJ.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            if (!this.closed) {
                this.buffer.writeInt(i2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeI.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeIntLe(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            if (!this.closed) {
                this.buffer.writeIntLe(i2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeI.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLong(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j2)) == null) {
            if (!this.closed) {
                this.buffer.writeLong(j2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeJ.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLongLe(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j2)) == null) {
            if (!this.closed) {
                this.buffer.writeLongLe(j2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeJ.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            if (!this.closed) {
                this.buffer.writeShort(i2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeI.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShortLe(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (!this.closed) {
                this.buffer.writeShortLe(i2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeI.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, charset)) == null) {
            if (!this.closed) {
                this.buffer.writeString(str, charset);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeLL.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (!this.closed) {
                this.buffer.writeUtf8(str);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeL.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (!this.closed) {
                this.buffer.writeUtf8CodePoint(i2);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeI.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, byteString)) == null) {
            if (!this.closed) {
                this.buffer.write(byteString);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeL.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String str, int i2, int i3, Charset charset) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), charset})) == null) {
            if (!this.closed) {
                this.buffer.writeString(str, i2, i3, charset);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeCommon.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048604, this, str, i2, i3)) == null) {
            if (!this.closed) {
                this.buffer.writeUtf8(str, i2, i3);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeLII.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bArr)) == null) {
            if (!this.closed) {
                this.buffer.write(bArr);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeL.objValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048589, this, bArr, i2, i3)) == null) {
            if (!this.closed) {
                this.buffer.write(bArr, i2, i3);
                return emitCompleteSegments();
            }
            throw new IllegalStateException("closed");
        }
        return (BufferedSink) invokeLII.objValue;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, byteBuffer)) == null) {
            if (!this.closed) {
                int write = this.buffer.write(byteBuffer);
                emitCompleteSegments();
                return write;
            }
            throw new IllegalStateException("closed");
        }
        return invokeL.intValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, source, j2)) == null) {
            while (j2 > 0) {
                long read = source.read(this.buffer, j2);
                if (read != -1) {
                    j2 -= read;
                    emitCompleteSegments();
                } else {
                    throw new EOFException();
                }
            }
            return this;
        }
        return (BufferedSink) invokeLJ.objValue;
    }
}
