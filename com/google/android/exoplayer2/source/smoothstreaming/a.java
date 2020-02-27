package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.extractor.c.j;
import com.google.android.exoplayer2.extractor.c.k;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.a.i;
import com.google.android.exoplayer2.source.a.l;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.upstream.o;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a implements b {
    private final e mdU;
    private final o mtR;
    private final f muv;
    private IOException muy;
    private final int mxU;
    private final com.google.android.exoplayer2.source.a.d[] mxV;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxW;
    private int mxX;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0682a implements b.a {
        private final e.a mrX;

        public C0682a(e.a aVar) {
            this.mrX = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public b a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, k[] kVarArr) {
            return new a(oVar, aVar, i, fVar, this.mrX.dyT(), kVarArr);
        }
    }

    public a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, e eVar, k[] kVarArr) {
        this.mtR = oVar;
        this.mxW = aVar;
        this.mxU = i;
        this.muv = fVar;
        this.mdU = eVar;
        a.b bVar = aVar.myf[i];
        this.mxV = new com.google.android.exoplayer2.source.a.d[fVar.length()];
        for (int i2 = 0; i2 < this.mxV.length; i2++) {
            int LG = fVar.LG(i2);
            Format format = bVar.msu[LG];
            this.mxV[i2] = new com.google.android.exoplayer2.source.a.d(new com.google.android.exoplayer2.extractor.c.e(3, null, new j(LG, bVar.type, bVar.timescale, -9223372036854775807L, aVar.lZB, format, 0, kVarArr, bVar.type == 2 ? 4 : 0, null, null), null), bVar.type, format);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b bVar = this.mxW.myf[this.mxU];
        int i = bVar.mtK;
        a.b bVar2 = aVar.myf[this.mxU];
        if (i == 0 || bVar2.mtK == 0) {
            this.mxX += i;
        } else {
            long Lh = bVar2.Lh(0);
            if (bVar.Lh(i - 1) + bVar.Li(i - 1) <= Lh) {
                this.mxX += i;
            } else {
                this.mxX = bVar.fK(Lh) + this.mxX;
            }
        }
        this.mxW = aVar;
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dwj() throws IOException {
        if (this.muy != null) {
            throw this.muy;
        }
        this.mtR.dwj();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public final void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int dwO;
        if (this.muy == null) {
            a.b bVar = this.mxW.myf[this.mxU];
            if (bVar.mtK == 0) {
                eVar.mtt = !this.mxW.mxI;
                return;
            }
            if (lVar == null) {
                dwO = bVar.fK(j2);
            } else {
                dwO = lVar.dwO() - this.mxX;
                if (dwO < 0) {
                    this.muy = new BehindLiveWindowException();
                    return;
                }
            }
            if (dwO >= bVar.mtK) {
                eVar.mtt = !this.mxW.mxI;
                return;
            }
            this.muv.g(j, j2 - j, gr(j));
            long Lh = bVar.Lh(dwO);
            long Li = Lh + bVar.Li(dwO);
            int i = dwO + this.mxX;
            int dxh = this.muv.dxh();
            eVar.mts = a(this.muv.dyv(), this.mdU, bVar.dQ(this.muv.LG(dxh), dwO), null, i, Lh, Li, this.muv.dxi(), this.muv.dxj(), this.mxV[dxh]);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        return z && h.a(this.muv, this.muv.m(cVar.mtf), exc);
    }

    private static l a(Format format, e eVar, Uri uri, String str, int i, long j, long j2, int i2, Object obj, com.google.android.exoplayer2.source.a.d dVar) {
        return new i(eVar, new g(uri, 0L, -1L, str), format, i2, obj, j, j2, i, 1, j, dVar);
    }

    private long gr(long j) {
        if (!this.mxW.mxI) {
            return -9223372036854775807L;
        }
        a.b bVar = this.mxW.myf[this.mxU];
        int i = bVar.mtK - 1;
        return (bVar.Li(i) + bVar.Lh(i)) - j;
    }
}
