package com.facebook.imagepipeline.producers;
/* loaded from: classes6.dex */
public interface Producer<T> {
    void produceResults(Consumer<T> consumer, ProducerContext producerContext);
}
