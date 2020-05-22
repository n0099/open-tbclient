package com.xiaomi.push;

import android.util.Base64;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
/* loaded from: classes8.dex */
class cr {
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(m202a(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(List<NameValuePair> list, String str) {
        Collections.sort(list, new cs());
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        Iterator<NameValuePair> it = list.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                sb.append(ETAG.ITEM_SEPARATOR).append(str);
                return a(new String(Base64.encode(m202a(sb.toString()), 2)));
            }
            NameValuePair next = it.next();
            if (!z2) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(next.getName()).append(ETAG.EQUAL).append(next.getValue());
            z = false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m201a(String str) {
    }

    /* renamed from: a  reason: collision with other method in class */
    private static byte[] m202a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }
}
