package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import java.util.Map;
/* loaded from: classes7.dex */
public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
    @VisibleForTesting
    public static final String VALUE_FOUND = "cached_value_found";
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public String getProducerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? PRODUCER_NAME : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CacheKey mCacheKey;
        public final boolean mIsMemoryCachedEnabled;
        public final boolean mIsRepeatedProcessor;
        public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z2) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, cacheKey, Boolean.valueOf(z), memoryCache, Boolean.valueOf(z2)};
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
            this.mCacheKey = cacheKey;
            this.mIsRepeatedProcessor = z;
            this.mMemoryCache = memoryCache;
            this.mIsMemoryCachedEnabled = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, closeableReference, i) == null) {
                CloseableReference<CloseableImage> closeableReference2 = null;
                if (closeableReference == null) {
                    if (BaseConsumer.isLast(i)) {
                        getConsumer().onNewResult(null, i);
                    }
                } else if (BaseConsumer.isNotLast(i) && !this.mIsRepeatedProcessor) {
                } else {
                    if (this.mIsMemoryCachedEnabled) {
                        closeableReference2 = this.mMemoryCache.cache(this.mCacheKey, closeableReference);
                    }
                    try {
                        getConsumer().onProgressUpdate(1.0f);
                        Consumer<CloseableReference<CloseableImage>> consumer = getConsumer();
                        if (closeableReference2 != null) {
                            closeableReference = closeableReference2;
                        }
                        consumer.onNewResult(closeableReference, i);
                    } finally {
                        CloseableReference.closeSafely(closeableReference2);
                    }
                }
            }
        }
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
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

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consumer, producerContext) == null) {
            ProducerListener2 producerListener = producerContext.getProducerListener();
            ImageRequest imageRequest = producerContext.getImageRequest();
            Object callerContext = producerContext.getCallerContext();
            Postprocessor postprocessor = imageRequest.getPostprocessor();
            if (postprocessor != null && postprocessor.getPostprocessorCacheKey() != null) {
                producerListener.onProducerStart(producerContext, getProducerName());
                CacheKey postprocessedBitmapCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
                CloseableReference<CloseableImage> closeableReference = this.mMemoryCache.get(postprocessedBitmapCacheKey);
                Map<String, String> map = null;
                if (closeableReference != null) {
                    String producerName = getProducerName();
                    if (producerListener.requiresExtraMap(producerContext, getProducerName())) {
                        map = ImmutableMap.of("cached_value_found", "true");
                    }
                    producerListener.onProducerFinishWithSuccess(producerContext, producerName, map);
                    producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, true);
                    producerContext.putOriginExtra("memory_bitmap", "postprocessed");
                    consumer.onProgressUpdate(1.0f);
                    consumer.onNewResult(closeableReference, 1);
                    closeableReference.close();
                    return;
                }
                CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer, postprocessedBitmapCacheKey, postprocessor instanceof RepeatedPostprocessor, this.mMemoryCache, producerContext.getImageRequest().isMemoryCacheEnabled());
                String producerName2 = getProducerName();
                if (producerListener.requiresExtraMap(producerContext, getProducerName())) {
                    map = ImmutableMap.of("cached_value_found", "false");
                }
                producerListener.onProducerFinishWithSuccess(producerContext, producerName2, map);
                this.mInputProducer.produceResults(cachedPostprocessorConsumer, producerContext);
                return;
            }
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }
}
