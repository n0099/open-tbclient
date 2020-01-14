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
/* loaded from: classes5.dex */
final class c implements k, q.a<f<b>> {
    private final u lXY;
    private final com.google.android.exoplayer2.extractor.c.k[] mir;
    private final int mqJ;
    private final com.google.android.exoplayer2.upstream.b mqM;
    private k.a mqn;
    private final b.a msS;
    private final o mtk;
    private f<b>[] mtm;
    private e mtn;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxq;
    private final b.a mxs;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, int i, b.a aVar3, o oVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mxs = aVar2;
        this.mtk = oVar;
        this.mqJ = i;
        this.msS = aVar3;
        this.mqM = bVar;
        this.lXY = b(aVar);
        a.C0675a c0675a = aVar.mxy;
        if (c0675a != null) {
            this.mir = new com.google.android.exoplayer2.extractor.c.k[]{new com.google.android.exoplayer2.extractor.c.k(true, null, 8, at(c0675a.data), 0, 0, null)};
        } else {
            this.mir = null;
        }
        this.mxq = aVar;
        this.mtm = KP(0);
        this.mtn = new e(this.mtm);
    }

    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.mxq = aVar;
        for (f<b> fVar : this.mtm) {
            fVar.dvC().a(aVar);
        }
        this.mqn.a((k.a) this);
    }

    public void release() {
        for (f<b> fVar : this.mtm) {
            fVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqn = aVar;
        aVar.a((k) this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duS() throws IOException {
        this.mtk.duZ();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duT() {
        return this.lXY;
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
                this.mtm = KP(arrayList.size());
                arrayList.toArray(this.mtm);
                this.mtn = new e(this.mtm);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        return this.mtn.gf(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duW() {
        return this.mtn.duW();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duU() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duV() {
        return this.mtn.duV();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        for (f<b> fVar : this.mtm) {
            fVar.gp(j);
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(f<b> fVar) {
        this.mqn.a((k.a) this);
    }

    private f<b> a(com.google.android.exoplayer2.b.f fVar, long j) {
        int a = this.lXY.a(fVar.dvT());
        return new f<>(this.mxq.mxz[a].type, null, this.mxs.a(this.mtk, this.mxq, a, fVar, this.mir), this, this.mqM, j, this.mqJ, this.msS);
    }

    private static u b(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        t[] tVarArr = new t[aVar.mxz.length];
        for (int i = 0; i < aVar.mxz.length; i++) {
            tVarArr[i] = new t(aVar.mxz[i].mrN);
        }
        return new u(tVarArr);
    }

    private static f<b>[] KP(int i) {
        return new f[i];
    }

    private static byte[] at(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 2) {
            sb.append((char) bArr[i]);
        }
        String sb2 = sb.toString();
        byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
        w(decode, 0, 3);
        w(decode, 1, 2);
        w(decode, 4, 5);
        w(decode, 6, 7);
        return decode;
    }

    private static void w(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }
}
