package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.qq.e.comm.util.GDTLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f12883a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            int length = packageInfo.signatures.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                try {
                    sb.append(a(MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(packageInfo.signatures[i].toByteArray())));
                    if (i != length - 1) {
                        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                } catch (NoSuchAlgorithmException e) {
                    GDTLogger.d("get Signature Message Digest encounter exception: " + e.getMessage());
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            GDTLogger.d("get Signature Digest encounter exception: " + e2.getMessage());
            return null;
        }
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            cArr[i * 2] = f12883a[(b2 >>> 4) & 15];
            cArr[(i * 2) + 1] = f12883a[b2 & 15];
        }
        return new String(cArr);
    }
}
