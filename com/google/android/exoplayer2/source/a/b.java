package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.o;
/* loaded from: classes6.dex */
final class b implements d.b {
    private final o[] mrB;
    private final int[] mte;

    public b(int[] iArr, o[] oVarArr) {
        this.mte = iArr;
        this.mrB = oVarArr;
    }

    @Override // com.google.android.exoplayer2.source.a.d.b
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        for (int i3 = 0; i3 < this.mte.length; i3++) {
            if (i2 == this.mte[i3]) {
                return this.mrB[i3];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
        return new com.google.android.exoplayer2.extractor.d();
    }

    public int[] dwI() {
        int[] iArr = new int[this.mrB.length];
        for (int i = 0; i < this.mrB.length; i++) {
            if (this.mrB[i] != null) {
                iArr[i] = this.mrB[i].dwt();
            }
        }
        return iArr;
    }

    public void gk(long j) {
        o[] oVarArr;
        for (o oVar : this.mrB) {
            if (oVar != null) {
                oVar.gk(j);
            }
        }
    }
}
