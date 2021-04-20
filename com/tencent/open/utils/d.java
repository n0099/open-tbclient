package com.tencent.open.utils;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f39595a = {1, 2, 3, 4, 5, 6, 7, 8};

    public static String a(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f39595a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e2) {
            com.tencent.open.a.f.c("DESUtils", "encode " + e2.toString());
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f39595a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(decode));
        } catch (Exception e2) {
            com.tencent.open.a.f.c("DESUtils", "decode " + e2.toString());
            return null;
        }
    }
}
