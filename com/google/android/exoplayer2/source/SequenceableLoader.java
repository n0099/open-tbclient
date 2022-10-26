package com.google.android.exoplayer2.source;
/* loaded from: classes7.dex */
public interface SequenceableLoader {

    /* loaded from: classes7.dex */
    public interface Callback {
        void onContinueLoadingRequested(SequenceableLoader sequenceableLoader);
    }

    boolean continueLoading(long j);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();
}
