package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class a implements b.a {
    private final int bitrate;
    private final long lZO;
    private final long mgL;

    public a(long j, int i, long j2) {
        this.mgL = j;
        this.bitrate = i;
        this.lZO = j2 == -1 ? -9223372036854775807L : fN(j2);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean duR() {
        return this.lZO != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fL(long j) {
        if (this.lZO == -9223372036854775807L) {
            return 0L;
        }
        return this.mgL + ((v.h(j, 0L, this.lZO) * this.bitrate) / 8000000);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fN(long j) {
        return ((Math.max(0L, j - this.mgL) * TimeUtils.NANOS_PER_MS) * 8) / this.bitrate;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.lZO;
    }
}
