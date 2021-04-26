package com.facebook.imagepipeline.producers;

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
/* loaded from: classes6.dex */
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer<EncodedImage> mInputProducer;
    public final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

    /* loaded from: classes6.dex */
    public static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final boolean mIsMemoryCacheEnabled;
        public final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
        public final CacheKey mRequestedCacheKey;

        public EncodedMemoryCacheConsumer(Consumer<EncodedImage> consumer, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z) {
            super(consumer);
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsMemoryCacheEnabled = z;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            boolean isTracing;
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

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
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
                listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                listener.onUltimateProducerReached(id, PRODUCER_NAME, true);
                consumer.onProgressUpdate(1.0f);
                consumer.onNewResult(encodedImage, 1);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(closeableReference);
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
