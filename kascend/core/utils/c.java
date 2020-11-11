package kascend.core.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes18.dex */
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

    public byte[] eBq() {
        byte[] bArr = null;
        try {
            bArr = getContent().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return eBr().digest(bArr);
    }

    private MessageDigest eBr() {
        return this.md5;
    }

    private void a(MessageDigest messageDigest) {
        this.md5 = messageDigest;
    }

    public static c g(String str, String... strArr) {
        c cVar = new c(str);
        if (strArr.length > 0) {
            cVar.setCharset(Charset.forName(strArr[0]));
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
        String bigInteger = new BigInteger(1, eBq()).toString(16);
        while (bigInteger.length() < 32) {
            bigInteger = "0" + bigInteger;
        }
        return bigInteger;
    }

    public boolean equals(Object obj) {
        return toString().equals(obj);
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public static String ZN(String str) {
        return g(str, new String[0]).toString();
    }
}
