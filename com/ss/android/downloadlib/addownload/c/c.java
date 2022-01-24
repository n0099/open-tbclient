package com.ss.android.downloadlib.addownload.c;

import android.content.Context;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static void a() {
        List<DownloadInfo> a = com.ss.android.socialbase.appdownloader.d.j().a(j.getContext());
        if (a == null || a.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < a.size(); i2++) {
            DownloadInfo downloadInfo = a.get(i2);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_file_expire_hours", 0) * 3600000;
            if (a2 <= 0) {
                a2 = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= a2) {
                a(file);
                Downloader.getInstance(j.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void b() {
        DownloadInfo downloadInfo;
        List successedDownloadInfosWithMimeType = Downloader.getInstance(j.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < successedDownloadInfosWithMimeType.size(); i2++) {
            if (((DownloadInfo) successedDownloadInfosWithMimeType.get(i2)) != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_complete_file_expire_hours", 0) * 3600000;
                    if (a <= 0) {
                        a = 604800000;
                    }
                    boolean z = true;
                    if (currentTimeMillis < a && !l.e(j.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        a(file);
                    }
                }
            }
        }
    }

    public static void a(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            a(externalCacheDir.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(File file) {
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

    public static void a(String str) {
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
                        a(str3);
                    }
                }
            }
            file.delete();
        }
    }
}
