package com.ss.android.socialbase.downloader.g;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.g;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.ad;
import com.ss.android.socialbase.downloader.d.af;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.al;
import com.ss.android.socialbase.downloader.d.an;
import com.ss.android.socialbase.downloader.d.r;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.g.c;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private final Map<h, com.ss.android.socialbase.downloader.d.b> d;
    private final SparseArray<h> e;
    private final SparseArray<com.ss.android.socialbase.downloader.d.b> f;
    private final SparseArray<com.ss.android.socialbase.downloader.d.b> g;
    private final SparseArray<com.ss.android.socialbase.downloader.d.b> h;
    private c qbH;
    private com.ss.android.socialbase.downloader.d.c qgA;
    private c.a qgB;
    private al qgC;
    private af qgD;
    private s qgE;
    private r qgF;
    private ah qgG;
    private ab qgH;
    private com.ss.android.socialbase.downloader.downloader.h qgv;
    private i qgw;
    private com.ss.android.socialbase.downloader.d.d qgx;
    private an qgy;
    private ad qgz;
    private boolean r;

    public c a() {
        return this.qbH;
    }

    public d() {
        this.d = new ConcurrentHashMap();
        this.e = new SparseArray<>();
        this.r = false;
        this.qgB = new c.a();
        this.f = new SparseArray<>();
        this.g = new SparseArray<>();
        this.h = new SparseArray<>();
    }

    public d(c cVar) {
        this();
        this.qbH = cVar;
    }

    public boolean b() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public an eIi() {
        return this.qgy;
    }

    public ad eIj() {
        return this.qgz;
    }

    public com.ss.android.socialbase.downloader.d.c eIk() {
        return this.qgA;
    }

    public i eIl() {
        return this.qgw;
    }

    public s eIm() {
        return this.qgE;
    }

    public al eIn() {
        return this.qgC;
    }

    public af eIo() {
        return this.qgD;
    }

    public com.ss.android.socialbase.downloader.d.d eIp() {
        return this.qgx;
    }

    public r eIq() {
        return this.qgF;
    }

    public ah eIr() {
        return this.qgG;
    }

    public boolean m() {
        if (this.qbH != null) {
            return this.qbH.eHm();
        }
        return false;
    }

    public d c(i iVar) {
        this.qgw = iVar;
        return this;
    }

    public d d(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.qgv = hVar;
        return this;
    }

    public d a(s sVar) {
        this.qgE = sVar;
        return this;
    }

    public d b(com.ss.android.socialbase.downloader.d.b bVar) {
        return bVar == null ? this : b(bVar.hashCode(), bVar);
    }

    public d b(int i, com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            synchronized (this.f) {
                this.f.put(i, bVar);
            }
            this.d.put(h.MAIN, bVar);
            synchronized (this.e) {
                this.e.put(i, h.MAIN);
            }
        }
        return this;
    }

    public d c(int i, com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            synchronized (this.g) {
                this.g.put(i, bVar);
            }
            this.d.put(h.SUB, bVar);
            synchronized (this.e) {
                this.e.put(i, h.SUB);
            }
        }
        return this;
    }

    public d c(com.ss.android.socialbase.downloader.d.b bVar) {
        return bVar == null ? this : d(bVar.hashCode(), bVar);
    }

    public d d(int i, com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            synchronized (this.h) {
                this.h.put(i, bVar);
            }
            this.d.put(h.NOTIFICATION, bVar);
            synchronized (this.e) {
                this.e.put(i, h.NOTIFICATION);
            }
        }
        return this;
    }

    public d a(com.ss.android.socialbase.downloader.d.d dVar) {
        this.qgx = dVar;
        return this;
    }

    public d a(an anVar) {
        this.qgy = anVar;
        return this;
    }

    public d a(ad adVar) {
        this.qgz = adVar;
        return this;
    }

    public d a(com.ss.android.socialbase.downloader.d.c cVar) {
        this.qgA = cVar;
        return this;
    }

    public d c(r rVar) {
        this.qgF = rVar;
        return this;
    }

    public d a(al alVar) {
        this.qgC = alVar;
        return this;
    }

    public d b(af afVar) {
        this.qgD = afVar;
        return this;
    }

    public d abw(String str) {
        this.qgB.abm(str);
        return this;
    }

    public d abx(String str) {
        this.qgB.abn(str);
        return this;
    }

    public d aby(String str) {
        this.qgB.abo(str);
        return this;
    }

    public d abz(String str) {
        this.qgB.abp(str);
        return this;
    }

    public d abA(String str) {
        this.qgB.abq(str);
        return this;
    }

    public d CB(boolean z) {
        this.qgB.Co(z);
        return this;
    }

    public d gZ(List<e> list) {
        this.qgB.gX(list);
        return this;
    }

    public d RJ(int i) {
        this.qgB.RE(i);
        return this;
    }

    public d RK(int i) {
        this.qgB.RF(i);
        return this;
    }

    public d CC(boolean z) {
        this.qgB.Cp(z);
        return this;
    }

    public d RL(int i) {
        this.qgB.RG(i);
        return this;
    }

    public d RM(int i) {
        this.qgB.RH(i);
        return this;
    }

    public d ha(List<String> list) {
        this.qgB.gY(list);
        return this;
    }

    public d abB(String str) {
        this.qgB.abr(str);
        return this;
    }

    public d CD(boolean z) {
        this.qgB.Cr(z);
        return this;
    }

    public d CE(boolean z) {
        this.qgB.Cq(z);
        return this;
    }

    public d CF(boolean z) {
        this.qgB.Cs(z);
        return this;
    }

    public d CG(boolean z) {
        this.qgB.Ct(z);
        return this;
    }

    public d abC(String str) {
        this.qgB.abs(str);
        return this;
    }

    public d abD(String str) {
        this.qgB.abt(str);
        return this;
    }

    public d jr(long j) {
        this.qgB.jp(j);
        return this;
    }

    public d CH(boolean z) {
        this.qgB.Cw(z);
        return this;
    }

    public d abE(String str) {
        this.qgB.abu(str);
        return this;
    }

    public d CI(boolean z) {
        this.qgB.Cu(z);
        return this;
    }

    public d CJ(boolean z) {
        this.qgB.Cx(z);
        return this;
    }

    public d CK(boolean z) {
        this.qgB.CA(z);
        return this;
    }

    public d CL(boolean z) {
        this.qgB.Cv(z);
        return this;
    }

    public d CM(boolean z) {
        this.qgB.Cy(z);
        return this;
    }

    public d c(g gVar) {
        this.qgB.b(gVar);
        return this;
    }

    public d CN(boolean z) {
        this.qgB.Cz(z);
        return this;
    }

    public d b(ah ahVar) {
        this.qgG = ahVar;
        return this;
    }

    public d fl(JSONObject jSONObject) {
        this.qgB.fk(jSONObject);
        return this;
    }

    public d abF(String str) {
        this.qgB.abv(str);
        return this;
    }

    public d RN(int i) {
        this.qgB.RI(i);
        return this;
    }

    public d js(long j) {
        this.qgB.jq(j);
        return this;
    }

    public int n() {
        this.qbH = this.qgB.a();
        s();
        com.ss.android.socialbase.downloader.downloader.c.eGG().a(this);
        if (this.qbH == null) {
            return 0;
        }
        return this.qbH.g();
    }

    public int o() {
        if (this.qbH == null) {
            return 0;
        }
        return this.qbH.g();
    }

    public void p() {
        com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        a(h.MAIN);
        a(h.SUB);
        com.ss.android.socialbase.downloader.h.a.a(this.qgA, this.qbH, new com.ss.android.socialbase.downloader.e.a(1003, "has another same task, add Listener to old task"), 0);
    }

    private void a(h hVar) {
        SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = b(hVar);
        synchronized (b2) {
            for (int i = 0; i < b2.size(); i++) {
                com.ss.android.socialbase.downloader.d.b bVar = b2.get(b2.keyAt(i));
                if (bVar != null) {
                    com.ss.android.socialbase.downloader.downloader.c.eGG().b(o(), bVar, hVar, false);
                }
            }
        }
    }

    public SparseArray<com.ss.android.socialbase.downloader.d.b> b(h hVar) {
        if (hVar == h.MAIN) {
            return this.f;
        }
        if (hVar == h.SUB) {
            return this.g;
        }
        if (hVar == h.NOTIFICATION) {
            return this.h;
        }
        return null;
    }

    public int c(h hVar) {
        int size;
        SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = b(hVar);
        if (b2 == null) {
            return 0;
        }
        synchronized (b2) {
            size = b2.size();
        }
        return size;
    }

    public com.ss.android.socialbase.downloader.d.b a(h hVar, int i) {
        com.ss.android.socialbase.downloader.d.b bVar = null;
        SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = b(hVar);
        if (b2 != null && i >= 0) {
            synchronized (b2) {
                if (i < b2.size()) {
                    bVar = b2.get(b2.keyAt(i));
                }
            }
        }
        return bVar;
    }

    public com.ss.android.socialbase.downloader.d.b d(h hVar) {
        return this.d.get(hVar);
    }

    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, h hVar, boolean z) {
        com.ss.android.socialbase.downloader.d.b bVar2;
        int indexOfValue;
        SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = b(hVar);
        if (b2 == null) {
            if (z && this.d.containsKey(hVar)) {
                this.d.remove(hVar);
                return;
            }
            return;
        }
        synchronized (b2) {
            if (z) {
                if (this.d.containsKey(hVar)) {
                    bVar2 = this.d.get(hVar);
                    this.d.remove(hVar);
                } else {
                    bVar2 = bVar;
                }
                if (bVar2 != null && (indexOfValue = b2.indexOfValue(bVar2)) >= 0 && indexOfValue < b2.size()) {
                    b2.removeAt(indexOfValue);
                }
            } else {
                b2.remove(i);
                synchronized (this.e) {
                    h hVar2 = this.e.get(i);
                    if (hVar2 != null && this.d.containsKey(hVar2)) {
                        this.d.remove(hVar2);
                        this.e.remove(i);
                    }
                }
            }
        }
    }

    public void b(int i, com.ss.android.socialbase.downloader.d.b bVar, h hVar, boolean z) {
        if (bVar != null) {
            if (z && this.d != null) {
                this.d.put(hVar, bVar);
                synchronized (this.e) {
                    this.e.put(i, hVar);
                }
            }
            SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = b(hVar);
            if (b2 != null) {
                synchronized (b2) {
                    b2.put(i, bVar);
                }
            }
        }
    }

    private void a(SparseArray<com.ss.android.socialbase.downloader.d.b> sparseArray, SparseArray<com.ss.android.socialbase.downloader.d.b> sparseArray2) {
        sparseArray.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < sparseArray2.size()) {
                int keyAt = sparseArray2.keyAt(i2);
                com.ss.android.socialbase.downloader.d.b bVar = sparseArray2.get(keyAt);
                if (bVar != null) {
                    sparseArray.put(keyAt, bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(SparseArray<com.ss.android.socialbase.downloader.d.b> sparseArray, h hVar) {
        if (sparseArray != null) {
            try {
                if (hVar == h.MAIN) {
                    synchronized (this.f) {
                        a(this.f, sparseArray);
                    }
                } else if (hVar == h.SUB) {
                    synchronized (this.g) {
                        a(this.g, sparseArray);
                    }
                } else if (hVar == h.NOTIFICATION) {
                    synchronized (this.h) {
                        a(this.h, sparseArray);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void b(com.ss.android.socialbase.downloader.d.d dVar) {
        this.qgx = dVar;
    }

    public com.ss.android.socialbase.downloader.downloader.h eIs() {
        return this.qgv;
    }

    public void a(d dVar) {
        this.qgv = dVar.qgv;
        this.qgw = dVar.qgw;
        this.d.clear();
        this.d.putAll(dVar.d);
        synchronized (this.f) {
            this.f.clear();
            d(dVar.f, this.f);
        }
        synchronized (this.g) {
            this.g.clear();
            d(dVar.g, this.g);
        }
        synchronized (this.h) {
            this.h.clear();
            d(dVar.h, this.h);
        }
        this.qgx = dVar.qgx;
        this.qgy = dVar.qgy;
        this.qgz = dVar.qgz;
        this.qgA = dVar.qgA;
        this.qgC = dVar.qgC;
        this.qgD = dVar.qgD;
        this.qgE = dVar.qgE;
        this.qgF = dVar.qgF;
        this.qgG = dVar.qgG;
        this.qgH = dVar.qgH;
    }

    public void b(d dVar) {
        for (Map.Entry<h, com.ss.android.socialbase.downloader.d.b> entry : dVar.d.entrySet()) {
            if (entry != null && !this.d.containsKey(entry.getKey())) {
                this.d.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (dVar.f.size() != 0) {
                synchronized (this.f) {
                    e(this.f, dVar.f);
                    d(dVar.f, this.f);
                }
            }
            if (dVar.g.size() != 0) {
                synchronized (this.g) {
                    e(this.g, dVar.g);
                    d(dVar.g, this.g);
                }
            }
            if (dVar.h.size() != 0) {
                synchronized (this.h) {
                    e(this.h, dVar.h);
                    d(dVar.h, this.h);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray != null && sparseArray2 != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                sparseArray2.put(keyAt, sparseArray.get(keyAt));
            }
        }
    }

    private void e(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray != null && sparseArray2 != null) {
            int size = sparseArray2.size();
            for (int i = 0; i < size; i++) {
                sparseArray.remove(sparseArray2.keyAt(i));
            }
        }
    }

    public d d(ab abVar) {
        this.qgH = abVar;
        return this;
    }

    public ab eIt() {
        return this.qgH;
    }

    private void s() {
        if (this.qbH.eIh() > 0) {
            c(new i() { // from class: com.ss.android.socialbase.downloader.g.d.1
                @Override // com.ss.android.socialbase.downloader.downloader.i
                public int a(long j) {
                    return 1;
                }
            });
        }
    }
}
