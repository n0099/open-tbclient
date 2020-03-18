package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
final class a implements b.a {
    private final int bitrate;
    private final long mbx;
    private final long mit;

    public a(long j, int i, long j2) {
        this.mit = j;
        this.bitrate = i;
        this.mbx = j2 == -1 ? -9223372036854775807L : fO(j2);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dvo() {
        return this.mbx != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fM(long j) {
        if (this.mbx == -9223372036854775807L) {
            return 0L;
        }
        return this.mit + ((v.h(j, 0L, this.mbx) * this.bitrate) / 8000000);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fO(long j) {
        return ((Math.max(0L, j - this.mit) * TimeUtils.NANOS_PER_MS) * 8) / this.bitrate;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long getDurationUs() {
        return this.mbx;
    }
}
