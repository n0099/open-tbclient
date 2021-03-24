package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    public static final String INPUT_IMAGE_FORMAT = "Image format";
    @VisibleForTesting
    public static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    public static final String ORIGINAL_SIZE_KEY = "Original size";
    public static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    public static final String REQUESTED_SIZE_KEY = "Requested size";
    public static final String TRANSCODER_ID = "Transcoder id";
    public static final String TRANSCODING_RESULT = "Transcoding result";
    public final Executor mExecutor;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    public final Producer<EncodedImage> mInputProducer;
    public final boolean mIsResizingEnabled;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: classes.dex */
    public class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ImageTranscoderFactory mImageTranscoderFactory;
        public boolean mIsCancelled;
        public final boolean mIsResizingEnabled;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;

        public TransformingConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer);
            this.mIsCancelled = false;
            this.mProducerContext = producerContext;
            Boolean resizingAllowedOverride = producerContext.getImageRequest().getResizingAllowedOverride();
            this.mIsResizingEnabled = resizingAllowedOverride != null ? resizingAllowedOverride.booleanValue() : z;
            this.mImageTranscoderFactory = imageTranscoderFactory;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobScheduler.JobRunnable() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, int i) {
                    TransformingConsumer transformingConsumer = TransformingConsumer.this;
                    transformingConsumer.doTransform(encodedImage, i, (ImageTranscoder) Preconditions.checkNotNull(transformingConsumer.mImageTranscoderFactory.createImageTranscoder(encodedImage.getImageFormat(), TransformingConsumer.this.mIsResizingEnabled)));
                }
            }, 100);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.2
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doTransform(EncodedImage encodedImage, int i, ImageTranscoder imageTranscoder) {
            this.mProducerContext.getListener().onProducerStart(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME);
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            PooledByteBufferOutputStream newOutputStream = ResizeAndRotateProducer.this.mPooledByteBufferFactory.newOutputStream();
            try {
                ImageTranscodeResult transcode = imageTranscoder.transcode(encodedImage, newOutputStream, imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), null, 85);
                if (transcode.getTranscodeStatus() != 2) {
                    Map<String, String> extraMap = getExtraMap(encodedImage, imageRequest.getResizeOptions(), transcode, imageTranscoder.getIdentifier());
                    CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                    try {
                        EncodedImage encodedImage2 = new EncodedImage(of);
                        encodedImage2.setImageFormat(DefaultImageFormats.JPEG);
                        encodedImage2.parseMetaData();
                        this.mProducerContext.getListener().onProducerFinishWithSuccess(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, extraMap);
                        if (transcode.getTranscodeStatus() != 1) {
                            i |= 16;
                        }
                        getConsumer().onNewResult(encodedImage2, i);
                        EncodedImage.closeSafely(encodedImage2);
                        return;
                    } finally {
                        CloseableReference.closeSafely(of);
                    }
                }
                throw new RuntimeException("Error while transcoding the image");
            } catch (Exception e2) {
                this.mProducerContext.getListener().onProducerFinishWithFailure(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, e2, null);
                if (BaseConsumer.isLast(i)) {
                    getConsumer().onFailure(e2);
                }
            } finally {
                newOutputStream.close();
            }
        }

        private void forwardNewResult(EncodedImage encodedImage, int i, ImageFormat imageFormat) {
            EncodedImage newResultsForJpegOrHeif;
            if (imageFormat != DefaultImageFormats.JPEG && imageFormat != DefaultImageFormats.HEIF) {
                newResultsForJpegOrHeif = getNewResultForImagesWithoutExifData(encodedImage);
            } else {
                newResultsForJpegOrHeif = getNewResultsForJpegOrHeif(encodedImage);
            }
            getConsumer().onNewResult(newResultsForJpegOrHeif, i);
        }

        @Nullable
        private EncodedImage getCloneWithRotationApplied(EncodedImage encodedImage, int i) {
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            encodedImage.close();
            if (cloneOrNull != null) {
                cloneOrNull.setRotationAngle(i);
            }
            return cloneOrNull;
        }

        @Nullable
        private Map<String, String> getExtraMap(EncodedImage encodedImage, @Nullable ResizeOptions resizeOptions, @Nullable ImageTranscodeResult imageTranscodeResult, @Nullable String str) {
            String str2;
            if (this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
                String str3 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
                if (resizeOptions != null) {
                    str2 = resizeOptions.width + "x" + resizeOptions.height;
                } else {
                    str2 = "Unspecified";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(ResizeAndRotateProducer.INPUT_IMAGE_FORMAT, String.valueOf(encodedImage.getImageFormat()));
                hashMap.put(ResizeAndRotateProducer.ORIGINAL_SIZE_KEY, str3);
                hashMap.put(ResizeAndRotateProducer.REQUESTED_SIZE_KEY, str2);
                hashMap.put(JobScheduler.QUEUE_TIME_KEY, String.valueOf(this.mJobScheduler.getQueuedTime()));
                hashMap.put(ResizeAndRotateProducer.TRANSCODER_ID, str);
                hashMap.put(ResizeAndRotateProducer.TRANSCODING_RESULT, String.valueOf(imageTranscodeResult));
                return ImmutableMap.copyOf((Map) hashMap);
            }
            return null;
        }

        @Nullable
        private EncodedImage getNewResultForImagesWithoutExifData(EncodedImage encodedImage) {
            RotationOptions rotationOptions = this.mProducerContext.getImageRequest().getRotationOptions();
            return (rotationOptions.useImageMetadata() || !rotationOptions.rotationEnabled()) ? encodedImage : getCloneWithRotationApplied(encodedImage, rotationOptions.getForcedAngle());
        }

        @Nullable
        private EncodedImage getNewResultsForJpegOrHeif(EncodedImage encodedImage) {
            return (this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered() || encodedImage.getRotationAngle() == 0 || encodedImage.getRotationAngle() == -1) ? encodedImage : getCloneWithRotationApplied(encodedImage, 0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i) {
            if (this.mIsCancelled) {
                return;
            }
            boolean isLast = BaseConsumer.isLast(i);
            if (encodedImage == null) {
                if (isLast) {
                    getConsumer().onNewResult(null, 1);
                    return;
                }
                return;
            }
            ImageFormat imageFormat = encodedImage.getImageFormat();
            TriState shouldTransform = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage, (ImageTranscoder) Preconditions.checkNotNull(this.mImageTranscoderFactory.createImageTranscoder(imageFormat, this.mIsResizingEnabled)));
            if (isLast || shouldTransform != TriState.UNSET) {
                if (shouldTransform != TriState.YES) {
                    forwardNewResult(encodedImage, i, imageFormat);
                } else if (this.mJobScheduler.updateJob(encodedImage, i)) {
                    if (isLast || this.mProducerContext.isIntermediateResultExpected()) {
                        this.mJobScheduler.scheduleJob();
                    }
                }
            }
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mImageTranscoderFactory = (ImageTranscoderFactory) Preconditions.checkNotNull(imageTranscoderFactory);
        this.mIsResizingEnabled = z;
    }

    public static boolean shouldRotate(RotationOptions rotationOptions, EncodedImage encodedImage) {
        return !rotationOptions.canDeferUntilRendered() && (JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage) != 0 || shouldRotateUsingExifOrientation(rotationOptions, encodedImage));
    }

    public static boolean shouldRotateUsingExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (rotationOptions.rotationEnabled() && !rotationOptions.canDeferUntilRendered()) {
            return JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()));
        }
        encodedImage.setExifOrientation(0);
        return false;
    }

    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage, ImageTranscoder imageTranscoder) {
        if (encodedImage != null && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
            if (!imageTranscoder.canTranscode(encodedImage.getImageFormat())) {
                return TriState.NO;
            }
            return TriState.valueOf(shouldRotate(imageRequest.getRotationOptions(), encodedImage) || imageTranscoder.canResize(encodedImage, imageRequest.getRotationOptions(), imageRequest.getResizeOptions()));
        }
        return TriState.UNSET;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new TransformingConsumer(consumer, producerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory), producerContext);
    }
}
