package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.o;
/* loaded from: classes6.dex */
final class b implements d.b {
    private final o[] mtv;
    private final int[] muY;

    public b(int[] iArr, o[] oVarArr) {
        this.muY = iArr;
        this.mtv = oVarArr;
    }

    @Override // com.google.android.exoplayer2.source.a.d.b
    public com.google.android.exoplayer2.extractor.m dL(int i, int i2) {
        for (int i3 = 0; i3 < this.muY.length; i3++) {
            if (i2 == this.muY[i3]) {
                return this.mtv[i3];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
        return new com.google.android.exoplayer2.extractor.d();
    }

    public int[] dxi() {
        int[] iArr = new int[this.mtv.length];
        for (int i = 0; i < this.mtv.length; i++) {
            if (this.mtv[i] != null) {
                iArr[i] = this.mtv[i].dwT();
            }
        }
        return iArr;
    }

    public void gl(long j) {
        o[] oVarArr;
        for (o oVar : this.mtv) {
            if (oVar != null) {
                oVar.gl(j);
            }
        }
    }
}
