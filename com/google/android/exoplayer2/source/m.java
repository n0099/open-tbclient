package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* loaded from: classes6.dex */
final class m implements k, k.a {
    private u lYE;
    private k.a mqT;
    public final k[] msf;
    private final IdentityHashMap<p, Integer> msh = new IdentityHashMap<>();
    private int msi;
    private k[] msj;
    private q msk;

    public m(k... kVarArr) {
        this.msf = kVarArr;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqT = aVar;
        this.msi = this.msf.length;
        for (k kVar : this.msf) {
            kVar.a(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwc() throws IOException {
        for (k kVar : this.msf) {
            kVar.dwc();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwd() {
        return this.lYE;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.msh.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dxd = fVarArr[i2].dxd();
                int i3 = 0;
                while (true) {
                    if (i3 < this.msf.length) {
                        if (this.msf[i3].dwd().a(dxd) == -1) {
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
        this.msh.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.msf.length);
        int i4 = 0;
        long j2 = j;
        while (i4 < this.msf.length) {
            for (int i5 = 0; i5 < fVarArr.length; i5++) {
                pVarArr3[i5] = iArr[i5] == i4 ? pVarArr[i5] : null;
                fVarArr2[i5] = iArr2[i5] == i4 ? fVarArr[i5] : null;
            }
            long a = this.msf[i4].a(fVarArr2, zArr, pVarArr3, zArr2, j2);
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
                    this.msh.put(pVarArr3[i6], Integer.valueOf(i4));
                } else if (iArr[i6] == i4) {
                    com.google.android.exoplayer2.util.a.checkState(pVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList.add(this.msf[i4]);
            }
            i4++;
        }
        System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
        this.msj = new k[arrayList.size()];
        arrayList.toArray(this.msj);
        this.msk = new e(this.msj);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        for (k kVar : this.msj) {
            kVar.gb(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.msk.gd(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwg() {
        return this.msk.dwg();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwe() {
        k[] kVarArr;
        long dwe = this.msf[0].dwe();
        for (int i = 1; i < this.msf.length; i++) {
            if (this.msf[i].dwe() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (dwe != -9223372036854775807L) {
            for (k kVar : this.msj) {
                if (kVar != this.msf[0] && kVar.gc(dwe) != dwe) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return dwe;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwf() {
        return this.msk.dwf();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        long gc = this.msj[0].gc(j);
        for (int i = 1; i < this.msj.length; i++) {
            if (this.msj[i].gc(gc) != gc) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return gc;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        int i = this.msi - 1;
        this.msi = i;
        if (i <= 0) {
            int i2 = 0;
            for (k kVar2 : this.msf) {
                i2 += kVar2.dwd().length;
            }
            t[] tVarArr = new t[i2];
            k[] kVarArr = this.msf;
            int length = kVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                u dwd = kVarArr[i3].dwd();
                int i5 = dwd.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = dwd.KR(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lYE = new u(tVarArr);
            this.mqT.a((k) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        if (this.lYE != null) {
            this.mqT.a((k.a) this);
        }
    }
}
