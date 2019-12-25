package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.hls.d;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class l implements com.google.android.exoplayer2.extractor.g, o.b, q, Loader.a<com.google.android.exoplayer2.source.a.c>, Loader.d {
    private final int lTu;
    private boolean lUK;
    private u lUc;
    private final int mmP;
    private final com.google.android.exoplayer2.upstream.b mmS;
    private boolean mnd;
    private boolean mnf;
    private int mnh;
    private long mnm;
    private long mnn;
    private boolean mnp;
    private final b.a moY;
    private long mom;
    private int mpw;
    private final a mrQ;
    private final d mrR;
    private final Format mrS;
    private Format mrU;
    private boolean mrV;
    private boolean[] mrW;
    private boolean[] mrX;
    private boolean mrY;
    private boolean released;
    private final Loader mmV = new Loader("Loader:HlsSampleStreamWrapper");
    private final d.b mrT = new d.b();
    private int[] mnc = new int[0];
    private o[] mnb = new o[0];
    private final LinkedList<h> mpa = new LinkedList<>();
    private final Runnable mmY = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.dtQ();
        }
    };
    private final Handler handler = new Handler();

    /* loaded from: classes4.dex */
    public interface a extends q.a<l> {
        void a(a.C0667a c0667a);

        void onPrepared();
    }

    public l(int i, a aVar, d dVar, com.google.android.exoplayer2.upstream.b bVar, long j, Format format, int i2, b.a aVar2) {
        this.lTu = i;
        this.mrQ = aVar;
        this.mrR = dVar;
        this.mmS = bVar;
        this.mrS = format;
        this.mmP = i2;
        this.moY = aVar2;
        this.mnm = j;
        this.mnn = j;
    }

    public void duR() {
        if (!this.lUK) {
            ga(this.mnm);
        }
    }

    public void o(Format format) {
        dJ(0, -1).h(format);
        this.mnd = true;
        dtQ();
    }

    public void dtF() throws IOException {
        dtM();
    }

    public u dtG() {
        return this.lUc;
    }

    public boolean a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        com.google.android.exoplayer2.util.a.checkState(this.lUK);
        int i = this.mnh;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fVarArr.length) {
                break;
            }
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                af(((k) pVarArr[i3]).group, false);
                pVarArr[i3] = null;
            }
            i2 = i3 + 1;
        }
        boolean z4 = z || (!this.mnf ? j == this.mnm : i != 0);
        com.google.android.exoplayer2.b.f duH = this.mrR.duH();
        boolean z5 = z4;
        int i4 = 0;
        com.google.android.exoplayer2.b.f fVar = duH;
        while (i4 < fVarArr.length) {
            if (pVarArr[i4] == null && fVarArr[i4] != null) {
                com.google.android.exoplayer2.b.f fVar2 = fVarArr[i4];
                int a2 = this.lUc.a(fVar2.duG());
                af(a2, true);
                if (a2 == this.mpw) {
                    this.mrR.b(fVar2);
                    fVar = fVar2;
                }
                pVarArr[i4] = new k(this, a2);
                zArr2[i4] = true;
                if (!z5) {
                    o oVar = this.mnb[a2];
                    oVar.rewind();
                    z3 = oVar.a(j, true, true) == -1 && oVar.dtX() != 0;
                    i4++;
                    z5 = z3;
                }
            }
            z3 = z5;
            i4++;
            z5 = z3;
        }
        if (this.mnh == 0) {
            this.mrR.reset();
            this.mrU = null;
            this.mpa.clear();
            if (this.mmV.isLoading()) {
                for (o oVar2 : this.mnb) {
                    oVar2.dug();
                }
                this.mmV.cKW();
            } else {
                duS();
            }
        } else {
            if (!this.mpa.isEmpty() && !v.h(fVar, duH)) {
                if (!this.mnf) {
                    fVar.f(j, j < 0 ? -j : 0L, -9223372036854775807L);
                    if (fVar.dvZ() == this.mrR.duG().m(this.mpa.getLast().moF)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = true;
                }
                if (z2) {
                    z = true;
                    z5 = true;
                    this.mrY = true;
                }
            }
            if (z5) {
                p(j, z);
                for (int i5 = 0; i5 < pVarArr.length; i5++) {
                    if (pVarArr[i5] != null) {
                        zArr2[i5] = true;
                    }
                }
            }
        }
        this.mnf = true;
        return z5;
    }

    public void fY(long j) {
        int length = this.mnb.length;
        for (int i = 0; i < length; i++) {
            this.mnb[i].c(j, false, this.mrW[i]);
        }
    }

    public boolean p(long j, boolean z) {
        this.mnm = j;
        if (z || dtT() || !gc(j)) {
            this.mnn = j;
            this.mnp = false;
            this.mpa.clear();
            if (this.mmV.isLoading()) {
                this.mmV.cKW();
            } else {
                duS();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dtI() {
        if (this.mnp) {
            return Long.MIN_VALUE;
        }
        if (dtT()) {
            return this.mnn;
        }
        long j = this.mnm;
        h last = this.mpa.getLast();
        if (!last.dus()) {
            last = this.mpa.size() > 1 ? this.mpa.get(this.mpa.size() - 2) : null;
        }
        long max = last != null ? Math.max(j, last.moJ) : j;
        o[] oVarArr = this.mnb;
        int length = oVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, oVarArr[i].dtS());
            i++;
            max = max2;
        }
        return max;
    }

    public void release() {
        boolean a2 = this.mmV.a(this);
        if (this.lUK && !a2) {
            for (o oVar : this.mnb) {
                oVar.dug();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dtO() {
        duS();
    }

    public void vs(boolean z) {
        this.mrR.vs(z);
    }

    public void a(a.C0667a c0667a, long j) {
        this.mrR.a(c0667a, j);
    }

    public boolean Kq(int i) {
        return this.mnp || (!dtT() && this.mnb[i].dtZ());
    }

    public void dtM() throws IOException {
        this.mmV.dtM();
        this.mrR.dtM();
    }

    public int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dtT()) {
            return -3;
        }
        int a2 = this.mnb[i].a(mVar, eVar, z, this.mnp, this.mnm);
        if (a2 == -4) {
            duf();
            return a2;
        }
        return a2;
    }

    public int F(int i, long j) {
        int i2 = 0;
        if (!dtT()) {
            o oVar = this.mnb[i];
            if (this.mnp && j > oVar.dtS()) {
                i2 = oVar.dub();
            } else {
                int a2 = oVar.a(j, true, true);
                if (a2 != -1) {
                    i2 = a2;
                }
            }
            if (i2 > 0) {
                duf();
            }
        }
        return i2;
    }

    private void duf() {
        if (!this.mpa.isEmpty()) {
            while (this.mpa.size() > 1 && a(this.mpa.getFirst())) {
                this.mpa.removeFirst();
            }
            h first = this.mpa.getFirst();
            Format format = first.moF;
            if (!format.equals(this.mrU)) {
                this.moY.b(this.lTu, format, first.moG, first.moH, first.moI);
            }
            this.mrU = format;
        }
    }

    private boolean a(h hVar) {
        int i = hVar.uid;
        for (int i2 = 0; i2 < this.mnb.length; i2++) {
            if (this.mrW[i2] && this.mnb[i2].dtY() == i) {
                return false;
            }
        }
        return true;
    }

    private void duS() {
        for (o oVar : this.mnb) {
            oVar.reset(this.mrY);
        }
        this.mrY = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean ga(long j) {
        long j2;
        h hVar;
        if (this.mnp || this.mmV.isLoading()) {
            return false;
        }
        if (dtT()) {
            hVar = null;
            j2 = this.mnn;
        } else {
            h last = this.mpa.getLast();
            j2 = last.moJ;
            hVar = last;
        }
        this.mrR.a(hVar, j, j2, this.mrT);
        boolean z = this.mrT.moT;
        com.google.android.exoplayer2.source.a.c cVar = this.mrT.moS;
        a.C0667a c0667a = this.mrT.mrq;
        this.mrT.clear();
        if (z) {
            this.mnn = -9223372036854775807L;
            this.mnp = true;
            return true;
        } else if (cVar == null) {
            if (c0667a != null) {
                this.mrQ.a(c0667a);
            }
            return false;
        } else {
            if (a(cVar)) {
                this.mnn = -9223372036854775807L;
                h hVar2 = (h) cVar;
                hVar2.a(this);
                this.mpa.add(hVar2);
            }
            this.moY.b(cVar.dataSpec, cVar.type, this.lTu, cVar.moF, cVar.moG, cVar.moH, cVar.moI, cVar.moJ, this.mmV.a(cVar, this, this.mmP));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dtJ() {
        if (dtT()) {
            return this.mnn;
        }
        if (this.mnp) {
            return Long.MIN_VALUE;
        }
        return this.mpa.getLast().moJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2) {
        this.mrR.b(cVar);
        this.moY.c(cVar.dataSpec, cVar.type, this.lTu, cVar.moF, cVar.moG, cVar.moH, cVar.moI, cVar.moJ, j, j2, cVar.dum());
        if (!this.lUK) {
            ga(this.mnm);
        } else {
            this.mrQ.a((a) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, boolean z) {
        this.moY.d(cVar.dataSpec, cVar.type, this.lTu, cVar.moF, cVar.moG, cVar.moH, cVar.moI, cVar.moJ, j, j2, cVar.dum());
        if (!z) {
            duS();
            if (this.mnh > 0) {
                this.mrQ.a((a) this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, IOException iOException) {
        long dum = cVar.dum();
        boolean a2 = a(cVar);
        boolean z = false;
        if (this.mrR.a(cVar, !a2 || dum == 0, iOException)) {
            if (a2) {
                com.google.android.exoplayer2.util.a.checkState(this.mpa.removeLast() == cVar);
                if (this.mpa.isEmpty()) {
                    this.mnn = this.mnm;
                }
            }
            z = true;
        }
        this.moY.b(cVar.dataSpec, cVar.type, this.lTu, cVar.moF, cVar.moG, cVar.moH, cVar.moI, cVar.moJ, j, j2, cVar.dum(), iOException, z);
        if (z) {
            if (!this.lUK) {
                ga(this.mnm);
            } else {
                this.mrQ.a((a) this);
            }
            return 2;
        }
        return 0;
    }

    public void ae(int i, boolean z) {
        for (o oVar : this.mnb) {
            oVar.Kt(i);
        }
        if (z) {
            for (o oVar2 : this.mnb) {
                oVar2.due();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.g
    /* renamed from: dO */
    public o dJ(int i, int i2) {
        int length = this.mnb.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mnc[i3] == i) {
                return this.mnb[i3];
            }
        }
        o oVar = new o(this.mmS);
        oVar.gh(this.mom);
        oVar.a(this);
        this.mnc = Arrays.copyOf(this.mnc, length + 1);
        this.mnc[length] = i;
        this.mnb = (o[]) Arrays.copyOf(this.mnb, length + 1);
        this.mnb[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dst() {
        this.mnd = true;
        this.handler.post(this.mmY);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mmY);
    }

    public void gh(long j) {
        this.mom = j;
        for (o oVar : this.mnb) {
            oVar.gh(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtQ() {
        if (!this.released && !this.lUK && this.mnd) {
            for (o oVar : this.mnb) {
                if (oVar.dua() == null) {
                    return;
                }
            }
            duT();
            this.lUK = true;
            this.mrQ.onPrepared();
        }
    }

    private void duT() {
        char c;
        int length = this.mnb.length;
        int i = 0;
        int i2 = -1;
        char c2 = 0;
        while (i < length) {
            String str = this.mnb[i].dua().sampleMimeType;
            if (com.google.android.exoplayer2.util.i.Ot(str)) {
                c = 3;
            } else if (com.google.android.exoplayer2.util.i.PQ(str)) {
                c = 2;
            } else {
                c = com.google.android.exoplayer2.util.i.PR(str) ? (char) 1 : (char) 0;
            }
            if (c > c2) {
                i2 = i;
            } else if (c != c2 || i2 == -1) {
                c = c2;
            } else {
                i2 = -1;
                c = c2;
            }
            i++;
            c2 = c;
        }
        t duG = this.mrR.duG();
        int i3 = duG.length;
        this.mpw = -1;
        this.mrW = new boolean[length];
        this.mrX = new boolean[length];
        t[] tVarArr = new t[length];
        for (int i4 = 0; i4 < length; i4++) {
            Format dua = this.mnb[i4].dua();
            String str2 = dua.sampleMimeType;
            boolean z = com.google.android.exoplayer2.util.i.Ot(str2) || com.google.android.exoplayer2.util.i.PQ(str2);
            this.mrX[i4] = z;
            this.mrV = z | this.mrV;
            if (i4 == i2) {
                Format[] formatArr = new Format[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    formatArr[i5] = a(duG.KC(i5), dua);
                }
                tVarArr[i4] = new t(formatArr);
                this.mpw = i4;
            } else {
                tVarArr[i4] = new t(a((c2 == 3 && com.google.android.exoplayer2.util.i.PQ(dua.sampleMimeType)) ? this.mrS : null, dua));
            }
        }
        this.lUc = new u(tVarArr);
    }

    private void af(int i, boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mrW[i] != z);
        this.mrW[i] = z;
        this.mnh += z ? 1 : -1;
    }

    private static Format a(Format format, Format format2) {
        if (format != null) {
            String str = null;
            int PV = com.google.android.exoplayer2.util.i.PV(format2.sampleMimeType);
            if (PV == 1) {
                str = Pl(format.codecs);
            } else if (PV == 2) {
                str = Pm(format.codecs);
            }
            return format2.a(format.id, str, format.bitrate, format.width, format.height, format.selectionFlags, format.language);
        }
        return format2;
    }

    private boolean a(com.google.android.exoplayer2.source.a.c cVar) {
        return cVar instanceof h;
    }

    private boolean dtT() {
        return this.mnn != -9223372036854775807L;
    }

    private boolean gc(long j) {
        int length = this.mnb.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mnb[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mrX[i] || !this.mrV)) {
                return false;
            }
            oVar.duf();
        }
        return true;
    }

    private static String Pl(String str) {
        return bI(str, 1);
    }

    private static String Pm(String str) {
        return bI(str, 2);
    }

    private static String bI(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i == com.google.android.exoplayer2.util.i.PW(str2)) {
                if (sb.length() > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
