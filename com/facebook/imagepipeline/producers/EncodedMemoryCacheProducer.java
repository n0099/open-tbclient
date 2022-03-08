package com.facebook.imagepipeline.producers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
/* loaded from: classes7.dex */
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer<EncodedImage> mInputProducer;
    public final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

    /* loaded from: classes7.dex */
    public static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mIsMemoryCacheEnabled;
        public final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
        public final CacheKey mRequestedCacheKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EncodedMemoryCacheConsumer(Consumer<EncodedImage> consumer, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, memoryCache, cacheKey, Boolean.valueOf(z)};
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
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsMemoryCacheEnabled = z;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            boolean isTracing;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, encodedImage, i2) == null) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");
                    }
                    if (!BaseConsumer.isNotLast(i2) && encodedImage != null && !BaseConsumer.statusHasAnyFlag(i2, 10) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
                        if (byteBufferRef != null) {
                            CloseableReference<PooledByteBuffer> cache = this.mIsMemoryCacheEnabled ? this.mMemoryCache.cache(this.mRequestedCacheKey, byteBufferRef) : null;
                            CloseableReference.closeSafely(byteBufferRef);
                            if (cache != null) {
                                EncodedImage encodedImage2 = new EncodedImage(cache);
                                encodedImage2.copyMetaDataFrom(encodedImage);
                                CloseableReference.closeSafely(cache);
                                getConsumer().onProgressUpdate(1.0f);
                                getConsumer().onNewResult(encodedImage2, i2);
                                EncodedImage.closeSafely(encodedImage2);
                                if (isTracing) {
                                    return;
                                }
                                return;
                            }
                        }
                        getConsumer().onNewResult(encodedImage, i2);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                    getConsumer().onNewResult(encodedImage, i2);
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
    }

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryCache, cacheKeyFactory, producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");
                }
                String id = producerContext.getId();
                ProducerListener listener = producerContext.getListener();
                listener.onProducerStart(id, PRODUCER_NAME);
                CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
                CloseableReference<PooledByteBuffer> closeableReference = this.mMemoryCache.get(encodedCacheKey);
                if (closeableReference != null) {
                    EncodedImage encodedImage = new EncodedImage(closeableReference);
                    try {
                        listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                        listener.onUltimateProducerReached(id, PRODUCER_NAME, true);
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(encodedImage, 1);
                        CloseableReference.closeSafely(closeableReference);
                    } finally {
                        EncodedImage.closeSafely(encodedImage);
                    }
                } else if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                    listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                    listener.onUltimateProducerReached(id, PRODUCER_NAME, false);
                    consumer.onNewResult(null, 1);
                    CloseableReference.closeSafely(closeableReference);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } else {
                    EncodedMemoryCacheConsumer encodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(consumer, this.mMemoryCache, encodedCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled());
                    listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                    this.mInputProducer.produceResults(encodedMemoryCacheConsumer, producerContext);
                    CloseableReference.closeSafely(closeableReference);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }
}
