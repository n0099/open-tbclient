package com.facebook.imagepipeline.core;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
/* loaded from: classes11.dex */
public class ImagePipelineExperiments {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mBitmapPrepareToDrawForPrefetch;
    public final int mBitmapPrepareToDrawMaxSizeBytes;
    public final int mBitmapPrepareToDrawMinSizeBytes;
    public final boolean mDecodeCancellationEnabled;
    public final boolean mDownscaleFrameToDrawableDimensions;
    public final boolean mGingerbreadDecoderEnabled;
    public final Supplier<Boolean> mLazyDataSource;
    public final int mMaxBitmapSize;
    public final boolean mNativeCodeDisabled;
    public final boolean mPartialImageCachingEnabled;
    public final ProducerFactoryMethod mProducerFactoryMethod;
    public final boolean mUseBitmapPrepareToDraw;
    public final boolean mUseDownsamplingRatioForResizing;
    public final WebpBitmapFactory mWebpBitmapFactory;
    public final WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
    public final boolean mWebpSupportEnabled;

    /* renamed from: com.facebook.imagepipeline.core.ImagePipelineExperiments$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mBitmapPrepareToDrawForPrefetch;
        public int mBitmapPrepareToDrawMaxSizeBytes;
        public int mBitmapPrepareToDrawMinSizeBytes;
        public final ImagePipelineConfig.Builder mConfigBuilder;
        public boolean mDecodeCancellationEnabled;
        public boolean mDownscaleFrameToDrawableDimensions;
        public boolean mGingerbreadDecoderEnabled;
        public Supplier<Boolean> mLazyDataSource;
        public int mMaxBitmapSize;
        public boolean mNativeCodeDisabled;
        public boolean mPartialImageCachingEnabled;
        public ProducerFactoryMethod mProducerFactoryMethod;
        public boolean mUseBitmapPrepareToDraw;
        public boolean mUseDownsamplingRatioForResizing;
        public WebpBitmapFactory mWebpBitmapFactory;
        public WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
        public boolean mWebpSupportEnabled;

        public Builder(ImagePipelineConfig.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWebpSupportEnabled = false;
            this.mDecodeCancellationEnabled = false;
            this.mUseDownsamplingRatioForResizing = false;
            this.mUseBitmapPrepareToDraw = false;
            this.mBitmapPrepareToDrawMinSizeBytes = 0;
            this.mBitmapPrepareToDrawMaxSizeBytes = 0;
            this.mBitmapPrepareToDrawForPrefetch = false;
            this.mMaxBitmapSize = 2048;
            this.mNativeCodeDisabled = false;
            this.mPartialImageCachingEnabled = false;
            this.mConfigBuilder = builder;
        }

        public ImagePipelineExperiments build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ImagePipelineExperiments(this, null) : (ImagePipelineExperiments) invokeV.objValue;
        }

        public boolean isPartialImageCachingEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPartialImageCachingEnabled : invokeV.booleanValue;
        }

        public ImagePipelineConfig.Builder setBitmapPrepareToDraw(boolean z, int i2, int i3, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
                this.mUseBitmapPrepareToDraw = z;
                this.mBitmapPrepareToDrawMinSizeBytes = i2;
                this.mBitmapPrepareToDrawMaxSizeBytes = i3;
                this.mBitmapPrepareToDrawForPrefetch = z2;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeCommon.objValue;
        }

        public ImagePipelineConfig.Builder setDecodeCancellationEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.mDecodeCancellationEnabled = z;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeZ.objValue;
        }

        public ImagePipelineConfig.Builder setGingerbreadDecoderEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.mGingerbreadDecoderEnabled = z;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeZ.objValue;
        }

        public ImagePipelineConfig.Builder setLazyDataSource(Supplier<Boolean> supplier) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, supplier)) == null) {
                this.mLazyDataSource = supplier;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeL.objValue;
        }

        public ImagePipelineConfig.Builder setMaxBitmapSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.mMaxBitmapSize = i2;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeI.objValue;
        }

        public ImagePipelineConfig.Builder setNativeCodeDisabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.mNativeCodeDisabled = z;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeZ.objValue;
        }

        public ImagePipelineConfig.Builder setPartialImageCachingEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.mPartialImageCachingEnabled = z;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeZ.objValue;
        }

        public ImagePipelineConfig.Builder setProducerFactoryMethod(ProducerFactoryMethod producerFactoryMethod) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, producerFactoryMethod)) == null) {
                this.mProducerFactoryMethod = producerFactoryMethod;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeL.objValue;
        }

        public ImagePipelineConfig.Builder setShouldDownscaleFrameToDrawableDimensions(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.mDownscaleFrameToDrawableDimensions = z;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeZ.objValue;
        }

        public ImagePipelineConfig.Builder setUseDownsampligRatioForResizing(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.mUseDownsamplingRatioForResizing = z;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeZ.objValue;
        }

        public ImagePipelineConfig.Builder setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, webpBitmapFactory)) == null) {
                this.mWebpBitmapFactory = webpBitmapFactory;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeL.objValue;
        }

        public ImagePipelineConfig.Builder setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, webpErrorLogger)) == null) {
                this.mWebpErrorLogger = webpErrorLogger;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeL.objValue;
        }

        public ImagePipelineConfig.Builder setWebpSupportEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.mWebpSupportEnabled = z;
                return this.mConfigBuilder;
            }
            return (ImagePipelineConfig.Builder) invokeZ.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultProducerFactoryMethod() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod
        public ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i2, int i3, boolean z4, int i4, CloseableReferenceFactory closeableReferenceFactory) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, byteArrayPool, imageDecoder, progressiveJpegConfig, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, platformBitmapFactory, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z4), Integer.valueOf(i4), closeableReferenceFactory})) == null) ? new ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, z, z2, z3, executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, platformBitmapFactory, i2, i3, z4, i4, closeableReferenceFactory) : (ProducerFactory) invokeCommon.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public interface ProducerFactoryMethod {
        ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i2, int i3, boolean z4, int i4, CloseableReferenceFactory closeableReferenceFactory);
    }

    public /* synthetic */ ImagePipelineExperiments(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static Builder newBuilder(ImagePipelineConfig.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, builder)) == null) ? new Builder(builder) : (Builder) invokeL.objValue;
    }

    public boolean getBitmapPrepareToDrawForPrefetch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBitmapPrepareToDrawForPrefetch : invokeV.booleanValue;
    }

    public int getBitmapPrepareToDrawMaxSizeBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBitmapPrepareToDrawMaxSizeBytes : invokeV.intValue;
    }

    public int getBitmapPrepareToDrawMinSizeBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBitmapPrepareToDrawMinSizeBytes : invokeV.intValue;
    }

    public int getMaxBitmapSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMaxBitmapSize : invokeV.intValue;
    }

    public ProducerFactoryMethod getProducerFactoryMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mProducerFactoryMethod : (ProducerFactoryMethod) invokeV.objValue;
    }

    public boolean getUseBitmapPrepareToDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mUseBitmapPrepareToDraw : invokeV.booleanValue;
    }

    public boolean getUseDownsamplingRatioForResizing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mUseDownsamplingRatioForResizing : invokeV.booleanValue;
    }

    public WebpBitmapFactory getWebpBitmapFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mWebpBitmapFactory : (WebpBitmapFactory) invokeV.objValue;
    }

    public WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mWebpErrorLogger : (WebpBitmapFactory.WebpErrorLogger) invokeV.objValue;
    }

    public boolean isDecodeCancellationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mDecodeCancellationEnabled : invokeV.booleanValue;
    }

    public boolean isGingerbreadDecoderEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mGingerbreadDecoderEnabled : invokeV.booleanValue;
    }

    public Supplier<Boolean> isLazyDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLazyDataSource : (Supplier) invokeV.objValue;
    }

    public boolean isNativeCodeDisabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mNativeCodeDisabled : invokeV.booleanValue;
    }

    public boolean isPartialImageCachingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mPartialImageCachingEnabled : invokeV.booleanValue;
    }

    public boolean isWebpSupportEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mWebpSupportEnabled : invokeV.booleanValue;
    }

    public boolean shouldDownscaleFrameToDrawableDimensions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mDownscaleFrameToDrawableDimensions : invokeV.booleanValue;
    }

    public ImagePipelineExperiments(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWebpSupportEnabled = builder.mWebpSupportEnabled;
        this.mWebpErrorLogger = builder.mWebpErrorLogger;
        this.mDecodeCancellationEnabled = builder.mDecodeCancellationEnabled;
        this.mWebpBitmapFactory = builder.mWebpBitmapFactory;
        this.mUseDownsamplingRatioForResizing = builder.mUseDownsamplingRatioForResizing;
        this.mUseBitmapPrepareToDraw = builder.mUseBitmapPrepareToDraw;
        this.mBitmapPrepareToDrawMinSizeBytes = builder.mBitmapPrepareToDrawMinSizeBytes;
        this.mBitmapPrepareToDrawMaxSizeBytes = builder.mBitmapPrepareToDrawMaxSizeBytes;
        this.mBitmapPrepareToDrawForPrefetch = builder.mBitmapPrepareToDrawForPrefetch;
        this.mMaxBitmapSize = builder.mMaxBitmapSize;
        this.mNativeCodeDisabled = builder.mNativeCodeDisabled;
        this.mPartialImageCachingEnabled = builder.mPartialImageCachingEnabled;
        if (builder.mProducerFactoryMethod != null) {
            this.mProducerFactoryMethod = builder.mProducerFactoryMethod;
        } else {
            this.mProducerFactoryMethod = new DefaultProducerFactoryMethod();
        }
        this.mLazyDataSource = builder.mLazyDataSource;
        this.mGingerbreadDecoderEnabled = builder.mGingerbreadDecoderEnabled;
        this.mDownscaleFrameToDrawableDimensions = builder.mDownscaleFrameToDrawableDimensions;
    }
}
