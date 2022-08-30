package com.facebook.imagepipeline.producers;
/* loaded from: classes7.dex */
public interface Producer<T> {
    void produceResults(Consumer<T> consumer, ProducerContext producerContext);
}
