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
    private c pRc;
    private com.ss.android.socialbase.downloader.downloader.h pVQ;
    private i pVR;
    private com.ss.android.socialbase.downloader.d.d pVS;
    private an pVT;
    private ad pVU;
    private com.ss.android.socialbase.downloader.d.c pVV;
    private c.a pVW;
    private al pVX;
    private af pVY;
    private s pVZ;
    private r pWa;
    private ah pWb;
    private ab pWc;
    private boolean r;

    public c a() {
        return this.pRc;
    }

    public d() {
        this.d = new ConcurrentHashMap();
        this.e = new SparseArray<>();
        this.r = false;
        this.pVW = new c.a();
        this.f = new SparseArray<>();
        this.g = new SparseArray<>();
        this.h = new SparseArray<>();
    }

    public d(c cVar) {
        this();
        this.pRc = cVar;
    }

    public boolean b() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public an eFJ() {
        return this.pVT;
    }

    public ad eFK() {
        return this.pVU;
    }

    public com.ss.android.socialbase.downloader.d.c eFL() {
        return this.pVV;
    }

    public i eFM() {
        return this.pVR;
    }

    public s eFN() {
        return this.pVZ;
    }

    public al eFO() {
        return this.pVX;
    }

    public af eFP() {
        return this.pVY;
    }

    public com.ss.android.socialbase.downloader.d.d eFQ() {
        return this.pVS;
    }

    public r eFR() {
        return this.pWa;
    }

    public ah eFS() {
        return this.pWb;
    }

    public boolean m() {
        if (this.pRc != null) {
            return this.pRc.eEN();
        }
        return false;
    }

    public d c(i iVar) {
        this.pVR = iVar;
        return this;
    }

    public d d(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.pVQ = hVar;
        return this;
    }

    public d a(s sVar) {
        this.pVZ = sVar;
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
        this.pVS = dVar;
        return this;
    }

    public d a(an anVar) {
        this.pVT = anVar;
        return this;
    }

    public d a(ad adVar) {
        this.pVU = adVar;
        return this;
    }

    public d a(com.ss.android.socialbase.downloader.d.c cVar) {
        this.pVV = cVar;
        return this;
    }

    public d c(r rVar) {
        this.pWa = rVar;
        return this;
    }

    public d a(al alVar) {
        this.pVX = alVar;
        return this;
    }

    public d b(af afVar) {
        this.pVY = afVar;
        return this;
    }

    public d aai(String str) {
        this.pVW.ZY(str);
        return this;
    }

    public d aaj(String str) {
        this.pVW.ZZ(str);
        return this;
    }

    public d aak(String str) {
        this.pVW.aaa(str);
        return this;
    }

    public d aal(String str) {
        this.pVW.aab(str);
        return this;
    }

    public d aam(String str) {
        this.pVW.aac(str);
        return this;
    }

    public d Ch(boolean z) {
        this.pVW.BU(z);
        return this;
    }

    public d hb(List<e> list) {
        this.pVW.gZ(list);
        return this;
    }

    public d Rn(int i) {
        this.pVW.Ri(i);
        return this;
    }

    public d Ro(int i) {
        this.pVW.Rj(i);
        return this;
    }

    public d Ci(boolean z) {
        this.pVW.BV(z);
        return this;
    }

    public d Rp(int i) {
        this.pVW.Rk(i);
        return this;
    }

    public d Rq(int i) {
        this.pVW.Rl(i);
        return this;
    }

    public d hc(List<String> list) {
        this.pVW.ha(list);
        return this;
    }

    public d aan(String str) {
        this.pVW.aad(str);
        return this;
    }

    public d Cj(boolean z) {
        this.pVW.BX(z);
        return this;
    }

    public d Ck(boolean z) {
        this.pVW.BW(z);
        return this;
    }

    public d Cl(boolean z) {
        this.pVW.BY(z);
        return this;
    }

    public d Cm(boolean z) {
        this.pVW.BZ(z);
        return this;
    }

    public d aao(String str) {
        this.pVW.aae(str);
        return this;
    }

    public d aap(String str) {
        this.pVW.aaf(str);
        return this;
    }

    public d jo(long j) {
        this.pVW.jm(j);
        return this;
    }

    public d Cn(boolean z) {
        this.pVW.Cc(z);
        return this;
    }

    public d aaq(String str) {
        this.pVW.aag(str);
        return this;
    }

    public d Co(boolean z) {
        this.pVW.Ca(z);
        return this;
    }

    public d Cp(boolean z) {
        this.pVW.Cd(z);
        return this;
    }

    public d Cq(boolean z) {
        this.pVW.Cg(z);
        return this;
    }

    public d Cr(boolean z) {
        this.pVW.Cb(z);
        return this;
    }

    public d Cs(boolean z) {
        this.pVW.Ce(z);
        return this;
    }

    public d c(g gVar) {
        this.pVW.b(gVar);
        return this;
    }

    public d Ct(boolean z) {
        this.pVW.Cf(z);
        return this;
    }

    public d b(ah ahVar) {
        this.pWb = ahVar;
        return this;
    }

    public d fk(JSONObject jSONObject) {
        this.pVW.fj(jSONObject);
        return this;
    }

    public d aar(String str) {
        this.pVW.aah(str);
        return this;
    }

    public d Rr(int i) {
        this.pVW.Rm(i);
        return this;
    }

    public d jp(long j) {
        this.pVW.jn(j);
        return this;
    }

    public int n() {
        this.pRc = this.pVW.a();
        s();
        com.ss.android.socialbase.downloader.downloader.c.eEh().a(this);
        if (this.pRc == null) {
            return 0;
        }
        return this.pRc.g();
    }

    public int o() {
        if (this.pRc == null) {
            return 0;
        }
        return this.pRc.g();
    }

    public void p() {
        com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        a(h.MAIN);
        a(h.SUB);
        com.ss.android.socialbase.downloader.h.a.a(this.pVV, this.pRc, new com.ss.android.socialbase.downloader.e.a(1003, "has another same task, add Listener to old task"), 0);
    }

    private void a(h hVar) {
        SparseArray<com.ss.android.socialbase.downloader.d.b> b2 = b(hVar);
        synchronized (b2) {
            for (int i = 0; i < b2.size(); i++) {
                com.ss.android.socialbase.downloader.d.b bVar = b2.get(b2.keyAt(i));
                if (bVar != null) {
                    com.ss.android.socialbase.downloader.downloader.c.eEh().b(o(), bVar, hVar, false);
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
        this.pVS = dVar;
    }

    public com.ss.android.socialbase.downloader.downloader.h eFT() {
        return this.pVQ;
    }

    public void a(d dVar) {
        this.pVQ = dVar.pVQ;
        this.pVR = dVar.pVR;
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
        this.pVS = dVar.pVS;
        this.pVT = dVar.pVT;
        this.pVU = dVar.pVU;
        this.pVV = dVar.pVV;
        this.pVX = dVar.pVX;
        this.pVY = dVar.pVY;
        this.pVZ = dVar.pVZ;
        this.pWa = dVar.pWa;
        this.pWb = dVar.pWb;
        this.pWc = dVar.pWc;
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
        this.pWc = abVar;
        return this;
    }

    public ab eFU() {
        return this.pWc;
    }

    private void s() {
        if (this.pRc.eFI() > 0) {
            c(new i() { // from class: com.ss.android.socialbase.downloader.g.d.1
                @Override // com.ss.android.socialbase.downloader.downloader.i
                public int a(long j) {
                    return 1;
                }
            });
        }
    }
}
