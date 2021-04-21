package d.p.a.d.f.d;

import android.content.Context;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.d.f.n;
import d.p.a.d.n.k;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static void a() {
        List<DownloadInfo> h2 = d.p.a.e.a.e.F().h(n.a());
        if (h2 == null || h2.size() <= 0) {
            return;
        }
        for (int i = 0; i < h2.size(); i++) {
            DownloadInfo downloadInfo = h2.get(i);
            File file = new File(downloadInfo.N0(), downloadInfo.M0());
            long lastModified = file.lastModified();
            long b2 = d.p.a.e.b.j.a.d(downloadInfo.c0()).b("download_file_expire_hours", 0) * VideoCloudSetting.HOUR_MILLISECOND;
            if (b2 <= 0) {
                b2 = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= b2) {
                c(file);
                d.p.a.e.b.g.a.l(n.a()).d(downloadInfo.c0());
            }
        }
    }

    public static void b(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            d(externalCacheDir.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(File file) {
        FileOutputStream fileOutputStream;
        Exception e2;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write("1".getBytes());
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    file.delete();
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileOutputStream = null;
            e2 = e6;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        file.delete();
    }

    public static void d(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = str.endsWith(File.separator) ? str + str2 : str + File.separator + str2;
                    File file2 = new File(str3);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        d(str3);
                    }
                }
            }
            file.delete();
        }
    }

    public static void e() {
        DownloadInfo downloadInfo;
        List<DownloadInfo> o = d.p.a.e.b.g.a.l(n.a()).o("application/vnd.android.package-archive");
        if (o == null || o.isEmpty()) {
            return;
        }
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i) != null) {
                String str = downloadInfo.F0() + File.separator + downloadInfo.q0();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long b2 = d.p.a.e.b.j.a.d(downloadInfo.c0()).b("download_complete_file_expire_hours", 0) * VideoCloudSetting.HOUR_MILLISECOND;
                    if (b2 <= 0) {
                        b2 = 604800000;
                    }
                    boolean z = true;
                    if (currentTimeMillis < b2 && !k.K(n.a(), str)) {
                        z = false;
                    }
                    if (z) {
                        c(file);
                    }
                }
            }
        }
    }
}
