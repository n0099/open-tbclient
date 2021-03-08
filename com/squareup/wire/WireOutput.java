package com.squareup.wire;

import com.thunder.livesdk.system.ThunderNetStateService;
import java.io.IOException;
/* loaded from: classes4.dex */
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

    void writeRawByte(byte b) throws IOException {
        if (this.position == this.limit) {
            throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeRawByte(int i) throws IOException {
        writeRawByte((byte) i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    void writeRawBytes(byte[] bArr, int i, int i2) throws IOException {
        if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTag(int i, WireType wireType) throws IOException {
        writeVarint32(makeTag(i, wireType));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeSignedVarint32(int i) throws IOException {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeVarint32(int i) throws IOException {
        while ((i & (-128)) != 0) {
            writeRawByte((i & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeVarint64(long j) throws IOException {
        while (((-128) & j) != 0) {
            writeRawByte((((int) j) & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeFixed32(int i) throws IOException {
        writeRawByte(i & 255);
        writeRawByte((i >> 8) & 255);
        writeRawByte((i >> 16) & 255);
        writeRawByte((i >> 24) & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zigZag32(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zigZag64(long j) {
        return (j << 1) ^ (j >> 63);
    }
}
