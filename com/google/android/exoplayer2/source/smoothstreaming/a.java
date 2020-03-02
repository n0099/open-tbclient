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
    private final e mdW;
    private final o mtT;
    private IOException muA;
    private final f mux;
    private final int mxW;
    private final com.google.android.exoplayer2.source.a.d[] mxX;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxY;
    private int mxZ;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0682a implements b.a {
        private final e.a mrZ;

        public C0682a(e.a aVar) {
            this.mrZ = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public b a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, k[] kVarArr) {
            return new a(oVar, aVar, i, fVar, this.mrZ.dyV(), kVarArr);
        }
    }

    public a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, e eVar, k[] kVarArr) {
        this.mtT = oVar;
        this.mxY = aVar;
        this.mxW = i;
        this.mux = fVar;
        this.mdW = eVar;
        a.b bVar = aVar.myh[i];
        this.mxX = new com.google.android.exoplayer2.source.a.d[fVar.length()];
        for (int i2 = 0; i2 < this.mxX.length; i2++) {
            int LG = fVar.LG(i2);
            Format format = bVar.msw[LG];
            this.mxX[i2] = new com.google.android.exoplayer2.source.a.d(new com.google.android.exoplayer2.extractor.c.e(3, null, new j(LG, bVar.type, bVar.timescale, -9223372036854775807L, aVar.lZD, format, 0, kVarArr, bVar.type == 2 ? 4 : 0, null, null), null), bVar.type, format);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b bVar = this.mxY.myh[this.mxW];
        int i = bVar.mtM;
        a.b bVar2 = aVar.myh[this.mxW];
        if (i == 0 || bVar2.mtM == 0) {
            this.mxZ += i;
        } else {
            long Lh = bVar2.Lh(0);
            if (bVar.Lh(i - 1) + bVar.Li(i - 1) <= Lh) {
                this.mxZ += i;
            } else {
                this.mxZ = bVar.fK(Lh) + this.mxZ;
            }
        }
        this.mxY = aVar;
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dwl() throws IOException {
        if (this.muA != null) {
            throw this.muA;
        }
        this.mtT.dwl();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public final void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int dwQ;
        if (this.muA == null) {
            a.b bVar = this.mxY.myh[this.mxW];
            if (bVar.mtM == 0) {
                eVar.mtv = !this.mxY.mxK;
                return;
            }
            if (lVar == null) {
                dwQ = bVar.fK(j2);
            } else {
                dwQ = lVar.dwQ() - this.mxZ;
                if (dwQ < 0) {
                    this.muA = new BehindLiveWindowException();
                    return;
                }
            }
            if (dwQ >= bVar.mtM) {
                eVar.mtv = !this.mxY.mxK;
                return;
            }
            this.mux.g(j, j2 - j, gr(j));
            long Lh = bVar.Lh(dwQ);
            long Li = Lh + bVar.Li(dwQ);
            int i = dwQ + this.mxZ;
            int dxj = this.mux.dxj();
            eVar.mtu = a(this.mux.dyx(), this.mdW, bVar.dQ(this.mux.LG(dxj), dwQ), null, i, Lh, Li, this.mux.dxk(), this.mux.dxl(), this.mxX[dxj]);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        return z && h.a(this.mux, this.mux.m(cVar.mth), exc);
    }

    private static l a(Format format, e eVar, Uri uri, String str, int i, long j, long j2, int i2, Object obj, com.google.android.exoplayer2.source.a.d dVar) {
        return new i(eVar, new g(uri, 0L, -1L, str), format, i2, obj, j, j2, i, 1, j, dVar);
    }

    private long gr(long j) {
        if (!this.mxY.mxK) {
            return -9223372036854775807L;
        }
        a.b bVar = this.mxY.myh[this.mxW];
        int i = bVar.mtM - 1;
        return (bVar.Li(i) + bVar.Lh(i)) - j;
    }
}
