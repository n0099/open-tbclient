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
    private int f13516b = 0;

    /* renamed from: a  reason: collision with root package name */
    private volatile SparseArray<c> f13515a = new SparseArray<>();

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            if (this.f13516b >= 500) {
                b();
                this.f13516b = 0;
            } else {
                this.f13516b++;
            }
            this.f13515a.put(cVar.e(), cVar);
        }
        com.ss.android.socialbase.downloader.g.d eJt = cVar.eJt();
        try {
            ExecutorService eHa = com.ss.android.socialbase.downloader.downloader.b.eHa();
            if (eJt != null && eJt.a() != null) {
                if ("mime_type_plugin".equals(eJt.a().eIa()) && com.ss.android.socialbase.downloader.k.a.eJs().a("divide_plugin", 1) == 1) {
                    eJt.a().o(3);
                }
                switch (eJt.a().eIT()) {
                    case 3:
                        eHa = com.ss.android.socialbase.downloader.downloader.b.eGY();
                        break;
                    case 4:
                        eHa = com.ss.android.socialbase.downloader.downloader.b.eGZ();
                        break;
                }
            }
            if (eHa != null) {
                if (com.ss.android.socialbase.downloader.k.a.SR(cVar.e()).b("pause_with_interrupt", false)) {
                    cVar.a(eHa.submit(cVar));
                    return;
                } else {
                    eHa.execute(cVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.h.a.a(eJt.eIX(), eJt.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute failed cpu thread executor service is null"), eJt.a() != null ? eJt.a().q() : 0);
        } catch (Exception e) {
            if (eJt != null) {
                com.ss.android.socialbase.downloader.h.a.a(eJt.eIX(), eJt.a(), new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(e, "DownloadThreadPoolExecute")), eJt.a() != null ? eJt.a().q() : 0);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (eJt != null) {
                com.ss.android.socialbase.downloader.h.a.a(eJt.eIX(), eJt.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute OOM"), eJt.a() != null ? eJt.a().q() : 0);
            }
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f13515a.size(); i++) {
                int keyAt = this.f13515a.keyAt(i);
                if (!this.f13515a.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.f13515a.remove(num.intValue());
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
                    int indexOfValue = this.f13515a.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f13515a.removeAt(indexOfValue);
                    }
                } else {
                    this.f13515a.remove(cVar.e());
                }
            }
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            if (this.f13515a == null || this.f13515a.size() <= 0) {
                return false;
            }
            c cVar = this.f13515a.get(i);
            return cVar != null && cVar.d();
        }
    }

    public c SU(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f13515a.get(i);
            if (cVar != null) {
                cVar.b();
                c(cVar);
                this.f13515a.remove(i);
                return cVar;
            }
            return null;
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f13515a.get(i);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.f13515a.remove(i);
            }
        }
    }

    private void c(c cVar) {
        Future eJu;
        if (cVar != null) {
            try {
                ExecutorService eHa = com.ss.android.socialbase.downloader.downloader.b.eHa();
                com.ss.android.socialbase.downloader.g.d eJt = cVar.eJt();
                if (eJt != null && eJt.a() != null) {
                    switch (eJt.a().eIT()) {
                        case 3:
                            eHa = com.ss.android.socialbase.downloader.downloader.b.eGY();
                            break;
                        case 4:
                            eHa = com.ss.android.socialbase.downloader.downloader.b.eGZ();
                            break;
                    }
                }
                if (eHa != null && (eHa instanceof ThreadPoolExecutor)) {
                    ((ThreadPoolExecutor) eHa).remove(cVar);
                    if (com.ss.android.socialbase.downloader.k.a.SR(cVar.e()).b("pause_with_interrupt", false) && (eJu = cVar.eJu()) != null) {
                        eJu.cancel(true);
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
            for (int i = 0; i < this.f13515a.size(); i++) {
                c cVar = this.f13515a.get(this.f13515a.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        c cVar = this.f13515a.get(i);
        if (cVar != null) {
            cVar.b(j);
        }
    }
}
