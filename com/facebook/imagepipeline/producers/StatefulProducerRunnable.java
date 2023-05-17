package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    public final Consumer<T> mConsumer;
    public final ProducerContext mProducerContext;
    public final ProducerListener2 mProducerListener;
    public final String mProducerName;

    @Override // com.facebook.common.executors.StatefulRunnable
    public abstract void disposeResult(T t);

    @Nullable
    public Map<String, String> getExtraMapOnCancellation() {
        return null;
    }

    @Nullable
    public Map<String, String> getExtraMapOnFailure(Exception exc) {
        return null;
    }

    @Nullable
    public Map<String, String> getExtraMapOnSuccess(T t) {
        return null;
    }

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str) {
        this.mConsumer = consumer;
        this.mProducerListener = producerListener2;
        this.mProducerName = str;
        this.mProducerContext = producerContext;
        producerListener2.onProducerStart(producerContext, str);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onCancellation() {
        Map<String, String> map;
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        if (producerListener2.requiresExtraMap(producerContext, str)) {
            map = getExtraMapOnCancellation();
        } else {
            map = null;
        }
        producerListener2.onProducerFinishWithCancellation(producerContext, str, map);
        this.mConsumer.onCancellation();
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onFailure(Exception exc) {
        Map<String, String> map;
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        if (producerListener2.requiresExtraMap(producerContext, str)) {
            map = getExtraMapOnFailure(exc);
        } else {
            map = null;
        }
        producerListener2.onProducerFinishWithFailure(producerContext, str, exc, map);
        this.mConsumer.onFailure(exc);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onSuccess(T t) {
        Map<String, String> map;
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        if (producerListener2.requiresExtraMap(producerContext, str)) {
            map = getExtraMapOnSuccess(t);
        } else {
            map = null;
        }
        producerListener2.onProducerFinishWithSuccess(producerContext, str, map);
        this.mConsumer.onNewResult(t, 1);
    }
}
