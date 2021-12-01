package com.ss.android.socialbase.downloader.i;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.apache.commons.lang3.text.FormattableUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f61880b;

    /* renamed from: c  reason: collision with root package name */
    public static String f61881c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile SparseArray<Boolean> f61882d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile SparseArray<List<ai>> f61883e;

    /* renamed from: f  reason: collision with root package name */
    public static final char[] f61884f;

    /* renamed from: g  reason: collision with root package name */
    public static Pattern f61885g;

    /* renamed from: h  reason: collision with root package name */
    public static Pattern f61886h;

    /* renamed from: i  reason: collision with root package name */
    public static ConnectivityManager f61887i;

    /* renamed from: j  reason: collision with root package name */
    public static Boolean f61888j;

    /* renamed from: k  reason: collision with root package name */
    public static Boolean f61889k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(479430425, "Lcom/ss/android/socialbase/downloader/i/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(479430425, "Lcom/ss/android/socialbase/downloader/i/f;");
                return;
            }
        }
        f61880b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
        f61881c = null;
        f61882d = new SparseArray<>();
        f61883e = new SparseArray<>();
        f61884f = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f61885g = null;
        f61886h = null;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static double a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? j2 / 1048576.0d : invokeJ.doubleValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bArr)) == null) {
            if (bArr != null) {
                return a(bArr, 0, bArr.length);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65570, null, i2)) == null) ? i2 == 0 || i2 == 2 : invokeI.booleanValue;
    }

    public static long b(com.ss.android.socialbase.downloader.network.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, gVar)) == null) {
            if (gVar == null) {
                return -1L;
            }
            String b2 = b(gVar, "Content-Range");
            if (TextUtils.isEmpty(b2)) {
                return -1L;
            }
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(b2);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.d(str, "parse content-length from content-range failed " + e2);
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65595, null, j2)) == null) ? j2 == -1 : invokeJ.booleanValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return String.format("%s.tp", str);
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65606, null, i2)) == null) ? i2 == 200 || i2 == 201 || i2 == 0 : invokeI.booleanValue;
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65618, null, i2)) == null) ? i2 == 206 || i2 == 200 : invokeI.booleanValue;
    }

    public static boolean d(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, downloadInfo)) == null) {
            boolean z = false;
            if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
                com.ss.android.socialbase.downloader.c.a.b(a, "dcache::last modify is emtpy, so just return cache");
            } else {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.b(str, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
                if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                    z = true;
                }
            }
            String str2 = a;
            com.ss.android.socialbase.downloader.c.a.b(str2, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65625, null, str)) == null) {
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(str.getBytes("UTF-8"));
                        return a(messageDigest.digest());
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String d2 = d(com.ss.android.socialbase.downloader.downloader.c.N());
            return d2 != null && d2.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65633, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean h(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65637, null, th)) == null) {
            if (th == null) {
                return false;
            }
            if (th instanceof BaseException) {
                BaseException baseException = (BaseException) th;
                int errorCode = baseException.getErrorCode();
                if (errorCode == 1006) {
                    return true;
                }
                if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                    String message = baseException.getMessage();
                    return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
                }
                return false;
            } else if (th instanceof IOException) {
                String j2 = j(th);
                return !TextUtils.isEmpty(j2) && j2.contains("ENOSPC");
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String i() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65639, null)) == null) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (com.ss.android.socialbase.downloader.c.a.a()) {
                    com.ss.android.socialbase.downloader.c.a.b("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                a(bufferedReader);
                return sb2;
            } catch (Throwable unused2) {
                a(bufferedReader);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65641, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                if (f61885g == null) {
                    f61885g = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
                }
                matcher = f61885g.matcher(str);
            } catch (Exception unused) {
            }
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (f61886h == null) {
                f61886h = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = f61886h.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65643, null, str)) == null) {
            String str2 = "deleteDirIfEmpty on thread: " + Thread.currentThread();
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                return file.isDirectory() && file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, bArr, i2, i3)) == null) {
            if (bArr != null) {
                if (i2 >= 0 && i2 + i3 <= bArr.length) {
                    int i4 = i3 * 2;
                    char[] cArr = new char[i4];
                    int i5 = 0;
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = bArr[i6 + i2] & 255;
                        int i8 = i5 + 1;
                        char[] cArr2 = f61884f;
                        cArr[i5] = cArr2[i7 >> 4];
                        i5 = i8 + 1;
                        cArr[i8] = cArr2[i7 & 15];
                    }
                    return new String(cArr, 0, i4);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLII.objValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65603, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            String str3 = "deleteFile: " + str + "/" + str2;
            file.delete();
        }
    }

    public static boolean f(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65631, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String j2 = j(th);
            return !TextUtils.isEmpty(j2) && j2.contains("Requested Range Not Satisfiable");
        }
        return invokeL.booleanValue;
    }

    public static long d(String str) throws BaseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, null, str)) == null) {
            try {
                StatFs statFs = new StatFs(str);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (IllegalArgumentException e2) {
                throw new BaseException(1050, e2);
            } catch (Throwable th) {
                throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, th);
            }
        }
        return invokeL.longValue;
    }

    public static boolean e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65627, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String j2 = j(th);
            return !TextUtils.isEmpty(j2) && j2.contains("Precondition Failed");
        }
        return invokeL.booleanValue;
    }

    public static long f(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65628, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return 0L;
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = com.ss.android.socialbase.downloader.downloader.c.x().c(downloadInfo.getId());
            int chunkCount = downloadInfo.getChunkCount();
            boolean z = chunkCount > 1;
            if (downloadInfo.isBreakpointAvailable()) {
                if (z) {
                    if (c2 == null || chunkCount != c2.size()) {
                        return 0L;
                    }
                    return b(c2);
                }
                return downloadInfo.getCurBytes();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static boolean g(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65634, null, th)) == null) ? com.ss.android.socialbase.downloader.downloader.c.M().a(th) : invokeL.booleanValue;
    }

    public static boolean c(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65609, null, downloadInfo)) == null) ? a(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5()) : invokeL.booleanValue;
    }

    public static com.ss.android.socialbase.downloader.constants.f e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65623, null, i2)) == null) {
            com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.a;
            if (i2 == com.ss.android.socialbase.downloader.constants.f.f61676b.ordinal()) {
                return com.ss.android.socialbase.downloader.constants.f.f61676b;
            }
            return i2 == com.ss.android.socialbase.downloader.constants.f.f61677c.ordinal() ? com.ss.android.socialbase.downloader.constants.f.f61677c : fVar;
        }
        return (com.ss.android.socialbase.downloader.constants.f) invokeI.objValue;
    }

    public static File g() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) {
            try {
                str = Environment.getExternalStorageState();
            } catch (Exception unused) {
                str = "";
            }
            if ("mounted".equals(str)) {
                return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, str)) == null) {
            if (str == null) {
                return -1L;
            }
            String[] split = str.split("/");
            if (split.length >= 2) {
                try {
                    return Long.parseLong(split[1]);
                } catch (NumberFormatException unused) {
                    String str2 = a;
                    com.ss.android.socialbase.downloader.c.a.d(str2, "parse instance length failed with " + str);
                }
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static boolean c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65611, null, str, str2, str3)) == null) ? a(b(str, str2, str3)) : invokeLLL.booleanValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Context N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65636, null, str)) == null) {
            if (com.ss.android.socialbase.downloader.g.a.c().b("save_path_security") > 0 && (N = com.ss.android.socialbase.downloader.downloader.c.N()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
                if (!str.contains("Android/data/" + N.getPackageName())) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65640, null, th)) == null) {
            if (th instanceof BaseException) {
                int errorCode = ((BaseException) th).getErrorCode();
                return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                try {
                    bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            try {
                return new String(bArr, "utf-8");
            } catch (Exception e3) {
                e3.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(com.ss.android.socialbase.downloader.network.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return a.a(8) ? "chunked".equals(gVar.a("Transfer-Encoding")) || a(gVar) == -1 : a(gVar) == -1;
        }
        return invokeL.booleanValue;
    }

    public static String j(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65642, null, th)) == null) {
            if (th == null) {
                return "";
            }
            try {
                return th.toString();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return "throwable getMsg error";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65620, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            return new File(str, str2).exists();
        }
        return invokeLL.booleanValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) ? a(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getGlobalSaveTempDir(), false) : (String) invokeV.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return !TextUtils.isEmpty(str2) ? str2 : str;
        }
        return (String) invokeLL.objValue;
    }

    public static long e(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return -1L;
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = com.ss.android.socialbase.downloader.downloader.c.x().c(downloadInfo.getId());
            if (downloadInfo.getChunkCount() == 1) {
                return downloadInfo.getCurBytes();
            }
            if (c2 == null || c2.size() <= 1) {
                return 0L;
            }
            long d2 = d(c2);
            if (d2 >= 0) {
                return d2;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static long i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65638, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (matcher.find()) {
                try {
                    return Long.parseLong(matcher.group(1));
                } catch (Throwable th) {
                    th.printStackTrace();
                    return 0L;
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, context)) == null) {
            try {
                ConnectivityManager a2 = a(context);
                if (a2 == null || (activeNetworkInfo = a2.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isConnected();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65635, null)) == null) {
            Context N = com.ss.android.socialbase.downloader.downloader.c.N();
            return (N == null || b(N) || !c(N)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static long b(List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, list)) == null) {
            long j2 = 0;
            for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                j2 += bVar.o();
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, context)) == null) {
            String str = f61881c;
            if (TextUtils.isEmpty(str)) {
                try {
                    int myPid = Process.myPid();
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager != null) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                            if (runningAppProcessInfo.pid == myPid) {
                                if (com.ss.android.socialbase.downloader.c.a.a()) {
                                    com.ss.android.socialbase.downloader.c.a.b("Process", "processName = " + runningAppProcessInfo.processName);
                                }
                                String str2 = runningAppProcessInfo.processName;
                                f61881c = str2;
                                return str2;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String i2 = i();
                f61881c = i2;
                return i2;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void b(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.g.a a2;
        JSONObject d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65591, null, downloadInfo) == null) || downloadInfo == null || (d2 = (a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId())).d("download_dir")) == null) {
            return;
        }
        String optString = d2.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            c(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String a3 = a(title, a2);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(a3) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(a3);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            k(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            Boolean bool = f61889k;
            if (bool != null) {
                return bool.booleanValue();
            }
            String d2 = d(com.ss.android.socialbase.downloader.downloader.c.N());
            if (d2 != null) {
                if (d2.equals(com.ss.android.socialbase.downloader.downloader.c.N().getPackageName() + ":downloader")) {
                    f61889k = Boolean.TRUE;
                    return f61889k.booleanValue();
                }
            }
            f61889k = Boolean.FALSE;
            return f61889k.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static long a(com.ss.android.socialbase.downloader.network.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, gVar)) == null) {
            if (gVar == null) {
                return -1L;
            }
            String b2 = b(gVar, "Content-Length");
            if (TextUtils.isEmpty(b2) && a.a(1)) {
                return b(gVar);
            }
            try {
                return Long.parseLong(b2);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) ? a(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getGlobalSaveDir(), true) : (String) invokeV.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65626, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String e2 = e(str2);
            return (TextUtils.isEmpty(e2) || str.contains(e2)) ? str : new File(str, e2).getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    public static String a(com.ss.android.socialbase.downloader.network.g gVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, gVar, str)) == null) {
            String j2 = j(gVar.a("Content-Disposition"));
            return TextUtils.isEmpty(j2) ? e(str) : j2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean c(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String j2 = j(th);
            return !TextUtils.isEmpty(j2) && j2.contains("network not available");
        }
        return invokeL.booleanValue;
    }

    public static com.ss.android.socialbase.downloader.model.e a(DownloadInfo downloadInfo, String str, String str2, int i2) throws BaseException {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65543, null, downloadInfo, str, str2, i2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str, str2);
                boolean z = false;
                if (file.exists() && file.isDirectory()) {
                    throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
                }
                if (!file.exists()) {
                    try {
                        File file2 = new File(str);
                        if (!file2.exists() || !file2.isDirectory()) {
                            if (!file2.exists()) {
                                if (!file2.mkdirs() && !file2.exists()) {
                                    if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo).a("opt_mkdir_failed", 0) != 1) {
                                        throw new BaseException(1030, "download savePath directory can not created:" + str);
                                    }
                                    int i3 = 0;
                                    while (!z) {
                                        int i4 = i3 + 1;
                                        if (i3 >= 3) {
                                            break;
                                        }
                                        try {
                                            Thread.sleep(10L);
                                            z = file2.mkdirs();
                                            i3 = i4;
                                        } catch (InterruptedException unused) {
                                        }
                                    }
                                    if (!z) {
                                        if (d(downloadInfo.getSavePath()) < 16384) {
                                            throw new BaseException(1006, "download savePath directory can not created:" + str);
                                        }
                                        throw new BaseException(1030, "download savePath directory can not created:" + str);
                                    }
                                }
                            } else {
                                file2.delete();
                                if (!file2.mkdirs() && !file2.exists()) {
                                    throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:path=" + str);
                                }
                                throw new BaseException((int) ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, "download savePath is not directory:" + str);
                            }
                        }
                        file.createNewFile();
                    } catch (IOException e2) {
                        throw new BaseException(1036, e2);
                    }
                }
                return new com.ss.android.socialbase.downloader.model.e(file, i2);
            }
            throw new BaseException(1021, new IOException("path must be not empty"));
        }
        return (com.ss.android.socialbase.downloader.model.e) invokeLLLI.objValue;
    }

    public static boolean c(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, baseException)) == null) {
            if (baseException == null) {
                return false;
            }
            return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
        }
        return invokeL.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    public static boolean d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65621, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String j2 = j(th);
            return !TextUtils.isEmpty(j2) && j2.contains("Exception in connect");
        }
        return invokeL.booleanValue;
    }

    public static void c(Throwable th, String str) throws com.ss.android.socialbase.downloader.exception.g {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65604, null, th, str) == null) {
            com.ss.android.socialbase.downloader.exception.g a2 = com.ss.android.socialbase.downloader.downloader.c.M().a(th, null);
            if (a2 == null) {
                a2 = com.ss.android.socialbase.downloader.downloader.c.M().a(th.getCause(), null);
            }
            if (a2 == null) {
                return;
            }
            throw new com.ss.android.socialbase.downloader.exception.g(a2.getErrorCode(), b(a2, str)).a(a2.a());
        }
    }

    public static long d(List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return -1L;
            }
            long j2 = -1;
            for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                if (bVar != null && (bVar.n() <= bVar.p() || bVar.p() == 0)) {
                    if (j2 == -1 || j2 > bVar.n()) {
                        j2 = bVar.n();
                    }
                }
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static long c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65601, null, j2)) == null) ? System.currentTimeMillis() - j2 : invokeJ.longValue;
    }

    public static boolean c(List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b()) && "download-tc21-1-15".equals(cVar.a()) && "download-tc21-1-15".equals(cVar.b())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65583, null, str, str2, str3)) == null) ? com.ss.android.a.c.a(str3, new File(str, str2)) : invokeLLL.intValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65587, null, i2)) == null) {
            String str = "ttmd5 check code = " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR;
            if (i2 != 99) {
                switch (i2) {
                    case 0:
                        return str + "md5 match";
                    case 1:
                        return str + "md5 not match";
                    case 2:
                        return str + "md5 empty";
                    case 3:
                        return str + "ttmd5 version not support";
                    case 4:
                        return str + "ttmd5 tag parser error";
                    case 5:
                        return str + "file not exist";
                    case 6:
                        return str + "get file md5 error";
                    default:
                        return str;
                }
            }
            return str + "unknown error";
        }
        return (String) invokeI.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @TargetApi(19)
    public static void b(File file, File file2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65592, null, file, file2, z) == null) {
            if (file2.exists() && file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is a directory");
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                FileChannel channel2 = fileOutputStream.getChannel();
                try {
                    long size = channel.size();
                    long j2 = 0;
                    while (j2 < size) {
                        long j3 = size - j2;
                        long transferFrom = channel2.transferFrom(channel, j2, j3 > 31457280 ? 31457280L : j3);
                        if (transferFrom == 0) {
                            break;
                        }
                        j2 += transferFrom;
                    }
                    if (channel2 != null) {
                        channel2.close();
                    }
                    fileOutputStream.close();
                    if (channel != null) {
                        channel.close();
                    }
                    fileInputStream.close();
                    long length = file.length();
                    long length2 = file2.length();
                    if (length == length2) {
                        if (z) {
                            file2.setLastModified(file.lastModified());
                            return;
                        }
                        return;
                    }
                    throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (channel2 != null) {
                            try {
                                channel2.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.b> a(List<com.ss.android.socialbase.downloader.model.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, list)) == null) {
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                if (bVar != null) {
                    if (bVar.d()) {
                        sparseArray.put(bVar.s(), bVar);
                        List<com.ss.android.socialbase.downloader.model.b> list2 = (List) sparseArray2.get(bVar.s());
                        if (list2 != null) {
                            for (com.ss.android.socialbase.downloader.model.b bVar2 : list2) {
                                bVar2.a(bVar);
                            }
                            bVar.a(list2);
                        }
                    } else {
                        com.ss.android.socialbase.downloader.model.b bVar3 = (com.ss.android.socialbase.downloader.model.b) sparseArray.get(bVar.b());
                        if (bVar3 != null) {
                            List<com.ss.android.socialbase.downloader.model.b> g2 = bVar3.g();
                            if (g2 == null) {
                                g2 = new ArrayList<>();
                                bVar3.a(g2);
                            }
                            bVar.a(bVar3);
                            g2.add(bVar);
                        } else {
                            List list3 = (List) sparseArray2.get(bVar.b());
                            if (list3 == null) {
                                list3 = new ArrayList();
                                sparseArray2.put(bVar.b(), list3);
                            }
                            list3.add(bVar);
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
            }
            return arrayList.isEmpty() ? list : arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean b(File file, File file2) throws BaseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65599, null, file, file2)) == null) {
            String str = "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath();
            boolean renameTo = file.renameTo(file2);
            if (!renameTo) {
                renameTo = a(file, file2);
                try {
                    String str2 = "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath();
                    file.delete();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return renameTo;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, context)) == null) {
            try {
                ConnectivityManager a2 = a(context);
                if (a2 != null && (activeNetworkInfo = a2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                    return 1 == activeNetworkInfo.getType();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            return String.format("%s%s%s", str, File.separator, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, str, str2, str3)) == null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                a2 = a(str2, str3);
            } else {
                a2 = a(str, str3);
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            return String.format("%s.tp", a2);
        }
        return (String) invokeLLL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? !c() && com.ss.android.socialbase.downloader.downloader.c.c() && l.a(true).g() : invokeV.booleanValue;
    }

    public static boolean b(Throwable th) {
        InterceptResult invokeL;
        com.ss.android.socialbase.downloader.exception.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String j2 = j(th);
            if (!(th instanceof com.ss.android.socialbase.downloader.exception.b) || (((bVar = (com.ss.android.socialbase.downloader.exception.b) th) == null || bVar.a() != 403) && (TextUtils.isEmpty(j2) || !j2.contains("403")))) {
                return !TextUtils.isEmpty(j2) && j2.contains("Forbidden");
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, downloadInfo) == null) {
            a(downloadInfo, true);
        }
    }

    public static void a(DownloadInfo downloadInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65563, null, downloadInfo, z) == null) || downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                c(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        c(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            b(downloadInfo);
        }
        if (z) {
            String e2 = e(downloadInfo.getUrl());
            if (TextUtils.isEmpty(e2) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(e2)) {
                return;
            }
            k(downloadInfo.getSavePath());
        }
    }

    public static boolean b(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, baseException)) == null) {
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.b) {
                com.ss.android.socialbase.downloader.exception.b bVar = (com.ss.android.socialbase.downloader.exception.b) baseException;
                if (bVar.a() == 412 || bVar.a() == 416) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(Throwable th, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65590, null, th, str)) == null) {
            if (str == null) {
                return j(th);
            }
            return str + "-" + j(th);
        }
        return (String) invokeLL.objValue;
    }

    public static void b(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65593, null, list, downloadInfo) == null) {
            long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
            if (ttnetProtectTimeout > 300) {
                list.add(new com.ss.android.socialbase.downloader.model.c("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
            }
        }
    }

    public static String b(com.ss.android.socialbase.downloader.network.g gVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, gVar, str)) == null) {
            if (gVar == null || TextUtils.isEmpty(str)) {
                return null;
            }
            String a2 = gVar.a(str);
            if (com.ss.android.socialbase.downloader.g.a.c().b("fix_get_http_resp_head_ignore_case", true)) {
                if (TextUtils.isEmpty(a2)) {
                    a2 = gVar.a(str.toLowerCase());
                }
                return TextUtils.isEmpty(a2) ? gVar.a(str.toUpperCase()) : a2;
            }
            return a2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, context, str)) == null) ? (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true : invokeLL.booleanValue;
    }

    public static boolean a(DownloadInfo downloadInfo, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{downloadInfo, Boolean.valueOf(z), str})) == null) {
            if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                try {
                    if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                        if (c(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                            return true;
                        }
                    }
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(BaseException baseException, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65598, null, baseException, downloadInfo)) == null) ? downloadInfo != null && downloadInfo.isOnlyWifi() && c(com.ss.android.socialbase.downloader.downloader.c.N()) : invokeLL.booleanValue;
    }

    public static int a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, file, str)) == null) ? com.ss.android.a.c.a(str, file) : invokeLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(DownloadInfo downloadInfo, x xVar, ai aiVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65561, null, downloadInfo, xVar, aiVar) == null) {
            com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
            try {
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName throwable " + th.getMessage());
                if (aiVar == null) {
                }
            }
            synchronized (f61882d) {
                if (f61882d.get(downloadInfo.getId()) == Boolean.TRUE) {
                    com.ss.android.socialbase.downloader.c.a.b(a, "has another same task is saving temp file");
                    if (aiVar != null) {
                        List<ai> list = f61883e.get(downloadInfo.getId());
                        if (list == null) {
                            list = new ArrayList<>();
                            f61883e.put(downloadInfo.getId(), list);
                        }
                        list.add(aiVar);
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.c.a.b(a, "saveTempFileStatusMap put id:" + downloadInfo.getId());
                f61882d.put(downloadInfo.getId(), Boolean.TRUE);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                boolean h2 = h(downloadInfo.getSavePath());
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.c.a.b(a, "targetFile exist");
                    int a2 = a(file2, downloadInfo.getMd5());
                    if (a(a2)) {
                        com.ss.android.socialbase.downloader.c.a.b(a, "tempFile not exist , targetFile exists and md5 check valid");
                        downloadInfo.setTTMd5CheckStatus(a2);
                        if (aiVar != null) {
                            aiVar.a();
                        }
                        a(downloadInfo.getId(), true, (BaseException) null);
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), b(a2)));
                            if (aiVar != null) {
                                aiVar.a(baseException2);
                            }
                            a(downloadInfo.getId(), false, baseException2);
                            z = false;
                        }
                        if (h2 && !file2.delete()) {
                            if (z) {
                                BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + b(a2));
                                if (aiVar != null) {
                                    aiVar.a(baseException3);
                                }
                                a(downloadInfo.getId(), false, baseException3);
                            } else if (xVar != null) {
                                com.ss.android.socialbase.downloader.d.a.a(xVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                            }
                        }
                        if (z) {
                            return;
                        }
                        try {
                            int a3 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_finish_check_ttmd5", 2);
                            if (a3 > 0) {
                                int a4 = a(file, downloadInfo.getMd5());
                                downloadInfo.setTTMd5CheckStatus(a4);
                                if (a3 >= 2 && !a(a4)) {
                                    BaseException baseException4 = new BaseException(1034, b(a4));
                                    if (aiVar != null) {
                                        aiVar.a(baseException4);
                                    }
                                    a(downloadInfo.getId(), false, baseException4);
                                    a(downloadInfo, h2);
                                    return;
                                }
                            }
                            z2 = !b(file, file2);
                            baseException = null;
                        } catch (BaseException e2) {
                            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_file_rename_failed")) {
                                baseException = e2;
                                z2 = true;
                            } else {
                                baseException = e2;
                                z2 = false;
                            }
                        }
                        if (z2) {
                            if (baseException == null) {
                                baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                            }
                            if (aiVar != null) {
                                aiVar.a(baseException);
                            }
                            a(downloadInfo.getId(), false, baseException);
                            return;
                        }
                        if (aiVar != null) {
                            aiVar.a();
                        }
                        a(downloadInfo.getId(), true, (BaseException) null);
                        return;
                    }
                    z = false;
                    if (z) {
                    }
                } else if (file.exists()) {
                    z = true;
                    if (z) {
                    }
                } else {
                    BaseException baseException5 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                    if (aiVar != null) {
                        aiVar.a(baseException5);
                    }
                    a(downloadInfo.getId(), false, baseException5);
                    z = false;
                    if (z) {
                    }
                }
                com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName throwable " + th.getMessage());
                if (aiVar == null) {
                    aiVar.a(new BaseException(1038, b(th, "saveFileAsTargetName")));
                }
            }
        }
    }

    public static void a(int i2, boolean z, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), baseException}) == null) {
            synchronized (f61882d) {
                List<ai> list = f61883e.get(i2);
                if (list != null) {
                    for (ai aiVar : list) {
                        if (aiVar != null) {
                            if (z) {
                                aiVar.a();
                            } else {
                                aiVar.a(baseException);
                            }
                        }
                    }
                }
                String str = a;
                com.ss.android.socialbase.downloader.c.a.b(str, "handleTempSaveCallback id:" + i2);
                f61882d.remove(i2);
            }
        }
    }

    public static void a(DownloadInfo downloadInfo, String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65562, null, downloadInfo, str) == null) || downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        r0 = "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath();
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!a(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean a(File file, File file2) throws BaseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, file, file2)) == null) ? a(file, file2, true) : invokeLL.booleanValue;
    }

    public static boolean a(File file, File file2, boolean z) throws BaseException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65579, null, file, file2, z)) == null) {
            if (file != null && file2 != null) {
                try {
                    if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                        File parentFile = file2.getParentFile();
                        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                            throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                        }
                        String str = "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath();
                        if (file2.exists() && !file2.canWrite()) {
                            throw new IOException("Destination '" + file2 + "' exists but is read-only");
                        }
                        b(file, file2, z);
                        return true;
                    }
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    a(th, "CopyFile");
                    return false;
                }
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65571, null, i2, str)) == null) {
            if (a.a(16777216)) {
                return i2 == 206 || i2 == 1;
            } else if (i2 >= 400) {
                return false;
            } else {
                return i2 == 206 || i2 == 1 || "bytes".equals(str);
            }
        }
        return invokeIL.booleanValue;
    }

    public static List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list, String str, com.ss.android.socialbase.downloader.model.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, list, str, bVar)) == null) ? a(list, str, bVar.m(), bVar.p()) : (List) invokeLLL.objValue;
    }

    public static List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list, String str, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{list, str, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    if (cVar != null) {
                        arrayList.add(cVar);
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new com.ss.android.socialbase.downloader.model.c(Util.IF_MATCH, str));
            }
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("Accept-Encoding", "identity"));
            String format = j3 <= 0 ? String.format("bytes=%s-", String.valueOf(j2)) : String.format("bytes=%s-%s", String.valueOf(j2), String.valueOf(j3));
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("Range", format));
            String str2 = a;
            com.ss.android.socialbase.downloader.c.a.b(str2, " range CurrentOffset:" + j2 + " EndOffset:" + j3 + ", range = " + format);
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static boolean a(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65572, null, i2, str, str2)) == null) ? i2 == -3 && !d(str, str2) : invokeILL.booleanValue;
    }

    public static ConnectivityManager a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            ConnectivityManager connectivityManager = f61887i;
            if (connectivityManager == null) {
                ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
                f61887i = connectivityManager2;
                return connectivityManager2;
            }
            return connectivityManager;
        }
        return (ConnectivityManager) invokeL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            Boolean bool = f61888j;
            if (bool != null) {
                return bool.booleanValue();
            }
            String d2 = d(com.ss.android.socialbase.downloader.downloader.c.N());
            if (d2 == null || !d2.contains(":")) {
                f61888j = Boolean.valueOf(d2 != null && d2.equals(com.ss.android.socialbase.downloader.downloader.c.N().getPackageName()));
            } else {
                f61888j = Boolean.FALSE;
            }
            return f61888j.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, th)) == null) {
            if (th == null) {
                return false;
            }
            String j2 = j(th);
            if (!(th instanceof SocketTimeoutException)) {
                if (TextUtils.isEmpty(j2)) {
                    return false;
                }
                if (!j2.contains("time out") && !j2.contains("Time-out")) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, baseException)) == null) ? baseException != null && baseException.getErrorCode() == 1051 : invokeL.booleanValue;
    }

    public static void a(Throwable th, String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, th, str) == null) {
            String str2 = !TextUtils.isEmpty(str) ? str : "";
            if (!(th instanceof BaseException)) {
                if (!(th instanceof SSLHandshakeException)) {
                    if (!a(th)) {
                        if (!e(th)) {
                            if (!f(th)) {
                                if (!b(th)) {
                                    if (!c(th)) {
                                        if (!d(th)) {
                                            if (th instanceof IOException) {
                                                c(th, str);
                                                a((IOException) th, str);
                                                return;
                                            }
                                            throw new BaseException(1000, b(th, str2));
                                        }
                                        throw new BaseException(1041, b(th, str2));
                                    }
                                    throw new BaseException(1049, b(th, str2));
                                }
                                throw new BaseException((int) RevenueServerConst.GetUserCouponStoreRequest, b(th, str2));
                            }
                            throw new com.ss.android.socialbase.downloader.exception.b(1004, 416, b(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, 412, b(th, str2));
                    }
                    throw new BaseException(1048, b(th, str2));
                }
                throw new BaseException(1011, b(th, str2));
            }
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        }
    }

    public static void a(IOException iOException, String str) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, iOException, str) == null) {
            if (str == null) {
                str = "";
            }
            String b2 = b(iOException, str);
            if (!(iOException instanceof ConnectException)) {
                if (!(iOException instanceof UnknownHostException)) {
                    if (!(iOException instanceof NoRouteToHostException)) {
                        if (!(iOException instanceof UnknownServiceException)) {
                            if (!(iOException instanceof PortUnreachableException)) {
                                if (!(iOException instanceof SocketTimeoutException)) {
                                    if (!(iOException instanceof SocketException)) {
                                        if (!(iOException instanceof HttpRetryException)) {
                                            if (!(iOException instanceof ProtocolException)) {
                                                if (!(iOException instanceof MalformedURLException)) {
                                                    if (!(iOException instanceof FileNotFoundException)) {
                                                        if (!(iOException instanceof InterruptedIOException)) {
                                                            if (!(iOException instanceof UnsupportedEncodingException)) {
                                                                if (!(iOException instanceof EOFException)) {
                                                                    if (!(iOException instanceof StreamResetException)) {
                                                                        if (!(iOException instanceof SSLException)) {
                                                                            if (h(iOException)) {
                                                                                throw new BaseException(1006, b2);
                                                                            }
                                                                            throw new BaseException(1023, b2);
                                                                        }
                                                                        throw new BaseException(1011, b2);
                                                                    }
                                                                    throw new BaseException(1067, b2);
                                                                }
                                                                throw new BaseException(1066, b2);
                                                            }
                                                            throw new BaseException(1065, b2);
                                                        }
                                                        throw new BaseException(1064, b2);
                                                    }
                                                    throw new BaseException(1063, b2);
                                                }
                                                throw new BaseException(1062, b2);
                                            }
                                            throw new BaseException((int) RevenueServerConst.GetChargeOrderStatusRequest, b2);
                                        }
                                        throw new BaseException((int) RevenueServerConst.GetChargeCurrencyConfigByChannelsRequest, b2);
                                    }
                                    throw new BaseException(1059, b2);
                                }
                                throw new BaseException(1048, b2);
                            }
                            throw new BaseException(1058, b2);
                        }
                        throw new BaseException(1057, b2);
                    }
                    throw new BaseException(1056, b2);
                }
                throw new BaseException(1055, b2);
            }
            throw new BaseException(1041, b2);
        }
    }

    public static boolean a(BaseException baseException, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, baseException, downloadInfo)) == null) {
            if (baseException == null) {
                return false;
            }
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
                return true;
            }
            return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public static <K> HashMap<Integer, K> a(SparseArray<K> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, sparseArray)) == null) {
            if (sparseArray == null) {
                return null;
            }
            HashMap<Integer, K> hashMap = new HashMap<>();
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                hashMap.put(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static <K> void a(SparseArray<K> sparseArray, Map<Integer, K> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65559, null, sparseArray, map) == null) || map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean a(List<com.ss.android.socialbase.downloader.model.c> list, List<com.ss.android.socialbase.downloader.model.c> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65582, null, list, list2)) == null) {
            if (list == list2) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            return new HashSet(list).equals(new HashSet(list2));
        }
        return invokeLL.booleanValue;
    }

    public static void a(Closeable... closeableArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, null, closeableArr) == null) || closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(Cursor... cursorArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, cursorArr) == null) || cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, str, i2)) == null) ? i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2) : (String) invokeLI.objValue;
    }

    public static String a(String str, com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeLL;
        JSONObject d2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, aVar)) == null) {
            if (aVar == null || (d2 = aVar.d("download_dir")) == null) {
                return "";
            }
            String optString = d2.optString("dir_name");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
                optString = optString.substring(1);
            }
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            if (!optString.contains(FormattableUtils.SIMPLEST_FORMAT)) {
                format = optString + str;
            } else {
                try {
                    format = String.format(optString, str);
                } catch (Throwable unused) {
                }
            }
            optString = format;
            return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, file, z)) == null) {
            Context N = com.ss.android.socialbase.downloader.downloader.c.N();
            if (a(file)) {
                return file.getAbsolutePath();
            }
            int i2 = N.getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                File externalFilesDir = N.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                if (a(externalFilesDir)) {
                    return externalFilesDir.getAbsolutePath();
                }
            } else {
                if (z) {
                    File g2 = g();
                    if (a(g2)) {
                        return g2.getAbsolutePath();
                    }
                }
                File externalFilesDir2 = N.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                if (a(externalFilesDir2)) {
                    return externalFilesDir2.getAbsolutePath();
                }
            }
            return N.getFilesDir().getAbsolutePath();
        }
        return (String) invokeLZ.objValue;
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, file)) == null) {
            if (file == null) {
                return false;
            }
            try {
                if (file.exists() || file.mkdirs()) {
                    return file.isDirectory();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void a(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, null, list, downloadInfo) == null) {
            long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
            if (throttleNetSpeed > 0) {
                list.add(new com.ss.android.socialbase.downloader.model.c("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
            }
        }
    }

    public static int a(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, i2)) == null) {
            try {
                return ((Integer) obj).intValue();
            } catch (ClassCastException unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static String a(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, obj, str)) == null) {
            try {
                return (String) obj;
            } catch (ClassCastException unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65580, null, obj, z)) == null) {
            try {
                return ((Boolean) obj).booleanValue();
            } catch (ClassCastException unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }
}
