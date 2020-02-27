package com.google.android.exoplayer2.text.e;

import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final b mBB;
    private final long[] mBC;
    private final Map<String, e> mBD;
    private final Map<String, c> mBE;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.mBB = bVar;
        this.mBE = map2;
        this.mBD = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.mBC = bVar.dyi();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gw(long j) {
        int b = v.b(this.mBC, j, false, false);
        if (b < this.mBC.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dxI() {
        return this.mBC.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lk(int i) {
        return this.mBC[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gx(long j) {
        return this.mBB.a(j, this.mBD, this.mBE);
    }
}
