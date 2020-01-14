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
/* loaded from: classes5.dex */
public final class l implements com.google.android.exoplayer2.extractor.g, o.b, q, Loader.a<com.google.android.exoplayer2.source.a.c>, Loader.d {
    private u lXY;
    private final int lXq;
    private boolean lYG;
    private final int mqJ;
    private final com.google.android.exoplayer2.upstream.b mqM;
    private boolean mqX;
    private boolean mqZ;
    private int mrb;
    private long mrg;
    private long mrh;
    private boolean mrj;
    private final b.a msS;
    private long msh;
    private int mtq;
    private final a mvK;
    private final d mvL;
    private final Format mvM;
    private Format mvO;
    private boolean mvP;
    private boolean[] mvQ;
    private boolean[] mvR;
    private boolean mvS;
    private boolean released;
    private final Loader mqP = new Loader("Loader:HlsSampleStreamWrapper");
    private final d.b mvN = new d.b();
    private int[] mqW = new int[0];
    private o[] mqV = new o[0];
    private final LinkedList<h> msU = new LinkedList<>();
    private final Runnable mqS = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.dvd();
        }
    };
    private final Handler handler = new Handler();

    /* loaded from: classes5.dex */
    public interface a extends q.a<l> {
        void a(a.C0673a c0673a);

        void onPrepared();
    }

    public l(int i, a aVar, d dVar, com.google.android.exoplayer2.upstream.b bVar, long j, Format format, int i2, b.a aVar2) {
        this.lXq = i;
        this.mvK = aVar;
        this.mvL = dVar;
        this.mqM = bVar;
        this.mvM = format;
        this.mqJ = i2;
        this.msS = aVar2;
        this.mrg = j;
        this.mrh = j;
    }

    public void dwe() {
        if (!this.lYG) {
            gf(this.mrg);
        }
    }

    public void o(Format format) {
        dH(0, -1).h(format);
        this.mqX = true;
        dvd();
    }

    public void duS() throws IOException {
        duZ();
    }

    public u duT() {
        return this.lXY;
    }

    public boolean a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        com.google.android.exoplayer2.util.a.checkState(this.lYG);
        int i = this.mrb;
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
        boolean z4 = z || (!this.mqZ ? j == this.mrg : i != 0);
        com.google.android.exoplayer2.b.f dvU = this.mvL.dvU();
        boolean z5 = z4;
        int i4 = 0;
        com.google.android.exoplayer2.b.f fVar = dvU;
        while (i4 < fVarArr.length) {
            if (pVarArr[i4] == null && fVarArr[i4] != null) {
                com.google.android.exoplayer2.b.f fVar2 = fVarArr[i4];
                int a2 = this.lXY.a(fVar2.dvT());
                af(a2, true);
                if (a2 == this.mtq) {
                    this.mvL.b(fVar2);
                    fVar = fVar2;
                }
                pVarArr[i4] = new k(this, a2);
                zArr2[i4] = true;
                if (!z5) {
                    o oVar = this.mqV[a2];
                    oVar.rewind();
                    z3 = oVar.a(j, true, true) == -1 && oVar.dvk() != 0;
                    i4++;
                    z5 = z3;
                }
            }
            z3 = z5;
            i4++;
            z5 = z3;
        }
        if (this.mrb == 0) {
            this.mvL.reset();
            this.mvO = null;
            this.msU.clear();
            if (this.mqP.isLoading()) {
                for (o oVar2 : this.mqV) {
                    oVar2.dvt();
                }
                this.mqP.cMd();
            } else {
                dwf();
            }
        } else {
            if (!this.msU.isEmpty() && !v.h(fVar, dvU)) {
                if (!this.mqZ) {
                    fVar.f(j, j < 0 ? -j : 0L, -9223372036854775807L);
                    if (fVar.dxm() == this.mvL.dvT().m(this.msU.getLast().msz)) {
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
                    this.mvS = true;
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
        this.mqZ = true;
        return z5;
    }

    public void gd(long j) {
        int length = this.mqV.length;
        for (int i = 0; i < length; i++) {
            this.mqV[i].c(j, false, this.mvQ[i]);
        }
    }

    public boolean p(long j, boolean z) {
        this.mrg = j;
        if (z || dvg() || !gh(j)) {
            this.mrh = j;
            this.mrj = false;
            this.msU.clear();
            if (this.mqP.isLoading()) {
                this.mqP.cMd();
            } else {
                dwf();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long duV() {
        if (this.mrj) {
            return Long.MIN_VALUE;
        }
        if (dvg()) {
            return this.mrh;
        }
        long j = this.mrg;
        h last = this.msU.getLast();
        if (!last.dvF()) {
            last = this.msU.size() > 1 ? this.msU.get(this.msU.size() - 2) : null;
        }
        long max = last != null ? Math.max(j, last.msD) : j;
        o[] oVarArr = this.mqV;
        int length = oVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, oVarArr[i].dvf());
            i++;
            max = max2;
        }
        return max;
    }

    public void release() {
        boolean a2 = this.mqP.a(this);
        if (this.lYG && !a2) {
            for (o oVar : this.mqV) {
                oVar.dvt();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dvb() {
        dwf();
    }

    public void vE(boolean z) {
        this.mvL.vE(z);
    }

    public void a(a.C0673a c0673a, long j) {
        this.mvL.a(c0673a, j);
    }

    public boolean Kz(int i) {
        return this.mrj || (!dvg() && this.mqV[i].dvm());
    }

    public void duZ() throws IOException {
        this.mqP.duZ();
        this.mvL.duZ();
    }

    public int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dvg()) {
            return -3;
        }
        int a2 = this.mqV[i].a(mVar, eVar, z, this.mrj, this.mrg);
        if (a2 == -4) {
            dvs();
            return a2;
        }
        return a2;
    }

    public int F(int i, long j) {
        int i2 = 0;
        if (!dvg()) {
            o oVar = this.mqV[i];
            if (this.mrj && j > oVar.dvf()) {
                i2 = oVar.dvo();
            } else {
                int a2 = oVar.a(j, true, true);
                if (a2 != -1) {
                    i2 = a2;
                }
            }
            if (i2 > 0) {
                dvs();
            }
        }
        return i2;
    }

    private void dvs() {
        if (!this.msU.isEmpty()) {
            while (this.msU.size() > 1 && a(this.msU.getFirst())) {
                this.msU.removeFirst();
            }
            h first = this.msU.getFirst();
            Format format = first.msz;
            if (!format.equals(this.mvO)) {
                this.msS.b(this.lXq, format, first.msA, first.msB, first.msC);
            }
            this.mvO = format;
        }
    }

    private boolean a(h hVar) {
        int i = hVar.uid;
        for (int i2 = 0; i2 < this.mqV.length; i2++) {
            if (this.mvQ[i2] && this.mqV[i2].dvl() == i) {
                return false;
            }
        }
        return true;
    }

    private void dwf() {
        for (o oVar : this.mqV) {
            oVar.reset(this.mvS);
        }
        this.mvS = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        long j2;
        h hVar;
        if (this.mrj || this.mqP.isLoading()) {
            return false;
        }
        if (dvg()) {
            hVar = null;
            j2 = this.mrh;
        } else {
            h last = this.msU.getLast();
            j2 = last.msD;
            hVar = last;
        }
        this.mvL.a(hVar, j, j2, this.mvN);
        boolean z = this.mvN.msN;
        com.google.android.exoplayer2.source.a.c cVar = this.mvN.msM;
        a.C0673a c0673a = this.mvN.mvk;
        this.mvN.clear();
        if (z) {
            this.mrh = -9223372036854775807L;
            this.mrj = true;
            return true;
        } else if (cVar == null) {
            if (c0673a != null) {
                this.mvK.a(c0673a);
            }
            return false;
        } else {
            if (a(cVar)) {
                this.mrh = -9223372036854775807L;
                h hVar2 = (h) cVar;
                hVar2.a(this);
                this.msU.add(hVar2);
            }
            this.msS.b(cVar.dataSpec, cVar.type, this.lXq, cVar.msz, cVar.msA, cVar.msB, cVar.msC, cVar.msD, this.mqP.a(cVar, this, this.mqJ));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long duW() {
        if (dvg()) {
            return this.mrh;
        }
        if (this.mrj) {
            return Long.MIN_VALUE;
        }
        return this.msU.getLast().msD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2) {
        this.mvL.b(cVar);
        this.msS.c(cVar.dataSpec, cVar.type, this.lXq, cVar.msz, cVar.msA, cVar.msB, cVar.msC, cVar.msD, j, j2, cVar.dvz());
        if (!this.lYG) {
            gf(this.mrg);
        } else {
            this.mvK.a((a) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, boolean z) {
        this.msS.d(cVar.dataSpec, cVar.type, this.lXq, cVar.msz, cVar.msA, cVar.msB, cVar.msC, cVar.msD, j, j2, cVar.dvz());
        if (!z) {
            dwf();
            if (this.mrb > 0) {
                this.mvK.a((a) this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, IOException iOException) {
        long dvz = cVar.dvz();
        boolean a2 = a(cVar);
        boolean z = false;
        if (this.mvL.a(cVar, !a2 || dvz == 0, iOException)) {
            if (a2) {
                com.google.android.exoplayer2.util.a.checkState(this.msU.removeLast() == cVar);
                if (this.msU.isEmpty()) {
                    this.mrh = this.mrg;
                }
            }
            z = true;
        }
        this.msS.b(cVar.dataSpec, cVar.type, this.lXq, cVar.msz, cVar.msA, cVar.msB, cVar.msC, cVar.msD, j, j2, cVar.dvz(), iOException, z);
        if (z) {
            if (!this.lYG) {
                gf(this.mrg);
            } else {
                this.mvK.a((a) this);
            }
            return 2;
        }
        return 0;
    }

    public void ae(int i, boolean z) {
        for (o oVar : this.mqV) {
            oVar.KC(i);
        }
        if (z) {
            for (o oVar2 : this.mqV) {
                oVar2.dvr();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.g
    /* renamed from: dM */
    public o dH(int i, int i2) {
        int length = this.mqV.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mqW[i3] == i) {
                return this.mqV[i3];
            }
        }
        o oVar = new o(this.mqM);
        oVar.gm(this.msh);
        oVar.a(this);
        this.mqW = Arrays.copyOf(this.mqW, length + 1);
        this.mqW[length] = i;
        this.mqV = (o[]) Arrays.copyOf(this.mqV, length + 1);
        this.mqV[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dtH() {
        this.mqX = true;
        this.handler.post(this.mqS);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mqS);
    }

    public void gm(long j) {
        this.msh = j;
        for (o oVar : this.mqV) {
            oVar.gm(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvd() {
        if (!this.released && !this.lYG && this.mqX) {
            for (o oVar : this.mqV) {
                if (oVar.dvn() == null) {
                    return;
                }
            }
            dwg();
            this.lYG = true;
            this.mvK.onPrepared();
        }
    }

    private void dwg() {
        char c;
        int length = this.mqV.length;
        int i = 0;
        int i2 = -1;
        char c2 = 0;
        while (i < length) {
            String str = this.mqV[i].dvn().sampleMimeType;
            if (com.google.android.exoplayer2.util.i.OD(str)) {
                c = 3;
            } else if (com.google.android.exoplayer2.util.i.Qb(str)) {
                c = 2;
            } else {
                c = com.google.android.exoplayer2.util.i.Qc(str) ? (char) 1 : (char) 0;
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
        t dvT = this.mvL.dvT();
        int i3 = dvT.length;
        this.mtq = -1;
        this.mvQ = new boolean[length];
        this.mvR = new boolean[length];
        t[] tVarArr = new t[length];
        for (int i4 = 0; i4 < length; i4++) {
            Format dvn = this.mqV[i4].dvn();
            String str2 = dvn.sampleMimeType;
            boolean z = com.google.android.exoplayer2.util.i.OD(str2) || com.google.android.exoplayer2.util.i.Qb(str2);
            this.mvR[i4] = z;
            this.mvP = z | this.mvP;
            if (i4 == i2) {
                Format[] formatArr = new Format[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    formatArr[i5] = a(dvT.KL(i5), dvn);
                }
                tVarArr[i4] = new t(formatArr);
                this.mtq = i4;
            } else {
                tVarArr[i4] = new t(a((c2 == 3 && com.google.android.exoplayer2.util.i.Qb(dvn.sampleMimeType)) ? this.mvM : null, dvn));
            }
        }
        this.lXY = new u(tVarArr);
    }

    private void af(int i, boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mvQ[i] != z);
        this.mvQ[i] = z;
        this.mrb += z ? 1 : -1;
    }

    private static Format a(Format format, Format format2) {
        if (format != null) {
            String str = null;
            int Qg = com.google.android.exoplayer2.util.i.Qg(format2.sampleMimeType);
            if (Qg == 1) {
                str = Pw(format.codecs);
            } else if (Qg == 2) {
                str = Px(format.codecs);
            }
            return format2.a(format.id, str, format.bitrate, format.width, format.height, format.selectionFlags, format.language);
        }
        return format2;
    }

    private boolean a(com.google.android.exoplayer2.source.a.c cVar) {
        return cVar instanceof h;
    }

    private boolean dvg() {
        return this.mrh != -9223372036854775807L;
    }

    private boolean gh(long j) {
        int length = this.mqV.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mqV[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mvR[i] || !this.mvP)) {
                return false;
            }
            oVar.dvs();
        }
        return true;
    }

    private static String Pw(String str) {
        return bJ(str, 1);
    }

    private static String Px(String str) {
        return bJ(str, 2);
    }

    private static String bJ(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i == com.google.android.exoplayer2.util.i.Qh(str2)) {
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
