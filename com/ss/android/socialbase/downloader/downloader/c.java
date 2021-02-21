package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private static volatile c qfJ = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile SparseArray<Boolean> f13135b = new SparseArray<>();
    private Handler c = new Handler(Looper.getMainLooper());
    private volatile List<com.ss.android.socialbase.downloader.d.n> d = new ArrayList();

    public static c eGG() {
        if (qfJ == null) {
            synchronized (c.class) {
                qfJ = new c();
            }
        }
        return qfJ;
    }

    public void b() {
        synchronized (this.d) {
            for (com.ss.android.socialbase.downloader.d.n nVar : this.d) {
                if (nVar != null) {
                    nVar.a();
                }
            }
        }
    }

    public void a(int i, boolean z) {
        b(i, z);
        if (!com.ss.android.socialbase.downloader.m.d.c() && com.ss.android.socialbase.downloader.impls.l.CO(true).g()) {
            com.ss.android.socialbase.downloader.impls.l.CO(true).c(i, z);
        }
        if (!b.b() && !com.ss.android.socialbase.downloader.m.d.c() && !com.ss.android.socialbase.downloader.m.d.a()) {
            try {
                Intent intent = new Intent(b.eGC(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
                intent.putExtra("extra_download_id", i);
                b.eGC().startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void b(int i, boolean z) {
        this.f13135b.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public int a(int i) {
        return (com.ss.android.socialbase.downloader.m.d.c() || !com.ss.android.socialbase.downloader.impls.l.CO(true).g()) ? b(i) : com.ss.android.socialbase.downloader.impls.l.CO(true).m(i);
    }

    public synchronized int b(int i) {
        int i2;
        if (this.f13135b.get(i) == null) {
            i2 = -1;
        } else {
            i2 = this.f13135b.get(i).booleanValue() ? 1 : 0;
        }
        return i2;
    }

    public n Ro(int i) {
        boolean z = true;
        return com.ss.android.socialbase.downloader.impls.l.CO((a(i) != 1 || com.ss.android.socialbase.downloader.m.d.c()) ? false : false);
    }

    private n d(com.ss.android.socialbase.downloader.g.d dVar) {
        com.ss.android.socialbase.downloader.g.c a2;
        List<com.ss.android.socialbase.downloader.g.b> i;
        if (dVar == null || (a2 = dVar.a()) == null) {
            return null;
        }
        int i2 = a2.ae() ? 1 : 0;
        if (com.ss.android.socialbase.downloader.m.d.c() || !com.ss.android.socialbase.downloader.m.d.a()) {
            i2 = 1;
        }
        int a3 = a(a2.g());
        if (a3 >= 0 && a3 != i2) {
            try {
                if (a3 == 1) {
                    if (com.ss.android.socialbase.downloader.m.d.a()) {
                        com.ss.android.socialbase.downloader.impls.l.CO(true).a(a2.g());
                        com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.impls.l.CO(true).h(a2.g());
                        if (h != null) {
                            com.ss.android.socialbase.downloader.impls.l.CO(false).b(h);
                        }
                        if (h.eHU() > 1 && (i = com.ss.android.socialbase.downloader.impls.l.CO(true).i(a2.g())) != null) {
                            com.ss.android.socialbase.downloader.impls.l.CO(false).a(a2.g(), com.ss.android.socialbase.downloader.m.d.a(i));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.m.d.a()) {
                    com.ss.android.socialbase.downloader.impls.l.CO(false).a(a2.g());
                    List<com.ss.android.socialbase.downloader.g.b> i3 = com.ss.android.socialbase.downloader.impls.l.CO(false).i(a2.g());
                    if (i3 != null) {
                        com.ss.android.socialbase.downloader.impls.l.CO(true).a(a2.g(), com.ss.android.socialbase.downloader.m.d.a(i3));
                    }
                } else {
                    dVar.a(true);
                    com.ss.android.socialbase.downloader.impls.l.CO(true).a(1, a2.g());
                }
            } catch (Throwable th) {
            }
        }
        a(a2.g(), i2 == 1);
        return com.ss.android.socialbase.downloader.impls.l.CO(i2 == 1);
    }

    public void d(int i) {
        n Ro = Ro(i);
        if (Ro != null) {
            Ro.a(i);
        }
    }

    public void c(int i, boolean z) {
        if (com.ss.android.socialbase.downloader.m.d.a()) {
            if (com.ss.android.socialbase.downloader.m.a.a(8388608)) {
                n CO = com.ss.android.socialbase.downloader.impls.l.CO(true);
                if (CO != null) {
                    CO.a(i, z);
                }
                n CO2 = com.ss.android.socialbase.downloader.impls.l.CO(false);
                if (CO2 != null) {
                    CO2.a(i, z);
                    return;
                }
                return;
            }
            n CO3 = com.ss.android.socialbase.downloader.impls.l.CO(false);
            if (CO3 != null) {
                CO3.a(i, z);
            }
            n CO4 = com.ss.android.socialbase.downloader.impls.l.CO(true);
            if (CO4 != null) {
                CO4.a(i, z);
                return;
            }
            return;
        }
        n Ro = Ro(i);
        if (Ro != null) {
            Ro.a(i, z);
        }
        com.ss.android.socialbase.downloader.impls.l.CO(true).a(2, i);
    }

    public boolean e(int i) {
        n Ro = Ro(i);
        if (Ro == null) {
            return false;
        }
        return Ro.b(i);
    }

    public void f(int i) {
        n Ro = Ro(i);
        if (Ro != null) {
            Ro.c(i);
        }
    }

    public void g(int i) {
        n Ro = Ro(i);
        if (Ro != null) {
            Ro.d(i);
        }
    }

    public void c() {
        n CO = com.ss.android.socialbase.downloader.impls.l.CO(false);
        if (CO != null) {
            CO.a();
        }
        n CO2 = com.ss.android.socialbase.downloader.impls.l.CO(true);
        if (CO2 != null) {
            CO2.a();
        }
    }

    public int h(int i) {
        n Ro = Ro(i);
        if (Ro == null) {
            return 0;
        }
        return Ro.f(i);
    }

    public boolean i(int i) {
        n Ro = Ro(i);
        if (Ro == null) {
            return false;
        }
        return Ro.g(i);
    }

    public com.ss.android.socialbase.downloader.g.c j(int i) {
        n Ro = Ro(i);
        if (Ro == null) {
            return null;
        }
        return Ro.h(i);
    }

    public int a(String str, String str2) {
        return b.a(str, str2);
    }

    public com.ss.android.socialbase.downloader.g.c b(String str, String str2) {
        int a2 = a(str, str2);
        n Ro = Ro(a2);
        if (Ro == null) {
            return null;
        }
        return Ro.h(a2);
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        List<com.ss.android.socialbase.downloader.g.c> a2 = com.ss.android.socialbase.downloader.impls.l.CO(false).a(str);
        List<com.ss.android.socialbase.downloader.g.c> a3 = com.ss.android.socialbase.downloader.impls.l.CO(true).a(str);
        if (a2 == null && a3 == null) {
            return null;
        }
        if (a2 == null || a3 == null) {
            return a2 == null ? a3 : a2;
        }
        ArrayList arrayList = new ArrayList(a2);
        arrayList.addAll(a3);
        return arrayList;
    }

    public com.ss.android.socialbase.downloader.d.d Rp(int i) {
        n Ro = Ro(i);
        if (Ro == null) {
            return null;
        }
        return Ro.Rx(i);
    }

    public com.ss.android.socialbase.downloader.d.r Rq(int i) {
        n Ro = Ro(i);
        if (Ro == null) {
            return null;
        }
        return Ro.Ry(i);
    }

    private List<com.ss.android.socialbase.downloader.g.c> a(List<com.ss.android.socialbase.downloader.g.c> list, List<com.ss.android.socialbase.downloader.g.c> list2, SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.ss.android.socialbase.downloader.g.c cVar : list) {
                if (cVar != null && sparseArray.get(cVar.g()) == null) {
                    sparseArray.put(cVar.g(), cVar);
                }
            }
        }
        if (list2 != null) {
            for (com.ss.android.socialbase.downloader.g.c cVar2 : list2) {
                if (cVar2 != null && sparseArray.get(cVar2.g()) == null) {
                    sparseArray.put(cVar2.g(), cVar2);
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray.size()) {
                arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray = new SparseArray<>();
        n CO = com.ss.android.socialbase.downloader.impls.l.CO(false);
        List<com.ss.android.socialbase.downloader.g.c> c = CO != null ? CO.c(str) : null;
        n CO2 = com.ss.android.socialbase.downloader.impls.l.CO(true);
        return a(c, CO2 != null ? CO2.c(str) : null, sparseArray);
    }

    public void a(List<String> list) {
        n CO = com.ss.android.socialbase.downloader.impls.l.CO(false);
        if (CO != null) {
            CO.a(list);
        }
        n CO2 = com.ss.android.socialbase.downloader.impls.l.CO(true);
        if (CO2 != null) {
            CO2.a(list);
        }
    }

    public void b(List<String> list) {
        n CO = com.ss.android.socialbase.downloader.impls.l.CO(false);
        if (CO != null) {
            CO.b(list);
        }
        n CO2 = com.ss.android.socialbase.downloader.impls.l.CO(true);
        if (CO2 != null) {
            CO2.b(list);
        }
    }

    public void d(int i, boolean z) {
        n Ro = Ro(i);
        if (Ro != null) {
            Ro.b(i, z);
        }
    }

    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        n Ro = Ro(i);
        if (Ro != null) {
            Ro.b(i, bVar == null ? 0 : bVar.hashCode(), bVar, hVar, z);
        }
    }

    public void b(int i, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        n Ro = Ro(i);
        if (Ro != null) {
            Ro.a(i, bVar.hashCode(), bVar, hVar, z);
        }
    }

    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        n Ro = Ro(i);
        if (Ro != null) {
            Ro.a(i, bVar.hashCode(), bVar, hVar, z, z2);
        }
    }

    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        n Ro;
        if (cVar == null || (Ro = Ro(cVar.g())) == null) {
            return false;
        }
        return Ro.a(cVar);
    }

    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray = new SparseArray<>();
        n CO = com.ss.android.socialbase.downloader.impls.l.CO(false);
        List<com.ss.android.socialbase.downloader.g.c> d = CO != null ? CO.d(str) : null;
        n CO2 = com.ss.android.socialbase.downloader.impls.l.CO(true);
        return a(d, CO2 != null ? CO2.d(str) : null, sparseArray);
    }

    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray = new SparseArray<>();
        n CO = com.ss.android.socialbase.downloader.impls.l.CO(false);
        List<com.ss.android.socialbase.downloader.g.c> e = CO != null ? CO.e(str) : null;
        n CO2 = com.ss.android.socialbase.downloader.impls.l.CO(true);
        return a(e, CO2 != null ? CO2.e(str) : null, sparseArray);
    }

    public void a(final com.ss.android.socialbase.downloader.g.d dVar) {
        final n d = d(dVar);
        if (d == null) {
            if (dVar != null) {
                com.ss.android.socialbase.downloader.h.a.a(dVar.eIk(), dVar.a(), new com.ss.android.socialbase.downloader.e.a(1003, "tryDownload but getDownloadHandler failed"), dVar.a() != null ? dVar.a().q() : 0);
            }
        } else if (dVar.b()) {
            this.c.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
                @Override // java.lang.Runnable
                public void run() {
                    d.a(dVar);
                }
            }, 500L);
        } else {
            d.a(dVar);
        }
    }

    public boolean Rr(int i) {
        n Ro = Ro(i);
        if (Ro == null) {
            return false;
        }
        return Ro.Rw(i);
    }

    public void n(int i) {
        if (i != 0) {
            b(i, Boolean.TRUE.booleanValue());
            n CO = com.ss.android.socialbase.downloader.impls.l.CO(true);
            if (CO != null) {
                CO.d();
            }
        }
    }

    public ah Rs(int i) {
        n Ro = Ro(i);
        if (Ro == null) {
            return null;
        }
        return Ro.Rz(i);
    }
}
