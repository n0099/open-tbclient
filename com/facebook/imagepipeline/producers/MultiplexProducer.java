package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {
    public final Producer<T> mInputProducer;
    @VisibleForTesting
    @GuardedBy("this")
    public final Map<K, MultiplexProducer<K, T>.Multiplexer> mMultiplexers = new HashMap();

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public class Multiplexer {
        public final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
        @GuardedBy("Multiplexer.this")
        @Nullable
        public MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer mForwardingConsumer;
        public final K mKey;
        @GuardedBy("Multiplexer.this")
        @Nullable
        public T mLastIntermediateResult;
        @GuardedBy("Multiplexer.this")
        public float mLastProgress;
        @GuardedBy("Multiplexer.this")
        public int mLastStatus;
        @GuardedBy("Multiplexer.this")
        @Nullable
        public BaseProducerContext mMultiplexProducerContext;

        /* loaded from: classes6.dex */
        public class ForwardingConsumer extends BaseConsumer<T> {
            public ForwardingConsumer() {
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onCancellationImpl() {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onCancellation");
                    }
                    Multiplexer.this.onCancelled(this);
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onFailureImpl(Throwable th) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onFailure");
                    }
                    Multiplexer.this.onFailure(this, th);
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer$ForwardingConsumer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public /* bridge */ /* synthetic */ void onNewResultImpl(Object obj, int i2) {
                onNewResultImpl((ForwardingConsumer) ((Closeable) obj), i2);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onProgressUpdateImpl(float f2) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onProgressUpdate");
                    }
                    Multiplexer.this.onProgressUpdate(this, f2);
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }

            public void onNewResultImpl(T t, int i2) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onNewResult");
                    }
                    Multiplexer.this.onNextResult(this, t, i2);
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }
        }

        public Multiplexer(K k) {
            this.mKey = k;
        }

        private void addCallbacks(final Pair<Consumer<T>, ProducerContext> pair, ProducerContext producerContext) {
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    boolean remove;
                    List list;
                    BaseProducerContext baseProducerContext;
                    List list2;
                    List list3;
                    synchronized (Multiplexer.this) {
                        remove = Multiplexer.this.mConsumerContextPairs.remove(pair);
                        list = null;
                        if (!remove) {
                            baseProducerContext = null;
                            list2 = null;
                        } else if (Multiplexer.this.mConsumerContextPairs.isEmpty()) {
                            baseProducerContext = Multiplexer.this.mMultiplexProducerContext;
                            list2 = null;
                        } else {
                            List updateIsPrefetch = Multiplexer.this.updateIsPrefetch();
                            list2 = Multiplexer.this.updatePriority();
                            list3 = Multiplexer.this.updateIsIntermediateResultExpected();
                            baseProducerContext = null;
                            list = updateIsPrefetch;
                        }
                        list3 = list2;
                    }
                    BaseProducerContext.callOnIsPrefetchChanged(list);
                    BaseProducerContext.callOnPriorityChanged(list2);
                    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(list3);
                    if (baseProducerContext != null) {
                        baseProducerContext.cancel();
                    }
                    if (remove) {
                        ((Consumer) pair.first).onCancellation();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(Multiplexer.this.updateIsIntermediateResultExpected());
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsPrefetchChanged() {
                    BaseProducerContext.callOnIsPrefetchChanged(Multiplexer.this.updateIsPrefetch());
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onPriorityChanged() {
                    BaseProducerContext.callOnPriorityChanged(Multiplexer.this.updatePriority());
                }
            });
        }

        private void closeSafely(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        private synchronized boolean computeIsIntermediateResultExpected() {
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) it.next().second).isIntermediateResultExpected()) {
                    return true;
                }
            }
            return false;
        }

        private synchronized boolean computeIsPrefetch() {
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) it.next().second).isPrefetch()) {
                    return false;
                }
            }
            return true;
        }

        private synchronized Priority computePriority() {
            Priority priority;
            priority = Priority.LOW;
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                priority = Priority.getHigherPriority(priority, ((ProducerContext) it.next().second).getPriority());
            }
            return priority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startInputProducerIfHasAttachedConsumers() {
            synchronized (this) {
                boolean z = true;
                Preconditions.checkArgument(this.mMultiplexProducerContext == null);
                if (this.mForwardingConsumer != null) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                if (this.mConsumerContextPairs.isEmpty()) {
                    MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                    return;
                }
                ProducerContext producerContext = (ProducerContext) this.mConsumerContextPairs.iterator().next().second;
                this.mMultiplexProducerContext = new BaseProducerContext(producerContext.getImageRequest(), producerContext.getId(), producerContext.getListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());
                MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer = new ForwardingConsumer();
                this.mForwardingConsumer = forwardingConsumer;
                MultiplexProducer.this.mInputProducer.produceResults(forwardingConsumer, this.mMultiplexProducerContext);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ProducerContextCallbacks> updateIsIntermediateResultExpected() {
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            return this.mMultiplexProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ProducerContextCallbacks> updateIsPrefetch() {
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            return this.mMultiplexProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch());
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ProducerContextCallbacks> updatePriority() {
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            return this.mMultiplexProducerContext.setPriorityNoCallbacks(computePriority());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.Consumer<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean addNewConsumer(Consumer<T> consumer, ProducerContext producerContext) {
            Pair<Consumer<T>, ProducerContext> create = Pair.create(consumer, producerContext);
            synchronized (this) {
                if (MultiplexProducer.this.getExistingMultiplexer(this.mKey) != this) {
                    return false;
                }
                this.mConsumerContextPairs.add(create);
                List<ProducerContextCallbacks> updateIsPrefetch = updateIsPrefetch();
                List<ProducerContextCallbacks> updatePriority = updatePriority();
                List<ProducerContextCallbacks> updateIsIntermediateResultExpected = updateIsIntermediateResultExpected();
                Closeable closeable = this.mLastIntermediateResult;
                float f2 = this.mLastProgress;
                int i2 = this.mLastStatus;
                BaseProducerContext.callOnIsPrefetchChanged(updateIsPrefetch);
                BaseProducerContext.callOnPriorityChanged(updatePriority);
                BaseProducerContext.callOnIsIntermediateResultExpectedChanged(updateIsIntermediateResultExpected);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.mLastIntermediateResult) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = MultiplexProducer.this.cloneOrNull(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f2 > 0.0f) {
                            consumer.onProgressUpdate(f2);
                        }
                        consumer.onNewResult(closeable, i2);
                        closeSafely(closeable);
                    }
                }
                addCallbacks(create, producerContext);
                return true;
            }
        }

        public void onCancelled(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                this.mForwardingConsumer = null;
                this.mMultiplexProducerContext = null;
                closeSafely(this.mLastIntermediateResult);
                this.mLastIntermediateResult = null;
                startInputProducerIfHasAttachedConsumers();
            }
        }

        public void onFailure(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, Throwable th) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                this.mConsumerContextPairs.clear();
                MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                closeSafely(this.mLastIntermediateResult);
                this.mLastIntermediateResult = null;
                while (it.hasNext()) {
                    Pair<Consumer<T>, ProducerContext> next = it.next();
                    synchronized (next) {
                        ((Consumer) next.first).onFailure(th);
                    }
                }
            }
        }

        public void onNextResult(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, T t, int i2) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                closeSafely(this.mLastIntermediateResult);
                this.mLastIntermediateResult = null;
                Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                if (BaseConsumer.isNotLast(i2)) {
                    this.mLastIntermediateResult = (T) MultiplexProducer.this.cloneOrNull(t);
                    this.mLastStatus = i2;
                } else {
                    this.mConsumerContextPairs.clear();
                    MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                }
                while (it.hasNext()) {
                    Pair<Consumer<T>, ProducerContext> next = it.next();
                    synchronized (next) {
                        ((Consumer) next.first).onNewResult(t, i2);
                    }
                }
            }
        }

        public void onProgressUpdate(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, float f2) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                this.mLastProgress = f2;
                Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                while (it.hasNext()) {
                    Pair<Consumer<T>, ProducerContext> next = it.next();
                    synchronized (next) {
                        ((Consumer) next.first).onProgressUpdate(f2);
                    }
                }
            }
        }
    }

    public MultiplexProducer(Producer<T> producer) {
        this.mInputProducer = producer;
    }

    private synchronized MultiplexProducer<K, T>.Multiplexer createAndPutNewMultiplexer(K k) {
        MultiplexProducer<K, T>.Multiplexer multiplexer;
        multiplexer = new Multiplexer(k);
        this.mMultiplexers.put(k, multiplexer);
        return multiplexer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K k) {
        return this.mMultiplexers.get(k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeMultiplexer(K k, MultiplexProducer<K, T>.Multiplexer multiplexer) {
        if (this.mMultiplexers.get(k) == multiplexer) {
            this.mMultiplexers.remove(k);
        }
    }

    public abstract T cloneOrNull(T t);

    public abstract K getKey(ProducerContext producerContext);

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        MultiplexProducer<K, T>.Multiplexer existingMultiplexer;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("MultiplexProducer#produceResults");
            }
            K key = getKey(producerContext);
            do {
                z = false;
                synchronized (this) {
                    existingMultiplexer = getExistingMultiplexer(key);
                    if (existingMultiplexer == null) {
                        existingMultiplexer = createAndPutNewMultiplexer(key);
                        z = true;
                    }
                }
            } while (!existingMultiplexer.addNewConsumer(consumer, producerContext));
            if (z) {
                existingMultiplexer.startInputProducerIfHasAttachedConsumers();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
