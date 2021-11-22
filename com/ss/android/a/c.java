package com.ss.android.a;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f69221a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.ss.android.a.c$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f69222a;

        /* renamed from: b  reason: collision with root package name */
        public int f69223b;

        /* renamed from: c  reason: collision with root package name */
        public int f69224c;

        /* renamed from: d  reason: collision with root package name */
        public long f69225d;

        /* renamed from: e  reason: collision with root package name */
        public String f69226e;

        public a() {
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

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1430070469, "Lcom/ss/android/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1430070469, "Lcom/ss/android/a/c;");
                return;
            }
        }
        f69221a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) ? a(file, 9, 8192L) : (String) invokeL.objValue;
    }

    public static String b(File file, int i2, long j) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{file, Integer.valueOf(i2), Long.valueOf(j)})) == null) ? a(new com.ss.android.a.a(file), i2, j) : (String) invokeCommon.objValue;
    }

    public static String a(File file, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{file, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        return b(file, i2, j);
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

    public static long b(String str) throws RuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? (Long.parseLong(str, 16) - 31) >> 4 : invokeL.longValue;
    }

    public static int a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, file)) == null) ? a(str, file, (b) null) : invokeLL.intValue;
    }

    public static int a(String str, File file, b bVar) {
        InterceptResult invokeLLL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, file, bVar)) == null) {
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
                long j = -1;
                try {
                    a a2 = a(str);
                    if (a2 != null) {
                        if (a2.f69222a > 1) {
                            return 3;
                        }
                        i2 = a2.f69224c;
                        j = a2.f69225d;
                    }
                    a aVar = null;
                    if (bVar != null) {
                        b2 = a(bVar, i2, j);
                    } else {
                        b2 = b(file, i2, j);
                    }
                    if (b2 != null && b2.length() != 0) {
                        if (a2 != null && (a2.f69222a != 1 || a2.f69223b != 1)) {
                            if (a2.f69226e != null) {
                                try {
                                    aVar = a(b2);
                                } catch (Throwable unused2) {
                                }
                                if (aVar != null && a2.f69224c == aVar.f69224c && a2.f69225d == aVar.f69225d && a2.f69226e.equals(aVar.f69226e)) {
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
        return invokeLLL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX WARN: Can't wrap try/catch for region: R(13:7|8|(6:15|16|(3:18|(1:20)|21)|(1:23)|24|(4:33|35|36|37)(3:28|29|30))|40|16|(0)|(0)|24|(1:26)|33|35|36|37) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:8:0x0011, B:12:0x001e, B:17:0x0032, B:19:0x0044, B:21:0x0051, B:23:0x0068, B:24:0x0072, B:30:0x0084), top: B:43:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:8:0x0011, B:12:0x001e, B:17:0x0032, B:19:0x0044, B:21:0x0051, B:23:0x0068, B:24:0x0072, B:30:0x0084), top: B:43:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(b bVar, int i2, long j) throws Exception {
        InterceptResult invokeCommon;
        long j2;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{bVar, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            int i3 = i2;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return "";
            }
            try {
                long a3 = bVar.a();
                if (i3 > 0 && j > 0 && i3 * j <= (8 * a3) / 10) {
                    j2 = j;
                    byte[] bArr = new byte[8192];
                    long j3 = 0;
                    a(bVar, messageDigest, bArr, 0L, j2);
                    if (i3 > 2) {
                        int i4 = i3 - 1;
                        long j4 = (a3 - (i3 * j2)) / i4;
                        int i5 = 1;
                        while (i5 < i4) {
                            j3 += j2 + j4;
                            a(bVar, messageDigest, bArr, j3, j2);
                            i5++;
                            i4 = i4;
                        }
                    }
                    if (i3 > 1) {
                        a(bVar, messageDigest, bArr, a3 - j2, j2);
                    }
                    a2 = a(messageDigest.digest());
                    if (i3 == 1 || j2 != a3) {
                        String str = a(i3, j2) + ";" + a2;
                        bVar.b();
                        return str;
                    }
                    return a2;
                }
                j2 = a3;
                i3 = 1;
                byte[] bArr2 = new byte[8192];
                long j32 = 0;
                a(bVar, messageDigest, bArr2, 0L, j2);
                if (i3 > 2) {
                }
                if (i3 > 1) {
                }
                a2 = a(messageDigest.digest());
                if (i3 == 1) {
                }
                String str2 = a(i3, j2) + ";" + a2;
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

    public static void a(b bVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{bVar, messageDigest, bArr, Long.valueOf(j), Long.valueOf(j2)}) == null) {
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

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) {
            if (bArr != null) {
                int length = bArr.length;
                int i2 = length * 2;
                char[] cArr = new char[i2];
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = bArr[i4 + 0] & 255;
                    int i6 = i3 + 1;
                    char[] cArr2 = f69221a;
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

    public static String a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return "ttmd5:1:1:" + a(i2) + "g" + a(j);
        }
        return (String) invokeCommon.objValue;
    }

    public static a a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.startsWith("ttmd5:")) {
                String[] split = str.split(";");
                String[] split2 = split[0].split(":");
                a aVar = new a(null);
                aVar.f69222a = Integer.parseInt(split2[1]);
                if (aVar.f69222a > 1) {
                    return aVar;
                }
                aVar.f69223b = Integer.parseInt(split2[2]);
                String[] split3 = split2[3].split("g");
                aVar.f69224c = (int) b(split3[0]);
                aVar.f69225d = b(split3[1]);
                aVar.f69226e = split[1];
                return aVar;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j)) == null) ? Long.toHexString((j << 4) + 31) : (String) invokeJ.objValue;
    }
}
