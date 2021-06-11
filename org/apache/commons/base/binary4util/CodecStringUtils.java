package org.apache.commons.base.binary4util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.base.Charsets;
/* loaded from: classes8.dex */
public class CodecStringUtils {
    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        return charSequence.length() == charSequence2.length() && CharSequenceUtils.regionMatches(charSequence, false, 0, charSequence2, 0, charSequence.length());
    }

    public static ByteBuffer getByteBuffer(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return ByteBuffer.wrap(str.getBytes(charset));
    }

    public static ByteBuffer getByteBufferUtf8(String str) {
        return getByteBuffer(str, Charsets.UTF_8);
    }

    public static byte[] getBytes(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] getBytesIso8859_1(String str) {
        return getBytes(str, Charsets.ISO_8859_1);
    }

    public static byte[] getBytesUnchecked(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e2) {
            throw newIllegalStateException(str2, e2);
        }
    }

    public static byte[] getBytesUsAscii(String str) {
        return getBytes(str, Charsets.US_ASCII);
    }

    public static byte[] getBytesUtf16(String str) {
        return getBytes(str, Charsets.UTF_16);
    }

    public static byte[] getBytesUtf16Be(String str) {
        return getBytes(str, Charsets.UTF_16BE);
    }

    public static byte[] getBytesUtf16Le(String str) {
        return getBytes(str, Charsets.UTF_16LE);
    }

    public static byte[] getBytesUtf8(String str) {
        return getBytes(str, Charsets.UTF_8);
    }

    public static IllegalStateException newIllegalStateException(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static String newString(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String newStringIso8859_1(byte[] bArr) {
        return newString(bArr, Charsets.ISO_8859_1);
    }

    public static String newStringUsAscii(byte[] bArr) {
        return newString(bArr, Charsets.US_ASCII);
    }

    public static String newStringUtf16(byte[] bArr) {
        return newString(bArr, Charsets.UTF_16);
    }

    public static String newStringUtf16Be(byte[] bArr) {
        return newString(bArr, Charsets.UTF_16BE);
    }

    public static String newStringUtf16Le(byte[] bArr) {
        return newString(bArr, Charsets.UTF_16LE);
    }

    public static String newStringUtf8(byte[] bArr) {
        return newString(bArr, Charsets.UTF_8);
    }

    public static String newString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            throw newIllegalStateException(str, e2);
        }
    }
}
