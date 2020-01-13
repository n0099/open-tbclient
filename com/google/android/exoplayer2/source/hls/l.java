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
    private u lXT;
    private final int lXl;
    private boolean lYB;
    private final int mqE;
    private final com.google.android.exoplayer2.upstream.b mqH;
    private boolean mqS;
    private boolean mqU;
    private int mqW;
    private long mrb;
    private long mrc;
    private boolean mre;
    private final b.a msN;
    private long msb;
    private int mtl;
    private final a mvF;
    private final d mvG;
    private final Format mvH;
    private Format mvJ;
    private boolean mvK;
    private boolean[] mvL;
    private boolean[] mvM;
    private boolean mvN;
    private boolean released;
    private final Loader mqK = new Loader("Loader:HlsSampleStreamWrapper");
    private final d.b mvI = new d.b();
    private int[] mqR = new int[0];
    private o[] mqQ = new o[0];
    private final LinkedList<h> msP = new LinkedList<>();
    private final Runnable mqN = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.dvb();
        }
    };
    private final Handler handler = new Handler();

    /* loaded from: classes5.dex */
    public interface a extends q.a<l> {
        void a(a.C0673a c0673a);

        void onPrepared();
    }

    public l(int i, a aVar, d dVar, com.google.android.exoplayer2.upstream.b bVar, long j, Format format, int i2, b.a aVar2) {
        this.lXl = i;
        this.mvF = aVar;
        this.mvG = dVar;
        this.mqH = bVar;
        this.mvH = format;
        this.mqE = i2;
        this.msN = aVar2;
        this.mrb = j;
        this.mrc = j;
    }

    public void dwc() {
        if (!this.lYB) {
            gf(this.mrb);
        }
    }

    public void o(Format format) {
        dH(0, -1).h(format);
        this.mqS = true;
        dvb();
    }

    public void duQ() throws IOException {
        duX();
    }

    public u duR() {
        return this.lXT;
    }

    public boolean a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        com.google.android.exoplayer2.util.a.checkState(this.lYB);
        int i = this.mqW;
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
        boolean z4 = z || (!this.mqU ? j == this.mrb : i != 0);
        com.google.android.exoplayer2.b.f dvS = this.mvG.dvS();
        boolean z5 = z4;
        int i4 = 0;
        com.google.android.exoplayer2.b.f fVar = dvS;
        while (i4 < fVarArr.length) {
            if (pVarArr[i4] == null && fVarArr[i4] != null) {
                com.google.android.exoplayer2.b.f fVar2 = fVarArr[i4];
                int a2 = this.lXT.a(fVar2.dvR());
                af(a2, true);
                if (a2 == this.mtl) {
                    this.mvG.b(fVar2);
                    fVar = fVar2;
                }
                pVarArr[i4] = new k(this, a2);
                zArr2[i4] = true;
                if (!z5) {
                    o oVar = this.mqQ[a2];
                    oVar.rewind();
                    z3 = oVar.a(j, true, true) == -1 && oVar.dvi() != 0;
                    i4++;
                    z5 = z3;
                }
            }
            z3 = z5;
            i4++;
            z5 = z3;
        }
        if (this.mqW == 0) {
            this.mvG.reset();
            this.mvJ = null;
            this.msP.clear();
            if (this.mqK.isLoading()) {
                for (o oVar2 : this.mqQ) {
                    oVar2.dvr();
                }
                this.mqK.cMb();
            } else {
                dwd();
            }
        } else {
            if (!this.msP.isEmpty() && !v.h(fVar, dvS)) {
                if (!this.mqU) {
                    fVar.f(j, j < 0 ? -j : 0L, -9223372036854775807L);
                    if (fVar.dxk() == this.mvG.dvR().m(this.msP.getLast().msu)) {
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
                    this.mvN = true;
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
        this.mqU = true;
        return z5;
    }

    public void gd(long j) {
        int length = this.mqQ.length;
        for (int i = 0; i < length; i++) {
            this.mqQ[i].c(j, false, this.mvL[i]);
        }
    }

    public boolean p(long j, boolean z) {
        this.mrb = j;
        if (z || dve() || !gh(j)) {
            this.mrc = j;
            this.mre = false;
            this.msP.clear();
            if (this.mqK.isLoading()) {
                this.mqK.cMb();
            } else {
                dwd();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long duT() {
        if (this.mre) {
            return Long.MIN_VALUE;
        }
        if (dve()) {
            return this.mrc;
        }
        long j = this.mrb;
        h last = this.msP.getLast();
        if (!last.dvD()) {
            last = this.msP.size() > 1 ? this.msP.get(this.msP.size() - 2) : null;
        }
        long max = last != null ? Math.max(j, last.msy) : j;
        o[] oVarArr = this.mqQ;
        int length = oVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, oVarArr[i].dvd());
            i++;
            max = max2;
        }
        return max;
    }

    public void release() {
        boolean a2 = this.mqK.a(this);
        if (this.lYB && !a2) {
            for (o oVar : this.mqQ) {
                oVar.dvr();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void duZ() {
        dwd();
    }

    public void vE(boolean z) {
        this.mvG.vE(z);
    }

    public void a(a.C0673a c0673a, long j) {
        this.mvG.a(c0673a, j);
    }

    public boolean Kz(int i) {
        return this.mre || (!dve() && this.mqQ[i].dvk());
    }

    public void duX() throws IOException {
        this.mqK.duX();
        this.mvG.duX();
    }

    public int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dve()) {
            return -3;
        }
        int a2 = this.mqQ[i].a(mVar, eVar, z, this.mre, this.mrb);
        if (a2 == -4) {
            dvq();
            return a2;
        }
        return a2;
    }

    public int F(int i, long j) {
        int i2 = 0;
        if (!dve()) {
            o oVar = this.mqQ[i];
            if (this.mre && j > oVar.dvd()) {
                i2 = oVar.dvm();
            } else {
                int a2 = oVar.a(j, true, true);
                if (a2 != -1) {
                    i2 = a2;
                }
            }
            if (i2 > 0) {
                dvq();
            }
        }
        return i2;
    }

    private void dvq() {
        if (!this.msP.isEmpty()) {
            while (this.msP.size() > 1 && a(this.msP.getFirst())) {
                this.msP.removeFirst();
            }
            h first = this.msP.getFirst();
            Format format = first.msu;
            if (!format.equals(this.mvJ)) {
                this.msN.b(this.lXl, format, first.msv, first.msw, first.msx);
            }
            this.mvJ = format;
        }
    }

    private boolean a(h hVar) {
        int i = hVar.uid;
        for (int i2 = 0; i2 < this.mqQ.length; i2++) {
            if (this.mvL[i2] && this.mqQ[i2].dvj() == i) {
                return false;
            }
        }
        return true;
    }

    private void dwd() {
        for (o oVar : this.mqQ) {
            oVar.reset(this.mvN);
        }
        this.mvN = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        long j2;
        h hVar;
        if (this.mre || this.mqK.isLoading()) {
            return false;
        }
        if (dve()) {
            hVar = null;
            j2 = this.mrc;
        } else {
            h last = this.msP.getLast();
            j2 = last.msy;
            hVar = last;
        }
        this.mvG.a(hVar, j, j2, this.mvI);
        boolean z = this.mvI.msI;
        com.google.android.exoplayer2.source.a.c cVar = this.mvI.msH;
        a.C0673a c0673a = this.mvI.mvf;
        this.mvI.clear();
        if (z) {
            this.mrc = -9223372036854775807L;
            this.mre = true;
            return true;
        } else if (cVar == null) {
            if (c0673a != null) {
                this.mvF.a(c0673a);
            }
            return false;
        } else {
            if (a(cVar)) {
                this.mrc = -9223372036854775807L;
                h hVar2 = (h) cVar;
                hVar2.a(this);
                this.msP.add(hVar2);
            }
            this.msN.b(cVar.dataSpec, cVar.type, this.lXl, cVar.msu, cVar.msv, cVar.msw, cVar.msx, cVar.msy, this.mqK.a(cVar, this, this.mqE));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long duU() {
        if (dve()) {
            return this.mrc;
        }
        if (this.mre) {
            return Long.MIN_VALUE;
        }
        return this.msP.getLast().msy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2) {
        this.mvG.b(cVar);
        this.msN.c(cVar.dataSpec, cVar.type, this.lXl, cVar.msu, cVar.msv, cVar.msw, cVar.msx, cVar.msy, j, j2, cVar.dvx());
        if (!this.lYB) {
            gf(this.mrb);
        } else {
            this.mvF.a((a) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, boolean z) {
        this.msN.d(cVar.dataSpec, cVar.type, this.lXl, cVar.msu, cVar.msv, cVar.msw, cVar.msx, cVar.msy, j, j2, cVar.dvx());
        if (!z) {
            dwd();
            if (this.mqW > 0) {
                this.mvF.a((a) this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, IOException iOException) {
        long dvx = cVar.dvx();
        boolean a2 = a(cVar);
        boolean z = false;
        if (this.mvG.a(cVar, !a2 || dvx == 0, iOException)) {
            if (a2) {
                com.google.android.exoplayer2.util.a.checkState(this.msP.removeLast() == cVar);
                if (this.msP.isEmpty()) {
                    this.mrc = this.mrb;
                }
            }
            z = true;
        }
        this.msN.b(cVar.dataSpec, cVar.type, this.lXl, cVar.msu, cVar.msv, cVar.msw, cVar.msx, cVar.msy, j, j2, cVar.dvx(), iOException, z);
        if (z) {
            if (!this.lYB) {
                gf(this.mrb);
            } else {
                this.mvF.a((a) this);
            }
            return 2;
        }
        return 0;
    }

    public void ae(int i, boolean z) {
        for (o oVar : this.mqQ) {
            oVar.KC(i);
        }
        if (z) {
            for (o oVar2 : this.mqQ) {
                oVar2.dvp();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.g
    /* renamed from: dM */
    public o dH(int i, int i2) {
        int length = this.mqQ.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mqR[i3] == i) {
                return this.mqQ[i3];
            }
        }
        o oVar = new o(this.mqH);
        oVar.gm(this.msb);
        oVar.a(this);
        this.mqR = Arrays.copyOf(this.mqR, length + 1);
        this.mqR[length] = i;
        this.mqQ = (o[]) Arrays.copyOf(this.mqQ, length + 1);
        this.mqQ[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dtF() {
        this.mqS = true;
        this.handler.post(this.mqN);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mqN);
    }

    public void gm(long j) {
        this.msb = j;
        for (o oVar : this.mqQ) {
            oVar.gm(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvb() {
        if (!this.released && !this.lYB && this.mqS) {
            for (o oVar : this.mqQ) {
                if (oVar.dvl() == null) {
                    return;
                }
            }
            dwe();
            this.lYB = true;
            this.mvF.onPrepared();
        }
    }

    private void dwe() {
        char c;
        int length = this.mqQ.length;
        int i = 0;
        int i2 = -1;
        char c2 = 0;
        while (i < length) {
            String str = this.mqQ[i].dvl().sampleMimeType;
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
        t dvR = this.mvG.dvR();
        int i3 = dvR.length;
        this.mtl = -1;
        this.mvL = new boolean[length];
        this.mvM = new boolean[length];
        t[] tVarArr = new t[length];
        for (int i4 = 0; i4 < length; i4++) {
            Format dvl = this.mqQ[i4].dvl();
            String str2 = dvl.sampleMimeType;
            boolean z = com.google.android.exoplayer2.util.i.OD(str2) || com.google.android.exoplayer2.util.i.Qb(str2);
            this.mvM[i4] = z;
            this.mvK = z | this.mvK;
            if (i4 == i2) {
                Format[] formatArr = new Format[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    formatArr[i5] = a(dvR.KL(i5), dvl);
                }
                tVarArr[i4] = new t(formatArr);
                this.mtl = i4;
            } else {
                tVarArr[i4] = new t(a((c2 == 3 && com.google.android.exoplayer2.util.i.Qb(dvl.sampleMimeType)) ? this.mvH : null, dvl));
            }
        }
        this.lXT = new u(tVarArr);
    }

    private void af(int i, boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mvL[i] != z);
        this.mvL[i] = z;
        this.mqW += z ? 1 : -1;
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

    private boolean dve() {
        return this.mrc != -9223372036854775807L;
    }

    private boolean gh(long j) {
        int length = this.mqQ.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mqQ[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mvM[i] || !this.mvK)) {
                return false;
            }
            oVar.dvq();
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
