package com.win.opensdk;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
/* loaded from: classes7.dex */
public class d1 {

    /* renamed from: a  reason: collision with root package name */
    public AlgorithmParameterSpec f37026a;

    /* renamed from: b  reason: collision with root package name */
    public Key f37027b;

    public d1(String str, String str2) {
        try {
            this.f37026a = new IvParameterSpec(str2.getBytes("utf-8"));
            this.f37027b = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
        } catch (Exception e2) {
            throw new RuntimeException("Error in getKey(String secretKey), Cause: " + e2);
        }
    }
}
