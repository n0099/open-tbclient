package com.kwai.filedownloader.f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f37021a = 65536;

    /* renamed from: b  reason: collision with root package name */
    public static long f37022b = 2000;

    /* renamed from: c  reason: collision with root package name */
    public static String f37023c;

    /* renamed from: d  reason: collision with root package name */
    public static Boolean f37024d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f37025e;

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f37026f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static int a() {
        return f37021a;
    }

    public static int a(String str, String str2, boolean z) {
        return com.kwai.filedownloader.download.b.a().b().a(str, str2, z);
    }

    public static String a(int i, com.kwai.filedownloader.a.b bVar) {
        if (bVar != null) {
            String a2 = bVar.a(Util.ETAG);
            if (d.f37012a) {
                d.c(f.class, "etag find %s for task(%d)", a2, Integer.valueOf(i));
            }
            return a2;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    public static String a(com.kwai.filedownloader.a.b bVar, String str) {
        String g2 = g(bVar.a("Content-Disposition"));
        if (TextUtils.isEmpty(g2)) {
            g2 = c(str);
        }
        return g2.replaceAll("\\/", "_");
    }

    public static String a(String str, String str2) {
        if (str2 != null) {
            if (str != null) {
                return a("%s%s%s", str, File.separator, str2);
            }
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
        throw new IllegalStateException("can't generate real path, the file name is null");
    }

    public static String a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (z) {
            if (str2 == null) {
                return null;
            }
            return a(str, str2);
        }
        return str;
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static void a(int i) {
        if (!a(c.a())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        f37021a = i;
    }

    public static void a(long j) {
        if (!a(c.a())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
        }
        f37022b = j;
    }

    public static boolean a(int i, com.kwai.filedownloader.d.c cVar) {
        return a(i, cVar, (Boolean) null);
    }

    public static boolean a(int i, com.kwai.filedownloader.d.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.f37012a) {
                d.c(f.class, "can't continue %d model == null", Integer.valueOf(i));
            }
            return false;
        } else if (cVar.e() == null) {
            if (d.f37012a) {
                d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i));
            }
            return false;
        } else {
            return a(i, cVar, cVar.e(), bool);
        }
    }

    public static boolean a(int i, com.kwai.filedownloader.d.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (d.f37012a) {
                d.c(f.class, "can't continue %d path = null", Integer.valueOf(i));
                return false;
            }
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (!exists || isDirectory) {
            if (d.f37012a) {
                d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
                return false;
            }
            return false;
        }
        long length = file.length();
        long g2 = cVar.g();
        if (cVar.n() <= 1 && g2 == 0) {
            if (d.f37012a) {
                d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
                return false;
            }
            return false;
        }
        long h2 = cVar.h();
        if (length < g2 || (h2 != -1 && (length > h2 || g2 >= h2))) {
            if (d.f37012a) {
                d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(g2), Long.valueOf(h2));
                return false;
            }
            return false;
        } else if (bool == null || bool.booleanValue() || h2 != length) {
            return true;
        } else {
            if (d.f37012a) {
                d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
                return false;
            }
            return false;
        }
    }

    public static boolean a(long j, long j2) {
        return j > ((long) a()) && j2 > b();
    }

    public static boolean a(Context context) {
        Boolean bool = f37024d;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        if (!e.a().f37016d) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            z = next.processName.endsWith(":filedownloader");
                            break;
                        }
                    }
                } else {
                    d.d(f.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                    return false;
                }
            } else {
                d.d(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
        } else {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        f37024d = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean a(String str) {
        return true;
    }

    public static int b(String str, String str2) {
        return com.kwai.filedownloader.download.b.a().b().a(str, str2, false);
    }

    public static long b() {
        return f37022b;
    }

    public static long b(int i, com.kwai.filedownloader.a.b bVar) {
        long k = k(bVar.a("Content-Length"));
        String a2 = bVar.a("Transfer-Encoding");
        if (k < 0) {
            if (!(a2 != null && a2.equals("chunked"))) {
                if (!e.a().f37015c) {
                    throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                }
                if (d.f37012a) {
                    d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
                }
            }
            return -1L;
        }
        return k;
    }

    public static String b(String str) {
        return a(c(), c(str));
    }

    public static void b(Context context) {
        File c2 = c(context);
        try {
            c2.getParentFile().mkdirs();
            c2.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static File c(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + FileDownloadServiceProxy.TAG, ".old_file_converted");
    }

    public static String c() {
        if (TextUtils.isEmpty(f37023c)) {
            return (c.a().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory() : c.a().getExternalCacheDir()).getAbsolutePath();
        }
        return f37023c;
    }

    public static String c(String str) {
        return e(str);
    }

    public static void c(String str, String str2) {
        m(str2);
        n(str);
    }

    public static String d(String str) {
        return a("%s.temp", str);
    }

    public static boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static String e() {
        return a("FileDownloader/%s", "3.3.9");
    }

    public static String e(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("Huh, MD5 should be supported?", e3);
        }
    }

    public static long f(String str) {
        StatFs statFs = new StatFs(str);
        return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = f37026f.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String h(String str) {
        int length = str.length();
        int i = 2;
        int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || i2 <= 0) {
            i = lastIndexOf;
        }
        if (i != -1) {
            char charAt = str.charAt(length - 1);
            char c2 = File.separatorChar;
            if (charAt == c2) {
                return null;
            }
            return (str.indexOf(c2) == i && str.charAt(i2) == File.separatorChar) ? str.substring(0, i + 1) : str.substring(0, i);
        }
        return null;
    }

    public static String i(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean j(String str) {
        return c.a().checkCallingOrSelfPermission(str) == 0;
    }

    public static long k(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static com.kwai.filedownloader.e.a l(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        if (a(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(a("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (file.exists() || file.createNewFile()) {
                return com.kwai.filedownloader.download.b.a().a(file);
            }
            throw new IOException(a("create new file error  %s", file.getAbsolutePath()));
        }
        throw new RuntimeException(a("found invalid internal destination filename %s", str));
    }

    public static void m(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void n(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
