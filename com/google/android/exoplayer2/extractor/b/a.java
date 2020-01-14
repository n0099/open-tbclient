package com.google.android.exoplayer2.extractor.b;

import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
final class a implements b.a {
    private final int bitrate;
    private final long lYV;
    private final long mfS;

    public a(long j, int i, long j2) {
        this.mfS = j;
        this.bitrate = i;
        this.lYV = j2 == -1 ? -9223372036854775807L : fP(j2);
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public boolean dtD() {
        return this.lYV != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long fN(long j) {
        if (this.lYV == -9223372036854775807L) {
            return 0L;
        }
        return this.mfS + ((v.g(j, 0L, this.lYV) * this.bitrate) / 8000000);
    }

    @Override // com.google.android.exoplayer2.extractor.b.b.a
    public long fP(long j) {
        return ((Math.max(0L, j - this.mfS) * TimeUtils.NANOS_PER_MS) * 8) / this.bitrate;
    }

    @Override // com.google.android.exoplayer2.extractor.l
    public long dsq() {
        return this.lYV;
    }
}
