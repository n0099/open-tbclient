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
    private c qcv;
    private com.ss.android.socialbase.downloader.downloader.h qhk;
    private i qhl;
    private com.ss.android.socialbase.downloader.d.d qhm;
    private an qhn;
    private ad qho;
    private com.ss.android.socialbase.downloader.d.c qhp;
    private c.a qhq;
    private al qhr;
    private af qhs;
    private s qht;
    private r qhu;
    private ah qhv;
    private ab qhw;
    private boolean r;

    public c a() {
        return this.qcv;
    }

    public d() {
        this.d = new ConcurrentHashMap();
        this.e = new SparseArray<>();
        this.r = false;
        this.qhq = new c.a();
        this.f = new SparseArray<>();
        this.g = new SparseArray<>();
        this.h = new SparseArray<>();
    }

    public d(c cVar) {
        this();
        this.qcv = cVar;
    }

    public boolean b() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public an eIk() {
        return this.qhn;
    }

    public ad eIl() {
        return this.qho;
    }

    public com.ss.android.socialbase.downloader.d.c eIm() {
        return this.qhp;
    }

    public i eIn() {
        return this.qhl;
    }

    public s eIo() {
        return this.qht;
    }

    public al eIp() {
        return this.qhr;
    }

    public af eIq() {
        return this.qhs;
    }

    public com.ss.android.socialbase.downloader.d.d eIr() {
        return this.qhm;
    }

    public r eIs() {
        return this.qhu;
    }

    public ah eIt() {
        return this.qhv;
    }

    public boolean m() {
        if (this.qcv != null) {
            return this.qcv.eHs();
        }
        return false;
    }

    public d c(i iVar) {
        this.qhl = iVar;
        return this;
    }

    public d d(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.qhk = hVar;
        return this;
    }

    public d a(s sVar) {
        this.qht = sVar;
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
        this.qhm = dVar;
        return this;
    }

    public d a(an anVar) {
        this.qhn = anVar;
        return this;
    }

    public d a(ad adVar) {
        this.qho = adVar;
        return this;
    }

    public d a(com.ss.android.socialbase.downloader.d.c cVar) {
        this.qhp = cVar;
        return this;
    }

    public d c(r rVar) {
        this.qhu = rVar;
        return this;
    }

    public d a(al alVar) {
        this.qhr = alVar;
        return this;
    }

    public d b(af afVar) {
        this.qhs = afVar;
        return this;
    }

    public d abB(String str) {
        this.qhq.abr(str);
        return this;
    }

    public d abC(String str) {
        this.qhq.abs(str);
        return this;
    }

    public d abD(String str) {
        this.qhq.abt(str);
        return this;
    }

    public d abE(String str) {
        this.qhq.abu(str);
        return this;
    }

    public d abF(String str) {
        this.qhq.abv(str);
        return this;
    }

    public d Cz(boolean z) {
        this.qhq.Cm(z);
        return this;
    }

    public d gZ(List<e> list) {
        this.qhq.gX(list);
        return this;
    }

    public d RN(int i) {
        this.qhq.RI(i);
        return this;
    }

    public d RO(int i) {
        this.qhq.RJ(i);
        return this;
    }

    public d CA(boolean z) {
        this.qhq.Cn(z);
        return this;
    }

    public d RP(int i) {
        this.qhq.RK(i);
        return this;
    }

    public d RQ(int i) {
        this.qhq.RL(i);
        return this;
    }

    public d ha(List<String> list) {
        this.qhq.gY(list);
        return this;
    }

    public d abG(String str) {
        this.qhq.abw(str);
        return this;
    }

    public d CB(boolean z) {
        this.qhq.Cp(z);
        return this;
    }

    public d CC(boolean z) {
        this.qhq.Co(z);
        return this;
    }

    public d CD(boolean z) {
        this.qhq.Cq(z);
        return this;
    }

    public d CE(boolean z) {
        this.qhq.Cr(z);
        return this;
    }

    public d abH(String str) {
        this.qhq.abx(str);
        return this;
    }

    public d abI(String str) {
        this.qhq.aby(str);
        return this;
    }

    public d jr(long j) {
        this.qhq.jp(j);
        return this;
    }

    public d CF(boolean z) {
        this.qhq.Cu(z);
        return this;
    }

    public d abJ(String str) {
        this.qhq.abz(str);
        return this;
    }

    public d CG(boolean z) {
        this.qhq.Cs(z);
        return this;
    }

    public d CH(boolean z) {
        this.qhq.Cv(z);
        return this;
    }

    public d CI(boolean z) {
        this.qhq.Cy(z);
        return this;
    }

    public d CJ(boolean z) {
        this.qhq.Ct(z);
        return this;
    }

    public d CK(boolean z) {
        this.qhq.Cw(z);
        return this;
    }

    public d c(g gVar) {
        this.qhq.b(gVar);
        return this;
    }

    public d CL(boolean z) {
        this.qhq.Cx(z);
        return this;
    }

    public d b(ah ahVar) {
        this.qhv = ahVar;
        return this;
    }

    public d fo(JSONObject jSONObject) {
        this.qhq.fn(jSONObject);
        return this;
    }

    public d abK(String str) {
        this.qhq.abA(str);
        return this;
    }

    public d RR(int i) {
        this.qhq.RM(i);
        return this;
    }

    public d js(long j) {
        this.qhq.jq(j);
        return this;
    }

    public int n() {
        this.qcv = this.qhq.a();
        s();
        com.ss.android.socialbase.downloader.downloader.c.eGK().a(this);
        if (this.qcv == null) {
            return 0;
        }
        return this.qcv.g();
    }

    public int o() {
        if (this.qcv == null) {
            return 0;
        }
        return this.qcv.g();
    }

    public void p() {
        com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        a(h.MAIN);
        a(h.SUB);
        com.ss.android.socialbase.downloader.h.a.a(this.qhp, this.qcv, new com.ss.android.socialbase.downloader.e.a(1003, "has another same task, add Listener to old task"), 0);
    }

    private void a(h hVar) {
        SparseArray<com.ss.android.socialbase.downloader.d.b> b = b(hVar);
        synchronized (b) {
            for (int i = 0; i < b.size(); i++) {
                com.ss.android.socialbase.downloader.d.b bVar = b.get(b.keyAt(i));
                if (bVar != null) {
                    com.ss.android.socialbase.downloader.downloader.c.eGK().b(o(), bVar, hVar, false);
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
        SparseArray<com.ss.android.socialbase.downloader.d.b> b = b(hVar);
        if (b == null) {
            return 0;
        }
        synchronized (b) {
            size = b.size();
        }
        return size;
    }

    public com.ss.android.socialbase.downloader.d.b a(h hVar, int i) {
        com.ss.android.socialbase.downloader.d.b bVar = null;
        SparseArray<com.ss.android.socialbase.downloader.d.b> b = b(hVar);
        if (b != null && i >= 0) {
            synchronized (b) {
                if (i < b.size()) {
                    bVar = b.get(b.keyAt(i));
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
        SparseArray<com.ss.android.socialbase.downloader.d.b> b = b(hVar);
        if (b == null) {
            if (z && this.d.containsKey(hVar)) {
                this.d.remove(hVar);
                return;
            }
            return;
        }
        synchronized (b) {
            if (z) {
                if (this.d.containsKey(hVar)) {
                    bVar2 = this.d.get(hVar);
                    this.d.remove(hVar);
                } else {
                    bVar2 = bVar;
                }
                if (bVar2 != null && (indexOfValue = b.indexOfValue(bVar2)) >= 0 && indexOfValue < b.size()) {
                    b.removeAt(indexOfValue);
                }
            } else {
                b.remove(i);
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
            SparseArray<com.ss.android.socialbase.downloader.d.b> b = b(hVar);
            if (b != null) {
                synchronized (b) {
                    b.put(i, bVar);
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
        this.qhm = dVar;
    }

    public com.ss.android.socialbase.downloader.downloader.h eIu() {
        return this.qhk;
    }

    public void a(d dVar) {
        this.qhk = dVar.qhk;
        this.qhl = dVar.qhl;
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
        this.qhm = dVar.qhm;
        this.qhn = dVar.qhn;
        this.qho = dVar.qho;
        this.qhp = dVar.qhp;
        this.qhr = dVar.qhr;
        this.qhs = dVar.qhs;
        this.qht = dVar.qht;
        this.qhu = dVar.qhu;
        this.qhv = dVar.qhv;
        this.qhw = dVar.qhw;
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
        this.qhw = abVar;
        return this;
    }

    public ab eIv() {
        return this.qhw;
    }

    private void s() {
        if (this.qcv.eIj() > 0) {
            c(new i() { // from class: com.ss.android.socialbase.downloader.g.d.1
                @Override // com.ss.android.socialbase.downloader.downloader.i
                public int a(long j) {
                    return 1;
                }
            });
        }
    }
}
