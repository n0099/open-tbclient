package com.mofamulu.tieba.dslv.lock;

import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    public static List a(String str) {
        byte[] bytes;
        ArrayList a = d.a();
        try {
            for (byte b : str.getBytes(BdUtil.UTF8)) {
                a.add(i.a(b / 3, b % 3));
            }
        } catch (UnsupportedEncodingException e) {
        }
        return a;
    }

    public static String a(List list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            i iVar = (i) list.get(i);
            bArr[i] = (byte) (iVar.b() + (iVar.a() * 3));
        }
        try {
            return new String(bArr, BdUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String b(List list) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
            messageDigest.update(a(list).getBytes(BdUtil.UTF8));
            byte[] digest = messageDigest.digest();
            return String.format(null, "%0" + (digest.length * 2) + "x", new BigInteger(1, digest)).toLowerCase();
        } catch (UnsupportedEncodingException e) {
            return "";
        } catch (NoSuchAlgorithmException e2) {
            return "";
        }
    }
}
