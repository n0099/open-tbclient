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
/* loaded from: classes4.dex */
public class a implements b {
    private final e lZr;
    private final f mpU;
    private IOException mpX;
    private final o mpq;
    private final int mtv;
    private final com.google.android.exoplayer2.source.a.d[] mtw;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mty;
    private int mtz;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0668a implements b.a {
        private final e.a mnx;

        public C0668a(e.a aVar) {
            this.mnx = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public b a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, k[] kVarArr) {
            return new a(oVar, aVar, i, fVar, this.mnx.dww(), kVarArr);
        }
    }

    public a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, e eVar, k[] kVarArr) {
        this.mpq = oVar;
        this.mty = aVar;
        this.mtv = i;
        this.mpU = fVar;
        this.lZr = eVar;
        a.b bVar = aVar.mtH[i];
        this.mtw = new com.google.android.exoplayer2.source.a.d[fVar.length()];
        for (int i2 = 0; i2 < this.mtw.length; i2++) {
            int Ls = fVar.Ls(i2);
            Format format = bVar.mnT[Ls];
            this.mtw[i2] = new com.google.android.exoplayer2.source.a.d(new com.google.android.exoplayer2.extractor.c.e(3, null, new j(Ls, bVar.type, bVar.timescale, -9223372036854775807L, aVar.lUZ, format, 0, kVarArr, bVar.type == 2 ? 4 : 0, null, null), null), bVar.type, format);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b bVar = this.mty.mtH[this.mtv];
        int i = bVar.mpj;
        a.b bVar2 = aVar.mtH[this.mtv];
        if (i == 0 || bVar2.mpj == 0) {
            this.mtz += i;
        } else {
            long KT = bVar2.KT(0);
            if (bVar.KT(i - 1) + bVar.KU(i - 1) <= KT) {
                this.mtz += i;
            } else {
                this.mtz = bVar.fH(KT) + this.mtz;
            }
        }
        this.mty = aVar;
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dtM() throws IOException {
        if (this.mpX != null) {
            throw this.mpX;
        }
        this.mpq.dtM();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public final void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int dur;
        if (this.mpX == null) {
            a.b bVar = this.mty.mtH[this.mtv];
            if (bVar.mpj == 0) {
                eVar.moT = !this.mty.mtj;
                return;
            }
            if (lVar == null) {
                dur = bVar.fH(j2);
            } else {
                dur = lVar.dur() - this.mtz;
                if (dur < 0) {
                    this.mpX = new BehindLiveWindowException();
                    return;
                }
            }
            if (dur >= bVar.mpj) {
                eVar.moT = !this.mty.mtj;
                return;
            }
            this.mpU.f(j, j2 - j, go(j));
            long KT = bVar.KT(dur);
            long KU = KT + bVar.KU(dur);
            int i = dur + this.mtz;
            int duK = this.mpU.duK();
            eVar.moS = a(this.mpU.dvY(), this.lZr, bVar.dP(this.mpU.Ls(duK), dur), null, i, KT, KU, this.mpU.duL(), this.mpU.duM(), this.mtw[duK]);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        return z && h.a(this.mpU, this.mpU.m(cVar.moF), exc);
    }

    private static l a(Format format, e eVar, Uri uri, String str, int i, long j, long j2, int i2, Object obj, com.google.android.exoplayer2.source.a.d dVar) {
        return new i(eVar, new g(uri, 0L, -1L, str), format, i2, obj, j, j2, i, 1, j, dVar);
    }

    private long go(long j) {
        if (!this.mty.mtj) {
            return -9223372036854775807L;
        }
        a.b bVar = this.mty.mtH[this.mtv];
        int i = bVar.mpj - 1;
        return (bVar.KU(i) + bVar.KT(i)) - j;
    }
}
