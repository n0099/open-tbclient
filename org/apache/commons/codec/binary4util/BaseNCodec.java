package org.apache.commons.codec.binary4util;

import java.util.Arrays;
import org.apache.commons.base.BinaryDecoder;
import org.apache.commons.base.BinaryEncoder;
import org.apache.commons.base.DecoderException;
import org.apache.commons.base.EncoderException;
/* loaded from: classes9.dex */
public abstract class BaseNCodec implements BinaryDecoder, BinaryEncoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    @Deprecated
    protected final byte PAD;
    private final int chunkSeparatorLength;
    private final int encodedBlockSize;
    protected final int lineLength;
    protected final byte pad;
    private final int unencodedBlockSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void decode(byte[] bArr, int i, int i2, Context context);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void encode(byte[] bArr, int i, int i2, Context context);

    protected abstract boolean isInAlphabet(byte b);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseNCodec(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, PAD_DEFAULT);
    }

    protected BaseNCodec(int i, int i2, int i3, int i4, byte b) {
        this.PAD = PAD_DEFAULT;
        this.unencodedBlockSize = i;
        this.encodedBlockSize = i2;
        this.lineLength = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.chunkSeparatorLength = i4;
        this.pad = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasData(Context context) {
        return context.buffer != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    protected int getDefaultBufferSize() {
        return 8192;
    }

    private byte[] resizeBuffer(Context context) {
        if (context.buffer == null) {
            context.buffer = new byte[getDefaultBufferSize()];
            context.pos = 0;
            context.readPos = 0;
        } else {
            byte[] bArr = new byte[context.buffer.length * 2];
            System.arraycopy(context.buffer, 0, bArr, 0, context.buffer.length);
            context.buffer = bArr;
        }
        return context.buffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] ensureBufferSize(int i, Context context) {
        return (context.buffer == null || context.buffer.length < context.pos + i) ? resizeBuffer(context) : context.buffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readResults(byte[] bArr, int i, int i2, Context context) {
        if (context.buffer == null) {
            return context.eof ? -1 : 0;
        }
        int min = Math.min(available(context), i2);
        System.arraycopy(context.buffer, context.readPos, bArr, i, min);
        context.readPos += min;
        if (context.readPos >= context.pos) {
            context.buffer = null;
            return min;
        }
        return min;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isWhiteSpace(byte b) {
        switch (b) {
            case 9:
            case 10:
            case 13:
            case 32:
                return true;
            default:
                return false;
        }
    }

    @Override // org.apache.commons.base.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof byte[])) {
            throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
        }
        return encode((byte[]) obj);
    }

    public String encodeToString(byte[] bArr) {
        return org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeAsString(byte[] bArr) {
        return org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(encode(bArr));
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

    public byte[] decode(String str) {
        return decode(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str));
    }

    @Override // org.apache.commons.base.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            Context context = new Context();
            decode(bArr, 0, bArr.length, context);
            decode(bArr, 0, -1, context);
            byte[] bArr2 = new byte[context.pos];
            readResults(bArr2, 0, bArr2.length, context);
            return bArr2;
        }
        return bArr;
    }

    @Override // org.apache.commons.base.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : encode(bArr, 0, bArr.length);
    }

    public byte[] encode(byte[] bArr, int i, int i2) {
        if (bArr != null && bArr.length != 0) {
            Context context = new Context();
            encode(bArr, i, i2, context);
            encode(bArr, i, -1, context);
            byte[] bArr2 = new byte[context.pos - context.readPos];
            readResults(bArr2, 0, bArr2.length, context);
            return bArr2;
        }
        return bArr;
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        for (byte b : bArr) {
            if (!isInAlphabet(b)) {
                if (!z) {
                    return false;
                }
                if (b != this.pad && !isWhiteSpace(b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    public long getEncodedLength(byte[] bArr) {
        long length = (((bArr.length + this.unencodedBlockSize) - 1) / this.unencodedBlockSize) * this.encodedBlockSize;
        if (this.lineLength > 0) {
            return length + ((((this.lineLength + length) - 1) / this.lineLength) * this.chunkSeparatorLength);
        }
        return length;
    }
}
