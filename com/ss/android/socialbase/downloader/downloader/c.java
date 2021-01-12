package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static volatile c pVe = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile SparseArray<Boolean> f13133b = new SparseArray<>();
    private Handler c = new Handler(Looper.getMainLooper());
    private volatile List<com.ss.android.socialbase.downloader.d.n> d = new ArrayList();

    public static c eEh() {
        if (pVe == null) {
            synchronized (c.class) {
                pVe = new c();
            }
        }
        return pVe;
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
        if (!com.ss.android.socialbase.downloader.m.d.c() && com.ss.android.socialbase.downloader.impls.l.Cu(true).g()) {
            com.ss.android.socialbase.downloader.impls.l.Cu(true).c(i, z);
        }
        if (!b.b() && !com.ss.android.socialbase.downloader.m.d.c() && !com.ss.android.socialbase.downloader.m.d.a()) {
            try {
                Intent intent = new Intent(b.eEd(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
                intent.putExtra("extra_download_id", i);
                b.eEd().startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void b(int i, boolean z) {
        this.f13133b.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public int a(int i) {
        return (com.ss.android.socialbase.downloader.m.d.c() || !com.ss.android.socialbase.downloader.impls.l.Cu(true).g()) ? b(i) : com.ss.android.socialbase.downloader.impls.l.Cu(true).m(i);
    }

    public synchronized int b(int i) {
        int i2;
        if (this.f13133b.get(i) == null) {
            i2 = -1;
        } else {
            i2 = this.f13133b.get(i).booleanValue() ? 1 : 0;
        }
        return i2;
    }

    public n QS(int i) {
        boolean z = true;
        return com.ss.android.socialbase.downloader.impls.l.Cu((a(i) != 1 || com.ss.android.socialbase.downloader.m.d.c()) ? false : false);
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
                        com.ss.android.socialbase.downloader.impls.l.Cu(true).a(a2.g());
                        com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.impls.l.Cu(true).h(a2.g());
                        if (h != null) {
                            com.ss.android.socialbase.downloader.impls.l.Cu(false).b(h);
                        }
                        if (h.eFv() > 1 && (i = com.ss.android.socialbase.downloader.impls.l.Cu(true).i(a2.g())) != null) {
                            com.ss.android.socialbase.downloader.impls.l.Cu(false).a(a2.g(), com.ss.android.socialbase.downloader.m.d.a(i));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.m.d.a()) {
                    com.ss.android.socialbase.downloader.impls.l.Cu(false).a(a2.g());
                    List<com.ss.android.socialbase.downloader.g.b> i3 = com.ss.android.socialbase.downloader.impls.l.Cu(false).i(a2.g());
                    if (i3 != null) {
                        com.ss.android.socialbase.downloader.impls.l.Cu(true).a(a2.g(), com.ss.android.socialbase.downloader.m.d.a(i3));
                    }
                } else {
                    dVar.a(true);
                    com.ss.android.socialbase.downloader.impls.l.Cu(true).a(1, a2.g());
                }
            } catch (Throwable th) {
            }
        }
        a(a2.g(), i2 == 1);
        return com.ss.android.socialbase.downloader.impls.l.Cu(i2 == 1);
    }

    public void d(int i) {
        n QS = QS(i);
        if (QS != null) {
            QS.a(i);
        }
    }

    public void c(int i, boolean z) {
        if (com.ss.android.socialbase.downloader.m.d.a()) {
            if (com.ss.android.socialbase.downloader.m.a.a(8388608)) {
                n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(true);
                if (Cu != null) {
                    Cu.a(i, z);
                }
                n Cu2 = com.ss.android.socialbase.downloader.impls.l.Cu(false);
                if (Cu2 != null) {
                    Cu2.a(i, z);
                    return;
                }
                return;
            }
            n Cu3 = com.ss.android.socialbase.downloader.impls.l.Cu(false);
            if (Cu3 != null) {
                Cu3.a(i, z);
            }
            n Cu4 = com.ss.android.socialbase.downloader.impls.l.Cu(true);
            if (Cu4 != null) {
                Cu4.a(i, z);
                return;
            }
            return;
        }
        n QS = QS(i);
        if (QS != null) {
            QS.a(i, z);
        }
        com.ss.android.socialbase.downloader.impls.l.Cu(true).a(2, i);
    }

    public boolean e(int i) {
        n QS = QS(i);
        if (QS == null) {
            return false;
        }
        return QS.b(i);
    }

    public void f(int i) {
        n QS = QS(i);
        if (QS != null) {
            QS.c(i);
        }
    }

    public void g(int i) {
        n QS = QS(i);
        if (QS != null) {
            QS.d(i);
        }
    }

    public void c() {
        n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(false);
        if (Cu != null) {
            Cu.a();
        }
        n Cu2 = com.ss.android.socialbase.downloader.impls.l.Cu(true);
        if (Cu2 != null) {
            Cu2.a();
        }
    }

    public int h(int i) {
        n QS = QS(i);
        if (QS == null) {
            return 0;
        }
        return QS.f(i);
    }

    public boolean i(int i) {
        n QS = QS(i);
        if (QS == null) {
            return false;
        }
        return QS.g(i);
    }

    public com.ss.android.socialbase.downloader.g.c j(int i) {
        n QS = QS(i);
        if (QS == null) {
            return null;
        }
        return QS.h(i);
    }

    public int a(String str, String str2) {
        return b.a(str, str2);
    }

    public com.ss.android.socialbase.downloader.g.c b(String str, String str2) {
        int a2 = a(str, str2);
        n QS = QS(a2);
        if (QS == null) {
            return null;
        }
        return QS.h(a2);
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        List<com.ss.android.socialbase.downloader.g.c> a2 = com.ss.android.socialbase.downloader.impls.l.Cu(false).a(str);
        List<com.ss.android.socialbase.downloader.g.c> a3 = com.ss.android.socialbase.downloader.impls.l.Cu(true).a(str);
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

    public com.ss.android.socialbase.downloader.d.d QT(int i) {
        n QS = QS(i);
        if (QS == null) {
            return null;
        }
        return QS.Rb(i);
    }

    public com.ss.android.socialbase.downloader.d.r QU(int i) {
        n QS = QS(i);
        if (QS == null) {
            return null;
        }
        return QS.Rc(i);
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
        n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(false);
        List<com.ss.android.socialbase.downloader.g.c> c = Cu != null ? Cu.c(str) : null;
        n Cu2 = com.ss.android.socialbase.downloader.impls.l.Cu(true);
        return a(c, Cu2 != null ? Cu2.c(str) : null, sparseArray);
    }

    public void a(List<String> list) {
        n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(false);
        if (Cu != null) {
            Cu.a(list);
        }
        n Cu2 = com.ss.android.socialbase.downloader.impls.l.Cu(true);
        if (Cu2 != null) {
            Cu2.a(list);
        }
    }

    public void b(List<String> list) {
        n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(false);
        if (Cu != null) {
            Cu.b(list);
        }
        n Cu2 = com.ss.android.socialbase.downloader.impls.l.Cu(true);
        if (Cu2 != null) {
            Cu2.b(list);
        }
    }

    public void d(int i, boolean z) {
        n QS = QS(i);
        if (QS != null) {
            QS.b(i, z);
        }
    }

    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        n QS = QS(i);
        if (QS != null) {
            QS.b(i, bVar == null ? 0 : bVar.hashCode(), bVar, hVar, z);
        }
    }

    public void b(int i, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z) {
        n QS = QS(i);
        if (QS != null) {
            QS.a(i, bVar.hashCode(), bVar, hVar, z);
        }
    }

    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, com.ss.android.socialbase.downloader.b.h hVar, boolean z, boolean z2) {
        n QS = QS(i);
        if (QS != null) {
            QS.a(i, bVar.hashCode(), bVar, hVar, z, z2);
        }
    }

    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        n QS;
        if (cVar == null || (QS = QS(cVar.g())) == null) {
            return false;
        }
        return QS.a(cVar);
    }

    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray = new SparseArray<>();
        n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(false);
        List<com.ss.android.socialbase.downloader.g.c> d = Cu != null ? Cu.d(str) : null;
        n Cu2 = com.ss.android.socialbase.downloader.impls.l.Cu(true);
        return a(d, Cu2 != null ? Cu2.d(str) : null, sparseArray);
    }

    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        SparseArray<com.ss.android.socialbase.downloader.g.c> sparseArray = new SparseArray<>();
        n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(false);
        List<com.ss.android.socialbase.downloader.g.c> e = Cu != null ? Cu.e(str) : null;
        n Cu2 = com.ss.android.socialbase.downloader.impls.l.Cu(true);
        return a(e, Cu2 != null ? Cu2.e(str) : null, sparseArray);
    }

    public void a(final com.ss.android.socialbase.downloader.g.d dVar) {
        final n d = d(dVar);
        if (d == null) {
            if (dVar != null) {
                com.ss.android.socialbase.downloader.h.a.a(dVar.eFL(), dVar.a(), new com.ss.android.socialbase.downloader.e.a(1003, "tryDownload but getDownloadHandler failed"), dVar.a() != null ? dVar.a().q() : 0);
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

    public boolean QV(int i) {
        n QS = QS(i);
        if (QS == null) {
            return false;
        }
        return QS.Ra(i);
    }

    public void n(int i) {
        if (i != 0) {
            b(i, Boolean.TRUE.booleanValue());
            n Cu = com.ss.android.socialbase.downloader.impls.l.Cu(true);
            if (Cu != null) {
                Cu.d();
            }
        }
    }

    public ah QW(int i) {
        n QS = QS(i);
        if (QS == null) {
            return null;
        }
        return QS.Rd(i);
    }
}
