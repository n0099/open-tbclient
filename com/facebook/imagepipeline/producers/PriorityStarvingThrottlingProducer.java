package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.Priority;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class PriorityStarvingThrottlingProducer implements Producer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRODUCER_NAME = "PriorityStarvingThrottlingProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor mExecutor;
    public final Producer mInputProducer;
    public final int mMaxSimultaneousRequests;
    public int mNumCurrentRequests;
    public final Queue mPendingRequests;

    /* renamed from: com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class Item {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Consumer consumer;
        public final ProducerContext producerContext;
        public final long time;

        public Item(Consumer consumer, ProducerContext producerContext, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, producerContext, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.consumer = consumer;
            this.producerContext = producerContext;
            this.time = j;
        }
    }

    /* loaded from: classes7.dex */
    public class PriorityComparator implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PriorityComparator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Item item, Item item2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, item, item2)) == null) {
                Priority priority = item.producerContext.getPriority();
                Priority priority2 = item2.producerContext.getPriority();
                if (priority == priority2) {
                    return Double.compare(item.time, item2.time);
                }
                if (priority.ordinal() > priority2.ordinal()) {
                    return -1;
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class ThrottlerConsumer extends DelegatingConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PriorityStarvingThrottlingProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThrottlerConsumer(PriorityStarvingThrottlingProducer priorityStarvingThrottlingProducer, Consumer consumer) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {priorityStarvingThrottlingProducer, consumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = priorityStarvingThrottlingProducer;
        }

        public /* synthetic */ ThrottlerConsumer(PriorityStarvingThrottlingProducer priorityStarvingThrottlingProducer, Consumer consumer, AnonymousClass1 anonymousClass1) {
            this(priorityStarvingThrottlingProducer, consumer);
        }

        private void onRequestFinished() {
            Item item;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                synchronized (this.this$0) {
                    item = (Item) this.this$0.mPendingRequests.poll();
                    if (item == null) {
                        PriorityStarvingThrottlingProducer.access$210(this.this$0);
                    }
                }
                if (item != null) {
                    this.this$0.mExecutor.execute(new Runnable(this, item) { // from class: com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.ThrottlerConsumer.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ThrottlerConsumer this$1;
                        public final /* synthetic */ Item val$nextRequest;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, item};
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
                            this.val$nextRequest = item;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                                return;
                            }
                            this.this$1.this$0.produceResultsInternal(this.val$nextRequest);
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
        public void onNewResultImpl(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) {
                getConsumer().onNewResult(obj, i);
                if (BaseConsumer.isLast(i)) {
                    onRequestFinished();
                }
            }
        }
    }

    public PriorityStarvingThrottlingProducer(int i, Executor executor, Producer producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), executor, producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMaxSimultaneousRequests = i;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mPendingRequests = new PriorityQueue(11, new PriorityComparator());
        this.mNumCurrentRequests = 0;
    }

    public static /* synthetic */ int access$210(PriorityStarvingThrottlingProducer priorityStarvingThrottlingProducer) {
        int i = priorityStarvingThrottlingProducer.mNumCurrentRequests;
        priorityStarvingThrottlingProducer.mNumCurrentRequests = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void produceResultsInternal(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, item) == null) {
            item.producerContext.getProducerListener().onProducerFinishWithSuccess(item.producerContext, PRODUCER_NAME, null);
            this.mInputProducer.produceResults(new ThrottlerConsumer(this, item.consumer, null), item.producerContext);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            long nanoTime = System.nanoTime();
            producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
            synchronized (this) {
                z = true;
                if (this.mNumCurrentRequests >= this.mMaxSimultaneousRequests) {
                    this.mPendingRequests.add(new Item(consumer, producerContext, nanoTime));
                } else {
                    this.mNumCurrentRequests++;
                    z = false;
                }
            }
            if (!z) {
                produceResultsInternal(new Item(consumer, producerContext, nanoTime));
            }
        }
    }
}
