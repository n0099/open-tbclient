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
    private final e meh;
    private final f muI;
    private IOException muL;
    private final o mue;
    private final int myh;
    private final com.google.android.exoplayer2.source.a.d[] myi;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a myj;
    private int myk;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0682a implements b.a {
        private final e.a msl;

        public C0682a(e.a aVar) {
            this.msl = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public b a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, k[] kVarArr) {
            return new a(oVar, aVar, i, fVar, this.msl.dyW(), kVarArr);
        }
    }

    public a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, e eVar, k[] kVarArr) {
        this.mue = oVar;
        this.myj = aVar;
        this.myh = i;
        this.muI = fVar;
        this.meh = eVar;
        a.b bVar = aVar.mys[i];
        this.myi = new com.google.android.exoplayer2.source.a.d[fVar.length()];
        for (int i2 = 0; i2 < this.myi.length; i2++) {
            int LG = fVar.LG(i2);
            Format format = bVar.msH[LG];
            this.myi[i2] = new com.google.android.exoplayer2.source.a.d(new com.google.android.exoplayer2.extractor.c.e(3, null, new j(LG, bVar.type, bVar.timescale, -9223372036854775807L, aVar.lZO, format, 0, kVarArr, bVar.type == 2 ? 4 : 0, null, null), null), bVar.type, format);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b bVar = this.myj.mys[this.myh];
        int i = bVar.mtX;
        a.b bVar2 = aVar.mys[this.myh];
        if (i == 0 || bVar2.mtX == 0) {
            this.myk += i;
        } else {
            long Lh = bVar2.Lh(0);
            if (bVar.Lh(i - 1) + bVar.Li(i - 1) <= Lh) {
                this.myk += i;
            } else {
                this.myk = bVar.fK(Lh) + this.myk;
            }
        }
        this.myj = aVar;
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dwm() throws IOException {
        if (this.muL != null) {
            throw this.muL;
        }
        this.mue.dwm();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public final void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int dwR;
        if (this.muL == null) {
            a.b bVar = this.myj.mys[this.myh];
            if (bVar.mtX == 0) {
                eVar.mtH = !this.myj.mxV;
                return;
            }
            if (lVar == null) {
                dwR = bVar.fK(j2);
            } else {
                dwR = lVar.dwR() - this.myk;
                if (dwR < 0) {
                    this.muL = new BehindLiveWindowException();
                    return;
                }
            }
            if (dwR >= bVar.mtX) {
                eVar.mtH = !this.myj.mxV;
                return;
            }
            this.muI.g(j, j2 - j, gr(j));
            long Lh = bVar.Lh(dwR);
            long Li = Lh + bVar.Li(dwR);
            int i = dwR + this.myk;
            int dxk = this.muI.dxk();
            eVar.mtG = a(this.muI.dyy(), this.meh, bVar.dQ(this.muI.LG(dxk), dwR), null, i, Lh, Li, this.muI.dxl(), this.muI.dxm(), this.myi[dxk]);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        return z && h.a(this.muI, this.muI.m(cVar.mts), exc);
    }

    private static l a(Format format, e eVar, Uri uri, String str, int i, long j, long j2, int i2, Object obj, com.google.android.exoplayer2.source.a.d dVar) {
        return new i(eVar, new g(uri, 0L, -1L, str), format, i2, obj, j, j2, i, 1, j, dVar);
    }

    private long gr(long j) {
        if (!this.myj.mxV) {
            return -9223372036854775807L;
        }
        a.b bVar = this.myj.mys[this.myh];
        int i = bVar.mtX - 1;
        return (bVar.Li(i) + bVar.Lh(i)) - j;
    }
}
