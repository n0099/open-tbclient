package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes6.dex */
final class m implements k, k.a {
    private u lYR;
    private k.a mrg;
    public final k[] mst;
    private final IdentityHashMap<p, Integer> msu = new IdentityHashMap<>();
    private int msv;
    private k[] msw;
    private q msx;

    public m(k... kVarArr) {
        this.mst = kVarArr;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mrg = aVar;
        this.msv = this.mst.length;
        for (k kVar : this.mst) {
            kVar.a(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwf() throws IOException {
        for (k kVar : this.mst) {
            kVar.dwf();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwg() {
        return this.lYR;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.msu.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dxg = fVarArr[i2].dxg();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mst.length) {
                        if (this.mst[i3].dwg().a(dxg) == -1) {
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
        this.msu.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.mst.length);
        int i4 = 0;
        long j2 = j;
        while (i4 < this.mst.length) {
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                pVarArr3[i5] = iArr[i5] == i4 ? pVarArr[i5] : null;
                fVarArr2[i5] = iArr2[i5] == i4 ? fVarArr[i5] : null;
            }
            long a = this.mst[i4].a(fVarArr2, zArr, pVarArr3, zArr2, j2);
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
                    this.msu.put(pVarArr3[i6], Integer.valueOf(i4));
                } else if (iArr[i6] == i4) {
                    com.google.android.exoplayer2.util.a.checkState(pVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.mst[i4]);
            }
            i4++;
        }
        System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
        this.msw = new k[arrayList.size()];
        arrayList.toArray(this.msw);
        this.msx = new e(this.msw);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        for (k kVar : this.msw) {
            kVar.gb(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.msx.gd(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwj() {
        return this.msx.dwj();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwh() {
        k[] kVarArr;
        long dwh = this.mst[0].dwh();
        for (int i = 1; i < this.mst.length; i++) {
            if (this.mst[i].dwh() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (dwh != -9223372036854775807L) {
            for (k kVar : this.msw) {
                if (kVar != this.mst[0] && kVar.gc(dwh) != dwh) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return dwh;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        return this.msx.dwi();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        long gc = this.msw[0].gc(j);
        for (int i = 1; i < this.msw.length; i++) {
            if (this.msw[i].gc(gc) != gc) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return gc;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        int i = this.msv - 1;
        this.msv = i;
        if (i <= 0) {
            int i2 = 0;
            for (k kVar2 : this.mst) {
                i2 += kVar2.dwg().length;
            }
            t[] tVarArr = new t[i2];
            k[] kVarArr = this.mst;
            int length = kVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                u dwg = kVarArr[i3].dwg();
                int i5 = dwg.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = dwg.KR(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lYR = new u(tVarArr);
            this.mrg.a((k) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        if (this.lYR != null) {
            this.mrg.a((k.a) this);
        }
    }
}
