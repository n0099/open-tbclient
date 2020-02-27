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
    private final int lXW;
    private final com.google.android.exoplayer2.upstream.e mdU;
    private final o mtR;
    private com.google.android.exoplayer2.source.dash.manifest.b mtV;
    private final int[] mtW;
    private long muA;
    private final long mun;
    private final com.google.android.exoplayer2.b.f muv;
    private final int muw;
    protected final b[] mux;
    private IOException muy;
    private boolean muz;
    private int periodIndex;

    /* loaded from: classes6.dex */
    public static final class a implements a.InterfaceC0679a {
        private final e.a mrX;
        private final int muw;

        public a(e.a aVar) {
            this(aVar, 1);
        }

        public a(e.a aVar, int i) {
            this.mrX = aVar;
            this.muw = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0679a
        public com.google.android.exoplayer2.source.dash.a a(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, long j, boolean z, boolean z2) {
            return new f(oVar, bVar, i, iArr, fVar, i2, this.mrX.dyT(), j, this.muw, z, z2);
        }
    }

    public f(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, com.google.android.exoplayer2.upstream.e eVar, long j, int i3, boolean z, boolean z2) {
        this.mtR = oVar;
        this.mtV = bVar;
        this.mtW = iArr;
        this.muv = fVar;
        this.lXW = i2;
        this.mdU = eVar;
        this.periodIndex = i;
        this.mun = j;
        this.muw = i3;
        long Lb = bVar.Lb(i);
        this.muA = -9223372036854775807L;
        ArrayList<g> dwX = dwX();
        this.mux = new b[fVar.length()];
        for (int i4 = 0; i4 < this.mux.length; i4++) {
            this.mux[i4] = new b(Lb, i2, dwX.get(fVar.LG(i4)), z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        try {
            this.mtV = bVar;
            this.periodIndex = i;
            long Lb = this.mtV.Lb(this.periodIndex);
            ArrayList<g> dwX = dwX();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mux.length) {
                    this.mux[i3].a(Lb, dwX.get(this.muv.LG(i3)));
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } catch (BehindLiveWindowException e) {
            this.muy = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dwj() throws IOException {
        if (this.muy != null) {
            throw this.muy;
        }
        this.mtR.dwj();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int i;
        int i2;
        int dwO;
        if (this.muy == null) {
            this.muv.g(j, j2 - j, gr(j));
            b bVar = this.mux[this.muv.dxh()];
            if (bVar.mtL != null) {
                g gVar = bVar.muB;
                com.google.android.exoplayer2.source.dash.manifest.f fVar = null;
                com.google.android.exoplayer2.source.dash.manifest.f fVar2 = null;
                if (bVar.mtL.dwL() == null) {
                    fVar = gVar.dwY();
                }
                if (bVar.muC == null) {
                    fVar2 = gVar.dwZ();
                }
                if (fVar != null || fVar2 != null) {
                    eVar.mts = a(bVar, this.mdU, this.muv.dyv(), this.muv.dxi(), this.muv.dxj(), fVar, fVar2);
                    return;
                }
            }
            int segmentCount = bVar.getSegmentCount();
            if (segmentCount == 0) {
                eVar.mtt = !this.mtV.muJ || this.periodIndex < this.mtV.dtA() + (-1);
                return;
            }
            int dwV = bVar.dwV();
            if (segmentCount == -1) {
                long dwU = (dwU() - com.google.android.exoplayer2.b.fo(this.mtV.muH)) - com.google.android.exoplayer2.b.fo(this.mtV.KZ(this.periodIndex).muZ);
                if (this.mtV.muL != -9223372036854775807L) {
                    dwV = Math.max(dwV, bVar.gs(dwU - com.google.android.exoplayer2.b.fo(this.mtV.muL)));
                }
                int gs = bVar.gs(dwU) - 1;
                i = dwV;
                i2 = gs;
            } else {
                int i3 = (segmentCount + dwV) - 1;
                i = dwV;
                i2 = i3;
            }
            a(bVar, i2);
            if (lVar == null) {
                dwO = v.am(bVar.gs(j2), i, i2);
            } else {
                dwO = lVar.dwO();
                if (dwO < i) {
                    this.muy = new BehindLiveWindowException();
                    return;
                }
            }
            if (dwO > i2 || (this.muz && dwO >= i2)) {
                eVar.mtt = !this.mtV.muJ || this.periodIndex < this.mtV.dtA() + (-1);
            } else {
                eVar.mts = a(bVar, this.mdU, this.lXW, this.muv.dyv(), this.muv.dxi(), this.muv.dxj(), dwO, Math.min(this.muw, (i2 - dwO) + 1));
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        com.google.android.exoplayer2.extractor.l dwK;
        if (cVar instanceof k) {
            b bVar = this.mux[this.muv.m(((k) cVar).mtf)];
            if (bVar.muC == null && (dwK = bVar.mtL.dwK()) != null) {
                bVar.muC = new e((com.google.android.exoplayer2.extractor.a) dwK);
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
        if (!this.mtV.muJ && (cVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (bVar = this.mux[this.muv.m(cVar.mtf)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((l) cVar).dwO() > (bVar.dwV() + segmentCount) - 1) {
                this.muz = true;
                return true;
            }
        }
        return h.a(this.muv, this.muv.m(cVar.mtf), exc);
    }

    private ArrayList<g> dwX() {
        List<com.google.android.exoplayer2.source.dash.manifest.a> list = this.mtV.KZ(this.periodIndex).mva;
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i : this.mtW) {
            arrayList.addAll(list.get(i).muE);
        }
        return arrayList;
    }

    private void a(b bVar, int i) {
        this.muA = this.mtV.muJ ? bVar.KY(i) : -9223372036854775807L;
    }

    private long dwU() {
        return this.mun != 0 ? (SystemClock.elapsedRealtime() + this.mun) * 1000 : System.currentTimeMillis() * 1000;
    }

    private long gr(long j) {
        if (this.mtV.muJ && this.muA != -9223372036854775807L) {
            return this.muA - j;
        }
        return -9223372036854775807L;
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, Format format, int i, Object obj, com.google.android.exoplayer2.source.dash.manifest.f fVar, com.google.android.exoplayer2.source.dash.manifest.f fVar2) {
        String str = bVar.muB.baseUrl;
        if (fVar != null) {
            com.google.android.exoplayer2.source.dash.manifest.f a2 = fVar.a(fVar2, str);
            if (a2 != null) {
                fVar = a2;
            }
        } else {
            fVar = fVar2;
        }
        return new k(eVar, new com.google.android.exoplayer2.upstream.g(fVar.PG(str), fVar.start, fVar.length, bVar.muB.getCacheKey()), format, i, obj, bVar.mtL);
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, int i, Format format, int i2, Object obj, int i3, int i4) {
        com.google.android.exoplayer2.source.dash.manifest.f a2;
        g gVar = bVar.muB;
        long KX = bVar.KX(i3);
        com.google.android.exoplayer2.source.dash.manifest.f KW = bVar.KW(i3);
        String str = gVar.baseUrl;
        if (bVar.mtL == null) {
            return new m(eVar, new com.google.android.exoplayer2.upstream.g(KW.PG(str), KW.start, KW.length, gVar.getCacheKey()), format, i2, obj, KX, bVar.KY(i3), i3, i, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i6 < i4 && (a2 = KW.a(bVar.KW(i3 + i6), str)) != null) {
            i5++;
            i6++;
            KW = a2;
        }
        return new i(eVar, new com.google.android.exoplayer2.upstream.g(KW.PG(str), KW.start, KW.length, gVar.getCacheKey()), format, i2, obj, KX, bVar.KY((i3 + i5) - 1), i3, i5, -gVar.mvd, bVar.mtL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static final class b {
        private long msW;
        final com.google.android.exoplayer2.source.a.d mtL;
        public g muB;
        public d muC;
        private int muD;

        b(long j, int i, g gVar, boolean z, boolean z2) {
            com.google.android.exoplayer2.extractor.e eVar;
            this.msW = j;
            this.muB = gVar;
            String str = gVar.lZw.containerMimeType;
            if (PF(str)) {
                this.mtL = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.e.a(gVar.lZw);
                } else if (PE(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.a.d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    eVar = new com.google.android.exoplayer2.extractor.c.e(z2 ? i2 | 8 : i2);
                }
                this.mtL = new com.google.android.exoplayer2.source.a.d(eVar, i, gVar.lZw);
            }
            this.muC = gVar.dxa();
        }

        void a(long j, g gVar) throws BehindLiveWindowException {
            int gq;
            d dxa = this.muB.dxa();
            d dxa2 = gVar.dxa();
            this.msW = j;
            this.muB = gVar;
            if (dxa != null) {
                this.muC = dxa2;
                if (dxa.dwW() && (gq = dxa.gq(this.msW)) != 0) {
                    int dwV = (gq + dxa.dwV()) - 1;
                    long KV = dxa.KV(dwV) + dxa.F(dwV, this.msW);
                    int dwV2 = dxa2.dwV();
                    long KV2 = dxa2.KV(dwV2);
                    if (KV == KV2) {
                        this.muD += (dwV + 1) - dwV2;
                    } else if (KV < KV2) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.muD = (dxa.T(KV2, this.msW) - dwV2) + this.muD;
                    }
                }
            }
        }

        public int dwV() {
            return this.muC.dwV() + this.muD;
        }

        public int getSegmentCount() {
            return this.muC.gq(this.msW);
        }

        public long KX(int i) {
            return this.muC.KV(i - this.muD);
        }

        public long KY(int i) {
            return KX(i) + this.muC.F(i - this.muD, this.msW);
        }

        public int gs(long j) {
            return this.muC.T(j, this.msW) + this.muD;
        }

        public com.google.android.exoplayer2.source.dash.manifest.f KW(int i) {
            return this.muC.KW(i - this.muD);
        }

        private static boolean PE(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean PF(String str) {
            return com.google.android.exoplayer2.util.i.Qp(str) || "application/ttml+xml".equals(str);
        }
    }
}
