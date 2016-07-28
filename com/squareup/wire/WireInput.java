package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
final class WireInput {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType = null;
    private static final int BUFFER_SIZE = 1024;
    private static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    private static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    private static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    private static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    private static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    public static final int RECURSION_LIMIT = 64;
    private static final String UTF_8 = "UTF-8";
    private final byte[] buffer;
    private long bufferOffset;
    private int currentLimit;
    private final InputStream input;
    private boolean inputStreamAtEof;
    private int lastTag;
    private int limit;
    private int pos;
    public int recursionDepth;

    static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$WireType;
        if (iArr == null) {
            iArr = new int[WireType.valuesCustom().length];
            try {
                iArr[WireType.END_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WireType.FIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WireType.FIXED64.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WireType.LENGTH_DELIMITED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WireType.START_GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[WireType.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            $SWITCH_TABLE$com$squareup$wire$WireType = iArr;
        }
        return iArr;
    }

    public static WireInput newInstance(byte[] bArr) {
        return new WireInput(bArr, 0, bArr.length);
    }

    public static WireInput newInstance(byte[] bArr, int i, int i2) {
        return new WireInput(bArr, i, i2);
    }

    public static WireInput newInstance(InputStream inputStream) {
        return new WireInput(inputStream);
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readVarint32();
        if (this.lastTag == 0) {
            throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
        }
        return this.lastTag;
    }

    public void checkLastTagWas(int i) throws IOException {
        if (this.lastTag != i) {
            throw new IOException(PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
        }
    }

    public String readString() throws IOException {
        int readVarint32 = readVarint32();
        if (bytesRemaining() >= readVarint32) {
            String str = new String(this.buffer, this.pos, readVarint32, UTF_8);
            this.pos = readVarint32 + this.pos;
            return str;
        }
        return new String(readRawBytes(readVarint32), UTF_8);
    }

    private int bytesRemaining() {
        return this.limit - this.pos;
    }

    public ByteString readBytes() throws IOException {
        return readBytes(readVarint32());
    }

    public ByteString readBytes(int i) throws IOException {
        if (bytesRemaining() >= i) {
            ByteString of = ByteString.of(this.buffer, this.pos, i);
            this.pos += i;
            return of;
        }
        return ByteString.of(readRawBytes(i));
    }

    public int readVarint32() throws IOException {
        byte readRawByte = readRawByte();
        if (readRawByte < 0) {
            int i = readRawByte & Byte.MAX_VALUE;
            byte readRawByte2 = readRawByte();
            if (readRawByte2 >= 0) {
                return i | (readRawByte2 << 7);
            }
            int i2 = i | ((readRawByte2 & Byte.MAX_VALUE) << 7);
            byte readRawByte3 = readRawByte();
            if (readRawByte3 >= 0) {
                return i2 | (readRawByte3 << 14);
            }
            int i3 = i2 | ((readRawByte3 & Byte.MAX_VALUE) << 14);
            byte readRawByte4 = readRawByte();
            if (readRawByte4 >= 0) {
                return i3 | (readRawByte4 << 21);
            }
            int i4 = i3 | ((readRawByte4 & Byte.MAX_VALUE) << 21);
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
        return readRawByte;
    }

    public long readVarint64() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readRawByte = readRawByte();
            j |= (readRawByte & Byte.MAX_VALUE) << i;
            if ((readRawByte & 128) == 0) {
                return j;
            }
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=4] */
    public int readFixed32() throws IOException {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [224=8] */
    public long readFixed64() throws IOException {
        byte readRawByte = readRawByte();
        byte readRawByte2 = readRawByte();
        return ((readRawByte2 & 255) << 8) | (readRawByte & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    public static int decodeZigZag32(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long decodeZigZag64(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private WireInput(InputStream inputStream) {
        this.bufferOffset = 0L;
        this.pos = 0;
        this.currentLimit = Integer.MAX_VALUE;
        this.input = inputStream;
        this.buffer = new byte[1024];
    }

    private WireInput(byte[] bArr, int i, int i2) {
        this.bufferOffset = 0L;
        this.pos = 0;
        this.currentLimit = Integer.MAX_VALUE;
        this.input = null;
        this.buffer = bArr;
        this.bufferOffset = -i;
        this.pos = i;
        this.limit = i + i2;
        this.inputStreamAtEof = true;
    }

    private void refillBuffer(int i) throws IOException {
        if (this.pos >= this.limit && !this.inputStreamAtEof) {
            this.bufferOffset += this.pos;
            this.pos = 0;
            int min = Math.min(i, 1024);
            int i2 = 0;
            while (i2 < min) {
                int read = this.input.read(this.buffer, i2, 1024 - i2);
                if (read == -1) {
                    this.limit = i2;
                    this.inputStreamAtEof = true;
                    return;
                }
                i2 += read;
            }
            this.limit = i2;
            this.inputStreamAtEof = false;
        }
    }

    public int pushLimit(int i) throws IOException {
        if (i < 0) {
            throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
        }
        int i2 = (int) (i + this.bufferOffset + this.pos);
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        this.currentLimit = i2;
        return i3;
    }

    public void popLimit(int i) {
        this.currentLimit = i;
    }

    public boolean isAtEnd() throws IOException {
        if (getPosition() == this.currentLimit) {
            return true;
        }
        refillBuffer(1);
        return bytesRemaining() == 0 && this.inputStreamAtEof;
    }

    public long getPosition() {
        return this.bufferOffset + this.pos;
    }

    public byte readRawByte() throws IOException {
        refillBuffer(1);
        if (bytesRemaining() == 0) {
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public byte[] readRawBytes(int i) throws IOException {
        if (i < 0) {
            throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            refillBuffer(i - i2);
            if (bytesRemaining() == 0) {
                throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
            }
            int min = Math.min(i - i2, bytesRemaining());
            System.arraycopy(this.buffer, this.pos, bArr, i2, min);
            this.pos += min;
            i2 += min;
        }
        return bArr;
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

    private boolean skipField(int i) throws IOException {
        switch ($SWITCH_TABLE$com$squareup$wire$WireType()[WireType.valueOf(i).ordinal()]) {
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
                checkLastTagWas((i & (-8)) | WireType.END_GROUP.value());
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
}
