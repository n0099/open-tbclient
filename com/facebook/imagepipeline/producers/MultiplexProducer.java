package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Producer<T> mInputProducer;
    @VisibleForTesting
    @GuardedBy("this")
    public final Map<K, MultiplexProducer<K, T>.Multiplexer> mMultiplexers;

    /* renamed from: com.facebook.imagepipeline.producers.MultiplexProducer$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public class Multiplexer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs;
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
        public final /* synthetic */ MultiplexProducer this$0;

        /* loaded from: classes6.dex */
        public class ForwardingConsumer extends BaseConsumer<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Multiplexer this$1;

            public ForwardingConsumer(Multiplexer multiplexer) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {multiplexer};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = multiplexer;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onCancellationImpl() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("MultiplexProducer#onCancellation");
                        }
                        this.this$1.onCancelled(this);
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onFailureImpl(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("MultiplexProducer#onFailure");
                        }
                        this.this$1.onFailure(this, th);
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
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
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("MultiplexProducer#onProgressUpdate");
                        }
                        this.this$1.onProgressUpdate(this, f2);
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }

            public /* synthetic */ ForwardingConsumer(Multiplexer multiplexer, AnonymousClass1 anonymousClass1) {
                this(multiplexer);
            }

            public void onNewResultImpl(T t, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, t, i2) == null) {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("MultiplexProducer#onNewResult");
                        }
                        this.this$1.onNextResult(this, t, i2);
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }
        }

        public Multiplexer(MultiplexProducer multiplexProducer, K k) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiplexProducer, k};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = multiplexProducer;
            this.mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
            this.mKey = k;
        }

        private void addCallbacks(Pair<Consumer<T>, ProducerContext> pair, ProducerContext producerContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65543, this, pair, producerContext) == null) {
                producerContext.addCallbacks(new BaseProducerContextCallbacks(this, pair) { // from class: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Multiplexer this$1;
                    public final /* synthetic */ Pair val$consumerContextPair;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, pair};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$consumerContextPair = pair;
                    }

                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onCancellationRequested() {
                        boolean remove;
                        List list;
                        BaseProducerContext baseProducerContext;
                        List list2;
                        List list3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            synchronized (this.this$1) {
                                remove = this.this$1.mConsumerContextPairs.remove(this.val$consumerContextPair);
                                list = null;
                                if (!remove) {
                                    baseProducerContext = null;
                                    list2 = null;
                                } else if (this.this$1.mConsumerContextPairs.isEmpty()) {
                                    baseProducerContext = this.this$1.mMultiplexProducerContext;
                                    list2 = null;
                                } else {
                                    List updateIsPrefetch = this.this$1.updateIsPrefetch();
                                    list2 = this.this$1.updatePriority();
                                    list3 = this.this$1.updateIsIntermediateResultExpected();
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
                                ((Consumer) this.val$consumerContextPair.first).onCancellation();
                            }
                        }
                    }

                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onIsIntermediateResultExpectedChanged() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            BaseProducerContext.callOnIsIntermediateResultExpectedChanged(this.this$1.updateIsIntermediateResultExpected());
                        }
                    }

                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onIsPrefetchChanged() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            BaseProducerContext.callOnIsPrefetchChanged(this.this$1.updateIsPrefetch());
                        }
                    }

                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onPriorityChanged() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            BaseProducerContext.callOnPriorityChanged(this.this$1.updatePriority());
                        }
                    }
                });
            }
        }

        private void closeSafely(Closeable closeable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65544, this, closeable) == null) || closeable == null) {
                return;
            }
            try {
                closeable.close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        private synchronized boolean computeIsIntermediateResultExpected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
                synchronized (this) {
                    Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                    while (it.hasNext()) {
                        if (((ProducerContext) it.next().second).isIntermediateResultExpected()) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        private synchronized boolean computeIsPrefetch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
                synchronized (this) {
                    Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                    while (it.hasNext()) {
                        if (!((ProducerContext) it.next().second).isPrefetch()) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return invokeV.booleanValue;
        }

        private synchronized Priority computePriority() {
            InterceptResult invokeV;
            Priority priority;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
                synchronized (this) {
                    priority = Priority.LOW;
                    Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                    while (it.hasNext()) {
                        priority = Priority.getHigherPriority(priority, ((ProducerContext) it.next().second).getPriority());
                    }
                }
                return priority;
            }
            return (Priority) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startInputProducerIfHasAttachedConsumers() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                synchronized (this) {
                    boolean z = true;
                    Preconditions.checkArgument(this.mMultiplexProducerContext == null);
                    if (this.mForwardingConsumer != null) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    if (this.mConsumerContextPairs.isEmpty()) {
                        this.this$0.removeMultiplexer(this.mKey, this);
                        return;
                    }
                    ProducerContext producerContext = (ProducerContext) this.mConsumerContextPairs.iterator().next().second;
                    this.mMultiplexProducerContext = new BaseProducerContext(producerContext.getImageRequest(), producerContext.getId(), producerContext.getListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());
                    MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer = new ForwardingConsumer(this, null);
                    this.mForwardingConsumer = forwardingConsumer;
                    this.this$0.mInputProducer.produceResults(forwardingConsumer, this.mMultiplexProducerContext);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ProducerContextCallbacks> updateIsIntermediateResultExpected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
                synchronized (this) {
                    if (this.mMultiplexProducerContext == null) {
                        return null;
                    }
                    return this.mMultiplexProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());
                }
            }
            return (List) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ProducerContextCallbacks> updateIsPrefetch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
                synchronized (this) {
                    if (this.mMultiplexProducerContext == null) {
                        return null;
                    }
                    return this.mMultiplexProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch());
                }
            }
            return (List) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<ProducerContextCallbacks> updatePriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
                synchronized (this) {
                    if (this.mMultiplexProducerContext == null) {
                        return null;
                    }
                    return this.mMultiplexProducerContext.setPriorityNoCallbacks(computePriority());
                }
            }
            return (List) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.Consumer<T extends java.io.Closeable> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean addNewConsumer(Consumer<T> consumer, ProducerContext producerContext) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, consumer, producerContext)) == null) {
                Pair<Consumer<T>, ProducerContext> create = Pair.create(consumer, producerContext);
                synchronized (this) {
                    if (this.this$0.getExistingMultiplexer(this.mKey) != this) {
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
                                closeable = this.this$0.cloneOrNull(closeable);
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
            return invokeLL.booleanValue;
        }

        public void onCancelled(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forwardingConsumer) == null) {
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
        }

        public void onFailure(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forwardingConsumer, th) == null) {
                synchronized (this) {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                    this.mConsumerContextPairs.clear();
                    this.this$0.removeMultiplexer(this.mKey, this);
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
        }

        public void onNextResult(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, T t, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, forwardingConsumer, t, i2) == null) {
                synchronized (this) {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    closeSafely(this.mLastIntermediateResult);
                    this.mLastIntermediateResult = null;
                    Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                    if (BaseConsumer.isNotLast(i2)) {
                        this.mLastIntermediateResult = (T) this.this$0.cloneOrNull(t);
                        this.mLastStatus = i2;
                    } else {
                        this.mConsumerContextPairs.clear();
                        this.this$0.removeMultiplexer(this.mKey, this);
                    }
                    while (it.hasNext()) {
                        Pair<Consumer<T>, ProducerContext> next = it.next();
                        synchronized (next) {
                            ((Consumer) next.first).onNewResult(t, i2);
                        }
                    }
                }
            }
        }

        public void onProgressUpdate(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048580, this, forwardingConsumer, f2) == null) {
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
    }

    public MultiplexProducer(Producer<T> producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInputProducer = producer;
        this.mMultiplexers = new HashMap();
    }

    private synchronized MultiplexProducer<K, T>.Multiplexer createAndPutNewMultiplexer(K k) {
        InterceptResult invokeL;
        MultiplexProducer<K, T>.Multiplexer multiplexer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, k)) == null) {
            synchronized (this) {
                multiplexer = new Multiplexer(this, k);
                this.mMultiplexers.put(k, multiplexer);
            }
            return multiplexer;
        }
        return (Multiplexer) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K k) {
        InterceptResult invokeL;
        MultiplexProducer<K, T>.Multiplexer multiplexer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, k)) == null) {
            synchronized (this) {
                multiplexer = this.mMultiplexers.get(k);
            }
            return multiplexer;
        }
        return (Multiplexer) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeMultiplexer(K k, MultiplexProducer<K, T>.Multiplexer multiplexer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, k, multiplexer) == null) {
            synchronized (this) {
                if (this.mMultiplexers.get(k) == multiplexer) {
                    this.mMultiplexers.remove(k);
                }
            }
        }
    }

    public abstract T cloneOrNull(T t);

    public abstract K getKey(ProducerContext producerContext);

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        MultiplexProducer<K, T>.Multiplexer existingMultiplexer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, consumer, producerContext) == null) {
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
}
