package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public final long expandBuffer(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 <= 0) {
                    throw new IllegalArgumentException("minByteCount <= 0: " + i2);
                } else if (i2 <= 8192) {
                    Buffer buffer = this.buffer;
                    if (buffer != null) {
                        if (this.readWrite) {
                            long j2 = buffer.size;
                            Segment writableSegment = buffer.writableSegment(i2);
                            int i3 = 8192 - writableSegment.limit;
                            writableSegment.limit = 8192;
                            long j3 = i3;
                            this.buffer.size = j2 + j3;
                            this.segment = writableSegment;
                            this.offset = j2;
                            this.data = writableSegment.data;
                            this.start = 8192 - i3;
                            this.end = 8192;
                            return j3;
                        }
                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                    }
                    throw new IllegalStateException("not attached to a buffer");
                } else {
                    throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i2);
                }
            }
            return invokeI.longValue;
        }

        public final int next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long j2 = this.offset;
                if (j2 != this.buffer.size) {
                    if (j2 == -1) {
                        return seek(0L);
                    }
                    return seek(j2 + (this.end - this.start));
                }
                throw new IllegalStateException();
            }
            return invokeV.intValue;
        }

        public final long resizeBuffer(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                Buffer buffer = this.buffer;
                if (buffer != null) {
                    if (this.readWrite) {
                        long j3 = buffer.size;
                        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i2 <= 0) {
                            if (j2 >= 0) {
                                long j4 = j3 - j2;
                                while (true) {
                                    if (j4 <= 0) {
                                        break;
                                    }
                                    Buffer buffer2 = this.buffer;
                                    Segment segment = buffer2.head.prev;
                                    int i3 = segment.limit;
                                    long j5 = i3 - segment.pos;
                                    if (j5 <= j4) {
                                        buffer2.head = segment.pop();
                                        SegmentPool.recycle(segment);
                                        j4 -= j5;
                                    } else {
                                        segment.limit = (int) (i3 - j4);
                                        break;
                                    }
                                }
                                this.segment = null;
                                this.offset = j2;
                                this.data = null;
                                this.start = -1;
                                this.end = -1;
                            } else {
                                throw new IllegalArgumentException("newSize < 0: " + j2);
                            }
                        } else if (i2 > 0) {
                            long j6 = j2 - j3;
                            boolean z = true;
                            while (j6 > 0) {
                                Segment writableSegment = this.buffer.writableSegment(1);
                                int min = (int) Math.min(j6, 8192 - writableSegment.limit);
                                int i4 = writableSegment.limit + min;
                                writableSegment.limit = i4;
                                j6 -= min;
                                if (z) {
                                    this.segment = writableSegment;
                                    this.offset = j3;
                                    this.data = writableSegment.data;
                                    this.start = i4 - min;
                                    this.end = i4;
                                    z = false;
                                }
                            }
                        }
                        this.buffer.size = j2;
                        return j3;
                    }
                    throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
                }
                throw new IllegalStateException("not attached to a buffer");
            }
            return invokeJ.longValue;
        }

        public final int seek(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                int i2 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
                if (i2 >= 0) {
                    Buffer buffer = this.buffer;
                    long j3 = buffer.size;
                    if (j2 <= j3) {
                        if (i2 != 0 && j2 != j3) {
                            long j4 = 0;
                            Segment segment = buffer.head;
                            Segment segment2 = this.segment;
                            if (segment2 != null) {
                                long j5 = this.offset - (this.start - segment2.pos);
                                if (j5 > j2) {
                                    j3 = j5;
                                    segment2 = segment;
                                    segment = segment2;
                                } else {
                                    j4 = j5;
                                }
                            } else {
                                segment2 = segment;
                            }
                            if (j3 - j2 > j2 - j4) {
                                while (true) {
                                    int i3 = segment2.limit;
                                    int i4 = segment2.pos;
                                    if (j2 < (i3 - i4) + j4) {
                                        break;
                                    }
                                    j4 += i3 - i4;
                                    segment2 = segment2.next;
                                }
                            } else {
                                while (j3 > j2) {
                                    segment = segment.prev;
                                    j3 -= segment.limit - segment.pos;
                                }
                                segment2 = segment;
                                j4 = j3;
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
                            this.offset = j2;
                            this.data = segment2.data;
                            int i5 = segment2.pos + ((int) (j2 - j4));
                            this.start = i5;
                            int i6 = segment2.limit;
                            this.end = i6;
                            return i6 - i5;
                        }
                        this.segment = null;
                        this.offset = j2;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j2), Long.valueOf(this.buffer.size)));
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

    public Buffer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
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
            } catch (InvalidKeyException e2) {
                throw new IllegalArgumentException(e2);
            } catch (NoSuchAlgorithmException unused) {
                throw new AssertionError();
            }
        }
        return (ByteString) invokeLL.objValue;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Buffer) invokeV.objValue;
    }

    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                skip(this.size);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final long completeSegmentByteCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j2 = this.size;
            if (j2 == 0) {
                return 0L;
            }
            Segment segment = this.head.prev;
            int i2 = segment.limit;
            return (i2 >= 8192 || !segment.owner) ? j2 : j2 - (i2 - segment.pos);
        }
        return invokeV.longValue;
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, outputStream)) == null) ? copyTo(outputStream, 0L, this.size) : (Buffer) invokeL.objValue;
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Buffer) {
                Buffer buffer = (Buffer) obj;
                long j2 = this.size;
                if (j2 != buffer.size) {
                    return false;
                }
                long j3 = 0;
                if (j2 == 0) {
                    return true;
                }
                Segment segment = this.head;
                Segment segment2 = buffer.head;
                int i2 = segment.pos;
                int i3 = segment2.pos;
                while (j3 < this.size) {
                    long min = Math.min(segment.limit - i2, segment2.limit - i3);
                    int i4 = 0;
                    while (i4 < min) {
                        int i5 = i2 + 1;
                        int i6 = i3 + 1;
                        if (segment.data[i2] != segment2.data[i3]) {
                            return false;
                        }
                        i4++;
                        i2 = i5;
                        i3 = i6;
                    }
                    if (i2 == segment.limit) {
                        segment = segment.next;
                        i2 = segment.pos;
                    }
                    if (i3 == segment2.limit) {
                        segment2 = segment2.next;
                        i3 = segment2.pos;
                    }
                    j3 += min;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.size == 0 : invokeV.booleanValue;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public final byte getByte(long j2) {
        InterceptResult invokeJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048591, this, j2)) != null) {
            return invokeJ.byteValue;
        }
        Util.checkOffsetAndCount(this.size, j2, 1L);
        long j3 = this.size;
        if (j3 - j2 > j2) {
            Segment segment = this.head;
            while (true) {
                int i3 = segment.limit;
                int i4 = segment.pos;
                long j4 = i3 - i4;
                if (j2 < j4) {
                    return segment.data[i4 + ((int) j2)];
                }
                j2 -= j4;
                segment = segment.next;
            }
        } else {
            long j5 = j2 - j3;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                int i5 = segment2.limit;
                i2 = segment2.pos;
                j5 += i5 - i2;
            } while (j5 < 0);
            return segment2.data[i2 + ((int) j5)];
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Segment segment = this.head;
            if (segment == null) {
                return 0;
            }
            int i2 = 1;
            do {
                int i3 = segment.limit;
                for (int i4 = segment.pos; i4 < i3; i4++) {
                    i2 = (i2 * 31) + segment.data[i4];
                }
                segment = segment.next;
            } while (segment != this.head);
            return i2;
        }
        return invokeV.intValue;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, byteString)) == null) ? hmac("HmacSHA1", byteString) : (ByteString) invokeL.objValue;
    }

    public final ByteString hmacSha256(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, byteString)) == null) ? hmac("HmacSHA256", byteString) : (ByteString) invokeL.objValue;
    }

    public final ByteString hmacSha512(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, byteString)) == null) ? hmac("HmacSHA512", byteString) : (ByteString) invokeL.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(1048596, this, b2)) == null) ? indexOf(b2, 0L, Long.MAX_VALUE) : invokeB.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, byteString)) == null) ? indexOfElement(byteString, 0L) : invokeL.longValue;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? new InputStream(this) { // from class: okio.Buffer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Buffer this$0;

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
            public int available() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? (int) Math.min(this.this$0.size, 2147483647L) : invokeV2.intValue;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
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
            public int read(byte[] bArr, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048579, this, bArr, i2, i3)) == null) ? this.this$0.read(bArr, i2, i3) : invokeLII.intValue;
            }
        } : (InputStream) invokeV.objValue;
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

    public final ByteString md5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? digest("MD5") : (ByteString) invokeV.objValue;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? new OutputStream(this) { // from class: okio.Buffer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Buffer this$0;

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

            public String toString() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.this$0 + ".outputStream()";
                }
                return (String) invokeV2.objValue;
            }

            @Override // java.io.OutputStream
            public void write(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048579, this, i2) == null) {
                    this.this$0.writeByte((int) ((byte) i2));
                }
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048580, this, bArr, i2, i3) == null) {
                    this.this$0.write(bArr, i2, i3);
                }
            }
        } : (OutputStream) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, ByteString byteString) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048607, this, j2, byteString)) == null) ? rangeEquals(j2, byteString, 0, byteString.size()) : invokeJL.booleanValue;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, bArr)) == null) ? read(bArr, 0, bArr.length) : invokeL.intValue;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, sink)) == null) {
            long j2 = this.size;
            if (j2 > 0) {
                sink.write(this, j2);
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? readAndWriteUnsafe(new UnsafeCursor()) : (UnsafeCursor) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            long j2 = this.size;
            if (j2 != 0) {
                Segment segment = this.head;
                int i2 = segment.pos;
                int i3 = segment.limit;
                int i4 = i2 + 1;
                byte b2 = segment.data[i2];
                this.size = j2 - 1;
                if (i4 == i3) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i4;
                }
                return b2;
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.byteValue;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            try {
                return readByteArray(this.size);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? new ByteString(readByteArray()) : (ByteString) invokeV.objValue;
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
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            long j2 = 0;
            if (this.size != 0) {
                long j3 = -922337203685477580L;
                long j4 = -7;
                int i2 = 0;
                boolean z = false;
                boolean z2 = false;
                loop0: while (true) {
                    Segment segment = this.head;
                    byte[] bArr = segment.data;
                    int i3 = segment.pos;
                    int i4 = segment.limit;
                    while (i3 < i4) {
                        b2 = bArr[i3];
                        if (b2 >= 48 && b2 <= 57) {
                            int i5 = 48 - b2;
                            int i6 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                            if (i6 < 0 || (i6 == 0 && i5 < j4)) {
                                break loop0;
                            }
                            j2 = (j2 * 10) + i5;
                        } else if (b2 == 45 && i2 == 0) {
                            j4--;
                            z = true;
                        } else if (i2 == 0) {
                            throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(b2));
                        } else {
                            z2 = true;
                            if (i3 != i4) {
                                this.head = segment.pop();
                                SegmentPool.recycle(segment);
                            } else {
                                segment.pos = i3;
                            }
                            if (!!z2 || this.head == null) {
                                break;
                            }
                            j3 = -922337203685477580L;
                        }
                        i3++;
                        i2++;
                        j3 = -922337203685477580L;
                    }
                    if (i3 != i4) {
                    }
                    if (!z2) {
                        break;
                    }
                    break;
                }
                Buffer writeByte = new Buffer().writeDecimalLong(j2).writeByte((int) b2);
                if (!z) {
                    writeByte.readByte();
                }
                throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.longValue;
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
    public void readFully(Buffer buffer, long j2) throws EOFException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048624, this, buffer, j2) == null) {
            long j3 = this.size;
            if (j3 >= j2) {
                buffer.write(this, j2);
            } else {
                buffer.write(this, j3);
                throw new EOFException();
            }
        }
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
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.size != 0) {
                int i4 = 0;
                long j2 = 0;
                boolean z = false;
                do {
                    Segment segment = this.head;
                    byte[] bArr = segment.data;
                    int i5 = segment.pos;
                    int i6 = segment.limit;
                    while (i5 < i6) {
                        byte b2 = bArr[i5];
                        if (b2 < 48 || b2 > 57) {
                            if (b2 >= 97 && b2 <= 102) {
                                i2 = b2 - 97;
                            } else if (b2 >= 65 && b2 <= 70) {
                                i2 = b2 - 65;
                            } else if (i4 == 0) {
                                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                            } else {
                                z = true;
                                if (i5 != i6) {
                                    this.head = segment.pop();
                                    SegmentPool.recycle(segment);
                                } else {
                                    segment.pos = i5;
                                }
                                if (!z) {
                                    break;
                                }
                            }
                            i3 = i2 + 10;
                        } else {
                            i3 = b2 - 48;
                        }
                        if (((-1152921504606846976L) & j2) != 0) {
                            Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j2).writeByte((int) b2);
                            throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                        }
                        j2 = (j2 << 4) | i3;
                        i5++;
                        i4++;
                    }
                    if (i5 != i6) {
                    }
                    if (!z) {
                    }
                } while (this.head != null);
                this.size -= i4;
                return j2;
            }
            throw new IllegalStateException("size == 0");
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public int readInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            long j2 = this.size;
            if (j2 >= 4) {
                Segment segment = this.head;
                int i2 = segment.pos;
                int i3 = segment.limit;
                if (i3 - i2 < 4) {
                    return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
                }
                byte[] bArr = segment.data;
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
                int i7 = i5 + 1;
                int i8 = i6 | ((bArr[i5] & 255) << 8);
                int i9 = i7 + 1;
                int i10 = i8 | (bArr[i7] & 255);
                this.size = j2 - 4;
                if (i9 == i3) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i9;
                }
                return i10;
            }
            throw new IllegalStateException("size < 4: " + this.size);
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? Util.reverseBytesInt(readInt()) : invokeV.intValue;
    }

    @Override // okio.BufferedSource
    public long readLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            long j2 = this.size;
            if (j2 >= 8) {
                Segment segment = this.head;
                int i2 = segment.pos;
                int i3 = segment.limit;
                if (i3 - i2 < 8) {
                    return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
                }
                byte[] bArr = segment.data;
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                long j3 = (bArr[i4] & 255) << 48;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                int i11 = i10 + 1;
                long j4 = j3 | ((bArr[i2] & 255) << 56) | ((bArr[i5] & 255) << 40) | ((bArr[i6] & 255) << 32) | ((bArr[i7] & 255) << 24) | ((bArr[i8] & 255) << 16) | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
                this.size = j2 - 8;
                if (i11 == i3) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i11;
                }
                return j4;
            }
            throw new IllegalStateException("size < 8: " + this.size);
        }
        return invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? Util.reverseBytesLong(readLong()) : invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public short readShort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            long j2 = this.size;
            if (j2 >= 2) {
                Segment segment = this.head;
                int i2 = segment.pos;
                int i3 = segment.limit;
                if (i3 - i2 < 2) {
                    return (short) (((readByte() & 255) << 8) | (readByte() & 255));
                }
                byte[] bArr = segment.data;
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
                this.size = j2 - 2;
                if (i5 == i3) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i5;
                }
                return (short) i6;
            }
            throw new IllegalStateException("size < 2: " + this.size);
        }
        return invokeV.shortValue;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? Util.reverseBytesShort(readShort()) : invokeV.shortValue;
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, charset)) == null) {
            try {
                return readString(this.size, charset);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public final UnsafeCursor readUnsafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? readUnsafe(new UnsafeCursor()) : (UnsafeCursor) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            try {
                return readString(this.size, Util.UTF_8);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.size != 0) {
                byte b2 = getByte(0L);
                if ((b2 & 128) == 0) {
                    i2 = b2 & ByteCompanionObject.MAX_VALUE;
                    i3 = 1;
                    i4 = 0;
                } else if ((b2 & 224) == 192) {
                    i2 = b2 & 31;
                    i3 = 2;
                    i4 = 128;
                } else if ((b2 & 240) == 224) {
                    i2 = b2 & 15;
                    i3 = 3;
                    i4 = 2048;
                } else if ((b2 & 248) != 240) {
                    skip(1L);
                    return REPLACEMENT_CHARACTER;
                } else {
                    i2 = b2 & 7;
                    i3 = 4;
                    i4 = 65536;
                }
                long j2 = i3;
                if (this.size >= j2) {
                    for (int i5 = 1; i5 < i3; i5++) {
                        long j3 = i5;
                        byte b3 = getByte(j3);
                        if ((b3 & 192) != 128) {
                            skip(j3);
                            return REPLACEMENT_CHARACTER;
                        }
                        i2 = (i2 << 6) | (b3 & 63);
                    }
                    skip(j2);
                    return i2 > 1114111 ? REPLACEMENT_CHARACTER : ((i2 < 55296 || i2 > 57343) && i2 >= i4) ? i2 : REPLACEMENT_CHARACTER;
                }
                throw new EOFException("size < " + i3 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b2) + SmallTailInfo.EMOTION_SUFFIX);
            }
            throw new EOFException();
        }
        return invokeV.intValue;
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            long indexOf = indexOf((byte) 10);
            if (indexOf == -1) {
                long j2 = this.size;
                if (j2 != 0) {
                    return readUtf8(j2);
                }
                return null;
            }
            return readUtf8Line(indexOf);
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? readUtf8LineStrict(Long.MAX_VALUE) : (String) invokeV.objValue;
    }

    @Override // okio.BufferedSource
    public boolean request(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048644, this, j2)) == null) ? this.size >= j2 : invokeJ.booleanValue;
    }

    @Override // okio.BufferedSource
    public void require(long j2) throws EOFException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048645, this, j2) == null) && this.size < j2) {
            throw new EOFException();
        }
    }

    public List<Integer> segmentSizes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048646, this)) != null) {
            return (List) invokeV.objValue;
        }
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
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

    public int selectPrefix(Options options, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        int i3;
        int i4;
        int i5;
        Segment segment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048648, this, options, z)) == null) {
            Segment segment2 = this.head;
            int i6 = -2;
            if (segment2 == null) {
                if (z) {
                    return -2;
                }
                return options.indexOf(ByteString.EMPTY);
            }
            byte[] bArr = segment2.data;
            int i7 = segment2.pos;
            int i8 = segment2.limit;
            int[] iArr = options.trie;
            Segment segment3 = segment2;
            int i9 = 0;
            int i10 = -1;
            loop0: while (true) {
                int i11 = i9 + 1;
                int i12 = iArr[i9];
                int i13 = i11 + 1;
                int i14 = iArr[i11];
                if (i14 != -1) {
                    i10 = i14;
                }
                if (segment3 == null) {
                    break;
                }
                if (i12 >= 0) {
                    int i15 = i7 + 1;
                    int i16 = bArr[i7] & 255;
                    int i17 = i13 + i12;
                    while (i13 != i17) {
                        if (i16 == iArr[i13]) {
                            i2 = iArr[i13 + i12];
                            if (i15 == i8) {
                                segment3 = segment3.next;
                                i3 = segment3.pos;
                                bArr = segment3.data;
                                i8 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            } else {
                                i3 = i15;
                            }
                        } else {
                            i13++;
                        }
                    }
                    return i10;
                }
                int i18 = i13 + (i12 * (-1));
                while (true) {
                    int i19 = i7 + 1;
                    int i20 = i13 + 1;
                    if ((bArr[i7] & 255) != iArr[i13]) {
                        return i10;
                    }
                    boolean z2 = i20 == i18;
                    if (i19 == i8) {
                        Segment segment4 = segment3.next;
                        i5 = segment4.pos;
                        byte[] bArr2 = segment4.data;
                        i4 = segment4.limit;
                        if (segment4 != segment2) {
                            segment = segment4;
                            bArr = bArr2;
                        } else if (!z2) {
                            break loop0;
                        } else {
                            bArr = bArr2;
                            segment = null;
                        }
                    } else {
                        Segment segment5 = segment3;
                        i4 = i8;
                        i5 = i19;
                        segment = segment5;
                    }
                    if (z2) {
                        i2 = iArr[i20];
                        i3 = i5;
                        i8 = i4;
                        segment3 = segment;
                        break;
                    }
                    i7 = i5;
                    i8 = i4;
                    i13 = i20;
                    segment3 = segment;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i9 = -i2;
                i7 = i3;
                i6 = -2;
            }
            return z ? i6 : i10;
        }
        return invokeLZ.intValue;
    }

    public final ByteString sha1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? digest("SHA-1") : (ByteString) invokeV.objValue;
    }

    public final ByteString sha256() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? digest("SHA-256") : (ByteString) invokeV.objValue;
    }

    public final ByteString sha512() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? digest("SHA-512") : (ByteString) invokeV.objValue;
    }

    public final long size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.size : invokeV.longValue;
    }

    @Override // okio.BufferedSource
    public void skip(long j2) throws EOFException {
        Segment segment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048653, this, j2) == null) {
            while (j2 > 0) {
                if (this.head != null) {
                    int min = (int) Math.min(j2, segment.limit - segment.pos);
                    long j3 = min;
                    this.size -= j3;
                    j2 -= j3;
                    Segment segment2 = this.head;
                    int i2 = segment2.pos + min;
                    segment2.pos = i2;
                    if (i2 == segment2.limit) {
                        this.head = segment2.pop();
                        SegmentPool.recycle(segment2);
                    }
                } else {
                    throw new EOFException();
                }
            }
        }
    }

    public final ByteString snapshot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            long j2 = this.size;
            if (j2 <= 2147483647L) {
                return snapshot((int) j2);
            }
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.Source
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? Timeout.NONE : (Timeout) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? snapshot().toString() : (String) invokeV.objValue;
    }

    public Segment writableSegment(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i2)) == null) {
            if (i2 >= 1 && i2 <= 8192) {
                Segment segment = this.head;
                if (segment == null) {
                    Segment take = SegmentPool.take();
                    this.head = take;
                    take.prev = take;
                    take.next = take;
                    return take;
                }
                Segment segment2 = segment.prev;
                return (segment2.limit + i2 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
            }
            throw new IllegalArgumentException();
        }
        return (Segment) invokeI.objValue;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048668, this, source)) != null) {
            return invokeL.longValue;
        }
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, outputStream)) == null) ? writeTo(outputStream, this.size) : (Buffer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Buffer clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return (Buffer) invokeV.objValue;
        }
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
    }

    public final Buffer copyTo(OutputStream outputStream, long j2, long j3) throws IOException {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{outputStream, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (outputStream != null) {
                Util.checkOffsetAndCount(this.size, j2, j3);
                if (j3 == 0) {
                    return this;
                }
                Segment segment = this.head;
                while (true) {
                    int i3 = segment.limit;
                    int i4 = segment.pos;
                    if (j2 < i3 - i4) {
                        break;
                    }
                    j2 -= i3 - i4;
                    segment = segment.next;
                }
                while (j3 > 0) {
                    int min = (int) Math.min(segment.limit - i2, j3);
                    outputStream.write(segment.data, (int) (segment.pos + j2), min);
                    j3 -= min;
                    segment = segment.next;
                    j2 = 0;
                }
                return this;
            }
            throw new IllegalArgumentException("out == null");
        }
        return (Buffer) invokeCommon.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Byte.valueOf(b2), Long.valueOf(j2)})) == null) ? indexOf(b2, j2, Long.MAX_VALUE) : invokeCommon.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j2) {
        InterceptResult invokeLJ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048602, this, byteString, j2)) == null) {
            long j3 = 0;
            if (j2 >= 0) {
                Segment segment = this.head;
                if (segment == null) {
                    return -1L;
                }
                long j4 = this.size;
                if (j4 - j2 < j2) {
                    while (j4 > j2) {
                        segment = segment.prev;
                        j4 -= segment.limit - segment.pos;
                    }
                } else {
                    while (true) {
                        long j5 = (segment.limit - segment.pos) + j3;
                        if (j5 >= j2) {
                            break;
                        }
                        segment = segment.next;
                        j3 = j5;
                    }
                    j4 = j3;
                }
                if (byteString.size() == 2) {
                    byte b2 = byteString.getByte(0);
                    byte b3 = byteString.getByte(1);
                    while (j4 < this.size) {
                        byte[] bArr = segment.data;
                        i2 = (int) ((segment.pos + j2) - j4);
                        int i4 = segment.limit;
                        while (i2 < i4) {
                            byte b4 = bArr[i2];
                            if (b4 == b2 || b4 == b3) {
                                i3 = segment.pos;
                                return (i2 - i3) + j4;
                            }
                            i2++;
                        }
                        j4 += segment.limit - segment.pos;
                        segment = segment.next;
                        j2 = j4;
                    }
                    return -1L;
                }
                byte[] internalArray = byteString.internalArray();
                while (j4 < this.size) {
                    byte[] bArr2 = segment.data;
                    i2 = (int) ((segment.pos + j2) - j4);
                    int i5 = segment.limit;
                    while (i2 < i5) {
                        byte b5 = bArr2[i2];
                        for (byte b6 : internalArray) {
                            if (b5 == b6) {
                                i3 = segment.pos;
                                return (i2 - i3) + j4;
                            }
                        }
                        i2++;
                    }
                    j4 += segment.limit - segment.pos;
                    segment = segment.next;
                    j2 = j4;
                }
                return -1L;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        return invokeLJ.longValue;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, ByteString byteString, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j2), byteString, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (j2 < 0 || i2 < 0 || i3 < 0 || this.size - j2 < i3 || byteString.size() - i2 < i3) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (getByte(i4 + j2) != byteString.getByte(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048611, this, bArr, i2, i3)) == null) {
            Util.checkOffsetAndCount(bArr.length, i2, i3);
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            int min = Math.min(i3, segment.limit - segment.pos);
            System.arraycopy(segment.data, segment.pos, bArr, i2, min);
            int i4 = segment.pos + min;
            segment.pos = i4;
            this.size -= min;
            if (i4 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return min;
        }
        return invokeLII.intValue;
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
    public ByteString readByteString(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048620, this, j2)) == null) ? new ByteString(readByteArray(j2)) : (ByteString) invokeJ.objValue;
    }

    public final Buffer readFrom(InputStream inputStream, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048623, this, inputStream, j2)) == null) {
            if (j2 >= 0) {
                readFrom(inputStream, j2, false);
                return this;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        return (Buffer) invokeLJ.objValue;
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
    public String readUtf8LineStrict(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048643, this, j2)) == null) {
            if (j2 >= 0) {
                long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
                long indexOf = indexOf((byte) 10, 0L, j3);
                if (indexOf != -1) {
                    return readUtf8Line(indexOf);
                }
                if (j3 < size() && getByte(j3 - 1) == 13 && getByte(j3) == 10) {
                    return readUtf8Line(j3);
                }
                Buffer buffer = new Buffer();
                copyTo(buffer, 0L, Math.min(32L, size()));
                throw new EOFException("\\n not found: limit=" + Math.min(size(), j2) + " content=" + buffer.readByteString().hex() + Typography.ellipsis);
            }
            throw new IllegalArgumentException("limit < 0: " + j2);
        }
        return (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeByte(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048669, this, i2)) == null) {
            Segment writableSegment = writableSegment(1);
            byte[] bArr = writableSegment.data;
            int i3 = writableSegment.limit;
            writableSegment.limit = i3 + 1;
            bArr[i3] = (byte) i2;
            this.size++;
            return this;
        }
        return (Buffer) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048671, this, j2)) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 == 0) {
                return writeByte(48);
            }
            boolean z = false;
            int i3 = 1;
            if (i2 < 0) {
                j2 = -j2;
                if (j2 < 0) {
                    return writeUtf8("-9223372036854775808");
                }
                z = true;
            }
            if (j2 >= 100000000) {
                i3 = j2 < BasicLabelFormatter.TRILLION ? j2 < 10000000000L ? j2 < C.NANOS_PER_SECOND ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
            } else if (j2 >= 10000) {
                i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
            } else if (j2 >= 100) {
                i3 = j2 < 1000 ? 3 : 4;
            } else if (j2 >= 10) {
                i3 = 2;
            }
            if (z) {
                i3++;
            }
            Segment writableSegment = writableSegment(i3);
            byte[] bArr = writableSegment.data;
            int i4 = writableSegment.limit + i3;
            while (j2 != 0) {
                i4--;
                bArr[i4] = DIGITS[(int) (j2 % 10)];
                j2 /= 10;
            }
            if (z) {
                bArr[i4 - 1] = 45;
            }
            writableSegment.limit += i3;
            this.size += i3;
            return this;
        }
        return (Buffer) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048673, this, j2)) == null) {
            if (j2 == 0) {
                return writeByte(48);
            }
            int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
            Segment writableSegment = writableSegment(numberOfTrailingZeros);
            byte[] bArr = writableSegment.data;
            int i2 = writableSegment.limit;
            for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
                bArr[i3] = DIGITS[(int) (15 & j2)];
                j2 >>>= 4;
            }
            writableSegment.limit += numberOfTrailingZeros;
            this.size += numberOfTrailingZeros;
            return this;
        }
        return (Buffer) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048675, this, i2)) == null) {
            Segment writableSegment = writableSegment(4);
            byte[] bArr = writableSegment.data;
            int i3 = writableSegment.limit;
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >>> 24) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i2 >>> 16) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i2 >>> 8) & 255);
            bArr[i6] = (byte) (i2 & 255);
            writableSegment.limit = i6 + 1;
            this.size += 4;
            return this;
        }
        return (Buffer) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048677, this, i2)) == null) ? writeInt(Util.reverseBytesInt(i2)) : (Buffer) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeLong(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048679, this, j2)) == null) {
            Segment writableSegment = writableSegment(8);
            byte[] bArr = writableSegment.data;
            int i2 = writableSegment.limit;
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((j2 >>> 56) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((j2 >>> 48) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((j2 >>> 40) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j2 >>> 32) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j2 >>> 24) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j2 >>> 16) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((j2 >>> 8) & 255);
            bArr[i9] = (byte) (j2 & 255);
            writableSegment.limit = i9 + 1;
            this.size += 8;
            return this;
        }
        return (Buffer) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048681, this, j2)) == null) ? writeLong(Util.reverseBytesLong(j2)) : (Buffer) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeShort(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048683, this, i2)) == null) {
            Segment writableSegment = writableSegment(2);
            byte[] bArr = writableSegment.data;
            int i3 = writableSegment.limit;
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >>> 8) & 255);
            bArr[i4] = (byte) (i2 & 255);
            writableSegment.limit = i4 + 1;
            this.size += 2;
            return this;
        }
        return (Buffer) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048685, this, i2)) == null) ? writeShort((int) Util.reverseBytesShort((short) i2)) : (Buffer) invokeI.objValue;
    }

    public final Buffer writeTo(OutputStream outputStream, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048692, this, outputStream, j2)) == null) {
            if (outputStream != null) {
                Util.checkOffsetAndCount(this.size, 0L, j2);
                Segment segment = this.head;
                while (j2 > 0) {
                    int min = (int) Math.min(j2, segment.limit - segment.pos);
                    outputStream.write(segment.data, segment.pos, min);
                    int i2 = segment.pos + min;
                    segment.pos = i2;
                    long j3 = min;
                    this.size -= j3;
                    j2 -= j3;
                    if (i2 == segment.limit) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048697, this, i2)) == null) {
            if (i2 < 128) {
                writeByte(i2);
            } else if (i2 < 2048) {
                writeByte((i2 >> 6) | 192);
                writeByte((i2 & 63) | 128);
            } else if (i2 < 65536) {
                if (i2 >= 55296 && i2 <= 57343) {
                    writeByte(63);
                } else {
                    writeByte((i2 >> 12) | 224);
                    writeByte(((i2 >> 6) & 63) | 128);
                    writeByte((i2 & 63) | 128);
                }
            } else if (i2 <= 1114111) {
                writeByte((i2 >> 18) | 240);
                writeByte(((i2 >> 12) & 63) | 128);
                writeByte(((i2 >> 6) & 63) | 128);
                writeByte((i2 & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
            return this;
        }
        return (Buffer) invokeI.objValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2, long j3) {
        InterceptResult invokeCommon;
        Segment segment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Byte.valueOf(b2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = 0;
            if (j2 >= 0 && j3 >= j2) {
                long j5 = this.size;
                if (j3 <= j5) {
                    j5 = j3;
                }
                if (j2 == j5 || (segment = this.head) == null) {
                    return -1L;
                }
                long j6 = this.size;
                if (j6 - j2 < j2) {
                    while (j6 > j2) {
                        segment = segment.prev;
                        j6 -= segment.limit - segment.pos;
                    }
                } else {
                    while (true) {
                        long j7 = (segment.limit - segment.pos) + j4;
                        if (j7 >= j2) {
                            break;
                        }
                        segment = segment.next;
                        j4 = j7;
                    }
                    j6 = j4;
                }
                long j8 = j2;
                while (j6 < j5) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + j5) - j6);
                    for (int i2 = (int) ((segment.pos + j8) - j6); i2 < min; i2++) {
                        if (bArr[i2] == b2) {
                            return (i2 - segment.pos) + j6;
                        }
                    }
                    j6 += segment.limit - segment.pos;
                    segment = segment.next;
                    j8 = j6;
                }
                return -1L;
            }
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j2), Long.valueOf(j3)));
        }
        return invokeCommon.longValue;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048618, this, j2)) == null) {
            Util.checkOffsetAndCount(this.size, 0L, j2);
            if (j2 <= 2147483647L) {
                byte[] bArr = new byte[(int) j2];
                readFully(bArr);
                return bArr;
            }
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
        }
        return (byte[]) invokeJ.objValue;
    }

    @Override // okio.BufferedSource
    public String readString(long j2, Charset charset) throws EOFException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048633, this, j2, charset)) == null) {
            Util.checkOffsetAndCount(this.size, 0L, j2);
            if (charset != null) {
                if (j2 > 2147483647L) {
                    throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
                } else if (j2 == 0) {
                    return "";
                } else {
                    Segment segment = this.head;
                    if (segment.pos + j2 > segment.limit) {
                        return new String(readByteArray(j2), charset);
                    }
                    String str = new String(segment.data, segment.pos, (int) j2, charset);
                    int i2 = (int) (segment.pos + j2);
                    segment.pos = i2;
                    this.size -= j2;
                    if (i2 == segment.limit) {
                        this.head = segment.pop();
                        SegmentPool.recycle(segment);
                    }
                    return str;
                }
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeJL.objValue;
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048638, this, j2)) == null) ? readString(j2, Util.UTF_8) : (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048688, this, str, charset)) == null) ? writeString(str, 0, str.length(), charset) : (Buffer) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, str)) == null) ? writeUtf8(str, 0, str.length()) : (Buffer) invokeL.objValue;
    }

    private void readFrom(InputStream inputStream, long j2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65541, this, new Object[]{inputStream, Long.valueOf(j2), Boolean.valueOf(z)}) != null) {
            return;
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j2 <= 0 && !z) {
                return;
            }
            Segment writableSegment = writableSegment(1);
            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j2, 8192 - writableSegment.limit));
            if (read == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment.limit += read;
            long j3 = read;
            this.size += j3;
            j2 -= j3;
        }
    }

    public String readUtf8Line(long j2) throws EOFException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048641, this, j2)) == null) {
            if (j2 > 0) {
                long j3 = j2 - 1;
                if (getByte(j3) == 13) {
                    String readUtf8 = readUtf8(j3);
                    skip(2L);
                    return readUtf8;
                }
            }
            String readUtf82 = readUtf8(j2);
            skip(1L);
            return readUtf82;
        }
        return (String) invokeJ.objValue;
    }

    public final ByteString snapshot(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048655, this, i2)) == null) {
            if (i2 == 0) {
                return ByteString.EMPTY;
            }
            return new SegmentedByteString(this, i2);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i2, int i3, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048687, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), charset})) == null) {
            if (str != null) {
                if (i2 < 0) {
                    throw new IllegalAccessError("beginIndex < 0: " + i2);
                } else if (i3 >= i2) {
                    if (i3 <= str.length()) {
                        if (charset != null) {
                            if (charset.equals(Util.UTF_8)) {
                                return writeUtf8(str, i2, i3);
                            }
                            byte[] bytes = str.substring(i2, i3).getBytes(charset);
                            return write(bytes, 0, bytes.length);
                        }
                        throw new IllegalArgumentException("charset == null");
                    }
                    throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return (Buffer) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048694, this, str, i2, i3)) == null) {
            if (str != null) {
                if (i2 < 0) {
                    throw new IllegalArgumentException("beginIndex < 0: " + i2);
                } else if (i3 >= i2) {
                    if (i3 > str.length()) {
                        throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                    }
                    while (i2 < i3) {
                        char charAt = str.charAt(i2);
                        if (charAt < 128) {
                            Segment writableSegment = writableSegment(1);
                            byte[] bArr = writableSegment.data;
                            int i4 = writableSegment.limit - i2;
                            int min = Math.min(i3, 8192 - i4);
                            int i5 = i2 + 1;
                            bArr[i2 + i4] = (byte) charAt;
                            while (i5 < min) {
                                char charAt2 = str.charAt(i5);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                bArr[i5 + i4] = (byte) charAt2;
                                i5++;
                            }
                            int i6 = writableSegment.limit;
                            int i7 = (i4 + i5) - i6;
                            writableSegment.limit = i6 + i7;
                            this.size += i7;
                            i2 = i5;
                        } else {
                            if (charAt < 2048) {
                                writeByte((charAt >> 6) | 192);
                                writeByte((charAt & '?') | 128);
                            } else if (charAt >= 55296 && charAt <= 57343) {
                                int i8 = i2 + 1;
                                char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                                if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                    int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                    writeByte((i9 >> 18) | 240);
                                    writeByte(((i9 >> 12) & 63) | 128);
                                    writeByte(((i9 >> 6) & 63) | 128);
                                    writeByte((i9 & 63) | 128);
                                    i2 += 2;
                                } else {
                                    writeByte(63);
                                    i2 = i8;
                                }
                            } else {
                                writeByte((charAt >> '\f') | 224);
                                writeByte(((charAt >> 6) & 63) | 128);
                                writeByte((charAt & '?') | 128);
                            }
                            i2++;
                        }
                    }
                    return this;
                } else {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
                }
            }
            throw new IllegalArgumentException("string == null");
        }
        return (Buffer) invokeLII.objValue;
    }

    private boolean rangeEquals(Segment segment, int i2, ByteString byteString, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{segment, Integer.valueOf(i2), byteString, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int i5 = segment.limit;
            byte[] bArr = segment.data;
            while (i3 < i4) {
                if (i2 == i5) {
                    segment = segment.next;
                    bArr = segment.data;
                    i2 = segment.pos;
                    i5 = segment.limit;
                }
                if (bArr[i2] != byteString.getByte(i3)) {
                    return false;
                }
                i2++;
                i3++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bArr) == null) {
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = read(bArr, i2, bArr.length - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
        }
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048662, this, bArr, i2, i3)) == null) {
            if (bArr != null) {
                long j2 = i3;
                Util.checkOffsetAndCount(bArr.length, i2, j2);
                int i4 = i3 + i2;
                while (i2 < i4) {
                    Segment writableSegment = writableSegment(1);
                    int min = Math.min(i4 - i2, 8192 - writableSegment.limit);
                    System.arraycopy(bArr, i2, writableSegment.data, writableSegment.limit, min);
                    i2 += min;
                    writableSegment.limit += min;
                }
                this.size += j2;
                return this;
            }
            throw new IllegalArgumentException("source == null");
        }
        return (Buffer) invokeLII.objValue;
    }

    public final Buffer copyTo(Buffer buffer, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{buffer, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (buffer != null) {
                Util.checkOffsetAndCount(this.size, j2, j3);
                if (j3 == 0) {
                    return this;
                }
                buffer.size += j3;
                Segment segment = this.head;
                while (true) {
                    int i2 = segment.limit;
                    int i3 = segment.pos;
                    if (j2 < i2 - i3) {
                        break;
                    }
                    j2 -= i2 - i3;
                    segment = segment.next;
                }
                while (j3 > 0) {
                    Segment sharedCopy = segment.sharedCopy();
                    int i4 = (int) (sharedCopy.pos + j2);
                    sharedCopy.pos = i4;
                    sharedCopy.limit = Math.min(i4 + ((int) j3), sharedCopy.limit);
                    Segment segment2 = buffer.head;
                    if (segment2 == null) {
                        sharedCopy.prev = sharedCopy;
                        sharedCopy.next = sharedCopy;
                        buffer.head = sharedCopy;
                    } else {
                        segment2.prev.push(sharedCopy);
                    }
                    j3 -= sharedCopy.limit - sharedCopy.pos;
                    segment = segment.next;
                    j2 = 0;
                }
                return this;
            }
            throw new IllegalArgumentException("out == null");
        }
        return (Buffer) invokeCommon.objValue;
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
            int i2 = segment.pos + min;
            segment.pos = i2;
            this.size -= min;
            if (i2 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return min;
        }
        return invokeL.intValue;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, byteBuffer)) == null) {
            if (byteBuffer != null) {
                int remaining = byteBuffer.remaining();
                int i2 = remaining;
                while (i2 > 0) {
                    Segment writableSegment = writableSegment(1);
                    int min = Math.min(i2, 8192 - writableSegment.limit);
                    byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                    i2 -= min;
                    writableSegment.limit += min;
                }
                this.size += remaining;
                return remaining;
            }
            throw new IllegalArgumentException("source == null");
        }
        return invokeL.intValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, byteString)) == null) ? indexOf(byteString, 0L) : invokeL.longValue;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048612, this, buffer, j2)) == null) {
            if (buffer != null) {
                if (j2 >= 0) {
                    long j3 = this.size;
                    if (j3 == 0) {
                        return -1L;
                    }
                    if (j2 > j3) {
                        j2 = j3;
                    }
                    buffer.write(this, j2);
                    return j2;
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            throw new IllegalArgumentException("sink == null");
        }
        return invokeLJ.longValue;
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j2) throws IOException {
        InterceptResult invokeLJ;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, byteString, j2)) == null) {
            if (byteString.size() != 0) {
                long j3 = 0;
                if (j2 >= 0) {
                    Segment segment = this.head;
                    long j4 = -1;
                    if (segment == null) {
                        return -1L;
                    }
                    long j5 = this.size;
                    if (j5 - j2 < j2) {
                        while (j5 > j2) {
                            segment = segment.prev;
                            j5 -= segment.limit - segment.pos;
                        }
                    } else {
                        while (true) {
                            long j6 = (segment.limit - segment.pos) + j3;
                            if (j6 >= j2) {
                                break;
                            }
                            segment = segment.next;
                            j3 = j6;
                        }
                        j5 = j3;
                    }
                    byte b2 = byteString.getByte(0);
                    int size = byteString.size();
                    long j7 = 1 + (this.size - size);
                    long j8 = j2;
                    Segment segment2 = segment;
                    long j9 = j5;
                    while (j9 < j7) {
                        byte[] bArr2 = segment2.data;
                        int min = (int) Math.min(segment2.limit, (segment2.pos + j7) - j9);
                        int i2 = (int) ((segment2.pos + j8) - j9);
                        while (i2 < min) {
                            if (bArr2[i2] == b2) {
                                bArr = bArr2;
                                if (rangeEquals(segment2, i2 + 1, byteString, 1, size)) {
                                    return (i2 - segment2.pos) + j9;
                                }
                            } else {
                                bArr = bArr2;
                            }
                            i2++;
                            bArr2 = bArr;
                        }
                        j9 += segment2.limit - segment2.pos;
                        segment2 = segment2.next;
                        j8 = j9;
                        j4 = -1;
                    }
                    return j4;
                }
                throw new IllegalArgumentException("fromIndex < 0");
            }
            throw new IllegalArgumentException("bytes is empty");
        }
        return invokeLJ.longValue;
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048664, this, source, j2)) == null) {
            while (j2 > 0) {
                long read = source.read(this, j2);
                if (read == -1) {
                    throw new EOFException();
                }
                j2 -= read;
            }
            return this;
        }
        return (BufferedSink) invokeLJ.objValue;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048667, this, buffer, j2) == null) {
            if (buffer == null) {
                throw new IllegalArgumentException("source == null");
            }
            if (buffer != this) {
                Util.checkOffsetAndCount(buffer.size, 0L, j2);
                while (j2 > 0) {
                    Segment segment = buffer.head;
                    if (j2 < segment.limit - segment.pos) {
                        Segment segment2 = this.head;
                        Segment segment3 = segment2 != null ? segment2.prev : null;
                        if (segment3 != null && segment3.owner) {
                            if ((segment3.limit + j2) - (segment3.shared ? 0 : segment3.pos) <= 8192) {
                                buffer.head.writeTo(segment3, (int) j2);
                                buffer.size -= j2;
                                this.size += j2;
                                return;
                            }
                        }
                        buffer.head = buffer.head.split((int) j2);
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
                    j2 -= j3;
                }
                return;
            }
            throw new IllegalArgumentException("source == this");
        }
    }
}
