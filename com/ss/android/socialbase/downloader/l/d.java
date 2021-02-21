package com.ss.android.socialbase.downloader.l;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private int f13219b = 0;

    /* renamed from: a  reason: collision with root package name */
    private volatile SparseArray<c> f13218a = new SparseArray<>();

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            if (this.f13219b >= 500) {
                b();
                this.f13219b = 0;
            } else {
                this.f13219b++;
            }
            this.f13218a.put(cVar.e(), cVar);
        }
        com.ss.android.socialbase.downloader.g.d eIG = cVar.eIG();
        try {
            ExecutorService eGn = com.ss.android.socialbase.downloader.downloader.b.eGn();
            if (eIG != null && eIG.a() != null) {
                if ("mime_type_plugin".equals(eIG.a().eHn()) && com.ss.android.socialbase.downloader.k.a.eIF().a("divide_plugin", 1) == 1) {
                    eIG.a().o(3);
                }
                switch (eIG.a().eIg()) {
                    case 3:
                        eGn = com.ss.android.socialbase.downloader.downloader.b.eGl();
                        break;
                    case 4:
                        eGn = com.ss.android.socialbase.downloader.downloader.b.eGm();
                        break;
                }
            }
            if (eGn != null) {
                if (com.ss.android.socialbase.downloader.k.a.RW(cVar.e()).b("pause_with_interrupt", false)) {
                    cVar.a(eGn.submit(cVar));
                    return;
                } else {
                    eGn.execute(cVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.h.a.a(eIG.eIk(), eIG.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute failed cpu thread executor service is null"), eIG.a() != null ? eIG.a().q() : 0);
        } catch (Exception e) {
            if (eIG != null) {
                com.ss.android.socialbase.downloader.h.a.a(eIG.eIk(), eIG.a(), new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(e, "DownloadThreadPoolExecute")), eIG.a() != null ? eIG.a().q() : 0);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (eIG != null) {
                com.ss.android.socialbase.downloader.h.a.a(eIG.eIk(), eIG.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute OOM"), eIG.a() != null ? eIG.a().q() : 0);
            }
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f13218a.size(); i++) {
                int keyAt = this.f13218a.keyAt(i);
                if (!this.f13218a.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.f13218a.remove(num.intValue());
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
                    int indexOfValue = this.f13218a.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f13218a.removeAt(indexOfValue);
                    }
                } else {
                    this.f13218a.remove(cVar.e());
                }
            }
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            if (this.f13218a == null || this.f13218a.size() <= 0) {
                return false;
            }
            c cVar = this.f13218a.get(i);
            return cVar != null && cVar.d();
        }
    }

    public c RZ(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f13218a.get(i);
            if (cVar != null) {
                cVar.b();
                c(cVar);
                this.f13218a.remove(i);
                return cVar;
            }
            return null;
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f13218a.get(i);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.f13218a.remove(i);
            }
        }
    }

    private void c(c cVar) {
        Future eIH;
        if (cVar != null) {
            try {
                ExecutorService eGn = com.ss.android.socialbase.downloader.downloader.b.eGn();
                com.ss.android.socialbase.downloader.g.d eIG = cVar.eIG();
                if (eIG != null && eIG.a() != null) {
                    switch (eIG.a().eIg()) {
                        case 3:
                            eGn = com.ss.android.socialbase.downloader.downloader.b.eGl();
                            break;
                        case 4:
                            eGn = com.ss.android.socialbase.downloader.downloader.b.eGm();
                            break;
                    }
                }
                if (eGn != null && (eGn instanceof ThreadPoolExecutor)) {
                    ((ThreadPoolExecutor) eGn).remove(cVar);
                    if (com.ss.android.socialbase.downloader.k.a.RW(cVar.e()).b("pause_with_interrupt", false) && (eIH = cVar.eIH()) != null) {
                        eIH.cancel(true);
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
            for (int i = 0; i < this.f13218a.size(); i++) {
                c cVar = this.f13218a.get(this.f13218a.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        c cVar = this.f13218a.get(i);
        if (cVar != null) {
            cVar.b(j);
        }
    }
}
