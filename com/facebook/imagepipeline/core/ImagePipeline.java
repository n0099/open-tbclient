package com.facebook.imagepipeline.core;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import d.d;
import d.e;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes11.dex */
public class ImagePipeline {
    public static /* synthetic */ Interceptable $ic;
    public static final CancellationException PREFETCH_EXCEPTION;
    public transient /* synthetic */ FieldHolder $fh;
    public final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    public final CacheKeyFactory mCacheKeyFactory;
    public final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public AtomicLong mIdCounter;
    public final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    public final Supplier<Boolean> mLazyDataSource;
    public final BufferedDiskCache mMainBufferedDiskCache;
    public final ProducerSequenceFactory mProducerSequenceFactory;
    public final RequestListener mRequestListener;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;
    public final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    /* renamed from: com.facebook.imagepipeline.core.ImagePipeline$8  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(293997625, "Lcom/facebook/imagepipeline/core/ImagePipeline$8;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(293997625, "Lcom/facebook/imagepipeline/core/ImagePipeline$8;");
                    return;
                }
            }
            int[] iArr = new int[ImageRequest.CacheChoice.values().length];
            $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice = iArr;
            try {
                iArr[ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[ImageRequest.CacheChoice.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1855052493, "Lcom/facebook/imagepipeline/core/ImagePipeline;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1855052493, "Lcom/facebook/imagepipeline/core/ImagePipeline;");
                return;
            }
        }
        PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    }

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {producerSequenceFactory, set, supplier, memoryCache, memoryCache2, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, threadHandoffProducerQueue, supplier2, supplier3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIdCounter = new AtomicLong();
        this.mProducerSequenceFactory = producerSequenceFactory;
        this.mRequestListener = new ForwardingRequestListener(set);
        this.mIsPrefetchEnabledSupplier = supplier;
        this.mBitmapMemoryCache = memoryCache;
        this.mEncodedMemoryCache = memoryCache2;
        this.mMainBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mSuppressBitmapPrefetchingSupplier = supplier2;
        this.mLazyDataSource = supplier3;
    }

    private Predicate<CacheKey> predicateForUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, uri)) == null) ? new Predicate<CacheKey>(this, uri) { // from class: com.facebook.imagepipeline.core.ImagePipeline.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImagePipeline this$0;
            public final /* synthetic */ Uri val$uri;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, uri};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$uri = uri;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, cacheKey)) == null) ? cacheKey.containsUri(this.val$uri) : invokeL2.booleanValue;
            }
        } : (Predicate) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable RequestListener requestListener) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, producer, imageRequest, requestLevel, obj, requestListener)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
            }
            RequestListener requestListenerForRequest = getRequestListenerForRequest(imageRequest, requestListener);
            try {
                try {
                    ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
                    String generateUniqueFutureId = generateUniqueFutureId();
                    if (!imageRequest.getProgressiveRenderingEnabled() && UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                        z = false;
                        DataSource<CloseableReference<T>> create = CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId, requestListenerForRequest, obj, max, false, z, imageRequest.getPriority()), requestListenerForRequest);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return create;
                    }
                    z = true;
                    DataSource<CloseableReference<T>> create2 = CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId, requestListenerForRequest, obj, max, false, z, imageRequest.getPriority()), requestListenerForRequest);
                    if (FrescoSystrace.isTracing()) {
                    }
                    return create2;
                } catch (Exception e2) {
                    DataSource<CloseableReference<T>> immediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return immediateFailedDataSource;
                }
            } catch (Throwable th) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                throw th;
            }
        }
        return (DataSource) invokeLLLLL.objValue;
    }

    private DataSource<Void> submitPrefetchRequest(Producer<Void> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, this, producer, imageRequest, requestLevel, obj, priority)) == null) {
            RequestListener requestListenerForRequest = getRequestListenerForRequest(imageRequest, null);
            try {
                return ProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId(), requestListenerForRequest, obj, ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel), true, false, priority), requestListenerForRequest);
            } catch (Exception e2) {
                return DataSources.immediateFailedDataSource(e2);
            }
        }
        return (DataSource) invokeLLLLL.objValue;
    }

    public void clearCaches() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            clearMemoryCaches();
            clearDiskCaches();
        }
    }

    public void clearDiskCaches() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mMainBufferedDiskCache.clearAll();
            this.mSmallImageBufferedDiskCache.clearAll();
        }
    }

    public void clearMemoryCaches() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Predicate<CacheKey> predicate = new Predicate<CacheKey>(this) { // from class: com.facebook.imagepipeline.core.ImagePipeline.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImagePipeline this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.Predicate
                public boolean apply(CacheKey cacheKey) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cacheKey)) == null) {
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            };
            this.mBitmapMemoryCache.removeAll(predicate);
            this.mEncodedMemoryCache.removeAll(predicate);
        }
    }

    public void evictFromCache(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
            evictFromMemoryCache(uri);
            evictFromDiskCache(uri);
        }
    }

    public void evictFromDiskCache(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
            evictFromDiskCache(ImageRequest.fromUri(uri));
        }
    }

    public void evictFromMemoryCache(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uri) == null) {
            Predicate<CacheKey> predicateForUri = predicateForUri(uri);
            this.mBitmapMemoryCache.removeAll(predicateForUri);
            this.mEncodedMemoryCache.removeAll(predicateForUri);
        }
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageRequest, obj)) == null) ? fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH) : (DataSource) invokeLL.objValue;
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, imageRequest, obj)) == null) ? fetchEncodedImage(imageRequest, obj, null) : (DataSource) invokeLL.objValue;
    }

    public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, imageRequest, obj)) == null) ? fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE) : (DataSource) invokeLL.objValue;
    }

    public String generateUniqueFutureId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? String.valueOf(this.mIdCounter.getAndIncrement()) : (String) invokeV.objValue;
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mBitmapMemoryCache : (MemoryCache) invokeV.objValue;
    }

    @Nullable
    public CacheKey getCacheKey(@Nullable ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, imageRequest, obj)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipeline#getCacheKey");
            }
            CacheKeyFactory cacheKeyFactory = this.mCacheKeyFactory;
            CacheKey cacheKey = null;
            if (cacheKeyFactory != null && imageRequest != null) {
                if (imageRequest.getPostprocessor() != null) {
                    cacheKey = cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, obj);
                } else {
                    cacheKey = cacheKeyFactory.getBitmapCacheKey(imageRequest, obj);
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return cacheKey;
        }
        return (CacheKey) invokeLL.objValue;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mCacheKeyFactory : (CacheKeyFactory) invokeV.objValue;
    }

    @Nullable
    public CloseableReference<CloseableImage> getCachedImage(@Nullable CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cacheKey)) == null) {
            MemoryCache<CacheKey, CloseableImage> memoryCache = this.mBitmapMemoryCache;
            if (memoryCache == null || cacheKey == null) {
                return null;
            }
            CloseableReference<CloseableImage> closeableReference = memoryCache.get(cacheKey);
            if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
                return closeableReference;
            }
            closeableReference.close();
            return null;
        }
        return (CloseableReference) invokeL.objValue;
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, imageRequest, obj, requestLevel)) == null) ? new Supplier<DataSource<CloseableReference<CloseableImage>>>(this, imageRequest, obj, requestLevel) { // from class: com.facebook.imagepipeline.core.ImagePipeline.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImagePipeline this$0;
            public final /* synthetic */ Object val$callerContext;
            public final /* synthetic */ ImageRequest val$imageRequest;
            public final /* synthetic */ ImageRequest.RequestLevel val$requestLevel;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, imageRequest, obj, requestLevel};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$imageRequest = imageRequest;
                this.val$callerContext = obj;
                this.val$requestLevel = requestLevel;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.toStringHelper(this).add("uri", this.val$imageRequest.getSourceUri()).toString() : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.fetchDecodedImage(this.val$imageRequest, this.val$callerContext, this.val$requestLevel) : (DataSource) invokeV.objValue;
            }
        } : (Supplier) invokeLLL.objValue;
    }

    public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, imageRequest, obj)) == null) ? new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>(this, imageRequest, obj) { // from class: com.facebook.imagepipeline.core.ImagePipeline.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImagePipeline this$0;
            public final /* synthetic */ Object val$callerContext;
            public final /* synthetic */ ImageRequest val$imageRequest;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, imageRequest, obj};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$imageRequest = imageRequest;
                this.val$callerContext = obj;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.toStringHelper(this).add("uri", this.val$imageRequest.getSourceUri()).toString() : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.fetchEncodedImage(this.val$imageRequest, this.val$callerContext) : (DataSource) invokeV.objValue;
            }
        } : (Supplier) invokeLL.objValue;
    }

    public long getMainBufferedDiskCacheCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            BufferedDiskCache bufferedDiskCache = this.mMainBufferedDiskCache;
            if (bufferedDiskCache != null) {
                return bufferedDiskCache.getCount();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long getMainBufferedDiskCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            BufferedDiskCache bufferedDiskCache = this.mMainBufferedDiskCache;
            if (bufferedDiskCache != null) {
                return bufferedDiskCache.getSize();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public ProducerSequenceFactory getProducerSequenceFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mProducerSequenceFactory : (ProducerSequenceFactory) invokeV.objValue;
    }

    public RequestListener getRequestListenerForRequest(ImageRequest imageRequest, @Nullable RequestListener requestListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, imageRequest, requestListener)) == null) {
            if (requestListener == null) {
                if (imageRequest.getRequestListener() == null) {
                    return this.mRequestListener;
                }
                return new ForwardingRequestListener(this.mRequestListener, imageRequest.getRequestListener());
            } else if (imageRequest.getRequestListener() == null) {
                return new ForwardingRequestListener(this.mRequestListener, requestListener);
            } else {
                return new ForwardingRequestListener(this.mRequestListener, requestListener, imageRequest.getRequestListener());
            }
        }
        return (RequestListener) invokeLL.objValue;
    }

    public long getSmallBufferedDiskCacheCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            BufferedDiskCache bufferedDiskCache = this.mSmallImageBufferedDiskCache;
            if (bufferedDiskCache != null) {
                return bufferedDiskCache.getCount();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long getSmallBufferedDiskCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            BufferedDiskCache bufferedDiskCache = this.mSmallImageBufferedDiskCache;
            if (bufferedDiskCache != null) {
                return bufferedDiskCache.getSize();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean hasCachedImage(@Nullable CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cacheKey)) == null) {
            MemoryCache<CacheKey, CloseableImage> memoryCache = this.mBitmapMemoryCache;
            if (memoryCache == null || cacheKey == null) {
                return false;
            }
            return memoryCache.contains((MemoryCache<CacheKey, CloseableImage>) cacheKey);
        }
        return invokeL.booleanValue;
    }

    public boolean isInBitmapMemoryCache(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, uri)) == null) {
            if (uri == null) {
                return false;
            }
            return this.mBitmapMemoryCache.contains(predicateForUri(uri));
        }
        return invokeL.booleanValue;
    }

    public DataSource<Boolean> isInDiskCache(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, uri)) == null) ? isInDiskCache(ImageRequest.fromUri(uri)) : (DataSource) invokeL.objValue;
    }

    public boolean isInDiskCacheSync(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, uri)) == null) ? isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT) : invokeL.booleanValue;
    }

    public Supplier<Boolean> isLazyDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mLazyDataSource : (Supplier) invokeV.objValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mThreadHandoffProducerQueue.isQueueing() : invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.mThreadHandoffProducerQueue.startQueueing();
        }
    }

    public DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        boolean booleanValue;
        Producer<Void> decodedImagePrefetchProducerSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, imageRequest, obj)) == null) {
            if (!this.mIsPrefetchEnabledSupplier.get().booleanValue()) {
                return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
            }
            try {
                Boolean shouldDecodePrefetches = imageRequest.shouldDecodePrefetches();
                if (shouldDecodePrefetches != null) {
                    booleanValue = !shouldDecodePrefetches.booleanValue();
                } else {
                    booleanValue = this.mSuppressBitmapPrefetchingSupplier.get().booleanValue();
                }
                if (booleanValue) {
                    decodedImagePrefetchProducerSequence = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
                } else {
                    decodedImagePrefetchProducerSequence = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
                }
                return submitPrefetchRequest(decodedImagePrefetchProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
            } catch (Exception e2) {
                return DataSources.immediateFailedDataSource(e2);
            }
        }
        return (DataSource) invokeLL.objValue;
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, imageRequest, obj)) == null) ? prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM) : (DataSource) invokeLL.objValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.mThreadHandoffProducerQueue.stopQueuing();
        }
    }

    public void evictFromDiskCache(ImageRequest imageRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, imageRequest) == null) {
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
            this.mMainBufferedDiskCache.remove(encodedCacheKey);
            this.mSmallImageBufferedDiskCache.remove(encodedCacheKey);
        }
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, @Nullable RequestListener requestListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, imageRequest, obj, requestListener)) == null) ? fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH, requestListener) : (DataSource) invokeLLL.objValue;
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj, @Nullable RequestListener requestListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, imageRequest, obj, requestListener)) == null) {
            Preconditions.checkNotNull(imageRequest.getSourceUri());
            try {
                Producer<CloseableReference<PooledByteBuffer>> encodedImageProducerSequence = this.mProducerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
                if (imageRequest.getResizeOptions() != null) {
                    imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
                }
                return submitFetchRequest(encodedImageProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, requestListener);
            } catch (Exception e2) {
                return DataSources.immediateFailedDataSource(e2);
            }
        }
        return (DataSource) invokeLLL.objValue;
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048597, this, imageRequest, obj, requestLevel, requestListener)) == null) ? new Supplier<DataSource<CloseableReference<CloseableImage>>>(this, imageRequest, obj, requestLevel, requestListener) { // from class: com.facebook.imagepipeline.core.ImagePipeline.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImagePipeline this$0;
            public final /* synthetic */ Object val$callerContext;
            public final /* synthetic */ ImageRequest val$imageRequest;
            public final /* synthetic */ ImageRequest.RequestLevel val$requestLevel;
            public final /* synthetic */ RequestListener val$requestListener;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, imageRequest, obj, requestLevel, requestListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$imageRequest = imageRequest;
                this.val$callerContext = obj;
                this.val$requestLevel = requestLevel;
                this.val$requestListener = requestListener;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Objects.toStringHelper(this).add("uri", this.val$imageRequest.getSourceUri()).toString() : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.fetchDecodedImage(this.val$imageRequest, this.val$callerContext, this.val$requestLevel, this.val$requestListener) : (DataSource) invokeV.objValue;
            }
        } : (Supplier) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: d.d<java.lang.Boolean, d.e<java.lang.Boolean>>, d.d<java.lang.Boolean, d.e<TContinuationResult>> */
    public DataSource<Boolean> isInDiskCache(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, imageRequest)) == null) {
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
            SimpleDataSource create = SimpleDataSource.create();
            this.mMainBufferedDiskCache.contains(encodedCacheKey).g(new d<Boolean, e<Boolean>>(this, encodedCacheKey) { // from class: com.facebook.imagepipeline.core.ImagePipeline.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImagePipeline this$0;
                public final /* synthetic */ CacheKey val$cacheKey;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, encodedCacheKey};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$cacheKey = encodedCacheKey;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d.d
                public e<Boolean> then(e<Boolean> eVar) throws Exception {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, eVar)) == null) {
                        if (eVar.n() || eVar.p() || !eVar.l().booleanValue()) {
                            return this.this$0.mSmallImageBufferedDiskCache.contains(this.val$cacheKey);
                        }
                        return e.j(Boolean.TRUE);
                    }
                    return (e) invokeL2.objValue;
                }
            }).e(new d<Boolean, Void>(this, create) { // from class: com.facebook.imagepipeline.core.ImagePipeline.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImagePipeline this$0;
                public final /* synthetic */ SimpleDataSource val$dataSource;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, create};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$dataSource = create;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.d
                public Void then(e<Boolean> eVar) throws Exception {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                        this.val$dataSource.setResult(Boolean.valueOf((eVar.n() || eVar.p() || !eVar.l().booleanValue()) ? false : true));
                        return null;
                    }
                    return (Void) invokeL2.objValue;
                }
            });
            return create;
        }
        return (DataSource) invokeL.objValue;
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj, Priority priority) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048618, this, imageRequest, obj, priority)) == null) {
            if (!this.mIsPrefetchEnabledSupplier.get().booleanValue()) {
                return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
            }
            try {
                return submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
            } catch (Exception e2) {
                return DataSources.immediateFailedDataSource(e2);
            }
        }
        return (DataSource) invokeLLL.objValue;
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, imageRequest, obj, requestLevel)) == null) ? fetchDecodedImage(imageRequest, obj, requestLevel, null) : (DataSource) invokeLLL.objValue;
    }

    public boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, imageRequest)) == null) {
            if (imageRequest == null) {
                return false;
            }
            CloseableReference<CloseableImage> closeableReference = this.mBitmapMemoryCache.get(this.mCacheKeyFactory.getBitmapCacheKey(imageRequest, null));
            try {
                return CloseableReference.isValid(closeableReference);
            } finally {
                CloseableReference.closeSafely(closeableReference);
            }
        }
        return invokeL.booleanValue;
    }

    public boolean isInDiskCacheSync(Uri uri, ImageRequest.CacheChoice cacheChoice) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, uri, cacheChoice)) == null) ? isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build()) : invokeLL.booleanValue;
    }

    public void clearMemoryCaches(Predicate<CacheKey> predicate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, predicate) == null) {
            if (predicate == null) {
                clearMemoryCaches();
                return;
            }
            this.mBitmapMemoryCache.removeAll(predicate);
            this.mEncodedMemoryCache.removeAll(predicate);
        }
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, imageRequest, obj, requestLevel, requestListener)) == null) {
            try {
                return submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, requestLevel, obj, requestListener);
            } catch (Exception e2) {
                return DataSources.immediateFailedDataSource(e2);
            }
        }
        return (DataSource) invokeLLLL.objValue;
    }

    public boolean isInDiskCacheSync(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, imageRequest)) == null) {
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
            int i2 = AnonymousClass8.$SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[imageRequest.getCacheChoice().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return false;
                }
                return this.mSmallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
            }
            return this.mMainBufferedDiskCache.diskCheckSync(encodedCacheKey);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, producer, settableProducerContext, requestListener)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
            }
            try {
                try {
                    DataSource<CloseableReference<T>> create = CloseableProducerToDataSourceAdapter.create(producer, settableProducerContext, requestListener);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return create;
                } catch (Exception e2) {
                    DataSource<CloseableReference<T>> immediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return immediateFailedDataSource;
                }
            } catch (Throwable th) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                throw th;
            }
        }
        return (DataSource) invokeLLL.objValue;
    }
}
