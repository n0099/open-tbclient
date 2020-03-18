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
    private final u maA;
    private final com.google.android.exoplayer2.extractor.c.k[] mkQ;
    private k.a msN;
    private final int mtj;
    private final com.google.android.exoplayer2.upstream.b mtm;
    private final o mvK;
    private f<b>[] mvM;
    private e mvN;
    private final b.a mvs;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mzP;
    private final b.a mzR;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, int i, b.a aVar3, o oVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mzR = aVar2;
        this.mvK = oVar;
        this.mtj = i;
        this.mvs = aVar3;
        this.mtm = bVar;
        this.maA = b(aVar);
        a.C0684a c0684a = aVar.mzX;
        if (c0684a != null) {
            this.mkQ = new com.google.android.exoplayer2.extractor.c.k[]{new com.google.android.exoplayer2.extractor.c.k(true, null, 8, ay(c0684a.data), 0, 0, null)};
        } else {
            this.mkQ = null;
        }
        this.mzP = aVar;
        this.mvM = La(0);
        this.mvN = new e(this.mvM);
    }

    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.mzP = aVar;
        for (f<b> fVar : this.mvM) {
            fVar.dxm().a(aVar);
        }
        this.msN.a((k.a) this);
    }

    public void release() {
        for (f<b> fVar : this.mvM) {
            fVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.msN = aVar;
        aVar.a((k) this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwC() throws IOException {
        this.mvK.dwJ();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwD() {
        return this.maA;
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
                this.mvM = La(arrayList.size());
                arrayList.toArray(this.mvM);
                this.mvN = new e(this.mvM);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gc(long j) {
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ge(long j) {
        return this.mvN.ge(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwG() {
        return this.mvN.dwG();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwE() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwF() {
        return this.mvN.dwF();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gd(long j) {
        for (f<b> fVar : this.mvM) {
            fVar.go(j);
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(f<b> fVar) {
        this.msN.a((k.a) this);
    }

    private f<b> a(com.google.android.exoplayer2.b.f fVar, long j) {
        int a = this.maA.a(fVar.dxD());
        return new f<>(this.mzP.mzY[a].type, null, this.mzR.a(this.mvK, this.mzP, a, fVar, this.mkQ), this, this.mtm, j, this.mtj, this.mvs);
    }

    private static u b(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        t[] tVarArr = new t[aVar.mzY.length];
        for (int i = 0; i < aVar.mzY.length; i++) {
            tVarArr[i] = new t(aVar.mzY[i].muo);
        }
        return new u(tVarArr);
    }

    private static f<b>[] La(int i) {
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
