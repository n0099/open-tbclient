package com.ss.android.socialbase.downloader.m;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.mapapi.UIMsg;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidubce.http.Headers;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.ss.android.socialbase.downloader.d.s;
import com.ss.android.socialbase.downloader.impls.l;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private static Boolean qiK;
    private static Boolean qjo;

    /* renamed from: a  reason: collision with root package name */
    private static final String f7874a = d.class.getSimpleName();
    private static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String c = null;
    private static volatile SparseArray<Boolean> d = new SparseArray<>();
    private static volatile SparseArray<List<s>> e = new SparseArray<>();
    private static final char[] f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern qjm = null;
    private static Pattern qjn = null;

    public static String a(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = bArr[i4 + i] & 255;
            int i6 = i3 + 1;
            cArr[i3] = f[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = f[i5 & 15];
        }
        return new String(cArr, 0, i2 * 2);
    }

    public static long b(com.ss.android.socialbase.downloader.i.e eVar) {
        if (eVar == null) {
            return -1L;
        }
        String b2 = b(eVar, "Content-Length");
        if (TextUtils.isEmpty(b2) && a.a(1)) {
            return c(eVar);
        }
        try {
            return Long.parseLong(b2);
        } catch (NumberFormatException e2) {
            return -1L;
        }
    }

    public static long c(com.ss.android.socialbase.downloader.i.e eVar) {
        if (eVar == null) {
            return -1L;
        }
        String b2 = b(eVar, Headers.CONTENT_RANGE);
        if (TextUtils.isEmpty(b2)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(b2);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
            return -1L;
        } catch (Exception e2) {
            com.ss.android.socialbase.downloader.f.a.d(f7874a, "parse content-length from content-range failed " + e2);
            return -1L;
        }
    }

    public static long a(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException e2) {
                com.ss.android.socialbase.downloader.f.a.d(f7874a, "parse instance length failed with " + str);
                return -1L;
            }
        }
        return -1L;
    }

    private static String g(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (qjm == null) {
                qjm = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            Matcher matcher = qjm.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (qjn == null) {
                qjn = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = qjn.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static String a(com.ss.android.socialbase.downloader.i.e eVar, String str) {
        String g = g(eVar.a("Content-Disposition"));
        if (TextUtils.isEmpty(g)) {
            return d(str);
        }
        return g;
    }

    public static com.ss.android.socialbase.downloader.g.f A(String str, String str2, int i) throws com.ss.android.socialbase.downloader.e.a {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new com.ss.android.socialbase.downloader.e.a(1021, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        if (file.exists() && file.isDirectory()) {
            throw new com.ss.android.socialbase.downloader.e.a(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (!file2.exists()) {
                        if (!file2.mkdirs()) {
                            throw new com.ss.android.socialbase.downloader.e.a(1030, "download savePath directory can not created");
                        }
                    } else {
                        file2.delete();
                        throw new com.ss.android.socialbase.downloader.e.a(1031, "download savePath is not directory");
                    }
                }
                file.createNewFile();
            } catch (IOException e2) {
                throw new com.ss.android.socialbase.downloader.e.a(1036, e2);
            }
        }
        return new com.ss.android.socialbase.downloader.g.f(file, i);
    }

    public static List<com.ss.android.socialbase.downloader.g.b> a(List<com.ss.android.socialbase.downloader.g.b> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.g.b bVar : list) {
            if (bVar != null) {
                if (bVar.d()) {
                    sparseArray.put(bVar.s(), bVar);
                    List<com.ss.android.socialbase.downloader.g.b> list2 = (List) sparseArray2.get(bVar.s());
                    if (list2 != null) {
                        for (com.ss.android.socialbase.downloader.g.b bVar2 : list2) {
                            bVar2.a(bVar);
                        }
                        bVar.a(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.g.b bVar3 = (com.ss.android.socialbase.downloader.g.b) sparseArray.get(bVar.b());
                    if (bVar3 != null) {
                        List<com.ss.android.socialbase.downloader.g.b> g = bVar3.g();
                        if (g == null) {
                            g = new ArrayList<>();
                            bVar3.a(g);
                        }
                        bVar.a(bVar3);
                        g.add(bVar);
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
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.temp", str);
    }

    public static long b(List<com.ss.android.socialbase.downloader.g.b> list) {
        long j = 0;
        Iterator<com.ss.android.socialbase.downloader.g.b> it = list.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = it.next().o() + j2;
            } else {
                return j2;
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.g.c cVar) {
        a(cVar, true);
    }

    public static void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z) {
        if (cVar != null) {
            if (z) {
                try {
                    c(cVar.k(), cVar.h());
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            c(cVar.l(), cVar.m());
            if (cVar.eIe()) {
                b(cVar);
            }
        }
    }

    public static void b(com.ss.android.socialbase.downloader.g.c cVar) {
        com.ss.android.socialbase.downloader.k.a Sa;
        JSONObject abM;
        if (cVar != null && (abM = (Sa = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g())).abM("anti_hijack_dir")) != null) {
            String optString = abM.optString("ins_desc");
            if (!TextUtils.isEmpty(optString)) {
                c(cVar.k(), optString);
            }
            String i = cVar.i();
            if (TextUtils.isEmpty(i)) {
                i = cVar.h();
            }
            String a2 = a(i, Sa);
            String k = cVar.k();
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(k)) {
                File file = new File(a2);
                for (File file2 = new File(k); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
                    h(file2.getPath());
                    file = file.getParentFile();
                }
            }
        }
    }

    private static boolean h(String str) {
        Log.w(f7874a, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            if (!file.delete()) {
                Log.w(f7874a, "deleteDirIfEmpty return false");
                return false;
            }
            return true;
        }
        return false;
    }

    public static void c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            if (file.exists()) {
                Log.e(f7874a, "deleteFile: " + str + "/" + str2);
                file.delete();
            }
        }
    }

    public static boolean a(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean c(com.ss.android.socialbase.downloader.g.c cVar) {
        return a(cVar, cVar.aj(), cVar.F());
    }

    public static boolean a(com.ss.android.socialbase.downloader.g.c cVar, boolean z, String str) {
        if (z || TextUtils.isEmpty(cVar.k()) || TextUtils.isEmpty(cVar.h())) {
            return false;
        }
        try {
            if (new File(cVar.k(), cVar.h()).exists()) {
                return b(cVar.k(), cVar.h(), str);
            }
            return false;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int a(String str, String str2, String str3) {
        return com.ss.android.c.c.r(str3, new File(str, str2));
    }

    public static boolean b(String str, String str2, String str3) {
        return a(a(str, str2, str3));
    }

    public static boolean a(int i) {
        return i == 0 || i == 2;
    }

    public static int m(File file, String str) {
        return com.ss.android.c.c.r(str, file);
    }

    public static boolean b(File file, String str) {
        return a(com.ss.android.c.c.r(str, file));
    }

    public static String b(int i) {
        String str = "ttmd5 check code = " + i + ", ";
        switch (i) {
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
            case 99:
                return str + "unknown error";
            default:
                return str;
        }
    }

    public static long c(String str) throws com.ss.android.socialbase.downloader.e.a {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (IllegalArgumentException e2) {
            throw new com.ss.android.socialbase.downloader.e.a(1050, e2);
        } catch (Throwable th) {
            throw new com.ss.android.socialbase.downloader.e.a(1052, th);
        }
    }

    public static double a(long j) {
        return j / 1048576.0d;
    }

    public static void a(com.ss.android.socialbase.downloader.g.c cVar, s sVar) {
        int m;
        com.ss.android.socialbase.downloader.e.a e2 = null;
        boolean z = true;
        com.ss.android.socialbase.downloader.f.a.b(f7874a, "saveFileAsTargetName targetName is " + cVar.n());
        try {
            File file = new File(cVar.l(), cVar.m());
            File file2 = new File(cVar.k(), cVar.h());
            com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).h(cVar.g());
            if (!file.exists()) {
                com.ss.android.socialbase.downloader.f.a.b(f7874a, "tempFile not exist");
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.f.a.b(f7874a, "targetFile exist");
                    if (b(file2, cVar.F())) {
                        com.ss.android.socialbase.downloader.f.a.b(f7874a, "tempFile not exist , targetFile exists and md5 check valid");
                        if (sVar != null) {
                            sVar.a();
                            return;
                        }
                        return;
                    } else if (h != null && h.eHR()) {
                        h.a(sVar);
                        return;
                    }
                } else {
                    com.ss.android.socialbase.downloader.f.a.b(f7874a, "targetFile not exist");
                    if (h != null && h.eHR()) {
                        h.a(sVar);
                        return;
                    }
                }
            } else if (file2.exists()) {
                com.ss.android.socialbase.downloader.f.a.b(f7874a, "targetFile exist");
                if (a(m(file2, cVar.F()))) {
                    com.ss.android.socialbase.downloader.f.a.b(f7874a, "tempFile exist , targetFile exists and md5 check valid");
                    if (sVar != null) {
                        sVar.a();
                        return;
                    }
                    return;
                } else if (h != null && h.eHR()) {
                    h.a(sVar);
                    return;
                } else {
                    if (h != null) {
                        h.l(true);
                    }
                    Log.e(f7874a, "saveFileAsTargetName: " + file2.getPath());
                    if (!file2.delete()) {
                        com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(1037, "delete targetPath file existed with md5 check invalid status:" + b(m));
                        if (sVar != null) {
                            sVar.a(aVar);
                        }
                        if (h != null) {
                            h.a(false, aVar);
                            return;
                        }
                        return;
                    }
                }
            }
            if (h != null) {
                h.l(true);
            }
            try {
                if (k(file, file2)) {
                    z = false;
                }
            } catch (com.ss.android.socialbase.downloader.e.a e3) {
                e2 = e3;
                z = false;
            }
            if (z) {
                com.ss.android.socialbase.downloader.e.a aVar2 = e2 == null ? new com.ss.android.socialbase.downloader.e.a(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s), temp file is exist: %d", cVar.l(), cVar.m(), cVar.k(), cVar.h(), Boolean.valueOf(file.exists()))) : e2;
                if (sVar != null) {
                    sVar.a(aVar2);
                }
                if (h != null) {
                    h.a(false, aVar2);
                    return;
                }
                return;
            }
            int a2 = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).a("download_finish_check_ttmd5", 2);
            if (a2 > 0) {
                int m2 = m(file2, cVar.F());
                cVar.a(m2);
                if (a2 >= 2 && !a(m2)) {
                    if (sVar != null) {
                        sVar.a(new com.ss.android.socialbase.downloader.e.a(1034, b(m2)));
                    }
                    a(cVar);
                    return;
                }
            }
            if (sVar != null) {
                sVar.a();
            }
            if (h != null) {
                h.a(true, (com.ss.android.socialbase.downloader.e.a) null);
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.f.a.b(f7874a, "saveFileAsTargetName throwable " + th.getMessage());
            if (sVar != null) {
                sVar.a(new com.ss.android.socialbase.downloader.e.a(1038, c(th, "saveFileAsTargetName")));
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.d.c cVar2, s sVar) {
        boolean z;
        boolean z2 = false;
        com.ss.android.socialbase.downloader.f.a.b(f7874a, "saveFileAsTargetName targetName is " + cVar.n());
        try {
            synchronized (d) {
                if (d.get(cVar.g()) == Boolean.TRUE) {
                    com.ss.android.socialbase.downloader.f.a.b(f7874a, "has another same task is saving temp file");
                    if (sVar != null) {
                        List<s> list = e.get(cVar.g());
                        if (list == null) {
                            list = new ArrayList<>();
                            e.put(cVar.g(), list);
                        }
                        list.add(sVar);
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.f.a.b(f7874a, "saveTempFileStatusMap put id:" + cVar.g());
                d.put(cVar.g(), Boolean.TRUE);
                File file = new File(cVar.l(), cVar.m());
                File file2 = new File(cVar.k(), cVar.h());
                if (file2.exists()) {
                    com.ss.android.socialbase.downloader.f.a.b(f7874a, "targetFile exist");
                    int m = m(file2, cVar.F());
                    if (a(m)) {
                        com.ss.android.socialbase.downloader.f.a.b(f7874a, "tempFile not exist , targetFile exists and md5 check valid");
                        cVar.a(m);
                        if (sVar != null) {
                            sVar.a();
                        }
                        a(cVar.g(), true, (com.ss.android.socialbase.downloader.e.a) null);
                        z = false;
                    } else {
                        if (file.exists()) {
                            z = true;
                        } else {
                            com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", cVar.l(), cVar.m(), cVar.k(), cVar.h(), b(m)));
                            if (sVar != null) {
                                sVar.a(aVar);
                            }
                            a(cVar.g(), false, aVar);
                            z = false;
                        }
                        if (!file2.delete()) {
                            if (!z) {
                                if (cVar2 != null) {
                                    com.ss.android.socialbase.downloader.h.a.a(cVar2, cVar, new com.ss.android.socialbase.downloader.e.a(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), cVar.q());
                                }
                            } else {
                                com.ss.android.socialbase.downloader.e.a aVar2 = new com.ss.android.socialbase.downloader.e.a(1037, "delete targetPath file existed with md5 check invalid status:" + b(m));
                                if (sVar != null) {
                                    sVar.a(aVar2);
                                }
                                a(cVar.g(), false, aVar2);
                                z = false;
                            }
                        }
                    }
                } else if (file.exists()) {
                    z = true;
                } else {
                    com.ss.android.socialbase.downloader.e.a aVar3 = new com.ss.android.socialbase.downloader.e.a(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", cVar.l(), cVar.m(), cVar.k(), cVar.h()));
                    if (sVar != null) {
                        sVar.a(aVar3);
                    }
                    a(cVar.g(), false, aVar3);
                    z = false;
                }
                if (z) {
                    com.ss.android.socialbase.downloader.e.a e2 = null;
                    try {
                        if (!k(file, file2)) {
                            z2 = true;
                        }
                    } catch (com.ss.android.socialbase.downloader.e.a e3) {
                        e2 = e3;
                        if (com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).a("fix_file_rename_failed")) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        if (e2 == null) {
                            e2 = new com.ss.android.socialbase.downloader.e.a(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", cVar.l(), cVar.m(), cVar.k(), cVar.h()));
                        }
                        if (sVar != null) {
                            sVar.a(e2);
                        }
                        a(cVar.g(), false, e2);
                        return;
                    }
                    int a2 = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).a("download_finish_check_ttmd5", 2);
                    if (a2 > 0) {
                        int m2 = m(file2, cVar.F());
                        cVar.a(m2);
                        if (a2 >= 2 && !a(m2)) {
                            com.ss.android.socialbase.downloader.e.a aVar4 = new com.ss.android.socialbase.downloader.e.a(1034, b(m2));
                            if (sVar != null) {
                                sVar.a(aVar4);
                            }
                            a(cVar.g(), false, aVar4);
                            a(cVar);
                            return;
                        }
                    }
                    if (sVar != null) {
                        sVar.a();
                    }
                    a(cVar.g(), true, (com.ss.android.socialbase.downloader.e.a) null);
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.f.a.b(f7874a, "saveFileAsTargetName throwable " + th.getMessage());
            if (sVar != null) {
                sVar.a(new com.ss.android.socialbase.downloader.e.a(1038, c(th, "saveFileAsTargetName")));
            }
        }
    }

    private static void a(int i, boolean z, com.ss.android.socialbase.downloader.e.a aVar) {
        synchronized (d) {
            List<s> list = e.get(i);
            if (list != null) {
                for (s sVar : list) {
                    if (sVar != null) {
                        if (z) {
                            sVar.a();
                        } else {
                            sVar.a(aVar);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.f.a.b(f7874a, "handleTempSaveCallback id:" + i);
            d.remove(i);
        }
    }

    public static void a(com.ss.android.socialbase.downloader.g.c cVar, String str) throws com.ss.android.socialbase.downloader.e.a {
        if (cVar != null && !TextUtils.isEmpty(str) && !str.equals(cVar.h())) {
            File file = new File(cVar.k(), str);
            File file2 = new File(cVar.k(), cVar.h());
            Log.e(f7874a, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
            if (file2.exists() && !file2.delete()) {
                throw new com.ss.android.socialbase.downloader.e.a(1037, "targetPath file exists but can't delete");
            }
            if (!a(file, file2)) {
                throw new com.ss.android.socialbase.downloader.e.a(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", cVar.k(), str, cVar.k(), cVar.h()));
            }
        }
    }

    public static boolean a(File file, File file2) throws com.ss.android.socialbase.downloader.e.a {
        return c(file, file2, true);
    }

    public static boolean c(File file, File file2, boolean z) throws com.ss.android.socialbase.downloader.e.a {
        if (file == null || file2 == null) {
            return false;
        }
        try {
            if (!file.exists() || file.isDirectory() || file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                return false;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new com.ss.android.socialbase.downloader.e.a(1053, "Destination '" + parentFile + "' directory cannot be created");
            }
            Log.e(f7874a, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
            if (file2.exists() && !file2.canWrite() && !file2.delete()) {
                throw new IOException("Destination '" + file2 + "' exists but is read-only and delete failed");
            }
            b(file, file2, z);
            return true;
        } catch (com.ss.android.socialbase.downloader.e.a e2) {
            throw e2;
        } catch (Throwable th) {
            a(th, "CopyFile");
            return false;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [939=7, 923=8] */
    @android.annotation.TargetApi(19)
    private static void b(java.io.File r18, java.io.File r19, boolean r20) throws java.io.IOException {
        /*
            boolean r2 = r19.exists()
            if (r2 == 0) goto L2f
            boolean r2 = r19.isDirectory()
            if (r2 == 0) goto L2f
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Destination '"
            java.lang.StringBuilder r3 = r3.append(r4)
            r0 = r19
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "' exists but is a directory"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L2f:
            java.io.FileInputStream r12 = new java.io.FileInputStream
            r0 = r18
            r12.<init>(r0)
            r11 = 0
            java.nio.channels.FileChannel r3 = r12.getChannel()     // Catch: java.lang.Throwable -> Lf0
            r10 = 0
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Le4
            r0 = r19
            r13.<init>(r0)     // Catch: java.lang.Throwable -> Le4
            r9 = 0
            java.nio.channels.FileChannel r2 = r13.getChannel()     // Catch: java.lang.Throwable -> Ld8
            r8 = 0
            long r14 = r3.size()     // Catch: java.lang.Throwable -> L105
            r4 = 0
        L4f:
            int r6 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r6 >= 0) goto L69
            long r6 = r14 - r4
            r16 = 31457280(0x1e00000, double:1.55419614E-316)
            int r16 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r16 <= 0) goto L5f
            r6 = 31457280(0x1e00000, double:1.55419614E-316)
        L5f:
            long r6 = r2.transferFrom(r3, r4, r6)     // Catch: java.lang.Throwable -> L105
            r16 = 0
            int r16 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r16 != 0) goto Ld0
        L69:
            if (r2 == 0) goto L70
            if (r8 == 0) goto Lfc
            r2.close()     // Catch: java.lang.Throwable -> Ld3
        L70:
            if (r13 == 0) goto L77
            if (r9 == 0) goto L124
            r13.close()     // Catch: java.lang.Throwable -> L11a
        L77:
            if (r3 == 0) goto L7e
            if (r10 == 0) goto L13c
            r3.close()     // Catch: java.lang.Throwable -> L132
        L7e:
            if (r12 == 0) goto L85
            if (r11 == 0) goto L150
            r12.close()     // Catch: java.lang.Throwable -> L14a
        L85:
            long r2 = r18.length()
            long r4 = r19.length()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L15e
            java.io.IOException r6 = new java.io.IOException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to copy full contents from '"
            java.lang.StringBuilder r7 = r7.append(r8)
            r0 = r18
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r8 = "' to '"
            java.lang.StringBuilder r7 = r7.append(r8)
            r0 = r19
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r8 = "' Expected length: "
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r2 = r7.append(r2)
            java.lang.String r3 = " Actual: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            r6.<init>(r2)
            throw r6
        Ld0:
            long r4 = r4 + r6
            goto L4f
        Ld3:
            r2 = move-exception
            r8.addSuppressed(r2)     // Catch: java.lang.Throwable -> Ld8
            goto L70
        Ld8:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> Lda
        Lda:
            r4 = move-exception
            r5 = r2
        Ldc:
            if (r13 == 0) goto Le3
            if (r5 == 0) goto L12e
            r13.close()     // Catch: java.lang.Throwable -> L129
        Le3:
            throw r4     // Catch: java.lang.Throwable -> Le4
        Le4:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> Le6
        Le6:
            r4 = move-exception
            r5 = r2
        Le8:
            if (r3 == 0) goto Lef
            if (r5 == 0) goto L146
            r3.close()     // Catch: java.lang.Throwable -> L141
        Lef:
            throw r4     // Catch: java.lang.Throwable -> Lf0
        Lf0:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> Lf2
        Lf2:
            r3 = move-exception
            r4 = r2
        Lf4:
            if (r12 == 0) goto Lfb
            if (r4 == 0) goto L15a
            r12.close()     // Catch: java.lang.Throwable -> L155
        Lfb:
            throw r3
        Lfc:
            r2.close()     // Catch: java.lang.Throwable -> Ld8
            goto L70
        L101:
            r2 = move-exception
            r4 = r2
            r5 = r9
            goto Ldc
        L105:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L107
        L107:
            r5 = move-exception
            r6 = r4
        L109:
            if (r2 == 0) goto L110
            if (r6 == 0) goto L116
            r2.close()     // Catch: java.lang.Throwable -> L111
        L110:
            throw r5     // Catch: java.lang.Throwable -> Ld8
        L111:
            r2 = move-exception
            r6.addSuppressed(r2)     // Catch: java.lang.Throwable -> Ld8
            goto L110
        L116:
            r2.close()     // Catch: java.lang.Throwable -> Ld8
            goto L110
        L11a:
            r2 = move-exception
            r9.addSuppressed(r2)     // Catch: java.lang.Throwable -> Le4
            goto L77
        L120:
            r2 = move-exception
            r4 = r2
            r5 = r10
            goto Le8
        L124:
            r13.close()     // Catch: java.lang.Throwable -> Le4
            goto L77
        L129:
            r2 = move-exception
            r5.addSuppressed(r2)     // Catch: java.lang.Throwable -> Le4
            goto Le3
        L12e:
            r13.close()     // Catch: java.lang.Throwable -> Le4
            goto Le3
        L132:
            r2 = move-exception
            r10.addSuppressed(r2)     // Catch: java.lang.Throwable -> Lf0
            goto L7e
        L138:
            r2 = move-exception
            r3 = r2
            r4 = r11
            goto Lf4
        L13c:
            r3.close()     // Catch: java.lang.Throwable -> Lf0
            goto L7e
        L141:
            r2 = move-exception
            r5.addSuppressed(r2)     // Catch: java.lang.Throwable -> Lf0
            goto Lef
        L146:
            r3.close()     // Catch: java.lang.Throwable -> Lf0
            goto Lef
        L14a:
            r2 = move-exception
            r11.addSuppressed(r2)
            goto L85
        L150:
            r12.close()
            goto L85
        L155:
            r2 = move-exception
            r4.addSuppressed(r2)
            goto Lfb
        L15a:
            r12.close()
            goto Lfb
        L15e:
            if (r20 == 0) goto L169
            long r2 = r18.lastModified()
            r0 = r19
            r0.setLastModified(r2)
        L169:
            return
        L16a:
            r4 = move-exception
            r5 = r4
            r6 = r8
            goto L109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.m.d.b(java.io.File, java.io.File, boolean):void");
    }

    public static boolean k(File file, File file2) throws com.ss.android.socialbase.downloader.e.a {
        Log.e(f7874a, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = a(file, file2);
            try {
                Log.e(f7874a, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean a(int i, String str) {
        if (a.a(16777216)) {
            return i == 206 || i == 1;
        } else if (i < 400) {
            return i == 206 || i == 1 || "bytes".equals(str);
        } else {
            return false;
        }
    }

    public static boolean c(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static boolean d(int i) {
        return i == 206 || i == 200;
    }

    public static boolean b(long j) {
        return j == -1;
    }

    public static boolean d(com.ss.android.socialbase.downloader.i.e eVar) {
        if (eVar == null) {
            return false;
        }
        if (a.a(8)) {
            return HTTP.CHUNK_CODING.equals(eVar.a("Transfer-Encoding")) || b(eVar) == -1;
        }
        return b(eVar) == -1;
    }

    public static List<com.ss.android.socialbase.downloader.g.e> a(List<com.ss.android.socialbase.downloader.g.e> list, String str, com.ss.android.socialbase.downloader.g.b bVar) {
        return a(list, str, bVar.m(), bVar.p());
    }

    public static List<com.ss.android.socialbase.downloader.g.e> a(List<com.ss.android.socialbase.downloader.g.e> list, String str, long j, long j2) {
        String format;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.g.e eVar : list) {
                if (eVar != null) {
                    arrayList.add(eVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.g.e("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.g.e(Headers.ACCEPT_ENCODING, "identity"));
        com.ss.android.socialbase.downloader.f.a.b(f7874a, "range CurrentOffset:" + j + " EndOffset:" + j2);
        if (j2 == 0) {
            format = String.format("bytes=%s-", String.valueOf(j));
        } else {
            format = String.format("bytes=%s-%s", String.valueOf(j), String.valueOf(j2));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.g.e(Headers.RANGE, format));
        return arrayList;
    }

    public static boolean s(int i, String str, String str2) {
        return i == -3 && !d(str, str2);
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return 1 == activeNetworkInfo.getType();
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static String d(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                messageDigest.update(str.getBytes("UTF-8"));
                return a(messageDigest.digest());
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    public static String c(Context context) {
        String str = c;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
                if (activityManager != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            if (com.ss.android.socialbase.downloader.f.a.a()) {
                                com.ss.android.socialbase.downloader.f.a.b("Process", "processName = " + runningAppProcessInfo.processName);
                            }
                            c = runningAppProcessInfo.processName;
                            return c;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c = e();
            return c;
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String e() {
        /*
            r0 = 0
            r7 = 1
            r6 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L8c
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L8c
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r4.<init>()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r5 = "/proc/"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L8c
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r5 = "/cmdline"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L8c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r2.<init>()     // Catch: java.lang.Throwable -> L44
        L39:
            int r3 = r1.read()     // Catch: java.lang.Throwable -> L44
            if (r3 <= 0) goto L4d
            char r3 = (char) r3     // Catch: java.lang.Throwable -> L44
            r2.append(r3)     // Catch: java.lang.Throwable -> L44
            goto L39
        L44:
            r2 = move-exception
        L45:
            java.io.Closeable[] r2 = new java.io.Closeable[r7]
            r2[r6] = r1
            a(r2)
        L4c:
            return r0
        L4d:
            boolean r3 = com.ss.android.socialbase.downloader.f.a.a()     // Catch: java.lang.Throwable -> L44
            if (r3 == 0) goto L71
            java.lang.String r3 = "Process"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r4.<init>()     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = "get processName = "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L44
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L44
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L44
            com.ss.android.socialbase.downloader.f.a.b(r3, r4)     // Catch: java.lang.Throwable -> L44
        L71:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L44
            java.io.Closeable[] r2 = new java.io.Closeable[r7]
            r2[r6] = r1
            a(r2)
            goto L4c
        L7d:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L80:
            java.io.Closeable[] r0 = new java.io.Closeable[r7]
            r0[r6] = r3
            a(r0)
            throw r2
        L88:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L80
        L8c:
            r1 = move-exception
            r1 = r0
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.m.d.e():java.lang.String");
    }

    public static boolean a() {
        boolean z = false;
        if (qjo != null) {
            return qjo.booleanValue();
        }
        String c2 = c(com.ss.android.socialbase.downloader.downloader.b.eGG());
        if (c2 != null && c2.contains(":")) {
            qjo = false;
        } else {
            if (c2 != null && c2.equals(com.ss.android.socialbase.downloader.downloader.b.eGG().getPackageName())) {
                z = true;
            }
            qjo = Boolean.valueOf(z);
        }
        return qjo.booleanValue();
    }

    public static boolean b() {
        return !c() && com.ss.android.socialbase.downloader.downloader.b.b() && l.CM(true).g();
    }

    public static boolean c() {
        if (qiK != null) {
            return qiK.booleanValue();
        }
        String c2 = c(com.ss.android.socialbase.downloader.downloader.b.eGG());
        if (c2 != null && c2.equals(com.ss.android.socialbase.downloader.downloader.b.eGG().getPackageName() + ":downloader")) {
            qiK = true;
        } else {
            qiK = false;
        }
        return qiK.booleanValue();
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String c2 = c(com.ss.android.socialbase.downloader.downloader.b.eGG());
        return c2 != null && c2.equals(str);
    }

    public static boolean d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String f(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        String K = K(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(K)) {
                return false;
            }
            if (!K.contains("time out") && !K.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(Throwable th) {
        if (th == null) {
            return false;
        }
        String K = K(th);
        if (th instanceof com.ss.android.socialbase.downloader.e.c) {
            com.ss.android.socialbase.downloader.e.c cVar = (com.ss.android.socialbase.downloader.e.c) th;
            if (cVar != null && cVar.c() == 403) {
                return true;
            }
            if (!TextUtils.isEmpty(K) && K.contains("403")) {
                return true;
            }
        }
        return !TextUtils.isEmpty(K) && K.contains("Forbidden");
    }

    public static boolean q(Throwable th) {
        if (th == null) {
            return false;
        }
        String K = K(th);
        return !TextUtils.isEmpty(K) && K.contains("network not available");
    }

    public static boolean F(Throwable th) {
        if (th == null) {
            return false;
        }
        String K = K(th);
        return !TextUtils.isEmpty(K) && K.contains("Exception in connect");
    }

    public static boolean G(Throwable th) {
        if (th == null) {
            return false;
        }
        String K = K(th);
        return !TextUtils.isEmpty(K) && K.contains("Precondition Failed");
    }

    public static boolean H(Throwable th) {
        if (th == null) {
            return false;
        }
        String K = K(th);
        return !TextUtils.isEmpty(K) && K.contains("Requested Range Not Satisfiable");
    }

    public static boolean d(com.ss.android.socialbase.downloader.e.a aVar) {
        return aVar != null && aVar.a() == 1051;
    }

    public static boolean g(com.ss.android.socialbase.downloader.e.a aVar) {
        return (aVar instanceof com.ss.android.socialbase.downloader.e.c) && (((com.ss.android.socialbase.downloader.e.c) aVar).c() == 412 || ((com.ss.android.socialbase.downloader.e.c) aVar).c() == 416);
    }

    public static void a(Throwable th, String str) throws com.ss.android.socialbase.downloader.e.a {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof com.ss.android.socialbase.downloader.e.a) {
            ((com.ss.android.socialbase.downloader.e.a) th).a(str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((com.ss.android.socialbase.downloader.e.a) th).b());
            throw ((com.ss.android.socialbase.downloader.e.a) th);
        } else if (th instanceof SSLHandshakeException) {
            throw new com.ss.android.socialbase.downloader.e.a(1011, c(th, str2));
        } else {
            if (a(th)) {
                throw new com.ss.android.socialbase.downloader.e.a(1048, c(th, str2));
            }
            if (G(th)) {
                throw new com.ss.android.socialbase.downloader.e.c(1004, 412, c(th, str2));
            }
            if (H(th)) {
                throw new com.ss.android.socialbase.downloader.e.c(1004, HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, c(th, str2));
            }
            if (b(th)) {
                throw new com.ss.android.socialbase.downloader.e.a(1047, c(th, str2));
            }
            if (q(th)) {
                throw new com.ss.android.socialbase.downloader.e.a(1049, c(th, str2));
            }
            if (F(th)) {
                throw new com.ss.android.socialbase.downloader.e.a(1041, c(th, str2));
            }
            if (th instanceof IOException) {
                a((IOException) th, str);
                return;
            }
            throw new com.ss.android.socialbase.downloader.e.a(1000, c(th, str2));
        }
    }

    public static void a(IOException iOException, String str) throws com.ss.android.socialbase.downloader.e.a {
        if (str == null) {
            str = "";
        }
        String c2 = c(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new com.ss.android.socialbase.downloader.e.a(1041, c2);
        }
        if (iOException instanceof UnknownHostException) {
            throw new com.ss.android.socialbase.downloader.e.a(1055, c2);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new com.ss.android.socialbase.downloader.e.a(1056, c2);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new com.ss.android.socialbase.downloader.e.a(1057, c2);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new com.ss.android.socialbase.downloader.e.a(1058, c2);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new com.ss.android.socialbase.downloader.e.a(1048, c2);
        }
        if (iOException instanceof SocketException) {
            throw new com.ss.android.socialbase.downloader.e.a(1059, c2);
        }
        if (iOException instanceof HttpRetryException) {
            throw new com.ss.android.socialbase.downloader.e.a(1060, c2);
        }
        if (iOException instanceof ProtocolException) {
            throw new com.ss.android.socialbase.downloader.e.a(1061, c2);
        }
        if (iOException instanceof MalformedURLException) {
            throw new com.ss.android.socialbase.downloader.e.a(1062, c2);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new com.ss.android.socialbase.downloader.e.a(1063, c2);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new com.ss.android.socialbase.downloader.e.a(1064, c2);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new com.ss.android.socialbase.downloader.e.a(1065, c2);
        }
        if (iOException instanceof EOFException) {
            throw new com.ss.android.socialbase.downloader.e.a(1066, c2);
        }
        if (iOException instanceof StreamResetException) {
            throw new com.ss.android.socialbase.downloader.e.a(1067, c2);
        }
        if (iOException instanceof SSLException) {
            throw new com.ss.android.socialbase.downloader.e.a(1011, c2);
        }
        if (I(iOException)) {
            throw new com.ss.android.socialbase.downloader.e.a(1006, c2);
        }
        throw new com.ss.android.socialbase.downloader.e.a(1023, c2);
    }

    public static boolean I(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof com.ss.android.socialbase.downloader.e.a) {
            com.ss.android.socialbase.downloader.e.a aVar = (com.ss.android.socialbase.downloader.e.a) th;
            int a2 = aVar.a();
            if (a2 == 1006) {
                return true;
            }
            if (a2 == 1023 || a2 == 1039 || a2 == 1040 || a2 == 1054 || a2 == 1064) {
                String message = aVar.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String K = K(th);
            return !TextUtils.isEmpty(K) && K.contains("ENOSPC");
        }
        return false;
    }

    public static boolean J(Throwable th) {
        if (th instanceof com.ss.android.socialbase.downloader.e.a) {
            int a2 = ((com.ss.android.socialbase.downloader.e.a) th).a();
            return a2 == 1055 || a2 == 1023 || a2 == 1041 || a2 == 1022 || a2 == 1048 || a2 == 1056 || a2 == 1057 || a2 == 1058 || a2 == 1059 || a2 == 1060 || a2 == 1061 || a2 == 1067 || a2 == 1049 || a2 == 1047 || a2 == 1051 || a2 == 1004 || a2 == 1011 || a2 == 1002 || a2 == 1013;
        }
        return false;
    }

    public static boolean a(com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.g.c cVar) {
        if (aVar == null) {
            return false;
        }
        int a2 = aVar.a();
        if (a2 == 1000 || a2 == 1032 || a2 == 1033 || a2 == 1034 || a2 == 1008 || a2 == 1026 || a2 == 1027 || a2 == 1044 || a2 == 1020) {
            return true;
        }
        return (a2 == 1049 || a2 == 1055 || a2 == 1006 || cVar == null || cVar.eHm() >= 8388608) ? false : true;
    }

    public static String c(Throwable th, String str) {
        return str == null ? K(th) : str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + K(th);
    }

    public static String K(Throwable th) {
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

    public static com.ss.android.socialbase.downloader.b.h Se(int i) {
        com.ss.android.socialbase.downloader.b.h hVar = com.ss.android.socialbase.downloader.b.h.MAIN;
        if (i == com.ss.android.socialbase.downloader.b.h.SUB.ordinal()) {
            return com.ss.android.socialbase.downloader.b.h.SUB;
        }
        if (i == com.ss.android.socialbase.downloader.b.h.NOTIFICATION.ordinal()) {
            return com.ss.android.socialbase.downloader.b.h.NOTIFICATION;
        }
        return hVar;
    }

    public static <K> HashMap<Integer, K> j(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i));
        }
        return hashMap;
    }

    public static <K> void a(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map != null && sparseArray != null) {
            for (Integer num : map.keySet()) {
                if (num != null) {
                    sparseArray.put(num.intValue(), map.get(num));
                }
            }
        }
    }

    public static long t(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.g.b> c2 = com.ss.android.socialbase.downloader.downloader.b.eGw().c(cVar.g());
        if (cVar.eHW() == 1) {
            return cVar.eHm();
        }
        if (c2 != null && c2.size() > 1) {
            long hd = hd(c2);
            if (hd >= 0) {
                return hd;
            }
        }
        return 0L;
    }

    private static long hd(List<com.ss.android.socialbase.downloader.g.b> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j = -1;
        for (com.ss.android.socialbase.downloader.g.b bVar : list) {
            if (bVar != null && ((bVar.n() <= bVar.p() || bVar.p() == 0) && (j == -1 || j > bVar.n()))) {
                j = bVar.n();
            }
            j = j;
        }
        return j;
    }

    public static long u(com.ss.android.socialbase.downloader.g.c cVar) {
        long j;
        if (cVar == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.g.b> c2 = com.ss.android.socialbase.downloader.downloader.b.eGw().c(cVar.g());
        int eHW = cVar.eHW();
        boolean z = eHW > 1;
        if (cVar.eHS()) {
            if (z) {
                if (c2 != null && eHW == c2.size()) {
                    j = b(c2);
                }
            } else {
                j = cVar.eHm();
            }
            return j;
        }
        j = 0;
        return j;
    }

    public static boolean H(List<com.ss.android.socialbase.downloader.g.e> list, List<com.ss.android.socialbase.downloader.g.e> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
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
    }

    public static String a(String str, int i) {
        if (i == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static String a(String str, com.ss.android.socialbase.downloader.k.a aVar) {
        JSONObject abM;
        if (aVar == null || (abM = aVar.abM("anti_hijack_dir")) == null) {
            return "";
        }
        String optString = abM.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (!TextUtils.isEmpty(optString)) {
            if (optString.contains("%s")) {
                try {
                    optString = String.format(optString, str);
                } catch (Throwable th) {
                }
            } else {
                optString = optString + str;
            }
            if (optString.length() > 255) {
                return optString.substring(optString.length() + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE);
            }
            return optString;
        }
        return optString;
    }

    public static void a(List<com.ss.android.socialbase.downloader.g.e> list, com.ss.android.socialbase.downloader.g.c cVar) {
        long eIj = cVar.eIj();
        if (eIj > 0) {
            list.add(new com.ss.android.socialbase.downloader.g.e("extra_throttle_net_speed", String.valueOf(eIj)));
        }
    }

    public static String b(com.ss.android.socialbase.downloader.i.e eVar, String str) {
        if (eVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String a2 = eVar.a(str);
        if (com.ss.android.socialbase.downloader.k.a.eIH().b("fix_get_http_resp_head_ignore_case", true)) {
            if (TextUtils.isEmpty(a2)) {
                a2 = eVar.a(str.toLowerCase());
            }
            if (TextUtils.isEmpty(a2)) {
                return eVar.a(str.toUpperCase());
            }
            return a2;
        }
        return a2;
    }

    public static int a(Object obj, int i) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e2) {
            return i;
        }
    }

    public static String a(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException e2) {
            return str;
        }
    }

    public static boolean f(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e2) {
            return z;
        }
    }
}
