package com.google.android.exoplayer2.text.e;

import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final b mAU;
    private final long[] mAV;
    private final Map<String, e> mAW;
    private final Map<String, c> mAX;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.mAU = bVar;
        this.mAX = map2;
        this.mAW = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.mAV = bVar.dwY();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        int b = v.b(this.mAV, j, false, false);
        if (b < this.mAV.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dwy() {
        return this.mAV.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        return this.mAV[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gz(long j) {
        return this.mAU.a(j, this.mAW, this.mAX);
    }
}
