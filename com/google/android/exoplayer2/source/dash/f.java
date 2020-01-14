package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.a.i;
import com.google.android.exoplayer2.source.a.k;
import com.google.android.exoplayer2.source.a.l;
import com.google.android.exoplayer2.source.a.m;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.manifest.g;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f implements com.google.android.exoplayer2.source.dash.a {
    private final int lXq;
    private final com.google.android.exoplayer2.upstream.e mdo;
    private final long mtH;
    private final com.google.android.exoplayer2.b.f mtP;
    private final int mtQ;
    protected final b[] mtR;
    private IOException mtS;
    private boolean mtT;
    private long mtU;
    private final o mtk;
    private com.google.android.exoplayer2.source.dash.manifest.b mto;
    private final int[] mtp;
    private int periodIndex;

    /* loaded from: classes5.dex */
    public static final class a implements a.InterfaceC0671a {
        private final e.a mrr;
        private final int mtQ;

        public a(e.a aVar) {
            this(aVar, 1);
        }

        public a(e.a aVar, int i) {
            this.mrr = aVar;
            this.mtQ = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0671a
        public com.google.android.exoplayer2.source.dash.a a(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, long j, boolean z, boolean z2) {
            return new f(oVar, bVar, i, iArr, fVar, i2, this.mrr.dxJ(), j, this.mtQ, z, z2);
        }
    }

    public f(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, com.google.android.exoplayer2.upstream.e eVar, long j, int i3, boolean z, boolean z2) {
        this.mtk = oVar;
        this.mto = bVar;
        this.mtp = iArr;
        this.mtP = fVar;
        this.lXq = i2;
        this.mdo = eVar;
        this.periodIndex = i;
        this.mtH = j;
        this.mtQ = i3;
        long KW = bVar.KW(i);
        this.mtU = -9223372036854775807L;
        ArrayList<g> dvN = dvN();
        this.mtR = new b[fVar.length()];
        for (int i4 = 0; i4 < this.mtR.length; i4++) {
            this.mtR[i4] = new b(KW, i2, dvN.get(fVar.LB(i4)), z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        try {
            this.mto = bVar;
            this.periodIndex = i;
            long KW = this.mto.KW(this.periodIndex);
            ArrayList<g> dvN = dvN();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mtR.length) {
                    this.mtR[i3].a(KW, dvN.get(this.mtP.LB(i3)));
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } catch (BehindLiveWindowException e) {
            this.mtS = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void duZ() throws IOException {
        if (this.mtS != null) {
            throw this.mtS;
        }
        this.mtk.duZ();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int i;
        int i2;
        int dvE;
        if (this.mtS == null) {
            this.mtP.f(j, j2 - j, gt(j));
            b bVar = this.mtR[this.mtP.dvX()];
            if (bVar.mte != null) {
                g gVar = bVar.mtV;
                com.google.android.exoplayer2.source.dash.manifest.f fVar = null;
                com.google.android.exoplayer2.source.dash.manifest.f fVar2 = null;
                if (bVar.mte.dvB() == null) {
                    fVar = gVar.dvO();
                }
                if (bVar.mtW == null) {
                    fVar2 = gVar.dvP();
                }
                if (fVar != null || fVar2 != null) {
                    eVar.msM = a(bVar, this.mdo, this.mtP.dxl(), this.mtP.dvY(), this.mtP.dvZ(), fVar, fVar2);
                    return;
                }
            }
            int segmentCount = bVar.getSegmentCount();
            if (segmentCount == 0) {
                eVar.msN = !this.mto.mud || this.periodIndex < this.mto.dso() + (-1);
                return;
            }
            int dvL = bVar.dvL();
            if (segmentCount == -1) {
                long dvK = (dvK() - com.google.android.exoplayer2.b.fq(this.mto.mub)) - com.google.android.exoplayer2.b.fq(this.mto.KU(this.periodIndex).mut);
                if (this.mto.muf != -9223372036854775807L) {
                    dvL = Math.max(dvL, bVar.gu(dvK - com.google.android.exoplayer2.b.fq(this.mto.muf)));
                }
                int gu = bVar.gu(dvK) - 1;
                i = dvL;
                i2 = gu;
            } else {
                int i3 = (segmentCount + dvL) - 1;
                i = dvL;
                i2 = i3;
            }
            a(bVar, i2);
            if (lVar == null) {
                dvE = v.al(bVar.gu(j2), i, i2);
            } else {
                dvE = lVar.dvE();
                if (dvE < i) {
                    this.mtS = new BehindLiveWindowException();
                    return;
                }
            }
            if (dvE > i2 || (this.mtT && dvE >= i2)) {
                eVar.msN = !this.mto.mud || this.periodIndex < this.mto.dso() + (-1);
            } else {
                eVar.msM = a(bVar, this.mdo, this.lXq, this.mtP.dxl(), this.mtP.dvY(), this.mtP.dvZ(), dvE, Math.min(this.mtQ, (i2 - dvE) + 1));
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        com.google.android.exoplayer2.extractor.l dvA;
        if (cVar instanceof k) {
            b bVar = this.mtR[this.mtP.m(((k) cVar).msz)];
            if (bVar.mtW == null && (dvA = bVar.mte.dvA()) != null) {
                bVar.mtW = new e((com.google.android.exoplayer2.extractor.a) dvA);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        b bVar;
        int segmentCount;
        if (!z) {
            return false;
        }
        if (!this.mto.mud && (cVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (bVar = this.mtR[this.mtP.m(cVar.msz)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((l) cVar).dvE() > (bVar.dvL() + segmentCount) - 1) {
                this.mtT = true;
                return true;
            }
        }
        return h.a(this.mtP, this.mtP.m(cVar.msz), exc);
    }

    private ArrayList<g> dvN() {
        List<com.google.android.exoplayer2.source.dash.manifest.a> list = this.mto.KU(this.periodIndex).muu;
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i : this.mtp) {
            arrayList.addAll(list.get(i).mtY);
        }
        return arrayList;
    }

    private void a(b bVar, int i) {
        this.mtU = this.mto.mud ? bVar.KT(i) : -9223372036854775807L;
    }

    private long dvK() {
        return this.mtH != 0 ? (SystemClock.elapsedRealtime() + this.mtH) * 1000 : System.currentTimeMillis() * 1000;
    }

    private long gt(long j) {
        if (this.mto.mud && this.mtU != -9223372036854775807L) {
            return this.mtU - j;
        }
        return -9223372036854775807L;
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, Format format, int i, Object obj, com.google.android.exoplayer2.source.dash.manifest.f fVar, com.google.android.exoplayer2.source.dash.manifest.f fVar2) {
        String str = bVar.mtV.baseUrl;
        if (fVar != null) {
            com.google.android.exoplayer2.source.dash.manifest.f a2 = fVar.a(fVar2, str);
            if (a2 != null) {
                fVar = a2;
            }
        } else {
            fVar = fVar2;
        }
        return new k(eVar, new com.google.android.exoplayer2.upstream.g(fVar.Pt(str), fVar.start, fVar.length, bVar.mtV.getCacheKey()), format, i, obj, bVar.mte);
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, int i, Format format, int i2, Object obj, int i3, int i4) {
        com.google.android.exoplayer2.source.dash.manifest.f a2;
        g gVar = bVar.mtV;
        long KS = bVar.KS(i3);
        com.google.android.exoplayer2.source.dash.manifest.f KR = bVar.KR(i3);
        String str = gVar.baseUrl;
        if (bVar.mte == null) {
            return new m(eVar, new com.google.android.exoplayer2.upstream.g(KR.Pt(str), KR.start, KR.length, gVar.getCacheKey()), format, i2, obj, KS, bVar.KT(i3), i3, i, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i6 < i4 && (a2 = KR.a(bVar.KR(i3 + i6), str)) != null) {
            i5++;
            i6++;
            KR = a2;
        }
        return new i(eVar, new com.google.android.exoplayer2.upstream.g(KR.Pt(str), KR.start, KR.length, gVar.getCacheKey()), format, i2, obj, KS, bVar.KT((i3 + i5) - 1), i3, i5, -gVar.mux, bVar.mte);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static final class b {
        private long msq;
        public g mtV;
        public d mtW;
        private int mtX;
        final com.google.android.exoplayer2.source.a.d mte;

        b(long j, int i, g gVar, boolean z, boolean z2) {
            com.google.android.exoplayer2.extractor.e eVar;
            this.msq = j;
            this.mtV = gVar;
            String str = gVar.lYQ.containerMimeType;
            if (Ps(str)) {
                this.mte = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.e.a(gVar.lYQ);
                } else if (Pr(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.a.d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    eVar = new com.google.android.exoplayer2.extractor.c.e(z2 ? i2 | 8 : i2);
                }
                this.mte = new com.google.android.exoplayer2.source.a.d(eVar, i, gVar.lYQ);
            }
            this.mtW = gVar.dvQ();
        }

        void a(long j, g gVar) throws BehindLiveWindowException {
            int gs;
            d dvQ = this.mtV.dvQ();
            d dvQ2 = gVar.dvQ();
            this.msq = j;
            this.mtV = gVar;
            if (dvQ != null) {
                this.mtW = dvQ2;
                if (dvQ.dvM() && (gs = dvQ.gs(this.msq)) != 0) {
                    int dvL = (gs + dvQ.dvL()) - 1;
                    long KQ = dvQ.KQ(dvL) + dvQ.G(dvL, this.msq);
                    int dvL2 = dvQ2.dvL();
                    long KQ2 = dvQ2.KQ(dvL2);
                    if (KQ == KQ2) {
                        this.mtX += (dvL + 1) - dvL2;
                    } else if (KQ < KQ2) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.mtX = (dvQ.U(KQ2, this.msq) - dvL2) + this.mtX;
                    }
                }
            }
        }

        public int dvL() {
            return this.mtW.dvL() + this.mtX;
        }

        public int getSegmentCount() {
            return this.mtW.gs(this.msq);
        }

        public long KS(int i) {
            return this.mtW.KQ(i - this.mtX);
        }

        public long KT(int i) {
            return KS(i) + this.mtW.G(i - this.mtX, this.msq);
        }

        public int gu(long j) {
            return this.mtW.U(j, this.msq) + this.mtX;
        }

        public com.google.android.exoplayer2.source.dash.manifest.f KR(int i) {
            return this.mtW.KR(i - this.mtX);
        }

        private static boolean Pr(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean Ps(String str) {
            return com.google.android.exoplayer2.util.i.Qc(str) || "application/ttml+xml".equals(str);
        }
    }
}
