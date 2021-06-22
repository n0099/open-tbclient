package d.o.a.e.b.l;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.searchbox.bddownload.core.Util;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.vivo.push.PushInnerClientConstants;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import d.o.a.e.b.f.j;
import d.o.a.e.b.f.y;
import d.o.a.e.b.m.l;
import d.o.a.e.b.o.i;
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
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f71243a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static String f71244b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile SparseArray<Boolean> f71245c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile SparseArray<List<j>> f71246d;

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f71247e;

    /* renamed from: f  reason: collision with root package name */
    public static Pattern f71248f;

    /* renamed from: g  reason: collision with root package name */
    public static Pattern f71249g;

    /* renamed from: h  reason: collision with root package name */
    public static ConnectivityManager f71250h;

    /* renamed from: i  reason: collision with root package name */
    public static Boolean f71251i;
    public static Boolean j;

    static {
        Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
        f71244b = null;
        f71245c = new SparseArray<>();
        f71246d = new SparseArray<>();
        f71247e = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f71248f = null;
        f71249g = null;
    }

    public static void A(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!P(th)) {
                    if (!G0(th)) {
                        if (!J0(th)) {
                            if (!i0(th)) {
                                if (!u0(th)) {
                                    if (!B0(th)) {
                                        if (th instanceof IOException) {
                                            z((IOException) th, str);
                                            throw null;
                                        }
                                        throw new BaseException(1000, Y(th, str2));
                                    }
                                    throw new BaseException((int) SDKLogTypeConstants.LOCAL_THIRD_CLICK_MONITOR, Y(th, str2));
                                }
                                throw new BaseException((int) SDKLogTypeConstants.TYPE_LP_LOAD_URL, Y(th, str2));
                            }
                            throw new BaseException(1047, Y(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, 416, Y(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, 412, Y(th, str2));
                }
                throw new BaseException((int) SDKLogTypeConstants.STATE_MACHINE, Y(th, str2));
            }
            throw new BaseException(1011, Y(th, str2));
        }
        BaseException baseException = (BaseException) th;
        baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
        throw baseException;
    }

    public static boolean A0(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static void B(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        long O0 = downloadInfo.O0();
        if (O0 > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.c("extra_throttle_net_speed", String.valueOf(O0)));
        }
    }

    public static boolean B0(Throwable th) {
        if (th == null) {
            return false;
        }
        String R0 = R0(th);
        return !TextUtils.isEmpty(R0) && R0.contains("Exception in connect");
    }

    public static void C(Closeable... closeableArr) {
        if (closeableArr == null) {
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

    public static long C0(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = d.o.a.e.b.g.d.I0().c(downloadInfo.c0());
        int B = downloadInfo.B();
        boolean z = B > 1;
        if (downloadInfo.f1()) {
            if (z) {
                if (c2 == null || B != c2.size()) {
                    return 0L;
                }
                return U(c2);
            }
            return downloadInfo.E();
        }
        return 0L;
    }

    public static boolean D() {
        Boolean bool = f71251i;
        if (bool != null) {
            return bool.booleanValue();
        }
        String x0 = x0(d.o.a.e.b.g.d.l());
        if (x0 == null || !x0.contains(":")) {
            f71251i = Boolean.valueOf(x0 != null && x0.equals(d.o.a.e.b.g.d.l().getPackageName()));
        } else {
            f71251i = Boolean.FALSE;
        }
        return f71251i.booleanValue();
    }

    public static com.ss.android.socialbase.downloader.constants.g D0(int i2) {
        com.ss.android.socialbase.downloader.constants.g gVar = com.ss.android.socialbase.downloader.constants.g.MAIN;
        if (i2 == com.ss.android.socialbase.downloader.constants.g.SUB.ordinal()) {
            return com.ss.android.socialbase.downloader.constants.g.SUB;
        }
        return i2 == com.ss.android.socialbase.downloader.constants.g.NOTIFICATION.ordinal() ? com.ss.android.socialbase.downloader.constants.g.NOTIFICATION : gVar;
    }

    public static boolean E(int i2) {
        return i2 == 0 || i2 == 2;
    }

    public static String E0() {
        Context l = d.o.a.e.b.g.d.l();
        File k = d.o.a.e.b.g.a.l(l).k();
        if (L(k)) {
            return k.getAbsolutePath();
        }
        int i2 = l.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
            File externalFilesDir = l.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (L(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            File H0 = H0();
            if (L(H0)) {
                return H0.getAbsolutePath();
            }
            File externalFilesDir2 = l.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (L(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return l.getFilesDir().getAbsolutePath();
    }

    public static boolean F(int i2, String str) {
        if (a.a(16777216)) {
            return i2 == 206 || i2 == 1;
        } else if (i2 >= 400) {
            return false;
        } else {
            return i2 == 206 || i2 == 1 || "bytes".equals(str);
        }
    }

    public static String F0(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return m(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean G(int i2, String str, String str2) {
        return i2 == -3 && !A0(str, str2);
    }

    public static boolean G0(Throwable th) {
        if (th == null) {
            return false;
        }
        String R0 = R0(th);
        return !TextUtils.isEmpty(R0) && R0.contains("Precondition Failed");
    }

    public static boolean H(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static File H0() {
        String str;
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

    public static boolean I(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static boolean I0(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String x0 = x0(d.o.a.e.b.g.d.l());
        return x0 != null && x0.equals(str);
    }

    public static boolean J(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.E() >= 8388608) ? false : true;
    }

    public static boolean J0(Throwable th) {
        if (th == null) {
            return false;
        }
        String R0 = R0(th);
        return !TextUtils.isEmpty(R0) && R0.contains("Requested Range Not Satisfiable");
    }

    public static boolean K(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.F0()) && !TextUtils.isEmpty(downloadInfo.q0())) {
            try {
                if (new File(downloadInfo.F0(), downloadInfo.q0()).exists()) {
                    if (t0(downloadInfo.F0(), downloadInfo.q0(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String K0(String str) {
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

    public static boolean L(File file) {
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

    public static boolean L0() {
        Context l = d.o.a.e.b.g.d.l();
        return (l == null || d0(l) || !p0(l)) ? false : true;
    }

    public static boolean M(File file, File file2) throws BaseException {
        return N(file, file2, true);
    }

    public static boolean M0(Throwable th) {
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
            String R0 = R0(th);
            return !TextUtils.isEmpty(R0) && R0.contains("ENOSPC");
        } else {
            return false;
        }
    }

    public static boolean N(File file, File file2, boolean z) throws BaseException {
        if (file == null || file2 == null) {
            return false;
        }
        try {
            if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                File parentFile = file2.getParentFile();
                if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                }
                String str = f71243a;
                Log.e(str, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                if (file2.exists() && !file2.canWrite() && !file2.delete()) {
                    throw new IOException("Destination '" + file2 + "' exists but is read-only and delete failed");
                }
                a0(file, file2, z);
                return true;
            }
            return false;
        } catch (BaseException e2) {
            throw e2;
        } catch (Throwable th) {
            A(th, "CopyFile");
            throw null;
        }
    }

    public static long N0(String str) {
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

    public static boolean O(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public static String O0() {
        BufferedReader bufferedReader;
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
            if (d.o.a.e.b.c.a.e()) {
                d.o.a.e.b.c.a.g("Process", "get processName = " + sb.toString());
            }
            String sb2 = sb.toString();
            C(bufferedReader);
            return sb2;
        } catch (Throwable unused2) {
            C(bufferedReader);
            return null;
        }
    }

    public static boolean P(Throwable th) {
        if (th == null) {
            return false;
        }
        String R0 = R0(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(R0)) {
                return false;
            }
            if (!R0.contains("time out") && !R0.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean P0(Throwable th) {
        if (th instanceof BaseException) {
            int errorCode = ((BaseException) th).getErrorCode();
            return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
        }
        return false;
    }

    public static boolean Q(List<com.ss.android.socialbase.downloader.model.c> list, List<com.ss.android.socialbase.downloader.model.c> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static String Q0(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (f71248f == null) {
                f71248f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = f71248f.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (f71249g == null) {
            f71249g = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = f71249g.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static int R(String str, String str2, String str3) {
        return d.o.a.c.c.a(str3, new File(str, str2));
    }

    public static String R0(Throwable th) {
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

    public static long S(i iVar) {
        if (iVar == null) {
            return -1L;
        }
        String W = W(iVar, "Content-Range");
        if (TextUtils.isEmpty(W)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(W);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e2) {
            String str = f71243a;
            d.o.a.e.b.c.a.i(str, "parse content-length from content-range failed " + e2);
        }
        return -1L;
    }

    public static boolean S0(String str) {
        String str2 = f71243a;
        Log.w(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                Log.w(f71243a, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static long T(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                String str2 = f71243a;
                d.o.a.e.b.c.a.i(str2, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static long U(List<com.ss.android.socialbase.downloader.model.b> list) {
        long j2 = 0;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            j2 += bVar.B();
        }
        return j2;
    }

    public static String V(int i2) {
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

    public static String W(i iVar, String str) {
        if (iVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String a2 = iVar.a(str);
        if (d.o.a.e.b.j.a.r().q("fix_get_http_resp_head_ignore_case", true)) {
            if (TextUtils.isEmpty(a2)) {
                a2 = iVar.a(str.toLowerCase());
            }
            return TextUtils.isEmpty(a2) ? iVar.a(str.toUpperCase()) : a2;
        }
        return a2;
    }

    public static String X(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String Y(Throwable th, String str) {
        if (str == null) {
            return R0(th);
        }
        return str + "-" + R0(th);
    }

    public static void Z(DownloadInfo downloadInfo) {
        d.o.a.e.b.j.a d2;
        JSONObject u;
        if (downloadInfo == null || (u = (d2 = d.o.a.e.b.j.a.d(downloadInfo.c0())).u("download_dir")) == null) {
            return;
        }
        String optString = u.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            m0(downloadInfo.F0(), optString);
        }
        String P0 = downloadInfo.P0();
        if (TextUtils.isEmpty(P0)) {
            P0 = downloadInfo.q0();
        }
        String k = k(P0, d2);
        String F0 = downloadInfo.F0();
        if (TextUtils.isEmpty(k) || TextUtils.isEmpty(F0)) {
            return;
        }
        File file = new File(k);
        for (File file2 = new File(F0); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            S0(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static double a(long j2) {
        return j2 / 1048576.0d;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @TargetApi(19)
    public static void a0(File file, File file2, boolean z) throws IOException {
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

    public static int b(File file, String str) {
        return d.o.a.c.c.a(str, file);
    }

    public static boolean b0() {
        return !n0() && d.o.a.e.b.g.d.i0() && l.a(true).g();
    }

    public static int c(Object obj, int i2) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i2;
        }
    }

    public static boolean c0(long j2) {
        return j2 == -1;
    }

    public static long d(i iVar) {
        if (iVar == null) {
            return -1L;
        }
        String W = W(iVar, "Content-Length");
        if (TextUtils.isEmpty(W) && a.a(1)) {
            return S(iVar);
        }
        try {
            return Long.parseLong(W);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean d0(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager e2 = e(context);
            if (e2 != null && (activeNetworkInfo = e2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ConnectivityManager e(Context context) {
        ConnectivityManager connectivityManager = f71250h;
        if (connectivityManager == null) {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
            f71250h = connectivityManager2;
            return connectivityManager2;
        }
        return connectivityManager;
    }

    public static boolean e0(BaseException baseException) {
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.b) {
            com.ss.android.socialbase.downloader.exception.b bVar = (com.ss.android.socialbase.downloader.exception.b) baseException;
            if (bVar.a() == 412 || bVar.a() == 416) {
                return true;
            }
        }
        return false;
    }

    public static d.o.a.e.b.n.c f(String str, String str2, int i2) throws BaseException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs()) {
                                throw new BaseException((int) PushInnerClientConstants.ReportTypeConstant.TYPE_NOTICE_CLICK, "download savePath directory can not created");
                            }
                        } else {
                            file2.delete();
                            throw new BaseException(1031, "download savePath is not directory");
                        }
                    }
                    file.createNewFile();
                } catch (IOException e2) {
                    throw new BaseException(1036, e2);
                }
            }
            return new d.o.a.e.b.n.c(file, i2);
        }
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    public static boolean f0(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.K1() && p0(d.o.a.e.b.g.d.l());
    }

    public static String g(i iVar, String str) {
        String Q0 = Q0(iVar.a("Content-Disposition"));
        return TextUtils.isEmpty(Q0) ? F0(str) : Q0;
    }

    public static boolean g0(File file, File file2) throws BaseException {
        String str = f71243a;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = M(file, file2);
            try {
                String str2 = f71243a;
                Log.e(str2, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static String h(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean h0(File file, String str) {
        return E(d.o.a.c.c.a(str, file));
    }

    public static String i(String str) {
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

    public static boolean i0(Throwable th) {
        com.ss.android.socialbase.downloader.exception.b bVar;
        if (th == null) {
            return false;
        }
        String R0 = R0(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.b) || (((bVar = (com.ss.android.socialbase.downloader.exception.b) th) == null || bVar.a() != 403) && (TextUtils.isEmpty(R0) || !R0.contains("403")))) {
            return !TextUtils.isEmpty(R0) && R0.contains("Forbidden");
        }
        return true;
    }

    public static String j(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static long j0(long j2) {
        return System.currentTimeMillis() - j2;
    }

    public static String k(String str, d.o.a.e.b.j.a aVar) {
        JSONObject u;
        String format;
        if (aVar == null || (u = aVar.u("download_dir")) == null) {
            return "";
        }
        String optString = u.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
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

    public static long k0(List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j2 = -1;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null && (bVar.A() <= bVar.C() || bVar.C() == 0)) {
                if (j2 == -1 || j2 > bVar.A()) {
                    j2 = bVar.A();
                }
            }
        }
        return j2;
    }

    public static String l(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String l0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static String m(byte[] bArr) {
        if (bArr != null) {
            return n(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static void m0(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            String str3 = f71243a;
            Log.e(str3, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static String n(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            if (i2 >= 0 && i2 + i3 <= bArr.length) {
                int i4 = i3 * 2;
                char[] cArr = new char[i4];
                int i5 = 0;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = bArr[i6 + i2] & 255;
                    int i8 = i5 + 1;
                    char[] cArr2 = f71247e;
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

    public static boolean n0() {
        Boolean bool = j;
        if (bool != null) {
            return bool.booleanValue();
        }
        String x0 = x0(d.o.a.e.b.g.d.l());
        if (x0 != null) {
            if (x0.equals(d.o.a.e.b.g.d.l().getPackageName() + ":downloader")) {
                j = Boolean.TRUE;
                return j.booleanValue();
            }
        }
        j = Boolean.FALSE;
        return j.booleanValue();
    }

    public static <K> HashMap<Integer, K> o(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i2));
        }
        return hashMap;
    }

    public static boolean o0(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 0;
    }

    public static List<com.ss.android.socialbase.downloader.model.b> p(List<com.ss.android.socialbase.downloader.model.b> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.q()) {
                    sparseArray.put(bVar.F(), bVar);
                    List<com.ss.android.socialbase.downloader.model.b> list2 = (List) sparseArray2.get(bVar.F());
                    if (list2 != null) {
                        for (com.ss.android.socialbase.downloader.model.b bVar2 : list2) {
                            bVar2.g(bVar);
                        }
                        bVar.h(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.b bVar3 = (com.ss.android.socialbase.downloader.model.b) sparseArray.get(bVar.j());
                    if (bVar3 != null) {
                        List<com.ss.android.socialbase.downloader.model.b> t = bVar3.t();
                        if (t == null) {
                            t = new ArrayList<>();
                            bVar3.h(t);
                        }
                        bVar.g(bVar3);
                        t.add(bVar);
                    } else {
                        List list3 = (List) sparseArray2.get(bVar.j());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(bVar.j(), list3);
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

    public static boolean p0(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager e2 = e(context);
            if (e2 == null || (activeNetworkInfo = e2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.c> q(List<com.ss.android.socialbase.downloader.model.c> list, String str, long j2, long j3) {
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
        String str2 = f71243a;
        d.o.a.e.b.c.a.g(str2, " range CurrentOffset:" + j2 + " EndOffset:" + j3 + ", range = " + format);
        return arrayList;
    }

    public static boolean q0(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    public static List<com.ss.android.socialbase.downloader.model.c> r(List<com.ss.android.socialbase.downloader.model.c> list, String str, com.ss.android.socialbase.downloader.model.b bVar) {
        return q(list, str, bVar.z(), bVar.C());
    }

    public static boolean r0(DownloadInfo downloadInfo) {
        return K(downloadInfo, downloadInfo.v1(), downloadInfo.l0());
    }

    public static void s(int i2, boolean z, BaseException baseException) {
        synchronized (f71245c) {
            List<j> list = f71246d.get(i2);
            if (list != null) {
                for (j jVar : list) {
                    if (jVar != null) {
                        if (z) {
                            jVar.a();
                        } else {
                            jVar.a(baseException);
                        }
                    }
                }
            }
            String str = f71243a;
            d.o.a.e.b.c.a.g(str, "handleTempSaveCallback id:" + i2);
            f71245c.remove(i2);
        }
    }

    public static boolean s0(i iVar) {
        if (iVar == null) {
            return false;
        }
        return a.a(8) ? "chunked".equals(iVar.a("Transfer-Encoding")) || d(iVar) == -1 : d(iVar) == -1;
    }

    public static <K> void t(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean t0(String str, String str2, String str3) {
        return E(R(str, str2, str3));
    }

    public static void u(DownloadInfo downloadInfo) {
        y(downloadInfo, true);
    }

    public static boolean u0(Throwable th) {
        if (th == null) {
            return false;
        }
        String R0 = R0(th);
        return !TextUtils.isEmpty(R0) && R0.contains("network not available");
    }

    public static void v(DownloadInfo downloadInfo, j jVar) {
        int b2;
        BaseException baseException;
        boolean z;
        d.o.a.e.b.c.a.g(f71243a, "saveFileAsTargetName targetName is " + downloadInfo.K0());
        try {
            File file = new File(downloadInfo.N0(), downloadInfo.M0());
            File file2 = new File(downloadInfo.F0(), downloadInfo.q0());
            DownloadInfo f2 = d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).f(downloadInfo.c0());
            if (!file.exists()) {
                d.o.a.e.b.c.a.g(f71243a, "tempFile not exist");
                if (file2.exists()) {
                    d.o.a.e.b.c.a.g(f71243a, "targetFile exist");
                    if (h0(file2, downloadInfo.l0())) {
                        d.o.a.e.b.c.a.g(f71243a, "tempFile not exist , targetFile exists and md5 check valid");
                        if (jVar != null) {
                            jVar.a();
                            return;
                        }
                        return;
                    } else if (f2 != null && f2.P1()) {
                        f2.Y1(jVar);
                        return;
                    }
                } else {
                    d.o.a.e.b.c.a.g(f71243a, "targetFile not exist");
                    if (f2 != null && f2.P1()) {
                        f2.Y1(jVar);
                        return;
                    }
                }
            } else if (file2.exists()) {
                d.o.a.e.b.c.a.g(f71243a, "targetFile exist");
                if (E(b(file2, downloadInfo.l0()))) {
                    d.o.a.e.b.c.a.g(f71243a, "tempFile exist , targetFile exists and md5 check valid");
                    if (jVar != null) {
                        jVar.a();
                        return;
                    }
                    return;
                } else if (f2 != null && f2.P1()) {
                    f2.Y1(jVar);
                    return;
                } else {
                    if (f2 != null) {
                        f2.F2(true);
                    }
                    Log.e(f71243a, "saveFileAsTargetName: " + file2.getPath());
                    if (!file2.delete()) {
                        BaseException baseException2 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + V(b2));
                        if (jVar != null) {
                            jVar.a(baseException2);
                        }
                        if (f2 != null) {
                            f2.V0(false, baseException2);
                            return;
                        }
                        return;
                    }
                }
            }
            if (f2 != null) {
                f2.F2(true);
            }
            try {
                z = !g0(file, file2);
                baseException = null;
            } catch (BaseException e2) {
                baseException = e2;
                z = false;
            }
            if (z) {
                if (baseException == null) {
                    baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s), temp file is exist: %d", downloadInfo.N0(), downloadInfo.M0(), downloadInfo.F0(), downloadInfo.q0(), Boolean.valueOf(file.exists())));
                }
                if (jVar != null) {
                    jVar.a(baseException);
                }
                if (f2 != null) {
                    f2.V0(false, baseException);
                    return;
                }
                return;
            }
            int b3 = d.o.a.e.b.j.a.d(downloadInfo.c0()).b("download_finish_check_ttmd5", 2);
            if (b3 > 0) {
                int b4 = b(file2, downloadInfo.l0());
                downloadInfo.e3(b4);
                if (b3 >= 2 && !E(b4)) {
                    if (jVar != null) {
                        jVar.a(new BaseException(1034, V(b4)));
                    }
                    u(downloadInfo);
                    return;
                }
            }
            if (jVar != null) {
                jVar.a();
            }
            if (f2 != null) {
                f2.V0(true, null);
            }
        } catch (Throwable th) {
            d.o.a.e.b.c.a.g(f71243a, "saveFileAsTargetName throwable " + th.getMessage());
            if (jVar != null) {
                jVar.a(new BaseException(1038, Y(th, "saveFileAsTargetName")));
            }
        }
    }

    public static long v0(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = d.o.a.e.b.g.d.I0().c(downloadInfo.c0());
        if (downloadInfo.B() == 1) {
            return downloadInfo.E();
        }
        if (c2 == null || c2.size() <= 1) {
            return 0L;
        }
        long k0 = k0(c2);
        if (k0 >= 0) {
            return k0;
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void w(DownloadInfo downloadInfo, y yVar, j jVar) {
        boolean z;
        BaseException baseException;
        boolean z2;
        d.o.a.e.b.c.a.g(f71243a, "saveFileAsTargetName targetName is " + downloadInfo.K0());
        try {
        } catch (Throwable th) {
            d.o.a.e.b.c.a.g(f71243a, "saveFileAsTargetName throwable " + th.getMessage());
            if (jVar == null) {
            }
        }
        synchronized (f71245c) {
            if (f71245c.get(downloadInfo.c0()) == Boolean.TRUE) {
                d.o.a.e.b.c.a.g(f71243a, "has another same task is saving temp file");
                if (jVar != null) {
                    List<j> list = f71246d.get(downloadInfo.c0());
                    if (list == null) {
                        list = new ArrayList<>();
                        f71246d.put(downloadInfo.c0(), list);
                    }
                    list.add(jVar);
                }
                return;
            }
            d.o.a.e.b.c.a.g(f71243a, "saveTempFileStatusMap put id:" + downloadInfo.c0());
            f71245c.put(downloadInfo.c0(), Boolean.TRUE);
            File file = new File(downloadInfo.N0(), downloadInfo.M0());
            File file2 = new File(downloadInfo.F0(), downloadInfo.q0());
            if (file2.exists()) {
                d.o.a.e.b.c.a.g(f71243a, "targetFile exist");
                int b2 = b(file2, downloadInfo.l0());
                if (E(b2)) {
                    d.o.a.e.b.c.a.g(f71243a, "tempFile not exist , targetFile exists and md5 check valid");
                    downloadInfo.e3(b2);
                    if (jVar != null) {
                        jVar.a();
                    }
                    s(downloadInfo.c0(), true, null);
                } else {
                    if (file.exists()) {
                        z = true;
                    } else {
                        BaseException baseException2 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.N0(), downloadInfo.M0(), downloadInfo.F0(), downloadInfo.q0(), V(b2)));
                        if (jVar != null) {
                            jVar.a(baseException2);
                        }
                        s(downloadInfo.c0(), false, baseException2);
                        z = false;
                    }
                    if (!file2.delete()) {
                        if (z) {
                            BaseException baseException3 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + V(b2));
                            if (jVar != null) {
                                jVar.a(baseException3);
                            }
                            s(downloadInfo.c0(), false, baseException3);
                        } else if (yVar != null) {
                            d.o.a.e.b.e.a.e(yVar, downloadInfo, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.H0());
                        }
                    }
                    if (z) {
                        return;
                    }
                    try {
                        z2 = !g0(file, file2);
                        baseException = null;
                    } catch (BaseException e2) {
                        if (d.o.a.e.b.j.a.d(downloadInfo.c0()).l("fix_file_rename_failed")) {
                            baseException = e2;
                            z2 = true;
                        } else {
                            baseException = e2;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        if (baseException == null) {
                            baseException = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.N0(), downloadInfo.M0(), downloadInfo.F0(), downloadInfo.q0()));
                        }
                        if (jVar != null) {
                            jVar.a(baseException);
                        }
                        s(downloadInfo.c0(), false, baseException);
                        return;
                    }
                    int b3 = d.o.a.e.b.j.a.d(downloadInfo.c0()).b("download_finish_check_ttmd5", 2);
                    if (b3 > 0) {
                        int b4 = b(file2, downloadInfo.l0());
                        downloadInfo.e3(b4);
                        if (b3 >= 2 && !E(b4)) {
                            BaseException baseException4 = new BaseException(1034, V(b4));
                            if (jVar != null) {
                                jVar.a(baseException4);
                            }
                            s(downloadInfo.c0(), false, baseException4);
                            u(downloadInfo);
                            return;
                        }
                    }
                    if (jVar != null) {
                        jVar.a();
                    }
                    s(downloadInfo.c0(), true, null);
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
                BaseException baseException5 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.N0(), downloadInfo.M0(), downloadInfo.F0(), downloadInfo.q0()));
                if (jVar != null) {
                    jVar.a(baseException5);
                }
                s(downloadInfo.c0(), false, baseException5);
                z = false;
                if (z) {
                }
            }
            d.o.a.e.b.c.a.g(f71243a, "saveFileAsTargetName throwable " + th.getMessage());
            if (jVar == null) {
                jVar.a(new BaseException(1038, Y(th, "saveFileAsTargetName")));
            }
        }
    }

    public static long w0(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException e2) {
            throw new BaseException(1050, e2);
        } catch (Throwable th) {
            throw new BaseException((int) RevenueServerConst.GetChargeCouponDiscountRequest, th);
        }
    }

    public static void x(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.q0())) {
            return;
        }
        File file = new File(downloadInfo.F0(), str);
        File file2 = new File(downloadInfo.F0(), downloadInfo.q0());
        String str2 = f71243a;
        Log.e(str2, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.delete()) {
            throw new BaseException(1037, "targetPath file exists but can't delete");
        }
        if (!M(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.F0(), str, downloadInfo.F0(), downloadInfo.q0()));
        }
    }

    public static String x0(Context context) {
        String str = f71244b;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            if (d.o.a.e.b.c.a.e()) {
                                d.o.a.e.b.c.a.g("Process", "processName = " + runningAppProcessInfo.processName);
                            }
                            String str2 = runningAppProcessInfo.processName;
                            f71244b = str2;
                            return str2;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String O0 = O0();
            f71244b = O0;
            return O0;
        }
        return str;
    }

    public static void y(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                m0(downloadInfo.F0(), downloadInfo.q0());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        m0(downloadInfo.N0(), downloadInfo.M0());
        if (downloadInfo.O1()) {
            Z(downloadInfo);
        }
    }

    public static boolean y0() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void z(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String Y = Y(iOException, str);
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
                                                                        if (M0(iOException)) {
                                                                            throw new BaseException(1006, Y);
                                                                        }
                                                                        throw new BaseException(1023, Y);
                                                                    }
                                                                    throw new BaseException(1011, Y);
                                                                }
                                                                throw new BaseException(1067, Y);
                                                            }
                                                            throw new BaseException(1066, Y);
                                                        }
                                                        throw new BaseException(1065, Y);
                                                    }
                                                    throw new BaseException(1064, Y);
                                                }
                                                throw new BaseException(1063, Y);
                                            }
                                            throw new BaseException(1062, Y);
                                        }
                                        throw new BaseException((int) RevenueServerConst.GetChargeOrderStatusRequest, Y);
                                    }
                                    throw new BaseException((int) RevenueServerConst.GetChargeCurrencyConfigByChannelsRequest, Y);
                                }
                                throw new BaseException(1059, Y);
                            }
                            throw new BaseException((int) SDKLogTypeConstants.STATE_MACHINE, Y);
                        }
                        throw new BaseException(1058, Y);
                    }
                    throw new BaseException(1057, Y);
                }
                throw new BaseException(1056, Y);
            }
            throw new BaseException(1055, Y);
        }
        throw new BaseException((int) SDKLogTypeConstants.LOCAL_THIRD_CLICK_MONITOR, Y);
    }

    public static boolean z0(int i2) {
        return i2 == 206 || i2 == 200;
    }
}
