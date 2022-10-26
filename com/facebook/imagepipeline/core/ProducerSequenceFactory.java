package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ProducerSequenceFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Producer mBackgroundLocalContentUriFetchToEncodedMemorySequence;
    public Producer mBackgroundLocalFileFetchToEncodedMemorySequence;
    public Producer mBackgroundNetworkFetchToEncodedMemorySequence;
    public Map mBitmapPrepareSequences;
    public Map mCloseableImagePrefetchSequences;
    public Producer mCommonNetworkFetchToEncodedMemorySequence;
    public final ContentResolver mContentResolver;
    public Producer mDataFetchSequence;
    public final boolean mDiskCacheEnabled;
    public final boolean mDownsampleEnabled;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    public final boolean mIsDiskCacheProbingEnabled;
    public final boolean mIsEncodedMemoryCacheProbingEnabled;
    public Producer mLocalAssetFetchSequence;
    public Producer mLocalContentUriEncodedImageProducerSequence;
    public Producer mLocalContentUriFetchSequence;
    public Producer mLocalFileEncodedImageProducerSequence;
    public Producer mLocalFileFetchToEncodedMemoryPrefetchSequence;
    public Producer mLocalImageFileFetchSequence;
    public Producer mLocalResourceFetchSequence;
    public Producer mLocalVideoFileFetchSequence;
    public Producer mNetworkEncodedImageProducerSequence;
    public Producer mNetworkFetchSequence;
    public Producer mNetworkFetchToEncodedMemoryPrefetchSequence;
    public final NetworkFetcher mNetworkFetcher;
    public final boolean mPartialImageCachingEnabled;
    public Map mPostprocessorSequences;
    public final ProducerFactory mProducerFactory;
    public Producer mQualifiedResourceFetchSequence;
    public final boolean mResizeAndRotateEnabledForNetwork;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
    public final boolean mUseBitmapPrepareToDraw;
    public final boolean mWebpSupportEnabled;

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher networkFetcher, boolean z, boolean z2, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z3, boolean z4, boolean z5, boolean z6, ImageTranscoderFactory imageTranscoderFactory, boolean z7, boolean z8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {contentResolver, producerFactory, networkFetcher, Boolean.valueOf(z), Boolean.valueOf(z2), threadHandoffProducerQueue, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), imageTranscoderFactory, Boolean.valueOf(z7), Boolean.valueOf(z8)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContentResolver = contentResolver;
        this.mProducerFactory = producerFactory;
        this.mNetworkFetcher = networkFetcher;
        this.mResizeAndRotateEnabledForNetwork = z;
        this.mWebpSupportEnabled = z2;
        this.mPostprocessorSequences = new HashMap();
        this.mCloseableImagePrefetchSequences = new HashMap();
        this.mBitmapPrepareSequences = new HashMap();
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mDownsampleEnabled = z3;
        this.mUseBitmapPrepareToDraw = z4;
        this.mPartialImageCachingEnabled = z5;
        this.mDiskCacheEnabled = z6;
        this.mImageTranscoderFactory = imageTranscoderFactory;
        this.mIsEncodedMemoryCacheProbingEnabled = z7;
        this.mIsDiskCacheProbingEnabled = z8;
    }

    private synchronized Producer getBackgroundLocalContentUriFetchToEncodeMemorySequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence");
                }
                if (this.mBackgroundLocalContentUriFetchToEncodedMemorySequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
                    }
                    this.mBackgroundLocalContentUriFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalContentUriFetchProducer()), this.mThreadHandoffProducerQueue);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer = this.mBackgroundLocalContentUriFetchToEncodedMemorySequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getBackgroundLocalFileFetchToEncodeMemorySequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
                }
                if (this.mBackgroundLocalFileFetchToEncodedMemorySequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");
                    }
                    this.mBackgroundLocalFileFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalFileFetchProducer()), this.mThreadHandoffProducerQueue);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer = this.mBackgroundLocalFileFetchToEncodedMemorySequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getBackgroundNetworkFetchToEncodedMemorySequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");
                }
                if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
                    }
                    this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer = this.mBackgroundNetworkFetchToEncodedMemorySequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getDataFetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            synchronized (this) {
                if (this.mDataFetchSequence == null) {
                    Producer newDataFetchProducer = this.mProducerFactory.newDataFetchProducer();
                    if (WebpSupportStatus.sIsWebpSupportRequired && (!this.mWebpSupportEnabled || WebpSupportStatus.sWebpBitmapFactory == null)) {
                        newDataFetchProducer = this.mProducerFactory.newWebpTranscodeProducer(newDataFetchProducer);
                    }
                    this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(newDataFetchProducer), true, this.mImageTranscoderFactory));
                }
                producer = this.mDataFetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getLocalFileFetchToEncodedMemoryPrefetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");
                }
                if (this.mLocalFileFetchToEncodedMemoryPrefetchSequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
                    }
                    this.mLocalFileFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer = this.mLocalFileFetchToEncodedMemoryPrefetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getNetworkFetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence");
                }
                if (this.mNetworkFetchSequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
                    }
                    this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer = this.mNetworkFetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getNetworkFetchToEncodedMemoryPrefetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
                }
                if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");
                    }
                    this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer = this.mNetworkFetchToEncodedMemoryPrefetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    public Producer getLocalContentUriFetchEncodedImageProducerSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence");
                }
                if (this.mLocalContentUriEncodedImageProducerSequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
                    }
                    this.mLocalContentUriEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalContentUriFetchToEncodeMemorySequence());
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            return this.mLocalContentUriEncodedImageProducerSequence;
        }
        return (Producer) invokeV.objValue;
    }

    public Producer getLocalFileFetchEncodedImageProducerSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence");
                }
                if (this.mLocalFileEncodedImageProducerSequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
                    }
                    this.mLocalFileEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            return this.mLocalFileEncodedImageProducerSequence;
        }
        return (Producer) invokeV.objValue;
    }

    public Producer getNetworkFetchEncodedImageProducerSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence");
                }
                if (this.mNetworkEncodedImageProducerSequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
                    }
                    this.mNetworkEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            return this.mNetworkEncodedImageProducerSequence;
        }
        return (Producer) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    private Producer getBasicDecodedImageSequence(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, imageRequest)) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getBasicDecodedImageSequence");
                }
                Preconditions.checkNotNull(imageRequest);
                Uri sourceUri = imageRequest.getSourceUri();
                Preconditions.checkNotNull(sourceUri, "Uri is null.");
                int sourceUriType = imageRequest.getSourceUriType();
                if (sourceUriType != 0) {
                    switch (sourceUriType) {
                        case 2:
                            Producer localVideoFileFetchSequence = getLocalVideoFileFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localVideoFileFetchSequence;
                        case 3:
                            Producer localImageFileFetchSequence = getLocalImageFileFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localImageFileFetchSequence;
                        case 4:
                            if (MediaUtils.isVideo(this.mContentResolver.getType(sourceUri))) {
                                Producer localVideoFileFetchSequence2 = getLocalVideoFileFetchSequence();
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.endSection();
                                }
                                return localVideoFileFetchSequence2;
                            }
                            Producer localContentUriFetchSequence = getLocalContentUriFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localContentUriFetchSequence;
                        case 5:
                            Producer localAssetFetchSequence = getLocalAssetFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localAssetFetchSequence;
                        case 6:
                            Producer localResourceFetchSequence = getLocalResourceFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localResourceFetchSequence;
                        case 7:
                            Producer dataFetchSequence = getDataFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return dataFetchSequence;
                        case 8:
                            return getQualifiedResourceFetchSequence();
                        default:
                            throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + getShortenedUriString(sourceUri));
                    }
                }
                Producer networkFetchSequence = getNetworkFetchSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return networkFetchSequence;
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
        return (Producer) invokeL.objValue;
    }

    private synchronized Producer getBitmapPrepareSequence(Producer producer) {
        InterceptResult invokeL;
        Producer producer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, producer)) == null) {
            synchronized (this) {
                producer2 = (Producer) this.mBitmapPrepareSequences.get(producer);
                if (producer2 == null) {
                    producer2 = this.mProducerFactory.newBitmapPrepareProducer(producer);
                    this.mBitmapPrepareSequences.put(producer, producer2);
                }
            }
            return producer2;
        }
        return (Producer) invokeL.objValue;
    }

    private synchronized Producer getDecodedImagePrefetchSequence(Producer producer) {
        InterceptResult invokeL;
        Producer producer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, producer)) == null) {
            synchronized (this) {
                if (!this.mCloseableImagePrefetchSequences.containsKey(producer)) {
                    this.mCloseableImagePrefetchSequences.put(producer, ProducerFactory.newSwallowResultProducer(producer));
                }
                producer2 = (Producer) this.mCloseableImagePrefetchSequences.get(producer);
            }
            return producer2;
        }
        return (Producer) invokeL.objValue;
    }

    private Producer newBitmapCacheGetToDecodeSequence(Producer producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, producer)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
            }
            Producer newBitmapCacheGetToBitmapCacheSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(producer));
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return newBitmapCacheGetToBitmapCacheSequence;
        }
        return (Producer) invokeL.objValue;
    }

    private Producer newBitmapCacheGetToLocalTransformSequence(Producer producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, producer)) == null) {
            return newBitmapCacheGetToLocalTransformSequence(producer, new ThumbnailProducer[]{this.mProducerFactory.newLocalExifThumbnailProducer()});
        }
        return (Producer) invokeL.objValue;
    }

    private Producer newLocalThumbnailProducer(ThumbnailProducer[] thumbnailProducerArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, thumbnailProducerArr)) == null) {
            return this.mProducerFactory.newResizeAndRotateProducer(this.mProducerFactory.newThumbnailBranchProducer(thumbnailProducerArr), true, this.mImageTranscoderFactory);
        }
        return (Producer) invokeL.objValue;
    }

    public static void validateEncodedImageRequest(ImageRequest imageRequest) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, imageRequest) == null) {
            Preconditions.checkNotNull(imageRequest);
            if (imageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
        }
    }

    public Producer getDecodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageRequest)) == null) {
            Producer basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
            if (this.mUseBitmapPrepareToDraw) {
                basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
            }
            return getDecodedImagePrefetchSequence(basicDecodedImageSequence);
        }
        return (Producer) invokeL.objValue;
    }

    private synchronized Producer getCommonNetworkFetchToEncodedMemorySequence() {
        InterceptResult invokeV;
        Producer producer;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
                }
                if (this.mCommonNetworkFetchToEncodedMemorySequence == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");
                    }
                    AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
                    this.mCommonNetworkFetchToEncodedMemorySequence = newAddImageTransformMetaDataProducer;
                    ProducerFactory producerFactory = this.mProducerFactory;
                    if (this.mResizeAndRotateEnabledForNetwork && !this.mDownsampleEnabled) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mCommonNetworkFetchToEncodedMemorySequence = producerFactory.newResizeAndRotateProducer(newAddImageTransformMetaDataProducer, z, this.mImageTranscoderFactory);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer = this.mCommonNetworkFetchToEncodedMemorySequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getLocalAssetFetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            synchronized (this) {
                if (this.mLocalAssetFetchSequence == null) {
                    this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
                }
                producer = this.mLocalAssetFetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getLocalImageFileFetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            synchronized (this) {
                if (this.mLocalImageFileFetchSequence == null) {
                    this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
                }
                producer = this.mLocalImageFileFetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getLocalResourceFetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            synchronized (this) {
                if (this.mLocalResourceFetchSequence == null) {
                    this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
                }
                producer = this.mLocalResourceFetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getLocalVideoFileFetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            synchronized (this) {
                if (this.mLocalVideoFileFetchSequence == null) {
                    this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
                }
                producer = this.mLocalVideoFileFetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getQualifiedResourceFetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            synchronized (this) {
                if (this.mQualifiedResourceFetchSequence == null) {
                    this.mQualifiedResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newQualifiedResourceFetchProducer());
                }
                producer = this.mQualifiedResourceFetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getLocalContentUriFetchSequence() {
        InterceptResult invokeV;
        Producer producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            synchronized (this) {
                if (this.mLocalContentUriFetchSequence == null) {
                    this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalContentUriFetchProducer(), new ThumbnailProducer[]{this.mProducerFactory.newLocalContentUriThumbnailFetchProducer(), this.mProducerFactory.newLocalExifThumbnailProducer()});
                }
                producer = this.mLocalContentUriFetchSequence;
            }
            return producer;
        }
        return (Producer) invokeV.objValue;
    }

    private synchronized Producer getPostprocessorSequence(Producer producer) {
        InterceptResult invokeL;
        Producer producer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, producer)) == null) {
            synchronized (this) {
                if (!this.mPostprocessorSequences.containsKey(producer)) {
                    this.mPostprocessorSequences.put(producer, this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer(this.mProducerFactory.newPostprocessorProducer(producer)));
                }
                producer2 = (Producer) this.mPostprocessorSequences.get(producer);
            }
            return producer2;
        }
        return (Producer) invokeL.objValue;
    }

    public static String getShortenedUriString(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, uri)) == null) {
            String valueOf = String.valueOf(uri);
            if (valueOf.length() > 30) {
                return valueOf.substring(0, 30) + StringHelper.STRING_MORE;
            }
            return valueOf;
        }
        return (String) invokeL.objValue;
    }

    private Producer newBitmapCacheGetToBitmapCacheSequence(Producer producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, producer)) == null) {
            ThreadHandoffProducer newBackgroundThreadHandoffProducer = this.mProducerFactory.newBackgroundThreadHandoffProducer(this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(this.mProducerFactory.newBitmapMemoryCacheProducer(producer)), this.mThreadHandoffProducerQueue);
            if (!this.mIsEncodedMemoryCacheProbingEnabled && !this.mIsDiskCacheProbingEnabled) {
                return this.mProducerFactory.newBitmapMemoryCacheGetProducer(newBackgroundThreadHandoffProducer);
            }
            return this.mProducerFactory.newBitmapProbeProducer(this.mProducerFactory.newBitmapMemoryCacheGetProducer(newBackgroundThreadHandoffProducer));
        }
        return (Producer) invokeL.objValue;
    }

    private Producer newDiskCacheSequence(Producer producer) {
        InterceptResult invokeL;
        DiskCacheWriteProducer newDiskCacheWriteProducer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, this, producer)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
            }
            if (this.mPartialImageCachingEnabled) {
                newDiskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(this.mProducerFactory.newPartialDiskCacheProducer(producer));
            } else {
                newDiskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(producer);
            }
            DiskCacheReadProducer newDiskCacheReadProducer = this.mProducerFactory.newDiskCacheReadProducer(newDiskCacheWriteProducer);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return newDiskCacheReadProducer;
        }
        return (Producer) invokeL.objValue;
    }

    public Producer getDecodedImageProducerSequence(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
            }
            Producer basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
            if (imageRequest.getPostprocessor() != null) {
                basicDecodedImageSequence = getPostprocessorSequence(basicDecodedImageSequence);
            }
            if (this.mUseBitmapPrepareToDraw) {
                basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return basicDecodedImageSequence;
        }
        return (Producer) invokeL.objValue;
    }

    private Producer newBitmapCacheGetToLocalTransformSequence(Producer producer, ThumbnailProducer[] thumbnailProducerArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, this, producer, thumbnailProducerArr)) == null) {
            return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(producer), thumbnailProducerArr));
        }
        return (Producer) invokeLL.objValue;
    }

    private Producer newLocalTransformationsSequence(Producer producer, ThumbnailProducer[] thumbnailProducerArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, this, producer, thumbnailProducerArr)) == null) {
            return ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(thumbnailProducerArr), this.mProducerFactory.newThrottlingProducer(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(producer), true, this.mImageTranscoderFactory)));
        }
        return (Producer) invokeLL.objValue;
    }

    private Producer newEncodedCacheMultiplexToTranscodeSequence(Producer producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, producer)) == null) {
            if (WebpSupportStatus.sIsWebpSupportRequired && (!this.mWebpSupportEnabled || WebpSupportStatus.sWebpBitmapFactory == null)) {
                producer = this.mProducerFactory.newWebpTranscodeProducer(producer);
            }
            if (this.mDiskCacheEnabled) {
                producer = newDiskCacheSequence(producer);
            }
            EncodedMemoryCacheProducer newEncodedMemoryCacheProducer = this.mProducerFactory.newEncodedMemoryCacheProducer(producer);
            if (this.mIsDiskCacheProbingEnabled) {
                return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(this.mProducerFactory.newEncodedProbeProducer(newEncodedMemoryCacheProducer));
            }
            return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(newEncodedMemoryCacheProducer);
        }
        return (Producer) invokeL.objValue;
    }

    public Producer getEncodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageRequest)) == null) {
            validateEncodedImageRequest(imageRequest);
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType != 0) {
                if (sourceUriType != 2 && sourceUriType != 3) {
                    Uri sourceUri = imageRequest.getSourceUri();
                    throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(sourceUri));
                }
                return getLocalFileFetchToEncodedMemoryPrefetchSequence();
            }
            return getNetworkFetchToEncodedMemoryPrefetchSequence();
        }
        return (Producer) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public Producer getEncodedImageProducerSequence(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, imageRequest)) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
                }
                validateEncodedImageRequest(imageRequest);
                Uri sourceUri = imageRequest.getSourceUri();
                int sourceUriType = imageRequest.getSourceUriType();
                if (sourceUriType != 0) {
                    if (sourceUriType != 2 && sourceUriType != 3) {
                        if (sourceUriType == 4) {
                            return getLocalContentUriFetchEncodedImageProducerSequence();
                        }
                        throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(sourceUri));
                    }
                    Producer localFileFetchEncodedImageProducerSequence = getLocalFileFetchEncodedImageProducerSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return localFileFetchEncodedImageProducerSequence;
                }
                Producer networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return networkFetchEncodedImageProducerSequence;
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
        return (Producer) invokeL.objValue;
    }
}
