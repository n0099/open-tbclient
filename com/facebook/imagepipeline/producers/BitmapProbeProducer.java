package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
/* loaded from: classes7.dex */
public class BitmapProbeProducer implements Producer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRODUCER_NAME = "BitmapProbeProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheKeyFactory mCacheKeyFactory;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final BoundedLinkedHashSet mDiskCacheHistory;
    public final MemoryCache mEncodedMemoryCache;
    public final BoundedLinkedHashSet mEncodedMemoryCacheHistory;
    public final Producer mInputProducer;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;

    public String getProducerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? PRODUCER_NAME : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class ProbeConsumer extends DelegatingConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CacheKeyFactory mCacheKeyFactory;
        public final BufferedDiskCache mDefaultBufferedDiskCache;
        public final BoundedLinkedHashSet mDiskCacheHistory;
        public final MemoryCache mEncodedMemoryCache;
        public final BoundedLinkedHashSet mEncodedMemoryCacheHistory;
        public final ProducerContext mProducerContext;
        public final BufferedDiskCache mSmallImageBufferedDiskCache;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProbeConsumer(Consumer consumer, ProducerContext producerContext, MemoryCache memoryCache, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, producerContext, memoryCache, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, boundedLinkedHashSet, boundedLinkedHashSet2};
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
            this.mProducerContext = producerContext;
            this.mEncodedMemoryCache = memoryCache;
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
            this.mCacheKeyFactory = cacheKeyFactory;
            this.mEncodedMemoryCacheHistory = boundedLinkedHashSet;
            this.mDiskCacheHistory = boundedLinkedHashSet2;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference closeableReference, int i) {
            boolean isTracing;
            boolean z;
            BufferedDiskCache bufferedDiskCache;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, closeableReference, i) == null) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("BitmapProbeProducer#onNewResultImpl");
                    }
                    if (!BaseConsumer.isNotLast(i) && closeableReference != null && !BaseConsumer.statusHasAnyFlag(i, 8)) {
                        ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, this.mProducerContext.getCallerContext());
                        if (this.mProducerContext.getExtra("origin").equals("memory_bitmap")) {
                            if (this.mProducerContext.getImagePipelineConfig().getExperiments().isEncodedMemoryCacheProbingEnabled() && !this.mEncodedMemoryCacheHistory.contains(encodedCacheKey)) {
                                this.mEncodedMemoryCache.probe(encodedCacheKey);
                                this.mEncodedMemoryCacheHistory.add(encodedCacheKey);
                            }
                            if (this.mProducerContext.getImagePipelineConfig().getExperiments().isDiskCacheProbingEnabled() && !this.mDiskCacheHistory.contains(encodedCacheKey)) {
                                if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    bufferedDiskCache = this.mSmallImageBufferedDiskCache;
                                } else {
                                    bufferedDiskCache = this.mDefaultBufferedDiskCache;
                                }
                                bufferedDiskCache.addKeyForAsyncProbing(encodedCacheKey);
                                this.mDiskCacheHistory.add(encodedCacheKey);
                            }
                        }
                        getConsumer().onNewResult(closeableReference, i);
                        if (isTracing) {
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
    }

    public BitmapProbeProducer(MemoryCache memoryCache, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2, Producer producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryCache, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, boundedLinkedHashSet, boundedLinkedHashSet2, producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEncodedMemoryCache = memoryCache;
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mEncodedMemoryCacheHistory = boundedLinkedHashSet;
        this.mDiskCacheHistory = boundedLinkedHashSet2;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consumer, producerContext) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("BitmapProbeProducer#produceResults");
                }
                ProducerListener2 producerListener = producerContext.getProducerListener();
                producerListener.onProducerStart(producerContext, getProducerName());
                ProbeConsumer probeConsumer = new ProbeConsumer(consumer, producerContext, this.mEncodedMemoryCache, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory);
                producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, null);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("mInputProducer.produceResult");
                }
                this.mInputProducer.produceResults(probeConsumer, producerContext);
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
