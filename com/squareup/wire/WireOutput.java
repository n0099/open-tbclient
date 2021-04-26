package com.squareup.wire;

import com.alibaba.fastjson.asm.Label;
import com.alipay.sdk.encrypt.a;
import java.io.IOException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes6.dex */
public final class WireOutput {
    public final byte[] buffer;
    public final int limit;
    public int position;

    public WireOutput(byte[] bArr, int i2, int i3) {
        this.buffer = bArr;
        this.position = i2;
        this.limit = i2 + i3;
    }

    public static int int32Size(int i2) {
        if (i2 >= 0) {
            return varint32Size(i2);
        }
        return 10;
    }

    public static int int64Size(long j) {
        if (j >= 0) {
            return varint64Size(j);
        }
        return 10;
    }

    public static int makeTag(int i2, WireType wireType) {
        return (i2 << 3) | wireType.value();
    }

    public static int messageHeaderSize(int i2, int i3) {
        return tagSize(i2, WireType.LENGTH_DELIMITED) + int32Size(i3);
    }

    public static int messageSize(int i2, int i3) {
        return tagSize(i2, WireType.LENGTH_DELIMITED) + int32Size(i3) + i3;
    }

    public static WireOutput newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static int tagSize(int i2, WireType wireType) {
        return int32Size(makeTag(i2, wireType));
    }

    public static int varint32Size(int i2) {
        if ((i2 & a.f1872g) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & Label.FORWARD_REFERENCE_TYPE_MASK) == 0 ? 4 : 5;
    }

    public static int varint64Size(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if ((CoroutineScheduler.PARKED_VERSION_MASK & j) == 0) {
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
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int varintTagSize(int i2) {
        return varint32Size(makeTag(i2, WireType.VARINT));
    }

    public static int writeMessageHeader(int i2, byte[] bArr, int i3, int i4) {
        int writeTag = writeTag(i2, WireType.LENGTH_DELIMITED, bArr, i3) + i3;
        return (writeTag + writeVarint(i4, bArr, writeTag)) - i3;
    }

    public static int writeTag(int i2, WireType wireType, byte[] bArr, int i3) {
        return writeVarint(makeTag(i2, wireType), bArr, i3);
    }

    public static int writeVarint(long j, byte[] bArr, int i2) {
        int i3 = i2;
        while (((-128) & j) != 0) {
            bArr[i3] = (byte) ((127 & j) | 128);
            j >>>= 7;
            i3++;
        }
        bArr[i3] = (byte) j;
        return (i3 + 1) - i2;
    }

    public static int zigZag32(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long zigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public void writeFixed32(int i2) throws IOException {
        writeRawByte(i2 & 255);
        writeRawByte((i2 >> 8) & 255);
        writeRawByte((i2 >> 16) & 255);
        writeRawByte((i2 >> 24) & 255);
    }

    public void writeFixed64(long j) throws IOException {
        writeRawByte(((int) j) & 255);
        writeRawByte(((int) (j >> 8)) & 255);
        writeRawByte(((int) (j >> 16)) & 255);
        writeRawByte(((int) (j >> 24)) & 255);
        writeRawByte(((int) (j >> 32)) & 255);
        writeRawByte(((int) (j >> 40)) & 255);
        writeRawByte(((int) (j >> 48)) & 255);
        writeRawByte(((int) (j >> 56)) & 255);
    }

    public void writeRawByte(byte b2) throws IOException {
        int i2 = this.position;
        if (i2 != this.limit) {
            byte[] bArr = this.buffer;
            this.position = i2 + 1;
            bArr[i2] = b2;
            return;
        }
        throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeSignedVarint32(int i2) throws IOException {
        if (i2 >= 0) {
            writeVarint32(i2);
        } else {
            writeVarint64(i2);
        }
    }

    public void writeVarint32(int i2) throws IOException {
        while ((i2 & a.f1872g) != 0) {
            writeRawByte((i2 & 127) | 128);
            i2 >>>= 7;
        }
        writeRawByte(i2);
    }

    public void writeVarint64(long j) throws IOException {
        while (((-128) & j) != 0) {
            writeRawByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    public static WireOutput newInstance(byte[] bArr, int i2, int i3) {
        return new WireOutput(bArr, i2, i3);
    }

    public void writeRawBytes(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.limit;
        int i5 = this.position;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.buffer, i5, i3);
            this.position += i3;
            return;
        }
        throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
    }

    public void writeTag(int i2, WireType wireType) throws IOException {
        writeVarint32(makeTag(i2, wireType));
    }

    public void writeRawByte(int i2) throws IOException {
        writeRawByte((byte) i2);
    }
}
