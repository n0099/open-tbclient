package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.util.TriState;
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
/* loaded from: classes7.dex */
public abstract class MultiplexProducer implements Producer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRAS_STARTED_AS_PREFETCH = "started_as_prefetch";
    public transient /* synthetic */ FieldHolder $fh;
    public final String mDedupedRequestsCountKey;
    public final Producer mInputProducer;
    public final boolean mKeepCancelledFetchAsLowPriority;
    public final Map mMultiplexers;
    public final String mProducerName;

    /* renamed from: com.facebook.imagepipeline.producers.MultiplexProducer$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public abstract Closeable cloneOrNull(Closeable closeable);

    public abstract Object getKey(ProducerContext producerContext);

    /* loaded from: classes7.dex */
    public class Multiplexer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CopyOnWriteArraySet mConsumerContextPairs;
        @Nullable
        public ForwardingConsumer mForwardingConsumer;
        public final Object mKey;
        @Nullable
        public Closeable mLastIntermediateResult;
        public float mLastProgress;
        public int mLastStatus;
        @Nullable
        public BaseProducerContext mMultiplexProducerContext;
        public final /* synthetic */ MultiplexProducer this$0;

        /* loaded from: classes7.dex */
        public class ForwardingConsumer extends BaseConsumer {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = multiplexer;
            }

            public /* synthetic */ ForwardingConsumer(Multiplexer multiplexer, AnonymousClass1 anonymousClass1) {
                this(multiplexer);
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

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onProgressUpdateImpl(float f) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("MultiplexProducer#onProgressUpdate");
                        }
                        this.this$1.onProgressUpdate(this, f);
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(Closeable closeable, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, closeable, i) == null) {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("MultiplexProducer#onNewResult");
                        }
                        this.this$1.onNextResult(this, closeable, i);
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }
        }

        public Multiplexer(MultiplexProducer multiplexProducer, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiplexProducer, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = multiplexProducer;
            this.mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
            this.mKey = obj;
        }

        public void onProgressUpdate(ForwardingConsumer forwardingConsumer, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048580, this, forwardingConsumer, f) == null) {
                synchronized (this) {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    this.mLastProgress = f;
                    Iterator it = this.mConsumerContextPairs.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            ((Consumer) pair.first).onProgressUpdate(f);
                        }
                    }
                }
            }
        }

        private void addCallbacks(Pair pair, ProducerContext producerContext) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                                if (remove) {
                                    if (this.this$1.mConsumerContextPairs.isEmpty()) {
                                        baseProducerContext = this.this$1.mMultiplexProducerContext;
                                        list2 = null;
                                    } else {
                                        List updateIsPrefetch = this.this$1.updateIsPrefetch();
                                        list2 = this.this$1.updatePriority();
                                        list3 = this.this$1.updateIsIntermediateResultExpected();
                                        baseProducerContext = null;
                                        list = updateIsPrefetch;
                                    }
                                } else {
                                    baseProducerContext = null;
                                    list2 = null;
                                }
                                list3 = list2;
                            }
                            BaseProducerContext.callOnIsPrefetchChanged(list);
                            BaseProducerContext.callOnPriorityChanged(list2);
                            BaseProducerContext.callOnIsIntermediateResultExpectedChanged(list3);
                            if (baseProducerContext != null) {
                                if (this.this$1.this$0.mKeepCancelledFetchAsLowPriority && !baseProducerContext.isPrefetch()) {
                                    BaseProducerContext.callOnPriorityChanged(baseProducerContext.setPriorityNoCallbacks(Priority.LOW));
                                } else {
                                    baseProducerContext.cancel();
                                }
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
            if ((interceptable == null || interceptable.invokeL(65544, this, closeable) == null) && closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void onCancelled(ForwardingConsumer forwardingConsumer) {
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
                    startInputProducerIfHasAttachedConsumers(TriState.UNSET);
                }
            }
        }

        private synchronized boolean computeIsIntermediateResultExpected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
                synchronized (this) {
                    Iterator it = this.mConsumerContextPairs.iterator();
                    while (it.hasNext()) {
                        if (((ProducerContext) ((Pair) it.next()).second).isIntermediateResultExpected()) {
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
                    Iterator it = this.mConsumerContextPairs.iterator();
                    while (it.hasNext()) {
                        if (!((ProducerContext) ((Pair) it.next()).second).isPrefetch()) {
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
                    Iterator it = this.mConsumerContextPairs.iterator();
                    while (it.hasNext()) {
                        priority = Priority.getHigherPriority(priority, ((ProducerContext) ((Pair) it.next()).second).getPriority());
                    }
                }
                return priority;
            }
            return (Priority) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startInputProducerIfHasAttachedConsumers(TriState triState) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, triState) == null) {
                synchronized (this) {
                    boolean z2 = true;
                    if (this.mMultiplexProducerContext == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    if (this.mForwardingConsumer != null) {
                        z2 = false;
                    }
                    Preconditions.checkArgument(z2);
                    if (this.mConsumerContextPairs.isEmpty()) {
                        this.this$0.removeMultiplexer(this.mKey, this);
                        return;
                    }
                    ProducerContext producerContext = (ProducerContext) ((Pair) this.mConsumerContextPairs.iterator().next()).second;
                    BaseProducerContext baseProducerContext = new BaseProducerContext(producerContext.getImageRequest(), producerContext.getId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority(), producerContext.getImagePipelineConfig());
                    this.mMultiplexProducerContext = baseProducerContext;
                    baseProducerContext.putExtras(producerContext.getExtras());
                    if (triState.isSet()) {
                        this.mMultiplexProducerContext.setExtra(MultiplexProducer.EXTRAS_STARTED_AS_PREFETCH, Boolean.valueOf(triState.asBoolean()));
                    }
                    ForwardingConsumer forwardingConsumer = new ForwardingConsumer(this, null);
                    this.mForwardingConsumer = forwardingConsumer;
                    this.this$0.mInputProducer.produceResults(forwardingConsumer, this.mMultiplexProducerContext);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List updateIsIntermediateResultExpected() {
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
        public synchronized List updateIsPrefetch() {
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
        public synchronized List updatePriority() {
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

        public boolean addNewConsumer(Consumer consumer, ProducerContext producerContext) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, consumer, producerContext)) == null) {
                Pair create = Pair.create(consumer, producerContext);
                synchronized (this) {
                    if (this.this$0.getExistingMultiplexer(this.mKey) != this) {
                        return false;
                    }
                    this.mConsumerContextPairs.add(create);
                    List updateIsPrefetch = updateIsPrefetch();
                    List updatePriority = updatePriority();
                    List updateIsIntermediateResultExpected = updateIsIntermediateResultExpected();
                    Closeable closeable = this.mLastIntermediateResult;
                    float f = this.mLastProgress;
                    int i = this.mLastStatus;
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
                            if (f > 0.0f) {
                                consumer.onProgressUpdate(f);
                            }
                            consumer.onNewResult(closeable, i);
                            closeSafely(closeable);
                        }
                    }
                    addCallbacks(create, producerContext);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }

        public void onFailure(ForwardingConsumer forwardingConsumer, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forwardingConsumer, th) == null) {
                synchronized (this) {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    Iterator it = this.mConsumerContextPairs.iterator();
                    this.mConsumerContextPairs.clear();
                    this.this$0.removeMultiplexer(this.mKey, this);
                    closeSafely(this.mLastIntermediateResult);
                    this.mLastIntermediateResult = null;
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            ((ProducerContext) pair.second).getProducerListener().onProducerFinishWithFailure((ProducerContext) pair.second, this.this$0.mProducerName, th, null);
                            ((Consumer) pair.first).onFailure(th);
                        }
                    }
                }
            }
        }

        public void onNextResult(ForwardingConsumer forwardingConsumer, Closeable closeable, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, forwardingConsumer, closeable, i) == null) {
                synchronized (this) {
                    if (this.mForwardingConsumer != forwardingConsumer) {
                        return;
                    }
                    closeSafely(this.mLastIntermediateResult);
                    this.mLastIntermediateResult = null;
                    Iterator it = this.mConsumerContextPairs.iterator();
                    int size = this.mConsumerContextPairs.size();
                    if (BaseConsumer.isNotLast(i)) {
                        this.mLastIntermediateResult = this.this$0.cloneOrNull(closeable);
                        this.mLastStatus = i;
                    } else {
                        this.mConsumerContextPairs.clear();
                        this.this$0.removeMultiplexer(this.mKey, this);
                    }
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            if (BaseConsumer.isLast(i)) {
                                ((ProducerContext) pair.second).getProducerListener().onProducerFinishWithSuccess((ProducerContext) pair.second, this.this$0.mProducerName, null);
                                if (this.mMultiplexProducerContext != null) {
                                    ((ProducerContext) pair.second).putExtras(this.mMultiplexProducerContext.getExtras());
                                }
                                ((ProducerContext) pair.second).setExtra(this.this$0.mDedupedRequestsCountKey, Integer.valueOf(size));
                            }
                            ((Consumer) pair.first).onNewResult(closeable, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiplexProducer(Producer producer, String str, String str2) {
        this(producer, str, str2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Producer) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public MultiplexProducer(Producer producer, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInputProducer = producer;
        this.mMultiplexers = new HashMap();
        this.mKeepCancelledFetchAsLowPriority = z;
        this.mProducerName = str;
        this.mDedupedRequestsCountKey = str2;
    }

    private synchronized Multiplexer createAndPutNewMultiplexer(Object obj) {
        InterceptResult invokeL;
        Multiplexer multiplexer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, obj)) == null) {
            synchronized (this) {
                multiplexer = new Multiplexer(this, obj);
                this.mMultiplexers.put(obj, multiplexer);
            }
            return multiplexer;
        }
        return (Multiplexer) invokeL.objValue;
    }

    public synchronized Multiplexer getExistingMultiplexer(Object obj) {
        InterceptResult invokeL;
        Multiplexer multiplexer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            synchronized (this) {
                multiplexer = (Multiplexer) this.mMultiplexers.get(obj);
            }
            return multiplexer;
        }
        return (Multiplexer) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        boolean z;
        Multiplexer existingMultiplexer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, consumer, producerContext) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("MultiplexProducer#produceResults");
                }
                producerContext.getProducerListener().onProducerStart(producerContext, this.mProducerName);
                Object key = getKey(producerContext);
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
                    existingMultiplexer.startInputProducerIfHasAttachedConsumers(TriState.valueOf(producerContext.isPrefetch()));
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }

    public synchronized void removeMultiplexer(Object obj, Multiplexer multiplexer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, obj, multiplexer) == null) {
            synchronized (this) {
                if (this.mMultiplexers.get(obj) == multiplexer) {
                    this.mMultiplexers.remove(obj);
                }
            }
        }
    }
}
