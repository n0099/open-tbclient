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
/* loaded from: classes4.dex */
public class d {
    private final Map<h, com.ss.android.socialbase.downloader.d.b> d;
    private final SparseArray<h> e;
    private final SparseArray<com.ss.android.socialbase.downloader.d.b> f;
    private final SparseArray<com.ss.android.socialbase.downloader.d.b> g;
    private final SparseArray<com.ss.android.socialbase.downloader.d.b> h;
    private c pTV;
    private com.ss.android.socialbase.downloader.downloader.h pYJ;
    private i pYK;
    private com.ss.android.socialbase.downloader.d.d pYL;
    private an pYM;
    private ad pYN;
    private com.ss.android.socialbase.downloader.d.c pYO;
    private c.a pYP;
    private al pYQ;
    private af pYR;
    private s pYS;
    private r pYT;
    private ah pYU;
    private ab pYV;
    private boolean r;

    public c a() {
        return this.pTV;
    }

    public d() {
        this.d = new ConcurrentHashMap();
        this.e = new SparseArray<>();
        this.r = false;
        this.pYP = new c.a();
        this.f = new SparseArray<>();
        this.g = new SparseArray<>();
        this.h = new SparseArray<>();
    }

    public d(c cVar) {
        this();
        this.pTV = cVar;
    }

    public boolean b() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public an eIV() {
        return this.pYM;
    }

    public ad eIW() {
        return this.pYN;
    }

    public com.ss.android.socialbase.downloader.d.c eIX() {
        return this.pYO;
    }

    public i eIY() {
        return this.pYK;
    }

    public s eIZ() {
        return this.pYS;
    }

    public al eJa() {
        return this.pYQ;
    }

    public af eJb() {
        return this.pYR;
    }

    public com.ss.android.socialbase.downloader.d.d eJc() {
        return this.pYL;
    }

    public r eJd() {
        return this.pYT;
    }

    public ah eJe() {
        return this.pYU;
    }

    public boolean m() {
        if (this.pTV != null) {
            return this.pTV.eHZ();
        }
        return false;
    }

    public d c(i iVar) {
        this.pYK = iVar;
        return this;
    }

    public d d(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.pYJ = hVar;
        return this;
    }

    public d a(s sVar) {
        this.pYS = sVar;
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
        this.pYL = dVar;
        return this;
    }

    public d a(an anVar) {
        this.pYM = anVar;
        return this;
    }

    public d a(ad adVar) {
        this.pYN = adVar;
        return this;
    }

    public d a(com.ss.android.socialbase.downloader.d.c cVar) {
        this.pYO = cVar;
        return this;
    }

    public d c(r rVar) {
        this.pYT = rVar;
        return this;
    }

    public d a(al alVar) {
        this.pYQ = alVar;
        return this;
    }

    public d b(af afVar) {
        this.pYR = afVar;
        return this;
    }

    public d abp(String str) {
        this.pYP.abf(str);
        return this;
    }

    public d abq(String str) {
        this.pYP.abg(str);
        return this;
    }

    public d abr(String str) {
        this.pYP.abh(str);
        return this;
    }

    public d abs(String str) {
        this.pYP.abi(str);
        return this;
    }

    public d abt(String str) {
        this.pYP.abj(str);
        return this;
    }

    public d Cl(boolean z) {
        this.pYP.BY(z);
        return this;
    }

    public d ha(List<e> list) {
        this.pYP.gY(list);
        return this;
    }

    public d SE(int i) {
        this.pYP.Sz(i);
        return this;
    }

    public d SF(int i) {
        this.pYP.SA(i);
        return this;
    }

    public d Cm(boolean z) {
        this.pYP.BZ(z);
        return this;
    }

    public d SG(int i) {
        this.pYP.SB(i);
        return this;
    }

    public d SH(int i) {
        this.pYP.SC(i);
        return this;
    }

    public d hb(List<String> list) {
        this.pYP.gZ(list);
        return this;
    }

