package com.squareup.wire;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
/* loaded from: classes.dex */
public final class WireOutput {
    private final byte[] buffer;
    private final int limit;
    private int position;

    public static int int32Size(int i) {
        if (i >= 0) {
            return varint32Size(i);
        }
        return 10;
    }

    public static int int64Size(long j) {
        if (j >= 0) {
            return varint64Size(j);
        }
        return 10;
    }

    public static int tagSize(int i, WireType wireType) {
        return int32Size(makeTag(i, wireType));
    }

    public static int messageSize(int i, int i2) {
        return tagSize(i, WireType.LENGTH_DELIMITED) + int32Size(i2) + i2;
    }

    public static int writeTag(int i, WireType wireType, byte[] bArr, int i2) {
        return writeVarint(makeTag(i, wireType), bArr, i2);
    }

    public static int writeVarint(long j, byte[] bArr, int i) {
        int i2 = i;
        while (((-128) & j) != 0) {
            bArr[i2] = (byte) ((127 & j) | 128);
            j >>>= 7;
            i2++;
        }
        bArr[i2] = (byte) j;
        return (i2 + 1) - i;
    }

    public static int messageHeaderSize(int i, int i2) {
        return tagSize(i, WireType.LENGTH_DELIMITED) + int32Size(i2);
    }

    public static int writeMessageHeader(int i, byte[] bArr, int i2, int i3) {
        int writeTag = writeTag(i, WireType.LENGTH_DELIMITED, bArr, i2) + i2;
        return (writeTag + writeVarint(i3, bArr, writeTag)) - i2;
    }

    public static int makeTag(int i, WireType wireType) {
        return (i << 3) | wireType.value();
    }

    private WireOutput(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.limit = i + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WireOutput newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WireOutput newInstance(byte[] bArr, int i, int i2) {
        return new WireOutput(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int varintTagSize(int i) {
        return varint32Size(makeTag(i, WireType.VARINT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int varint32Size(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int varint64Size(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    void writeRawByte(byte b) {
        if (this.position == this.limit) {
            throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeRawByte(int i) {
        writeRawByte((byte) i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeRawBytes(byte[] bArr) {
        writeRawBytes(bArr, 0, bArr.length);
    }

    void writeRawBytes(byte[] bArr, int i, int i2) {
        if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTag(int i, WireType wireType) {
        writeVarint32(makeTag(i, wireType));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeSignedVarint32(int i) {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeVarint32(int i) {
        while ((i & (-128)) != 0) {
            writeRawByte((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeVarint64(long j) {
        while (((-128) & j) != 0) {
            writeRawByte((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeFixed32(int i) {
        writeRawByte(i & MotionEventCompat.ACTION_MASK);
        writeRawByte((i >> 8) & MotionEventCompat.ACTION_MASK);
        writeRawByte((i >> 16) & MotionEventCompat.ACTION_MASK);
        writeRawByte((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeFixed64(long j) {
        writeRawByte(((int) j) & MotionEventCompat.ACTION_MASK);
        writeRawByte(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        writeRawByte(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        writeRawByte(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        writeRawByte(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        writeRawByte(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        writeRawByte(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        writeRawByte(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zigZag32(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zigZag64(long j) {
        return (j << 1) ^ (j >> 63);
    }
}
