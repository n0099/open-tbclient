package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.ImagePipelineConfigProxy;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class ImagePipelineConfig {
    public static DefaultImageRequestConfig sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    @Nullable
    public final MemoryCache<CacheKey, CloseableImage> mBitmapCache;
    public final Bitmap.Config mBitmapConfig;
    public final CountingMemoryCache.EntryStateObserver<CacheKey> mBitmapMemoryCacheEntryStateObserver;
    public final Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
    public final MemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
    public final CacheKeyFactory mCacheKeyFactory;
    @Nullable
    public final CallerContextVerifier mCallerContextVerifier;
    public final CloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
    public final Context mContext;
    public final boolean mDiskCacheEnabled;
    public final boolean mDownsampleEnabled;
    @Nullable
    public final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public final Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
    public final ExecutorSupplier mExecutorSupplier;
    public final FileCacheFactory mFileCacheFactory;
    public final int mHttpNetworkTimeout;
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    @Nullable
    public final ImageDecoder mImageDecoder;
    @Nullable
    public final ImageDecoderConfig mImageDecoderConfig;
    public final ImagePipelineExperiments mImagePipelineExperiments;
    @Nullable
    public final ImageTranscoderFactory mImageTranscoderFactory;
    @Nullable
    public final Integer mImageTranscoderType;
    public final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    public final DiskCacheConfig mMainDiskCacheConfig;
    public final int mMemoryChunkType;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final NetworkFetcher mNetworkFetcher;
    @Nullable
    public final PlatformBitmapFactory mPlatformBitmapFactory;
    public final PoolFactory mPoolFactory;
    public final ProgressiveJpegConfig mProgressiveJpegConfig;
    public final Set<RequestListener2> mRequestListener2s;
    public final Set<RequestListener> mRequestListeners;
    public final boolean mResizeAndRotateEnabledForNetwork;
    public final DiskCacheConfig mSmallImageDiskCacheConfig;

    /* loaded from: classes8.dex */
    public static class Builder {
        public Bitmap.Config mBitmapConfig;
        @Nullable
        public MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
        public CountingMemoryCache.EntryStateObserver<CacheKey> mBitmapMemoryCacheEntryStateObserver;
        public Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
        public MemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
        public CacheKeyFactory mCacheKeyFactory;
        public CallerContextVerifier mCallerContextVerifier;
        public CloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
        public final Context mContext;
        public boolean mDiskCacheEnabled;
        public boolean mDownsampleEnabled;
        @Nullable
        public MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
        public Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
        public ExecutorSupplier mExecutorSupplier;
        public final ImagePipelineExperiments.Builder mExperimentsBuilder;
        public FileCacheFactory mFileCacheFactory;
        public int mHttpConnectionTimeout;
        public ImageCacheStatsTracker mImageCacheStatsTracker;
        public ImageDecoder mImageDecoder;
        public ImageDecoderConfig mImageDecoderConfig;
        public ImageTranscoderFactory mImageTranscoderFactory;
        @Nullable
        public Integer mImageTranscoderType;
        public Supplier<Boolean> mIsPrefetchEnabledSupplier;
        public DiskCacheConfig mMainDiskCacheConfig;
        @Nullable
        public Integer mMemoryChunkType;
        public MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        public NetworkFetcher mNetworkFetcher;
        public PlatformBitmapFactory mPlatformBitmapFactory;
        public PoolFactory mPoolFactory;
        public ProgressiveJpegConfig mProgressiveJpegConfig;
        public Set<RequestListener2> mRequestListener2s;
        public Set<RequestListener> mRequestListeners;
        public boolean mResizeAndRotateEnabledForNetwork;
        public DiskCacheConfig mSmallImageDiskCacheConfig;

        public Builder(Context context) {
            this.mDownsampleEnabled = false;
            this.mImageTranscoderType = null;
            this.mMemoryChunkType = null;
            this.mResizeAndRotateEnabledForNetwork = true;
            this.mHttpConnectionTimeout = -1;
            this.mExperimentsBuilder = new ImagePipelineExperiments.Builder(this);
            this.mDiskCacheEnabled = true;
            this.mCloseableReferenceLeakTracker = new NoOpCloseableReferenceLeakTracker();
            this.mContext = (Context) Preconditions.checkNotNull(context);
        }

        public Builder setBitmapMemoryCache(@Nullable MemoryCache<CacheKey, CloseableImage> memoryCache) {
            this.mBitmapMemoryCache = memoryCache;
            return this;
        }

        public Builder setBitmapMemoryCacheEntryStateObserver(CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver) {
            this.mBitmapMemoryCacheEntryStateObserver = entryStateObserver;
            return this;
        }

        public Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setBitmapMemoryCacheTrimStrategy(MemoryCache.CacheTrimStrategy cacheTrimStrategy) {
            this.mBitmapMemoryCacheTrimStrategy = cacheTrimStrategy;
            return this;
        }

        public Builder setBitmapsConfig(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.mCacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public Builder setCallerContextVerifier(CallerContextVerifier callerContextVerifier) {
            this.mCallerContextVerifier = callerContextVerifier;
            return this;
        }

        public Builder setCloseableReferenceLeakTracker(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            this.mCloseableReferenceLeakTracker = closeableReferenceLeakTracker;
            return this;
        }

        public Builder setDiskCacheEnabled(boolean z) {
            this.mDiskCacheEnabled = z;
            return this;
        }

        public Builder setDownsampleEnabled(boolean z) {
            this.mDownsampleEnabled = z;
            return this;
        }

        public Builder setEncodedMemoryCache(@Nullable MemoryCache<CacheKey, PooledByteBuffer> memoryCache) {
            this.mEncodedMemoryCache = memoryCache;
            return this;
        }

        public Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mEncodedMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setExecutorSupplier(ExecutorSupplier executorSupplier) {
            this.mExecutorSupplier = executorSupplier;
            return this;
        }

        public Builder setFileCacheFactory(FileCacheFactory fileCacheFactory) {
            this.mFileCacheFactory = fileCacheFactory;
            return this;
        }

        public Builder setHttpConnectionTimeout(int i) {
            this.mHttpConnectionTimeout = i;
            return this;
        }

        public Builder setImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.mImageCacheStatsTracker = imageCacheStatsTracker;
            return this;
        }

        public Builder setImageDecoder(ImageDecoder imageDecoder) {
            this.mImageDecoder = imageDecoder;
            return this;
        }

        public Builder setImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
            this.mImageDecoderConfig = imageDecoderConfig;
            return this;
        }

        public Builder setImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
            this.mImageTranscoderFactory = imageTranscoderFactory;
            return this;
        }

        public Builder setImageTranscoderType(int i) {
            this.mImageTranscoderType = Integer.valueOf(i);
            return this;
        }

        public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> supplier) {
            this.mIsPrefetchEnabledSupplier = supplier;
            return this;
        }

        public Builder setMainDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mMainDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder setMemoryChunkType(int i) {
            this.mMemoryChunkType = Integer.valueOf(i);
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        public Builder setNetworkFetcher(NetworkFetcher networkFetcher) {
            this.mNetworkFetcher = networkFetcher;
            return this;
        }

        public Builder setPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
            this.mPlatformBitmapFactory = platformBitmapFactory;
            return this;
        }

        public Builder setPoolFactory(PoolFactory poolFactory) {
            this.mPoolFactory = poolFactory;
            return this;
        }

        public Builder setProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
            this.mProgressiveJpegConfig = progressiveJpegConfig;
            return this;
        }

        public Builder setRequestListener2s(Set<RequestListener2> set) {
            this.mRequestListener2s = set;
            return this;
        }

        public Builder setRequestListeners(Set<RequestListener> set) {
            this.mRequestListeners = set;
            return this;
        }

        public Builder setResizeAndRotateEnabledForNetwork(boolean z) {
            this.mResizeAndRotateEnabledForNetwork = z;
            return this;
        }

        public Builder setSmallImageDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mSmallImageDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public ImagePipelineConfig build() {
            return new ImagePipelineConfig(this);
        }

        public ImagePipelineExperiments.Builder experiment() {
            return this.mExperimentsBuilder;
        }

        @Nullable
        public Integer getImageTranscoderType() {
            return this.mImageTranscoderType;
        }

        @Nullable
        public Integer getMemoryChunkType() {
            return this.mMemoryChunkType;
        }

        public boolean isDiskCacheEnabled() {
            return this.mDiskCacheEnabled;
        }

        public boolean isDownsampleEnabled() {
            return this.mDownsampleEnabled;
        }
    }

    /* loaded from: classes8.dex */
    public static class DefaultImageRequestConfig {
        public boolean mProgressiveRenderingEnabled;

        public DefaultImageRequestConfig() {
            this.mProgressiveRenderingEnabled = false;
        }

        public boolean isProgressiveRenderingEnabled() {
            return this.mProgressiveRenderingEnabled;
        }

        public void setProgressiveRenderingEnabled(boolean z) {
            this.mProgressiveRenderingEnabled = z;
        }
    }

    public static DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return sDefaultImageRequestConfig;
    }

    @VisibleForTesting
    public static void resetDefaultRequestConfig() {
        sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    }

    @Nullable
    public MemoryCache<CacheKey, CloseableImage> getBitmapCacheOverride() {
        return this.mBitmapCache;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public CountingMemoryCache.EntryStateObserver<CacheKey> getBitmapMemoryCacheEntryStateObserver() {
        return this.mBitmapMemoryCacheEntryStateObserver;
    }

    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.mBitmapMemoryCacheParamsSupplier;
    }

    public MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.mBitmapMemoryCacheTrimStrategy;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }

    @Nullable
    public CallerContextVerifier getCallerContextVerifier() {
        return this.mCallerContextVerifier;
    }

    public CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        return this.mCloseableReferenceLeakTracker;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCacheOverride() {
        return this.mEncodedMemoryCache;
    }

    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.mEncodedMemoryCacheParamsSupplier;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.mExecutorSupplier;
    }

    public ImagePipelineExperiments getExperiments() {
        return this.mImagePipelineExperiments;
    }

    public FileCacheFactory getFileCacheFactory() {
        return this.mFileCacheFactory;
    }

    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.mImageCacheStatsTracker;
    }

    @Nullable
    public ImageDecoder getImageDecoder() {
        return this.mImageDecoder;
    }

    @Nullable
    public ImageDecoderConfig getImageDecoderConfig() {
        return this.mImageDecoderConfig;
    }

    @Nullable
    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.mImageTranscoderFactory;
    }

    @Nullable
    public Integer getImageTranscoderType() {
        return this.mImageTranscoderType;
    }

    public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        return this.mIsPrefetchEnabledSupplier;
    }

    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.mMainDiskCacheConfig;
    }

    public int getMemoryChunkType() {
        return this.mMemoryChunkType;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public NetworkFetcher getNetworkFetcher() {
        return this.mNetworkFetcher;
    }

    @Nullable
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.mPlatformBitmapFactory;
    }

    public PoolFactory getPoolFactory() {
        return this.mPoolFactory;
    }

    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.mProgressiveJpegConfig;
    }

    public Set<RequestListener2> getRequestListener2s() {
        return Collections.unmodifiableSet(this.mRequestListener2s);
    }

    public Set<RequestListener> getRequestListeners() {
        return Collections.unmodifiableSet(this.mRequestListeners);
    }

    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.mSmallImageDiskCacheConfig;
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCacheEnabled;
    }

    public boolean isDownsampleEnabled() {
        return this.mDownsampleEnabled;
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        return this.mResizeAndRotateEnabledForNetwork;
    }

    public ImagePipelineConfig(Builder builder) {
        Supplier<MemoryCacheParams> supplier;
        MemoryCache.CacheTrimStrategy cacheTrimStrategy;
        Bitmap.Config config;
        CacheKeyFactory cacheKeyFactory;
        FileCacheFactory fileCacheFactory;
        Supplier<MemoryCacheParams> supplier2;
        ImageCacheStatsTracker imageCacheStatsTracker;
        Supplier<Boolean> supplier3;
        DiskCacheConfig diskCacheConfig;
        MemoryTrimmableRegistry memoryTrimmableRegistry;
        int i;
        PoolFactory poolFactory;
        ProgressiveJpegConfig progressiveJpegConfig;
        Set<RequestListener> set;
        Set<RequestListener2> set2;
        DiskCacheConfig diskCacheConfig2;
        ExecutorSupplier executorSupplier;
        WebpBitmapFactory loadWebpBitmapFactoryIfExists;
        HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        this.mImagePipelineExperiments = builder.mExperimentsBuilder.build();
        if (builder.mBitmapMemoryCacheParamsSupplier != null) {
            supplier = builder.mBitmapMemoryCacheParamsSupplier;
        } else {
            supplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity"));
        }
        this.mBitmapMemoryCacheParamsSupplier = supplier;
        if (builder.mBitmapMemoryCacheTrimStrategy != null) {
            cacheTrimStrategy = builder.mBitmapMemoryCacheTrimStrategy;
        } else {
            cacheTrimStrategy = new BitmapMemoryCacheTrimStrategy();
        }
        this.mBitmapMemoryCacheTrimStrategy = cacheTrimStrategy;
        this.mBitmapMemoryCacheEntryStateObserver = builder.mBitmapMemoryCacheEntryStateObserver;
        if (builder.mBitmapConfig != null) {
            config = builder.mBitmapConfig;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        this.mBitmapConfig = config;
        if (builder.mCacheKeyFactory != null) {
            cacheKeyFactory = builder.mCacheKeyFactory;
        } else {
            cacheKeyFactory = DefaultCacheKeyFactory.getInstance();
        }
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mContext = (Context) Preconditions.checkNotNull(builder.mContext);
        if (builder.mFileCacheFactory != null) {
            fileCacheFactory = builder.mFileCacheFactory;
        } else {
            fileCacheFactory = new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory());
        }
        this.mFileCacheFactory = fileCacheFactory;
        this.mDownsampleEnabled = builder.mDownsampleEnabled;
        if (builder.mEncodedMemoryCacheParamsSupplier != null) {
            supplier2 = builder.mEncodedMemoryCacheParamsSupplier;
        } else {
            supplier2 = new DefaultEncodedMemoryCacheParamsSupplier();
        }
        this.mEncodedMemoryCacheParamsSupplier = supplier2;
        if (builder.mImageCacheStatsTracker != null) {
            imageCacheStatsTracker = builder.mImageCacheStatsTracker;
        } else {
            imageCacheStatsTracker = NoOpImageCacheStatsTracker.getInstance();
        }
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
        this.mImageDecoder = builder.mImageDecoder;
        this.mImageTranscoderFactory = getImageTranscoderFactory(builder);
        this.mImageTranscoderType = builder.mImageTranscoderType;
        if (builder.mIsPrefetchEnabledSupplier != null) {
            supplier3 = builder.mIsPrefetchEnabledSupplier;
        } else {
            supplier3 = new Supplier<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfig.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.common.internal.Supplier
                public Boolean get() {
                    return Boolean.TRUE;
                }
            };
        }
        this.mIsPrefetchEnabledSupplier = supplier3;
        if (builder.mMainDiskCacheConfig != null) {
            diskCacheConfig = builder.mMainDiskCacheConfig;
        } else {
            diskCacheConfig = getDefaultMainDiskCacheConfig(builder.mContext);
        }
        this.mMainDiskCacheConfig = diskCacheConfig;
        if (builder.mMemoryTrimmableRegistry != null) {
            memoryTrimmableRegistry = builder.mMemoryTrimmableRegistry;
        } else {
            memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        }
        this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
        this.mMemoryChunkType = getMemoryChunkType(builder, this.mImagePipelineExperiments);
        if (builder.mHttpConnectionTimeout >= 0) {
            i = builder.mHttpConnectionTimeout;
        } else {
            i = 30000;
        }
        this.mHttpNetworkTimeout = i;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
        }
        if (builder.mNetworkFetcher == null) {
            if (ImagePipelineConfigProxy.getImagePipelineConfig() == null) {
                httpUrlConnectionNetworkFetcher = new HttpUrlConnectionNetworkFetcher(this.mHttpNetworkTimeout);
            } else {
                httpUrlConnectionNetworkFetcher = null;
            }
            this.mNetworkFetcher = httpUrlConnectionNetworkFetcher;
        } else {
            this.mNetworkFetcher = builder.mNetworkFetcher;
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        this.mPlatformBitmapFactory = builder.mPlatformBitmapFactory;
        if (builder.mPoolFactory != null) {
            poolFactory = builder.mPoolFactory;
        } else {
            poolFactory = new PoolFactory(PoolConfig.newBuilder().build());
        }
        this.mPoolFactory = poolFactory;
        if (builder.mProgressiveJpegConfig != null) {
            progressiveJpegConfig = builder.mProgressiveJpegConfig;
        } else {
            progressiveJpegConfig = new SimpleProgressiveJpegConfig();
        }
        this.mProgressiveJpegConfig = progressiveJpegConfig;
        if (builder.mRequestListeners != null) {
            set = builder.mRequestListeners;
        } else {
            set = new HashSet<>();
        }
        this.mRequestListeners = set;
        if (builder.mRequestListener2s != null) {
            set2 = builder.mRequestListener2s;
        } else {
            set2 = new HashSet<>();
        }
        this.mRequestListener2s = set2;
        this.mResizeAndRotateEnabledForNetwork = builder.mResizeAndRotateEnabledForNetwork;
        if (builder.mSmallImageDiskCacheConfig != null) {
            diskCacheConfig2 = builder.mSmallImageDiskCacheConfig;
        } else {
            diskCacheConfig2 = this.mMainDiskCacheConfig;
        }
        this.mSmallImageDiskCacheConfig = diskCacheConfig2;
        this.mImageDecoderConfig = builder.mImageDecoderConfig;
        int flexByteArrayPoolMaxNumThreads = this.mPoolFactory.getFlexByteArrayPoolMaxNumThreads();
        if (builder.mExecutorSupplier != null) {
            executorSupplier = builder.mExecutorSupplier;
        } else {
            executorSupplier = new DefaultExecutorSupplier(flexByteArrayPoolMaxNumThreads);
        }
        this.mExecutorSupplier = executorSupplier;
        this.mDiskCacheEnabled = builder.mDiskCacheEnabled;
        this.mCallerContextVerifier = builder.mCallerContextVerifier;
        this.mCloseableReferenceLeakTracker = builder.mCloseableReferenceLeakTracker;
        this.mBitmapCache = builder.mBitmapMemoryCache;
        this.mEncodedMemoryCache = builder.mEncodedMemoryCache;
        WebpBitmapFactory webpBitmapFactory = this.mImagePipelineExperiments.getWebpBitmapFactory();
        if (webpBitmapFactory != null) {
            setWebpBitmapFactory(webpBitmapFactory, this.mImagePipelineExperiments, new HoneycombBitmapCreator(getPoolFactory()));
        } else if (this.mImagePipelineExperiments.isWebpSupportEnabled() && WebpSupportStatus.sIsWebpSupportRequired && (loadWebpBitmapFactoryIfExists = WebpSupportStatus.loadWebpBitmapFactoryIfExists()) != null) {
            setWebpBitmapFactory(loadWebpBitmapFactoryIfExists, this.mImagePipelineExperiments, new HoneycombBitmapCreator(getPoolFactory()));
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public static DiskCacheConfig getDefaultMainDiskCacheConfig(Context context) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");
            }
            return DiskCacheConfig.newBuilder(context).build();
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    @Nullable
    public static ImageTranscoderFactory getImageTranscoderFactory(Builder builder) {
        if (builder.mImageTranscoderFactory != null && builder.mImageTranscoderType != null) {
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
        }
        if (builder.mImageTranscoderFactory != null) {
            return builder.mImageTranscoderFactory;
        }
        return null;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public static int getMemoryChunkType(Builder builder, ImagePipelineExperiments imagePipelineExperiments) {
        if (builder.mMemoryChunkType != null) {
            return builder.mMemoryChunkType.intValue();
        }
        if (imagePipelineExperiments.getMemoryType() == 2 && Build.VERSION.SDK_INT >= 27) {
            return 2;
        }
        if (imagePipelineExperiments.getMemoryType() == 1) {
            return 1;
        }
        if (imagePipelineExperiments.getMemoryType() == 0) {
        }
        return 0;
    }

    public static void setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory, ImagePipelineExperiments imagePipelineExperiments, BitmapCreator bitmapCreator) {
        WebpSupportStatus.sWebpBitmapFactory = webpBitmapFactory;
        WebpBitmapFactory.WebpErrorLogger webpErrorLogger = imagePipelineExperiments.getWebpErrorLogger();
        if (webpErrorLogger != null) {
            webpBitmapFactory.setWebpErrorLogger(webpErrorLogger);
        }
        if (bitmapCreator != null) {
            webpBitmapFactory.setBitmapCreator(bitmapCreator);
        }
    }
}
