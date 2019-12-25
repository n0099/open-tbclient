package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes4.dex */
final class m implements k, k.a {
    private u lUc;
    private k.a mmt;
    public final k[] mnF;
    private final IdentityHashMap<p, Integer> mnG = new IdentityHashMap<>();
    private int mnH;
    private k[] mnI;
    private q mnJ;

    public m(k... kVarArr) {
        this.mnF = kVarArr;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mmt = aVar;
        this.mnH = this.mnF.length;
        for (k kVar : this.mnF) {
            kVar.a(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dtF() throws IOException {
        for (k kVar : this.mnF) {
            kVar.dtF();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dtG() {
        return this.lUc;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mnG.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t duG = fVarArr[i2].duG();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mnF.length) {
                        if (this.mnF[i3].dtG().a(duG) == -1) {
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
        this.mnG.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.mnF.length);
        int i4 = 0;
        long j2 = j;
        while (i4 < this.mnF.length) {
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                pVarArr3[i5] = iArr[i5] == i4 ? pVarArr[i5] : null;
                fVarArr2[i5] = iArr2[i5] == i4 ? fVarArr[i5] : null;
            }
            long a = this.mnF[i4].a(fVarArr2, zArr, pVarArr3, zArr2, j2);
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
                    this.mnG.put(pVarArr3[i6], Integer.valueOf(i4));
                } else if (iArr[i6] == i4) {
                    com.google.android.exoplayer2.util.a.checkState(pVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.mnF[i4]);
            }
            i4++;
        }
        System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
        this.mnI = new k[arrayList.size()];
        arrayList.toArray(this.mnI);
        this.mnJ = new e(this.mnI);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void fY(long j) {
        for (k kVar : this.mnI) {
            kVar.fY(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ga(long j) {
        return this.mnJ.ga(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtJ() {
        return this.mnJ.dtJ();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dtH() {
        k[] kVarArr;
        long dtH = this.mnF[0].dtH();
        for (int i = 1; i < this.mnF.length; i++) {
            if (this.mnF[i].dtH() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (dtH != -9223372036854775807L) {
            for (k kVar : this.mnI) {
                if (kVar != this.mnF[0] && kVar.fZ(dtH) != dtH) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return dtH;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtI() {
        return this.mnJ.dtI();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long fZ(long j) {
        long fZ = this.mnI[0].fZ(j);
        for (int i = 1; i < this.mnI.length; i++) {
            if (this.mnI[i].fZ(fZ) != fZ) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return fZ;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        int i = this.mnH - 1;
        this.mnH = i;
        if (i <= 0) {
            int i2 = 0;
            for (k kVar2 : this.mnF) {
                i2 += kVar2.dtG().length;
            }
            t[] tVarArr = new t[i2];
            k[] kVarArr = this.mnF;
            int length = kVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                u dtG = kVarArr[i3].dtG();
                int i5 = dtG.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = dtG.KD(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lUc = new u(tVarArr);
            this.mmt.a((k) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        if (this.lUc != null) {
            this.mmt.a((k.a) this);
        }
    }
}
