package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;
/* loaded from: classes4.dex */
public class i {
    public static int a(int i2, int i3) {
        return (i3 <= 0 || i3 >= 100 || !a(i2)) ? i3 : (int) (Math.sqrt(i3) * 10.0d);
    }

    public static long a(int i2, long j2, long j3) {
        if (a(i2)) {
            if (j2 <= 0) {
                return 0L;
            }
            return j3 <= 0 ? j2 : (j3 * a(i2, (int) ((j2 * 100) / j3))) / 100;
        }
        return j2;
    }

    public static DownloadShortInfo a(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && a((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = a((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    public static boolean a(int i2) {
        return com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_switch", 0) == 1;
    }
}
