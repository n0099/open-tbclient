package com.ss.android.downloadlib.b;

import com.ss.android.socialbase.downloader.a.a;
/* loaded from: classes7.dex */
public class e implements a.InterfaceC0597a {
    public long a;

    /* loaded from: classes7.dex */
    public static class a {
        public static e a = new e();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0597a
    public void b() {
        this.a = System.currentTimeMillis();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0597a
    public void c() {
    }

    public e() {
        this.a = 0L;
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static e a() {
        return a.a;
    }

    public void b(d dVar) {
        if (dVar == null) {
            return;
        }
        int optInt = com.ss.android.downloadlib.addownload.j.i().optInt("check_an_result_delay", 1200);
        a(dVar, optInt > 0 ? optInt : 1200);
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

    public void a(d dVar) {
        a(dVar, 5000L);
    }
}
