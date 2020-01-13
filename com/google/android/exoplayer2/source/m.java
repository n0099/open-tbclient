package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes5.dex */
final class m implements k, k.a {
    private u lXT;
    private k.a mqi;
    public final k[] mru;
    private final IdentityHashMap<p, Integer> mrv = new IdentityHashMap<>();
    private int mrw;
    private k[] mrx;
    private q mry;

    public m(k... kVarArr) {
        this.mru = kVarArr;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqi = aVar;
        this.mrw = this.mru.length;
        for (k kVar : this.mru) {
            kVar.a(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duQ() throws IOException {
        for (k kVar : this.mru) {
            kVar.duQ();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duR() {
        return this.lXT;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mrv.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dvR = fVarArr[i2].dvR();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mru.length) {
                        if (this.mru[i3].duR().a(dvR) == -1) {
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
        this.mrv.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.mru.length);
        int i4 = 0;
        long j2 = j;
        while (i4 < this.mru.length) {
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                pVarArr3[i5] = iArr[i5] == i4 ? pVarArr[i5] : null;
                fVarArr2[i5] = iArr2[i5] == i4 ? fVarArr[i5] : null;
            }
            long a = this.mru[i4].a(fVarArr2, zArr, pVarArr3, zArr2, j2);
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
                    this.mrv.put(pVarArr3[i6], Integer.valueOf(i4));
                } else if (iArr[i6] == i4) {
                    com.google.android.exoplayer2.util.a.checkState(pVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.mru[i4]);
            }
            i4++;
        }
        System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
        this.mrx = new k[arrayList.size()];
        arrayList.toArray(this.mrx);
        this.mry = new e(this.mrx);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        for (k kVar : this.mrx) {
            kVar.gd(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        return this.mry.gf(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duU() {
        return this.mry.duU();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duS() {
        k[] kVarArr;
        long duS = this.mru[0].duS();
        for (int i = 1; i < this.mru.length; i++) {
            if (this.mru[i].duS() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (duS != -9223372036854775807L) {
            for (k kVar : this.mrx) {
                if (kVar != this.mru[0] && kVar.ge(duS) != duS) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return duS;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duT() {
        return this.mry.duT();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        long ge = this.mrx[0].ge(j);
        for (int i = 1; i < this.mrx.length; i++) {
            if (this.mrx[i].ge(ge) != ge) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return ge;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        int i = this.mrw - 1;
        this.mrw = i;
        if (i <= 0) {
            int i2 = 0;
            for (k kVar2 : this.mru) {
                i2 += kVar2.duR().length;
            }
            t[] tVarArr = new t[i2];
            k[] kVarArr = this.mru;
            int length = kVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                u duR = kVarArr[i3].duR();
                int i5 = duR.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = duR.KM(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lXT = new u(tVarArr);
            this.mqi.a((k) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        if (this.lXT != null) {
            this.mqi.a((k.a) this);
        }
    }
}
