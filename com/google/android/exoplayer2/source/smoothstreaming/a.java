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
/* loaded from: classes5.dex */
public class a implements b {
    private final e mdo;
    private final f mtP;
    private IOException mtS;
    private final o mtk;
    private final int mxo;
    private final com.google.android.exoplayer2.source.a.d[] mxp;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxq;
    private int mxr;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0674a implements b.a {
        private final e.a mrr;

        public C0674a(e.a aVar) {
            this.mrr = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public b a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, k[] kVarArr) {
            return new a(oVar, aVar, i, fVar, this.mrr.dxJ(), kVarArr);
        }
    }

    public a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, e eVar, k[] kVarArr) {
        this.mtk = oVar;
        this.mxq = aVar;
        this.mxo = i;
        this.mtP = fVar;
        this.mdo = eVar;
        a.b bVar = aVar.mxz[i];
        this.mxp = new com.google.android.exoplayer2.source.a.d[fVar.length()];
        for (int i2 = 0; i2 < this.mxp.length; i2++) {
            int LB = fVar.LB(i2);
            Format format = bVar.mrN[LB];
            this.mxp[i2] = new com.google.android.exoplayer2.source.a.d(new com.google.android.exoplayer2.extractor.c.e(3, null, new j(LB, bVar.type, bVar.timescale, -9223372036854775807L, aVar.lYV, format, 0, kVarArr, bVar.type == 2 ? 4 : 0, null, null), null), bVar.type, format);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b bVar = this.mxq.mxz[this.mxo];
        int i = bVar.mtd;
        a.b bVar2 = aVar.mxz[this.mxo];
        if (i == 0 || bVar2.mtd == 0) {
            this.mxr += i;
        } else {
            long Lc = bVar2.Lc(0);
            if (bVar.Lc(i - 1) + bVar.Ld(i - 1) <= Lc) {
                this.mxr += i;
            } else {
                this.mxr = bVar.fM(Lc) + this.mxr;
            }
        }
        this.mxq = aVar;
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void duZ() throws IOException {
        if (this.mtS != null) {
            throw this.mtS;
        }
        this.mtk.duZ();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public final void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int dvE;
        if (this.mtS == null) {
            a.b bVar = this.mxq.mxz[this.mxo];
            if (bVar.mtd == 0) {
                eVar.msN = !this.mxq.mxc;
                return;
            }
            if (lVar == null) {
                dvE = bVar.fM(j2);
            } else {
                dvE = lVar.dvE() - this.mxr;
                if (dvE < 0) {
                    this.mtS = new BehindLiveWindowException();
                    return;
                }
            }
            if (dvE >= bVar.mtd) {
                eVar.msN = !this.mxq.mxc;
                return;
            }
            this.mtP.f(j, j2 - j, gt(j));
            long Lc = bVar.Lc(dvE);
            long Ld = Lc + bVar.Ld(dvE);
            int i = dvE + this.mxr;
            int dvX = this.mtP.dvX();
            eVar.msM = a(this.mtP.dxl(), this.mdo, bVar.dN(this.mtP.LB(dvX), dvE), null, i, Lc, Ld, this.mtP.dvY(), this.mtP.dvZ(), this.mxp[dvX]);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        return z && h.a(this.mtP, this.mtP.m(cVar.msz), exc);
    }

    private static l a(Format format, e eVar, Uri uri, String str, int i, long j, long j2, int i2, Object obj, com.google.android.exoplayer2.source.a.d dVar) {
        return new i(eVar, new g(uri, 0L, -1L, str), format, i2, obj, j, j2, i, 1, j, dVar);
    }

    private long gt(long j) {
        if (!this.mxq.mxc) {
            return -9223372036854775807L;
        }
        a.b bVar = this.mxq.mxz[this.mxo];
        int i = bVar.mtd - 1;
        return (bVar.Ld(i) + bVar.Lc(i)) - j;
    }
}
