package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.s;
/* loaded from: classes6.dex */
public final class m {
    private final SparseArray<s> mwA = new SparseArray<>();

    public s Lg(int i) {
        s sVar = this.mwA.get(i);
        if (sVar == null) {
            s sVar2 = new s(Format.OFFSET_SAMPLE_RELATIVE);
            this.mwA.put(i, sVar2);
            return sVar2;
        }
        return sVar;
    }

    public void reset() {
        this.mwA.clear();
    }
}
