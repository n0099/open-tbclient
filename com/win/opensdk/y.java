package com.win.opensdk;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
/* loaded from: classes14.dex */
public class y {
    public AlgorithmParameterSpec qkC;
    public Key qkD;

    static {
        byte[] bArr = {-50, 53, 5, 13, -104, -111, 8, 10};
    }

    public y(String str, String str2) {
        try {
            this.qkC = new IvParameterSpec(str2.getBytes("utf-8"));
            this.qkD = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Error in getKey(String secretKey), Cause: " + e);
        }
    }
}
