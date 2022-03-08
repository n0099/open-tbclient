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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import kotlin.text.Typography;
/* loaded from: classes9.dex */
public final class RealBufferedSource implements BufferedSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Buffer buffer;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {source};
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
        if (source != null) {
            this.source = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.buffer : (Buffer) invokeV.objValue;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            return this.buffer.exhausted() && this.source.read(this.buffer, 8192L) == -1;
        }
        return invokeV.booleanValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) throws IOException {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(1048579, this, b2)) == null) ? indexOf(b2, 0L, Long.MAX_VALUE) : invokeB.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteString)) == null) ? indexOfElement(byteString, 0L) : invokeL.longValue;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new InputStream(this) { // from class: okio.RealBufferedSource.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RealBufferedSource this$0;

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

            @Override // java.io.InputStream
            public int available() throws IOException {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                    RealBufferedSource realBufferedSource = this.this$0;
                    if (!realBufferedSource.closed) {
                        return (int) Math.min(realBufferedSource.buffer.size, 2147483647L);
                    }
                    throw new IOException("closed");
                }
                return invokeV2.intValue;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.close();
                }
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    RealBufferedSource realBufferedSource = this.this$0;
                    if (!realBufferedSource.closed) {
                        Buffer buffer = realBufferedSource.buffer;
                        if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                            return -1;
                        }
                        return this.this$0.buffer.readByte() & 255;
                    }
                    throw new IOException("closed");
                }
                return invokeV2.intValue;
            }

            public String toString() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048580, this)) == null) {
                    return this.this$0 + ".inputStream()";
                }
                return (String) invokeV2.objValue;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048579, this, bArr, i2, i3)) == null) {
                    if (!this.this$0.closed) {
                        Util.checkOffsetAndCount(bArr.length, i2, i3);
                        RealBufferedSource realBufferedSource = this.this$0;
                        Buffer buffer = realBufferedSource.buffer;
                        if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192L) == -1) {
                            return -1;
                        }
                        return this.this$0.buffer.read(bArr, i2, i3);
                    }
                    throw new IOException("closed");
                }
                return invokeLII.intValue;
            }
        } : (InputStream) invokeV.objValue;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !this.closed : invokeV.booleanValue;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, ByteString byteString) throws IOException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048588, this, j2, byteString)) == null) ? rangeEquals(j2, byteString, 0, byteString.size()) : invokeJL.booleanValue;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048593, this, buffer, j2)) == null) {
            if (buffer != null) {
                if (j2 >= 0) {
                    if (!this.closed) {
                        Buffer buffer2 = this.buffer;
                        if (buffer2.size == 0 && this.source.read(buffer2, 8192L) == -1) {
                            return -1L;
                        }
                        return this.buffer.read(buffer, Math.min(j2, this.buffer.size));
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            throw new IllegalArgumentException("sink == null");
        }
        return invokeLJ.longValue;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, sink)) == null) {
            if (sink != null) {
                long j2 = 0;
                while (this.source.read(this.buffer, 8192L) != -1) {
                    long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
                    if (completeSegmentByteCount > 0) {
                        j2 += completeSegmentByteCount;
                        sink.write(this.buffer, completeSegmentByteCount);
                    }
                }
                if (this.buffer.size() > 0) {
                    long size = j2 + this.buffer.size();
                    Buffer buffer = this.buffer;
                    sink.write(buffer, buffer.size());
                    return size;
                }
                return j2;
            }
            throw new IllegalArgumentException("sink == null");
        }
        return invokeL.longValue;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            require(1L);
            return this.buffer.readByte();
        }
        return invokeV.byteValue;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readByteArray();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readByteString();
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws IOException {
        InterceptResult invokeV;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            require(1L);
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (!request(i3)) {
                    break;
                }
                b2 = this.buffer.getByte(i2);
                if ((b2 < 48 || b2 > 57) && !(i2 == 0 && b2 == 45)) {
                    break;
                }
                i2 = i3;
            }
            if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b2)));
            }
            return this.buffer.readDecimalLong();
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048602, this, bArr) != null) {
            return;
        }
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                Buffer buffer = this.buffer;
                long j2 = buffer.size;
                if (j2 > 0) {
                    int read = buffer.read(bArr, i2, (int) j2);
                    if (read == -1) {
                        throw new AssertionError();
                    }
                    i2 += read;
                } else {
                    throw e2;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r1 == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readHexadecimalUnsignedLong() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            require(1L);
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (!request(i3)) {
                    break;
                }
                byte b2 = this.buffer.getByte(i2);
                if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                    break;
                }
                i2 = i3;
            }
            return this.buffer.readHexadecimalUnsignedLong();
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public int readInt() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            require(4L);
            return this.buffer.readInt();
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            require(4L);
            return this.buffer.readIntLe();
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    public long readLong() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            require(8L);
            return this.buffer.readLong();
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            require(8L);
            return this.buffer.readLongLe();
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public short readShort() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            require(2L);
            return this.buffer.readShort();
        }
        return invokeV.shortValue;
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            require(2L);
            return this.buffer.readShortLe();
        }
        return invokeV.shortValue;
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, charset)) == null) {
            if (charset != null) {
                this.buffer.writeAll(this.source);
                return this.buffer.readString(charset);
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeL.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readUtf8();
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            require(1L);
            byte b2 = this.buffer.getByte(0L);
            if ((b2 & 224) == 192) {
                require(2L);
            } else if ((b2 & 240) == 224) {
                require(3L);
            } else if ((b2 & 248) == 240) {
                require(4L);
            }
            return this.buffer.readUtf8CodePoint();
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            long indexOf = indexOf((byte) 10);
            if (indexOf == -1) {
                long j2 = this.buffer.size;
                if (j2 != 0) {
                    return readUtf8(j2);
                }
                return null;
            }
            return this.buffer.readUtf8Line(indexOf);
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? readUtf8LineStrict(Long.MAX_VALUE) : (String) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public boolean request(long j2) throws IOException {
        InterceptResult invokeJ;
        Buffer buffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048618, this, j2)) == null) {
            if (j2 >= 0) {
                if (!this.closed) {
                    do {
                        buffer = this.buffer;
                        if (buffer.size >= j2) {
                            return true;
                        }
                    } while (this.source.read(buffer, 8192L) != -1);
                    return false;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        return invokeJ.booleanValue;
    }

    @Override // okio.BufferedSource
    public void require(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048619, this, j2) == null) && !request(j2)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, options)) == null) {
            if (!this.closed) {
                do {
                    int selectPrefix = this.buffer.selectPrefix(options, true);
                    if (selectPrefix == -1) {
                        return -1;
                    }
                    if (selectPrefix != -2) {
                        this.buffer.skip(options.byteStrings[selectPrefix].size());
                        return selectPrefix;
                    }
                } while (this.source.read(this.buffer, 8192L) != -1);
                return -1;
            }
            throw new IllegalStateException("closed");
        }
        return invokeL.intValue;
    }

    @Override // okio.BufferedSource
    public void skip(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048621, this, j2) == null) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            while (j2 > 0) {
                Buffer buffer = this.buffer;
                if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.buffer.size());
                this.buffer.skip(min);
                j2 -= min;
            }
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.source.timeout() : (Timeout) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return "buffer(" + this.source + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Byte.valueOf(b2), Long.valueOf(j2)})) == null) ? indexOf(b2, j2, Long.MAX_VALUE) : invokeCommon.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048585, this, byteString, j2)) != null) {
            return invokeLJ.longValue;
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.buffer.indexOfElement(byteString, j2);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            Buffer buffer = this.buffer;
            long j3 = buffer.size;
            if (this.source.read(buffer, 8192L) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, j3);
        }
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, ByteString byteString, int i2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), byteString, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (!this.closed) {
                if (j2 < 0 || i2 < 0 || i3 < 0 || byteString.size() - i2 < i3) {
                    return false;
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    long j3 = i4 + j2;
                    if (!request(1 + j3) || this.buffer.getByte(j3) != byteString.getByte(i2 + i4)) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException("closed");
        }
        return invokeCommon.booleanValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048617, this, j2)) == null) {
            if (j2 >= 0) {
                long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
                long indexOf = indexOf((byte) 10, 0L, j3);
                if (indexOf != -1) {
                    return this.buffer.readUtf8Line(indexOf);
                }
                if (j3 < Long.MAX_VALUE && request(j3) && this.buffer.getByte(j3 - 1) == 13 && request(1 + j3) && this.buffer.getByte(j3) == 10) {
                    return this.buffer.readUtf8Line(j3);
                }
                Buffer buffer = new Buffer();
                Buffer buffer2 = this.buffer;
                buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
                throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), j2) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
            }
            throw new IllegalArgumentException("limit < 0: " + j2);
        }
        return (String) invokeJ.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2, long j3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Byte.valueOf(b2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j2 < 0 || j3 < j2) {
                throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j2), Long.valueOf(j3)));
            }
            while (j2 < j3) {
                long indexOf = this.buffer.indexOf(b2, j2, j3);
                if (indexOf == -1) {
                    Buffer buffer = this.buffer;
                    long j4 = buffer.size;
                    if (j4 >= j3 || this.source.read(buffer, 8192L) == -1) {
                        break;
                    }
                    j2 = Math.max(j2, j4);
                } else {
                    return indexOf;
                }
            }
            return -1L;
        }
        return invokeCommon.longValue;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j2)) == null) {
            require(j2);
            return this.buffer.readByteArray(j2);
        }
        return (byte[]) invokeJ.objValue;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j2)) == null) {
            require(j2);
            return this.buffer.readByteString(j2);
        }
        return (ByteString) invokeJ.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048613, this, j2)) == null) {
            require(j2);
            return this.buffer.readUtf8(j2);
        }
        return (String) invokeJ.objValue;
    }

    @Override // okio.BufferedSource
    public String readString(long j2, Charset charset) throws IOException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048610, this, j2, charset)) == null) {
            require(j2);
            if (charset != null) {
                return this.buffer.readString(j2, charset);
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeJL.objValue;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048601, this, buffer, j2) == null) {
            try {
                require(j2);
                this.buffer.readFully(buffer, j2);
            } catch (EOFException e2) {
                buffer.writeAll(this.buffer);
                throw e2;
            }
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bArr)) == null) ? read(bArr, 0, bArr.length) : invokeL.intValue;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048592, this, bArr, i2, i3)) == null) {
            long j2 = i3;
            Util.checkOffsetAndCount(bArr.length, i2, j2);
            Buffer buffer = this.buffer;
            if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
                return -1;
            }
            return this.buffer.read(bArr, i2, (int) Math.min(j2, this.buffer.size));
        }
        return invokeLII.intValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, byteString)) == null) ? indexOf(byteString, 0L) : invokeL.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048583, this, byteString, j2)) != null) {
            return invokeLJ.longValue;
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.buffer.indexOf(byteString, j2);
            if (indexOf != -1) {
                return indexOf;
            }
            Buffer buffer = this.buffer;
            long j3 = buffer.size;
            if (this.source.read(buffer, 8192L) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (j3 - byteString.size()) + 1);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, byteBuffer)) == null) {
            Buffer buffer = this.buffer;
            if (buffer.size == 0 && this.source.read(buffer, 8192L) == -1) {
                return -1;
            }
            return this.buffer.read(byteBuffer);
        }
        return invokeL.intValue;
    }
}
