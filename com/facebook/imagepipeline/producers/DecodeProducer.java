package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
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
/* loaded from: classes6.dex */
public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
    public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
    public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
    public static final String EXTRA_IS_FINAL = "isFinal";
    public static final String PRODUCER_NAME = "DecodeProducer";
    public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
    public static final String SAMPLE_SIZE = "sampleSize";
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

    /* loaded from: classes6.dex */
    public class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public LocalImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i2) {
            super(consumer, producerContext, z, i2);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return encodedImage.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public QualityInfo getQualityInfo() {
            return ImmutableQualityInfo.of(0, false, false);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i2) {
            if (BaseConsumer.isNotLast(i2)) {
                return false;
            }
            return super.updateDecodeJob(encodedImage, i2);
        }
    }

    /* loaded from: classes6.dex */
    public class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        public int mLastScheduledScanNumber;
        public final ProgressiveJpegConfig mProgressiveJpegConfig;
        public final ProgressiveJpegParser mProgressiveJpegParser;

        public NetworkImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z, int i2) {
            super(consumer, producerContext, z, i2);
            this.mProgressiveJpegParser = (ProgressiveJpegParser) Preconditions.checkNotNull(progressiveJpegParser);
            this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
            this.mLastScheduledScanNumber = 0;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return this.mProgressiveJpegParser.getBestScanEndOffset();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public QualityInfo getQualityInfo() {
            return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        public synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i2) {
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

    /* loaded from: classes6.dex */
    public abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        public static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
        public final String TAG;
        public final ImageDecodeOptions mImageDecodeOptions;
        @GuardedBy("this")
        public boolean mIsFinished;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;
        public final ProducerListener mProducerListener;

        public ProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext, final boolean z, final int i2) {
            super(consumer);
            this.TAG = "ProgressiveDecoder";
            this.mProducerContext = producerContext;
            this.mProducerListener = producerContext.getListener();
            this.mImageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            this.mIsFinished = false;
            this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, new JobScheduler.JobRunnable() { // from class: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, int i3) {
                    if (encodedImage != null) {
                        if (DecodeProducer.this.mDownsampleEnabled || !BaseConsumer.statusHasFlag(i3, 16)) {
                            ImageRequest imageRequest = producerContext.getImageRequest();
                            if (DecodeProducer.this.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                                encodedImage.setSampleSize(DownsampleUtil.determineSampleSize(imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), encodedImage, i2));
                            }
                        }
                        ProgressiveDecoder.this.doDecode(encodedImage, i3);
                    }
                }
            }, this.mImageDecodeOptions.minDecodeIntervalMs);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.2
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (z) {
                        ProgressiveDecoder.this.handleCancellation();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
                        ProgressiveDecoder.this.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00e0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void doDecode(EncodedImage encodedImage, int i2) {
            ResizeOptions resizeOptions;
            String str;
            int size;
            QualityInfo qualityInfo;
            QualityInfo qualityInfo2;
            CloseableImage closeableImage;
            CloseableImage decode;
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
                        try {
                            if (!z && !statusHasFlag) {
                                size = getIntermediateImageEndOffset(encodedImage);
                                if (!z && !statusHasFlag) {
                                    qualityInfo = getQualityInfo();
                                    qualityInfo2 = qualityInfo;
                                    this.mProducerListener.onProducerStart(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                                    decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, size, qualityInfo2, this.mImageDecodeOptions);
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
                                decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, size, qualityInfo2, this.mImageDecodeOptions);
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
                                decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, size, qualityInfo2, this.mImageDecodeOptions);
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
                            closeableImage = decode;
                            Map<String, String> extraMap = getExtraMap(closeableImage, queuedTime, qualityInfo2, isLast, name, str2, str, valueOf);
                            this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, e, extraMap);
                            this.mProducerListener.onDecoderFinishWithFailure(this.mProducerContext.getImageRequest(), encodedImage, e, extraMap);
                            handleError(e);
                            return;
                        }
                        decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, size, qualityInfo2, this.mImageDecodeOptions);
                    } catch (DecodeException e3) {
                        EncodedImage encodedImage2 = e3.getEncodedImage();
                        FLog.w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e3.getMessage(), valueOf2, encodedImage2.getFirstBytesAsHexString(10), Integer.valueOf(encodedImage2.getSize()));
                        throw e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    closeableImage = null;
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

        /* JADX INFO: Access modifiers changed from: private */
        public void handleCancellation() {
            maybeFinish(true);
            getConsumer().onCancellation();
        }

        private void handleError(Throwable th) {
            maybeFinish(true);
            getConsumer().onFailure(th);
        }

        private void handleResult(CloseableImage closeableImage, int i2) {
            CloseableReference<CloseableImage> create = DecodeProducer.this.mCloseableReferenceFactory.create(closeableImage);
            try {
                maybeFinish(BaseConsumer.isLast(i2));
                getConsumer().onNewResult(create, i2);
            } finally {
                CloseableReference.closeSafely(create);
            }
        }

        private synchronized boolean isFinished() {
            return this.mIsFinished;
        }

        private void maybeFinish(boolean z) {
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

        public abstract int getIntermediateImageEndOffset(EncodedImage encodedImage);

        public abstract QualityInfo getQualityInfo();

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            handleCancellation();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            handleError(th);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onProgressUpdateImpl(float f2) {
            super.onProgressUpdateImpl(f2 * 0.99f);
        }

        public boolean updateDecodeJob(EncodedImage encodedImage, int i2) {
            return this.mJobScheduler.updateJob(encodedImage, i2);
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
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

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer, int i2, CloseableReferenceFactory closeableReferenceFactory) {
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
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DecodeProducer#produceResults");
            }
            if (!UriUtil.isNetworkUri(producerContext.getImageRequest().getSourceUri())) {
                networkImagesProgressiveDecoder = new LocalImagesProgressiveDecoder(consumer, producerContext, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
            } else {
                networkImagesProgressiveDecoder = new NetworkImagesProgressiveDecoder(consumer, producerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
            }
            this.mInputProducer.produceResults(networkImagesProgressiveDecoder, producerContext);
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
