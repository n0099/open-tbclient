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
    private final int lXY;
    private final com.google.android.exoplayer2.upstream.e mdW;
    private final o mtT;
    private com.google.android.exoplayer2.source.dash.manifest.b mtX;
    private final int[] mtY;
    private IOException muA;
    private boolean muB;
    private long muC;
    private final long mup;
    private final com.google.android.exoplayer2.b.f mux;
    private final int muy;
    protected final b[] muz;
    private int periodIndex;

    /* loaded from: classes6.dex */
    public static final class a implements a.InterfaceC0679a {
        private final e.a mrZ;
        private final int muy;

        public a(e.a aVar) {
            this(aVar, 1);
        }

        public a(e.a aVar, int i) {
            this.mrZ = aVar;
            this.muy = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0679a
        public com.google.android.exoplayer2.source.dash.a a(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, long j, boolean z, boolean z2) {
            return new f(oVar, bVar, i, iArr, fVar, i2, this.mrZ.dyV(), j, this.muy, z, z2);
        }
    }

    public f(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, com.google.android.exoplayer2.upstream.e eVar, long j, int i3, boolean z, boolean z2) {
        this.mtT = oVar;
        this.mtX = bVar;
        this.mtY = iArr;
        this.mux = fVar;
        this.lXY = i2;
        this.mdW = eVar;
        this.periodIndex = i;
        this.mup = j;
        this.muy = i3;
        long Lb = bVar.Lb(i);
        this.muC = -9223372036854775807L;
        ArrayList<g> dwZ = dwZ();
        this.muz = new b[fVar.length()];
        for (int i4 = 0; i4 < this.muz.length; i4++) {
            this.muz[i4] = new b(Lb, i2, dwZ.get(fVar.LG(i4)), z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        try {
            this.mtX = bVar;
            this.periodIndex = i;
            long Lb = this.mtX.Lb(this.periodIndex);
            ArrayList<g> dwZ = dwZ();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.muz.length) {
                    this.muz[i3].a(Lb, dwZ.get(this.mux.LG(i3)));
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } catch (BehindLiveWindowException e) {
            this.muA = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dwl() throws IOException {
        if (this.muA != null) {
            throw this.muA;
        }
        this.mtT.dwl();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int i;
        int i2;
        int dwQ;
        if (this.muA == null) {
            this.mux.g(j, j2 - j, gr(j));
            b bVar = this.muz[this.mux.dxj()];
            if (bVar.mtN != null) {
                g gVar = bVar.muD;
                com.google.android.exoplayer2.source.dash.manifest.f fVar = null;
                com.google.android.exoplayer2.source.dash.manifest.f fVar2 = null;
                if (bVar.mtN.dwN() == null) {
                    fVar = gVar.dxa();
                }
                if (bVar.muE == null) {
                    fVar2 = gVar.dxb();
                }
                if (fVar != null || fVar2 != null) {
                    eVar.mtu = a(bVar, this.mdW, this.mux.dyx(), this.mux.dxk(), this.mux.dxl(), fVar, fVar2);
                    return;
                }
            }
            int segmentCount = bVar.getSegmentCount();
            if (segmentCount == 0) {
                eVar.mtv = !this.mtX.muL || this.periodIndex < this.mtX.dtC() + (-1);
                return;
            }
            int dwX = bVar.dwX();
            if (segmentCount == -1) {
                long dwW = (dwW() - com.google.android.exoplayer2.b.fo(this.mtX.muJ)) - com.google.android.exoplayer2.b.fo(this.mtX.KZ(this.periodIndex).mvb);
                if (this.mtX.muN != -9223372036854775807L) {
                    dwX = Math.max(dwX, bVar.gs(dwW - com.google.android.exoplayer2.b.fo(this.mtX.muN)));
                }
                int gs = bVar.gs(dwW) - 1;
                i = dwX;
                i2 = gs;
            } else {
                int i3 = (segmentCount + dwX) - 1;
                i = dwX;
                i2 = i3;
            }
            a(bVar, i2);
            if (lVar == null) {
                dwQ = v.am(bVar.gs(j2), i, i2);
            } else {
                dwQ = lVar.dwQ();
                if (dwQ < i) {
                    this.muA = new BehindLiveWindowException();
                    return;
                }
            }
            if (dwQ > i2 || (this.muB && dwQ >= i2)) {
                eVar.mtv = !this.mtX.muL || this.periodIndex < this.mtX.dtC() + (-1);
            } else {
                eVar.mtu = a(bVar, this.mdW, this.lXY, this.mux.dyx(), this.mux.dxk(), this.mux.dxl(), dwQ, Math.min(this.muy, (i2 - dwQ) + 1));
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        com.google.android.exoplayer2.extractor.l dwM;
        if (cVar instanceof k) {
            b bVar = this.muz[this.mux.m(((k) cVar).mth)];
            if (bVar.muE == null && (dwM = bVar.mtN.dwM()) != null) {
                bVar.muE = new e((com.google.android.exoplayer2.extractor.a) dwM);
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
        if (!this.mtX.muL && (cVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (bVar = this.muz[this.mux.m(cVar.mth)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((l) cVar).dwQ() > (bVar.dwX() + segmentCount) - 1) {
                this.muB = true;
                return true;
            }
        }
        return h.a(this.mux, this.mux.m(cVar.mth), exc);
    }

    private ArrayList<g> dwZ() {
        List<com.google.android.exoplayer2.source.dash.manifest.a> list = this.mtX.KZ(this.periodIndex).mvc;
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i : this.mtY) {
            arrayList.addAll(list.get(i).muG);
        }
        return arrayList;
    }

    private void a(b bVar, int i) {
        this.muC = this.mtX.muL ? bVar.KY(i) : -9223372036854775807L;
    }

    private long dwW() {
        return this.mup != 0 ? (SystemClock.elapsedRealtime() + this.mup) * 1000 : System.currentTimeMillis() * 1000;
    }

    private long gr(long j) {
        if (this.mtX.muL && this.muC != -9223372036854775807L) {
            return this.muC - j;
        }
        return -9223372036854775807L;
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, Format format, int i, Object obj, com.google.android.exoplayer2.source.dash.manifest.f fVar, com.google.android.exoplayer2.source.dash.manifest.f fVar2) {
        String str = bVar.muD.baseUrl;
        if (fVar != null) {
            com.google.android.exoplayer2.source.dash.manifest.f a2 = fVar.a(fVar2, str);
            if (a2 != null) {
                fVar = a2;
            }
        } else {
            fVar = fVar2;
        }
        return new k(eVar, new com.google.android.exoplayer2.upstream.g(fVar.PG(str), fVar.start, fVar.length, bVar.muD.getCacheKey()), format, i, obj, bVar.mtN);
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, int i, Format format, int i2, Object obj, int i3, int i4) {
        com.google.android.exoplayer2.source.dash.manifest.f a2;
        g gVar = bVar.muD;
        long KX = bVar.KX(i3);
        com.google.android.exoplayer2.source.dash.manifest.f KW = bVar.KW(i3);
        String str = gVar.baseUrl;
        if (bVar.mtN == null) {
            return new m(eVar, new com.google.android.exoplayer2.upstream.g(KW.PG(str), KW.start, KW.length, gVar.getCacheKey()), format, i2, obj, KX, bVar.KY(i3), i3, i, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i6 < i4 && (a2 = KW.a(bVar.KW(i3 + i6), str)) != null) {
            i5++;
            i6++;
            KW = a2;
        }
        return new i(eVar, new com.google.android.exoplayer2.upstream.g(KW.PG(str), KW.start, KW.length, gVar.getCacheKey()), format, i2, obj, KX, bVar.KY((i3 + i5) - 1), i3, i5, -gVar.mvf, bVar.mtN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static final class b {
        private long msY;
        final com.google.android.exoplayer2.source.a.d mtN;
        public g muD;
        public d muE;
        private int muF;

        b(long j, int i, g gVar, boolean z, boolean z2) {
            com.google.android.exoplayer2.extractor.e eVar;
            this.msY = j;
            this.muD = gVar;
            String str = gVar.lZy.containerMimeType;
            if (PF(str)) {
                this.mtN = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.e.a(gVar.lZy);
                } else if (PE(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.a.d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    eVar = new com.google.android.exoplayer2.extractor.c.e(z2 ? i2 | 8 : i2);
                }
                this.mtN = new com.google.android.exoplayer2.source.a.d(eVar, i, gVar.lZy);
            }
            this.muE = gVar.dxc();
        }

        void a(long j, g gVar) throws BehindLiveWindowException {
            int gq;
            d dxc = this.muD.dxc();
            d dxc2 = gVar.dxc();
            this.msY = j;
            this.muD = gVar;
            if (dxc != null) {
                this.muE = dxc2;
                if (dxc.dwY() && (gq = dxc.gq(this.msY)) != 0) {
                    int dwX = (gq + dxc.dwX()) - 1;
                    long KV = dxc.KV(dwX) + dxc.F(dwX, this.msY);
                    int dwX2 = dxc2.dwX();
                    long KV2 = dxc2.KV(dwX2);
                    if (KV == KV2) {
                        this.muF += (dwX + 1) - dwX2;
                    } else if (KV < KV2) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.muF = (dxc.T(KV2, this.msY) - dwX2) + this.muF;
                    }
                }
            }
        }

        public int dwX() {
            return this.muE.dwX() + this.muF;
        }

        public int getSegmentCount() {
            return this.muE.gq(this.msY);
        }

        public long KX(int i) {
            return this.muE.KV(i - this.muF);
        }

        public long KY(int i) {
            return KX(i) + this.muE.F(i - this.muF, this.msY);
        }

        public int gs(long j) {
            return this.muE.T(j, this.msY) + this.muF;
        }

        public com.google.android.exoplayer2.source.dash.manifest.f KW(int i) {
            return this.muE.KW(i - this.muF);
        }

        private static boolean PE(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean PF(String str) {
            return com.google.android.exoplayer2.util.i.Qp(str) || "application/ttml+xml".equals(str);
        }
    }
}
