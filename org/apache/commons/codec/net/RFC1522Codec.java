package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
@Deprecated
/* loaded from: classes7.dex */
public abstract class RFC1522Codec {
    public RFC1522Codec() {
        throw new RuntimeException("Stub!");
    }

    public String decodeText(String str) throws DecoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    public abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    public abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    public String encodeText(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    public abstract String getEncoding();
}
