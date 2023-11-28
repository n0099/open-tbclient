package com.kwad.sdk.api.loader;

import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
/* loaded from: classes10.dex */
public final class s {
    public static final char[] amG = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String getFileMD5(File file) {
        Throwable th;
        DigestInputStream digestInputStream;
        Exception e;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    for (int read = digestInputStream.read(bArr); read != -1; read = digestInputStream.read(bArr)) {
                    }
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder(digest.length * 2);
                    for (byte b : digest) {
                        int i = b & 255;
                        if (i < 16) {
                            sb.append("0");
                        }
                        sb.append(Integer.toHexString(i));
                    }
                    String sb2 = sb.toString();
                    b(digestInputStream);
                    return sb2;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    b(digestInputStream);
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                b(digestInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            digestInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            digestInputStream = null;
            b(digestInputStream);
            throw th;
        }
    }
}
