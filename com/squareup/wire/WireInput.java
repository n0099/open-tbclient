package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class WireInput {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType = null;
    public static final int BUFFER_SIZE = 1024;
    public static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    public static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    public static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    public static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    public static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    public static final int RECURSION_LIMIT = 64;
    public static final String UTF_8 = "UTF-8";
    public final byte[] buffer;
    public long bufferOffset;
    public int currentLimit;
    public final InputStream input;
    public boolean inputStreamAtEof;
    public int lastTag;
    public int limit;
    public int pos;
    public int recursionDepth;

    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$WireType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[WireType.valuesCustom().length];
        try {
            iArr2[WireType.END_GROUP.ordinal()] = 5;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[WireType.FIXED32.ordinal()] = 6;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[WireType.FIXED64.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[WireType.LENGTH_DELIMITED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[WireType.START_GROUP.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$squareup$wire$WireType = iArr2;
        return iArr2;
    }

    public WireInput(InputStream inputStream) {
        this.bufferOffset = 0L;
        this.pos = 0;
        this.currentLimit = Integer.MAX_VALUE;
        this.input = inputStream;
        this.buffer = new byte[1024];
    }

    private int bytesRemaining() {
        return this.limit - this.pos;
    }

    public static int decodeZigZag32(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static WireInput newInstance(byte[] bArr) {
        return new WireInput(bArr, 0, bArr.length);
    }

    private void refillBuffer(int i2) throws IOException {
        int i3 = this.pos;
        if (i3 < this.limit || this.inputStreamAtEof) {
            return;
        }
        this.bufferOffset += i3;
        this.pos = 0;
        int min = Math.min(i2, 1024);
        int i4 = 0;
        while (i4 < min) {
            int read = this.input.read(this.buffer, i4, 1024 - i4);
            if (read == -1) {
                this.limit = i4;
                this.inputStreamAtEof = true;
                return;
            }
            i4 += read;
        }
        this.limit = i4;
        this.inputStreamAtEof = false;
    }

    private boolean skipField(int i2) throws IOException {
        switch ($SWITCH_TABLE$com$squareup$wire$WireType()[WireType.valueOf(i2).ordinal()]) {
            case 1:
                readVarint64();
                return false;
            case 2:
                readFixed64();
                return false;
            case 3:
                readRawBytes(readVarint32());
                return false;
            case 4:
                skipGroup();
                checkLastTagWas((i2 & (-8)) | WireType.END_GROUP.value());
                return false;
            case 5:
                return true;
            case 6:
                readFixed32();
                return false;
            default:
                throw new AssertionError();
        }
    }

    public void checkLastTagWas(int i2) throws IOException {
        if (this.lastTag != i2) {
            throw new IOException(PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
        }
    }

    public long getPosition() {
        return this.bufferOffset + this.pos;
    }

    public boolean isAtEnd() throws IOException {
        if (getPosition() == this.currentLimit) {
            return true;
        }
        refillBuffer(1);
        return bytesRemaining() == 0 && this.inputStreamAtEof;
    }

    public void popLimit(int i2) {
        this.currentLimit = i2;
    }

    public int pushLimit(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = (int) (i2 + this.bufferOffset + this.pos);
            int i4 = this.currentLimit;
            if (i3 <= i4) {
                this.currentLimit = i3;
                return i4;
            }
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
    }

    public ByteString readBytes() throws IOException {
        return readBytes(readVarint32());
    }

    public int readFixed32() throws IOException {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    public long readFixed64() throws IOException {
        byte readRawByte = readRawByte();
        byte readRawByte2 = readRawByte();
        return ((readRawByte2 & 255) << 8) | (readRawByte & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    public byte readRawByte() throws IOException {
        refillBuffer(1);
        if (bytesRemaining() != 0) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 + 1;
            return bArr[i2];
        }
        throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
    }

    public byte[] readRawBytes(int i2) throws IOException {
        if (i2 >= 0) {
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i2 - i3;
                refillBuffer(i4);
                if (bytesRemaining() != 0) {
                    int min = Math.min(i4, bytesRemaining());
                    System.arraycopy(this.buffer, this.pos, bArr, i3, min);
                    this.pos += min;
                    i3 += min;
                } else {
                    throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
                }
            }
            return bArr;
        }
        throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
    }

    public String readString() throws IOException {
        int readVarint32 = readVarint32();
        if (bytesRemaining() >= readVarint32) {
            String str = new String(this.buffer, this.pos, readVarint32, "UTF-8");
            this.pos += readVarint32;
            return str;
        }
        return new String(readRawBytes(readVarint32), "UTF-8");
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readVarint32 = readVarint32();
        this.lastTag = readVarint32;
        if (readVarint32 != 0) {
            return readVarint32;
        }
        throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
    }

    public int readVarint32() throws IOException {
        int i2;
        byte readRawByte = readRawByte();
        if (readRawByte >= 0) {
            return readRawByte;
        }
        int i3 = readRawByte & ByteCompanionObject.MAX_VALUE;
        byte readRawByte2 = readRawByte();
        if (readRawByte2 >= 0) {
            i2 = readRawByte2 << 7;
        } else {
            i3 |= (readRawByte2 & ByteCompanionObject.MAX_VALUE) << 7;
            byte readRawByte3 = readRawByte();
            if (readRawByte3 >= 0) {
                i2 = readRawByte3 << 14;
            } else {
                i3 |= (readRawByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                byte readRawByte4 = readRawByte();
                if (readRawByte4 < 0) {
                    int i4 = i3 | ((readRawByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                    byte readRawByte5 = readRawByte();
                    int i5 = i4 | (readRawByte5 << 28);
                    if (readRawByte5 < 0) {
                        for (int i6 = 0; i6 < 5; i6++) {
                            if (readRawByte() >= 0) {
                                return i5;
                            }
                        }
                        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
                    }
                    return i5;
                }
                i2 = readRawByte4 << 21;
            }
        }
        return i3 | i2;
    }

    public long readVarint64() throws IOException {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte readRawByte = readRawByte();
            j |= (readRawByte & ByteCompanionObject.MAX_VALUE) << i2;
            if ((readRawByte & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    public void skipGroup() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (!skipField(readTag));
    }

    public static WireInput newInstance(byte[] bArr, int i2, int i3) {
        return new WireInput(bArr, i2, i3);
    }

    public static WireInput newInstance(InputStream inputStream) {
        return new WireInput(inputStream);
    }

    public ByteString readBytes(int i2) throws IOException {
        if (bytesRemaining() >= i2) {
            ByteString of = ByteString.of(this.buffer, this.pos, i2);
            this.pos += i2;
            return of;
        }
        return ByteString.of(readRawBytes(i2));
    }

    public WireInput(byte[] bArr, int i2, int i3) {
        this.bufferOffset = 0L;
        this.pos = 0;
        this.currentLimit = Integer.MAX_VALUE;
        this.input = null;
        this.buffer = bArr;
        this.bufferOffset = -i2;
        this.pos = i2;
        this.limit = i2 + i3;
        this.inputStreamAtEof = true;
    }
}
