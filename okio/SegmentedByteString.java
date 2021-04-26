package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class SegmentedByteString extends ByteString {
    public final transient int[] directory;
    public final transient byte[][] segments;

    public SegmentedByteString(Buffer buffer, int i2) {
        super(null);
        Util.checkOffsetAndCount(buffer.size, 0L, i2);
        Segment segment = buffer.head;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = segment.limit;
            int i7 = segment.pos;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i5];
        this.directory = new int[i5 * 2];
        Segment segment2 = buffer.head;
        int i8 = 0;
        while (i3 < i2) {
            this.segments[i8] = segment2.data;
            i3 += segment2.limit - segment2.pos;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.directory;
            iArr[i8] = i3;
            iArr[this.segments.length + i8] = segment2.pos;
            segment2.shared = true;
            i8++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i2) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return toByteString();
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public byte getByte(int i2) {
        Util.checkOffsetAndCount(this.directory[this.segments.length - 1], i2, 1L);
        int segment = segment(i2);
        int i3 = segment == 0 ? 0 : this.directory[segment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(i2 - i3) + iArr[bArr.length + segment]];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        int length = this.segments.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.segments[i3];
            int[] iArr = this.directory;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.hashCode = i5;
        return i5;
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i2) {
        return toByteString().indexOf(bArr, i2);
    }

    @Override // okio.ByteString
    public byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i2) {
        return toByteString().lastIndexOf(bArr, i2);
    }

    @Override // okio.ByteString
    public ByteString md5() {
        return toByteString().md5();
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i2, ByteString byteString, int i3, int i4) {
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int segment = segment(i2);
        while (i4 > 0) {
            int i5 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i4, ((this.directory[segment] - i5) + i5) - i2);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i3, bArr[segment], (i2 - i5) + iArr[bArr.length + segment], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i2) {
        return toByteString().substring(i2);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.directory;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.segments[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public String utf8() {
        return toByteString().utf8();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int[] iArr = this.directory;
                int i4 = iArr[length + i2];
                int i5 = iArr[i2];
                outputStream.write(this.segments[i2], i4, i5 - i3);
                i2++;
                i3 = i5;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.ByteString
    public ByteString substring(int i2, int i3) {
        return toByteString().substring(i2, i3);
    }

    @Override // okio.ByteString
    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            Segment segment = new Segment(this.segments[i2], i4, (i4 + i5) - i3, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.prev.push(segment);
            }
            i2++;
            i3 = i5;
        }
        buffer.size += i3;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int segment = segment(i2);
        while (i4 > 0) {
            int i5 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i4, ((this.directory[segment] - i5) + i5) - i2);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.arrayRangeEquals(bArr2[segment], (i2 - i5) + iArr[bArr2.length + segment], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            segment++;
        }
        return true;
    }
}
