package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;
/* loaded from: classes9.dex */
public abstract class RFC1522Codec {
    public static final String POSTFIX = "?=";
    public static final String PREFIX = "=?";
    public static final char SEP = '?';

    public abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    public abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    public abstract String getEncoding();

    public String decodeText(String str) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (str.startsWith(PREFIX) && str.endsWith(POSTFIX)) {
            int length = str.length() - 2;
            int indexOf = str.indexOf(63, 2);
            if (indexOf != length) {
                String substring = str.substring(2, indexOf);
                if (!substring.equals("")) {
                    int i = indexOf + 1;
                    int indexOf2 = str.indexOf(63, i);
                    if (indexOf2 != length) {
                        String substring2 = str.substring(i, indexOf2);
                        if (getEncoding().equalsIgnoreCase(substring2)) {
                            int i2 = indexOf2 + 1;
                            return new String(doDecoding(StringUtils.getBytesUsAscii(str.substring(i2, str.indexOf(63, i2)))), substring);
                        }
                        throw new DecoderException("This codec cannot decode " + substring2 + " encoded content");
                    }
                    throw new DecoderException("RFC 1522 violation: encoding token not found");
                }
                throw new DecoderException("RFC 1522 violation: charset not specified");
            }
            throw new DecoderException("RFC 1522 violation: charset token not found");
        }
        throw new DecoderException("RFC 1522 violation: malformed encoded content");
    }

    public String encodeText(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PREFIX);
        stringBuffer.append(str2);
        stringBuffer.append(SEP);
        stringBuffer.append(getEncoding());
        stringBuffer.append(SEP);
        stringBuffer.append(StringUtils.newStringUsAscii(doEncoding(str.getBytes(str2))));
        stringBuffer.append(POSTFIX);
        return stringBuffer.toString();
    }
}
