package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.List;
/* loaded from: classes7.dex */
public interface TrackSelection {

    /* loaded from: classes7.dex */
    public interface Factory {
        TrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr);
    }

    boolean blacklist(int i2, long j2);

    int evaluateQueueSize(long j2, List<? extends MediaChunk> list);

    Format getFormat(int i2);

    int getIndexInTrackGroup(int i2);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(int i2);

    int indexOf(Format format);

    int length();

    void updateSelectedTrack(long j2, long j3, long j4);
}
