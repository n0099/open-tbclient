package com.google.android.exoplayer2.text.e;

import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final b mBO;
    private final long[] mBP;
    private final Map<String, e> mBQ;
    private final Map<String, c> mBR;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.mBO = bVar;
        this.mBR = map2;
        this.mBQ = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.mBP = bVar.dyl();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        int b = v.b(this.mBP, j, false, false);
        if (b < this.mBP.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxL() {
        return this.mBP.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        return this.mBP[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        return this.mBO.a(j, this.mBQ, this.mBR);
    }
}
