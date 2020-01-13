package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.s;
/* loaded from: classes5.dex */
public final class m {
    private final SparseArray<s> mvP = new SparseArray<>();

    public s Lb(int i) {
        s sVar = this.mvP.get(i);
        if (sVar == null) {
            s sVar2 = new s(Format.OFFSET_SAMPLE_RELATIVE);
            this.mvP.put(i, sVar2);
            return sVar2;
        }
        return sVar;
    }

    public void reset() {
        this.mvP.clear();
    }
}
