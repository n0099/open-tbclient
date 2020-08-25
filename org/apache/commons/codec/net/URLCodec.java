package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
@Deprecated
/* loaded from: classes9.dex */
public class URLCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
    protected static byte ESCAPE_CHAR;
    protected static final BitSet WWW_FORM_URL = null;
    protected String charset;

    public URLCodec() {
        throw new RuntimeException("Stub!");
    }

    public URLCodec(String str) {
        throw new RuntimeException("Stub!");
    }

    public static final byte[] encodeUrl(BitSet bitSet, byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    public static final byte[] decodeUrl(byte[] bArr) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    public String encode(String str, String str2) throws UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    public String decode(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringDecoder
    public String decode(String str) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getEncoding() {
        throw new RuntimeException("Stub!");
    }

    public String getDefaultCharset() {
        throw new RuntimeException("Stub!");
    }
}
