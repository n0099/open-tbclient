package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes6.dex */
final class m implements k, k.a {
    private u maA;
    private k.a msN;
    public final k[] mua;
    private final IdentityHashMap<p, Integer> mub = new IdentityHashMap<>();
    private int muc;
    private k[] mud;
    private q mue;

    public m(k... kVarArr) {
        this.mua = kVarArr;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.msN = aVar;
        this.muc = this.mua.length;
        for (k kVar : this.mua) {
            kVar.a(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwC() throws IOException {
        for (k kVar : this.mua) {
            kVar.dwC();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwD() {
        return this.maA;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mub.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dxD = fVarArr[i2].dxD();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mua.length) {
                        if (this.mua[i3].dwD().a(dxD) == -1) {
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
        this.mub.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.mua.length);
        int i4 = 0;
        long j2 = j;
        while (i4 < this.mua.length) {
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                pVarArr3[i5] = iArr[i5] == i4 ? pVarArr[i5] : null;
                fVarArr2[i5] = iArr2[i5] == i4 ? fVarArr[i5] : null;
            }
            long a = this.mua[i4].a(fVarArr2, zArr, pVarArr3, zArr2, j2);
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
                    this.mub.put(pVarArr3[i6], Integer.valueOf(i4));
                } else if (iArr[i6] == i4) {
                    com.google.android.exoplayer2.util.a.checkState(pVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.mua[i4]);
            }
            i4++;
        }
        System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
        this.mud = new k[arrayList.size()];
        arrayList.toArray(this.mud);
        this.mue = new e(this.mud);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gc(long j) {
        for (k kVar : this.mud) {
            kVar.gc(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ge(long j) {
        return this.mue.ge(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwG() {
        return this.mue.dwG();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwE() {
        k[] kVarArr;
        long dwE = this.mua[0].dwE();
        for (int i = 1; i < this.mua.length; i++) {
            if (this.mua[i].dwE() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (dwE != -9223372036854775807L) {
            for (k kVar : this.mud) {
                if (kVar != this.mua[0] && kVar.gd(dwE) != dwE) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return dwE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwF() {
        return this.mue.dwF();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gd(long j) {
        long gd = this.mud[0].gd(j);
        for (int i = 1; i < this.mud.length; i++) {
            if (this.mud[i].gd(gd) != gd) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return gd;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        int i = this.muc - 1;
        this.muc = i;
        if (i <= 0) {
            int i2 = 0;
            for (k kVar2 : this.mua) {
                i2 += kVar2.dwD().length;
            }
            t[] tVarArr = new t[i2];
            k[] kVarArr = this.mua;
            int length = kVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                u dwD = kVarArr[i3].dwD();
                int i5 = dwD.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = dwD.KX(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.maA = new u(tVarArr);
            this.msN.a((k) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        if (this.maA != null) {
            this.msN.a((k.a) this);
        }
    }
}
