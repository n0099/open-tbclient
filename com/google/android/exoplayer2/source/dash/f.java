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
/* loaded from: classes6.dex */
public class f implements com.google.android.exoplayer2.source.dash.a {
    private final int lZP;
    private final com.google.android.exoplayer2.upstream.e mfN;
    private final o mvK;
    private com.google.android.exoplayer2.source.dash.manifest.b mvO;
    private final int[] mvP;
    private final long mwg;
    private final com.google.android.exoplayer2.b.f mwo;
    private final int mwp;
    protected final b[] mwq;
    private IOException mwr;
    private boolean mws;
    private long mwt;
    private int periodIndex;

    /* loaded from: classes6.dex */
    public static final class a implements a.InterfaceC0680a {
        private final e.a mtS;
        private final int mwp;

        public a(e.a aVar) {
            this(aVar, 1);
        }

        public a(e.a aVar, int i) {
            this.mtS = aVar;
            this.mwp = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0680a
        public com.google.android.exoplayer2.source.dash.a a(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, long j, boolean z, boolean z2) {
            return new f(oVar, bVar, i, iArr, fVar, i2, this.mtS.dzt(), j, this.mwp, z, z2);
        }
    }

    public f(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, com.google.android.exoplayer2.upstream.e eVar, long j, int i3, boolean z, boolean z2) {
        this.mvK = oVar;
        this.mvO = bVar;
        this.mvP = iArr;
        this.mwo = fVar;
        this.lZP = i2;
        this.mfN = eVar;
        this.periodIndex = i;
        this.mwg = j;
        this.mwp = i3;
        long Lh = bVar.Lh(i);
        this.mwt = -9223372036854775807L;
        ArrayList<g> dxx = dxx();
        this.mwq = new b[fVar.length()];
        for (int i4 = 0; i4 < this.mwq.length; i4++) {
            this.mwq[i4] = new b(Lh, i2, dxx.get(fVar.LM(i4)), z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        try {
            this.mvO = bVar;
            this.periodIndex = i;
            long Lh = this.mvO.Lh(this.periodIndex);
            ArrayList<g> dxx = dxx();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mwq.length) {
                    this.mwq[i3].a(Lh, dxx.get(this.mwo.LM(i3)));
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } catch (BehindLiveWindowException e) {
            this.mwr = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dwJ() throws IOException {
        if (this.mwr != null) {
            throw this.mwr;
        }
        this.mvK.dwJ();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int i;
        int i2;
        int dxo;
        if (this.mwr == null) {
            this.mwo.g(j, j2 - j, gs(j));
            b bVar = this.mwq[this.mwo.dxH()];
            if (bVar.mvE != null) {
                g gVar = bVar.mwu;
                com.google.android.exoplayer2.source.dash.manifest.f fVar = null;
                com.google.android.exoplayer2.source.dash.manifest.f fVar2 = null;
                if (bVar.mvE.dxl() == null) {
                    fVar = gVar.dxy();
                }
                if (bVar.mwv == null) {
                    fVar2 = gVar.dxz();
                }
                if (fVar != null || fVar2 != null) {
                    eVar.mvm = a(bVar, this.mfN, this.mwo.dyV(), this.mwo.dxI(), this.mwo.dxJ(), fVar, fVar2);
                    return;
                }
            }
            int segmentCount = bVar.getSegmentCount();
            if (segmentCount == 0) {
                eVar.mvn = !this.mvO.mwC || this.periodIndex < this.mvO.dua() + (-1);
                return;
            }
            int dxv = bVar.dxv();
            if (segmentCount == -1) {
                long dxu = (dxu() - com.google.android.exoplayer2.b.fp(this.mvO.mwA)) - com.google.android.exoplayer2.b.fp(this.mvO.Lf(this.periodIndex).mwS);
                if (this.mvO.mwE != -9223372036854775807L) {
                    dxv = Math.max(dxv, bVar.gt(dxu - com.google.android.exoplayer2.b.fp(this.mvO.mwE)));
                }
                int gt = bVar.gt(dxu) - 1;
                i = dxv;
                i2 = gt;
            } else {
                int i3 = (segmentCount + dxv) - 1;
                i = dxv;
                i2 = i3;
            }
            a(bVar, i2);
            if (lVar == null) {
                dxo = v.am(bVar.gt(j2), i, i2);
            } else {
                dxo = lVar.dxo();
                if (dxo < i) {
                    this.mwr = new BehindLiveWindowException();
                    return;
                }
            }
            if (dxo > i2 || (this.mws && dxo >= i2)) {
                eVar.mvn = !this.mvO.mwC || this.periodIndex < this.mvO.dua() + (-1);
            } else {
                eVar.mvm = a(bVar, this.mfN, this.lZP, this.mwo.dyV(), this.mwo.dxI(), this.mwo.dxJ(), dxo, Math.min(this.mwp, (i2 - dxo) + 1));
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        com.google.android.exoplayer2.extractor.l dxk;
        if (cVar instanceof k) {
            b bVar = this.mwq[this.mwo.m(((k) cVar).muZ)];
            if (bVar.mwv == null && (dxk = bVar.mvE.dxk()) != null) {
                bVar.mwv = new e((com.google.android.exoplayer2.extractor.a) dxk);
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
        if (!this.mvO.mwC && (cVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (bVar = this.mwq[this.mwo.m(cVar.muZ)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((l) cVar).dxo() > (bVar.dxv() + segmentCount) - 1) {
                this.mws = true;
                return true;
            }
        }
        return h.a(this.mwo, this.mwo.m(cVar.muZ), exc);
    }

    private ArrayList<g> dxx() {
        List<com.google.android.exoplayer2.source.dash.manifest.a> list = this.mvO.Lf(this.periodIndex).mwT;
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i : this.mvP) {
            arrayList.addAll(list.get(i).mwx);
        }
        return arrayList;
    }

    private void a(b bVar, int i) {
        this.mwt = this.mvO.mwC ? bVar.Le(i) : -9223372036854775807L;
    }

    private long dxu() {
        return this.mwg != 0 ? (SystemClock.elapsedRealtime() + this.mwg) * 1000 : System.currentTimeMillis() * 1000;
    }

    private long gs(long j) {
        if (this.mvO.mwC && this.mwt != -9223372036854775807L) {
            return this.mwt - j;
        }
        return -9223372036854775807L;
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, Format format, int i, Object obj, com.google.android.exoplayer2.source.dash.manifest.f fVar, com.google.android.exoplayer2.source.dash.manifest.f fVar2) {
        String str = bVar.mwu.baseUrl;
        if (fVar != null) {
            com.google.android.exoplayer2.source.dash.manifest.f a2 = fVar.a(fVar2, str);
            if (a2 != null) {
                fVar = a2;
            }
        } else {
            fVar = fVar2;
        }
        return new k(eVar, new com.google.android.exoplayer2.upstream.g(fVar.PH(str), fVar.start, fVar.length, bVar.mwu.getCacheKey()), format, i, obj, bVar.mvE);
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, int i, Format format, int i2, Object obj, int i3, int i4) {
        com.google.android.exoplayer2.source.dash.manifest.f a2;
        g gVar = bVar.mwu;
        long Ld = bVar.Ld(i3);
        com.google.android.exoplayer2.source.dash.manifest.f Lc = bVar.Lc(i3);
        String str = gVar.baseUrl;
        if (bVar.mvE == null) {
            return new m(eVar, new com.google.android.exoplayer2.upstream.g(Lc.PH(str), Lc.start, Lc.length, gVar.getCacheKey()), format, i2, obj, Ld, bVar.Le(i3), i3, i, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i6 < i4 && (a2 = Lc.a(bVar.Lc(i3 + i6), str)) != null) {
            i5++;
            i6++;
            Lc = a2;
        }
        return new i(eVar, new com.google.android.exoplayer2.upstream.g(Lc.PH(str), Lc.start, Lc.length, gVar.getCacheKey()), format, i2, obj, Ld, bVar.Le((i3 + i5) - 1), i3, i5, -gVar.mwW, bVar.mvE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static final class b {
        private long muQ;
        final com.google.android.exoplayer2.source.a.d mvE;
        public g mwu;
        public d mwv;
        private int mww;

        b(long j, int i, g gVar, boolean z, boolean z2) {
            com.google.android.exoplayer2.extractor.e eVar;
            this.muQ = j;
            this.mwu = gVar;
            String str = gVar.mbs.containerMimeType;
            if (PG(str)) {
                this.mvE = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.e.a(gVar.mbs);
                } else if (PF(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.a.d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    eVar = new com.google.android.exoplayer2.extractor.c.e(z2 ? i2 | 8 : i2);
                }
                this.mvE = new com.google.android.exoplayer2.source.a.d(eVar, i, gVar.mbs);
            }
            this.mwv = gVar.dxA();
        }

        void a(long j, g gVar) throws BehindLiveWindowException {
            int gr;
            d dxA = this.mwu.dxA();
            d dxA2 = gVar.dxA();
            this.muQ = j;
            this.mwu = gVar;
            if (dxA != null) {
                this.mwv = dxA2;
                if (dxA.dxw() && (gr = dxA.gr(this.muQ)) != 0) {
                    int dxv = (gr + dxA.dxv()) - 1;
                    long Lb = dxA.Lb(dxv) + dxA.F(dxv, this.muQ);
                    int dxv2 = dxA2.dxv();
                    long Lb2 = dxA2.Lb(dxv2);
                    if (Lb == Lb2) {
                        this.mww += (dxv + 1) - dxv2;
                    } else if (Lb < Lb2) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.mww = (dxA.T(Lb2, this.muQ) - dxv2) + this.mww;
                    }
                }
            }
        }

        public int dxv() {
            return this.mwv.dxv() + this.mww;
        }

        public int getSegmentCount() {
            return this.mwv.gr(this.muQ);
        }

        public long Ld(int i) {
            return this.mwv.Lb(i - this.mww);
        }

        public long Le(int i) {
            return Ld(i) + this.mwv.F(i - this.mww, this.muQ);
        }

        public int gt(long j) {
            return this.mwv.T(j, this.muQ) + this.mww;
        }

        public com.google.android.exoplayer2.source.dash.manifest.f Lc(int i) {
            return this.mwv.Lc(i - this.mww);
        }

        private static boolean PF(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean PG(String str) {
            return com.google.android.exoplayer2.util.i.Qq(str) || "application/ttml+xml".equals(str);
        }
    }
}
