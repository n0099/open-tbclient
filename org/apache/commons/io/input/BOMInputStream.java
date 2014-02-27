package org.apache.commons.io.input;

import android.support.v4.view.MotionEventCompat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.ByteOrderMark;
/* loaded from: classes.dex */
public class BOMInputStream extends ProxyInputStream {
    private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>() { // from class: org.apache.commons.io.input.BOMInputStream.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public final int compare(ByteOrderMark byteOrderMark, ByteOrderMark byteOrderMark2) {
            int length = byteOrderMark.length();
            int length2 = byteOrderMark2.length();
            if (length > length2) {
                return -1;
            }
            if (length2 > length) {
                return 1;
            }
            return 0;
        }
    };
    private final List<ByteOrderMark> boms;
    private ByteOrderMark byteOrderMark;
    private int fbIndex;
    private int fbLength;
    private int[] firstBytes;
    private final boolean include;
    private int markFbIndex;
    private boolean markedAtStart;

    public BOMInputStream(InputStream inputStream) {
        this(inputStream, false, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, boolean z) {
        this(inputStream, z, ByteOrderMark.UTF_8);
    }

    public BOMInputStream(InputStream inputStream, ByteOrderMark... byteOrderMarkArr) {
        this(inputStream, false, byteOrderMarkArr);
    }

    public BOMInputStream(InputStream inputStream, boolean z, ByteOrderMark... byteOrderMarkArr) {
        super(inputStream);
        if (byteOrderMarkArr == null || byteOrderMarkArr.length == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.include = z;
        Arrays.sort(byteOrderMarkArr, ByteOrderMarkLengthComparator);
        this.boms = Arrays.asList(byteOrderMarkArr);
    }

    public boolean hasBOM() {
        return getBOM() != null;
    }

    public boolean hasBOM(ByteOrderMark byteOrderMark) {
        if (this.boms.contains(byteOrderMark)) {
            return this.byteOrderMark != null && getBOM().equals(byteOrderMark);
        }
        throw new IllegalArgumentException("Stream not configure to detect " + byteOrderMark);
    }

    public ByteOrderMark getBOM() {
        if (this.firstBytes == null) {
            this.fbLength = 0;
            this.firstBytes = new int[this.boms.get(0).length()];
            for (int i = 0; i < this.firstBytes.length; i++) {
                this.firstBytes[i] = this.in.read();
                this.fbLength++;
                if (this.firstBytes[i] < 0) {
                    break;
                }
            }
            this.byteOrderMark = find();
            if (this.byteOrderMark != null && !this.include) {
                if (this.byteOrderMark.length() < this.firstBytes.length) {
                    this.fbIndex = this.byteOrderMark.length();
                } else {
                    this.fbLength = 0;
                }
            }
        }
        return this.byteOrderMark;
    }

    public String getBOMCharsetName() {
        getBOM();
        if (this.byteOrderMark == null) {
            return null;
        }
        return this.byteOrderMark.getCharsetName();
    }

    private int readFirstBytes() {
        getBOM();
        if (this.fbIndex < this.fbLength) {
            int[] iArr = this.firstBytes;
            int i = this.fbIndex;
            this.fbIndex = i + 1;
            return iArr[i];
        }
        return -1;
    }

    private ByteOrderMark find() {
        for (ByteOrderMark byteOrderMark : this.boms) {
            if (matches(byteOrderMark)) {
                return byteOrderMark;
            }
        }
        return null;
    }

    private boolean matches(ByteOrderMark byteOrderMark) {
        for (int i = 0; i < byteOrderMark.length(); i++) {
            if (byteOrderMark.get(i) != this.firstBytes[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int readFirstBytes = readFirstBytes();
        return readFirstBytes >= 0 ? readFirstBytes : this.in.read();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i2 > 0 && i4 >= 0) {
            i4 = readFirstBytes();
            if (i4 >= 0) {
                bArr[i] = (byte) (i4 & MotionEventCompat.ACTION_MASK);
                i2--;
                i3++;
                i++;
            }
        }
        int read = this.in.read(bArr, i, i2);
        if (read < 0) {
            if (i3 > 0) {
                return i3;
            }
            return -1;
        }
        return i3 + read;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.markFbIndex = this.fbIndex;
        this.markedAtStart = this.firstBytes == null;
        this.in.mark(i);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        this.fbIndex = this.markFbIndex;
        if (this.markedAtStart) {
            this.firstBytes = null;
        }
        this.in.reset();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        while (j > 0 && readFirstBytes() >= 0) {
            j--;
        }
        return this.in.skip(j);
    }
}
