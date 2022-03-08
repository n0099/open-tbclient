package com.google.android.exoplayer2.extractor;
/* loaded from: classes7.dex */
public interface ExtractorOutput {
    void endTracks();

    void seekMap(SeekMap seekMap);

    TrackOutput track(int i2, int i3);
}
