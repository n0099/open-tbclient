package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
/* loaded from: classes7.dex */
public interface DashChunkSource extends ChunkSource {

    /* loaded from: classes7.dex */
    public interface Factory {
        DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i2, int[] iArr, TrackSelection trackSelection, int i3, long j2, boolean z, boolean z2);
    }

    void updateManifest(DashManifest dashManifest, int i2);
}
