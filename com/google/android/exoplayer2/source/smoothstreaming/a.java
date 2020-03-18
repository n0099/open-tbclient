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
    private final e mfN;
    private final o mvK;
    private final f mwo;
    private IOException mwr;
    private final int mzN;
    private final com.google.android.exoplayer2.source.a.d[] mzO;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mzP;
    private int mzQ;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0683a implements b.a {
        private final e.a mtS;

        public C0683a(e.a aVar) {
            this.mtS = aVar;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.b.a
        public b a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, k[] kVarArr) {
            return new a(oVar, aVar, i, fVar, this.mtS.dzt(), kVarArr);
        }
    }

    public a(o oVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, f fVar, e eVar, k[] kVarArr) {
        this.mvK = oVar;
        this.mzP = aVar;
        this.mzN = i;
        this.mwo = fVar;
        this.mfN = eVar;
        a.b bVar = aVar.mzY[i];
        this.mzO = new com.google.android.exoplayer2.source.a.d[fVar.length()];
        for (int i2 = 0; i2 < this.mzO.length; i2++) {
            int LM = fVar.LM(i2);
            Format format = bVar.muo[LM];
            this.mzO[i2] = new com.google.android.exoplayer2.source.a.d(new com.google.android.exoplayer2.extractor.c.e(3, null, new j(LM, bVar.type, bVar.timescale, -9223372036854775807L, aVar.mbx, format, 0, kVarArr, bVar.type == 2 ? 4 : 0, null, null), null), bVar.type, format);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.b
    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b bVar = this.mzP.mzY[this.mzN];
        int i = bVar.mvD;
        a.b bVar2 = aVar.mzY[this.mzN];
        if (i == 0 || bVar2.mvD == 0) {
            this.mzQ += i;
        } else {
            long Ln = bVar2.Ln(0);
            if (bVar.Ln(i - 1) + bVar.Lo(i - 1) <= Ln) {
                this.mzQ += i;
            } else {
                this.mzQ = bVar.fL(Ln) + this.mzQ;
            }
        }
        this.mzP = aVar;
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dwJ() throws IOException {
        if (this.mwr != null) {
            throw this.mwr;
        }
        this.mvK.dwJ();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public final void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int dxo;
        if (this.mwr == null) {
            a.b bVar = this.mzP.mzY[this.mzN];
            if (bVar.mvD == 0) {
                eVar.mvn = !this.mzP.mzB;
                return;
            }
            if (lVar == null) {
                dxo = bVar.fL(j2);
            } else {
                dxo = lVar.dxo() - this.mzQ;
                if (dxo < 0) {
                    this.mwr = new BehindLiveWindowException();
                    return;
                }
            }
            if (dxo >= bVar.mvD) {
                eVar.mvn = !this.mzP.mzB;
                return;
            }
            this.mwo.g(j, j2 - j, gs(j));
            long Ln = bVar.Ln(dxo);
            long Lo = Ln + bVar.Lo(dxo);
            int i = dxo + this.mzQ;
            int dxH = this.mwo.dxH();
            eVar.mvm = a(this.mwo.dyV(), this.mfN, bVar.dR(this.mwo.LM(dxH), dxo), null, i, Ln, Lo, this.mwo.dxI(), this.mwo.dxJ(), this.mzO[dxH]);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        return z && h.a(this.mwo, this.mwo.m(cVar.muZ), exc);
    }

    private static l a(Format format, e eVar, Uri uri, String str, int i, long j, long j2, int i2, Object obj, com.google.android.exoplayer2.source.a.d dVar) {
        return new i(eVar, new g(uri, 0L, -1L, str), format, i2, obj, j, j2, i, 1, j, dVar);
    }

    private long gs(long j) {
        if (!this.mzP.mzB) {
            return -9223372036854775807L;
        }
        a.b bVar = this.mzP.mzY[this.mzN];
        int i = bVar.mvD - 1;
        return (bVar.Lo(i) + bVar.Ln(i)) - j;
    }
}
