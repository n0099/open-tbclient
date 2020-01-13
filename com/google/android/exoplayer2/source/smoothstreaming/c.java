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
    private final u lXT;
    private final com.google.android.exoplayer2.extractor.c.k[] mil;
    private final int mqE;
    private final com.google.android.exoplayer2.upstream.b mqH;
    private k.a mqi;
    private final b.a msN;
    private final o mtf;
    private f<b>[] mth;
    private e mti;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxl;
    private final b.a mxn;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, int i, b.a aVar3, o oVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mxn = aVar2;
        this.mtf = oVar;
        this.mqE = i;
        this.msN = aVar3;
        this.mqH = bVar;
        this.lXT = b(aVar);
        a.C0675a c0675a = aVar.mxt;
        if (c0675a != null) {
            this.mil = new com.google.android.exoplayer2.extractor.c.k[]{new com.google.android.exoplayer2.extractor.c.k(true, null, 8, at(c0675a.data), 0, 0, null)};
        } else {
            this.mil = null;
        }
        this.mxl = aVar;
        this.mth = KP(0);
        this.mti = new e(this.mth);
    }

    public void a(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.mxl = aVar;
        for (f<b> fVar : this.mth) {
            fVar.dvA().a(aVar);
        }
        this.mqi.a((k.a) this);
    }

    public void release() {
        for (f<b> fVar : this.mth) {
            fVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqi = aVar;
        aVar.a((k) this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duQ() throws IOException {
        this.mtf.duX();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duR() {
        return this.lXT;
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
                this.mth = KP(arrayList.size());
                arrayList.toArray(this.mth);
                this.mti = new e(this.mth);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        return this.mti.gf(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duU() {
        return this.mti.duU();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duS() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duT() {
        return this.mti.duT();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        for (f<b> fVar : this.mth) {
            fVar.gp(j);
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(f<b> fVar) {
        this.mqi.a((k.a) this);
    }

    private f<b> a(com.google.android.exoplayer2.b.f fVar, long j) {
        int a = this.lXT.a(fVar.dvR());
        return new f<>(this.mxl.mxu[a].type, null, this.mxn.a(this.mtf, this.mxl, a, fVar, this.mil), this, this.mqH, j, this.mqE, this.msN);
    }

    private static u b(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        t[] tVarArr = new t[aVar.mxu.length];
        for (int i = 0; i < aVar.mxu.length; i++) {
            tVarArr[i] = new t(aVar.mxu[i].mrI);
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
