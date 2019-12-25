package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.s;
/* loaded from: classes4.dex */
public final class m {
    private final SparseArray<s> msa = new SparseArray<>();

    public s KS(int i) {
        s sVar = this.msa.get(i);
        if (sVar == null) {
            s sVar2 = new s(Format.OFFSET_SAMPLE_RELATIVE);
            this.msa.put(i, sVar2);
            return sVar2;
        }
        return sVar;
    }

    public void reset() {
        this.msa.clear();
    }
}
