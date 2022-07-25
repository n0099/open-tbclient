package com.kwad.sdk.api.loader;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public final class s {
    public static final char[] SI = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0060 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    public static String a(File file) {
        Throwable th;
        Exception e;
        DigestInputStream digestInputStream;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                digestInputStream = new DigestInputStream(new FileInputStream((File) file), messageDigest);
                try {
                    while (digestInputStream.read(new byte[1024]) != -1) {
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
                    a(digestInputStream);
                    return sb2;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    a(digestInputStream);
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) file);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            digestInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            file = 0;
            a((Closeable) file);
            throw th;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
