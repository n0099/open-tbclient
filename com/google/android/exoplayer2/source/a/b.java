package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.o;
/* loaded from: classes5.dex */
final class b implements d.b {
    private final o[] mqV;
    private final int[] msy;

    public b(int[] iArr, o[] oVarArr) {
        this.msy = iArr;
        this.mqV = oVarArr;
    }

    @Override // com.google.android.exoplayer2.source.a.d.b
    public com.google.android.exoplayer2.extractor.m dH(int i, int i2) {
        for (int i3 = 0; i3 < this.msy.length; i3++) {
            if (i2 == this.msy[i3]) {
                return this.mqV[i3];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
        return new com.google.android.exoplayer2.extractor.d();
    }

    public int[] dvy() {
        int[] iArr = new int[this.mqV.length];
        for (int i = 0; i < this.mqV.length; i++) {
            if (this.mqV[i] != null) {
                iArr[i] = this.mqV[i].dvj();
            }
        }
        return iArr;
    }

    public void gm(long j) {
        o[] oVarArr;
        for (o oVar : this.mqV) {
            if (oVar != null) {
                oVar.gm(j);
            }
        }
    }
}
