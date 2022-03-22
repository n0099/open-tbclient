package com.facebook.imagepipeline.core;

import android.content.Context;
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
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoderFactory;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes6.dex */
public class ImagePipelineFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public static ImagePipelineFactory sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public AnimatedFactory mAnimatedFactory;
    public CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
    public InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public final ImagePipelineConfig mConfig;
    public CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public ImageDecoder mImageDecoder;
    public ImagePipeline mImagePipeline;
    public ImageTranscoderFactory mImageTranscoderFactory;
    public BufferedDiskCache mMainBufferedDiskCache;
    public FileCache mMainFileCache;
    public PlatformBitmapFactory mPlatformBitmapFactory;
    public PlatformDecoder mPlatformDecoder;
    public ProducerFactory mProducerFactory;
    public ProducerSequenceFactory mProducerSequenceFactory;
    public BufferedDiskCache mSmallImageBufferedDiskCache;
    public FileCache mSmallImageFileCache;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1564856767, "Lcom/facebook/imagepipeline/core/ImagePipelineFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1564856767, "Lcom/facebook/imagepipeline/core/ImagePipelineFactory;");
                return;
            }
        }
        TAG = ImagePipelineFactory.class;
    }

    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imagePipelineConfig};
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
        this.mConfig = (ImagePipelineConfig) Preconditions.checkNotNull(imagePipelineConfig);
        this.mThreadHandoffProducerQueue = new ThreadHandoffProducerQueue(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
        this.mCloseableReferenceFactory = new CloseableReferenceFactory(imagePipelineConfig.getCloseableReferenceLeakTracker());
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Nullable
    private AnimatedFactory getAnimatedFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mAnimatedFactory == null) {
                this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache(), this.mConfig.getExperiments().shouldDownscaleFrameToDrawableDimensions());
            }
            return this.mAnimatedFactory;
        }
        return (AnimatedFactory) invokeV.objValue;
    }

    private ImageDecoder getImageDecoder() {
        InterceptResult invokeV;
        ImageDecoder imageDecoder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mImageDecoder == null) {
                if (this.mConfig.getImageDecoder() != null) {
                    this.mImageDecoder = this.mConfig.getImageDecoder();
                } else {
                    AnimatedFactory animatedFactory = getAnimatedFactory();
                    ImageDecoder imageDecoder2 = null;
                    if (animatedFactory != null) {
                        imageDecoder2 = animatedFactory.getGifDecoder(this.mConfig.getBitmapConfig());
                        imageDecoder = animatedFactory.getWebPDecoder(this.mConfig.getBitmapConfig());
                    } else {
                        imageDecoder = null;
                    }
                    if (this.mConfig.getImageDecoderConfig() == null) {
                        this.mImageDecoder = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder());
                    } else {
                        this.mImageDecoder = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
                        ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
                    }
                }
            }
            return this.mImageDecoder;
        }
        return (ImageDecoder) invokeV.objValue;
    }

    private ImageTranscoderFactory getImageTranscoderFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mImageTranscoderFactory == null) {
                if (this.mConfig.getImageTranscoderFactory() == null && this.mConfig.getImageTranscoderType() == null && this.mConfig.getExperiments().isNativeCodeDisabled()) {
                    this.mImageTranscoderFactory = new SimpleImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapSize());
                } else {
                    this.mImageTranscoderFactory = new MultiImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapSize(), this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), this.mConfig.getImageTranscoderFactory(), this.mConfig.getImageTranscoderType());
                }
            }
            return this.mImageTranscoderFactory;
        }
        return (ImageTranscoderFactory) invokeV.objValue;
    }

    public static ImagePipelineFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (ImagePipelineFactory) Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!") : (ImagePipelineFactory) invokeV.objValue;
    }

    private ProducerFactory getProducerFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.mProducerFactory == null) {
                this.mProducerFactory = this.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isDecodeCancellationEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch(), this.mConfig.getExperiments().getMaxBitmapSize(), getCloseableReferenceFactory());
            }
            return this.mProducerFactory;
        }
        return (ProducerFactory) invokeV.objValue;
    }

    private ProducerSequenceFactory getProducerSequenceFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            boolean z = Build.VERSION.SDK_INT >= 24 && this.mConfig.getExperiments().getUseBitmapPrepareToDraw();
            if (this.mProducerSequenceFactory == null) {
                this.mProducerSequenceFactory = new ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.isDownsampleEnabled(), z, this.mConfig.getExperiments().isPartialImageCachingEnabled(), this.mConfig.isDiskCacheEnabled(), getImageTranscoderFactory());
            }
            return this.mProducerSequenceFactory;
        }
        return (ProducerSequenceFactory) invokeV.objValue;
    }

    private BufferedDiskCache getSmallImageBufferedDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.mSmallImageBufferedDiskCache == null) {
                this.mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
            }
            return this.mSmallImageBufferedDiskCache;
        }
        return (BufferedDiskCache) invokeV.objValue;
    }

    public static synchronized boolean hasBeenInitialized() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (ImagePipelineFactory.class) {
                z = sInstance != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static synchronized void initialize(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            synchronized (ImagePipelineFactory.class) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ImagePipelineFactory#initialize");
                }
                initialize(ImagePipelineConfig.newBuilder(context).build());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }

    public static void setInstance(ImagePipelineFactory imagePipelineFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, imagePipelineFactory) == null) {
            sInstance = imagePipelineFactory;
        }
    }

    public static synchronized void shutDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            synchronized (ImagePipelineFactory.class) {
                if (sInstance != null) {
                    sInstance.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
                    sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
                    sInstance = null;
                }
            }
        }
    }

    @Nullable
    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            AnimatedFactory animatedFactory = getAnimatedFactory();
            if (animatedFactory == null) {
                return null;
            }
            return animatedFactory.getAnimatedDrawableFactory(context);
        }
        return (DrawableFactory) invokeL.objValue;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mBitmapCountingMemoryCache == null) {
                this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy());
            }
            return this.mBitmapCountingMemoryCache;
        }
        return (CountingMemoryCache) invokeV.objValue;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mBitmapMemoryCache == null) {
                this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
            }
            return this.mBitmapMemoryCache;
        }
        return (InstrumentedMemoryCache) invokeV.objValue;
    }

    public CloseableReferenceFactory getCloseableReferenceFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCloseableReferenceFactory : (CloseableReferenceFactory) invokeV.objValue;
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mEncodedCountingMemoryCache == null) {
                this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
            }
            return this.mEncodedCountingMemoryCache;
        }
        return (CountingMemoryCache) invokeV.objValue;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mEncodedMemoryCache == null) {
                this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(getEncodedCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
            }
            return this.mEncodedMemoryCache;
        }
        return (InstrumentedMemoryCache) invokeV.objValue;
    }

    public ImagePipeline getImagePipeline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mImagePipeline == null) {
                this.mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, Suppliers.of(Boolean.FALSE), this.mConfig.getExperiments().isLazyDataSource());
            }
            return this.mImagePipeline;
        }
        return (ImagePipeline) invokeV.objValue;
    }

    public BufferedDiskCache getMainBufferedDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mMainBufferedDiskCache == null) {
                this.mMainBufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
            }
            return this.mMainBufferedDiskCache;
        }
        return (BufferedDiskCache) invokeV.objValue;
    }

    public FileCache getMainFileCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mMainFileCache == null) {
                this.mMainFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getMainDiskCacheConfig());
            }
            return this.mMainFileCache;
        }
        return (FileCache) invokeV.objValue;
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mPlatformBitmapFactory == null) {
                this.mPlatformBitmapFactory = PlatformBitmapFactoryProvider.buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder(), getCloseableReferenceFactory());
            }
            return this.mPlatformBitmapFactory;
        }
        return (PlatformBitmapFactory) invokeV.objValue;
    }

    public PlatformDecoder getPlatformDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mPlatformDecoder == null) {
                this.mPlatformDecoder = PlatformDecoderFactory.buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().isGingerbreadDecoderEnabled());
            }
            return this.mPlatformDecoder;
        }
        return (PlatformDecoder) invokeV.objValue;
    }

    public FileCache getSmallImageFileCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mSmallImageFileCache == null) {
                this.mSmallImageFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getSmallImageDiskCacheConfig());
            }
            return this.mSmallImageFileCache;
        }
        return (FileCache) invokeV.objValue;
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, imagePipelineConfig) == null) {
            synchronized (ImagePipelineFactory.class) {
                if (sInstance != null) {
                    FLog.w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
                }
                sInstance = new ImagePipelineFactory(imagePipelineConfig);
            }
        }
    }
}
