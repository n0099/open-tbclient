package com.google.android.exoplayer2.source.a;

import android.util.Log;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.o;
/* loaded from: classes4.dex */
final class b implements d.b {
    private final o[] mnb;
    private final int[] moE;

    public b(int[] iArr, o[] oVarArr) {
        this.moE = iArr;
        this.mnb = oVarArr;
    }

    @Override // com.google.android.exoplayer2.source.a.d.b
    public com.google.android.exoplayer2.extractor.m dJ(int i, int i2) {
        for (int i3 = 0; i3 < this.moE.length; i3++) {
            if (i2 == this.moE[i3]) {
                return this.mnb[i3];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
        return new com.google.android.exoplayer2.extractor.d();
    }

    public int[] dul() {
        int[] iArr = new int[this.mnb.length];
        for (int i = 0; i < this.mnb.length; i++) {
            if (this.mnb[i] != null) {
                iArr[i] = this.mnb[i].dtW();
            }
        }
        return iArr;
    }

    public void gh(long j) {
        o[] oVarArr;
        for (o oVar : this.mnb) {
            if (oVar != null) {
                oVar.gh(j);
            }
        }
    }
}
