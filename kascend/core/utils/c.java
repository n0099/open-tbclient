package kascend.core.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class c {
    private Charset charset = Charset.forName("UTF-8");
    private String content;
    private MessageDigest md5;

    private c(String str) {
        try {
            a(MessageDigest.getInstance("MD5"));
            setContent(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public byte[] dIL() {
        byte[] bArr = null;
        try {
            bArr = getContent().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return dIM().digest(bArr);
    }

    private MessageDigest dIM() {
        return this.md5;
    }

    private void a(MessageDigest messageDigest) {
        this.md5 = messageDigest;
    }

    public static c i(String str, String... strArr) {
        c cVar = new c(str);
        if (strArr.length > 0) {
            cVar.a(Charset.forName(strArr[0]));
        }
        return cVar;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        String bigInteger = new BigInteger(1, dIL()).toString(16);
        while (bigInteger.length() < 32) {
            bigInteger = "0" + bigInteger;
        }
        return bigInteger;
    }

    public boolean equals(Object obj) {
        return toString().equals(obj);
    }

    public void a(Charset charset) {
        this.charset = charset;
    }

    public static String RT(String str) {
        return i(str, new String[0]).toString();
    }
}
