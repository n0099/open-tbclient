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
    private final int lYj;
    private final com.google.android.exoplayer2.upstream.e meh;
    private final long muA;
    private final com.google.android.exoplayer2.b.f muI;
    private final int muJ;
    protected final b[] muK;
    private IOException muL;
    private boolean muM;
    private long muN;
    private final o mue;
    private com.google.android.exoplayer2.source.dash.manifest.b mui;
    private final int[] muj;
    private int periodIndex;

    /* loaded from: classes6.dex */
    public static final class a implements a.InterfaceC0679a {
        private final e.a msl;
        private final int muJ;

        public a(e.a aVar) {
            this(aVar, 1);
        }

        public a(e.a aVar, int i) {
            this.msl = aVar;
            this.muJ = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0679a
        public com.google.android.exoplayer2.source.dash.a a(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, long j, boolean z, boolean z2) {
            return new f(oVar, bVar, i, iArr, fVar, i2, this.msl.dyW(), j, this.muJ, z, z2);
        }
    }

    public f(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, com.google.android.exoplayer2.upstream.e eVar, long j, int i3, boolean z, boolean z2) {
        this.mue = oVar;
        this.mui = bVar;
        this.muj = iArr;
        this.muI = fVar;
        this.lYj = i2;
        this.meh = eVar;
        this.periodIndex = i;
        this.muA = j;
        this.muJ = i3;
        long Lb = bVar.Lb(i);
        this.muN = -9223372036854775807L;
        ArrayList<g> dxa = dxa();
        this.muK = new b[fVar.length()];
        for (int i4 = 0; i4 < this.muK.length; i4++) {
            this.muK[i4] = new b(Lb, i2, dxa.get(fVar.LG(i4)), z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        try {
            this.mui = bVar;
            this.periodIndex = i;
            long Lb = this.mui.Lb(this.periodIndex);
            ArrayList<g> dxa = dxa();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.muK.length) {
                    this.muK[i3].a(Lb, dxa.get(this.muI.LG(i3)));
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } catch (BehindLiveWindowException e) {
            this.muL = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dwm() throws IOException {
        if (this.muL != null) {
            throw this.muL;
        }
        this.mue.dwm();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int i;
        int i2;
        int dwR;
        if (this.muL == null) {
            this.muI.g(j, j2 - j, gr(j));
            b bVar = this.muK[this.muI.dxk()];
            if (bVar.mtY != null) {
                g gVar = bVar.muO;
                com.google.android.exoplayer2.source.dash.manifest.f fVar = null;
                com.google.android.exoplayer2.source.dash.manifest.f fVar2 = null;
                if (bVar.mtY.dwO() == null) {
                    fVar = gVar.dxb();
                }
                if (bVar.muP == null) {
                    fVar2 = gVar.dxc();
                }
                if (fVar != null || fVar2 != null) {
                    eVar.mtG = a(bVar, this.meh, this.muI.dyy(), this.muI.dxl(), this.muI.dxm(), fVar, fVar2);
                    return;
                }
            }
            int segmentCount = bVar.getSegmentCount();
            if (segmentCount == 0) {
                eVar.mtH = !this.mui.muW || this.periodIndex < this.mui.dtD() + (-1);
                return;
            }
            int dwY = bVar.dwY();
            if (segmentCount == -1) {
                long dwX = (dwX() - com.google.android.exoplayer2.b.fo(this.mui.muU)) - com.google.android.exoplayer2.b.fo(this.mui.KZ(this.periodIndex).mvm);
                if (this.mui.muY != -9223372036854775807L) {
                    dwY = Math.max(dwY, bVar.gs(dwX - com.google.android.exoplayer2.b.fo(this.mui.muY)));
                }
                int gs = bVar.gs(dwX) - 1;
                i = dwY;
                i2 = gs;
            } else {
                int i3 = (segmentCount + dwY) - 1;
                i = dwY;
                i2 = i3;
            }
            a(bVar, i2);
            if (lVar == null) {
                dwR = v.am(bVar.gs(j2), i, i2);
            } else {
                dwR = lVar.dwR();
                if (dwR < i) {
                    this.muL = new BehindLiveWindowException();
                    return;
                }
            }
            if (dwR > i2 || (this.muM && dwR >= i2)) {
                eVar.mtH = !this.mui.muW || this.periodIndex < this.mui.dtD() + (-1);
            } else {
                eVar.mtG = a(bVar, this.meh, this.lYj, this.muI.dyy(), this.muI.dxl(), this.muI.dxm(), dwR, Math.min(this.muJ, (i2 - dwR) + 1));
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        com.google.android.exoplayer2.extractor.l dwN;
        if (cVar instanceof k) {
            b bVar = this.muK[this.muI.m(((k) cVar).mts)];
            if (bVar.muP == null && (dwN = bVar.mtY.dwN()) != null) {
                bVar.muP = new e((com.google.android.exoplayer2.extractor.a) dwN);
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
        if (!this.mui.muW && (cVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (bVar = this.muK[this.muI.m(cVar.mts)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((l) cVar).dwR() > (bVar.dwY() + segmentCount) - 1) {
                this.muM = true;
                return true;
            }
        }
        return h.a(this.muI, this.muI.m(cVar.mts), exc);
    }

    private ArrayList<g> dxa() {
        List<com.google.android.exoplayer2.source.dash.manifest.a> list = this.mui.KZ(this.periodIndex).mvn;
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i : this.muj) {
            arrayList.addAll(list.get(i).muR);
        }
        return arrayList;
    }

    private void a(b bVar, int i) {
        this.muN = this.mui.muW ? bVar.KY(i) : -9223372036854775807L;
    }

    private long dwX() {
        return this.muA != 0 ? (SystemClock.elapsedRealtime() + this.muA) * 1000 : System.currentTimeMillis() * 1000;
    }

    private long gr(long j) {
        if (this.mui.muW && this.muN != -9223372036854775807L) {
            return this.muN - j;
        }
        return -9223372036854775807L;
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, Format format, int i, Object obj, com.google.android.exoplayer2.source.dash.manifest.f fVar, com.google.android.exoplayer2.source.dash.manifest.f fVar2) {
        String str = bVar.muO.baseUrl;
        if (fVar != null) {
            com.google.android.exoplayer2.source.dash.manifest.f a2 = fVar.a(fVar2, str);
            if (a2 != null) {
                fVar = a2;
            }
        } else {
            fVar = fVar2;
        }
        return new k(eVar, new com.google.android.exoplayer2.upstream.g(fVar.PH(str), fVar.start, fVar.length, bVar.muO.getCacheKey()), format, i, obj, bVar.mtY);
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, int i, Format format, int i2, Object obj, int i3, int i4) {
        com.google.android.exoplayer2.source.dash.manifest.f a2;
        g gVar = bVar.muO;
        long KX = bVar.KX(i3);
        com.google.android.exoplayer2.source.dash.manifest.f KW = bVar.KW(i3);
        String str = gVar.baseUrl;
        if (bVar.mtY == null) {
            return new m(eVar, new com.google.android.exoplayer2.upstream.g(KW.PH(str), KW.start, KW.length, gVar.getCacheKey()), format, i2, obj, KX, bVar.KY(i3), i3, i, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i6 < i4 && (a2 = KW.a(bVar.KW(i3 + i6), str)) != null) {
            i5++;
            i6++;
            KW = a2;
        }
        return new i(eVar, new com.google.android.exoplayer2.upstream.g(KW.PH(str), KW.start, KW.length, gVar.getCacheKey()), format, i2, obj, KX, bVar.KY((i3 + i5) - 1), i3, i5, -gVar.mvq, bVar.mtY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static final class b {
        final com.google.android.exoplayer2.source.a.d mtY;
        private long mtj;
        public g muO;
        public d muP;
        private int muQ;

        b(long j, int i, g gVar, boolean z, boolean z2) {
            com.google.android.exoplayer2.extractor.e eVar;
            this.mtj = j;
            this.muO = gVar;
            String str = gVar.lZJ.containerMimeType;
            if (PG(str)) {
                this.mtY = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.e.a(gVar.lZJ);
                } else if (PF(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.a.d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    eVar = new com.google.android.exoplayer2.extractor.c.e(z2 ? i2 | 8 : i2);
                }
                this.mtY = new com.google.android.exoplayer2.source.a.d(eVar, i, gVar.lZJ);
            }
            this.muP = gVar.dxd();
        }

        void a(long j, g gVar) throws BehindLiveWindowException {
            int gq;
            d dxd = this.muO.dxd();
            d dxd2 = gVar.dxd();
            this.mtj = j;
            this.muO = gVar;
            if (dxd != null) {
                this.muP = dxd2;
                if (dxd.dwZ() && (gq = dxd.gq(this.mtj)) != 0) {
                    int dwY = (gq + dxd.dwY()) - 1;
                    long KV = dxd.KV(dwY) + dxd.F(dwY, this.mtj);
                    int dwY2 = dxd2.dwY();
                    long KV2 = dxd2.KV(dwY2);
                    if (KV == KV2) {
                        this.muQ += (dwY + 1) - dwY2;
                    } else if (KV < KV2) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.muQ = (dxd.T(KV2, this.mtj) - dwY2) + this.muQ;
                    }
                }
            }
        }

        public int dwY() {
            return this.muP.dwY() + this.muQ;
        }

        public int getSegmentCount() {
            return this.muP.gq(this.mtj);
        }

        public long KX(int i) {
            return this.muP.KV(i - this.muQ);
        }

        public long KY(int i) {
            return KX(i) + this.muP.F(i - this.muQ, this.mtj);
        }

        public int gs(long j) {
            return this.muP.T(j, this.mtj) + this.muQ;
        }

        public com.google.android.exoplayer2.source.dash.manifest.f KW(int i) {
            return this.muP.KW(i - this.muQ);
        }

        private static boolean PF(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean PG(String str) {
            return com.google.android.exoplayer2.util.i.Qq(str) || "application/ttml+xml".equals(str);
        }
    }
}
