package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes6.dex */
public final class CodedInputStream {
    public static final int BUFFER_SIZE = 4096;
    public static final int DEFAULT_RECURSION_LIMIT = 64;
    public static final int DEFAULT_SIZE_LIMIT = 67108864;
    public final byte[] buffer;
    public int bufferPos;
    public int bufferSize;
    public int bufferSizeAfterLimit;
    public int currentLimit;
    public final InputStream input;
    public int lastTag;
    public int recursionDepth;
    public int recursionLimit;
    public int sizeLimit;
    public int totalBytesRetired;

    public CodedInputStream(byte[] bArr, int i2, int i3) {
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = bArr;
        this.bufferSize = i3 + i2;
        this.bufferPos = i2;
        this.totalBytesRetired = -i2;
        this.input = null;
    }

    public static int decodeZigZag32(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    private void recomputeBufferSizeAfterLimit() {
        int i2 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i2;
        int i3 = this.totalBytesRetired + i2;
        int i4 = this.currentLimit;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.bufferSizeAfterLimit = i5;
            this.bufferSize = i2 - i5;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    private boolean refillBuffer(boolean z) throws IOException {
        int i2 = this.bufferPos;
        int i3 = this.bufferSize;
        if (i2 >= i3) {
            int i4 = this.totalBytesRetired;
            if (i4 + i3 == this.currentLimit) {
                if (z) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                return false;
            }
            this.totalBytesRetired = i4 + i3;
            this.bufferPos = 0;
            InputStream inputStream = this.input;
            int read = inputStream == null ? -1 : inputStream.read(this.buffer);
            this.bufferSize = read;
            if (read == 0 || read < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
            } else if (read == -1) {
                this.bufferSize = 0;
                if (z) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                return false;
            } else {
                recomputeBufferSizeAfterLimit();
                int i5 = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
                if (i5 > this.sizeLimit || i5 < 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                return true;
            }
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public void checkLastTagWas(int i2) throws InvalidProtocolBufferException {
        if (this.lastTag != i2) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        int i2 = this.currentLimit;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.totalBytesRetired + this.bufferPos);
    }

    public int getTotalBytesRead() {
        return this.totalBytesRetired + this.bufferPos;
    }

    public boolean isAtEnd() throws IOException {
        return this.bufferPos == this.bufferSize && !refillBuffer(false);
    }

    public void popLimit(int i2) {
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = i2 + this.totalBytesRetired + this.bufferPos;
            int i4 = this.currentLimit;
            if (i3 <= i4) {
                this.currentLimit = i3;
                recomputeBufferSizeAfterLimit();
                return i4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean readBool() throws IOException {
        return readRawVarint32() != 0;
    }

    public ByteString readBytes() throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 == 0) {
            return ByteString.EMPTY;
        }
        int i2 = this.bufferSize;
        int i3 = this.bufferPos;
        if (readRawVarint32 <= i2 - i3 && readRawVarint32 > 0) {
            ByteString copyFrom = ByteString.copyFrom(this.buffer, i3, readRawVarint32);
            this.bufferPos += readRawVarint32;
            return copyFrom;
        }
        return ByteString.copyFrom(readRawBytes(readRawVarint32));
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i3 = this.recursionDepth;
        if (i3 < this.recursionLimit) {
            this.recursionDepth = i3 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i2, 4));
            this.recursionDepth--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(true);
        }
        byte[] bArr = this.buffer;
        int i2 = this.bufferPos;
        this.bufferPos = i2 + 1;
        return bArr[i2];
    }

    public byte[] readRawBytes(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.totalBytesRetired;
            int i4 = this.bufferPos;
            int i5 = i3 + i4 + i2;
            int i6 = this.currentLimit;
            if (i5 <= i6) {
                int i7 = this.bufferSize;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.buffer, i4, bArr, 0, i2);
                    this.bufferPos += i2;
                    return bArr;
                } else if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.buffer, i4, bArr2, 0, i8);
                    this.bufferPos = this.bufferSize;
                    refillBuffer(true);
                    while (true) {
                        int i9 = i2 - i8;
                        int i10 = this.bufferSize;
                        if (i9 > i10) {
                            System.arraycopy(this.buffer, 0, bArr2, i8, i10);
                            int i11 = this.bufferSize;
                            i8 += i11;
                            this.bufferPos = i11;
                            refillBuffer(true);
                        } else {
                            System.arraycopy(this.buffer, 0, bArr2, i8, i9);
                            this.bufferPos = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.totalBytesRetired = i3 + i7;
                    this.bufferPos = 0;
                    this.bufferSize = 0;
                    int i12 = i7 - i4;
                    int i13 = i2 - i12;
                    ArrayList<byte[]> arrayList = new ArrayList();
                    while (i13 > 0) {
                        int min = Math.min(i13, 4096);
                        byte[] bArr3 = new byte[min];
                        int i14 = 0;
                        while (i14 < min) {
                            InputStream inputStream = this.input;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i14, min - i14);
                            if (read == -1) {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                            this.totalBytesRetired += read;
                            i14 += read;
                        }
                        i13 -= min;
                        arrayList.add(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.buffer, i4, bArr4, 0, i12);
                    for (byte[] bArr5 : arrayList) {
                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                        i12 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    public int readRawLittleEndian32() throws IOException {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    public long readRawLittleEndian64() throws IOException {
        byte readRawByte = readRawByte();
        byte readRawByte2 = readRawByte();
        return ((readRawByte2 & 255) << 8) | (readRawByte & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    public int readRawVarint32() throws IOException {
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
                        throw InvalidProtocolBufferException.malformedVarint();
                    }
                    return i5;
                }
                i2 = readRawByte4 << 21;
            }
        }
        return i3 | i2;
    }

    public long readRawVarint64() throws IOException {
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte readRawByte = readRawByte();
            j |= (readRawByte & ByteCompanionObject.MAX_VALUE) << i2;
            if ((readRawByte & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
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

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 <= this.bufferSize - this.bufferPos && readRawVarint32 > 0) {
            String str = new String(this.buffer, this.bufferPos, readRawVarint32, "UTF-8");
            this.bufferPos += readRawVarint32;
            return str;
        }
        return new String(readRawBytes(readRawVarint32), "UTF-8");
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
            return this.lastTag;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    @Deprecated
    public void readUnknownGroup(int i2, MessageLite.Builder builder) throws IOException {
        readGroup(i2, builder, (ExtensionRegistryLite) null);
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = -this.bufferPos;
    }

    public int setRecursionLimit(int i2) {
        if (i2 >= 0) {
            int i3 = this.recursionLimit;
            this.recursionLimit = i2;
            return i3;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i2);
    }

    public int setSizeLimit(int i2) {
        if (i2 >= 0) {
            int i3 = this.sizeLimit;
            this.sizeLimit = i2;
            return i3;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i2);
    }

    public boolean skipField(int i2) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            readInt32();
            return true;
        } else if (tagWireType == 1) {
            readRawLittleEndian64();
            return true;
        } else if (tagWireType == 2) {
            skipRawBytes(readRawVarint32());
            return true;
        } else if (tagWireType == 3) {
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i2), 4));
            return true;
        } else if (tagWireType != 4) {
            if (tagWireType == 5) {
                readRawLittleEndian32();
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        } else {
            return false;
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

    public void skipRawBytes(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.totalBytesRetired;
            int i4 = this.bufferPos;
            int i5 = i3 + i4 + i2;
            int i6 = this.currentLimit;
            if (i5 <= i6) {
                int i7 = this.bufferSize;
                if (i2 <= i7 - i4) {
                    this.bufferPos = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.bufferPos = i7;
                refillBuffer(true);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.bufferSize;
                    if (i9 > i10) {
                        i8 += i10;
                        this.bufferPos = i10;
                        refillBuffer(true);
                    } else {
                        this.bufferPos = i9;
                        return;
                    }
                }
            } else {
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i2, int i3) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i2, i3);
        try {
            codedInputStream.pushLimit(i3);
            return codedInputStream;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public <T extends MessageLite> T readGroup(int i2, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i3 = this.recursionDepth;
        if (i3 < this.recursionLimit) {
            this.recursionDepth = i3 + 1;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i2, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public static int readRawVarint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return readRawVarint32(read, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public CodedInputStream(InputStream inputStream) {
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public static int readRawVarint32(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i3 = i2 & 127;
        int i4 = 7;
        while (i4 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i3 |= (read & 127) << i4;
            if ((read & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        while (i4 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i3;
            }
            i4 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }
}
