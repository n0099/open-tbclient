package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes5.dex */
final class m implements k, k.a {
    private u lXY;
    private k.a mqn;
    private final IdentityHashMap<p, Integer> mrA = new IdentityHashMap<>();
    private int mrB;
    private k[] mrC;
    private q mrD;
    public final k[] mrz;

    public m(k... kVarArr) {
        this.mrz = kVarArr;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqn = aVar;
        this.mrB = this.mrz.length;
        for (k kVar : this.mrz) {
            kVar.a(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duS() throws IOException {
        for (k kVar : this.mrz) {
            kVar.duS();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duT() {
        return this.lXY;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mrA.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dvT = fVarArr[i2].dvT();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mrz.length) {
                        if (this.mrz[i3].duT().a(dvT) == -1) {
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
        this.mrA.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.mrz.length);
        int i4 = 0;
        long j2 = j;
        while (i4 < this.mrz.length) {
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                pVarArr3[i5] = iArr[i5] == i4 ? pVarArr[i5] : null;
                fVarArr2[i5] = iArr2[i5] == i4 ? fVarArr[i5] : null;
            }
            long a = this.mrz[i4].a(fVarArr2, zArr, pVarArr3, zArr2, j2);
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
                    this.mrA.put(pVarArr3[i6], Integer.valueOf(i4));
                } else if (iArr[i6] == i4) {
                    com.google.android.exoplayer2.util.a.checkState(pVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.mrz[i4]);
            }
            i4++;
        }
        System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
        this.mrC = new k[arrayList.size()];
        arrayList.toArray(this.mrC);
        this.mrD = new e(this.mrC);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        for (k kVar : this.mrC) {
            kVar.gd(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        return this.mrD.gf(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duW() {
        return this.mrD.duW();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duU() {
        k[] kVarArr;
        long duU = this.mrz[0].duU();
        for (int i = 1; i < this.mrz.length; i++) {
            if (this.mrz[i].duU() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (duU != -9223372036854775807L) {
            for (k kVar : this.mrC) {
                if (kVar != this.mrz[0] && kVar.ge(duU) != duU) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return duU;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duV() {
        return this.mrD.duV();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        long ge = this.mrC[0].ge(j);
        for (int i = 1; i < this.mrC.length; i++) {
            if (this.mrC[i].ge(ge) != ge) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return ge;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        int i = this.mrB - 1;
        this.mrB = i;
        if (i <= 0) {
            int i2 = 0;
            for (k kVar2 : this.mrz) {
                i2 += kVar2.duT().length;
            }
            t[] tVarArr = new t[i2];
            k[] kVarArr = this.mrz;
            int length = kVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                u duT = kVarArr[i3].duT();
                int i5 = duT.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = duT.KM(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lXY = new u(tVarArr);
            this.mqn.a((k) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        if (this.lXY != null) {
            this.mqn.a((k.a) this);
        }
    }
}
