package com.xiaomi.push;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes12.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f4941a = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    private static Cipher a(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.e.q);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f4941a);
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
        cipher.init(i, secretKeySpec, ivParameterSpec);
        return cipher;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, 1).doFinal(bArr2);
    }
}
