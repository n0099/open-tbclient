package com.ss.android.socialbase.downloader.l;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class d {
    private int b = 0;

    /* renamed from: a  reason: collision with root package name */
    private volatile SparseArray<c> f7872a = new SparseArray<>();

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            if (this.b >= 500) {
                b();
                this.b = 0;
            } else {
                this.b++;
            }
            this.f7872a.put(cVar.e(), cVar);
        }
        com.ss.android.socialbase.downloader.g.d eII = cVar.eII();
        try {
            ExecutorService eGr = com.ss.android.socialbase.downloader.downloader.b.eGr();
            if (eII != null && eII.a() != null) {
                if ("mime_type_plugin".equals(eII.a().at()) && com.ss.android.socialbase.downloader.k.a.eIH().a("divide_plugin", 1) == 1) {
                    eII.a().o(3);
                }
                switch (eII.a().eIi()) {
                    case 3:
                        eGr = com.ss.android.socialbase.downloader.downloader.b.eGp();
                        break;
                    case 4:
                        eGr = com.ss.android.socialbase.downloader.downloader.b.eGq();
                        break;
                }
            }
            if (eGr != null) {
                if (com.ss.android.socialbase.downloader.k.a.Sa(cVar.e()).b("pause_with_interrupt", false)) {
                    cVar.a(eGr.submit(cVar));
                    return;
                } else {
                    eGr.execute(cVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.h.a.a(eII.eIm(), eII.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute failed cpu thread executor service is null"), eII.a() != null ? eII.a().q() : 0);
        } catch (Exception e) {
            if (eII != null) {
                com.ss.android.socialbase.downloader.h.a.a(eII.eIm(), eII.a(), new com.ss.android.socialbase.downloader.e.a(1003, com.ss.android.socialbase.downloader.m.d.c(e, "DownloadThreadPoolExecute")), eII.a() != null ? eII.a().q() : 0);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (eII != null) {
                com.ss.android.socialbase.downloader.h.a.a(eII.eIm(), eII.a(), new com.ss.android.socialbase.downloader.e.a(1003, "execute OOM"), eII.a() != null ? eII.a().q() : 0);
            }
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f7872a.size(); i++) {
                int keyAt = this.f7872a.keyAt(i);
                if (!this.f7872a.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.f7872a.remove(num.intValue());
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
                    int indexOfValue = this.f7872a.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f7872a.removeAt(indexOfValue);
                    }
                } else {
                    this.f7872a.remove(cVar.e());
                }
            }
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            if (this.f7872a == null || this.f7872a.size() <= 0) {
                return false;
            }
            c cVar = this.f7872a.get(i);
            return cVar != null && cVar.d();
        }
    }

    public c Sd(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f7872a.get(i);
            if (cVar != null) {
                cVar.b();
                c(cVar);
                this.f7872a.remove(i);
                return cVar;
            }
            return null;
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.f7872a.get(i);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.f7872a.remove(i);
            }
        }
    }

    private void c(c cVar) {
        Future eIJ;
        if (cVar != null) {
            try {
                ExecutorService eGr = com.ss.android.socialbase.downloader.downloader.b.eGr();
                com.ss.android.socialbase.downloader.g.d eII = cVar.eII();
                if (eII != null && eII.a() != null) {
                    switch (eII.a().eIi()) {
                        case 3:
                            eGr = com.ss.android.socialbase.downloader.downloader.b.eGp();
                            break;
                        case 4:
                            eGr = com.ss.android.socialbase.downloader.downloader.b.eGq();
                            break;
                    }
                }
                if (eGr != null && (eGr instanceof ThreadPoolExecutor)) {
                    ((ThreadPoolExecutor) eGr).remove(cVar);
                    if (com.ss.android.socialbase.downloader.k.a.Sa(cVar.e()).b("pause_with_interrupt", false) && (eIJ = cVar.eIJ()) != null) {
                        eIJ.cancel(true);
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
            for (int i = 0; i < this.f7872a.size(); i++) {
                c cVar = this.f7872a.get(this.f7872a.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        c cVar = this.f7872a.get(i);
        if (cVar != null) {
            cVar.b(j);
        }
    }
}
