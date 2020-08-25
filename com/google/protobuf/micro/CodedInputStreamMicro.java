package com.google.protobuf.micro;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
/* loaded from: classes20.dex */
public final class CodedInputStreamMicro {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private int sizeLimit;
    private int totalBytesRetired;

    public static CodedInputStreamMicro newInstance(InputStream inputStream) {
        return new CodedInputStreamMicro(inputStream);
    }

    public static CodedInputStreamMicro newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStreamMicro newInstance(byte[] bArr, int i, int i2) {
        return new CodedInputStreamMicro(bArr, i, i2);
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readRawVarint32();
        if (this.lastTag == 0) {
            throw InvalidProtocolBufferMicroException.invalidTag();
        }
        return this.lastTag;
    }

    public void checkLastTagWas(int i) throws InvalidProtocolBufferMicroException {
        if (this.lastTag != i) {
            throw InvalidProtocolBufferMicroException.invalidEndTag();
        }
    }

    public boolean skipField(int i) throws IOException {
        switch (WireFormatMicro.getTagWireType(i)) {
            case 0:
                readInt32();
                return true;
            case 1:
                readRawLittleEndian64();
                return true;
            case 2:
                skipRawBytes(readRawVarint32());
                return true;
            case 3:
                skipMessage();
                checkLastTagWas(WireFormatMicro.makeTag(WireFormatMicro.getTagFieldNumber(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                readRawLittleEndian32();
                return true;
            default:
                throw InvalidProtocolBufferMicroException.invalidWireType();
        }
    }

    public void skipMessage() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag));
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public boolean readBool() throws IOException {
        return readRawVarint32() != 0;
    }

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 > this.bufferSize - this.bufferPos || readRawVarint32 <= 0) {
            return new String(readRawBytes(readRawVarint32), "UTF-8");
        }
        String str = new String(this.buffer, this.bufferPos, readRawVarint32, "UTF-8");
        this.bufferPos = readRawVarint32 + this.bufferPos;
        return str;
    }

    public void readGroup(MessageMicro messageMicro, int i) throws IOException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferMicroException.recursionLimitExceeded();
        }
        this.recursionDepth++;
        messageMicro.mergeFrom(this);
        checkLastTagWas(WireFormatMicro.makeTag(i, 4));
        this.recursionDepth--;
    }

    public void readMessage(MessageMicro messageMicro) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferMicroException.recursionLimitExceeded();
        }
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        messageMicro.mergeFrom(this);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
    }

    public ByteStringMicro readBytes() throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 > this.bufferSize - this.bufferPos || readRawVarint32 <= 0) {
            return ByteStringMicro.copyFrom(readRawBytes(readRawVarint32));
        }
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(this.buffer, this.bufferPos, readRawVarint32);
        this.bufferPos = readRawVarint32 + this.bufferPos;
        return copyFrom;
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public int readRawVarint32() throws IOException {
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
                throw InvalidProtocolBufferMicroException.malformedVarint();
            }
            return i5;
        }
        return readRawByte;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static int readRawVarint32(InputStream inputStream) throws IOException {
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i < 32) {
                int read = inputStream.read();
                if (read == -1) {
                    throw InvalidProtocolBufferMicroException.truncatedMessage();
                }
                i2 |= (read & 127) << i;
                if ((read & 128) == 0) {
                    break;
                }
                i += 7;
            } else {
                while (i < 64) {
                    int read2 = inputStream.read();
                    if (read2 == -1) {
                        throw InvalidProtocolBufferMicroException.truncatedMessage();
                    }
                    if ((read2 & 128) != 0) {
                        i += 7;
                    }
                }
                throw InvalidProtocolBufferMicroException.malformedVarint();
            }
        }
    }

    public long readRawVarint64() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readRawByte = readRawByte();
            j |= (readRawByte & Byte.MAX_VALUE) << i;
            if ((readRawByte & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferMicroException.malformedVarint();
    }

    public int readRawLittleEndian32() throws IOException {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    public long readRawLittleEndian64() throws IOException {
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

    private CodedInputStreamMicro(byte[] bArr, int i, int i2) {
        this.currentLimit = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = bArr;
        this.bufferSize = i + i2;
        this.bufferPos = i;
        this.input = null;
    }

    private CodedInputStreamMicro(InputStream inputStream) {
        this.currentLimit = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.input = inputStream;
    }

    public int setRecursionLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
        }
        int i2 = this.recursionLimit;
        this.recursionLimit = i;
        return i2;
    }

    public int setSizeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + i);
        }
        int i2 = this.sizeLimit;
        this.sizeLimit = i;
        return i2;
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = 0;
    }

    public int pushLimit(int i) throws InvalidProtocolBufferMicroException {
        if (i < 0) {
            throw InvalidProtocolBufferMicroException.negativeSize();
        }
        int i2 = this.totalBytesRetired + this.bufferPos + i;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw InvalidProtocolBufferMicroException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    private void recomputeBufferSizeAfterLimit() {
        this.bufferSize += this.bufferSizeAfterLimit;
        int i = this.totalBytesRetired + this.bufferSize;
        if (i > this.currentLimit) {
            this.bufferSizeAfterLimit = i - this.currentLimit;
            this.bufferSize -= this.bufferSizeAfterLimit;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    public void popLimit(int i) {
        this.currentLimit = i;
        recomputeBufferSizeAfterLimit();
    }

    public int getBytesUntilLimit() {
        if (this.currentLimit == Integer.MAX_VALUE) {
            return -1;
        }
        return this.currentLimit - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        return this.bufferPos == this.bufferSize && !refillBuffer(false);
    }

    private boolean refillBuffer(boolean z) throws IOException {
        if (this.bufferPos < this.bufferSize) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.totalBytesRetired + this.bufferSize == this.currentLimit) {
            if (z) {
                throw InvalidProtocolBufferMicroException.truncatedMessage();
            }
            return false;
        }
        this.totalBytesRetired += this.bufferSize;
        this.bufferPos = 0;
        this.bufferSize = this.input == null ? -1 : this.input.read(this.buffer);
        if (this.bufferSize == 0 || this.bufferSize < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
        }
        if (this.bufferSize == -1) {
            this.bufferSize = 0;
            if (z) {
                throw InvalidProtocolBufferMicroException.truncatedMessage();
            }
            return false;
        }
        recomputeBufferSizeAfterLimit();
        int i = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
        if (i > this.sizeLimit || i < 0) {
            throw InvalidProtocolBufferMicroException.sizeLimitExceeded();
        }
        return true;
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(true);
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i];
    }

    public byte[] readRawBytes(int i) throws IOException {
        if (i < 0) {
            throw InvalidProtocolBufferMicroException.negativeSize();
        }
        if (this.totalBytesRetired + this.bufferPos + i > this.currentLimit) {
            skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.bufferPos);
            throw InvalidProtocolBufferMicroException.truncatedMessage();
        } else if (i <= this.bufferSize - this.bufferPos) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.bufferPos, bArr, 0, i);
            this.bufferPos += i;
            return bArr;
        } else if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.bufferSize - this.bufferPos;
            System.arraycopy(this.buffer, this.bufferPos, bArr2, 0, i2);
            this.bufferPos = this.bufferSize;
            refillBuffer(true);
            while (i - i2 > this.bufferSize) {
                System.arraycopy(this.buffer, 0, bArr2, i2, this.bufferSize);
                i2 += this.bufferSize;
                this.bufferPos = this.bufferSize;
                refillBuffer(true);
            }
            System.arraycopy(this.buffer, 0, bArr2, i2, i - i2);
            this.bufferPos = i - i2;
            return bArr2;
        } else {
            int i3 = this.bufferPos;
            int i4 = this.bufferSize;
            this.totalBytesRetired += this.bufferSize;
            this.bufferPos = 0;
            this.bufferSize = 0;
            Vector vector = new Vector();
            int i5 = i - (i4 - i3);
            while (i5 > 0) {
                byte[] bArr3 = new byte[Math.min(i5, 4096)];
                int i6 = 0;
                while (i6 < bArr3.length) {
                    int read = this.input == null ? -1 : this.input.read(bArr3, i6, bArr3.length - i6);
                    if (read == -1) {
                        throw InvalidProtocolBufferMicroException.truncatedMessage();
                    }
                    this.totalBytesRetired += read;
                    i6 += read;
                }
                vector.addElement(bArr3);
                i5 -= bArr3.length;
            }
            byte[] bArr4 = new byte[i];
            int i7 = i4 - i3;
            System.arraycopy(this.buffer, i3, bArr4, 0, i7);
            int i8 = i7;
            for (int i9 = 0; i9 < vector.size(); i9++) {
                byte[] bArr5 = (byte[]) vector.elementAt(i9);
                System.arraycopy(bArr5, 0, bArr4, i8, bArr5.length);
                i8 += bArr5.length;
            }
            return bArr4;
        }
    }

    public void skipRawBytes(int i) throws IOException {
        if (i < 0) {
            throw InvalidProtocolBufferMicroException.negativeSize();
        }
        if (this.totalBytesRetired + this.bufferPos + i > this.currentLimit) {
            skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.bufferPos);
            throw InvalidProtocolBufferMicroException.truncatedMessage();
        } else if (i <= this.bufferSize - this.bufferPos) {
            this.bufferPos += i;
        } else {
            int i2 = this.bufferSize - this.bufferPos;
            this.totalBytesRetired += this.bufferSize;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int i3 = i2;
            while (i3 < i) {
                int skip = this.input == null ? -1 : (int) this.input.skip(i - i3);
                if (skip <= 0) {
                    throw InvalidProtocolBufferMicroException.truncatedMessage();
                }
                i3 += skip;
                this.totalBytesRetired = skip + this.totalBytesRetired;
            }
        }
    }
}
