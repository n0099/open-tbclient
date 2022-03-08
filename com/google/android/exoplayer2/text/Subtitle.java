package com.google.android.exoplayer2.text;

import java.util.List;
/* loaded from: classes7.dex */
public interface Subtitle {
    List<Cue> getCues(long j2);

    long getEventTime(int i2);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j2);
}