    public d abu(String str) {
        this.pYP.abk(str);
        return this;
    }

    public d Cn(boolean z) {
        this.pYP.Cb(z);
        return this;
    }

    public d Co(boolean z) {
        this.pYP.Ca(z);
        return this;
    }

    public d Cp(boolean z) {
        this.pYP.Cc(z);
        return this;
    }

    public d Cq(boolean z) {
        this.pYP.Cd(z);
        return this;
    }

    public d abv(String str) {
        this.pYP.abl(str);
        return this;
    }

    public d abw(String str) {
        this.pYP.abm(str);
        return this;
    }

    public d jl(long j) {
        this.pYP.jj(j);
        return this;
    }

    public d Cr(boolean z) {
        this.pYP.Cg(z);
        return this;
    }

    public d abx(String str) {
        this.pYP.abn(str);
        return this;
    }

    public d Cs(boolean z) {
        this.pYP.Ce(z);
        return this;
    }

    public d Ct(boolean z) {
        this.pYP.Ch(z);
        return this;
    }

    public d Cu(boolean z) {
        this.pYP.Ck(z);
        return this;
    }

    public d Cv(boolean z) {
        this.pYP.Cf(z);
        return this;
    }

    public d Cw(boolean z) {
        this.pYP.Ci(z);
        return this;
    }

    public d c(g gVar) {
        this.pYP.b(gVar);
        return this;
    }

    public d Cx(boolean z) {
        this.pYP.Cj(z);
        return this;
    }

    public d b(ah ahVar) {
        this.pYU = ahVar;
        return this;
    }

    public d fk(JSONObject jSONObject) {
        this.pYP.fj(jSONObject);
        return this;
    }

    public d aby(String str) {
        this.pYP.abo(str);
        return this;
    }

    public d SI(int i) {
        this.pYP.SD(i);
        return this;
    }

    public d jm(long j) {
        this.pYP.jk(j);
        return this;
    }

    public int n() {
        this.pTV = this.pYP.a();
        s();
        com.ss.android.socialbase.downloader.downloader.c.eHt().a(this);
        if (this.pTV == null) {
            return 0;
        }
        return this.pTV.g();
    }

    public int o() {
        if (this.pTV == null) {
            return 0;
        }
        return this.pTV.g();
    }

    public void p() {
        com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        a(h.MAIN);
        a(h.SUB);
        com.ss.android.socialbase.downloader.h.a.a(this.pYO, this.pTV, new com.ss.android.socialbase.downloader.e.a(1003, "has another same task, add Listener to old task"), 0);
    }

    private void a(h hVar) {
        SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = b(hVar);
        synchronized (b2) {
            for (int i = 0; i < b2.size(); i++) {
                com.ss.android.socialbase.downloader.d.b bVar = b2.get(b2.keyAt(i));
                if (bVar != null) {
                    com.ss.android.socialbase.downloader.downloader.c.eHt().b(o(), bVar, hVar, false);
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
        this.pYL = dVar;
    }

    public com.ss.android.socialbase.downloader.downloader.h eJf() {
        return this.pYJ;
    }

    public void a(d dVar) {
        this.pYJ = dVar.pYJ;
        this.pYK = dVar.pYK;
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
        this.pYL = dVar.pYL;
        this.pYM = dVar.pYM;
        this.pYN = dVar.pYN;
        this.pYO = dVar.pYO;
        this.pYQ = dVar.pYQ;
        this.pYR = dVar.pYR;
        this.pYS = dVar.pYS;
        this.pYT = dVar.pYT;
        this.pYU = dVar.pYU;
        this.pYV = dVar.pYV;
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
        this.pYV = abVar;
        return this;
    }

    public ab eJg() {
        return this.pYV;
    }

    private void s() {
        if (this.pTV.eIU() > 0) {
            c(new i() { // from class: com.ss.android.socialbase.downloader.g.d.1
                @Override // com.ss.android.socialbase.downloader.downloader.i
                public int a(long j) {
                    return 1;
                }
            });
        }
    }
}
