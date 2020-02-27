package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class a implements b.a {
    private final int bitrate;
    private final long lZB;
    private final long mgy;

    public a(long j, int i, long j2) {
        this.mgy = j;
        this.bitrate = i;
        this.lZB = j2 == -1 ? -9223372036854775807L : fN(j2);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duO() {
        return this.lZB != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        if (this.lZB == -9223372036854775807L) {
            return 0L;
        }
        return this.mgy + ((v.h(j, 0L, this.lZB) * this.bitrate) / 8000000);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fN(long j) {
        return ((Math.max(0L, j - this.mgy) * TimeUtils.NANOS_PER_MS) * 8) / this.bitrate;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZB;
    }
}
