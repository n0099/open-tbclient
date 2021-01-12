package com.ss.android.socialbase.downloader.l;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private int f13217b = 0;

    /* renamed from: a  reason: collision with root package name */
    private volatile SparseArray<c> f13216a = new SparseArray<>();

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            if (this.f13217b >= 500) {
                b();
                this.f13217b = 0;
            } else {
                this.f13217b++;
            }
            this.f13216a.put(cVar.e(), cVar);
        }
        com.ss.android.socialbase.downloader.g.d eGh = cVar.eGh();
        try {
            ExecutorService eDO = com.ss.android.socialbase.downloader.downloader.b.eDO();
            if (eGh != null && eGh.a() != null) {
                if ("mime_type_plugin".equals(eGh.a().eEO()) && com.ss.android.socialbase.downloader.k.a.eGg().a("divide_plugin", 1) == 1) {
                    eGh.a().o(3);
                }
                switch (eGh.a().eFH()) {
                    case 3:
                        eDO = com.ss.android.socialbase.downloader.downloader.b.eDM();
                        break;
                    case 4:
                        eDO = com.ss.android.socialbase.downloader.downloader.b.eDN();
                        break;
                }
            }
            if (eDO != null) {
                if (com.ss.android.socialbase.downloader.k.a.RA(cVar.e()).b("pause_with_interrupt", false)) {
                    cVar.a(eDO.submit(cVar));
                    return;
                } else {
                    eDO.execute(cVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.h.a.a(eGh.eFL(), eGh.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute failed cpu thread executor service is null"), eGh.a() != null ? eGh.a().q() : 0);
        } catch (Exception e) {
            if (eGh != null) {
                com.ss.android.socialbase.downloader.h.a.a(eGh.eFL(), eGh.a(), new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(e, "DownloadThreadPoolExecute")), eGh.a() != null ? eGh.a().q() : 0);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (eGh != null) {
                com.ss.android.socialbase.downloader.h.a.a(eGh.eFL(), eGh.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute OOM"), eGh.a() != null ? eGh.a().q() : 0);
            }
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f13216a.size(); i++) {
                int keyAt = this.f13216a.keyAt(i);
                if (!this.f13216a.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.f13216a.remove(num.intValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(c cVar) {
        if (cVar != null) {
            synchronized (d.class) {
                if (com.ss.android.socialbase.downloader.m.a.a(524288)) {
                    int indexOfValue = this.f13216a.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f13216a.removeAt(indexOfValue);
                    }
                } else {
                    this.f13216a.remove(cVar.e());
                }
            }
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            if (this.f13216a == null || this.f13216a.size() <= 0) {
                return false;
            }
            c cVar = this.f13216a.get(i);
            return cVar != null && cVar.d();
        }
    }

    public c RD(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f13216a.get(i);
            if (cVar != null) {
                cVar.b();
                c(cVar);
                this.f13216a.remove(i);
                return cVar;
            }
            return null;
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f13216a.get(i);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.f13216a.remove(i);
            }
        }
    }

    private void c(c cVar) {
        Future eGi;
        if (cVar != null) {
            try {
                ExecutorService eDO = com.ss.android.socialbase.downloader.downloader.b.eDO();
                com.ss.android.socialbase.downloader.g.d eGh = cVar.eGh();
                if (eGh != null && eGh.a() != null) {
                    switch (eGh.a().eFH()) {
                        case 3:
                            eDO = com.ss.android.socialbase.downloader.downloader.b.eDM();
                            break;
                        case 4:
                            eDO = com.ss.android.socialbase.downloader.downloader.b.eDN();
                            break;
                    }
                }
                if (eDO != null && (eDO instanceof ThreadPoolExecutor)) {
                    ((ThreadPoolExecutor) eDO).remove(cVar);
                    if (com.ss.android.socialbase.downloader.k.a.RA(cVar.e()).b("pause_with_interrupt", false) && (eGi = cVar.eGi()) != null) {
                        eGi.cancel(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            b();
            arrayList = new ArrayList();
            for (int i = 0; i < this.f13216a.size(); i++) {
                c cVar = this.f13216a.get(this.f13216a.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        c cVar = this.f13216a.get(i);
        if (cVar != null) {
            cVar.b(j);
        }
    }
}
