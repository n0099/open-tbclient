package org.apache.commons.codec.binary4util;

import java.util.Arrays;
import org.apache.commons.base.BinaryDecoder;
import org.apache.commons.base.BinaryEncoder;
import org.apache.commons.base.DecoderException;
import org.apache.commons.base.EncoderException;
/* loaded from: classes7.dex */
public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    public static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int EOF = -1;
    public static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    public static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    @Deprecated
    public final byte PAD;
    public final int chunkSeparatorLength;
    public final int encodedBlockSize;
    public final int lineLength;
    public final byte pad;
    public final int unencodedBlockSize;

    /* loaded from: classes7.dex */
    public static class Context {
        public byte[] buffer;
        public int currentLinePos;
        public boolean eof;
        public int ibitWorkArea;
        public long lbitWorkArea;
        public int modulus;
        public int pos;
        public int readPos;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", Context.class.getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos));
        }
    }

    public BaseNCodec(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, (byte) 61);
    }

    public static boolean isWhiteSpace(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private byte[] resizeBuffer(Context context) {
        byte[] bArr = context.buffer;
        if (bArr == null) {
            context.buffer = new byte[getDefaultBufferSize()];
            context.pos = 0;
            context.readPos = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            context.buffer = bArr2;
        }
        return context.buffer;
    }

    public int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (this.pad == b2 || isInAlphabet(b2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.base.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public abstract void decode(byte[] bArr, int i2, int i3, Context context);

    @Override // org.apache.commons.base.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public abstract void encode(byte[] bArr, int i2, int i3, Context context);

    public String encodeAsString(byte[] bArr) {
        return org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(encode(bArr));
    }

    public byte[] ensureBufferSize(int i2, Context context) {
        byte[] bArr = context.buffer;
        return (bArr == null || bArr.length < context.pos + i2) ? resizeBuffer(context) : bArr;
    }

    public int getDefaultBufferSize() {
        return 8192;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.unencodedBlockSize;
        long j = (((length + i2) - 1) / i2) * this.encodedBlockSize;
        int i3 = this.lineLength;
        return i3 > 0 ? j + ((((i3 + j) - 1) / i3) * this.chunkSeparatorLength) : j;
    }

    public boolean hasData(Context context) {
        return context.buffer != null;
    }

    public abstract boolean isInAlphabet(byte b2);

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        for (byte b2 : bArr) {
            if (!isInAlphabet(b2) && (!z || (b2 != this.pad && !isWhiteSpace(b2)))) {
                return false;
            }
        }
        return true;
    }

    public int readResults(byte[] bArr, int i2, int i3, Context context) {
        if (context.buffer == null) {
            return context.eof ? -1 : 0;
        }
        int min = Math.min(available(context), i3);
        System.arraycopy(context.buffer, context.readPos, bArr, i2, min);
        int i4 = context.readPos + min;
        context.readPos = i4;
        if (i4 >= context.pos) {
            context.buffer = null;
        }
        return min;
    }

    public BaseNCodec(int i2, int i3, int i4, int i5, byte b2) {
        this.PAD = (byte) 61;
        this.unencodedBlockSize = i2;
        this.encodedBlockSize = i3;
        this.lineLength = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.chunkSeparatorLength = i5;
        this.pad = b2;
    }

    @Override // org.apache.commons.base.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : encode(bArr, 0, bArr.length);
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str), true);
    }

    public byte[] decode(String str) {
        return decode(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str));
    }

    public byte[] encode(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, i2, i3, context);
        encode(bArr, i2, -1, context);
        int i4 = context.pos - context.readPos;
        byte[] bArr2 = new byte[i4];
        readResults(bArr2, 0, i4, context);
        return bArr2;
    }

    @Override // org.apache.commons.base.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        int i2 = context.pos;
        byte[] bArr2 = new byte[i2];
        readResults(bArr2, 0, i2, context);
        return bArr2;
    }
}
