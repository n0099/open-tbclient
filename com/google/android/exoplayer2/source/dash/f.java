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
    private final int lXl;
    private final com.google.android.exoplayer2.upstream.e mdj;
    private final long mtC;
    private final com.google.android.exoplayer2.b.f mtK;
    private final int mtL;
    protected final b[] mtM;
    private IOException mtN;
    private boolean mtO;
    private long mtP;
    private final o mtf;
    private com.google.android.exoplayer2.source.dash.manifest.b mtj;
    private final int[] mtk;
    private int periodIndex;

    /* loaded from: classes5.dex */
    public static final class a implements a.InterfaceC0671a {
        private final e.a mrm;
        private final int mtL;

        public a(e.a aVar) {
            this(aVar, 1);
        }

        public a(e.a aVar, int i) {
            this.mrm = aVar;
            this.mtL = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0671a
        public com.google.android.exoplayer2.source.dash.a a(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, long j, boolean z, boolean z2) {
            return new f(oVar, bVar, i, iArr, fVar, i2, this.mrm.dxH(), j, this.mtL, z, z2);
        }
    }

    public f(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, com.google.android.exoplayer2.upstream.e eVar, long j, int i3, boolean z, boolean z2) {
        this.mtf = oVar;
        this.mtj = bVar;
        this.mtk = iArr;
        this.mtK = fVar;
        this.lXl = i2;
        this.mdj = eVar;
        this.periodIndex = i;
        this.mtC = j;
        this.mtL = i3;
        long KW = bVar.KW(i);
        this.mtP = -9223372036854775807L;
        ArrayList<g> dvL = dvL();
        this.mtM = new b[fVar.length()];
        for (int i4 = 0; i4 < this.mtM.length; i4++) {
            this.mtM[i4] = new b(KW, i2, dvL.get(fVar.LB(i4)), z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        try {
            this.mtj = bVar;
            this.periodIndex = i;
            long KW = this.mtj.KW(this.periodIndex);
            ArrayList<g> dvL = dvL();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mtM.length) {
                    this.mtM[i3].a(KW, dvL.get(this.mtK.LB(i3)));
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } catch (BehindLiveWindowException e) {
            this.mtN = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void duX() throws IOException {
        if (this.mtN != null) {
            throw this.mtN;
        }
        this.mtf.duX();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int i;
        int i2;
        int dvC;
        if (this.mtN == null) {
            this.mtK.f(j, j2 - j, gt(j));
            b bVar = this.mtM[this.mtK.dvV()];
            if (bVar.msZ != null) {
                g gVar = bVar.mtQ;
                com.google.android.exoplayer2.source.dash.manifest.f fVar = null;
                com.google.android.exoplayer2.source.dash.manifest.f fVar2 = null;
                if (bVar.msZ.dvz() == null) {
                    fVar = gVar.dvM();
                }
                if (bVar.mtR == null) {
                    fVar2 = gVar.dvN();
                }
                if (fVar != null || fVar2 != null) {
                    eVar.msH = a(bVar, this.mdj, this.mtK.dxj(), this.mtK.dvW(), this.mtK.dvX(), fVar, fVar2);
                    return;
                }
            }
            int segmentCount = bVar.getSegmentCount();
            if (segmentCount == 0) {
                eVar.msI = !this.mtj.mtY || this.periodIndex < this.mtj.dsm() + (-1);
                return;
            }
            int dvJ = bVar.dvJ();
            if (segmentCount == -1) {
                long dvI = (dvI() - com.google.android.exoplayer2.b.fq(this.mtj.mtW)) - com.google.android.exoplayer2.b.fq(this.mtj.KU(this.periodIndex).muo);
                if (this.mtj.mua != -9223372036854775807L) {
                    dvJ = Math.max(dvJ, bVar.gu(dvI - com.google.android.exoplayer2.b.fq(this.mtj.mua)));
                }
                int gu = bVar.gu(dvI) - 1;
                i = dvJ;
                i2 = gu;
            } else {
                int i3 = (segmentCount + dvJ) - 1;
                i = dvJ;
                i2 = i3;
            }
            a(bVar, i2);
            if (lVar == null) {
                dvC = v.al(bVar.gu(j2), i, i2);
            } else {
                dvC = lVar.dvC();
                if (dvC < i) {
                    this.mtN = new BehindLiveWindowException();
                    return;
                }
            }
            if (dvC > i2 || (this.mtO && dvC >= i2)) {
                eVar.msI = !this.mtj.mtY || this.periodIndex < this.mtj.dsm() + (-1);
            } else {
                eVar.msH = a(bVar, this.mdj, this.lXl, this.mtK.dxj(), this.mtK.dvW(), this.mtK.dvX(), dvC, Math.min(this.mtL, (i2 - dvC) + 1));
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        com.google.android.exoplayer2.extractor.l dvy;
        if (cVar instanceof k) {
            b bVar = this.mtM[this.mtK.m(((k) cVar).msu)];
            if (bVar.mtR == null && (dvy = bVar.msZ.dvy()) != null) {
                bVar.mtR = new e((com.google.android.exoplayer2.extractor.a) dvy);
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
        if (!this.mtj.mtY && (cVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (bVar = this.mtM[this.mtK.m(cVar.msu)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((l) cVar).dvC() > (bVar.dvJ() + segmentCount) - 1) {
                this.mtO = true;
                return true;
            }
        }
        return h.a(this.mtK, this.mtK.m(cVar.msu), exc);
    }

    private ArrayList<g> dvL() {
        List<com.google.android.exoplayer2.source.dash.manifest.a> list = this.mtj.KU(this.periodIndex).mup;
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i : this.mtk) {
            arrayList.addAll(list.get(i).mtT);
        }
        return arrayList;
    }

    private void a(b bVar, int i) {
        this.mtP = this.mtj.mtY ? bVar.KT(i) : -9223372036854775807L;
    }

    private long dvI() {
        return this.mtC != 0 ? (SystemClock.elapsedRealtime() + this.mtC) * 1000 : System.currentTimeMillis() * 1000;
    }

    private long gt(long j) {
        if (this.mtj.mtY && this.mtP != -9223372036854775807L) {
            return this.mtP - j;
        }
        return -9223372036854775807L;
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, Format format, int i, Object obj, com.google.android.exoplayer2.source.dash.manifest.f fVar, com.google.android.exoplayer2.source.dash.manifest.f fVar2) {
        String str = bVar.mtQ.baseUrl;
        if (fVar != null) {
            com.google.android.exoplayer2.source.dash.manifest.f a2 = fVar.a(fVar2, str);
            if (a2 != null) {
                fVar = a2;
            }
        } else {
            fVar = fVar2;
        }
        return new k(eVar, new com.google.android.exoplayer2.upstream.g(fVar.Pt(str), fVar.start, fVar.length, bVar.mtQ.getCacheKey()), format, i, obj, bVar.msZ);
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, int i, Format format, int i2, Object obj, int i3, int i4) {
        com.google.android.exoplayer2.source.dash.manifest.f a2;
        g gVar = bVar.mtQ;
        long KS = bVar.KS(i3);
        com.google.android.exoplayer2.source.dash.manifest.f KR = bVar.KR(i3);
        String str = gVar.baseUrl;
        if (bVar.msZ == null) {
            return new m(eVar, new com.google.android.exoplayer2.upstream.g(KR.Pt(str), KR.start, KR.length, gVar.getCacheKey()), format, i2, obj, KS, bVar.KT(i3), i3, i, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i6 < i4 && (a2 = KR.a(bVar.KR(i3 + i6), str)) != null) {
            i5++;
            i6++;
            KR = a2;
        }
        return new i(eVar, new com.google.android.exoplayer2.upstream.g(KR.Pt(str), KR.start, KR.length, gVar.getCacheKey()), format, i2, obj, KS, bVar.KT((i3 + i5) - 1), i3, i5, -gVar.mus, bVar.msZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static final class b {
        final com.google.android.exoplayer2.source.a.d msZ;
        private long msl;
        public g mtQ;
        public d mtR;
        private int mtS;

        b(long j, int i, g gVar, boolean z, boolean z2) {
            com.google.android.exoplayer2.extractor.e eVar;
            this.msl = j;
            this.mtQ = gVar;
            String str = gVar.lYL.containerMimeType;
            if (Ps(str)) {
                this.msZ = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.e.a(gVar.lYL);
                } else if (Pr(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.a.d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    eVar = new com.google.android.exoplayer2.extractor.c.e(z2 ? i2 | 8 : i2);
                }
                this.msZ = new com.google.android.exoplayer2.source.a.d(eVar, i, gVar.lYL);
            }
            this.mtR = gVar.dvO();
        }

        void a(long j, g gVar) throws BehindLiveWindowException {
            int gs;
            d dvO = this.mtQ.dvO();
            d dvO2 = gVar.dvO();
            this.msl = j;
            this.mtQ = gVar;
            if (dvO != null) {
                this.mtR = dvO2;
                if (dvO.dvK() && (gs = dvO.gs(this.msl)) != 0) {
                    int dvJ = (gs + dvO.dvJ()) - 1;
                    long KQ = dvO.KQ(dvJ) + dvO.G(dvJ, this.msl);
                    int dvJ2 = dvO2.dvJ();
                    long KQ2 = dvO2.KQ(dvJ2);
                    if (KQ == KQ2) {
                        this.mtS += (dvJ + 1) - dvJ2;
                    } else if (KQ < KQ2) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.mtS = (dvO.U(KQ2, this.msl) - dvJ2) + this.mtS;
                    }
                }
            }
        }

        public int dvJ() {
            return this.mtR.dvJ() + this.mtS;
        }

        public int getSegmentCount() {
            return this.mtR.gs(this.msl);
        }

        public long KS(int i) {
            return this.mtR.KQ(i - this.mtS);
        }

        public long KT(int i) {
            return KS(i) + this.mtR.G(i - this.mtS, this.msl);
        }

        public int gu(long j) {
            return this.mtR.U(j, this.msl) + this.mtS;
        }

        public com.google.android.exoplayer2.source.dash.manifest.f KR(int i) {
            return this.mtR.KR(i - this.mtS);
        }

        private static boolean Pr(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean Ps(String str) {
            return com.google.android.exoplayer2.util.i.Qc(str) || "application/ttml+xml".equals(str);
        }
    }
}
