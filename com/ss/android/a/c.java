package com.ss.android.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes8.dex */
public class c {
    public static final char[] a = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* loaded from: classes8.dex */
    public static class a {
        public int a;
        public int b;
        public int c;
        public long d;
        public String e;

        public a() {
        }
    }

    public static int a(String str, File file) {
        return a(str, file, (b) null);
    }

    public static int a(String str, File file, b bVar) {
        String b;
        if (str != null && str.length() != 0) {
            try {
                if (bVar != null) {
                    if (bVar.a() <= 0) {
                        try {
                            bVar.b();
                        } catch (Throwable unused) {
                        }
                        return 5;
                    }
                } else if (file == null || !file.exists()) {
                    return 5;
                }
                int i = -1;
                long j = -1;
                try {
                    a a2 = a(str);
                    if (a2 != null) {
                        if (a2.a <= 1) {
                            i = a2.c;
                            j = a2.d;
                        } else {
                            return 3;
                        }
                    }
                    a aVar = null;
                    if (bVar != null) {
                        b = a(bVar, i, j);
                    } else {
                        b = b(file, i, j);
                    }
                    if (b != null && b.length() != 0) {
                        if (a2 != null && (a2.a != 1 || a2.b != 1)) {
                            if (a2.e != null) {
                                try {
                                    aVar = a(b);
                                } catch (Throwable unused2) {
                                }
                                if (aVar != null && a2.c == aVar.c && a2.d == aVar.d && a2.e.equals(aVar.e)) {
                                    return 0;
                                }
                            }
                            return 1;
                        }
                        if (!b.equals(str)) {
                            return 1;
                        }
                        return 0;
                    }
                    return 6;
                } catch (Throwable unused3) {
                    return 4;
                }
            } catch (Throwable unused4) {
                return 99;
            }
        }
        return 2;
    }

    public static a a(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] split = str.split(ParamableElem.DIVIDE_PARAM);
        String[] split2 = split[0].split(":");
        a aVar = new a();
        aVar.a = Integer.parseInt(split2[1]);
        if (aVar.a <= 1) {
            aVar.b = Integer.parseInt(split2[2]);
            String[] split3 = split2[3].split("g");
            aVar.c = (int) b(split3[0]);
            aVar.d = b(split3[1]);
            aVar.e = split[1];
            return aVar;
        }
        return aVar;
    }

    public static String a(int i, long j) {
        return "ttmd5:1:1:" + a(i) + "g" + a(j);
    }

    public static String a(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    public static long b(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|32|33|34)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:15:0x002e, B:17:0x0040, B:19:0x004d, B:21:0x0064, B:22:0x006e, B:28:0x0080), top: B:41:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:15:0x002e, B:17:0x0040, B:19:0x004d, B:21:0x0064, B:22:0x006e, B:28:0x0080), top: B:41:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(b bVar, int i, long j) throws Exception {
        long j2;
        String a2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long a3 = bVar.a();
            if (i2 > 0 && j > 0 && i2 * j <= (8 * a3) / 10) {
                j2 = j;
                byte[] bArr = new byte[8192];
                long j3 = 0;
                a(bVar, messageDigest, bArr, 0L, j2);
                if (i2 > 2) {
                    int i3 = i2 - 1;
                    long j4 = (a3 - (i2 * j2)) / i3;
                    int i4 = 1;
                    while (i4 < i3) {
                        j3 += j2 + j4;
                        a(bVar, messageDigest, bArr, j3, j2);
                        i4++;
                        i3 = i3;
                    }
                }
                if (i2 > 1) {
                    a(bVar, messageDigest, bArr, a3 - j2, j2);
                }
                a2 = a(messageDigest.digest());
                if (i2 != 1 && j2 == a3) {
                    return a2;
                }
                String str = a(i2, j2) + ParamableElem.DIVIDE_PARAM + a2;
                bVar.b();
                return str;
            }
            j2 = a3;
            i2 = 1;
            byte[] bArr2 = new byte[8192];
            long j32 = 0;
            a(bVar, messageDigest, bArr2, 0L, j2);
            if (i2 > 2) {
            }
            if (i2 > 1) {
            }
            a2 = a(messageDigest.digest());
            if (i2 != 1) {
            }
            String str2 = a(i2, j2) + ParamableElem.DIVIDE_PARAM + a2;
            bVar.b();
            return str2;
        } finally {
            try {
                bVar.b();
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(File file) {
        return a(file, 9, (long) PlaybackStateCompat.ACTION_PLAY_FROM_URI);
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

    public static String b(File file, int i, long j) throws Exception {
        return a(new com.ss.android.a.a(file), i, j);
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = length * 2;
            char[] cArr = new char[i];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = bArr[i3 + 0] & 255;
                int i5 = i2 + 1;
                char[] cArr2 = a;
                cArr[i2] = cArr2[i4 >> 4];
                i2 = i5 + 1;
                cArr[i5] = cArr2[i4 & 15];
            }
            return new String(cArr, 0, i);
        }
        throw new NullPointerException("bytes is null");
    }

    public static void a(b bVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        bVar.a(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int a2 = bVar.a(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (a2 > 0) {
                messageDigest.update(bArr, 0, a2);
                j3 += a2;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + a2 + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
        }
    }
}
