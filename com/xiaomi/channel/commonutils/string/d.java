package com.xiaomi.channel.commonutils.string;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes2.dex */
public class d {
    public static String a(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (str != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(c(str));
                return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException e) {
                return str;
            }
        }
        return "";
    }

    public static String a(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return a(collection.iterator(), str);
    }

    public static String a(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                StringBuffer stringBuffer = new StringBuffer(256);
                if (next != null) {
                    stringBuffer.append(next);
                }
                while (it.hasNext()) {
                    if (str != null) {
                        stringBuffer.append(str);
                    }
                    Object next2 = it.next();
                    if (next2 != null) {
                        stringBuffer.append(next2);
                    }
                }
                return stringBuffer.toString();
            }
            return next.toString();
        }
        return "";
    }

    public static String a(byte[] bArr) {
        String str = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (Exception e) {
        }
        return str.toLowerCase();
    }

    public static String b(String str) {
        if (str != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                messageDigest.update(c(str));
                return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException e) {
                return str;
            }
        }
        return null;
    }

    public static byte[] c(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    public static boolean d(String str) {
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt < 0 || charAt > 127) {
                    return false;
                }
            }
        }
        return true;
    }
}
