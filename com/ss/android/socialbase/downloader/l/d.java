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
    private int f13517b = 0;

    /* renamed from: a  reason: collision with root package name */
    private volatile SparseArray<c> f13516a = new SparseArray<>();

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            if (this.f13517b >= 500) {
                b();
                this.f13517b = 0;
            } else {
                this.f13517b++;
            }
            this.f13516a.put(cVar.e(), cVar);
        }
        com.ss.android.socialbase.downloader.g.d eJX = cVar.eJX();
        try {
            ExecutorService eHE = com.ss.android.socialbase.downloader.downloader.b.eHE();
            if (eJX != null && eJX.a() != null) {
                if ("mime_type_plugin".equals(eJX.a().eIE()) && com.ss.android.socialbase.downloader.k.a.eJW().a("divide_plugin", 1) == 1) {
                    eJX.a().o(3);
                }
                switch (eJX.a().eJx()) {
                    case 3:
                        eHE = com.ss.android.socialbase.downloader.downloader.b.eHC();
                        break;
                    case 4:
                        eHE = com.ss.android.socialbase.downloader.downloader.b.eHD();
                        break;
                }
            }
            if (eHE != null) {
                if (com.ss.android.socialbase.downloader.k.a.Th(cVar.e()).b("pause_with_interrupt", false)) {
                    cVar.a(eHE.submit(cVar));
                    return;
                } else {
                    eHE.execute(cVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.h.a.a(eJX.eJB(), eJX.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute failed cpu thread executor service is null"), eJX.a() != null ? eJX.a().q() : 0);
        } catch (Exception e) {
            if (eJX != null) {
                com.ss.android.socialbase.downloader.h.a.a(eJX.eJB(), eJX.a(), new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(e, "DownloadThreadPoolExecute")), eJX.a() != null ? eJX.a().q() : 0);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (eJX != null) {
                com.ss.android.socialbase.downloader.h.a.a(eJX.eJB(), eJX.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute OOM"), eJX.a() != null ? eJX.a().q() : 0);
            }
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f13516a.size(); i++) {
                int keyAt = this.f13516a.keyAt(i);
                if (!this.f13516a.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.f13516a.remove(num.intValue());
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
                    int indexOfValue = this.f13516a.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f13516a.removeAt(indexOfValue);
                    }
                } else {
                    this.f13516a.remove(cVar.e());
                }
            }
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            if (this.f13516a == null || this.f13516a.size() <= 0) {
                return false;
            }
            c cVar = this.f13516a.get(i);
            return cVar != null && cVar.d();
        }
    }

    public c Tk(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f13516a.get(i);
            if (cVar != null) {
                cVar.b();
                c(cVar);
                this.f13516a.remove(i);
                return cVar;
            }
            return null;
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f13516a.get(i);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.f13516a.remove(i);
            }
        }
    }

    private void c(c cVar) {
        Future eJY;
        if (cVar != null) {
            try {
                ExecutorService eHE = com.ss.android.socialbase.downloader.downloader.b.eHE();
                com.ss.android.socialbase.downloader.g.d eJX = cVar.eJX();
                if (eJX != null && eJX.a() != null) {
                    switch (eJX.a().eJx()) {
                        case 3:
                            eHE = com.ss.android.socialbase.downloader.downloader.b.eHC();
                            break;
                        case 4:
                            eHE = com.ss.android.socialbase.downloader.downloader.b.eHD();
                            break;
                    }
                }
                if (eHE != null && (eHE instanceof ThreadPoolExecutor)) {
                    ((ThreadPoolExecutor) eHE).remove(cVar);
                    if (com.ss.android.socialbase.downloader.k.a.Th(cVar.e()).b("pause_with_interrupt", false) && (eJY = cVar.eJY()) != null) {
                        eJY.cancel(true);
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
            for (int i = 0; i < this.f13516a.size(); i++) {
                c cVar = this.f13516a.get(this.f13516a.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        c cVar = this.f13516a.get(i);
        if (cVar != null) {
            cVar.b(j);
        }
    }
}
