package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public interface ProducerContextCallbacks {
    void onCancellationRequested();

    void onIsIntermediateResultExpectedChanged();

    void onIsPrefetchChanged();

    void onPriorityChanged();
}
