package d.o.a.c;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f66660a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f66661a;

        /* renamed from: b  reason: collision with root package name */
        public int f66662b;

        /* renamed from: c  reason: collision with root package name */
        public int f66663c;

        /* renamed from: d  reason: collision with root package name */
        public long f66664d;

        /* renamed from: e  reason: collision with root package name */
        public String f66665e;

        public b() {
        }
    }

    public static int a(String str, File file) {
        if (str == null || str.length() == 0) {
            return 2;
        }
        if (file != null) {
            try {
                if (file.exists()) {
                    int i2 = -1;
                    long j = -1;
                    try {
                        b b2 = b(str);
                        if (b2 != null) {
                            if (b2.f66661a > 1) {
                                return 3;
                            }
                            i2 = b2.f66663c;
                            j = b2.f66664d;
                        }
                        b bVar = null;
                        String k = k(file, i2, j);
                        if (k != null && k.length() != 0) {
                            if (b2 != null && (b2.f66661a != 1 || b2.f66662b != 1)) {
                                if (b2.f66665e != null) {
                                    try {
                                        bVar = b(k);
                                    } catch (Throwable unused) {
                                    }
                                    if (bVar != null && b2.f66663c == bVar.f66663c && b2.f66664d == bVar.f66664d && b2.f66665e.equals(bVar.f66665e)) {
                                        return 0;
                                    }
                                }
                            }
                            return k.equals(str) ? 0 : 1;
                        }
                        return 6;
                    } catch (Throwable unused2) {
                        return 4;
                    }
                }
                return 5;
            } catch (Throwable unused3) {
                return 99;
            }
        }
        return 5;
    }

    public static b b(String str) throws Exception {
        if (str.startsWith("ttmd5:")) {
            String[] split = str.split(";");
            String[] split2 = split[0].split(":");
            b bVar = new b();
            bVar.f66661a = Integer.parseInt(split2[1]);
            if (bVar.f66661a > 1) {
                return bVar;
            }
            bVar.f66662b = Integer.parseInt(split2[2]);
            String[] split3 = split2[3].split("g");
            bVar.f66663c = (int) j(split3[0]);
            bVar.f66664d = j(split3[1]);
            bVar.f66665e = split[1];
            return bVar;
        }
        return null;
    }

    public static String c(int i2, long j) {
        return "ttmd5:1:1:" + d(i2) + "g" + d(j);
    }

    public static String d(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|32|33|34)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:15:0x002e, B:17:0x0040, B:19:0x004d, B:21:0x0064, B:22:0x006e, B:28:0x0080), top: B:41:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:15:0x002e, B:17:0x0040, B:19:0x004d, B:21:0x0064, B:22:0x006e, B:28:0x0080), top: B:41:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(d.o.a.c.b bVar, int i2, long j) throws Exception {
        long j2;
        String h2;
        int i3 = i2;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long a2 = bVar.a();
            if (i3 > 0 && j > 0 && i3 * j <= (8 * a2) / 10) {
                j2 = j;
                byte[] bArr = new byte[8192];
                long j3 = 0;
                i(bVar, messageDigest, bArr, 0L, j2);
                if (i3 > 2) {
                    int i4 = i3 - 1;
                    long j4 = (a2 - (i3 * j2)) / i4;
                    int i5 = 1;
                    while (i5 < i4) {
                        j3 += j2 + j4;
                        i(bVar, messageDigest, bArr, j3, j2);
                        i5++;
                        i4 = i4;
                    }
                }
                if (i3 > 1) {
                    i(bVar, messageDigest, bArr, a2 - j2, j2);
                }
                h2 = h(messageDigest.digest());
                if (i3 == 1 || j2 != a2) {
                    String str = c(i3, j2) + ";" + h2;
                    bVar.b();
                    return str;
                }
                return h2;
            }
            j2 = a2;
            i3 = 1;
            byte[] bArr2 = new byte[8192];
            long j32 = 0;
            i(bVar, messageDigest, bArr2, 0L, j2);
            if (i3 > 2) {
            }
            if (i3 > 1) {
            }
            h2 = h(messageDigest.digest());
            if (i3 == 1) {
            }
            String str2 = c(i3, j2) + ";" + h2;
            bVar.b();
            return str2;
        } finally {
            try {
                bVar.b();
            } catch (Throwable unused) {
            }
        }
    }

    public static String f(File file) {
        return g(file, 9, 8192L);
    }

    public static String g(File file, int i2, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return k(file, i2, j);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String h(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i2 = length * 2;
            char[] cArr = new char[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = bArr[i4 + 0] & 255;
                int i6 = i3 + 1;
                char[] cArr2 = f66660a;
                cArr[i3] = cArr2[i5 >> 4];
                i3 = i6 + 1;
                cArr[i6] = cArr2[i5 & 15];
            }
            return new String(cArr, 0, i2);
        }
        throw new NullPointerException("bytes is null");
    }

    public static void i(d.o.a.c.b bVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
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

    public static long j(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static String k(File file, int i2, long j) throws Exception {
        return e(new d.o.a.c.a(file), i2, j);
    }
}
