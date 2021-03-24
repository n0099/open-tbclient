package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
@Deprecated
/* loaded from: classes7.dex */
public class QCodec extends RFC1522Codec implements StringEncoder, StringDecoder {
    public QCodec() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringDecoder
    public String decode(String str) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    public byte[] doDecoding(byte[] bArr) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    public byte[] doEncoding(byte[] bArr) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    public String encode(String str, String str2) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    public String getDefaultCharset() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    public String getEncoding() {
        throw new RuntimeException("Stub!");
    }

    public boolean isEncodeBlanks() {
        throw new RuntimeException("Stub!");
    }

    public void setEncodeBlanks(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public QCodec(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) throws EncoderException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        throw new RuntimeException("Stub!");
    }
}
