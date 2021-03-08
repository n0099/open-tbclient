package com.kwad.sdk.api.loader;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f5486a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            DigestInputStream digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
            byte[] bArr = new byte[1024];
            for (int read = digestInputStream.read(bArr); read != -1; read = digestInputStream.read(bArr)) {
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                if ((b & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b & 255));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
