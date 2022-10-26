package com.facebook.imagepipeline.producers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
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
/* loaded from: classes7.dex */
public class ResizeAndRotateProducer implements Producer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INPUT_IMAGE_FORMAT = "Image format";
    public static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    public static final String ORIGINAL_SIZE_KEY = "Original size";
    public static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    public static final String REQUESTED_SIZE_KEY = "Requested size";
    public static final String TRANSCODER_ID = "Transcoder id";
    public static final String TRANSCODING_RESULT = "Transcoding result";
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor mExecutor;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    public final Producer mInputProducer;
    public final boolean mIsResizingEnabled;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: classes7.dex */
    public class TransformingConsumer extends DelegatingConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImageTranscoderFactory mImageTranscoderFactory;
        public boolean mIsCancelled;
        public final boolean mIsResizingEnabled;
        public final JobScheduler mJobScheduler;
        public final ProducerContext mProducerContext;
        public final /* synthetic */ ResizeAndRotateProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransformingConsumer(ResizeAndRotateProducer resizeAndRotateProducer, Consumer consumer, ProducerContext producerContext, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resizeAndRotateProducer, consumer, producerContext, Boolean.valueOf(z), imageTranscoderFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = resizeAndRotateProducer;
            this.mIsCancelled = false;
            this.mProducerContext = producerContext;
            Boolean resizingAllowedOverride = producerContext.getImageRequest().getResizingAllowedOverride();
            this.mIsResizingEnabled = resizingAllowedOverride != null ? resizingAllowedOverride.booleanValue() : z;
            this.mImageTranscoderFactory = imageTranscoderFactory;
            this.mJobScheduler = new JobScheduler(resizeAndRotateProducer.mExecutor, new JobScheduler.JobRunnable(this, resizeAndRotateProducer) { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TransformingConsumer this$1;
                public final /* synthetic */ ResizeAndRotateProducer val$this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, resizeAndRotateProducer};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$this$0 = resizeAndRotateProducer;
                }

                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, encodedImage, i3) == null) {
                        TransformingConsumer transformingConsumer = this.this$1;
                        transformingConsumer.doTransform(encodedImage, i3, (ImageTranscoder) Preconditions.checkNotNull(transformingConsumer.mImageTranscoderFactory.createImageTranscoder(encodedImage.getImageFormat(), this.this$1.mIsResizingEnabled)));
                    }
                }
            }, 100);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(this, resizeAndRotateProducer, consumer) { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TransformingConsumer this$1;
                public final /* synthetic */ Consumer val$consumer;
                public final /* synthetic */ ResizeAndRotateProducer val$this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, resizeAndRotateProducer, consumer};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$this$0 = resizeAndRotateProducer;
                    this.val$consumer = consumer;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$1.mJobScheduler.clearJob();
                        this.this$1.mIsCancelled = true;
                        this.val$consumer.onCancellation();
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

        @Nullable
        private EncodedImage getNewResultForImagesWithoutExifData(EncodedImage encodedImage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, encodedImage)) == null) {
                RotationOptions rotationOptions = this.mProducerContext.getImageRequest().getRotationOptions();
                if (!rotationOptions.useImageMetadata() && rotationOptions.rotationEnabled()) {
                    return getCloneWithRotationApplied(encodedImage, rotationOptions.getForcedAngle());
                }
                return encodedImage;
            }
            return (EncodedImage) invokeL.objValue;
        }

        @Nullable
        private EncodedImage getCloneWithRotationApplied(EncodedImage encodedImage, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, this, encodedImage, i)) == null) {
                EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
                if (cloneOrNull != null) {
                    cloneOrNull.setRotationAngle(i);
                }
                return cloneOrNull;
            }
            return (EncodedImage) invokeLI.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doTransform(EncodedImage encodedImage, int i, ImageTranscoder imageTranscoder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65543, this, encodedImage, i, imageTranscoder) == null) {
                this.mProducerContext.getProducerListener().onProducerStart(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME);
                ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                PooledByteBufferOutputStream newOutputStream = this.this$0.mPooledByteBufferFactory.newOutputStream();
                try {
                    ImageTranscodeResult transcode = imageTranscoder.transcode(encodedImage, newOutputStream, imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), null, 85);
                    if (transcode.getTranscodeStatus() != 2) {
                        Map extraMap = getExtraMap(encodedImage, imageRequest.getResizeOptions(), transcode, imageTranscoder.getIdentifier());
                        CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                        try {
                            EncodedImage encodedImage2 = new EncodedImage(of);
                            encodedImage2.setImageFormat(DefaultImageFormats.JPEG);
                            encodedImage2.parseMetaData();
                            this.mProducerContext.getProducerListener().onProducerFinishWithSuccess(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME, extraMap);
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
                } catch (Exception e) {
                    this.mProducerContext.getProducerListener().onProducerFinishWithFailure(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME, e, null);
                    if (BaseConsumer.isLast(i)) {
                        getConsumer().onFailure(e);
                    }
                } finally {
                    newOutputStream.close();
                }
            }
        }

        private void forwardNewResult(EncodedImage encodedImage, int i, ImageFormat imageFormat) {
            EncodedImage newResultsForJpegOrHeif;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65544, this, encodedImage, i, imageFormat) == null) {
                if (imageFormat != DefaultImageFormats.JPEG && imageFormat != DefaultImageFormats.HEIF) {
                    newResultsForJpegOrHeif = getNewResultForImagesWithoutExifData(encodedImage);
                } else {
                    newResultsForJpegOrHeif = getNewResultsForJpegOrHeif(encodedImage);
                }
                getConsumer().onNewResult(newResultsForJpegOrHeif, i);
            }
        }

        @Nullable
        private Map getExtraMap(EncodedImage encodedImage, @Nullable ResizeOptions resizeOptions, @Nullable ImageTranscodeResult imageTranscodeResult, @Nullable String str) {
            InterceptResult invokeLLLL;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, this, encodedImage, resizeOptions, imageTranscodeResult, str)) == null) {
                if (!this.mProducerContext.getProducerListener().requiresExtraMap(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME)) {
                    return null;
                }
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
            return (Map) invokeLLLL.objValue;
        }

        @Nullable
        private EncodedImage getNewResultsForJpegOrHeif(EncodedImage encodedImage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, encodedImage)) == null) {
                if (!this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered() && encodedImage.getRotationAngle() != 0 && encodedImage.getRotationAngle() != -1) {
                    return getCloneWithRotationApplied(encodedImage, 0);
                }
                return encodedImage;
            }
            return (EncodedImage) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, encodedImage, i) != null) || this.mIsCancelled) {
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
            if (!isLast && shouldTransform == TriState.UNSET) {
                return;
            }
            if (shouldTransform != TriState.YES) {
                forwardNewResult(encodedImage, i, imageFormat);
            } else if (!this.mJobScheduler.updateJob(encodedImage, i)) {
            } else {
                if (isLast || this.mProducerContext.isIntermediateResultExpected()) {
                    this.mJobScheduler.scheduleJob();
                }
            }
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer producer, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, pooledByteBufferFactory, producer, Boolean.valueOf(z), imageTranscoderFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mImageTranscoderFactory = (ImageTranscoderFactory) Preconditions.checkNotNull(imageTranscoderFactory);
        this.mIsResizingEnabled = z;
    }

    public static boolean shouldRotate(RotationOptions rotationOptions, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, rotationOptions, encodedImage)) == null) {
            if (!rotationOptions.canDeferUntilRendered() && (JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage) != 0 || shouldRotateUsingExifOrientation(rotationOptions, encodedImage))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            this.mInputProducer.produceResults(new TransformingConsumer(this, consumer, producerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory), producerContext);
        }
    }

    public static boolean shouldRotateUsingExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, rotationOptions, encodedImage)) == null) {
            if (rotationOptions.rotationEnabled() && !rotationOptions.canDeferUntilRendered()) {
                return JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()));
            }
            encodedImage.setExifOrientation(0);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage, ImageTranscoder imageTranscoder) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, imageRequest, encodedImage, imageTranscoder)) == null) {
            if (encodedImage != null && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                if (!imageTranscoder.canTranscode(encodedImage.getImageFormat())) {
                    return TriState.NO;
                }
                if (!shouldRotate(imageRequest.getRotationOptions(), encodedImage) && !imageTranscoder.canResize(encodedImage, imageRequest.getRotationOptions(), imageRequest.getResizeOptions())) {
                    z = false;
                } else {
                    z = true;
                }
                return TriState.valueOf(z);
            }
            return TriState.UNSET;
        }
        return (TriState) invokeLLL.objValue;
    }
}
