package com.google.protobuf;

import com.alibaba.fastjson.asm.Label;
import com.alipay.sdk.encrypt.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes6.dex */
public final class CodedOutputStream {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    public final byte[] buffer;
    public final int limit;
    public final OutputStream output;
    public int position;

    /* loaded from: classes6.dex */
    public static class OutOfSpaceException extends IOException {
        public static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public CodedOutputStream(byte[] bArr, int i2, int i3) {
        this.output = null;
        this.buffer = bArr;
        this.position = i2;
        this.limit = i2 + i3;
    }

    public static int computeBoolSize(int i2, boolean z) {
        return computeTagSize(i2) + computeBoolSizeNoTag(z);
    }

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeBytesSize(int i2, ByteString byteString) {
        return computeTagSize(i2) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeRawVarint32Size(byteString.size()) + byteString.size();
    }

    public static int computeDoubleSize(int i2, double d2) {
        return computeTagSize(i2) + computeDoubleSizeNoTag(d2);
    }

    public static int computeDoubleSizeNoTag(double d2) {
        return 8;
    }

    public static int computeEnumSize(int i2, int i3) {
        return computeTagSize(i2) + computeEnumSizeNoTag(i3);
    }

    public static int computeEnumSizeNoTag(int i2) {
        return computeInt32SizeNoTag(i2);
    }

    public static int computeFixed32Size(int i2, int i3) {
        return computeTagSize(i2) + computeFixed32SizeNoTag(i3);
    }

    public static int computeFixed32SizeNoTag(int i2) {
        return 4;
    }

    public static int computeFixed64Size(int i2, long j) {
        return computeTagSize(i2) + computeFixed64SizeNoTag(j);
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i2, float f2) {
        return computeTagSize(i2) + computeFloatSizeNoTag(f2);
    }

    public static int computeFloatSizeNoTag(float f2) {
        return 4;
    }

    public static int computeGroupSize(int i2, MessageLite messageLite) {
        return (computeTagSize(i2) * 2) + computeGroupSizeNoTag(messageLite);
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i2, int i3) {
        return computeTagSize(i2) + computeInt32SizeNoTag(i3);
    }

    public static int computeInt32SizeNoTag(int i2) {
        if (i2 >= 0) {
            return computeRawVarint32Size(i2);
        }
        return 10;
    }

    public static int computeInt64Size(int i2, long j) {
        return computeTagSize(i2) + computeInt64SizeNoTag(j);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i2, LazyField lazyField) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeLazyFieldSize(3, lazyField);
    }

    public static int computeLazyFieldSize(int i2, LazyField lazyField) {
        return computeTagSize(i2) + computeLazyFieldSizeNoTag(lazyField);
    }

