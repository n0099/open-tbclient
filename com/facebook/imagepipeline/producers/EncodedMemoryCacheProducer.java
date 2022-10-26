package com.facebook.imagepipeline.producers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
/* loaded from: classes7.dex */
public class EncodedMemoryCacheProducer implements Producer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer mInputProducer;
    public final MemoryCache mMemoryCache;

    /* loaded from: classes7.dex */
    public class EncodedMemoryCacheConsumer extends DelegatingConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mEncodedCacheEnabled;
        public final boolean mIsMemoryCacheEnabled;
        public final MemoryCache mMemoryCache;
        public final CacheKey mRequestedCacheKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EncodedMemoryCacheConsumer(Consumer consumer, MemoryCache memoryCache, CacheKey cacheKey, boolean z, boolean z2) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, memoryCache, cacheKey, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsMemoryCacheEnabled = z;
            this.mEncodedCacheEnabled = z2;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            boolean isTracing;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, encodedImage, i) == null) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");
                    }
                    if (!BaseConsumer.isNotLast(i) && encodedImage != null && !BaseConsumer.statusHasAnyFlag(i, 10) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                        CloseableReference byteBufferRef = encodedImage.getByteBufferRef();
                        if (byteBufferRef != null) {
                            CloseableReference closeableReference = null;
                            if (this.mEncodedCacheEnabled && this.mIsMemoryCacheEnabled) {
                                closeableReference = this.mMemoryCache.cache(this.mRequestedCacheKey, byteBufferRef);
                            }
                            CloseableReference.closeSafely(byteBufferRef);
                            if (closeableReference != null) {
                                EncodedImage encodedImage2 = new EncodedImage(closeableReference);
                                encodedImage2.copyMetaDataFrom(encodedImage);
                                CloseableReference.closeSafely(closeableReference);
                                getConsumer().onProgressUpdate(1.0f);
                                getConsumer().onNewResult(encodedImage2, i);
                                EncodedImage.closeSafely(encodedImage2);
                                if (isTracing) {
                                    return;
                                }
                                return;
                            }
                        }
                        getConsumer().onNewResult(encodedImage, i);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                    getConsumer().onNewResult(encodedImage, i);
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

    public EncodedMemoryCacheProducer(MemoryCache memoryCache, CacheKeyFactory cacheKeyFactory, Producer producer) {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");
                }
                ProducerListener2 producerListener = producerContext.getProducerListener();
                producerListener.onProducerStart(producerContext, PRODUCER_NAME);
                CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
                CloseableReference closeableReference = this.mMemoryCache.get(encodedCacheKey);
                Map map2 = null;
                if (closeableReference != null) {
                    EncodedImage encodedImage = new EncodedImage(closeableReference);
                    if (producerListener.requiresExtraMap(producerContext, PRODUCER_NAME)) {
                        map2 = ImmutableMap.of("cached_value_found", "true");
                    }
                    producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, map2);
                    producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, true);
                    producerContext.putOriginExtra("memory_encoded");
                    consumer.onProgressUpdate(1.0f);
                    consumer.onNewResult(encodedImage, 1);
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(closeableReference);
                } else if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                    if (producerListener.requiresExtraMap(producerContext, PRODUCER_NAME)) {
                        map = ImmutableMap.of("cached_value_found", "false");
                    } else {
                        map = null;
                    }
                    producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, map);
                    producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, false);
                    producerContext.putOriginExtra("memory_encoded", "nil-result");
                    consumer.onNewResult(null, 1);
                    CloseableReference.closeSafely(closeableReference);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } else {
                    EncodedMemoryCacheConsumer encodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(consumer, this.mMemoryCache, encodedCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled(), producerContext.getImagePipelineConfig().getExperiments().isEncodedCacheEnabled());
                    if (producerListener.requiresExtraMap(producerContext, PRODUCER_NAME)) {
                        map2 = ImmutableMap.of("cached_value_found", "false");
                    }
                    producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, map2);
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
