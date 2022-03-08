package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes8.dex */
public class a implements r {
    public int a;

    private long b(com.ss.android.socialbase.downloader.g.a aVar) {
        long a = aVar.a("clear_space_sleep_time", 0L);
        if (a <= 0) {
            return 0L;
        }
        if (a > 5000) {
            a = 5000;
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + a, null);
        try {
            Thread.sleep(a);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return a;
    }

    public void a(int i2) {
        this.a = i2;
    }

    @Override // com.ss.android.socialbase.downloader.depend.r
    public boolean a(long j2, long j3, q qVar) {
        long j4;
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(this.a);
        if (a(a)) {
            long currentTimeMillis = System.currentTimeMillis();
            d.a().c();
            long a2 = l.a(0L);
            a();
            long a3 = l.a(0L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a3 < j3) {
                long b2 = b(a);
                if (b2 > 0) {
                    a3 = l.a(0L);
                }
                j4 = b2;
            } else {
                j4 = 0;
            }
            k.b("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j3 + ", byteAvailableAfter = " + a3 + ", cleaned = " + (a3 - a2), null);
            a(a2, a3, j3, currentTimeMillis2, j4);
            if (a3 < j3) {
                return false;
            }
            if (qVar != null) {
                qVar.a();
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (aVar.a("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - d.a().b() >= aVar.a("clear_space_min_time_interval", 600000L);
    }

    private void a() {
        com.ss.android.download.api.config.e o = j.o();
        if (o != null) {
            o.a();
        }
        c.a();
        c.b();
    }

    private void a(long j2, long j3, long j4, long j5, long j6) {
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(this.a);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.a.a().a(downloadInfo, j2, j3, j4, j5, j6, j3 > j4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
