package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.s;
/* loaded from: classes6.dex */
public final class m {
    private final SparseArray<s> myt = new SparseArray<>();

    public s Lm(int i) {
        s sVar = this.myt.get(i);
        if (sVar == null) {
            s sVar2 = new s(Format.OFFSET_SAMPLE_RELATIVE);
            this.myt.put(i, sVar2);
            return sVar2;
        }
        return sVar;
    }

    public void reset() {
        this.myt.clear();
    }
}
