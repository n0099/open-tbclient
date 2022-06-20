package com.facebook.imagepipeline.producers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.repackage.h0;
import com.repackage.i0;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "DiskCacheProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheKeyFactory mCacheKeyFactory;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final Producer<EncodedImage> mInputProducer;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @VisibleForTesting
    @Nullable
    public static Map<String, String> getExtraMap(ProducerListener producerListener, String str, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{producerListener, str, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (producerListener.requiresExtraMap(str)) {
                if (z) {
                    return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
                }
                return ImmutableMap.of("cached_value_found", String.valueOf(z));
            }
            return null;
        }
        return (Map) invokeCommon.objValue;
    }

    public static boolean isTaskCancelled(i0<?> i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, i0Var)) == null) ? i0Var.n() || (i0Var.p() && (i0Var.k() instanceof CancellationException)) : invokeL.booleanValue;
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, consumer, producerContext) == null) {
            if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
                consumer.onNewResult(null, 1);
            } else {
                this.mInputProducer.produceResults(consumer, producerContext);
            }
        }
    }

    private h0<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, consumer, producerContext)) == null) ? new h0<EncodedImage, Void>(this, producerContext.getListener(), producerContext.getId(), consumer, producerContext) { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DiskCacheReadProducer this$0;
            public final /* synthetic */ Consumer val$consumer;
            public final /* synthetic */ ProducerListener val$listener;
            public final /* synthetic */ ProducerContext val$producerContext;
            public final /* synthetic */ String val$requestId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, r8, consumer, producerContext};
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
                this.val$listener = r7;
                this.val$requestId = r8;
                this.val$consumer = consumer;
                this.val$producerContext = producerContext;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.h0
            public Void then(i0<EncodedImage> i0Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i0Var)) == null) {
                    if (DiskCacheReadProducer.isTaskCancelled(i0Var)) {
                        this.val$listener.onProducerFinishWithCancellation(this.val$requestId, "DiskCacheProducer", null);
                        this.val$consumer.onCancellation();
                    } else if (i0Var.p()) {
                        this.val$listener.onProducerFinishWithFailure(this.val$requestId, "DiskCacheProducer", i0Var.k(), null);
                        this.this$0.mInputProducer.produceResults(this.val$consumer, this.val$producerContext);
                    } else {
                        EncodedImage l = i0Var.l();
                        if (l != null) {
                            ProducerListener producerListener = this.val$listener;
                            String str = this.val$requestId;
                            producerListener.onProducerFinishWithSuccess(str, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener, str, true, l.getSize()));
                            this.val$listener.onUltimateProducerReached(this.val$requestId, "DiskCacheProducer", true);
                            this.val$consumer.onProgressUpdate(1.0f);
                            this.val$consumer.onNewResult(l, 1);
                            l.close();
                        } else {
                            ProducerListener producerListener2 = this.val$listener;
                            String str2 = this.val$requestId;
                            producerListener2.onProducerFinishWithSuccess(str2, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener2, str2, false, 0));
                            this.this$0.mInputProducer.produceResults(this.val$consumer, this.val$producerContext);
                        }
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        } : (h0) invokeLL.objValue;
    }

    private void subscribeTaskForRequestCancellation(AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, atomicBoolean, producerContext) == null) {
            producerContext.addCallbacks(new BaseProducerContextCallbacks(this, atomicBoolean) { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DiskCacheReadProducer this$0;
                public final /* synthetic */ AtomicBoolean val$isCancelled;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, atomicBoolean};
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
                    this.val$isCancelled = atomicBoolean;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$isCancelled.set(true);
                    }
                }
            });
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            ImageRequest imageRequest = producerContext.getImageRequest();
            if (!imageRequest.isDiskCacheEnabled()) {
                maybeStartInputProducer(consumer, producerContext);
                return;
            }
            producerContext.getListener().onProducerStart(producerContext.getId(), "DiskCacheProducer");
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
            BufferedDiskCache bufferedDiskCache = imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache;
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bufferedDiskCache.get(encodedCacheKey, atomicBoolean).e(onFinishDiskReads(consumer, producerContext));
            subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
        }
    }
}
