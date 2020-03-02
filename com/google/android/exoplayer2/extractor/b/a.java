package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class a implements b.a {
    private final int bitrate;
    private final long lZD;
    private final long mgA;

    public a(long j, int i, long j2) {
        this.mgA = j;
        this.bitrate = i;
        this.lZD = j2 == -1 ? -9223372036854775807L : fN(j2);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duQ() {
        return this.lZD != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        if (this.lZD == -9223372036854775807L) {
            return 0L;
        }
        return this.mgA + ((v.h(j, 0L, this.lZD) * this.bitrate) / 8000000);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fN(long j) {
        return ((Math.max(0L, j - this.mgA) * TimeUtils.NANOS_PER_MS) * 8) / this.bitrate;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZD;
    }
}
