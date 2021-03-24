package com.facebook.imagepipeline.core;

import android.net.Uri;
import c.d;
import c.e;
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
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes.dex */
public class ImagePipeline {
    public static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    public final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    public final CacheKeyFactory mCacheKeyFactory;
    public final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public AtomicLong mIdCounter = new AtomicLong();
    public final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    public final Supplier<Boolean> mLazyDataSource;
    public final BufferedDiskCache mMainBufferedDiskCache;
    public final ProducerSequenceFactory mProducerSequenceFactory;
    public final RequestListener mRequestListener;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;
    public final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    /* renamed from: com.facebook.imagepipeline.core.ImagePipeline$8  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice;

        static {
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

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3) {
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

    private Predicate<CacheKey> predicateForUri(final Uri uri) {
        return new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return cacheKey.containsUri(uri);
            }
        };
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable RequestListener requestListener) {
        boolean z;
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

    private DataSource<Void> submitPrefetchRequest(Producer<Void> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        RequestListener requestListenerForRequest = getRequestListenerForRequest(imageRequest, null);
        try {
            return ProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId(), requestListenerForRequest, obj, ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel), true, false, priority), requestListenerForRequest);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public void clearDiskCaches() {
        this.mMainBufferedDiskCache.clearAll();
        this.mSmallImageBufferedDiskCache.clearAll();
    }

    public void clearMemoryCaches() {
        Predicate<CacheKey> predicate = new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return true;
            }
        };
        this.mBitmapMemoryCache.removeAll(predicate);
        this.mEncodedMemoryCache.removeAll(predicate);
    }

    public void evictFromCache(Uri uri) {
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public void evictFromDiskCache(Uri uri) {
        evictFromDiskCache(ImageRequest.fromUri(uri));
    }

    public void evictFromMemoryCache(Uri uri) {
        Predicate<CacheKey> predicateForUri = predicateForUri(uri);
        this.mBitmapMemoryCache.removeAll(predicateForUri);
        this.mEncodedMemoryCache.removeAll(predicateForUri);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj) {
        return fetchEncodedImage(imageRequest, obj, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public String generateUniqueFutureId() {
        return String.valueOf(this.mIdCounter.getAndIncrement());
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.mBitmapMemoryCache;
    }

    @Nullable
    public CacheKey getCacheKey(@Nullable ImageRequest imageRequest, Object obj) {
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

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }

    @Nullable
    public CloseableReference<CloseableImage> getCachedImage(@Nullable CacheKey cacheKey) {
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

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object obj, final ImageRequest.RequestLevel requestLevel) {
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.1
            public String toString() {
                return Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, obj, requestLevel);
            }
        };
    }

    public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest imageRequest, final Object obj) {
        return new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.3
            public String toString() {
                return Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                return ImagePipeline.this.fetchEncodedImage(imageRequest, obj);
            }
        };
    }

    public long getMainBufferedDiskCacheCount() {
        BufferedDiskCache bufferedDiskCache = this.mMainBufferedDiskCache;
        if (bufferedDiskCache != null) {
            return bufferedDiskCache.getCount();
        }
        return -1L;
    }

    public long getMainBufferedDiskCacheSize() {
        BufferedDiskCache bufferedDiskCache = this.mMainBufferedDiskCache;
        if (bufferedDiskCache != null) {
            return bufferedDiskCache.getSize();
        }
        return -1L;
    }

    public ProducerSequenceFactory getProducerSequenceFactory() {
        return this.mProducerSequenceFactory;
    }

    public RequestListener getRequestListenerForRequest(ImageRequest imageRequest, @Nullable RequestListener requestListener) {
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

    public long getSmallBufferedDiskCacheCount() {
        BufferedDiskCache bufferedDiskCache = this.mSmallImageBufferedDiskCache;
        if (bufferedDiskCache != null) {
            return bufferedDiskCache.getCount();
        }
        return -1L;
    }

    public long getSmallBufferedDiskCacheSize() {
        BufferedDiskCache bufferedDiskCache = this.mSmallImageBufferedDiskCache;
        if (bufferedDiskCache != null) {
            return bufferedDiskCache.getSize();
        }
        return -1L;
    }

    public boolean hasCachedImage(@Nullable CacheKey cacheKey) {
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.mBitmapMemoryCache;
        if (memoryCache == null || cacheKey == null) {
            return false;
        }
        return memoryCache.contains((MemoryCache<CacheKey, CloseableImage>) cacheKey);
    }

    public boolean isInBitmapMemoryCache(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.mBitmapMemoryCache.contains(predicateForUri(uri));
    }

    public DataSource<Boolean> isInDiskCache(Uri uri) {
        return isInDiskCache(ImageRequest.fromUri(uri));
    }

    public boolean isInDiskCacheSync(Uri uri) {
        return isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT);
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.mLazyDataSource;
    }

    public boolean isPaused() {
        return this.mThreadHandoffProducerQueue.isQueueing();
    }

    public void pause() {
        this.mThreadHandoffProducerQueue.startQueueing();
    }

    public DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object obj) {
        boolean booleanValue;
        Producer<Void> decodedImagePrefetchProducerSequence;
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

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj) {
        return prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM);
    }

    public void resume() {
        this.mThreadHandoffProducerQueue.stopQueuing();
    }

    public void evictFromDiskCache(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        this.mMainBufferedDiskCache.remove(encodedCacheKey);
        this.mSmallImageBufferedDiskCache.remove(encodedCacheKey);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, @Nullable RequestListener requestListener) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH, requestListener);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj, @Nullable RequestListener requestListener) {
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

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object obj, final ImageRequest.RequestLevel requestLevel, @Nullable final RequestListener requestListener) {
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.2
            public String toString() {
                return Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, obj, requestLevel, requestListener);
            }
        };
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: c.d<java.lang.Boolean, c.e<java.lang.Boolean>>, c.d<java.lang.Boolean, c.e<TContinuationResult>> */
    public DataSource<Boolean> isInDiskCache(ImageRequest imageRequest) {
        final CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final SimpleDataSource create = SimpleDataSource.create();
        this.mMainBufferedDiskCache.contains(encodedCacheKey).i(new d<Boolean, e<Boolean>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.d
            public e<Boolean> then(e<Boolean> eVar) throws Exception {
                if (eVar.p() || eVar.r() || !eVar.n().booleanValue()) {
                    return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(encodedCacheKey);
                }
                return e.l(Boolean.TRUE);
            }
        }).g(new d<Boolean, Void>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.d
            public Void then(e<Boolean> eVar) throws Exception {
                create.setResult(Boolean.valueOf((eVar.p() || eVar.r() || !eVar.n().booleanValue()) ? false : true));
                return null;
            }
        });
        return create;
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.mIsPrefetchEnabledSupplier.get().booleanValue()) {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            return submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        return fetchDecodedImage(imageRequest, obj, requestLevel, null);
    }

    public boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
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

    public boolean isInDiskCacheSync(Uri uri, ImageRequest.CacheChoice cacheChoice) {
        return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build());
    }

    public void clearMemoryCaches(Predicate<CacheKey> predicate) {
        if (predicate == null) {
            clearMemoryCaches();
            return;
        }
        this.mBitmapMemoryCache.removeAll(predicate);
        this.mEncodedMemoryCache.removeAll(predicate);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener) {
        try {
            return submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, requestLevel, obj, requestListener);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public boolean isInDiskCacheSync(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        int i = AnonymousClass8.$SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[imageRequest.getCacheChoice().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            return this.mSmallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
        }
        return this.mMainBufferedDiskCache.diskCheckSync(encodedCacheKey);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
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
}
