package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.o;
/* loaded from: classes6.dex */
final class b implements d.b {
    private final o[] mrO;
    private final int[] mtr;

    public b(int[] iArr, o[] oVarArr) {
        this.mtr = iArr;
        this.mrO = oVarArr;
    }

    @Override // com.google.android.exoplayer2.source.a.d.b
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        for (int i3 = 0; i3 < this.mtr.length; i3++) {
            if (i2 == this.mtr[i3]) {
                return this.mrO[i3];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
        return new com.google.android.exoplayer2.extractor.d();
    }

    public int[] dwL() {
        int[] iArr = new int[this.mrO.length];
        for (int i = 0; i < this.mrO.length; i++) {
            if (this.mrO[i] != null) {
                iArr[i] = this.mrO[i].dww();
            }
        }
        return iArr;
    }

    public void gk(long j) {
        o[] oVarArr;
        for (o oVar : this.mrO) {
            if (oVar != null) {
                oVar.gk(j);
            }
        }
    }
}
