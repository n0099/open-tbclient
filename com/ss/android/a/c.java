package com.ss.android.a;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class c {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* loaded from: classes4.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f59339b;

        /* renamed from: c  reason: collision with root package name */
        public int f59340c;

        /* renamed from: d  reason: collision with root package name */
        public long f59341d;

        /* renamed from: e  reason: collision with root package name */
        public String f59342e;

        public a() {
        }
    }

    public static String a(File file) {
        return a(file, 9, 8192L);
    }

    public static String b(File file, int i2, long j2) throws Exception {
        return a(new com.ss.android.a.a(file), i2, j2);
    }

    public static String a(File file, int i2, long j2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return b(file, i2, j2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static long b(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static int a(String str, File file) {
        return a(str, file, (b) null);
    }

    public static int a(String str, File file, b bVar) {
        String b2;
        if (str == null || str.length() == 0) {
            return 2;
        }
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
            int i2 = -1;
            long j2 = -1;
            try {
                a a2 = a(str);
                if (a2 != null) {
                    if (a2.a > 1) {
                        return 3;
                    }
                    i2 = a2.f59340c;
                    j2 = a2.f59341d;
                }
                a aVar = null;
                if (bVar != null) {
                    b2 = a(bVar, i2, j2);
                } else {
                    b2 = b(file, i2, j2);
                }
                if (b2 != null && b2.length() != 0) {
                    if (a2 != null && (a2.a != 1 || a2.f59339b != 1)) {
                        if (a2.f59342e != null) {
                            try {
                                aVar = a(b2);
                            } catch (Throwable unused2) {
                            }
                            if (aVar != null && a2.f59340c == aVar.f59340c && a2.f59341d == aVar.f59341d && a2.f59342e.equals(aVar.f59342e)) {
                                return 0;
                            }
                        }
                    }
                    return b2.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|32|33|34)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:15:0x002e, B:17:0x0040, B:19:0x004d, B:21:0x0064, B:22:0x006e, B:28:0x0080), top: B:41:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:15:0x002e, B:17:0x0040, B:19:0x004d, B:21:0x0064, B:22:0x006e, B:28:0x0080), top: B:41:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(b bVar, int i2, long j2) throws Exception {
        long j3;
        String a2;
        int i3 = i2;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long a3 = bVar.a();
            if (i3 > 0 && j2 > 0 && i3 * j2 <= (8 * a3) / 10) {
                j3 = j2;
                byte[] bArr = new byte[8192];
                long j4 = 0;
                a(bVar, messageDigest, bArr, 0L, j3);
                if (i3 > 2) {
                    int i4 = i3 - 1;
                    long j5 = (a3 - (i3 * j3)) / i4;
                    int i5 = 1;
                    while (i5 < i4) {
                        j4 += j3 + j5;
                        a(bVar, messageDigest, bArr, j4, j3);
                        i5++;
                        i4 = i4;
                    }
                }
                if (i3 > 1) {
                    a(bVar, messageDigest, bArr, a3 - j3, j3);
                }
                a2 = a(messageDigest.digest());
                if (i3 == 1 || j3 != a3) {
                    String str = a(i3, j3) + ";" + a2;
                    bVar.b();
                    return str;
                }
                return a2;
            }
            j3 = a3;
            i3 = 1;
            byte[] bArr2 = new byte[8192];
            long j42 = 0;
            a(bVar, messageDigest, bArr2, 0L, j3);
            if (i3 > 2) {
            }
            if (i3 > 1) {
            }
            a2 = a(messageDigest.digest());
            if (i3 == 1) {
            }
            String str2 = a(i3, j3) + ";" + a2;
            bVar.b();
            return str2;
        } finally {
            try {
                bVar.b();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(b bVar, MessageDigest messageDigest, byte[] bArr, long j2, long j3) throws IOException {
        bVar.a(j2, j3);
        long j4 = 0;
        while (j4 < j3) {
            int a2 = bVar.a(bArr, 0, (int) Math.min(j3 - j4, bArr.length));
            if (a2 > 0) {
                messageDigest.update(bArr, 0, a2);
                j4 += a2;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + a2 + ", readTotalCount = " + j4 + ", sampleSize = " + j3);
            }
        }
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i2 = length * 2;
            char[] cArr = new char[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = bArr[i4 + 0] & 255;
                int i6 = i3 + 1;
                char[] cArr2 = a;
                cArr[i3] = cArr2[i5 >> 4];
                i3 = i6 + 1;
                cArr[i6] = cArr2[i5 & 15];
            }
            return new String(cArr, 0, i2);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String a(int i2, long j2) {
        return "ttmd5:1:1:" + a(i2) + "g" + a(j2);
    }

    public static a a(String str) throws Exception {
        if (str.startsWith("ttmd5:")) {
            String[] split = str.split(";");
            String[] split2 = split[0].split(":");
            a aVar = new a();
            aVar.a = Integer.parseInt(split2[1]);
            if (aVar.a > 1) {
                return aVar;
            }
            aVar.f59339b = Integer.parseInt(split2[2]);
            String[] split3 = split2[3].split("g");
            aVar.f59340c = (int) b(split3[0]);
            aVar.f59341d = b(split3[1]);
            aVar.f59342e = split[1];
            return aVar;
        }
        return null;
    }

    public static String a(long j2) {
        return Long.toHexString((j2 << 4) + 31);
    }
}
