package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.o;
/* loaded from: classes6.dex */
final class b implements d.b {
    private final o[] mrD;
    private final int[] mtg;

    public b(int[] iArr, o[] oVarArr) {
        this.mtg = iArr;
        this.mrD = oVarArr;
    }

    @Override // com.google.android.exoplayer2.source.a.d.b
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        for (int i3 = 0; i3 < this.mtg.length; i3++) {
            if (i2 == this.mtg[i3]) {
                return this.mrD[i3];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
        return new com.google.android.exoplayer2.extractor.d();
    }

    public int[] dwK() {
        int[] iArr = new int[this.mrD.length];
        for (int i = 0; i < this.mrD.length; i++) {
            if (this.mrD[i] != null) {
                iArr[i] = this.mrD[i].dwv();
            }
        }
        return iArr;
    }

    public void gk(long j) {
        o[] oVarArr;
        for (o oVar : this.mrD) {
            if (oVar != null) {
                oVar.gk(j);
            }
        }
    }
}
