package com.ss.android.downloadlib.addownload.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        List<DownloadInfo> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65536, null) == null) || (a2 = com.ss.android.socialbase.appdownloader.d.j().a(j.getContext())) == null || a2.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < a2.size(); i2++) {
            DownloadInfo downloadInfo = a2.get(i2);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long a3 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_file_expire_hours", 0) * 3600000;
            if (a3 <= 0) {
                a3 = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= a3) {
                a(file);
                Downloader.getInstance(j.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void b() {
        List successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (successedDownloadInfosWithMimeType = Downloader.getInstance(j.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < successedDownloadInfosWithMimeType.size(); i2++) {
            if (((DownloadInfo) successedDownloadInfosWithMimeType.get(i2)) != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_complete_file_expire_hours", 0) * 3600000;
                    if (a2 <= 0) {
                        a2 = 604800000;
                    }
                    boolean z = true;
                    if (currentTimeMillis < a2 && !l.e(j.getContext(), str)) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            a(externalCacheDir.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0017 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(File file) {
        Interceptable interceptable;
        ?? r1;
        Exception e2;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null) {
            interceptable = interceptable2;
            if (interceptable.invokeL(65538, null, file) != null) {
                return;
            }
        }
        ?? r0 = null;
        try {
            try {
                r1 = new FileOutputStream(file);
                try {
                    r1.write("1".getBytes());
                    r1.close();
                    interceptable = r1;
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    interceptable = r1;
                    if (r1 != 0) {
                        try {
                            r1.close();
                            interceptable = r1;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            interceptable = r1;
                        }
                    }
                    file.delete();
                }
            } catch (Throwable th) {
                th = th;
                r0 = interceptable;
                if (r0 != null) {
                    try {
                        r0.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            r1 = 0;
            e2 = e6;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != null) {
            }
            throw th;
        }
        file.delete();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
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
}
