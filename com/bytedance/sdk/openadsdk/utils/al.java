package com.bytedance.sdk.openadsdk.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import javax.security.cert.Certificate;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
/* loaded from: classes6.dex */
public class al {
    public static boolean a(Certificate[] certificateArr) {
        if (certificateArr != null) {
            int length = certificateArr.length;
            int i = 0;
            while (i < length) {
                X509Certificate[] a2 = a(certificateArr, i);
                if (!a(a2)) {
                    return false;
                }
                i += a2.length;
            }
        }
        return true;
    }

    private static X509Certificate[] a(Certificate[] certificateArr, int i) {
        int i2 = i;
        while (i2 < certificateArr.length - 1 && ((X509Certificate) certificateArr[i2]).getIssuerDN().equals(((X509Certificate) certificateArr[i2 + 1]).getSubjectDN())) {
            i2++;
        }
        int i3 = (i2 - i) + 1;
        X509Certificate[] x509CertificateArr = new X509Certificate[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            x509CertificateArr[i4] = (X509Certificate) certificateArr[i + i4];
        }
        return x509CertificateArr;
    }

    private static boolean a(X509Certificate[] x509CertificateArr) {
        int length = x509CertificateArr.length;
        for (int i = 0; i < length - 1; i++) {
            try {
                x509CertificateArr[i].verify(x509CertificateArr[i + 1].getPublicKey());
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
