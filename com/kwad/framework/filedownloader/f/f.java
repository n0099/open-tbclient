package com.kwad.framework.filedownloader.f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.searchbox.bddownload.core.Util;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.utils.aq;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class f {
    public static int aif = 65536;
    public static long aig = 2000;
    public static String aih;
    public static Boolean aii;
    public static Boolean aij;
    public static final Pattern aik = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static int wF() {
        return aif;
    }

    public static long wG() {
        return aig;
    }

    public static String wH() {
        if (!TextUtils.isEmpty(aih)) {
            return aih;
        }
        if (c.wB().getExternalCacheDir() == null) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return c.wB().getExternalCacheDir().getAbsolutePath();
    }

    public static boolean wI() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.wB().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            return false;
        }
        return true;
    }

    public static String wJ() {
        return b("FileDownloader/%s", BuildConfig.VERSION_NAME);
    }

    public static void R(long j) {
        if (an(c.wB())) {
            aig = j;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    public static void ao(Context context) {
        File ap = ap(context);
        try {
            ap.getParentFile().mkdirs();
            ap.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File ap(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + FileDownloadServiceProxy.TAG, ".old_file_converted");
    }

    public static void bH(int i) {
        if (an(c.wB())) {
            aif = i;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static String bk(String str) {
        return u(wH(), bl(str));
    }

    public static String bl(String str) {
        return bn(str);
    }

    public static String bm(String str) {
        return b("%s.temp", str);
    }

    public static String bo(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = aik.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String bq(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean br(String str) {
        if (c.wB().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static long bs(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void bu(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bv(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String a(int i, com.kwad.framework.filedownloader.a.b bVar) {
        if (bVar != null) {
            String aW = bVar.aW(Util.ETAG);
            if (d.ahW) {
                d.c(f.class, "etag find %s for task(%d)", aW, Integer.valueOf(i));
            }
            return aW;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    public static String b(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean i(long j, long j2) {
        if (j > wF() && j2 > wG()) {
            return true;
        }
        return false;
    }

    public static String u(String str, String str2) {
        if (str2 != null) {
            if (str != null) {
                return b("%s%s%s", str, File.separator, str2);
            }
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
        throw new IllegalStateException("can't generate real path, the file name is null");
    }

    public static int x(String str, String str2) {
        return com.kwad.framework.filedownloader.download.b.ve().vf().g(str, str2, false);
    }

    public static void y(String str, String str2) {
        bu(str2);
        bv(str);
    }

    public static String a(com.kwad.framework.filedownloader.a.b bVar, String str) {
        String bo = bo(bVar.aW("Content-Disposition"));
        if (TextUtils.isEmpty(bo)) {
            bo = bl(str);
        }
        return bo.replaceAll("\\/", "_");
    }

    public static boolean b(int i, com.kwad.framework.filedownloader.d.c cVar) {
        return a(i, cVar, (Boolean) null);
    }

    public static String a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (z) {
            if (str2 == null) {
                return null;
            }
            return u(str, str2);
        }
        return str;
    }

    public static int g(String str, String str2, boolean z) {
        return com.kwad.framework.filedownloader.download.b.ve().vf().g(str, str2, z);
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.ahW) {
                d.c(f.class, "can't continue %d model == null", Integer.valueOf(i));
            }
            return false;
        } else if (cVar.vt() == null) {
            if (d.ahW) {
                d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i));
            }
            return false;
        } else {
            return a(i, cVar, cVar.vt(), null);
        }
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (!d.ahW) {
                return false;
            }
            d.c(f.class, "can't continue %d path = null", Integer.valueOf(i));
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long wb = cVar.wb();
            if (cVar.we() <= 1 && wb == 0) {
                if (!d.ahW) {
                    return false;
                }
                d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
                return false;
            }
            long total = cVar.getTotal();
            if (length >= wb && (total == -1 || (length <= total && wb < total))) {
                if (bool != null && !bool.booleanValue() && total == length) {
                    if (!d.ahW) {
                        return false;
                    }
                    d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
                    return false;
                }
                return true;
            } else if (!d.ahW) {
                return false;
            } else {
                d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(wb), Long.valueOf(total));
                return false;
            }
        } else if (!d.ahW) {
            return false;
        } else {
            d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
            return false;
        }
    }

    public static boolean an(Context context) {
        boolean endsWith;
        Boolean bool = aii;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.wD().aia) {
            endsWith = true;
        } else if (((ActivityManager) context.getSystemService("activity")) == null) {
            d.d(f.class, "fail to get the activity manager!", new Object[0]);
            return false;
        } else {
            endsWith = aq.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean valueOf = Boolean.valueOf(endsWith);
        aii = valueOf;
        return valueOf.booleanValue();
    }

    public static long b(int i, com.kwad.framework.filedownloader.a.b bVar) {
        boolean z;
        long bs = bs(bVar.aW("Content-Length"));
        String aW = bVar.aW("Transfer-Encoding");
        if (bs < 0) {
            if (aW != null && aW.equals("chunked")) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (e.wD().ahZ) {
                    if (d.ahW) {
                        d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
                    }
                } else {
                    throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                }
            }
            return -1L;
        }
        return bs;
    }

    public static String bn(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        }
    }

    public static String bp(String str) {
        int i;
        int length = str.length();
        int i2 = 2;
        if (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') {
            i = 2;
        } else {
            i = 0;
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || i <= 0) {
            i2 = lastIndexOf;
        }
        if (i2 != -1) {
            char charAt = str.charAt(length - 1);
            char c = File.separatorChar;
            if (charAt != c) {
                if (str.indexOf(c) == i2 && str.charAt(i) == File.separatorChar) {
                    return str.substring(0, i2 + 1);
                }
                return str.substring(0, i2);
            }
            return null;
        }
        return null;
    }

    public static com.kwad.framework.filedownloader.e.a bt(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(b("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException(b("create new file error  %s", file.getAbsolutePath()));
            }
            return com.kwad.framework.filedownloader.download.b.ve().b(file);
        }
        throw new RuntimeException("found invalid internal destination path, empty");
    }
}
