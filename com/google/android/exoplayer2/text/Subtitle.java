package com.google.android.exoplayer2.text;

import java.util.List;
/* loaded from: classes7.dex */
public interface Subtitle {
    List getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j);
}
