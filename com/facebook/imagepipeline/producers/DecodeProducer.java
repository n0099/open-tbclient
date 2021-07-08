package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
    public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
    public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
    public static final String EXTRA_IS_FINAL = "isFinal";
    public static final String PRODUCER_NAME = "DecodeProducer";
    public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
    public static final String SAMPLE_SIZE = "sampleSize";
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteArrayPool mByteArrayPool;
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public final boolean mDecodeCancellationEnabled;
    public final boolean mDownsampleEnabled;
    public final boolean mDownsampleEnabledForNetwork;
    public final Executor mExecutor;
    public final ImageDecoder mImageDecoder;
    public final Producer<EncodedImage> mInputProducer;
    public final int mMaxBitmapSize;
    public final ProgressiveJpegConfig mProgressiveJpegConfig;

    /* loaded from: classes5.dex */
    public class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DecodeProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocalImagesProgressiveDecoder(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i2) {
            super(decodeProducer, consumer, producerContext, z, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {decodeProducer, consumer, producerContext, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((DecodeProducer) objArr2[0], (Consumer) objArr2[1], (ProducerContext) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = decodeProducer;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, encodedImage)) == null) ? encodedImage.getSize() : invokeL.intValue;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public QualityInfo getQualityInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ImmutableQualityInfo.of(0, false, false) : (QualityInfo) invokeV.objValue;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, encodedImage, i2)) == null) {
                synchronized (this) {
                    if (BaseConsumer.isNotLast(i2)) {
                        return false;
                    }
                    return super.updateDecodeJob(encodedImage, i2);
                }
            }
            return invokeLI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mLastScheduledScanNumber;
        public final ProgressiveJpegConfig mProgressiveJpegConfig;
        public final ProgressiveJpegParser mProgressiveJpegParser;
        public final /* synthetic */ DecodeProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkImagesProgressiveDecoder(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z, int i2) {
            super(decodeProducer, consumer, producerContext, z, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {decodeProducer, consumer, producerContext, progressiveJpegParser, progressiveJpegConfig, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((DecodeProducer) objArr2[0], (Consumer) objArr2[1], (ProducerContext) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = decodeProducer;
            this.mProgressiveJpegParser = (ProgressiveJpegParser) Preconditions.checkNotNull(progressiveJpegParser);
            this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
            this.mLastScheduledScanNumber = 0;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, encodedImage)) == null) ? this.mProgressiveJpegParser.getBestScanEndOffset() : invokeL.intValue;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public QualityInfo getQualityInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber()) : (QualityInfo) invokeV.objValue;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, encodedImage, i2)) == null) {
                synchronized (this) {
                    boolean updateDecodeJob = super.updateDecodeJob(encodedImage, i2);
                    if ((BaseConsumer.isNotLast(i2) || BaseConsumer.statusHasFlag(i2, 8)) && !BaseConsumer.statusHasFlag(i2, 4) && EncodedImage.isValid(encodedImage) && encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                        if (!this.mProgressiveJpegParser.parseMoreData(encodedImage)) {
                            return false;
                        }
                        int bestScanNumber = this.mProgressiveJpegParser.getBestScanNumber();
                        if (bestScanNumber <= this.mLastScheduledScanNumber) {
                            return false;
                        }
                        if (bestScanNumber < this.mProgressiveJpegConfig.getNextScanNumberToDecode(this.mLastScheduledScanNumber) && !this.mProgressiveJpegParser.isEndMarkerRead()) {
                            return false;
                        }
                        this.mLastScheduledScanNumber = bestScanNumber;
                    }
                    return updateDecodeJob;
                }
            }
            return invokeLI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
        public transient /* synthetic */ FieldHolder $fh;
        public final String TAG;
        public final ImageDecodeOptions mImageDecodeOptions;
        @GuardedBy("this")
        public boolean mIsFinished;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;
        public final ProducerListener mProducerListener;
        public final /* synthetic */ DecodeProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProgressiveDecoder(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i2) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {decodeProducer, consumer, producerContext, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = decodeProducer;
            this.TAG = "ProgressiveDecoder";
            this.mProducerContext = producerContext;
            this.mProducerListener = producerContext.getListener();
            this.mImageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            this.mIsFinished = false;
            this.mJobScheduler = new JobScheduler(decodeProducer.mExecutor, new JobScheduler.JobRunnable(this, decodeProducer, producerContext, i2) { // from class: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ProgressiveDecoder this$1;
                public final /* synthetic */ int val$maxBitmapSize;
                public final /* synthetic */ ProducerContext val$producerContext;
                public final /* synthetic */ DecodeProducer val$this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, decodeProducer, producerContext, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i5 = newInitContext2.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$this$0 = decodeProducer;
                    this.val$producerContext = producerContext;
                    this.val$maxBitmapSize = i2;
                }

                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, encodedImage, i5) == null) || encodedImage == null) {
                        return;
                    }
                    if (this.this$1.this$0.mDownsampleEnabled || !BaseConsumer.statusHasFlag(i5, 16)) {
                        ImageRequest imageRequest = this.val$producerContext.getImageRequest();
                        if (this.this$1.this$0.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                            encodedImage.setSampleSize(DownsampleUtil.determineSampleSize(imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), encodedImage, this.val$maxBitmapSize));
                        }
                    }
                    this.this$1.doDecode(encodedImage, i5);
                }
            }, this.mImageDecodeOptions.minDecodeIntervalMs);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(this, decodeProducer, z) { // from class: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ProgressiveDecoder this$1;
                public final /* synthetic */ boolean val$decodeCancellationEnabled;
                public final /* synthetic */ DecodeProducer val$this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, decodeProducer, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i5 = newInitContext2.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$this$0 = decodeProducer;
                    this.val$decodeCancellationEnabled = z;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.val$decodeCancellationEnabled) {
                        this.this$1.handleCancellation();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.this$1.mProducerContext.isIntermediateResultExpected()) {
                        this.this$1.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(8:24|25|(9:(13:29|(11:33|34|35|36|38|39|(1:41)|42|43|44|45)|59|34|35|36|38|39|(0)|42|43|44|45)|(11:33|34|35|36|38|39|(0)|42|43|44|45)|38|39|(0)|42|43|44|45)|60|59|34|35|36) */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0106, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0107, code lost:
            r2 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00e5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void doDecode(EncodedImage encodedImage, int i2) {
            ResizeOptions resizeOptions;
            String str;
            int size;
            QualityInfo qualityInfo;
            QualityInfo qualityInfo2;
            CloseableImage decode;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, encodedImage, i2) != null) {
                return;
            }
            int i3 = i2;
            if ((encodedImage.getImageFormat() != DefaultImageFormats.JPEG && BaseConsumer.isNotLast(i2)) || isFinished() || !EncodedImage.isValid(encodedImage)) {
                return;
            }
            ImageFormat imageFormat = encodedImage.getImageFormat();
            String name = imageFormat != null ? imageFormat.getName() : "unknown";
            String str2 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
            String valueOf = String.valueOf(encodedImage.getSampleSize());
            boolean isLast = BaseConsumer.isLast(i2);
            boolean z = isLast && !BaseConsumer.statusHasFlag(i3, 8);
            boolean statusHasFlag = BaseConsumer.statusHasFlag(i3, 4);
            if (this.mProducerContext.getImageRequest().getResizeOptions() != null) {
                str = resizeOptions.width + "x" + resizeOptions.height;
            } else {
                str = "unknown";
            }
            try {
                long queuedTime = this.mJobScheduler.getQueuedTime();
                String valueOf2 = String.valueOf(this.mProducerContext.getImageRequest().getSourceUri());
                try {
                    try {
                        if (!z && !statusHasFlag) {
                            size = getIntermediateImageEndOffset(encodedImage);
                            if (!z && !statusHasFlag) {
                                qualityInfo = getQualityInfo();
                                qualityInfo2 = qualityInfo;
                                this.mProducerListener.onProducerStart(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                                decode = this.this$0.mImageDecoder.decode(encodedImage, size, qualityInfo2, this.mImageDecodeOptions);
                                if (encodedImage.getSampleSize() != 1) {
                                    i3 |= 16;
                                }
                                this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, getExtraMap(decode, queuedTime, qualityInfo2, isLast, name, str2, str, valueOf));
                                handleResult(decode, i3);
                                return;
                            }
                            qualityInfo = ImmutableQualityInfo.FULL_QUALITY;
                            qualityInfo2 = qualityInfo;
                            this.mProducerListener.onProducerStart(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                            decode = this.this$0.mImageDecoder.decode(encodedImage, size, qualityInfo2, this.mImageDecodeOptions);
                            if (encodedImage.getSampleSize() != 1) {
                            }
                            this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, getExtraMap(decode, queuedTime, qualityInfo2, isLast, name, str2, str, valueOf));
                            handleResult(decode, i3);
                            return;
                        }
                        if (!z) {
                            qualityInfo = getQualityInfo();
                            qualityInfo2 = qualityInfo;
                            this.mProducerListener.onProducerStart(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                            decode = this.this$0.mImageDecoder.decode(encodedImage, size, qualityInfo2, this.mImageDecodeOptions);
                            if (encodedImage.getSampleSize() != 1) {
                            }
                            this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, getExtraMap(decode, queuedTime, qualityInfo2, isLast, name, str2, str, valueOf));
                            handleResult(decode, i3);
                            return;
                        }
                        if (encodedImage.getSampleSize() != 1) {
                        }
                        this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, getExtraMap(decode, queuedTime, qualityInfo2, isLast, name, str2, str, valueOf));
                        handleResult(decode, i3);
                        return;
                    } catch (Exception e2) {
                        e = e2;
                        CloseableImage closeableImage = decode;
                        Map<String, String> extraMap = getExtraMap(closeableImage, queuedTime, qualityInfo2, isLast, name, str2, str, valueOf);
                        this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, e, extraMap);
                        this.mProducerListener.onDecoderFinishWithFailure(this.mProducerContext.getImageRequest(), encodedImage, e, extraMap);
                        handleError(e);
                        return;
                    }
                    decode = this.this$0.mImageDecoder.decode(encodedImage, size, qualityInfo2, this.mImageDecodeOptions);
                } catch (DecodeException e3) {
                    EncodedImage encodedImage2 = e3.getEncodedImage();
                    FLog.w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e3.getMessage(), valueOf2, encodedImage2.getFirstBytesAsHexString(10), Integer.valueOf(encodedImage2.getSize()));
                    throw e3;
                }
                size = encodedImage.getSize();
                qualityInfo = ImmutableQualityInfo.FULL_QUALITY;
                qualityInfo2 = qualityInfo;
                this.mProducerListener.onProducerStart(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
            } finally {
                EncodedImage.closeSafely(encodedImage);
            }
        }

        @Nullable
        private Map<String, String> getExtraMap(@Nullable CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{closeableImage, Long.valueOf(j), qualityInfo, Boolean.valueOf(z), str, str2, str3, str4})) == null) {
                if (this.mProducerListener.requiresExtraMap(this.mProducerContext.getId())) {
                    String valueOf = String.valueOf(j);
                    String valueOf2 = String.valueOf(qualityInfo.isOfGoodEnoughQuality());
                    String valueOf3 = String.valueOf(z);
                    if (closeableImage instanceof CloseableStaticBitmap) {
                        Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap();
                        HashMap hashMap = new HashMap(8);
                        hashMap.put("bitmapSize", underlyingBitmap.getWidth() + "x" + underlyingBitmap.getHeight());
                        hashMap.put(JobScheduler.QUEUE_TIME_KEY, valueOf);
                        hashMap.put("hasGoodQuality", valueOf2);
                        hashMap.put("isFinal", valueOf3);
                        hashMap.put("encodedImageSize", str2);
                        hashMap.put("imageFormat", str);
                        hashMap.put("requestedImageSize", str3);
                        hashMap.put("sampleSize", str4);
                        return ImmutableMap.copyOf((Map) hashMap);
                    }
                    HashMap hashMap2 = new HashMap(7);
                    hashMap2.put(JobScheduler.QUEUE_TIME_KEY, valueOf);
                    hashMap2.put("hasGoodQuality", valueOf2);
                    hashMap2.put("isFinal", valueOf3);
                    hashMap2.put("encodedImageSize", str2);
                    hashMap2.put("imageFormat", str);
                    hashMap2.put("requestedImageSize", str3);
                    hashMap2.put("sampleSize", str4);
                    return ImmutableMap.copyOf((Map) hashMap2);
                }
                return null;
            }
            return (Map) invokeCommon.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleCancellation() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65543, this) == null) {
                maybeFinish(true);
                getConsumer().onCancellation();
            }
        }

        private void handleError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65544, this, th) == null) {
                maybeFinish(true);
                getConsumer().onFailure(th);
            }
        }

        private void handleResult(CloseableImage closeableImage, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65545, this, closeableImage, i2) == null) {
                CloseableReference<CloseableImage> create = this.this$0.mCloseableReferenceFactory.create(closeableImage);
                try {
                    maybeFinish(BaseConsumer.isLast(i2));
                    getConsumer().onNewResult(create, i2);
                } finally {
                    CloseableReference.closeSafely(create);
                }
            }
        }

        private synchronized boolean isFinished() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
                synchronized (this) {
                    z = this.mIsFinished;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        private void maybeFinish(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
                synchronized (this) {
                    if (z) {
                        if (!this.mIsFinished) {
                            getConsumer().onProgressUpdate(1.0f);
                            this.mIsFinished = true;
                            this.mJobScheduler.clearJob();
                        }
                    }
                }
            }
        }

        public abstract int getIntermediateImageEndOffset(EncodedImage encodedImage);

        public abstract QualityInfo getQualityInfo();

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                handleCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                handleError(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onProgressUpdateImpl(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
                super.onProgressUpdateImpl(f2 * 0.99f);
            }
        }

        public boolean updateDecodeJob(EncodedImage encodedImage, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, encodedImage, i2)) == null) ? this.mJobScheduler.updateJob(encodedImage, i2) : invokeLI.booleanValue;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, encodedImage, i2) == null) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("DecodeProducer#onNewResultImpl");
                    }
                    boolean isLast = BaseConsumer.isLast(i2);
                    if (isLast && !EncodedImage.isValid(encodedImage)) {
                        handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
                    } else if (!updateDecodeJob(encodedImage, i2)) {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    } else {
                        boolean statusHasFlag = BaseConsumer.statusHasFlag(i2, 4);
                        if (isLast || statusHasFlag || this.mProducerContext.isIntermediateResultExpected()) {
                            this.mJobScheduler.scheduleJob();
                        }
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }
        }
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer, int i2, CloseableReferenceFactory closeableReferenceFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteArrayPool, executor, imageDecoder, progressiveJpegConfig, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), producer, Integer.valueOf(i2), closeableReferenceFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mImageDecoder = (ImageDecoder) Preconditions.checkNotNull(imageDecoder);
        this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        this.mDownsampleEnabled = z;
        this.mDownsampleEnabledForNetwork = z2;
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mDecodeCancellationEnabled = z3;
        this.mMaxBitmapSize = i2;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<EncodedImage> networkImagesProgressiveDecoder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("DecodeProducer#produceResults");
                }
                if (!UriUtil.isNetworkUri(producerContext.getImageRequest().getSourceUri())) {
                    networkImagesProgressiveDecoder = new LocalImagesProgressiveDecoder(this, consumer, producerContext, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
                } else {
                    networkImagesProgressiveDecoder = new NetworkImagesProgressiveDecoder(this, consumer, producerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
                }
                this.mInputProducer.produceResults(networkImagesProgressiveDecoder, producerContext);
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }
}
