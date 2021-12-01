package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class ProducerSequenceFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public Producer<EncodedImage> mBackgroundLocalFileFetchToEncodedMemorySequence;
    @VisibleForTesting
    public Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;
    @VisibleForTesting
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mBitmapPrepareSequences;
    @VisibleForTesting
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences;
    public Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
    public final ContentResolver mContentResolver;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
    public final boolean mDiskCacheEnabled;
    public final boolean mDownsampleEnabled;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;
    @VisibleForTesting
    public Producer<CloseableReference<PooledByteBuffer>> mLocalFileEncodedImageProducerSequence;
    @VisibleForTesting
    public Producer<Void> mLocalFileFetchToEncodedMemoryPrefetchSequence;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;
    @VisibleForTesting
    public Producer<CloseableReference<PooledByteBuffer>> mNetworkEncodedImageProducerSequence;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;
    @VisibleForTesting
    public Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
    public final NetworkFetcher mNetworkFetcher;
    public final boolean mPartialImageCachingEnabled;
    @VisibleForTesting
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences;
    public final ProducerFactory mProducerFactory;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> mQualifiedResourceFetchSequence;
    public final boolean mResizeAndRotateEnabledForNetwork;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
    public final boolean mUseBitmapPrepareToDraw;
    public final boolean mWebpSupportEnabled;

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher networkFetcher, boolean z, boolean z2, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z3, boolean z4, boolean z5, boolean z6, ImageTranscoderFactory imageTranscoderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {contentResolver, producerFactory, networkFetcher, Boolean.valueOf(z), Boolean.valueOf(z2), threadHandoffProducerQueue, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), imageTranscoderFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    }

    private synchronized Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence() {
        InterceptResult invokeV;
        Producer<EncodedImage> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
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

    private synchronized Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence() {
        InterceptResult invokeV;
        Producer<EncodedImage> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    private Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, imageRequest)) == null) {
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
                            Producer<CloseableReference<CloseableImage>> localVideoFileFetchSequence = getLocalVideoFileFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localVideoFileFetchSequence;
                        case 3:
                            Producer<CloseableReference<CloseableImage>> localImageFileFetchSequence = getLocalImageFileFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localImageFileFetchSequence;
                        case 4:
                            if (MediaUtils.isVideo(this.mContentResolver.getType(sourceUri))) {
                                Producer<CloseableReference<CloseableImage>> localVideoFileFetchSequence2 = getLocalVideoFileFetchSequence();
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.endSection();
                                }
                                return localVideoFileFetchSequence2;
                            }
                            Producer<CloseableReference<CloseableImage>> localContentUriFetchSequence = getLocalContentUriFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localContentUriFetchSequence;
                        case 5:
                            Producer<CloseableReference<CloseableImage>> localAssetFetchSequence = getLocalAssetFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localAssetFetchSequence;
                        case 6:
                            Producer<CloseableReference<CloseableImage>> localResourceFetchSequence = getLocalResourceFetchSequence();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return localResourceFetchSequence;
                        case 7:
                            Producer<CloseableReference<CloseableImage>> dataFetchSequence = getDataFetchSequence();
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
                Producer<CloseableReference<CloseableImage>> networkFetchSequence = getNetworkFetchSequence();
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

    private synchronized Producer<CloseableReference<CloseableImage>> getBitmapPrepareSequence(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Producer<CloseableReference<CloseableImage>> producer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, producer)) == null) {
            synchronized (this) {
                producer2 = this.mBitmapPrepareSequences.get(producer);
                if (producer2 == null) {
                    producer2 = this.mProducerFactory.newBitmapPrepareProducer(producer);
                    this.mBitmapPrepareSequences.put(producer, producer2);
                }
            }
            return producer2;
        }
        return (Producer) invokeL.objValue;
    }

    private synchronized Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence() {
        InterceptResult invokeV;
        Producer<EncodedImage> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
                    this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(newAddImageTransformMetaDataProducer, this.mResizeAndRotateEnabledForNetwork && !this.mDownsampleEnabled, this.mImageTranscoderFactory);
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

    private synchronized Producer<CloseableReference<CloseableImage>> getDataFetchSequence() {
        InterceptResult invokeV;
        Producer<CloseableReference<CloseableImage>> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            synchronized (this) {
                if (this.mDataFetchSequence == null) {
                    Producer<EncodedImage> newDataFetchProducer = this.mProducerFactory.newDataFetchProducer();
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

    private synchronized Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Producer<Void> producer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, producer)) == null) {
            synchronized (this) {
                if (!this.mCloseableImagePrefetchSequences.containsKey(producer)) {
                    this.mCloseableImagePrefetchSequences.put(producer, ProducerFactory.newSwallowResultProducer(producer));
                }
                producer2 = this.mCloseableImagePrefetchSequences.get(producer);
            }
            return producer2;
        }
        return (Producer) invokeL.objValue;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence() {
        InterceptResult invokeV;
        Producer<CloseableReference<CloseableImage>> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
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

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence() {
        InterceptResult invokeV;
        Producer<CloseableReference<CloseableImage>> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
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

    private synchronized Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence() {
        InterceptResult invokeV;
        Producer<Void> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
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

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence() {
        InterceptResult invokeV;
        Producer<CloseableReference<CloseableImage>> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
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

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence() {
        InterceptResult invokeV;
        Producer<CloseableReference<CloseableImage>> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
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

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence() {
        InterceptResult invokeV;
        Producer<CloseableReference<CloseableImage>> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
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

    private synchronized Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence() {
        InterceptResult invokeV;
        Producer<CloseableReference<CloseableImage>> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
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

    private synchronized Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence() {
        InterceptResult invokeV;
        Producer<Void> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
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

    private synchronized Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Producer<CloseableReference<CloseableImage>> producer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, producer)) == null) {
            synchronized (this) {
                if (!this.mPostprocessorSequences.containsKey(producer)) {
                    this.mPostprocessorSequences.put(producer, this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer(this.mProducerFactory.newPostprocessorProducer(producer)));
                }
                producer2 = this.mPostprocessorSequences.get(producer);
            }
            return producer2;
        }
        return (Producer) invokeL.objValue;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence() {
        InterceptResult invokeV;
        Producer<CloseableReference<CloseableImage>> producer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
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

    public static String getShortenedUriString(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, uri)) == null) {
            String valueOf = String.valueOf(uri);
            if (valueOf.length() > 30) {
                return valueOf.substring(0, 30) + "...";
            }
            return valueOf;
        }
        return (String) invokeL.objValue;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, this, producer)) == null) ? this.mProducerFactory.newBitmapMemoryCacheGetProducer(this.mProducerFactory.newBackgroundThreadHandoffProducer(this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(this.mProducerFactory.newBitmapMemoryCacheProducer(producer)), this.mThreadHandoffProducerQueue)) : (Producer) invokeL.objValue;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, producer)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
            }
            Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(producer));
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return newBitmapCacheGetToBitmapCacheSequence;
        }
        return (Producer) invokeL.objValue;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, this, producer)) == null) ? newBitmapCacheGetToLocalTransformSequence(producer, new ThumbnailProducer[]{this.mProducerFactory.newLocalExifThumbnailProducer()}) : (Producer) invokeL.objValue;
    }

    private Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        DiskCacheWriteProducer newDiskCacheWriteProducer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, this, producer)) == null) {
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

    private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> producer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, this, producer)) == null) {
            if (WebpSupportStatus.sIsWebpSupportRequired && (!this.mWebpSupportEnabled || WebpSupportStatus.sWebpBitmapFactory == null)) {
                producer = this.mProducerFactory.newWebpTranscodeProducer(producer);
            }
            if (this.mDiskCacheEnabled) {
                producer = newDiskCacheSequence(producer);
            }
            return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(this.mProducerFactory.newEncodedMemoryCacheProducer(producer));
        }
        return (Producer) invokeL.objValue;
    }

    private Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, this, thumbnailProducerArr)) == null) ? this.mProducerFactory.newResizeAndRotateProducer(this.mProducerFactory.newThumbnailBranchProducer(thumbnailProducerArr), true, this.mImageTranscoderFactory) : (Producer) invokeL.objValue;
    }

    private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, this, producer, thumbnailProducerArr)) == null) ? ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(thumbnailProducerArr), this.mProducerFactory.newThrottlingProducer(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(producer), true, this.mImageTranscoderFactory))) : (Producer) invokeLL.objValue;
    }

    public static void validateEncodedImageRequest(ImageRequest imageRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, imageRequest) == null) {
            Preconditions.checkNotNull(imageRequest);
            Preconditions.checkArgument(imageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
        }
    }

    public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageRequest)) == null) {
            Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
            if (this.mUseBitmapPrepareToDraw) {
                basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
            }
            return getDecodedImagePrefetchSequence(basicDecodedImageSequence);
        }
        return (Producer) invokeL.objValue;
    }

    public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageRequest)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
            }
            Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
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

    public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
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
    public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest imageRequest) {
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
                        throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(sourceUri));
                    }
                    return getLocalFileFetchEncodedImageProducerSequence();
                }
                Producer<CloseableReference<PooledByteBuffer>> networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
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

    public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

    public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, this, producer, thumbnailProducerArr)) == null) ? newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(producer), thumbnailProducerArr)) : (Producer) invokeLL.objValue;
    }
}
