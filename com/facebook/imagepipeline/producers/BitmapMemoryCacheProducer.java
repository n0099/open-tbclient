package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.HasImageMetadata;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
/* loaded from: classes7.dex */
public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String ORIGIN_SUBCATEGORY = "pipe_bg";
    public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryCache, cacheKeyFactory, producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public static void maybeSetExtrasFromCloseableImage(HasImageMetadata hasImageMetadata, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, hasImageMetadata, producerContext) == null) {
            producerContext.putExtras(hasImageMetadata.getExtras());
        }
    }

    public String getOriginSubcategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ORIGIN_SUBCATEGORY : (String) invokeV.objValue;
    }

    public String getProducerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PRODUCER_NAME : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        boolean isTracing;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, consumer, producerContext) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");
                }
                ProducerListener2 producerListener = producerContext.getProducerListener();
                producerListener.onProducerStart(producerContext, getProducerName());
                CacheKey bitmapCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
                CloseableReference<CloseableImage> closeableReference = this.mMemoryCache.get(bitmapCacheKey);
                if (closeableReference != null) {
                    maybeSetExtrasFromCloseableImage(closeableReference.get(), producerContext);
                    boolean isOfFullQuality = closeableReference.get().getQualityInfo().isOfFullQuality();
                    if (isOfFullQuality) {
                        producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", "true") : null);
                        producerListener.onUltimateProducerReached(producerContext, getProducerName(), true);
                        producerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
                        consumer.onProgressUpdate(1.0f);
                    }
                    consumer.onNewResult(closeableReference, BaseConsumer.simpleStatusForIsLast(isOfFullQuality));
                    closeableReference.close();
                    if (isOfFullQuality) {
                        if (isTracing) {
                            return;
                        }
                        return;
                    }
                }
                if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
                    producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", "false") : null);
                    producerListener.onUltimateProducerReached(producerContext, getProducerName(), false);
                    producerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
                    consumer.onNewResult(null, 1);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                        return;
                    }
                    return;
                }
                Consumer<CloseableReference<CloseableImage>> wrapConsumer = wrapConsumer(consumer, bitmapCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled());
                producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", "false") : null);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("mInputProducer.produceResult");
                }
                this.mInputProducer.produceResults(wrapConsumer, producerContext);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }

    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, consumer, cacheKey, z)) == null) ? new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(this, consumer, cacheKey, z) { // from class: com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BitmapMemoryCacheProducer this$0;
            public final /* synthetic */ CacheKey val$cacheKey;
            public final /* synthetic */ boolean val$isMemoryCacheEnabled;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(consumer);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, consumer, cacheKey, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Consumer) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$cacheKey = cacheKey;
                this.val$isMemoryCacheEnabled = z;
            }

            /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
                CloseableReference<CloseableImage> closeableReference2;
                boolean isTracing;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, closeableReference, i) == null) {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("BitmapMemoryCacheProducer#onNewResultImpl");
                        }
                        boolean isLast = BaseConsumer.isLast(i);
                        if (closeableReference == null) {
                            if (isLast) {
                                getConsumer().onNewResult(null, i);
                            }
                            if (isTracing) {
                                return;
                            }
                            return;
                        }
                        if (!closeableReference.get().isStateful() && !BaseConsumer.statusHasFlag(i, 8)) {
                            if (!isLast && (closeableReference2 = this.this$0.mMemoryCache.get(this.val$cacheKey)) != null) {
                                QualityInfo qualityInfo = closeableReference.get().getQualityInfo();
                                QualityInfo qualityInfo2 = closeableReference2.get().getQualityInfo();
                                if (!qualityInfo2.isOfFullQuality() && qualityInfo2.getQuality() < qualityInfo.getQuality()) {
                                    CloseableReference.closeSafely(closeableReference2);
                                } else {
                                    getConsumer().onNewResult(closeableReference2, i);
                                    CloseableReference.closeSafely(closeableReference2);
                                    if (FrescoSystrace.isTracing()) {
                                        FrescoSystrace.endSection();
                                        return;
                                    }
                                    return;
                                }
                            }
                            CloseableReference<CloseableImage> cache = this.val$isMemoryCacheEnabled ? this.this$0.mMemoryCache.cache(this.val$cacheKey, closeableReference) : null;
                            if (isLast) {
                                getConsumer().onProgressUpdate(1.0f);
                            }
                            Consumer<CloseableReference<CloseableImage>> consumer2 = getConsumer();
                            if (cache != null) {
                                closeableReference = cache;
                            }
                            consumer2.onNewResult(closeableReference, i);
                            CloseableReference.closeSafely(cache);
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                                return;
                            }
                            return;
                        }
                        getConsumer().onNewResult(closeableReference, i);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }
        } : (Consumer) invokeLLZ.objValue;
    }
}
