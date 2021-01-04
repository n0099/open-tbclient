package com.ss.android.downloadlib.a.c;

import android.os.Environment;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.h;
import com.ss.android.socialbase.downloader.d.ae;
import com.ss.android.socialbase.downloader.d.af;
import com.ss.android.socialbase.downloader.downloader.f;
import java.io.File;
/* loaded from: classes4.dex */
public class a implements af {

    /* renamed from: a  reason: collision with root package name */
    private int f13243a;

    public void a(int i) {
        this.f13243a = i;
    }

    @Override // com.ss.android.socialbase.downloader.d.af
    public boolean a(long j, long j2, ae aeVar) {
        com.ss.android.socialbase.downloader.k.a SR = com.ss.android.socialbase.downloader.k.a.SR(this.f13243a);
        if (!a(SR)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        d.eFu().c();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        long a2 = a(externalStorageDirectory.toString());
        a();
        long a3 = a(externalStorageDirectory.toString());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long j3 = 0;
        if (a3 < j2) {
            j3 = b(SR);
            if (j3 > 0) {
                a3 = a(externalStorageDirectory.toString());
            }
        }
        h.j("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + a3 + ", cleaned = " + (a3 - a2), null);
        a(a2, a3, j2, currentTimeMillis2, j3);
        if (a3 < j2) {
            return false;
        }
        if (aeVar != null) {
            aeVar.a();
        }
        return true;
    }

    private boolean a(com.ss.android.socialbase.downloader.k.a aVar) {
        if (aVar.a("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - d.eFu().b() >= aVar.a("clear_space_min_time_interval", 600000L);
    }

    private void a() {
        com.ss.android.a.a.a.e eFM = j.eFM();
        if (eFM != null) {
            eFM.a();
        }
        c.a();
        c.b();
    }

    private long b(com.ss.android.socialbase.downloader.k.a aVar) {
        long a2 = aVar.a("clear_space_sleep_time", 0L);
        if (a2 <= 0) {
            return 0L;
        }
        long j = a2 <= 5000 ? a2 : 5000L;
        h.j("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + j, null);
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.j("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return j;
    }

    private void a(long j, long j2, long j3, long j4, long j5) {
        com.ss.android.socialbase.downloader.g.c h = f.iA(j.a()).h(this.f13243a);
        if (h != null) {
            boolean z = false;
            if (j2 > j3) {
                z = true;
            }
            try {
                com.ss.android.downloadlib.b.eFk().a(h, j, j2, j3, j4, j5, z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private long a(String str) {
        try {
            return com.ss.android.socialbase.downloader.m.d.c(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
