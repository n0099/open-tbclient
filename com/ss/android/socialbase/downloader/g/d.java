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
    private c qbh;
    private com.ss.android.socialbase.downloader.downloader.h qfV;
    private i qfW;
    private com.ss.android.socialbase.downloader.d.d qfX;
    private an qfY;
    private ad qfZ;
    private com.ss.android.socialbase.downloader.d.c qga;
    private c.a qgb;
    private al qgc;
    private af qgd;
    private s qge;
    private r qgf;
    private ah qgg;
    private ab qgh;
    private boolean r;

    public c a() {
        return this.qbh;
    }

    public d() {
        this.d = new ConcurrentHashMap();
        this.e = new SparseArray<>();
        this.r = false;
        this.qgb = new c.a();
        this.f = new SparseArray<>();
        this.g = new SparseArray<>();
        this.h = new SparseArray<>();
    }

    public d(c cVar) {
        this();
        this.qbh = cVar;
    }

    public boolean b() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public an eIa() {
        return this.qfY;
    }

    public ad eIb() {
        return this.qfZ;
    }

    public com.ss.android.socialbase.downloader.d.c eIc() {
        return this.qga;
    }

    public i eId() {
        return this.qfW;
    }

    public s eIe() {
        return this.qge;
    }

    public al eIf() {
        return this.qgc;
    }

    public af eIg() {
        return this.qgd;
    }

    public com.ss.android.socialbase.downloader.d.d eIh() {
        return this.qfX;
    }

    public r eIi() {
        return this.qgf;
    }

    public ah eIj() {
        return this.qgg;
    }

    public boolean m() {
        if (this.qbh != null) {
            return this.qbh.eHe();
        }
        return false;
    }

    public d c(i iVar) {
        this.qfW = iVar;
        return this;
    }

    public d d(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.qfV = hVar;
        return this;
    }

    public d a(s sVar) {
        this.qge = sVar;
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
        this.qfX = dVar;
        return this;
    }

    public d a(an anVar) {
        this.qfY = anVar;
        return this;
    }

    public d a(ad adVar) {
        this.qfZ = adVar;
        return this;
    }

    public d a(com.ss.android.socialbase.downloader.d.c cVar) {
        this.qga = cVar;
        return this;
    }

    public d c(r rVar) {
        this.qgf = rVar;
        return this;
    }

    public d a(al alVar) {
        this.qgc = alVar;
        return this;
    }

    public d b(af afVar) {
        this.qgd = afVar;
        return this;
    }

    public d abk(String str) {
        this.qgb.aba(str);
        return this;
    }

    public d abl(String str) {
        this.qgb.abb(str);
        return this;
    }

    public d abm(String str) {
        this.qgb.abc(str);
        return this;
    }

    public d abn(String str) {
        this.qgb.abd(str);
        return this;
    }

    public d abo(String str) {
        this.qgb.abe(str);
        return this;
    }

    public d CB(boolean z) {
        this.qgb.Co(z);
        return this;
    }

    public d gZ(List<e> list) {
        this.qgb.gX(list);
        return this;
    }

    public d RI(int i) {
        this.qgb.RD(i);
        return this;
    }

    public d RJ(int i) {
        this.qgb.RE(i);
        return this;
    }

    public d CC(boolean z) {
        this.qgb.Cp(z);
        return this;
    }

    public d RK(int i) {
        this.qgb.RF(i);
        return this;
    }

    public d RL(int i) {
        this.qgb.RG(i);
        return this;
    }

    public d ha(List<String> list) {
        this.qgb.gY(list);
        return this;
    }

    public d abp(String str) {
        this.qgb.abf(str);
        return this;
    }

    public d CD(boolean z) {
        this.qgb.Cr(z);
        return this;
    }

    public d CE(boolean z) {
        this.qgb.Cq(z);
        return this;
    }

    public d CF(boolean z) {
        this.qgb.Cs(z);
        return this;
    }

    public d CG(boolean z) {
        this.qgb.Ct(z);
        return this;
    }

    public d abq(String str) {
        this.qgb.abg(str);
        return this;
    }

    public d abr(String str) {
        this.qgb.abh(str);
        return this;
    }

    public d jr(long j) {
        this.qgb.jp(j);
        return this;
    }

    public d CH(boolean z) {
        this.qgb.Cw(z);
        return this;
    }

    public d abs(String str) {
        this.qgb.abi(str);
        return this;
    }

    public d CI(boolean z) {
        this.qgb.Cu(z);
        return this;
    }

    public d CJ(boolean z) {
        this.qgb.Cx(z);
        return this;
    }

    public d CK(boolean z) {
        this.qgb.CA(z);
        return this;
    }

    public d CL(boolean z) {
        this.qgb.Cv(z);
        return this;
    }

    public d CM(boolean z) {
        this.qgb.Cy(z);
        return this;
    }

    public d c(g gVar) {
        this.qgb.b(gVar);
        return this;
    }

    public d CN(boolean z) {
        this.qgb.Cz(z);
        return this;
    }

    public d b(ah ahVar) {
        this.qgg = ahVar;
        return this;
    }

    public d fl(JSONObject jSONObject) {
        this.qgb.fk(jSONObject);
        return this;
    }

    public d abt(String str) {
        this.qgb.abj(str);
        return this;
    }

    public d RM(int i) {
        this.qgb.RH(i);
        return this;
    }

    public d js(long j) {
        this.qgb.jq(j);
        return this;
    }

    public int n() {
        this.qbh = this.qgb.a();
        s();
        com.ss.android.socialbase.downloader.downloader.c.eGy().a(this);
        if (this.qbh == null) {
            return 0;
        }
        return this.qbh.g();
    }

    public int o() {
        if (this.qbh == null) {
            return 0;
        }
        return this.qbh.g();
    }

    public void p() {
        com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        a(h.MAIN);
        a(h.SUB);
        com.ss.android.socialbase.downloader.h.a.a(this.qga, this.qbh, new com.ss.android.socialbase.downloader.e.a(1003, "has another same task, add Listener to old task"), 0);
    }

    private void a(h hVar) {
        SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = b(hVar);
        synchronized (b2) {
            for (int i = 0; i < b2.size(); i++) {
                com.ss.android.socialbase.downloader.d.b bVar = b2.get(b2.keyAt(i));
                if (bVar != null) {
                    com.ss.android.socialbase.downloader.downloader.c.eGy().b(o(), bVar, hVar, false);
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
        this.qfX = dVar;
    }

    public com.ss.android.socialbase.downloader.downloader.h eIk() {
        return this.qfV;
    }

    public void a(d dVar) {
        this.qfV = dVar.qfV;
        this.qfW = dVar.qfW;
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
        this.qfX = dVar.qfX;
        this.qfY = dVar.qfY;
        this.qfZ = dVar.qfZ;
        this.qga = dVar.qga;
        this.qgc = dVar.qgc;
        this.qgd = dVar.qgd;
        this.qge = dVar.qge;
        this.qgf = dVar.qgf;
        this.qgg = dVar.qgg;
        this.qgh = dVar.qgh;
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
        this.qgh = abVar;
        return this;
    }

    public ab eIl() {
        return this.qgh;
    }

    private void s() {
        if (this.qbh.eHZ() > 0) {
            c(new i() { // from class: com.ss.android.socialbase.downloader.g.d.1
                @Override // com.ss.android.socialbase.downloader.downloader.i
                public int a(long j) {
                    return 1;
                }
            });
        }
    }
}
