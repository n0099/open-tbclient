package com.google.android.exoplayer2;
/* loaded from: classes6.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final x timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(x xVar, int i, long j) {
        this.timeline = xVar;
        this.windowIndex = i;
        this.positionMs = j;
    }
}
