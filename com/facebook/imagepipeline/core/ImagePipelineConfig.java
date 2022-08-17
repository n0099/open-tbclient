package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class ImagePipelineConfig {
    public static /* synthetic */ Interceptable $ic;
    public static DefaultImageRequestConfig sDefaultImageRequestConfig;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

        public ImagePipelineConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ImagePipelineConfig(this) : (ImagePipelineConfig) invokeV.objValue;
        }

        public ImagePipelineExperiments.Builder experiment() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mExperimentsBuilder : (ImagePipelineExperiments.Builder) invokeV.objValue;
        }

        @Nullable
        public Integer getImageTranscoderType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mImageTranscoderType : (Integer) invokeV.objValue;
        }

        @Nullable
        public Integer getMemoryChunkType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMemoryChunkType : (Integer) invokeV.objValue;
        }

        public boolean isDiskCacheEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDiskCacheEnabled : invokeV.booleanValue;
        }

        public boolean isDownsampleEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDownsampleEnabled : invokeV.booleanValue;
        }

        public Builder setBitmapMemoryCache(@Nullable MemoryCache<CacheKey, CloseableImage> memoryCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, memoryCache)) == null) {
                this.mBitmapMemoryCache = memoryCache;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBitmapMemoryCacheEntryStateObserver(CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, entryStateObserver)) == null) {
                this.mBitmapMemoryCacheEntryStateObserver = entryStateObserver;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, supplier)) == null) {
                this.mBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBitmapMemoryCacheTrimStrategy(MemoryCache.CacheTrimStrategy cacheTrimStrategy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cacheTrimStrategy)) == null) {
                this.mBitmapMemoryCacheTrimStrategy = cacheTrimStrategy;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBitmapsConfig(Bitmap.Config config) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, config)) == null) {
                this.mBitmapConfig = config;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cacheKeyFactory)) == null) {
                this.mCacheKeyFactory = cacheKeyFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCallerContextVerifier(CallerContextVerifier callerContextVerifier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, callerContextVerifier)) == null) {
                this.mCallerContextVerifier = callerContextVerifier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCloseableReferenceLeakTracker(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, closeableReferenceLeakTracker)) == null) {
                this.mCloseableReferenceLeakTracker = closeableReferenceLeakTracker;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDiskCacheEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.mDiskCacheEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDownsampleEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                this.mDownsampleEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setEncodedMemoryCache(@Nullable MemoryCache<CacheKey, PooledByteBuffer> memoryCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, memoryCache)) == null) {
                this.mEncodedMemoryCache = memoryCache;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, supplier)) == null) {
                this.mEncodedMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExecutorSupplier(ExecutorSupplier executorSupplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, executorSupplier)) == null) {
                this.mExecutorSupplier = executorSupplier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFileCacheFactory(FileCacheFactory fileCacheFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, fileCacheFactory)) == null) {
                this.mFileCacheFactory = fileCacheFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setHttpConnectionTimeout(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
                this.mHttpConnectionTimeout = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, imageCacheStatsTracker)) == null) {
                this.mImageCacheStatsTracker = imageCacheStatsTracker;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageDecoder(ImageDecoder imageDecoder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, imageDecoder)) == null) {
                this.mImageDecoder = imageDecoder;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, imageDecoderConfig)) == null) {
                this.mImageDecoderConfig = imageDecoderConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, imageTranscoderFactory)) == null) {
                this.mImageTranscoderFactory = imageTranscoderFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setImageTranscoderType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
                this.mImageTranscoderType = Integer.valueOf(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> supplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, supplier)) == null) {
                this.mIsPrefetchEnabledSupplier = supplier;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMainDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, diskCacheConfig)) == null) {
                this.mMainDiskCacheConfig = diskCacheConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMemoryChunkType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
                this.mMemoryChunkType = Integer.valueOf(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, memoryTrimmableRegistry)) == null) {
                this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNetworkFetcher(NetworkFetcher networkFetcher) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, networkFetcher)) == null) {
                this.mNetworkFetcher = networkFetcher;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, platformBitmapFactory)) == null) {
                this.mPlatformBitmapFactory = platformBitmapFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setPoolFactory(PoolFactory poolFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, poolFactory)) == null) {
                this.mPoolFactory = poolFactory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, progressiveJpegConfig)) == null) {
                this.mProgressiveJpegConfig = progressiveJpegConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRequestListener2s(Set<RequestListener2> set) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, set)) == null) {
                this.mRequestListener2s = set;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRequestListeners(Set<RequestListener> set) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, set)) == null) {
                this.mRequestListeners = set;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setResizeAndRotateEnabledForNetwork(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
                this.mResizeAndRotateEnabledForNetwork = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSmallImageDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, diskCacheConfig)) == null) {
                this.mSmallImageDiskCacheConfig = diskCacheConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
    }

    /* loaded from: classes4.dex */
    public static class DefaultImageRequestConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mProgressiveRenderingEnabled;

        public boolean isProgressiveRenderingEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mProgressiveRenderingEnabled : invokeV.booleanValue;
        }

        public void setProgressiveRenderingEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.mProgressiveRenderingEnabled = z;
            }
        }

        public DefaultImageRequestConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mProgressiveRenderingEnabled = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1400742443, "Lcom/facebook/imagepipeline/core/ImagePipelineConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1400742443, "Lcom/facebook/imagepipeline/core/ImagePipelineConfig;");
                return;
            }
        }
        sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    }

    public static DefaultImageRequestConfig getDefaultImageRequestConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sDefaultImageRequestConfig : (DefaultImageRequestConfig) invokeV.objValue;
    }

    public static DiskCacheConfig getDefaultMainDiskCacheConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
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
        return (DiskCacheConfig) invokeL.objValue;
    }

    public static Builder newBuilder(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? new Builder(context) : (Builder) invokeL.objValue;
    }

    @VisibleForTesting
    public static void resetDefaultRequestConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            sDefaultImageRequestConfig = new DefaultImageRequestConfig();
        }
    }

    public static void setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory, ImagePipelineExperiments imagePipelineExperiments, BitmapCreator bitmapCreator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, webpBitmapFactory, imagePipelineExperiments, bitmapCreator) == null) {
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

    @Nullable
    public MemoryCache<CacheKey, CloseableImage> getBitmapCacheOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBitmapCache : (MemoryCache) invokeV.objValue;
    }

    public Bitmap.Config getBitmapConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBitmapConfig : (Bitmap.Config) invokeV.objValue;
    }

    public CountingMemoryCache.EntryStateObserver<CacheKey> getBitmapMemoryCacheEntryStateObserver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBitmapMemoryCacheEntryStateObserver : (CountingMemoryCache.EntryStateObserver) invokeV.objValue;
    }

    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBitmapMemoryCacheParamsSupplier : (Supplier) invokeV.objValue;
    }

    public MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBitmapMemoryCacheTrimStrategy : (MemoryCache.CacheTrimStrategy) invokeV.objValue;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCacheKeyFactory : (CacheKeyFactory) invokeV.objValue;
    }

    @Nullable
    public CallerContextVerifier getCallerContextVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCallerContextVerifier : (CallerContextVerifier) invokeV.objValue;
    }

    public CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCloseableReferenceLeakTracker : (CloseableReferenceLeakTracker) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    @Nullable
    public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCacheOverride() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mEncodedMemoryCache : (MemoryCache) invokeV.objValue;
    }

    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mEncodedMemoryCacheParamsSupplier : (Supplier) invokeV.objValue;
    }

    public ExecutorSupplier getExecutorSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mExecutorSupplier : (ExecutorSupplier) invokeV.objValue;
    }

    public ImagePipelineExperiments getExperiments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mImagePipelineExperiments : (ImagePipelineExperiments) invokeV.objValue;
    }

    public FileCacheFactory getFileCacheFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mFileCacheFactory : (FileCacheFactory) invokeV.objValue;
    }

    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mImageCacheStatsTracker : (ImageCacheStatsTracker) invokeV.objValue;
    }

    @Nullable
    public ImageDecoder getImageDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mImageDecoder : (ImageDecoder) invokeV.objValue;
    }

    @Nullable
    public ImageDecoderConfig getImageDecoderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mImageDecoderConfig : (ImageDecoderConfig) invokeV.objValue;
    }

    @Nullable
    public ImageTranscoderFactory getImageTranscoderFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mImageTranscoderFactory : (ImageTranscoderFactory) invokeV.objValue;
    }

    @Nullable
    public Integer getImageTranscoderType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mImageTranscoderType : (Integer) invokeV.objValue;
    }

    public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mIsPrefetchEnabledSupplier : (Supplier) invokeV.objValue;
    }

    public DiskCacheConfig getMainDiskCacheConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mMainDiskCacheConfig : (DiskCacheConfig) invokeV.objValue;
    }

    public int getMemoryChunkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mMemoryChunkType : invokeV.intValue;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mMemoryTrimmableRegistry : (MemoryTrimmableRegistry) invokeV.objValue;
    }

    public NetworkFetcher getNetworkFetcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mNetworkFetcher : (NetworkFetcher) invokeV.objValue;
    }

    @Nullable
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mPlatformBitmapFactory : (PlatformBitmapFactory) invokeV.objValue;
    }

    public PoolFactory getPoolFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mPoolFactory : (PoolFactory) invokeV.objValue;
    }

    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mProgressiveJpegConfig : (ProgressiveJpegConfig) invokeV.objValue;
    }

    public Set<RequestListener2> getRequestListener2s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? Collections.unmodifiableSet(this.mRequestListener2s) : (Set) invokeV.objValue;
    }

    public Set<RequestListener> getRequestListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? Collections.unmodifiableSet(this.mRequestListeners) : (Set) invokeV.objValue;
    }

    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mSmallImageDiskCacheConfig : (DiskCacheConfig) invokeV.objValue;
    }

    public boolean isDiskCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mDiskCacheEnabled : invokeV.booleanValue;
    }

    public boolean isDownsampleEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mDownsampleEnabled : invokeV.booleanValue;
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mResizeAndRotateEnabledForNetwork : invokeV.booleanValue;
    }

    public ImagePipelineConfig(Builder builder) {
        CacheKeyFactory cacheKeyFactory;
        ImageCacheStatsTracker imageCacheStatsTracker;
        MemoryTrimmableRegistry memoryTrimmableRegistry;
        PoolFactory poolFactory;
        WebpBitmapFactory loadWebpBitmapFactoryIfExists;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        this.mImagePipelineExperiments = builder.mExperimentsBuilder.build();
        this.mBitmapMemoryCacheParamsSupplier = builder.mBitmapMemoryCacheParamsSupplier == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity")) : builder.mBitmapMemoryCacheParamsSupplier;
        this.mBitmapMemoryCacheTrimStrategy = builder.mBitmapMemoryCacheTrimStrategy == null ? new BitmapMemoryCacheTrimStrategy() : builder.mBitmapMemoryCacheTrimStrategy;
        this.mBitmapMemoryCacheEntryStateObserver = builder.mBitmapMemoryCacheEntryStateObserver;
        this.mBitmapConfig = builder.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : builder.mBitmapConfig;
        if (builder.mCacheKeyFactory != null) {
            cacheKeyFactory = builder.mCacheKeyFactory;
        } else {
            cacheKeyFactory = DefaultCacheKeyFactory.getInstance();
        }
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mContext = (Context) Preconditions.checkNotNull(builder.mContext);
        this.mFileCacheFactory = builder.mFileCacheFactory == null ? new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory()) : builder.mFileCacheFactory;
        this.mDownsampleEnabled = builder.mDownsampleEnabled;
        this.mEncodedMemoryCacheParamsSupplier = builder.mEncodedMemoryCacheParamsSupplier == null ? new DefaultEncodedMemoryCacheParamsSupplier() : builder.mEncodedMemoryCacheParamsSupplier;
        if (builder.mImageCacheStatsTracker != null) {
            imageCacheStatsTracker = builder.mImageCacheStatsTracker;
        } else {
            imageCacheStatsTracker = NoOpImageCacheStatsTracker.getInstance();
        }
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
        this.mImageDecoder = builder.mImageDecoder;
        this.mImageTranscoderFactory = getImageTranscoderFactory(builder);
        this.mImageTranscoderType = builder.mImageTranscoderType;
        this.mIsPrefetchEnabledSupplier = builder.mIsPrefetchEnabledSupplier == null ? new Supplier<Boolean>(this) { // from class: com.facebook.imagepipeline.core.ImagePipelineConfig.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImagePipelineConfig this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public Boolean get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.TRUE : (Boolean) invokeV.objValue;
            }
        } : builder.mIsPrefetchEnabledSupplier;
        this.mMainDiskCacheConfig = builder.mMainDiskCacheConfig == null ? getDefaultMainDiskCacheConfig(builder.mContext) : builder.mMainDiskCacheConfig;
        if (builder.mMemoryTrimmableRegistry != null) {
            memoryTrimmableRegistry = builder.mMemoryTrimmableRegistry;
        } else {
            memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        }
        this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
        this.mMemoryChunkType = getMemoryChunkType(builder, this.mImagePipelineExperiments);
        this.mHttpNetworkTimeout = builder.mHttpConnectionTimeout < 0 ? 30000 : builder.mHttpConnectionTimeout;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
        }
        if (builder.mNetworkFetcher != null) {
            this.mNetworkFetcher = builder.mNetworkFetcher;
        } else {
            this.mNetworkFetcher = ImagePipelineConfigProxy.getImagePipelineConfig() == null ? new HttpUrlConnectionNetworkFetcher(this.mHttpNetworkTimeout) : null;
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
        this.mProgressiveJpegConfig = builder.mProgressiveJpegConfig == null ? new SimpleProgressiveJpegConfig() : builder.mProgressiveJpegConfig;
        this.mRequestListeners = builder.mRequestListeners == null ? new HashSet<>() : builder.mRequestListeners;
        this.mRequestListener2s = builder.mRequestListener2s == null ? new HashSet<>() : builder.mRequestListener2s;
        this.mResizeAndRotateEnabledForNetwork = builder.mResizeAndRotateEnabledForNetwork;
        this.mSmallImageDiskCacheConfig = builder.mSmallImageDiskCacheConfig == null ? this.mMainDiskCacheConfig : builder.mSmallImageDiskCacheConfig;
        this.mImageDecoderConfig = builder.mImageDecoderConfig;
        this.mExecutorSupplier = builder.mExecutorSupplier == null ? new DefaultExecutorSupplier(this.mPoolFactory.getFlexByteArrayPoolMaxNumThreads()) : builder.mExecutorSupplier;
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

    @Nullable
    public static ImageTranscoderFactory getImageTranscoderFactory(Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, builder)) == null) {
            if (builder.mImageTranscoderFactory == null || builder.mImageTranscoderType == null) {
                if (builder.mImageTranscoderFactory != null) {
                    return builder.mImageTranscoderFactory;
                }
                return null;
            }
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
        }
        return (ImageTranscoderFactory) invokeL.objValue;
    }

    public static int getMemoryChunkType(Builder builder, ImagePipelineExperiments imagePipelineExperiments) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, builder, imagePipelineExperiments)) == null) {
            if (builder.mMemoryChunkType != null) {
                return builder.mMemoryChunkType.intValue();
            }
            if (imagePipelineExperiments.getMemoryType() != 2 || Build.VERSION.SDK_INT < 27) {
                if (imagePipelineExperiments.getMemoryType() == 1) {
                    return 1;
                }
                if (imagePipelineExperiments.getMemoryType() == 0) {
                }
                return 0;
            }
            return 2;
        }
        return invokeLL.intValue;
    }
}
