package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes10.dex */
public class a implements r {
    public int a;

    private void a() {
        com.ss.android.download.api.config.e o = j.o();
        if (o != null) {
            o.a();
        }
        c.a();
        c.b();
    }

    private void a(long j, long j2, long j3, long j4, long j5) {
        boolean z;
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(this.a);
        if (downloadInfo == null) {
            return;
        }
        if (j2 > j3) {
            z = true;
        } else {
            z = false;
        }
        try {
            com.ss.android.downloadlib.a.a().a(downloadInfo, j, j2, j3, j4, j5, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (aVar.a("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        if (System.currentTimeMillis() - d.a().b() < aVar.a("clear_space_min_time_interval", 600000L)) {
            return false;
        }
        return true;
    }

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return a;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // com.ss.android.socialbase.downloader.depend.r
    public boolean a(long j, long j2, q qVar) {
        long j3;
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(this.a);
        if (!a(a)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        d.a().c();
        long a2 = l.a(0L);
        a();
        long a3 = l.a(0L);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (a3 < j2) {
            long b = b(a);
            if (b > 0) {
                a3 = l.a(0L);
            }
            j3 = b;
        } else {
            j3 = 0;
        }
        k.b("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + a3 + ", cleaned = " + (a3 - a2), null);
        a(a2, a3, j2, currentTimeMillis2, j3);
        if (a3 < j2) {
            return false;
        }
        if (qVar != null) {
            qVar.a();
            return true;
        }
        return true;
    }
}
