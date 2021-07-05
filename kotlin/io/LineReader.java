package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b0\u0010\u0015J\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010.\u001a\u00060,j\u0002`-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lkotlin/io/LineReader;", "", "compactBytes", "()I", "", "endOfInput", "decode", "(Z)I", "nBytes", "nChars", "decodeEndOfInput", "(II)I", "Ljava/io/InputStream;", "inputStream", "Ljava/nio/charset/Charset;", "charset", "", "readLine", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;", "", "resetAll", "()V", "trimStringBuilder", "updateCharset", "(Ljava/nio/charset/Charset;)V", "BUFFER_SIZE", "I", "Ljava/nio/ByteBuffer;", "byteBuf", "Ljava/nio/ByteBuffer;", "", "bytes", "[B", "Ljava/nio/CharBuffer;", "charBuf", "Ljava/nio/CharBuffer;", "", "chars", "[C", "Ljava/nio/charset/CharsetDecoder;", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "Z", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Ljava/lang/StringBuilder;", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class LineReader {
    public static final int BUFFER_SIZE = 32;
    public static final ByteBuffer byteBuf;
    public static final byte[] bytes;
    public static final CharBuffer charBuf;
    public static CharsetDecoder decoder;
    public static boolean directEOL;
    public static final StringBuilder sb;
    public static final LineReader INSTANCE = new LineReader();
    public static final char[] chars = new char[32];

    static {
        byte[] bArr = new byte[32];
        bytes = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "ByteBuffer.wrap(bytes)");
        byteBuf = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(chars);
        Intrinsics.checkNotNullExpressionValue(wrap2, "CharBuffer.wrap(chars)");
        charBuf = wrap2;
        sb = new StringBuilder();
    }

    public static final /* synthetic */ CharsetDecoder access$getDecoder$p(LineReader lineReader) {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        return charsetDecoder;
    }

    private final int compactBytes() {
        ByteBuffer byteBuffer = byteBuf;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    private final int decode(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
            }
            CoderResult decode = charsetDecoder.decode(byteBuf, charBuf, z);
            Intrinsics.checkNotNullExpressionValue(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                resetAll();
                decode.throwException();
            }
            int position = charBuf.position();
            if (!decode.isOverflow()) {
                return position;
            }
            int i2 = position - 1;
            sb.append(chars, 0, i2);
            charBuf.position(0);
            charBuf.limit(32);
            charBuf.put(chars[i2]);
        }
    }

    private final int decodeEndOfInput(int i2, int i3) {
        byteBuf.limit(i2);
        charBuf.position(i3);
        int decode = decode(true);
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        return decode;
    }

    private final void resetAll() {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        sb.setLength(0);
    }

    private final void trimStringBuilder() {
        sb.setLength(32);
        sb.trimToSize();
    }

    private final void updateCharset(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        decoder = newDecoder;
        byteBuf.clear();
        charBuf.clear();
        byteBuf.put((byte) 10);
        byteBuf.flip();
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        boolean z = false;
        charsetDecoder.decode(byteBuf, charBuf, false);
        if (charBuf.position() == 1 && charBuf.get(0) == '\n') {
            z = true;
        }
        directEOL = z;
        resetAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r0.charset(), r11)) != false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String readLine(InputStream inputStream, Charset charset) {
        int decodeEndOfInput;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        boolean z = true;
        if (decoder != null) {
            if (decoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
            }
        }
        updateCharset(charset);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                if ((sb.length() == 0) && i2 == 0 && i3 == 0) {
                    return null;
                }
                decodeEndOfInput = decodeEndOfInput(i2, i3);
            } else {
                int i4 = i2 + 1;
                bytes[i2] = (byte) read;
                if (read != 10 && i4 != 32 && directEOL) {
                    i2 = i4;
                }
                byteBuf.limit(i4);
                charBuf.position(i3);
                i3 = decode(false);
                if (i3 > 0 && chars[i3 - 1] == '\n') {
                    byteBuf.position(0);
                    decodeEndOfInput = i3;
                    break;
                }
                i2 = compactBytes();
            }
        }
        if (decodeEndOfInput > 0 && chars[decodeEndOfInput - 1] == '\n' && decodeEndOfInput - 1 > 0 && chars[decodeEndOfInput - 1] == '\r') {
            decodeEndOfInput--;
        }
        if (sb.length() != 0) {
            z = false;
        }
        if (z) {
            return new String(chars, 0, decodeEndOfInput);
        }
        sb.append(chars, 0, decodeEndOfInput);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        if (sb.length() > 32) {
            trimStringBuilder();
        }
        sb.setLength(0);
        return sb2;
    }
}
