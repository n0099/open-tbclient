package com.ss.android.c;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class c {
    private static final char[] qiv = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String ax(File file) {
        return a(file, 9, 8192L);
    }

    public static String a(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return b(file, i, j);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static int r(String str, File file) {
        a aVar;
        if (str == null || str.length() == 0) {
            return 2;
        }
        if (file != null) {
            try {
                if (file.exists()) {
                    int i = -1;
                    long j = -1;
                    try {
                        a abx = abx(str);
                        if (abx != null) {
                            if (abx.qiw > 1) {
                                return 3;
                            }
                            i = abx.sampleCount;
                            j = abx.sampleSize;
                        }
                        String b2 = b(file, i, j);
                        if (b2 == null || b2.length() == 0) {
                            return 6;
                        }
                        if (abx == null || (abx.qiw == 1 && abx.qix == 1)) {
                            if (b2.equals(str)) {
                                return 0;
                            }
                        } else if (abx.qiy != null) {
                            try {
                                aVar = abx(b2);
                            } catch (Throwable th) {
                                aVar = null;
                            }
                            if (aVar != null && abx.sampleCount == aVar.sampleCount && abx.sampleSize == aVar.sampleSize && abx.qiy.equals(aVar.qiy)) {
                                return 0;
                            }
                        }
                        return 1;
                    } catch (Throwable th2) {
                        return 4;
                    }
                }
            } catch (Throwable th3) {
                return 99;
            }
        }
        return 5;
    }

    private static String b(File file, int i, long j) throws Exception {
        return a(new com.ss.android.c.a(file), i, j);
    }

    private static String a(b bVar, int i, long j) throws Exception {
        long j2;
        MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
        if (messageDigest == null) {
            return "";
        }
        try {
            long length = bVar.length();
            if (i <= 0 || j <= 0 || i * j > (8 * length) / 10) {
                i = 1;
                j2 = length;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            long j3 = 0;
            a(bVar, messageDigest, bArr, 0L, j2);
            if (i > 2) {
                long j4 = (length - (i * j2)) / (i - 1);
                for (int i2 = 1; i2 < i - 1; i2++) {
                    j3 += j2 + j4;
                    a(bVar, messageDigest, bArr, j3, j2);
                }
            }
            if (i > 1) {
                a(bVar, messageDigest, bArr, length - j2, j2);
            }
            String hexString = toHexString(messageDigest.digest());
            if (i != 1 || j2 != length) {
                String str = G(i, j2) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hexString;
                try {
                    bVar.close();
                    return str;
                } catch (Throwable th) {
                    return str;
                }
            }
            try {
                bVar.close();
                return hexString;
            } catch (Throwable th2) {
                return hexString;
            }
        } catch (Throwable th3) {
            try {
                bVar.close();
            } catch (Throwable th4) {
            }
            throw th3;
        }
    }

    private static void a(b bVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        bVar.V(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int read = bVar.read(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (read <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + read + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, read);
            j3 += read;
        }
    }

    private static String toHexString(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = bArr[i2 + 0] & 255;
            int i4 = i + 1;
            cArr[i] = qiv[i3 >> 4];
            i = i4 + 1;
            cArr[i4] = qiv[i3 & 15];
        }
        return new String(cArr, 0, length * 2);
    }

    private static String G(int i, long j) {
        return "ttmd5:1:1:" + ju(i) + IXAdRequestInfo.GPS + ju(j);
    }

    private static a abx(String str) throws Exception {
        if (str.startsWith("ttmd5:")) {
            String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            String[] split2 = split[0].split(":");
            a aVar = new a();
            aVar.qiw = Integer.parseInt(split2[1]);
            if (aVar.qiw > 1) {
                return aVar;
            }
            aVar.qix = Integer.parseInt(split2[2]);
            String[] split3 = split2[3].split(IXAdRequestInfo.GPS);
            aVar.sampleCount = (int) aby(split3[0]);
            aVar.sampleSize = aby(split3[1]);
            aVar.qiy = split[1];
            return aVar;
        }
        return null;
    }

    private static String ju(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long aby(String str) throws RuntimeException {
        try {
            return (Long.parseLong(str, 16) - 31) >> 4;
        } catch (Throwable th) {
            throw new RuntimeException("ttmd5 decryptNum error, num = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private int qiw;
        private int qix;
        private String qiy;
        private int sampleCount;
        private long sampleSize;

        private a() {
        }
    }
}
