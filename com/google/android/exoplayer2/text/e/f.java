package com.google.android.exoplayer2.text.e;

import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final Map<String, e> mDA;
    private final Map<String, c> mDB;
    private final b mDw;
    private final long[] mDz;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.mDw = bVar;
        this.mDB = map2;
        this.mDA = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.mDz = bVar.dyI();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gx(long j) {
        int b = v.b(this.mDz, j, false, false);
        if (b < this.mDz.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dyi() {
        return this.mDz.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lq(int i) {
        return this.mDz[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gy(long j) {
        return this.mDw.a(j, this.mDA, this.mDB);
    }
}
