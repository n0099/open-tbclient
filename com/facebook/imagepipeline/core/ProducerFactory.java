package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BitmapPrepareProducer;
import com.facebook.imagepipeline.producers.BitmapProbeProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.EncodedProbeProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.NullProducer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
/* loaded from: classes7.dex */
public class ProducerFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SIMULTANEOUS_REQUESTS = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public AssetManager mAssetManager;
    public final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    public boolean mBitmapPrepareToDrawForPrefetch;
    public final int mBitmapPrepareToDrawMaxSizeBytes;
    public final int mBitmapPrepareToDrawMinSizeBytes;
    public final ByteArrayPool mByteArrayPool;
    public final CacheKeyFactory mCacheKeyFactory;
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public ContentResolver mContentResolver;
    public final boolean mDecodeCancellationEnabled;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
    public final boolean mDownsampleEnabled;
    public final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
    public final ExecutorSupplier mExecutorSupplier;
    public final ImageDecoder mImageDecoder;
    public final boolean mKeepCancelledFetchAsLowPriority;
    public final int mMaxBitmapSize;
    public final PlatformBitmapFactory mPlatformBitmapFactory;
    public final PooledByteBufferFactory mPooledByteBufferFactory;
    public final ProgressiveJpegConfig mProgressiveJpegConfig;
    public final boolean mResizeAndRotateEnabledForNetwork;
    public Resources mResources;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;

    public ProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z5, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, byteArrayPool, imageDecoder, progressiveJpegConfig, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, platformBitmapFactory, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z4), Integer.valueOf(i3), closeableReferenceFactory, Boolean.valueOf(z5), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mByteArrayPool = byteArrayPool;
        this.mImageDecoder = imageDecoder;
        this.mProgressiveJpegConfig = progressiveJpegConfig;
        this.mDownsampleEnabled = z;
        this.mResizeAndRotateEnabledForNetwork = z2;
        this.mDecodeCancellationEnabled = z3;
        this.mExecutorSupplier = executorSupplier;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mBitmapMemoryCache = memoryCache;
        this.mEncodedMemoryCache = memoryCache2;
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mEncodedMemoryCacheHistory = new BoundedLinkedHashSet<>(i4);
        this.mDiskCacheHistory = new BoundedLinkedHashSet<>(i4);
        this.mBitmapPrepareToDrawMinSizeBytes = i;
        this.mBitmapPrepareToDrawMaxSizeBytes = i2;
        this.mBitmapPrepareToDrawForPrefetch = z4;
        this.mMaxBitmapSize = i3;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
        this.mKeepCancelledFetchAsLowPriority = z5;
    }

    public static AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, producer)) == null) {
            return new AddImageTransformMetaDataProducer(producer);
        }
        return (AddImageTransformMetaDataProducer) invokeL.objValue;
    }

    public static <T> SwallowResultProducer<T> newSwallowResultProducer(Producer<T> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, producer)) == null) {
            return new SwallowResultProducer<>(producer);
        }
        return (SwallowResultProducer) invokeL.objValue;
    }

    public BitmapMemoryCacheGetProducer newBitmapMemoryCacheGetProducer(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, producer)) == null) {
            return new BitmapMemoryCacheGetProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
        }
        return (BitmapMemoryCacheGetProducer) invokeL.objValue;
    }

    public BitmapMemoryCacheKeyMultiplexProducer newBitmapMemoryCacheKeyMultiplexProducer(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, producer)) == null) {
            return new BitmapMemoryCacheKeyMultiplexProducer(this.mCacheKeyFactory, producer);
        }
        return (BitmapMemoryCacheKeyMultiplexProducer) invokeL.objValue;
    }

    public BitmapMemoryCacheProducer newBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, producer)) == null) {
            return new BitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
        }
        return (BitmapMemoryCacheProducer) invokeL.objValue;
    }

    public BitmapPrepareProducer newBitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, producer)) == null) {
            return new BitmapPrepareProducer(producer, this.mBitmapPrepareToDrawMinSizeBytes, this.mBitmapPrepareToDrawMaxSizeBytes, this.mBitmapPrepareToDrawForPrefetch);
        }
        return (BitmapPrepareProducer) invokeL.objValue;
    }

    public BitmapProbeProducer newBitmapProbeProducer(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, producer)) == null) {
            return new BitmapProbeProducer(this.mEncodedMemoryCache, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, producer);
        }
        return (BitmapProbeProducer) invokeL.objValue;
    }

    public DiskCacheReadProducer newDiskCacheReadProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, producer)) == null) {
            return new DiskCacheReadProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, producer);
        }
        return (DiskCacheReadProducer) invokeL.objValue;
    }

    public DiskCacheWriteProducer newDiskCacheWriteProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, producer)) == null) {
            return new DiskCacheWriteProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, producer);
        }
        return (DiskCacheWriteProducer) invokeL.objValue;
    }

    public EncodedCacheKeyMultiplexProducer newEncodedCacheKeyMultiplexProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, producer)) == null) {
            return new EncodedCacheKeyMultiplexProducer(this.mCacheKeyFactory, this.mKeepCancelledFetchAsLowPriority, producer);
        }
        return (EncodedCacheKeyMultiplexProducer) invokeL.objValue;
    }

    public EncodedMemoryCacheProducer newEncodedMemoryCacheProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, producer)) == null) {
            return new EncodedMemoryCacheProducer(this.mEncodedMemoryCache, this.mCacheKeyFactory, producer);
        }
        return (EncodedMemoryCacheProducer) invokeL.objValue;
    }

    public EncodedProbeProducer newEncodedProbeProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, producer)) == null) {
            return new EncodedProbeProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, producer);
        }
        return (EncodedProbeProducer) invokeL.objValue;
    }

    public Producer<EncodedImage> newNetworkFetchProducer(NetworkFetcher networkFetcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, networkFetcher)) == null) {
            return new NetworkFetchProducer(this.mPooledByteBufferFactory, this.mByteArrayPool, networkFetcher);
        }
        return (Producer) invokeL.objValue;
    }

    public PartialDiskCacheProducer newPartialDiskCacheProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, producer)) == null) {
            return new PartialDiskCacheProducer(this.mDefaultBufferedDiskCache, this.mCacheKeyFactory, this.mPooledByteBufferFactory, this.mByteArrayPool, producer);
        }
        return (PartialDiskCacheProducer) invokeL.objValue;
    }

    public PostprocessedBitmapMemoryCacheProducer newPostprocessorBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, producer)) == null) {
            return new PostprocessedBitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
        }
        return (PostprocessedBitmapMemoryCacheProducer) invokeL.objValue;
    }

    public PostprocessorProducer newPostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, producer)) == null) {
            return new PostprocessorProducer(producer, this.mPlatformBitmapFactory, this.mExecutorSupplier.forBackgroundTasks());
        }
        return (PostprocessorProducer) invokeL.objValue;
    }

    public <T> ThrottlingProducer<T> newThrottlingProducer(Producer<T> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, producer)) == null) {
            return new ThrottlingProducer<>(5, this.mExecutorSupplier.forLightweightBackgroundTasks(), producer);
        }
        return (ThrottlingProducer) invokeL.objValue;
    }

    public ThumbnailBranchProducer newThumbnailBranchProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, thumbnailProducerArr)) == null) {
            return new ThumbnailBranchProducer(thumbnailProducerArr);
        }
        return (ThumbnailBranchProducer) invokeL.objValue;
    }

    public WebpTranscodeProducer newWebpTranscodeProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, producer)) == null) {
            return new WebpTranscodeProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, producer);
        }
        return (WebpTranscodeProducer) invokeL.objValue;
    }

    public static BranchOnSeparateImagesProducer newBranchOnSeparateImagesProducer(Producer<EncodedImage> producer, Producer<EncodedImage> producer2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, producer, producer2)) == null) {
            return new BranchOnSeparateImagesProducer(producer, producer2);
        }
        return (BranchOnSeparateImagesProducer) invokeLL.objValue;
    }

    public <T> ThreadHandoffProducer<T> newBackgroundThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, producer, threadHandoffProducerQueue)) == null) {
            return new ThreadHandoffProducer<>(producer, threadHandoffProducerQueue);
        }
        return (ThreadHandoffProducer) invokeLL.objValue;
    }

    public static <T> NullProducer<T> newNullProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new NullProducer<>();
        }
        return (NullProducer) invokeV.objValue;
    }

    public DataFetchProducer newDataFetchProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new DataFetchProducer(this.mPooledByteBufferFactory);
        }
        return (DataFetchProducer) invokeV.objValue;
    }

    public LocalAssetFetchProducer newLocalAssetFetchProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new LocalAssetFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mAssetManager);
        }
        return (LocalAssetFetchProducer) invokeV.objValue;
    }

    public LocalContentUriFetchProducer newLocalContentUriFetchProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new LocalContentUriFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
        }
        return (LocalContentUriFetchProducer) invokeV.objValue;
    }

    public LocalContentUriThumbnailFetchProducer newLocalContentUriThumbnailFetchProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new LocalContentUriThumbnailFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
        }
        return (LocalContentUriThumbnailFetchProducer) invokeV.objValue;
    }

    public LocalExifThumbnailProducer newLocalExifThumbnailProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return new LocalExifThumbnailProducer(this.mExecutorSupplier.forThumbnailProducer(), this.mPooledByteBufferFactory, this.mContentResolver);
        }
        return (LocalExifThumbnailProducer) invokeV.objValue;
    }

    public LocalFileFetchProducer newLocalFileFetchProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return new LocalFileFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory);
        }
        return (LocalFileFetchProducer) invokeV.objValue;
    }

    public LocalResourceFetchProducer newLocalResourceFetchProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return new LocalResourceFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mResources);
        }
        return (LocalResourceFetchProducer) invokeV.objValue;
    }

    public LocalVideoThumbnailProducer newLocalVideoThumbnailProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new LocalVideoThumbnailProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mContentResolver);
        }
        return (LocalVideoThumbnailProducer) invokeV.objValue;
    }

    public QualifiedResourceFetchProducer newQualifiedResourceFetchProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return new QualifiedResourceFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
        }
        return (QualifiedResourceFetchProducer) invokeV.objValue;
    }

    public DecodeProducer newDecodeProducer(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, producer)) == null) {
            return new DecodeProducer(this.mByteArrayPool, this.mExecutorSupplier.forDecode(), this.mImageDecoder, this.mProgressiveJpegConfig, this.mDownsampleEnabled, this.mResizeAndRotateEnabledForNetwork, this.mDecodeCancellationEnabled, producer, this.mMaxBitmapSize, this.mCloseableReferenceFactory, null, Suppliers.BOOLEAN_FALSE);
        }
        return (DecodeProducer) invokeL.objValue;
    }

    public ResizeAndRotateProducer newResizeAndRotateProducer(Producer<EncodedImage> producer, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{producer, Boolean.valueOf(z), imageTranscoderFactory})) == null) {
            return new ResizeAndRotateProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, producer, z, imageTranscoderFactory);
        }
        return (ResizeAndRotateProducer) invokeCommon.objValue;
    }
}
