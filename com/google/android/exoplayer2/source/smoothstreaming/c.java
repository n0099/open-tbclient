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
/* loaded from: classes6.dex */
final class c implements k, q.a<f<b>> {
    private final u lYG;
    private final com.google.android.exoplayer2.extractor.c.k[] miZ;
    private k.a mqV;
    private final int mrr;
    private final com.google.android.exoplayer2.upstream.b mru;
    private final b.a mtB;
    private final o mtT;
    private f<b>[] mtV;
    private e mtW;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxY;
    private final b.a mya;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, int i, b.a aVar3, o oVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mya = aVar2;
        this.mtT = oVar;
        this.mrr = i;
        this.mtB = aVar3;
        this.mru = bVar;
        this.lYG = b(aVar);
        a.C0683a c0683a = aVar.myg;
        if (c0683a != null) {
            this.miZ = new com.google.android.exoplayer2.extractor.c.k[]{new com.google.android.exoplayer2.extractor.c.k(true, null, 8, ay(c0683a.data), 0, 0, null)};
        } else {
            this.miZ = null;
        }
        this.mxY = aVar;
        this.mtV = KU(0);
        this.mtW = new e(this.mtV);
    }

    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.mxY = aVar;
        for (f<b> fVar : this.mtV) {
            fVar.dwO().a(aVar);
        }
        this.mqV.a((k.a) this);
    }

    public void release() {
        for (f<b> fVar : this.mtV) {
            fVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqV = aVar;
        aVar.a((k) this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwe() throws IOException {
        this.mtT.dwl();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwf() {
        return this.lYG;
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
                this.mtV = KU(arrayList.size());
                arrayList.toArray(this.mtV);
                this.mtW = new e(this.mtV);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.mtW.gd(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        return this.mtW.dwi();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwg() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwh() {
        return this.mtW.dwh();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        for (f<b> fVar : this.mtV) {
            fVar.gn(j);
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(f<b> fVar) {
        this.mqV.a((k.a) this);
    }

    private f<b> a(com.google.android.exoplayer2.b.f fVar, long j) {
        int a = this.lYG.a(fVar.dxf());
        return new f<>(this.mxY.myh[a].type, null, this.mya.a(this.mtT, this.mxY, a, fVar, this.miZ), this, this.mru, j, this.mrr, this.mtB);
    }

    private static u b(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        t[] tVarArr = new t[aVar.myh.length];
        for (int i = 0; i < aVar.myh.length; i++) {
            tVarArr[i] = new t(aVar.myh[i].msw);
        }
        return new u(tVarArr);
    }

    private static f<b>[] KU(int i) {
        return new f[i];
    }

    private static byte[] ay(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 2) {
            sb.append((char) bArr[i]);
        }
        String sb2 = sb.toString();
        byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
        A(decode, 0, 3);
        A(decode, 1, 2);
        A(decode, 4, 5);
        A(decode, 6, 7);
        return decode;
    }

    private static void A(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }
}
