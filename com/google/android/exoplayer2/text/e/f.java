package com.google.android.exoplayer2.text.e;

import com.google.android.exoplayer2.util.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
final class f implements com.google.android.exoplayer2.text.e {
    private final b mAP;
    private final long[] mAQ;
    private final Map<String, e> mAR;
    private final Map<String, c> mAS;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.mAP = bVar;
        this.mAS = map2;
        this.mAR = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.mAQ = bVar.dwW();
    }

    @Override // com.google.android.exoplayer2.text.e
    public int gy(long j) {
        int b = v.b(this.mAQ, j, false, false);
        if (b < this.mAQ.length) {
            return b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.e
    public int dww() {
        return this.mAQ.length;
    }

    @Override // com.google.android.exoplayer2.text.e
    public long Lf(int i) {
        return this.mAQ[i];
    }

    @Override // com.google.android.exoplayer2.text.e
    public List<com.google.android.exoplayer2.text.b> gz(long j) {
        return this.mAP.a(j, this.mAR, this.mAS);
    }
}
