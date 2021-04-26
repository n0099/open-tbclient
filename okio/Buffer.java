package okio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.internal.utils.UtilsBlink;
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
/* loaded from: classes7.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
    public static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    public Segment head;
    public long size;

    /* loaded from: classes7.dex */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        public Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
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

        public long expandBuffer(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i2);
            } else if (i2 <= 8192) {
                Buffer buffer = this.buffer;
                if (buffer != null) {
                    if (this.readWrite) {
                        long j = buffer.size;
                        Segment writableSegment = buffer.writableSegment(i2);
                        int i3 = 8192 - writableSegment.limit;
                        writableSegment.limit = 8192;
                        long j2 = i3;
                        this.buffer.size = j + j2;
                        this.segment = writableSegment;
                        this.offset = j;
                        this.data = writableSegment.data;
                        this.start = 8192 - i3;
                        this.end = 8192;
                        return j2;
                    }
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
                throw new IllegalStateException("not attached to a buffer");
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i2);
            }
        }

        public int next() {
            long j = this.offset;
            if (j != this.buffer.size) {
                if (j == -1) {
                    return seek(0L);
                }
                return seek(j + (this.end - this.start));
            }
            throw new IllegalStateException();
        }

        public long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (this.readWrite) {
                    long j2 = buffer.size;
                    int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i2 <= 0) {
                        if (j >= 0) {
                            long j3 = j2 - j;
                            while (true) {
                                if (j3 <= 0) {
                                    break;
                                }
                                Buffer buffer2 = this.buffer;
                                Segment segment = buffer2.head.prev;
                                int i3 = segment.limit;
                                long j4 = i3 - segment.pos;
                                if (j4 <= j3) {
                                    buffer2.head = segment.pop();
                                    SegmentPool.recycle(segment);
                                    j3 -= j4;
                                } else {
                                    segment.limit = (int) (i3 - j3);
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
                    } else if (i2 > 0) {
                        long j5 = j - j2;
                        boolean z = true;
                        while (j5 > 0) {
                            Segment writableSegment = this.buffer.writableSegment(1);
                            int min = (int) Math.min(j5, 8192 - writableSegment.limit);
                            int i4 = writableSegment.limit + min;
                            writableSegment.limit = i4;
                            j5 -= min;
                            if (z) {
                                this.segment = writableSegment;
                                this.offset = j2;
                                this.data = writableSegment.data;
                                this.start = i4 - min;
                                this.end = i4;
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

        public int seek(long j) {
            int i2 = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i2 >= 0) {
                Buffer buffer = this.buffer;
                long j2 = buffer.size;
                if (j <= j2) {
                    if (i2 != 0 && j != j2) {
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
                                int i3 = segment2.limit;
                                int i4 = segment2.pos;
                                if (j < (i3 - i4) + j3) {
                                    break;
                                }
                                j3 += i3 - i4;
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
                        int i5 = segment2.pos + ((int) (j - j3));
                        this.start = i5;
                        int i6 = segment2.limit;
                        this.end = i6;
                        return i6 - i5;
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
    }

    private ByteString digest(String str) {
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

    private ByteString hmac(String str, ByteString byteString) {
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

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public void clear() {
        try {
            skip(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        int i2 = segment.limit;
        return (i2 >= 8192 || !segment.owner) ? j : j - (i2 - segment.pos);
    }

    public Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
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
            int i2 = segment.pos;
            int i3 = segment2.pos;
            while (j2 < this.size) {
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
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    public byte getByte(long j) {
        int i2;
        Util.checkOffsetAndCount(this.size, j, 1L);
        long j2 = this.size;
        if (j2 - j > j) {
            Segment segment = this.head;
            while (true) {
                int i3 = segment.limit;
                int i4 = segment.pos;
                long j3 = i3 - i4;
                if (j < j3) {
                    return segment.data[i4 + ((int) j)];
                }
                j -= j3;
                segment = segment.next;
            }
        } else {
            long j4 = j - j2;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                int i5 = segment2.limit;
                i2 = segment2.pos;
                j4 += i5 - i2;
            } while (j4 < 0);
            return segment2.data[i2 + ((int) j4)];
        }
    }

    public int hashCode() {
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

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) {
                return Buffer.this.read(bArr, i2, i3);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i2) {
                Buffer.this.writeByte((int) ((byte) i2));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Buffer.this.write(bArr, i2, i3);
            }
        };
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.size;
        if (j != 0) {
            Segment segment = this.head;
            int i2 = segment.pos;
            int i3 = segment.limit;
            int i4 = i2 + 1;
            byte b2 = segment.data[i2];
            this.size = j - 1;
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

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        r1 = new okio.Buffer().writeDecimalLong(r3).writeByte((int) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r8 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
        r17.size -= r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bf, code lost:
        if (r8 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c3, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readDecimalLong() {
        long j = 0;
        if (this.size != 0) {
            long j2 = -922337203685477580L;
            long j3 = -7;
            int i2 = 0;
            boolean z = false;
            boolean z2 = false;
            loop0: while (true) {
                Segment segment = this.head;
                byte[] bArr = segment.data;
                int i3 = segment.pos;
                int i4 = segment.limit;
                while (i3 < i4) {
                    byte b2 = bArr[i3];
                    if (b2 >= 48 && b2 <= 57) {
                        int i5 = 48 - b2;
                        int i6 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i6 < 0 || (i6 == 0 && i5 < j3)) {
                            break loop0;
                        }
                        j = (j * 10) + i5;
                    } else if (b2 == 45 && i2 == 0) {
                        j3--;
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
                        j2 = -922337203685477580L;
                    }
                    i3++;
                    i2++;
                    j2 = -922337203685477580L;
                }
                if (i3 != i4) {
                }
                if (!z2) {
                    break;
                }
                break;
            }
        }
        throw new IllegalStateException("size == 0");
    }

    public Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5 A[EDGE_INSN: B:42:0x00a5->B:38:0x00a5 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readHexadecimalUnsignedLong() {
        int i2;
        int i3;
        if (this.size != 0) {
            int i4 = 0;
            long j = 0;
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
                    if (((-1152921504606846976L) & j) != 0) {
                        Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b2);
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                    j = (j << 4) | i3;
                    i5++;
                    i4++;
                }
                if (i5 != i6) {
                }
                if (!z) {
                }
            } while (this.head != null);
            this.size -= i4;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.size;
        if (j >= 4) {
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
            this.size = j - 4;
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

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        long j = this.size;
        if (j >= 8) {
            Segment segment = this.head;
            int i2 = segment.pos;
            int i3 = segment.limit;
            if (i3 - i2 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = segment.data;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            long j2 = (bArr[i4] & 255) << 48;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j3 = j2 | ((bArr[i2] & 255) << 56) | ((bArr[i5] & 255) << 40) | ((bArr[i6] & 255) << 32) | ((bArr[i7] & 255) << 24) | ((bArr[i8] & 255) << 16) | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
            this.size = j - 8;
            if (i11 == i3) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i11;
            }
            return j3;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.size;
        if (j >= 2) {
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
            this.size = j - 2;
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

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (this.size != 0) {
            byte b2 = getByte(0L);
            if ((b2 & ByteCompanionObject.MIN_VALUE) == 0) {
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
            long j = i3;
            if (this.size >= j) {
                for (int i5 = 1; i5 < i3; i5++) {
                    long j2 = i5;
                    byte b3 = getByte(j2);
                    if ((b3 & 192) != 128) {
                        skip(j2);
                        return REPLACEMENT_CHARACTER;
                    }
                    i2 = (i2 << 6) | (b3 & 63);
                }
                skip(j);
                return i2 > 1114111 ? REPLACEMENT_CHARACTER : ((i2 < 55296 || i2 > 57343) && i2 >= i4) ? i2 : REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i3 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b2) + SmallTailInfo.EMOTION_SUFFIX);
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
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

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    public List<Integer> segmentSizes() {
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
        Segment segment = this.head;
        if (segment == null) {
            return options.indexOf(ByteString.EMPTY);
        }
        ByteString[] byteStringArr = options.byteStrings;
        int length = byteStringArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            ByteString byteString = byteStringArr[i2];
            if (this.size >= byteString.size() && rangeEquals(segment, segment.pos, byteString, 0, byteString.size())) {
                try {
                    skip(byteString.size());
                    return i2;
                } catch (EOFException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
        return -1;
    }

    public int selectPrefix(Options options) {
        Segment segment = this.head;
        ByteString[] byteStringArr = options.byteStrings;
        int length = byteStringArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            ByteString byteString = byteStringArr[i2];
            int min = (int) Math.min(this.size, byteString.size());
            if (min == 0 || rangeEquals(segment, segment.pos, byteString, 0, min)) {
                return i2;
            }
        }
        return -1;
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public ByteString sha512() {
        return digest("SHA-512");
    }

    public long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        Segment segment;
        while (j > 0) {
            if (this.head != null) {
                int min = (int) Math.min(j, segment.limit - segment.pos);
                long j2 = min;
                this.size -= j2;
                j -= j2;
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

    public ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Segment writableSegment(int i2) {
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

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Buffer clone() {
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

    public Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        int i2;
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            Segment segment = this.head;
            while (true) {
                int i3 = segment.limit;
                int i4 = segment.pos;
                if (j < i3 - i4) {
                    break;
                }
                j -= i3 - i4;
                segment = segment.next;
            }
            while (j2 > 0) {
                int min = (int) Math.min(segment.limit - i2, j2);
                outputStream.write(segment.data, (int) (segment.pos + j), min);
                j2 -= min;
                segment = segment.next;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j) {
        return indexOf(b2, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i2;
        int i3;
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
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (j3 < this.size) {
                    byte[] bArr = segment.data;
                    i2 = (int) ((segment.pos + j) - j3);
                    int i4 = segment.limit;
                    while (i2 < i4) {
                        byte b4 = bArr[i2];
                        if (b4 == b2 || b4 == b3) {
                            i3 = segment.pos;
                            return (i2 - i3) + j3;
                        }
                        i2++;
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
                i2 = (int) ((segment.pos + j) - j3);
                int i5 = segment.limit;
                while (i2 < i5) {
                    byte b5 = bArr2[i2];
                    for (byte b6 : internalArray) {
                        if (b5 == b6) {
                            i3 = segment.pos;
                            return (i2 - i3) + j3;
                        }
                    }
                    i2++;
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                j = j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i2, int i3) {
        if (j < 0 || i2 < 0 || i3 < 0 || this.size - j < i3 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (getByte(i4 + j) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i2, int i3) {
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

    public UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    public Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeByte(int i2) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i3 = writableSegment.limit;
        writableSegment.limit = i3 + 1;
        bArr[i3] = (byte) i2;
        this.size++;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i3 = j < BasicLabelFormatter.TRILLION ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i3 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i3 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        Segment writableSegment = writableSegment(i3);
        byte[] bArr = writableSegment.data;
        int i4 = writableSegment.limit + i3;
        while (j != 0) {
            i4--;
            bArr[i4] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i4 - 1] = UtilsBlink.VER_TYPE_SEPARATOR;
        }
        writableSegment.limit += i3;
        this.size += i3;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeInt(int i2) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i2) {
        return writeInt(Util.reverseBytesInt(i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j >>> 8) & 255);
        bArr[i9] = (byte) (j & 255);
        writableSegment.limit = i9 + 1;
        this.size += 8;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeShort(int i2) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i2) {
        return writeShort((int) Util.reverseBytesShort((short) i2));
    }

    public Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, 0L, j);
            Segment segment = this.head;
            while (j > 0) {
                int min = (int) Math.min(j, segment.limit - segment.pos);
                outputStream.write(segment.data, segment.pos, min);
                int i2 = segment.pos + min;
                segment.pos = i2;
                long j2 = min;
                this.size -= j2;
                j -= j2;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i2) {
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

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j, long j2) {
        Segment segment;
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
                for (int i2 = (int) ((segment.pos + j7) - j5); i2 < min; i2++) {
                    if (bArr[i2] == b2) {
                        return (i2 - segment.pos) + j5;
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

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.head;
                if (segment.pos + j > segment.limit) {
                    return new String(readByteArray(j), charset);
                }
                String str = new String(segment.data, segment.pos, (int) j, charset);
                int i2 = (int) (segment.pos + j);
                segment.pos = i2;
                this.size -= j;
                if (i2 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, Util.UTF_8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
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
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment.limit += read;
            long j2 = read;
            this.size += j2;
            j -= j2;
        }
    }

    public String readUtf8Line(long j) throws EOFException {
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

    public ByteString snapshot(int i2) {
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i2, int i3, Charset charset) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i2, int i3) {
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

    private boolean rangeEquals(Segment segment, int i2, ByteString byteString, int i3, int i4) {
        int i5 = segment.limit;
        byte[] bArr = segment.data;
        while (i3 < i4) {
            if (i2 == i5) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
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

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = i3;
            Util.checkOffsetAndCount(bArr.length, i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i4 - i2, 8192 - writableSegment.limit);
                System.arraycopy(bArr, i2, writableSegment.data, writableSegment.limit, min);
                i2 += min;
                writableSegment.limit += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            Util.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
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
                Segment sharedCopy = segment.sharedCopy();
                int i4 = (int) (sharedCopy.pos + j);
                sharedCopy.pos = i4;
                sharedCopy.limit = Math.min(i4 + ((int) j2), sharedCopy.limit);
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

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
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

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
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

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
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

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        byte[] bArr;
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
                byte b2 = byteString.getByte(0);
                int size = byteString.size();
                long j6 = 1 + (this.size - size);
                long j7 = j;
                Segment segment2 = segment;
                long j8 = j4;
                while (j8 < j6) {
                    byte[] bArr2 = segment2.data;
                    int min = (int) Math.min(segment2.limit, (segment2.pos + j6) - j8);
                    int i2 = (int) ((segment2.pos + j7) - j8);
                    while (i2 < min) {
                        if (bArr2[i2] == b2) {
                            bArr = bArr2;
                            if (rangeEquals(segment2, i2 + 1, byteString, 1, size)) {
                                return (i2 - segment2.pos) + j8;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i2++;
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

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0L, j);
            while (j > 0) {
                Segment segment = buffer.head;
                if (j < segment.limit - segment.pos) {
                    Segment segment2 = this.head;
                    Segment segment3 = segment2 != null ? segment2.prev : null;
                    if (segment3 != null && segment3.owner) {
                        if ((segment3.limit + j) - (segment3.shared ? 0 : segment3.pos) <= 8192) {
                            buffer.head.writeTo(segment3, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    buffer.head = buffer.head.split((int) j);
                }
                Segment segment4 = buffer.head;
                long j2 = segment4.limit - segment4.pos;
                buffer.head = segment4.pop();
                Segment segment5 = this.head;
                if (segment5 == null) {
                    this.head = segment4;
                    segment4.prev = segment4;
                    segment4.next = segment4;
                } else {
                    segment5.prev.push(segment4).compact();
                }
                buffer.size -= j2;
                this.size += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
