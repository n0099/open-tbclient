package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes4.dex */
final class a implements b.a {
    private final int bitrate;
    private final long lUZ;
    private final long mbY;

    public a(long j, int i, long j2) {
        this.mbY = j;
        this.bitrate = i;
        this.lUZ = j2 == -1 ? -9223372036854775807L : fK(j2);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dsp() {
        return this.lUZ != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fI(long j) {
        if (this.lUZ == -9223372036854775807L) {
            return 0L;
        }
        return this.mbY + ((v.g(j, 0L, this.lUZ) * this.bitrate) / 8000000);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fK(long j) {
        return ((Math.max(0L, j - this.mbY) * TimeUtils.NANOS_PER_MS) * 8) / this.bitrate;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long drc() {
        return this.lUZ;
    }
}
