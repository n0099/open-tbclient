package org.apache.commons.codec.binary4util;

import java.util.Arrays;
import org.apache.commons.base.BinaryDecoder;
import org.apache.commons.base.BinaryEncoder;
import org.apache.commons.base.DecoderException;
import org.apache.commons.base.EncoderException;
/* loaded from: classes2.dex */
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

    public static boolean isWhiteSpace(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    public abstract void decode(byte[] bArr, int i, int i2, Context context);

    public abstract void encode(byte[] bArr, int i, int i2, Context context);

    public int getDefaultBufferSize() {
        return 8192;
    }

    public abstract boolean isInAlphabet(byte b);

    public BaseNCodec(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, (byte) 61);
    }

    public int readResults(byte[] bArr, int i, int i2, Context context) {
        if (context.buffer != null) {
            int min = Math.min(available(context), i2);
            System.arraycopy(context.buffer, context.readPos, bArr, i, min);
            int i3 = context.readPos + min;
            context.readPos = i3;
            if (i3 >= context.pos) {
                context.buffer = null;
            }
            return min;
        } else if (context.eof) {
            return -1;
        } else {
            return 0;
        }
    }

    /* loaded from: classes2.dex */
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

    public BaseNCodec(int i, int i2, int i3, int i4, byte b) {
        boolean z;
        this.PAD = (byte) 61;
        this.unencodedBlockSize = i;
        this.encodedBlockSize = i2;
        if (i3 > 0 && i4 > 0) {
            z = true;
        } else {
            z = false;
        }
        this.lineLength = z ? (i3 / i2) * i2 : 0;
        this.chunkSeparatorLength = i4;
        this.pad = b;
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
        for (byte b : bArr) {
            if (this.pad == b || isInAlphabet(b)) {
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

    @Override // org.apache.commons.base.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public String encodeAsString(byte[] bArr) {
        return org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(encode(bArr));
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i = this.unencodedBlockSize;
        long j = (((length + i) - 1) / i) * this.encodedBlockSize;
        int i2 = this.lineLength;
        if (i2 > 0) {
            return j + ((((i2 + j) - 1) / i2) * this.chunkSeparatorLength);
        }
        return j;
    }

    public boolean hasData(Context context) {
        if (context.buffer != null) {
            return true;
        }
        return false;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str), true);
    }

    public byte[] decode(String str) {
        return decode(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str));
    }

    @Override // org.apache.commons.base.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return encode(bArr, 0, bArr.length);
        }
        return bArr;
    }

    @Override // org.apache.commons.base.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            Context context = new Context();
            decode(bArr, 0, bArr.length, context);
            decode(bArr, 0, -1, context);
            int i = context.pos;
            byte[] bArr2 = new byte[i];
            readResults(bArr2, 0, i, context);
            return bArr2;
        }
        return bArr;
    }

    public byte[] encode(byte[] bArr, int i, int i2) {
        if (bArr != null && bArr.length != 0) {
            Context context = new Context();
            encode(bArr, i, i2, context);
            encode(bArr, i, -1, context);
            int i3 = context.pos - context.readPos;
            byte[] bArr2 = new byte[i3];
            readResults(bArr2, 0, i3, context);
            return bArr2;
        }
        return bArr;
    }

    public byte[] ensureBufferSize(int i, Context context) {
        byte[] bArr = context.buffer;
        if (bArr != null && bArr.length >= context.pos + i) {
            return bArr;
        }
        return resizeBuffer(context);
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        for (byte b : bArr) {
            if (!isInAlphabet(b) && (!z || (b != this.pad && !isWhiteSpace(b)))) {
                return false;
            }
        }
        return true;
    }
}
