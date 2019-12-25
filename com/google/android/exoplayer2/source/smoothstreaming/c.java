package com.google.android.exoplayer2.source.smoothstreaming;

import android.util.Base64;
import com.google.android.exoplayer2.source.a.f;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.o;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
final class c implements k, q.a<f<b>> {
    private final u lUc;
    private final com.google.android.exoplayer2.extractor.c.k[] mev;
    private final int mmP;
    private final com.google.android.exoplayer2.upstream.b mmS;
    private k.a mmt;
    private final b.a moY;
    private final o mpq;
    private f<b>[] mps;
    private e mpt;
    private final b.a mtA;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mty;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, int i, b.a aVar3, o oVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mtA = aVar2;
        this.mpq = oVar;
        this.mmP = i;
        this.moY = aVar3;
        this.mmS = bVar;
        this.lUc = b(aVar);
        a.C0669a c0669a = aVar.mtG;
        if (c0669a != null) {
            this.mev = new com.google.android.exoplayer2.extractor.c.k[]{new com.google.android.exoplayer2.extractor.c.k(true, null, 8, au(c0669a.data), 0, 0, null)};
        } else {
            this.mev = null;
        }
        this.mty = aVar;
        this.mps = KG(0);
        this.mpt = new e(this.mps);
    }

    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.mty = aVar;
        for (f<b> fVar : this.mps) {
            fVar.dup().a(aVar);
        }
        this.mmt.a((k.a) this);
    }

    public void release() {
        for (f<b> fVar : this.mps) {
            fVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mmt = aVar;
        aVar.a((k) this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dtF() throws IOException {
        this.mpq.dtM();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dtG() {
        return this.lUc;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < fVarArr.length) {
                if (pVarArr[i2] != null) {
                    f fVar = (f) pVarArr[i2];
                    if (fVarArr[i2] == null || !zArr[i2]) {
                        fVar.release();
                        pVarArr[i2] = null;
                    } else {
                        arrayList.add(fVar);
                    }
                }
                if (pVarArr[i2] == null && fVarArr[i2] != null) {
                    f<b> a = a(fVarArr[i2], j);
                    arrayList.add(a);
                    pVarArr[i2] = a;
                    zArr2[i2] = true;
                }
                i = i2 + 1;
            } else {
                this.mps = KG(arrayList.size());
                arrayList.toArray(this.mps);
                this.mpt = new e(this.mps);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void fY(long j) {
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ga(long j) {
        return this.mpt.ga(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtJ() {
        return this.mpt.dtJ();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dtH() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtI() {
        return this.mpt.dtI();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long fZ(long j) {
        for (f<b> fVar : this.mps) {
            fVar.gk(j);
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(f<b> fVar) {
        this.mmt.a((k.a) this);
    }

    private f<b> a(com.google.android.exoplayer2.b.f fVar, long j) {
        int a = this.lUc.a(fVar.duG());
        return new f<>(this.mty.mtH[a].type, null, this.mtA.a(this.mpq, this.mty, a, fVar, this.mev), this, this.mmS, j, this.mmP, this.moY);
    }

    private static u b(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        t[] tVarArr = new t[aVar.mtH.length];
        for (int i = 0; i < aVar.mtH.length; i++) {
            tVarArr[i] = new t(aVar.mtH[i].mnT);
        }
        return new u(tVarArr);
    }

    private static f<b>[] KG(int i) {
        return new f[i];
    }

    private static byte[] au(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 2) {
            sb.append((char) bArr[i]);
        }
        String sb2 = sb.toString();
        byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
        x(decode, 0, 3);
        x(decode, 1, 2);
        x(decode, 4, 5);
        x(decode, 6, 7);
        return decode;
    }

    private static void x(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }
}
