package d.l.a.c;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f74127a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f74128a;

        /* renamed from: b  reason: collision with root package name */
        public int f74129b;

        /* renamed from: c  reason: collision with root package name */
        public int f74130c;

        /* renamed from: d  reason: collision with root package name */
        public long f74131d;

        /* renamed from: e  reason: collision with root package name */
        public String f74132e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(179540972, "Ld/l/a/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(179540972, "Ld/l/a/c/c;");
                return;
            }
        }
        f74127a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static int a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, file)) == null) {
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
                                if (b2.f74128a > 1) {
                                    return 3;
                                }
                                i2 = b2.f74130c;
                                j = b2.f74131d;
                            }
                            b bVar = null;
                            String k = k(file, i2, j);
                            if (k != null && k.length() != 0) {
                                if (b2 != null && (b2.f74128a != 1 || b2.f74129b != 1)) {
                                    if (b2.f74132e != null) {
                                        try {
                                            bVar = b(k);
                                        } catch (Throwable unused) {
                                        }
                                        if (bVar != null && b2.f74130c == bVar.f74130c && b2.f74131d == bVar.f74131d && b2.f74132e.equals(bVar.f74132e)) {
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
        return invokeLL.intValue;
    }

    public static b b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.startsWith("ttmd5:")) {
                String[] split = str.split(";");
                String[] split2 = split[0].split(":");
                b bVar = new b(null);
                bVar.f74128a = Integer.parseInt(split2[1]);
                if (bVar.f74128a > 1) {
                    return bVar;
                }
                bVar.f74129b = Integer.parseInt(split2[2]);
                String[] split3 = split2[3].split("g");
                bVar.f74130c = (int) j(split3[0]);
                bVar.f74131d = j(split3[1]);
                bVar.f74132e = split[1];
                return bVar;
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static String c(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return "ttmd5:1:1:" + d(i2) + "g" + d(j);
        }
        return (String) invokeCommon.objValue;
    }

    public static String d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65540, null, j)) == null) ? Long.toHexString((j << 4) + 31) : (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(13:7|8|(6:15|16|(3:18|(1:20)|21)|(1:23)|24|(4:33|35|36|37)(3:28|29|30))|40|16|(0)|(0)|24|(1:26)|33|35|36|37) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:8:0x0011, B:12:0x001e, B:17:0x0032, B:19:0x0044, B:21:0x0051, B:23:0x0068, B:24:0x0072, B:30:0x0084), top: B:43:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:8:0x0011, B:12:0x001e, B:17:0x0032, B:19:0x0044, B:21:0x0051, B:23:0x0068, B:24:0x0072, B:30:0x0084), top: B:43:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(d.l.a.c.b bVar, int i2, long j) throws Exception {
        InterceptResult invokeCommon;
        long j2;
        String h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{bVar, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static String f(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, file)) == null) ? g(file, 9, 8192L) : (String) invokeL.objValue;
    }

    public static String g(File file, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{file, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static String h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr != null) {
                int length = bArr.length;
                int i2 = length * 2;
                char[] cArr = new char[i2];
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = bArr[i4 + 0] & 255;
                    int i6 = i3 + 1;
                    char[] cArr2 = f74127a;
                    cArr[i3] = cArr2[i5 >> 4];
                    i3 = i6 + 1;
                    cArr[i6] = cArr2[i5 & 15];
                }
                return new String(cArr, 0, i2);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeL.objValue;
    }

    public static void i(d.l.a.c.b bVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{bVar, messageDigest, bArr, Long.valueOf(j), Long.valueOf(j2)}) == null) {
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

    public static long j(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? (Long.parseLong(str, 16) - 31) >> 4 : invokeL.longValue;
    }

    public static String k(File file, int i2, long j) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{file, Integer.valueOf(i2), Long.valueOf(j)})) == null) ? e(new d.l.a.c.a(file), i2, j) : (String) invokeCommon.objValue;
    }
}
