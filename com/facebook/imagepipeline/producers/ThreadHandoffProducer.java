package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ThreadHandoffProducer<T> implements Producer<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final Producer<T> mInputProducer;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, threadHandoffProducerQueue};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    @Nullable
    public static String getInstrumentationTag(ProducerContext producerContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, producerContext)) == null) {
            if (FrescoInstrumenter.isTracing()) {
                return "ThreadHandoffProducer_produceResults_" + producerContext.getId();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ThreadHandoffProducer#produceResults");
                }
                ProducerListener2 producerListener = producerContext.getProducerListener();
                StatefulProducerRunnable<T> statefulProducerRunnable = new StatefulProducerRunnable<T>(this, consumer, producerListener, producerContext, PRODUCER_NAME, producerListener, producerContext, consumer) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ThreadHandoffProducer this$0;
                    public final /* synthetic */ Consumer val$consumer;
                    public final /* synthetic */ ProducerContext val$context;
                    public final /* synthetic */ ProducerListener2 val$producerListener;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(consumer, producerListener, producerContext, r15);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r3;
                            Object[] objArr = {this, consumer, producerListener, producerContext, r15, producerListener, producerContext, consumer};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((Consumer) objArr2[0], (ProducerListener2) objArr2[1], (ProducerContext) objArr2[2], (String) objArr2[3]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$producerListener = producerListener;
                        this.val$context = producerContext;
                        this.val$consumer = consumer;
                    }

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    public void disposeResult(T t) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, t) == null) {
                        }
                    }

                    @Override // com.facebook.common.executors.StatefulRunnable
                    @Nullable
                    public T getResult() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return null;
                        }
                        return (T) invokeV.objValue;
                    }

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    public void onSuccess(T t) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                            this.val$producerListener.onProducerFinishWithSuccess(this.val$context, ThreadHandoffProducer.PRODUCER_NAME, null);
                            this.this$0.mInputProducer.produceResults(this.val$consumer, this.val$context);
                        }
                    }
                };
                producerContext.addCallbacks(new BaseProducerContextCallbacks(this, statefulProducerRunnable) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ThreadHandoffProducer this$0;
                    public final /* synthetic */ StatefulProducerRunnable val$statefulRunnable;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, statefulProducerRunnable};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$statefulRunnable = statefulProducerRunnable;
                    }

                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onCancellationRequested() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$statefulRunnable.cancel();
                            this.this$0.mThreadHandoffProducerQueue.remove(this.val$statefulRunnable);
                        }
                    }
                });
                this.mThreadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(statefulProducerRunnable, getInstrumentationTag(producerContext)));
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }
}
