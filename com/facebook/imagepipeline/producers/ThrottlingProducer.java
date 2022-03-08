package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes7.dex */
public class ThrottlingProducer<T> implements Producer<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRODUCER_NAME = "ThrottlingProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor mExecutor;
    public final Producer<T> mInputProducer;
    public final int mMaxSimultaneousRequests;
    @GuardedBy("this")
    public int mNumCurrentRequests;
    @GuardedBy("this")
    public final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> mPendingRequests;

    /* renamed from: com.facebook.imagepipeline.producers.ThrottlingProducer$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThrottlingProducer this$0;

        public /* synthetic */ ThrottlerConsumer(ThrottlingProducer throttlingProducer, Consumer consumer, AnonymousClass1 anonymousClass1) {
            this(throttlingProducer, consumer);
        }

        private void onRequestFinished() {
            Pair pair;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                synchronized (this.this$0) {
                    pair = (Pair) this.this$0.mPendingRequests.poll();
                    if (pair == null) {
                        ThrottlingProducer.access$210(this.this$0);
                    }
                }
                if (pair != null) {
                    this.this$0.mExecutor.execute(new Runnable(this, pair) { // from class: com.facebook.imagepipeline.producers.ThrottlingProducer.ThrottlerConsumer.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ThrottlerConsumer this$1;
                        public final /* synthetic */ Pair val$nextRequestPair;

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
                            this.val$nextRequestPair = pair;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ThrottlingProducer throttlingProducer = this.this$1.this$0;
                                Pair pair2 = this.val$nextRequestPair;
                                throttlingProducer.produceResultsInternal((Consumer) pair2.first, (ProducerContext) pair2.second);
                            }
                        }
                    });
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                getConsumer().onCancellation();
                onRequestFinished();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                getConsumer().onFailure(th);
                onRequestFinished();
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(T t, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, t, i2) == null) {
                getConsumer().onNewResult(t, i2);
                if (BaseConsumer.isLast(i2)) {
                    onRequestFinished();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThrottlerConsumer(ThrottlingProducer throttlingProducer, Consumer<T> consumer) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {throttlingProducer, consumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = throttlingProducer;
        }
    }

    public ThrottlingProducer(int i2, Executor executor, Producer<T> producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), executor, producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMaxSimultaneousRequests = i2;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mPendingRequests = new ConcurrentLinkedQueue<>();
        this.mNumCurrentRequests = 0;
    }

    public static /* synthetic */ int access$210(ThrottlingProducer throttlingProducer) {
        int i2 = throttlingProducer.mNumCurrentRequests;
        throttlingProducer.mNumCurrentRequests = i2 - 1;
        return i2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            producerContext.getListener().onProducerStart(producerContext.getId(), PRODUCER_NAME);
            synchronized (this) {
                z = true;
                if (this.mNumCurrentRequests >= this.mMaxSimultaneousRequests) {
                    this.mPendingRequests.add(Pair.create(consumer, producerContext));
                } else {
                    this.mNumCurrentRequests++;
                    z = false;
                }
            }
            if (z) {
                return;
            }
            produceResultsInternal(consumer, producerContext);
        }
    }

    public void produceResultsInternal(Consumer<T> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consumer, producerContext) == null) {
            producerContext.getListener().onProducerFinishWithSuccess(producerContext.getId(), PRODUCER_NAME, null);
            this.mInputProducer.produceResults(new ThrottlerConsumer(this, consumer, null), producerContext);
        }
    }
}
