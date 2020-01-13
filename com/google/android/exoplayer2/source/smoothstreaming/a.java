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
    private final e mdj;
    private final f mtK;
    private IOException mtN;
    private final o mtf;
    private final int mxj;
    private final com.google.android.exoplayer2.source.a.d[] mxk;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxl;
    private int mxm;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0674a implements b.a {
        private final e.a mrm;

        public C0674a(e.a aVar) {
            this.mrm = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public b a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, k[] kVarArr) {
            return new a(oVar, aVar, i, fVar, this.mrm.dxH(), kVarArr);
        }
    }

    public a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, e eVar, k[] kVarArr) {
        this.mtf = oVar;
        this.mxl = aVar;
        this.mxj = i;
        this.mtK = fVar;
        this.mdj = eVar;
        a.b bVar = aVar.mxu[i];
        this.mxk = new com.google.android.exoplayer2.source.a.d[fVar.length()];
        for (int i2 = 0; i2 < this.mxk.length; i2++) {
            int LB = fVar.LB(i2);
            Format format = bVar.mrI[LB];
            this.mxk[i2] = new com.google.android.exoplayer2.source.a.d(new com.google.android.exoplayer2.extractor.c.e(3, null, new j(LB, bVar.type, bVar.timescale, -9223372036854775807L, aVar.lYQ, format, 0, kVarArr, bVar.type == 2 ? 4 : 0, null, null), null), bVar.type, format);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b bVar = this.mxl.mxu[this.mxj];
        int i = bVar.msY;
        a.b bVar2 = aVar.mxu[this.mxj];
        if (i == 0 || bVar2.msY == 0) {
            this.mxm += i;
        } else {
            long Lc = bVar2.Lc(0);
            if (bVar.Lc(i - 1) + bVar.Ld(i - 1) <= Lc) {
                this.mxm += i;
            } else {
                this.mxm = bVar.fM(Lc) + this.mxm;
            }
        }
        this.mxl = aVar;
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void duX() throws IOException {
        if (this.mtN != null) {
            throw this.mtN;
        }
        this.mtf.duX();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public final void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int dvC;
        if (this.mtN == null) {
            a.b bVar = this.mxl.mxu[this.mxj];
            if (bVar.msY == 0) {
                eVar.msI = !this.mxl.mwX;
                return;
            }
            if (lVar == null) {
                dvC = bVar.fM(j2);
            } else {
                dvC = lVar.dvC() - this.mxm;
                if (dvC < 0) {
                    this.mtN = new BehindLiveWindowException();
                    return;
                }
            }
            if (dvC >= bVar.msY) {
                eVar.msI = !this.mxl.mwX;
                return;
            }
            this.mtK.f(j, j2 - j, gt(j));
            long Lc = bVar.Lc(dvC);
            long Ld = Lc + bVar.Ld(dvC);
            int i = dvC + this.mxm;
            int dvV = this.mtK.dvV();
            eVar.msH = a(this.mtK.dxj(), this.mdj, bVar.dN(this.mtK.LB(dvV), dvC), null, i, Lc, Ld, this.mtK.dvW(), this.mtK.dvX(), this.mxk[dvV]);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        return z && h.a(this.mtK, this.mtK.m(cVar.msu), exc);
    }

    private static l a(Format format, e eVar, Uri uri, String str, int i, long j, long j2, int i2, Object obj, com.google.android.exoplayer2.source.a.d dVar) {
        return new i(eVar, new g(uri, 0L, -1L, str), format, i2, obj, j, j2, i, 1, j, dVar);
    }

    private long gt(long j) {
        if (!this.mxl.mwX) {
            return -9223372036854775807L;
        }
        a.b bVar = this.mxl.mxu[this.mxj];
        int i = bVar.msY - 1;
        return (bVar.Ld(i) + bVar.Lc(i)) - j;
    }
}
