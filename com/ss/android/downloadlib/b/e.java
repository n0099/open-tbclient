package com.ss.android.downloadlib.b;

import com.ss.android.socialbase.downloader.a.a;
/* loaded from: classes10.dex */
public class e implements a.InterfaceC0741a {
    public long a;

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0741a
    public void c() {
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static e a = new e();
    }

    public e() {
        this.a = 0L;
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static e a() {
        return a.a;
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0741a
    public void b() {
        this.a = System.currentTimeMillis();
    }

    public void b(d dVar) {
        if (dVar == null) {
            return;
        }
        int i = 1200;
        int optInt = com.ss.android.downloadlib.addownload.j.i().optInt("check_an_result_delay", 1200);
        if (optInt > 0) {
            i = optInt;
        }
        a(dVar, i);
    }

    public void a(d dVar) {
        a(dVar, 5000L);
    }

    public void a(final d dVar, final long j) {
        if (dVar == null) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.ss.android.socialbase.downloader.a.a.a().c() && System.currentTimeMillis() - e.this.a > j) {
                    dVar.a(false);
                } else {
                    dVar.a(true);
                }
            }
        }, j);
    }
}
