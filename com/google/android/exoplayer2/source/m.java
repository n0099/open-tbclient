package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes6.dex */
final class m implements k, k.a {
    private u lYG;
    private k.a mqV;
    public final k[] msi;
    private final IdentityHashMap<p, Integer> msj = new IdentityHashMap<>();
    private int msk;
    private k[] msl;
    private q msm;

    public m(k... kVarArr) {
        this.msi = kVarArr;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqV = aVar;
        this.msk = this.msi.length;
        for (k kVar : this.msi) {
            kVar.a(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwe() throws IOException {
        for (k kVar : this.msi) {
            kVar.dwe();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwf() {
        return this.lYG;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fVarArr.length) {
                break;
            }
            iArr[i2] = pVarArr[i2] == null ? -1 : this.msj.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dxf = fVarArr[i2].dxf();
                int i3 = 0;
                while (true) {
                    if (i3 < this.msi.length) {
                        if (this.msi[i3].dwf().a(dxf) == -1) {
                            i3++;
                        } else {
                            iArr2[i2] = i3;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i = i2 + 1;
        }
        this.msj.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.msi.length);
        int i4 = 0;
        long j2 = j;
        while (i4 < this.msi.length) {
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                pVarArr3[i5] = iArr[i5] == i4 ? pVarArr[i5] : null;
                fVarArr2[i5] = iArr2[i5] == i4 ? fVarArr[i5] : null;
            }
            long a = this.msi[i4].a(fVarArr2, zArr, pVarArr3, zArr2, j2);
            if (i4 == 0) {
                j2 = a;
            } else if (a != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < fVarArr.length; i6++) {
                if (iArr2[i6] == i4) {
                    com.google.android.exoplayer2.util.a.checkState(pVarArr3[i6] != null);
                    pVarArr2[i6] = pVarArr3[i6];
                    z = true;
                    this.msj.put(pVarArr3[i6], Integer.valueOf(i4));
                } else if (iArr[i6] == i4) {
                    com.google.android.exoplayer2.util.a.checkState(pVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.msi[i4]);
            }
            i4++;
        }
        System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
        this.msl = new k[arrayList.size()];
        arrayList.toArray(this.msl);
        this.msm = new e(this.msl);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        for (k kVar : this.msl) {
            kVar.gb(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.msm.gd(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        return this.msm.dwi();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwg() {
        k[] kVarArr;
        long dwg = this.msi[0].dwg();
        for (int i = 1; i < this.msi.length; i++) {
            if (this.msi[i].dwg() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (dwg != -9223372036854775807L) {
            for (k kVar : this.msl) {
                if (kVar != this.msi[0] && kVar.gc(dwg) != dwg) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return dwg;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwh() {
        return this.msm.dwh();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        long gc = this.msl[0].gc(j);
        for (int i = 1; i < this.msl.length; i++) {
            if (this.msl[i].gc(gc) != gc) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return gc;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        int i = this.msk - 1;
        this.msk = i;
        if (i <= 0) {
            int i2 = 0;
            for (k kVar2 : this.msi) {
                i2 += kVar2.dwf().length;
            }
            t[] tVarArr = new t[i2];
            k[] kVarArr = this.msi;
            int length = kVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                u dwf = kVarArr[i3].dwf();
                int i5 = dwf.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = dwf.KR(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lYG = new u(tVarArr);
            this.mqV.a((k) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        if (this.lYG != null) {
            this.mqV.a((k.a) this);
        }
    }
}
