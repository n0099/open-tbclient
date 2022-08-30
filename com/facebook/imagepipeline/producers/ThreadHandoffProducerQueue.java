package com.facebook.imagepipeline.producers;
/* loaded from: classes7.dex */
public interface ThreadHandoffProducerQueue {
    void addToQueueOrExecute(Runnable runnable);

    boolean isQueueing();

    void remove(Runnable runnable);

    void startQueueing();

    void stopQueuing();
}
