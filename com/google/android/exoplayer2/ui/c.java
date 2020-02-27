package com.google.android.exoplayer2.ui;

import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public interface c {

    /* loaded from: classes6.dex */
    public interface a {
        void a(c cVar, long j);

        void a(c cVar, long j, boolean z);

        void b(c cVar, long j);
    }

    void a(a aVar);

    void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i);

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z);

    void setPosition(long j);
}