    public static int computeLazyFieldSizeNoTag(LazyField lazyField) {
        int serializedSize = lazyField.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeMessageSetExtensionSize(int i2, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i2, MessageLite messageLite) {
        return computeTagSize(i2) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computePreferredBufferSize(int i2) {
        if (i2 > 4096) {
            return 4096;
        }
        return i2;
    }

    public static int computeRawMessageSetExtensionSize(int i2, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeBytesSize(3, byteString);
    }

    public static int computeRawVarint32Size(int i2) {
        if ((i2 & a.f1885g) == 0) {
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

    public static int computeRawVarint64Size(long j) {
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

    public static int computeSFixed32Size(int i2, int i3) {
        return computeTagSize(i2) + computeSFixed32SizeNoTag(i3);
    }

    public static int computeSFixed32SizeNoTag(int i2) {
        return 4;
    }

    public static int computeSFixed64Size(int i2, long j) {
        return computeTagSize(i2) + computeSFixed64SizeNoTag(j);
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32Size(int i2, int i3) {
        return computeTagSize(i2) + computeSInt32SizeNoTag(i3);
    }

    public static int computeSInt32SizeNoTag(int i2) {
        return computeRawVarint32Size(encodeZigZag32(i2));
    }

    public static int computeSInt64Size(int i2, long j) {
        return computeTagSize(i2) + computeSInt64SizeNoTag(j);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeRawVarint64Size(encodeZigZag64(j));
    }

    public static int computeStringSize(int i2, String str) {
        return computeTagSize(i2) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported.", e2);
        }
    }

    public static int computeTagSize(int i2) {
        return computeRawVarint32Size(WireFormat.makeTag(i2, 0));
    }

    public static int computeUInt32Size(int i2, int i3) {
        return computeTagSize(i2) + computeUInt32SizeNoTag(i3);
    }

    public static int computeUInt32SizeNoTag(int i2) {
        return computeRawVarint32Size(i2);
    }

    public static int computeUInt64Size(int i2, long j) {
        return computeTagSize(i2) + computeUInt64SizeNoTag(j);
    }

    public static int computeUInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    @Deprecated
    public static int computeUnknownGroupSize(int i2, MessageLite messageLite) {
        return computeGroupSize(i2, messageLite);
    }

    @Deprecated
    public static int computeUnknownGroupSizeNoTag(MessageLite messageLite) {
        return computeGroupSizeNoTag(messageLite);
    }

    public static int encodeZigZag32(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    private void refreshBuffer() throws IOException {
        OutputStream outputStream = this.output;
        if (outputStream != null) {
            outputStream.write(this.buffer, 0, this.position);
            this.position = 0;
            return;
        }
        throw new OutOfSpaceException();
    }

    public void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void flush() throws IOException {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public int spaceLeft() {
        if (this.output == null) {
            return this.limit - this.position;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void writeBool(int i2, boolean z) throws IOException {
        writeTag(i2, 0);
        writeBoolNoTag(z);
    }

    public void writeBoolNoTag(boolean z) throws IOException {
        writeRawByte(z ? 1 : 0);
    }

    public void writeBytes(int i2, ByteString byteString) throws IOException {
        writeTag(i2, 2);
        writeBytesNoTag(byteString);
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeDouble(int i2, double d2) throws IOException {
        writeTag(i2, 1);
        writeDoubleNoTag(d2);
    }

    public void writeDoubleNoTag(double d2) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d2));
    }

    public void writeEnum(int i2, int i3) throws IOException {
        writeTag(i2, 0);
        writeEnumNoTag(i3);
    }

    public void writeEnumNoTag(int i2) throws IOException {
        writeInt32NoTag(i2);
    }

    public void writeFixed32(int i2, int i3) throws IOException {
        writeTag(i2, 5);
        writeFixed32NoTag(i3);
    }

    public void writeFixed32NoTag(int i2) throws IOException {
        writeRawLittleEndian32(i2);
    }

    public void writeFixed64(int i2, long j) throws IOException {
        writeTag(i2, 1);
        writeFixed64NoTag(j);
    }

    public void writeFixed64NoTag(long j) throws IOException {
        writeRawLittleEndian64(j);
    }

    public void writeFloat(int i2, float f2) throws IOException {
        writeTag(i2, 5);
        writeFloatNoTag(f2);
    }

    public void writeFloatNoTag(float f2) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(f2));
    }

    public void writeGroup(int i2, MessageLite messageLite) throws IOException {
        writeTag(i2, 3);
        writeGroupNoTag(messageLite);
        writeTag(i2, 4);
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public void writeInt32(int i2, int i3) throws IOException {
        writeTag(i2, 0);
        writeInt32NoTag(i3);
    }

    public void writeInt32NoTag(int i2) throws IOException {
        if (i2 >= 0) {
            writeRawVarint32(i2);
        } else {
            writeRawVarint64(i2);
        }
    }

    public void writeInt64(int i2, long j) throws IOException {
        writeTag(i2, 0);
        writeInt64NoTag(j);
    }

    public void writeInt64NoTag(long j) throws IOException {
        writeRawVarint64(j);
    }

    public void writeMessage(int i2, MessageLite messageLite) throws IOException {
        writeTag(i2, 2);
        writeMessageNoTag(messageLite);
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i2);
        writeMessage(3, messageLite);
        writeTag(1, 4);
    }

    public void writeRawByte(byte b2) throws IOException {
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b2;
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        writeRawBytes(byteString, 0, byteString.size());
    }

    public void writeRawLittleEndian32(int i2) throws IOException {
        writeRawByte(i2 & 255);
        writeRawByte((i2 >> 8) & 255);
        writeRawByte((i2 >> 16) & 255);
        writeRawByte((i2 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j) throws IOException {
        writeRawByte(((int) j) & 255);
        writeRawByte(((int) (j >> 8)) & 255);
        writeRawByte(((int) (j >> 16)) & 255);
        writeRawByte(((int) (j >> 24)) & 255);
        writeRawByte(((int) (j >> 32)) & 255);
        writeRawByte(((int) (j >> 40)) & 255);
        writeRawByte(((int) (j >> 48)) & 255);
        writeRawByte(((int) (j >> 56)) & 255);
    }

    public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i2);
        writeBytes(3, byteString);
        writeTag(1, 4);
    }

    public void writeRawVarint32(int i2) throws IOException {
        while ((i2 & a.f1885g) != 0) {
            writeRawByte((i2 & 127) | 128);
            i2 >>>= 7;
        }
        writeRawByte(i2);
    }

    public void writeRawVarint64(long j) throws IOException {
        while (((-128) & j) != 0) {
            writeRawByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    public void writeSFixed32(int i2, int i3) throws IOException {
        writeTag(i2, 5);
        writeSFixed32NoTag(i3);
    }

    public void writeSFixed32NoTag(int i2) throws IOException {
        writeRawLittleEndian32(i2);
    }

    public void writeSFixed64(int i2, long j) throws IOException {
        writeTag(i2, 1);
        writeSFixed64NoTag(j);
    }

    public void writeSFixed64NoTag(long j) throws IOException {
        writeRawLittleEndian64(j);
    }

    public void writeSInt32(int i2, int i3) throws IOException {
        writeTag(i2, 0);
        writeSInt32NoTag(i3);
    }

    public void writeSInt32NoTag(int i2) throws IOException {
        writeRawVarint32(encodeZigZag32(i2));
    }

    public void writeSInt64(int i2, long j) throws IOException {
        writeTag(i2, 0);
        writeSInt64NoTag(j);
    }

    public void writeSInt64NoTag(long j) throws IOException {
        writeRawVarint64(encodeZigZag64(j));
    }

    public void writeString(int i2, String str) throws IOException {
        writeTag(i2, 2);
        writeStringNoTag(str);
    }

    public void writeStringNoTag(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i2, int i3) throws IOException {
        writeRawVarint32(WireFormat.makeTag(i2, i3));
    }

    public void writeUInt32(int i2, int i3) throws IOException {
        writeTag(i2, 0);
        writeUInt32NoTag(i3);
    }

    public void writeUInt32NoTag(int i2) throws IOException {
        writeRawVarint32(i2);
    }

    public void writeUInt64(int i2, long j) throws IOException {
        writeTag(i2, 0);
        writeUInt64NoTag(j);
    }

    public void writeUInt64NoTag(long j) throws IOException {
        writeRawVarint64(j);
    }

    @Deprecated
    public void writeUnknownGroup(int i2, MessageLite messageLite) throws IOException {
        writeGroup(i2, messageLite);
    }

    @Deprecated
    public void writeUnknownGroupNoTag(MessageLite messageLite) throws IOException {
        writeGroupNoTag(messageLite);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i2) {
        return new CodedOutputStream(outputStream, new byte[i2]);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.limit;
        int i5 = this.position;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.buffer, i5, i3);
            this.position += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.buffer, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.position = this.limit;
        refreshBuffer();
        if (i8 <= this.limit) {
            System.arraycopy(bArr, i7, this.buffer, 0, i8);
            this.position = i8;
            return;
        }
        this.output.write(bArr, i7, i8);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i2, int i3) {
        return new CodedOutputStream(bArr, i2, i3);
    }

    public void writeRawByte(int i2) throws IOException {
        writeRawByte((byte) i2);
    }

    public CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
    }

    public void writeRawBytes(ByteString byteString, int i2, int i3) throws IOException {
        int i4 = this.limit;
        int i5 = this.position;
        if (i4 - i5 >= i3) {
            byteString.copyTo(this.buffer, i2, i5, i3);
            this.position += i3;
            return;
        }
        int i6 = i4 - i5;
        byteString.copyTo(this.buffer, i2, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.position = this.limit;
        refreshBuffer();
        if (i8 <= this.limit) {
            byteString.copyTo(this.buffer, i7, 0, i8);
            this.position = i8;
            return;
        }
        InputStream newInput = byteString.newInput();
        long j = i7;
        if (j != newInput.skip(j)) {
            throw new IllegalStateException("Skip failed? Should never happen.");
        }
        while (i8 > 0) {
            int min = Math.min(i8, this.limit);
            int read = newInput.read(this.buffer, 0, min);
            if (read == min) {
                this.output.write(this.buffer, 0, read);
                i8 -= read;
            } else {
                throw new IllegalStateException("Read failed? Should never happen");
            }
        }
    }
}
