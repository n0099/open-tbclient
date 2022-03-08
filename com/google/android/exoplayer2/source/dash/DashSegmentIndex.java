package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
/* loaded from: classes7.dex */
public interface DashSegmentIndex {
    public static final int INDEX_UNBOUNDED = -1;

    long getDurationUs(int i2, long j2);

    int getFirstSegmentNum();

    int getSegmentCount(long j2);

    int getSegmentNum(long j2, long j3);

    RangedUri getSegmentUrl(int i2);

    long getTimeUs(int i2);

    boolean isExplicit();
}
