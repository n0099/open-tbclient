package com.google.android.exoplayer2.text.e;

import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final b mBD;
    private final long[] mBE;
    private final Map<String, e> mBF;
    private final Map<String, c> mBG;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.mBD = bVar;
        this.mBG = map2;
        this.mBF = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.mBE = bVar.dyk();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        int b = v.b(this.mBE, j, false, false);
        if (b < this.mBE.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxK() {
        return this.mBE.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        return this.mBE[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        return this.mBD.a(j, this.mBF, this.mBG);
    }
}
