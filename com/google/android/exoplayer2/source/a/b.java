package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.o;
/* loaded from: classes5.dex */
final class b implements d.b {
    private final o[] mqQ;
    private final int[] mst;

    public b(int[] iArr, o[] oVarArr) {
        this.mst = iArr;
        this.mqQ = oVarArr;
    }

    @Override // com.google.android.exoplayer2.source.a.d.b
    public com.google.android.exoplayer2.extractor.m dH(int i, int i2) {
        for (int i3 = 0; i3 < this.mst.length; i3++) {
            if (i2 == this.mst[i3]) {
                return this.mqQ[i3];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
        return new com.google.android.exoplayer2.extractor.d();
    }

    public int[] dvw() {
        int[] iArr = new int[this.mqQ.length];
        for (int i = 0; i < this.mqQ.length; i++) {
            if (this.mqQ[i] != null) {
                iArr[i] = this.mqQ[i].dvh();
            }
        }
        return iArr;
    }

    public void gm(long j) {
        o[] oVarArr;
        for (o oVar : this.mqQ) {
            if (oVar != null) {
                oVar.gm(j);
            }
        }
    }
}
