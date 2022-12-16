package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.slider.BasicLabelFormatter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.text.Typography;
/* loaded from: classes9.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte[] DIGITS;
    public static final int REPLACEMENT_CHARACTER = 65533;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Segment head;
    public long size;

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Buffer) invokeV.objValue;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (BufferedSink) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : (Buffer) invokeV.objValue;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public static final class UnsafeCursor implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Buffer buffer;
        public byte[] data;
        public int end;
        public long offset;
        public boolean readWrite;
        public Segment segment;
        public int start;

        public UnsafeCursor() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.offset = -1L;
            this.start = -1;
            this.end = -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.buffer != null) {
                    this.buffer = null;
                    this.segment = null;
                    this.offset = -1L;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return;
                }
                throw new IllegalStateException("not attached to a buffer");
            }
        }

        public final long expandBuffer(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (i > 0) {
                    if (i <= 8192) {
                        Buffer buffer = this.buffer;
                        if (buffer != null) {
                            if (this.readWrite) {
                                long j = buffer.size;
                                Segment writableSegment = buffer.writableSegment(i);
                                int i2 = 8192 - writableSegment.limit;
                                writableSegment.limit = 8192;
                                long j2 = i2;
                                this.buffer.size = j + j2;
                                this.segment = writableSegment;
                                this.offset = j;
                                this.data = writableSegment.data;
                                this.start = 8192 - i2;
                                this.end = 8192;
                                return j2;
                            }
                            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                        }
                        throw new IllegalStateException("not attached to a buffer");
                    }
                    throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
                }
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            }
            return invokeI.longValue;
        }

        public final int next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long j = this.offset;
                if (j != this.buffer.size) {
                    if (j == -1) {
                        return seek(0L);
                    }
                    return seek(j + (this.end - this.start));
                }
                throw new IllegalStateException();
            }
            return invokeV.intValue;
        }

        public final long resizeBuffer(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                Buffer buffer = this.buffer;
                if (buffer != null) {
                    if (this.readWrite) {
                        long j2 = buffer.size;
                        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i <= 0) {
                            if (j >= 0) {
                                long j3 = j2 - j;
                                while (true) {
                                    if (j3 <= 0) {
                                        break;
                                    }
                                    Buffer buffer2 = this.buffer;
                                    Segment segment = buffer2.head.prev;
                                    int i2 = segment.limit;
                                    long j4 = i2 - segment.pos;
                                    if (j4 <= j3) {
                                        buffer2.head = segment.pop();
                                        SegmentPool.recycle(segment);
                                        j3 -= j4;
                                    } else {
                                        segment.limit = (int) (i2 - j3);
                                        break;
                                    }
                                }
                                this.segment = null;
                                this.offset = j;
                                this.data = null;
                                this.start = -1;
                                this.end = -1;
                            } else {
                                throw new IllegalArgumentException("newSize < 0: " + j);
                            }
                        } else if (i > 0) {
                            long j5 = j - j2;
                            boolean z = true;
                            while (j5 > 0) {
                                Segment writableSegment = this.buffer.writableSegment(1);
                                int min = (int) Math.min(j5, 8192 - writableSegment.limit);
                                int i3 = writableSegment.limit + min;
                                writableSegment.limit = i3;
                                j5 -= min;
                                if (z) {
                                    this.segment = writableSegment;
                                    this.offset = j2;
                                    this.data = writableSegment.data;
                                    this.start = i3 - min;
                                    this.end = i3;
                                    z = false;
                                }
                            }
                        }
                        this.buffer.size = j;
                        return j2;
                    }
                    throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
                }
                throw new IllegalStateException("not attached to a buffer");
            }
            return invokeJ.longValue;
        }

        public final int seek(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
                if (i >= 0) {
                    Buffer buffer = this.buffer;
                    long j2 = buffer.size;
                    if (j <= j2) {
                        if (i != 0 && j != j2) {
                            long j3 = 0;
                            Segment segment = buffer.head;
                            Segment segment2 = this.segment;
                            if (segment2 != null) {
                                long j4 = this.offset - (this.start - segment2.pos);
                                if (j4 > j) {
                                    j2 = j4;
                                    segment2 = segment;
                                    segment = segment2;
                                } else {
                                    j3 = j4;
                                }
                            } else {
                                segment2 = segment;
                            }
                            if (j2 - j > j - j3) {
                                while (true) {
                                    int i2 = segment2.limit;
                                    int i3 = segment2.pos;
                                    if (j < (i2 - i3) + j3) {
                                        break;
                                    }
                                    j3 += i2 - i3;
                                    segment2 = segment2.next;
                                }
                            } else {
                                while (j2 > j) {
                                    segment = segment.prev;
                                    j2 -= segment.limit - segment.pos;
                                }
                                segment2 = segment;
                                j3 = j2;
                            }
                            if (this.readWrite && segment2.shared) {
                                Segment unsharedCopy = segment2.unsharedCopy();
                                Buffer buffer2 = this.buffer;
                                if (buffer2.head == segment2) {
                                    buffer2.head = unsharedCopy;
                                }
                                segment2 = segment2.push(unsharedCopy);
                                segment2.prev.pop();
                            }
                            this.segment = segment2;
                            this.offset = j;
                            this.data = segment2.data;
                            int i4 = segment2.pos + ((int) (j - j3));
                            this.start = i4;
                            int i5 = segment2.limit;
                            this.end = i5;
                            return i5 - i4;
                        }
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.buffer.size)));
            }
            return invokeJ.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1601546522, "Lokio/Buffer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1601546522, "Lokio/Buffer;");
                return;
            }
        }
        DIGITS = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Buffer clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Buffer buffer = new Buffer();
            if (this.size == 0) {
                return buffer;
            }
            Segment sharedCopy = this.head.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            Segment segment = this.head;
            while (true) {
                segment = segment.next;
                if (segment != this.head) {
                    buffer.head.prev.push(segment.sharedCopy());
                } else {
                    buffer.size = this.size;
                    return buffer;
                }
            }
        } else {
            return (Buffer) invokeV.objValue;
        }
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            long j = this.size;
            if (j != 0) {
                Segment segment = this.head;
                int i = segment.pos;
                int i2 = segment.limit;
                int i3 = i + 1;
                byte b = segment.data[i];
                this.size = j - 1;
                if (i3 == i2) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i3;
                }
                return b;
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.byteValue;
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            long indexOf = indexOf((byte) 10);
            if (indexOf == -1) {
                long j = this.size;
                if (j != 0) {
                    return readUtf8(j);
                }
                return null;
            }
            return readUtf8Line(indexOf);
        }
        return (String) invokeV.objValue;
    }

    public List<Integer> segmentSizes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (this.head == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Segment segment = this.head;
            arrayList.add(Integer.valueOf(segment.limit - segment.pos));
            Segment segment2 = this.head;
            while (true) {
                segment2 = segment2.next;
                if (segment2 != this.head) {
                    arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
                } else {
                    return arrayList;
                }
            }
        } else {
            return (List) invokeV.objValue;
        }
    }

    public final ByteString snapshot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            long j = this.size;
            if (j <= 2147483647L) {
                return snapshot((int) j);
            }
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
        }
        return (ByteString) invokeV.objValue;
    }

    public Buffer() {
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

    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                skip(this.size);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
    }

    public final long completeSegmentByteCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j = this.size;
            if (j == 0) {
                return 0L;
            }
            Segment segment = this.head.prev;
            int i = segment.limit;
            if (i < 8192 && segment.owner) {
                return j - (i - segment.pos);
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.size == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Segment segment = this.head;
            if (segment == null) {
                return 0;
            }
            int i = 1;
            do {
                int i2 = segment.limit;
                for (int i3 = segment.pos; i3 < i2; i3++) {
                    i = (i * 31) + segment.data[i3];
                }
                segment = segment.next;
            } while (segment != this.head);
            return i;
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return new InputStream(this) { // from class: okio.Buffer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Buffer this$0;

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.io.InputStream
                public int available() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        return (int) Math.min(this.this$0.size, 2147483647L);
                    }
                    return invokeV2.intValue;
                }

                @Override // java.io.InputStream
                public int read() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Buffer buffer = this.this$0;
                        if (buffer.size > 0) {
                            return buffer.readByte() & 255;
                        }
                        return -1;
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
                public int read(byte[] bArr, int i, int i2) {
                    InterceptResult invokeLII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048579, this, bArr, i, i2)) == null) {
                        return this.this$0.read(bArr, i, i2);
                    }
                    return invokeLII.intValue;
                }
            };
        }
        return (InputStream) invokeV.objValue;
    }

    public final ByteString md5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return digest("MD5");
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return new OutputStream(this) { // from class: okio.Buffer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Buffer this$0;

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.io.OutputStream
                public void write(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048579, this, i) == null) {
                        this.this$0.writeByte((int) ((byte) i));
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
                public void write(byte[] bArr, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(1048580, this, bArr, i, i2) == null) {
                        this.this$0.write(bArr, i, i2);
                    }
                }
            };
        }
        return (OutputStream) invokeV.objValue;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return readAndWriteUnsafe(new UnsafeCursor());
        }
        return (UnsafeCursor) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            try {
                return readByteArray(this.size);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return new ByteString(readByteArray());
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return Util.reverseBytesInt(readInt());
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return Util.reverseBytesLong(readLong());
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return Util.reverseBytesShort(readShort());
        }
        return invokeV.shortValue;
    }

    public final UnsafeCursor readUnsafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return readUnsafe(new UnsafeCursor());
        }
        return (UnsafeCursor) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            try {
                return readString(this.size, Util.UTF_8);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return readUtf8LineStrict(Long.MAX_VALUE);
        }
        return (String) invokeV.objValue;
    }

    public final ByteString sha1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return digest("SHA-1");
        }
        return (ByteString) invokeV.objValue;
    }

    public final ByteString sha256() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return digest("SHA-256");
        }
        return (ByteString) invokeV.objValue;
    }

    public final ByteString sha512() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return digest("SHA-512");
        }
        return (ByteString) invokeV.objValue;
    }

    public final long size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.size;
        }
        return invokeV.longValue;
    }

    @Override // okio.Source
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return Timeout.NONE;
        }
        return (Timeout) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return snapshot().toString();
        }
        return (String) invokeV.objValue;
    }

    private ByteString digest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (this.head != null) {
                    messageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                    Segment segment = this.head;
                    while (true) {
                        segment = segment.next;
                        if (segment == this.head) {
                            break;
                        }
                        messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
                    }
                }
                return ByteString.of(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
                throw new AssertionError();
            }
        }
        return (ByteString) invokeL.objValue;
    }

    public final byte getByte(long j) {
        InterceptResult invokeJ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
            Util.checkOffsetAndCount(this.size, j, 1L);
            long j2 = this.size;
            if (j2 - j > j) {
                Segment segment = this.head;
                while (true) {
                    int i2 = segment.limit;
                    int i3 = segment.pos;
                    long j3 = i2 - i3;
                    if (j < j3) {
                        return segment.data[i3 + ((int) j)];
                    }
                    j -= j3;
                    segment = segment.next;
                }
            } else {
                long j4 = j - j2;
                Segment segment2 = this.head;
                do {
                    segment2 = segment2.prev;
                    int i4 = segment2.limit;
                    i = segment2.pos;
                    j4 += i4 - i;
                } while (j4 < 0);
                return segment2.data[i + ((int) j4)];
            }
        } else {
            return invokeJ.byteValue;
        }
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        Segment segment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048653, this, j) == null) {
            while (j > 0) {
                if (this.head != null) {
                    int min = (int) Math.min(j, segment.limit - segment.pos);
                    long j2 = min;
                    this.size -= j2;
                    j -= j2;
                    Segment segment2 = this.head;
                    int i = segment2.pos + min;
                    segment2.pos = i;
                    if (i == segment2.limit) {
                        this.head = segment2.pop();
                        SegmentPool.recycle(segment2);
                    }
                } else {
                    throw new EOFException();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048673, this, j)) == null) {
            if (j == 0) {
                return writeByte(48);
            }
            int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
            Segment writableSegment = writableSegment(numberOfTrailingZeros);
            byte[] bArr = writableSegment.data;
            int i = writableSegment.limit;
            for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
                bArr[i2] = DIGITS[(int) (15 & j)];
                j >>>= 4;
            }
            writableSegment.limit += numberOfTrailingZeros;
            this.size += numberOfTrailingZeros;
            return this;
        }
        return (Buffer) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048675, this, i)) == null) {
            Segment writableSegment = writableSegment(4);
            byte[] bArr = writableSegment.data;
            int i2 = writableSegment.limit;
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((i >>> 24) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i >>> 16) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i >>> 8) & 255);
            bArr[i5] = (byte) (i & 255);
            writableSegment.limit = i5 + 1;
            this.size += 4;
            return this;
        }
        return (Buffer) invokeI.objValue;
    }

    private ByteString hmac(String str, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, byteString)) == null) {
            try {
                Mac mac = Mac.getInstance(str);
                mac.init(new SecretKeySpec(byteString.toByteArray(), str));
                if (this.head != null) {
                    mac.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                    Segment segment = this.head;
                    while (true) {
                        segment = segment.next;
                        if (segment == this.head) {
                            break;
                        }
                        mac.update(segment.data, segment.pos, segment.limit - segment.pos);
                    }
                }
                return ByteString.of(mac.doFinal());
            } catch (InvalidKeyException e) {
                throw new IllegalArgumentException(e);
            } catch (NoSuchAlgorithmException unused) {
                throw new AssertionError();
            }
        }
        return (ByteString) invokeLL.objValue;
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048633, this, j, charset)) == null) {
            Util.checkOffsetAndCount(this.size, 0L, j);
            if (charset != null) {
                if (j <= 2147483647L) {
                    if (j == 0) {
                        return "";
                    }
                    Segment segment = this.head;
                    if (segment.pos + j > segment.limit) {
                        return new String(readByteArray(j), charset);
                    }
                    String str = new String(segment.data, segment.pos, (int) j, charset);
                    int i = (int) (segment.pos + j);
                    segment.pos = i;
                    this.size -= j;
                    if (i == segment.limit) {
                        this.head = segment.pop();
                        SegmentPool.recycle(segment);
                    }
                    return str;
                }
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeJL.objValue;
    }

    private boolean rangeEquals(Segment segment, int i, ByteString byteString, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{segment, Integer.valueOf(i), byteString, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int i4 = segment.limit;
            byte[] bArr = segment.data;
            while (i2 < i3) {
                if (i == i4) {
                    segment = segment.next;
                    bArr = segment.data;
                    i = segment.pos;
                    i4 = segment.limit;
                }
                if (bArr[i] != byteString.getByte(i2)) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{inputStream, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (inputStream == null) {
                throw new IllegalArgumentException("in == null");
            }
            while (true) {
                if (j <= 0 && !z) {
                    return;
                }
                Segment writableSegment = writableSegment(1);
                int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
                if (read == -1) {
                    if (z) {
                        return;
                    }
                    throw new EOFException();
                }
                writableSegment.limit += read;
                long j2 = read;
                this.size += j2;
                j -= j2;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{outputStream, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (outputStream != null) {
                Util.checkOffsetAndCount(this.size, j, j2);
                if (j2 == 0) {
                    return this;
                }
                Segment segment = this.head;
                while (true) {
                    int i2 = segment.limit;
                    int i3 = segment.pos;
                    if (j < i2 - i3) {
                        break;
                    }
                    j -= i2 - i3;
                    segment = segment.next;
                }
                while (j2 > 0) {
                    int min = (int) Math.min(segment.limit - i, j2);
                    outputStream.write(segment.data, (int) (segment.pos + j), min);
                    j2 -= min;
                    segment = segment.next;
                    j = 0;
                }
                return this;
            }
            throw new IllegalArgumentException("out == null");
        }
        return (Buffer) invokeCommon.objValue;
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, outputStream)) == null) {
            return copyTo(outputStream, 0L, this.size);
        }
        return (Buffer) invokeL.objValue;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, byteString)) == null) {
            return hmac("HmacSHA1", byteString);
        }
        return (ByteString) invokeL.objValue;
    }

    public final ByteString hmacSha256(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, byteString)) == null) {
            return hmac("HmacSHA256", byteString);
        }
        return (ByteString) invokeL.objValue;
    }

    public final ByteString hmacSha512(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, byteString)) == null) {
            return hmac("HmacSHA512", byteString);
        }
        return (ByteString) invokeL.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048596, this, b)) == null) {
            return indexOf(b, 0L, Long.MAX_VALUE);
        }
        return invokeB.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, byteString)) == null) {
            return indexOfElement(byteString, 0L);
        }
        return invokeL.longValue;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, bArr)) == null) {
            return read(bArr, 0, bArr.length);
        }
        return invokeL.intValue;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, sink)) == null) {
            long j = this.size;
            if (j > 0) {
                sink.write(this, j);
            }
            return j;
        }
        return invokeL.longValue;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, unsafeCursor)) == null) {
            if (unsafeCursor.buffer == null) {
                unsafeCursor.buffer = this;
                unsafeCursor.readWrite = true;
                return unsafeCursor;
            }
            throw new IllegalStateException("already attached to a buffer");
        }
        return (UnsafeCursor) invokeL.objValue;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048620, this, j)) == null) {
            return new ByteString(readByteArray(j));
        }
        return (ByteString) invokeJ.objValue;
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, inputStream)) == null) {
            readFrom(inputStream, Long.MAX_VALUE, true);
            return this;
        }
        return (Buffer) invokeL.objValue;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bArr) == null) {
            int i = 0;
            while (i < bArr.length) {
                int read = read(bArr, i, bArr.length - i);
                if (read != -1) {
                    i += read;
                } else {
                    throw new EOFException();
                }
            }
        }
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, charset)) == null) {
            try {
                return readString(this.size, charset);
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
        return (String) invokeL.objValue;
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, unsafeCursor)) == null) {
            if (unsafeCursor.buffer == null) {
                unsafeCursor.buffer = this;
                unsafeCursor.readWrite = false;
                return unsafeCursor;
            }
            throw new IllegalStateException("already attached to a buffer");
        }
        return (UnsafeCursor) invokeL.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048638, this, j)) == null) {
            return readString(j, Util.UTF_8);
        }
        return (String) invokeJ.objValue;
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048644, this, j)) == null) {
            if (this.size >= j) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048645, this, j) != null) || this.size >= j) {
            return;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, options)) == null) {
            int selectPrefix = selectPrefix(options, false);
            if (selectPrefix == -1) {
                return -1;
            }
            try {
                skip(options.byteStrings[selectPrefix].size());
                return selectPrefix;
            } catch (EOFException unused) {
                throw new AssertionError();
            }
        }
        return invokeL.intValue;
    }

    public final ByteString snapshot(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048655, this, i)) == null) {
            if (i == 0) {
                return ByteString.EMPTY;
            }
            return new SegmentedByteString(this, i);
        }
        return (ByteString) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, byteString)) == null) {
            if (byteString != null) {
                byteString.write(this);
                return this;
            }
            throw new IllegalArgumentException("byteString == null");
        }
        return (Buffer) invokeL.objValue;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, source)) == null) {
            if (source != null) {
                long j = 0;
                while (true) {
                    long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                    if (read != -1) {
                        j += read;
                    } else {
                        return j;
                    }
                }
            } else {
                throw new IllegalArgumentException("source == null");
            }
        } else {
            return invokeL.longValue;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048669, this, i)) == null) {
            Segment writableSegment = writableSegment(1);
            byte[] bArr = writableSegment.data;
            int i2 = writableSegment.limit;
            writableSegment.limit = i2 + 1;
            bArr[i2] = (byte) i;
            this.size++;
            return this;
        }
        return (Buffer) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048677, this, i)) == null) {
            return writeInt(Util.reverseBytesInt(i));
        }
        return (Buffer) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048681, this, j)) == null) {
            return writeLong(Util.reverseBytesLong(j));
        }
        return (Buffer) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048685, this, i)) == null) {
            return writeShort((int) Util.reverseBytesShort((short) i));
        }
        return (Buffer) invokeI.objValue;
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, outputStream)) == null) {
            return writeTo(outputStream, this.size);
        }
        return (Buffer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, str)) == null) {
            return writeUtf8(str, 0, str.length());
        }
        return (Buffer) invokeL.objValue;
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{buffer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (buffer != null) {
                Util.checkOffsetAndCount(this.size, j, j2);
                if (j2 == 0) {
                    return this;
                }
                buffer.size += j2;
                Segment segment = this.head;
                while (true) {
                    int i = segment.limit;
                    int i2 = segment.pos;
                    if (j < i - i2) {
                        break;
                    }
                    j -= i - i2;
                    segment = segment.next;
                }
                while (j2 > 0) {
                    Segment sharedCopy = segment.sharedCopy();
                    int i3 = (int) (sharedCopy.pos + j);
                    sharedCopy.pos = i3;
                    sharedCopy.limit = Math.min(i3 + ((int) j2), sharedCopy.limit);
                    Segment segment2 = buffer.head;
                    if (segment2 == null) {
                        sharedCopy.prev = sharedCopy;
                        sharedCopy.next = sharedCopy;
                        buffer.head = sharedCopy;
                    } else {
                        segment2.prev.push(sharedCopy);
                    }
                    j2 -= sharedCopy.limit - sharedCopy.pos;
                    segment = segment.next;
                    j = 0;
                }
                return this;
            }
            throw new IllegalArgumentException("out == null");
        }
        return (Buffer) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Buffer)) {
                return false;
            }
            Buffer buffer = (Buffer) obj;
            long j = this.size;
            if (j != buffer.size) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.head;
            Segment segment2 = buffer.head;
            int i = segment.pos;
            int i2 = segment2.pos;
            while (j2 < this.size) {
                long min = Math.min(segment.limit - i, segment2.limit - i2);
                int i3 = 0;
                while (i3 < min) {
                    int i4 = i + 1;
                    int i5 = i2 + 1;
                    if (segment.data[i] != segment2.data[i2]) {
                        return false;
                    }
                    i3++;
                    i = i4;
                    i2 = i5;
                }
                if (i == segment.limit) {
                    segment = segment.next;
                    i = segment.pos;
                }
                if (i2 == segment2.limit) {
                    segment2 = segment2.next;
                    i2 = segment2.pos;
                }
                j2 += min;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048679, this, j)) == null) {
            Segment writableSegment = writableSegment(8);
            byte[] bArr = writableSegment.data;
            int i = writableSegment.limit;
            int i2 = i + 1;
            bArr[i] = (byte) ((j >>> 56) & 255);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((j >>> 48) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((j >>> 40) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((j >>> 32) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j >>> 24) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j >>> 16) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j >>> 8) & 255);
            bArr[i8] = (byte) (j & 255);
            writableSegment.limit = i8 + 1;
            this.size += 8;
            return this;
        }
        return (Buffer) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048697, this, i)) == null) {
            if (i < 128) {
                writeByte(i);
            } else if (i < 2048) {
                writeByte((i >> 6) | 192);
                writeByte((i & 63) | 128);
            } else if (i < 65536) {
                if (i >= 55296 && i <= 57343) {
                    writeByte(63);
                } else {
                    writeByte((i >> 12) | 224);
                    writeByte(((i >> 6) & 63) | 128);
                    writeByte((i & 63) | 128);
                }
            } else if (i <= 1114111) {
                writeByte((i >> 18) | 240);
                writeByte(((i >> 12) & 63) | 128);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            return this;
        }
        return (Buffer) invokeI.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Byte.valueOf(b), Long.valueOf(j)})) == null) {
            return indexOf(b, j, Long.MAX_VALUE);
        }
        return invokeCommon.longValue;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048607, this, j, byteString)) == null) {
            return rangeEquals(j, byteString, 0, byteString.size());
        }
        return invokeJL.booleanValue;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048624, this, buffer, j) == null) {
            long j2 = this.size;
            if (j2 >= j) {
                buffer.write(this, j);
            } else {
                buffer.write(this, j2);
                throw new EOFException();
            }
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048664, this, source, j)) == null) {
            while (j > 0) {
                long read = source.read(this, j);
                if (read != -1) {
                    j -= read;
                } else {
                    throw new EOFException();
                }
            }
            return this;
        }
        return (BufferedSink) invokeLJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048688, this, str, charset)) == null) {
            return writeString(str, 0, str.length(), charset);
        }
        return (Buffer) invokeLL.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        InterceptResult invokeCommon;
        Segment segment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Byte.valueOf(b), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = 0;
            if (j >= 0 && j2 >= j) {
                long j4 = this.size;
                if (j2 <= j4) {
                    j4 = j2;
                }
                if (j == j4 || (segment = this.head) == null) {
                    return -1L;
                }
                long j5 = this.size;
                if (j5 - j < j) {
                    while (j5 > j) {
                        segment = segment.prev;
                        j5 -= segment.limit - segment.pos;
                    }
                } else {
                    while (true) {
                        long j6 = (segment.limit - segment.pos) + j3;
                        if (j6 >= j) {
                            break;
                        }
                        segment = segment.next;
                        j3 = j6;
                    }
                    j5 = j3;
                }
                long j7 = j;
                while (j5 < j4) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + j4) - j5);
                    for (int i = (int) ((segment.pos + j7) - j5); i < min; i++) {
                        if (bArr[i] == b) {
                            return (i - segment.pos) + j5;
                        }
                    }
                    j5 += segment.limit - segment.pos;
                    segment = segment.next;
                    j7 = j5;
                }
                return -1L;
            }
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)));
        }
        return invokeCommon.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, byteString)) == null) {
            return indexOf(byteString, 0L);
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, bArr)) == null) {
            if (bArr != null) {
                return write(bArr, 0, bArr.length);
            }
            throw new IllegalArgumentException("source == null");
        }
        return (Buffer) invokeL.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        InterceptResult invokeLJ;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, byteString, j)) == null) {
            if (byteString.size() != 0) {
                long j2 = 0;
                if (j >= 0) {
                    Segment segment = this.head;
                    long j3 = -1;
                    if (segment == null) {
                        return -1L;
                    }
                    long j4 = this.size;
                    if (j4 - j < j) {
                        while (j4 > j) {
                            segment = segment.prev;
                            j4 -= segment.limit - segment.pos;
                        }
                    } else {
                        while (true) {
                            long j5 = (segment.limit - segment.pos) + j2;
                            if (j5 >= j) {
                                break;
                            }
                            segment = segment.next;
                            j2 = j5;
                        }
                        j4 = j2;
                    }
                    byte b = byteString.getByte(0);
                    int size = byteString.size();
                    long j6 = 1 + (this.size - size);
                    long j7 = j;
                    Segment segment2 = segment;
                    long j8 = j4;
                    while (j8 < j6) {
                        byte[] bArr2 = segment2.data;
                        int min = (int) Math.min(segment2.limit, (segment2.pos + j6) - j8);
                        int i = (int) ((segment2.pos + j7) - j8);
                        while (i < min) {
                            if (bArr2[i] == b) {
                                bArr = bArr2;
                                if (rangeEquals(segment2, i + 1, byteString, 1, size)) {
                                    return (i - segment2.pos) + j8;
                                }
                            } else {
                                bArr = bArr2;
                            }
                            i++;
                            bArr2 = bArr;
                        }
                        j8 += segment2.limit - segment2.pos;
                        segment2 = segment2.next;
                        j7 = j8;
                        j3 = -1;
                    }
                    return j3;
                }
                throw new IllegalArgumentException("fromIndex < 0");
            }
            throw new IllegalArgumentException("bytes is empty");
        }
        return invokeLJ.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        InterceptResult invokeLJ;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048602, this, byteString, j)) == null) {
            long j2 = 0;
            if (j >= 0) {
                Segment segment = this.head;
                if (segment == null) {
                    return -1L;
                }
                long j3 = this.size;
                if (j3 - j < j) {
                    while (j3 > j) {
                        segment = segment.prev;
                        j3 -= segment.limit - segment.pos;
                    }
                } else {
                    while (true) {
                        long j4 = (segment.limit - segment.pos) + j2;
                        if (j4 >= j) {
                            break;
                        }
                        segment = segment.next;
                        j2 = j4;
                    }
                    j3 = j2;
                }
                if (byteString.size() == 2) {
                    byte b = byteString.getByte(0);
                    byte b2 = byteString.getByte(1);
                    while (j3 < this.size) {
                        byte[] bArr = segment.data;
                        i = (int) ((segment.pos + j) - j3);
                        int i3 = segment.limit;
                        while (i < i3) {
                            byte b3 = bArr[i];
                            if (b3 != b && b3 != b2) {
                                i++;
                            } else {
                                i2 = segment.pos;
                                return (i - i2) + j3;
                            }
                        }
                        j3 += segment.limit - segment.pos;
                        segment = segment.next;
                        j = j3;
                    }
                    return -1L;
                }
                byte[] internalArray = byteString.internalArray();
                while (j3 < this.size) {
                    byte[] bArr2 = segment.data;
                    i = (int) ((segment.pos + j) - j3);
                    int i4 = segment.limit;
                    while (i < i4) {
                        byte b4 = bArr2[i];
                        for (byte b5 : internalArray) {
                            if (b4 == b5) {
                                i2 = segment.pos;
                                return (i - i2) + j3;
                            }
                        }
                        i++;
                    }
                    j3 += segment.limit - segment.pos;
                    segment = segment.next;
                    j = j3;
                }
                return -1L;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        return invokeLJ.longValue;
    }

    public int selectPrefix(Options options, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        Segment segment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048648, this, options, z)) == null) {
            Segment segment2 = this.head;
            int i5 = -2;
            if (segment2 == null) {
                if (z) {
                    return -2;
                }
                return options.indexOf(ByteString.EMPTY);
            }
            byte[] bArr = segment2.data;
            int i6 = segment2.pos;
            int i7 = segment2.limit;
            int[] iArr = options.trie;
            Segment segment3 = segment2;
            int i8 = 0;
            int i9 = -1;
            loop0: while (true) {
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (segment3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = i12 + (i11 * (-1));
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr[i6] & 255) != iArr[i12]) {
                            return i9;
                        }
                        if (i16 == i14) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (i15 == i7) {
                            Segment segment4 = segment3.next;
                            i4 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i3 = segment4.limit;
                            if (segment4 == segment2) {
                                if (!z2) {
                                    break loop0;
                                }
                                bArr = bArr2;
                                segment = null;
                            } else {
                                segment = segment4;
                                bArr = bArr2;
                            }
                        } else {
                            Segment segment5 = segment3;
                            i3 = i7;
                            i4 = i15;
                            segment = segment5;
                        }
                        if (z2) {
                            i = iArr[i16];
                            i2 = i4;
                            i7 = i3;
                            segment3 = segment;
                            break;
                        }
                        i6 = i4;
                        i7 = i3;
                        i12 = i16;
                        segment3 = segment;
                    }
                } else {
                    int i17 = i6 + 1;
                    int i18 = bArr[i6] & 255;
                    int i19 = i12 + i11;
                    while (i12 != i19) {
                        if (i18 == iArr[i12]) {
                            i = iArr[i12 + i11];
                            if (i17 == i7) {
                                segment3 = segment3.next;
                                i2 = segment3.pos;
                                bArr = segment3.data;
                                i7 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            } else {
                                i2 = i17;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                if (i >= 0) {
                    return i;
                }
                i8 = -i;
                i6 = i2;
                i5 = -2;
            }
            if (z) {
                return i5;
            }
            return i9;
        }
        return invokeLZ.intValue;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        Segment segment;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048667, this, buffer, j) == null) {
            if (buffer != null) {
                if (buffer != this) {
                    Util.checkOffsetAndCount(buffer.size, 0L, j);
                    while (j > 0) {
                        Segment segment2 = buffer.head;
                        if (j < segment2.limit - segment2.pos) {
                            Segment segment3 = this.head;
                            if (segment3 != null) {
                                segment = segment3.prev;
                            } else {
                                segment = null;
                            }
                            if (segment != null && segment.owner) {
                                long j2 = segment.limit + j;
                                if (segment.shared) {
                                    i = 0;
                                } else {
                                    i = segment.pos;
                                }
                                if (j2 - i <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                                    buffer.head.writeTo(segment, (int) j);
                                    buffer.size -= j;
                                    this.size += j;
                                    return;
                                }
                            }
                            buffer.head = buffer.head.split((int) j);
                        }
                        Segment segment4 = buffer.head;
                        long j3 = segment4.limit - segment4.pos;
                        buffer.head = segment4.pop();
                        Segment segment5 = this.head;
                        if (segment5 == null) {
                            this.head = segment4;
                            segment4.prev = segment4;
                            segment4.next = segment4;
                        } else {
                            segment5.prev.push(segment4).compact();
                        }
                        buffer.size -= j3;
                        this.size += j3;
                        j -= j3;
                    }
                    return;
                }
                throw new IllegalArgumentException("source == this");
            }
            throw new IllegalArgumentException("source == null");
        }
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j), byteString, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (j < 0 || i < 0 || i2 < 0 || this.size - j < i2 || byteString.size() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                if (getByte(i3 + j) != byteString.getByte(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, byteBuffer)) == null) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
            byteBuffer.put(segment.data, segment.pos, min);
            int i = segment.pos + min;
            segment.pos = i;
            this.size -= min;
            if (i == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return min;
        }
        return invokeL.intValue;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048618, this, j)) == null) {
            Util.checkOffsetAndCount(this.size, 0L, j);
            if (j <= 2147483647L) {
                byte[] bArr = new byte[(int) j];
                readFully(bArr);
                return bArr;
            }
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        return (byte[]) invokeJ.objValue;
    }

    public String readUtf8Line(long j) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048641, this, j)) == null) {
            if (j > 0) {
                long j2 = j - 1;
                if (getByte(j2) == 13) {
                    String readUtf8 = readUtf8(j2);
                    skip(2L);
                    return readUtf8;
                }
            }
            String readUtf82 = readUtf8(j);
            skip(1L);
            return readUtf82;
        }
        return (String) invokeJ.objValue;
    }

    public Segment writableSegment(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i)) == null) {
            if (i >= 1 && i <= 8192) {
                Segment segment = this.head;
                if (segment == null) {
                    Segment take = SegmentPool.take();
                    this.head = take;
                    take.prev = take;
                    take.next = take;
                    return take;
                }
                Segment segment2 = segment.prev;
                if (segment2.limit + i > 8192 || !segment2.owner) {
                    return segment2.push(SegmentPool.take());
                }
                return segment2;
            }
            throw new IllegalArgumentException();
        }
        return (Segment) invokeI.objValue;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, byteBuffer)) == null) {
            if (byteBuffer != null) {
                int remaining = byteBuffer.remaining();
                int i = remaining;
                while (i > 0) {
                    Segment writableSegment = writableSegment(1);
                    int min = Math.min(i, 8192 - writableSegment.limit);
                    byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                    i -= min;
                    writableSegment.limit += min;
                }
                this.size += remaining;
                return remaining;
            }
            throw new IllegalArgumentException("source == null");
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048683, this, i)) == null) {
            Segment writableSegment = writableSegment(2);
            byte[] bArr = writableSegment.data;
            int i2 = writableSegment.limit;
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((i >>> 8) & 255);
            bArr[i3] = (byte) (i & 255);
            writableSegment.limit = i3 + 1;
            this.size += 2;
            return this;
        }
        return (Buffer) invokeI.objValue;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048611, this, bArr, i, i2)) == null) {
            Util.checkOffsetAndCount(bArr.length, i, i2);
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            int min = Math.min(i2, segment.limit - segment.pos);
            System.arraycopy(segment.data, segment.pos, bArr, i, min);
            int i3 = segment.pos + min;
            segment.pos = i3;
            this.size -= min;
            if (i3 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return min;
        }
        return invokeLII.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048662, this, bArr, i, i2)) == null) {
            if (bArr != null) {
                long j = i2;
                Util.checkOffsetAndCount(bArr.length, i, j);
                int i3 = i2 + i;
                while (i < i3) {
                    Segment writableSegment = writableSegment(1);
                    int min = Math.min(i3 - i, 8192 - writableSegment.limit);
                    System.arraycopy(bArr, i, writableSegment.data, writableSegment.limit, min);
                    i += min;
                    writableSegment.limit += min;
                }
                this.size += j;
                return this;
            }
            throw new IllegalArgumentException("source == null");
        }
        return (Buffer) invokeLII.objValue;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048612, this, buffer, j)) == null) {
            if (buffer != null) {
                if (j >= 0) {
                    long j2 = this.size;
                    if (j2 == 0) {
                        return -1L;
                    }
                    if (j > j2) {
                        j = j2;
                    }
                    buffer.write(this, j);
                    return j;
                }
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            throw new IllegalArgumentException("sink == null");
        }
        return invokeLJ.longValue;
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048692, this, outputStream, j)) == null) {
            if (outputStream != null) {
                Util.checkOffsetAndCount(this.size, 0L, j);
                Segment segment = this.head;
                while (j > 0) {
                    int min = (int) Math.min(j, segment.limit - segment.pos);
                    outputStream.write(segment.data, segment.pos, min);
                    int i = segment.pos + min;
                    segment.pos = i;
                    long j2 = min;
                    this.size -= j2;
                    j -= j2;
                    if (i == segment.limit) {
                        Segment pop = segment.pop();
                        this.head = pop;
                        SegmentPool.recycle(segment);
                        segment = pop;
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("out == null");
        }
        return (Buffer) invokeLJ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bd, code lost:
        r17.size -= r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c3, code lost:
        if (r8 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c7, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readDecimalLong() {
        InterceptResult invokeV;
        byte b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            long j = 0;
            if (this.size != 0) {
                long j2 = -922337203685477580L;
                long j3 = -7;
                int i = 0;
                boolean z = false;
                boolean z2 = false;
                loop0: while (true) {
                    Segment segment = this.head;
                    byte[] bArr = segment.data;
                    int i2 = segment.pos;
                    int i3 = segment.limit;
                    while (i2 < i3) {
                        b = bArr[i2];
                        if (b >= 48 && b <= 57) {
                            int i4 = 48 - b;
                            int i5 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                            if (i5 < 0 || (i5 == 0 && i4 < j3)) {
                                break loop0;
                            }
                            j = (j * 10) + i4;
                        } else if (b == 45 && i == 0) {
                            j3--;
                            z = true;
                        } else if (i != 0) {
                            z2 = true;
                            if (i2 != i3) {
                                this.head = segment.pop();
                                SegmentPool.recycle(segment);
                            } else {
                                segment.pos = i2;
                            }
                            if (!!z2 || this.head == null) {
                                break;
                            }
                            j2 = -922337203685477580L;
                        } else {
                            throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b));
                        }
                        i2++;
                        i++;
                        j2 = -922337203685477580L;
                    }
                    if (i2 != i3) {
                    }
                    if (!z2) {
                        break;
                    }
                    break;
                }
                Buffer writeByte = new Buffer().writeDecimalLong(j).writeByte((int) b);
                if (!z) {
                    writeByte.readByte();
                }
                throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.longValue;
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048623, this, inputStream, j)) == null) {
            if (j >= 0) {
                readFrom(inputStream, j, false);
                return this;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        return (Buffer) invokeLJ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9 A[EDGE_INSN: B:49:0x00a9->B:40:0x00a9 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readHexadecimalUnsignedLong() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.size != 0) {
                int i3 = 0;
                long j = 0;
                boolean z = false;
                do {
                    Segment segment = this.head;
                    byte[] bArr = segment.data;
                    int i4 = segment.pos;
                    int i5 = segment.limit;
                    while (i4 < i5) {
                        byte b = bArr[i4];
                        if (b >= 48 && b <= 57) {
                            i2 = b - 48;
                        } else {
                            if (b >= 97 && b <= 102) {
                                i = b - 97;
                            } else if (b >= 65 && b <= 70) {
                                i = b - 65;
                            } else if (i3 != 0) {
                                z = true;
                                if (i4 != i5) {
                                    this.head = segment.pop();
                                    SegmentPool.recycle(segment);
                                } else {
                                    segment.pos = i4;
                                }
                                if (!z) {
                                    break;
                                }
                            } else {
                                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                            }
                            i2 = i + 10;
                        }
                        if (((-1152921504606846976L) & j) == 0) {
                            j = (j << 4) | i2;
                            i4++;
                            i3++;
                        } else {
                            Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b);
                            throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                        }
                    }
                    if (i4 != i5) {
                    }
                    if (!z) {
                    }
                } while (this.head != null);
                this.size -= i3;
                return j;
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public long readLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            long j = this.size;
            if (j >= 8) {
                Segment segment = this.head;
                int i = segment.pos;
                int i2 = segment.limit;
                if (i2 - i < 8) {
                    return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
                }
                byte[] bArr = segment.data;
                int i3 = i + 1;
                int i4 = i3 + 1;
                long j2 = (bArr[i3] & 255) << 48;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                long j3 = j2 | ((bArr[i] & 255) << 56) | ((bArr[i4] & 255) << 40) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
                this.size = j - 8;
                if (i10 == i2) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i10;
                }
                return j3;
            }
            throw new IllegalStateException("size < 8: " + this.size);
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.size != 0) {
                byte b = getByte(0L);
                if ((b & 128) == 0) {
                    i = b & ByteCompanionObject.MAX_VALUE;
                    i2 = 1;
                    i3 = 0;
                } else if ((b & 224) == 192) {
                    i = b & 31;
                    i2 = 2;
                    i3 = 128;
                } else if ((b & 240) == 224) {
                    i = b & 15;
                    i2 = 3;
                    i3 = 2048;
                } else if ((b & 248) == 240) {
                    i = b & 7;
                    i2 = 4;
                    i3 = 65536;
                } else {
                    skip(1L);
                    return REPLACEMENT_CHARACTER;
                }
                long j = i2;
                if (this.size >= j) {
                    for (int i4 = 1; i4 < i2; i4++) {
                        long j2 = i4;
                        byte b2 = getByte(j2);
                        if ((b2 & ExifInterface.MARKER_SOF0) == 128) {
                            i = (i << 6) | (b2 & 63);
                        } else {
                            skip(j2);
                            return REPLACEMENT_CHARACTER;
                        }
                    }
                    skip(j);
                    if (i > 1114111) {
                        return REPLACEMENT_CHARACTER;
                    }
                    if ((i >= 55296 && i <= 57343) || i < i3) {
                        return REPLACEMENT_CHARACTER;
                    }
                    return i;
                }
                throw new EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b) + SmallTailInfo.EMOTION_SUFFIX);
            }
            throw new EOFException();
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    public int readInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            long j = this.size;
            if (j >= 4) {
                Segment segment = this.head;
                int i = segment.pos;
                int i2 = segment.limit;
                if (i2 - i < 4) {
                    return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
                }
                byte[] bArr = segment.data;
                int i3 = i + 1;
                int i4 = i3 + 1;
                int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
                int i6 = i4 + 1;
                int i7 = i5 | ((bArr[i4] & 255) << 8);
                int i8 = i6 + 1;
                int i9 = i7 | (bArr[i6] & 255);
                this.size = j - 4;
                if (i8 == i2) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i8;
                }
                return i9;
            }
            throw new IllegalStateException("size < 4: " + this.size);
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    public short readShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            long j = this.size;
            if (j >= 2) {
                Segment segment = this.head;
                int i = segment.pos;
                int i2 = segment.limit;
                if (i2 - i < 2) {
                    return (short) (((readByte() & 255) << 8) | (readByte() & 255));
                }
                byte[] bArr = segment.data;
                int i3 = i + 1;
                int i4 = i3 + 1;
                int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
                this.size = j - 2;
                if (i4 == i2) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i4;
                }
                return (short) i5;
            }
            throw new IllegalStateException("size < 2: " + this.size);
        }
        return invokeV.shortValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048643, this, j)) == null) {
            if (j >= 0) {
                long j2 = Long.MAX_VALUE;
                if (j != Long.MAX_VALUE) {
                    j2 = j + 1;
                }
                long indexOf = indexOf((byte) 10, 0L, j2);
                if (indexOf != -1) {
                    return readUtf8Line(indexOf);
                }
                if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                    return readUtf8Line(j2);
                }
                Buffer buffer = new Buffer();
                copyTo(buffer, 0L, Math.min(32L, size()));
                throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
            }
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        return (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048671, this, j)) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i == 0) {
                return writeByte(48);
            }
            boolean z = false;
            int i2 = 1;
            if (i < 0) {
                j = -j;
                if (j < 0) {
                    return writeUtf8("-9223372036854775808");
                }
                z = true;
            }
            if (j < 100000000) {
                if (j < 10000) {
                    if (j < 100) {
                        if (j >= 10) {
                            i2 = 2;
                        }
                    } else if (j < 1000) {
                        i2 = 3;
                    } else {
                        i2 = 4;
                    }
                } else if (j < 1000000) {
                    if (j < 100000) {
                        i2 = 5;
                    } else {
                        i2 = 6;
                    }
                } else if (j < 10000000) {
                    i2 = 7;
                } else {
                    i2 = 8;
                }
            } else if (j < BasicLabelFormatter.TRILLION) {
                if (j < 10000000000L) {
                    if (j < 1000000000) {
                        i2 = 9;
                    } else {
                        i2 = 10;
                    }
                } else if (j < 100000000000L) {
                    i2 = 11;
                } else {
                    i2 = 12;
                }
            } else if (j < 1000000000000000L) {
                if (j < 10000000000000L) {
                    i2 = 13;
                } else if (j < 100000000000000L) {
                    i2 = 14;
                } else {
                    i2 = 15;
                }
            } else if (j < 100000000000000000L) {
                if (j < 10000000000000000L) {
                    i2 = 16;
                } else {
                    i2 = 17;
                }
            } else if (j < 1000000000000000000L) {
                i2 = 18;
            } else {
                i2 = 19;
            }
            if (z) {
                i2++;
            }
            Segment writableSegment = writableSegment(i2);
            byte[] bArr = writableSegment.data;
            int i3 = writableSegment.limit + i2;
            while (j != 0) {
                i3--;
                bArr[i3] = DIGITS[(int) (j % 10)];
                j /= 10;
            }
            if (z) {
                bArr[i3 - 1] = 45;
            }
            writableSegment.limit += i2;
            this.size += i2;
            return this;
        }
        return (Buffer) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048687, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), charset})) == null) {
            if (str != null) {
                if (i >= 0) {
                    if (i2 >= i) {
                        if (i2 <= str.length()) {
                            if (charset != null) {
                                if (charset.equals(Util.UTF_8)) {
                                    return writeUtf8(str, i, i2);
                                }
                                byte[] bytes = str.substring(i, i2).getBytes(charset);
                                return write(bytes, 0, bytes.length);
                            }
                            throw new IllegalArgumentException("charset == null");
                        }
                        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
                }
                throw new IllegalAccessError("beginIndex < 0: " + i);
            }
            throw new IllegalArgumentException("string == null");
        }
        return (Buffer) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        InterceptResult invokeLII;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048694, this, str, i, i2)) == null) {
            if (str != null) {
                if (i >= 0) {
                    if (i2 >= i) {
                        if (i2 <= str.length()) {
                            while (i < i2) {
                                char charAt = str.charAt(i);
                                if (charAt < 128) {
                                    Segment writableSegment = writableSegment(1);
                                    byte[] bArr = writableSegment.data;
                                    int i3 = writableSegment.limit - i;
                                    int min = Math.min(i2, 8192 - i3);
                                    int i4 = i + 1;
                                    bArr[i + i3] = (byte) charAt;
                                    while (i4 < min) {
                                        char charAt2 = str.charAt(i4);
                                        if (charAt2 >= 128) {
                                            break;
                                        }
                                        bArr[i4 + i3] = (byte) charAt2;
                                        i4++;
                                    }
                                    int i5 = writableSegment.limit;
                                    int i6 = (i3 + i4) - i5;
                                    writableSegment.limit = i5 + i6;
                                    this.size += i6;
                                    i = i4;
                                } else {
                                    if (charAt < 2048) {
                                        writeByte((charAt >> 6) | 192);
                                        writeByte((charAt & '?') | 128);
                                    } else if (charAt >= 55296 && charAt <= 57343) {
                                        int i7 = i + 1;
                                        if (i7 < i2) {
                                            c = str.charAt(i7);
                                        } else {
                                            c = 0;
                                        }
                                        if (charAt <= 56319 && c >= 56320 && c <= 57343) {
                                            int i8 = (((charAt & 10239) << 10) | (9215 & c)) + 65536;
                                            writeByte((i8 >> 18) | 240);
                                            writeByte(((i8 >> 12) & 63) | 128);
                                            writeByte(((i8 >> 6) & 63) | 128);
                                            writeByte((i8 & 63) | 128);
                                            i += 2;
                                        } else {
                                            writeByte(63);
                                            i = i7;
                                        }
                                    } else {
                                        writeByte((charAt >> '\f') | 224);
                                        writeByte(((charAt >> 6) & 63) | 128);
                                        writeByte((charAt & '?') | 128);
                                    }
                                    i++;
                                }
                            }
                            return this;
                        }
                        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
                }
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            }
            throw new IllegalArgumentException("string == null");
        }
        return (Buffer) invokeLII.objValue;
    }
}
