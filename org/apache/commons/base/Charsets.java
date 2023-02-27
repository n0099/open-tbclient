package org.apache.commons.base;

import java.nio.charset.Charset;
/* loaded from: classes9.dex */
public class Charsets {
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_16 = Charset.forName("UTF-16");
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Charset toCharset(String str) {
        if (str == null) {
            return Charset.defaultCharset();
        }
        return Charset.forName(str);
    }

    public static Charset toCharset(Charset charset) {
        if (charset == null) {
            return Charset.defaultCharset();
        }
        return charset;
    }
}
