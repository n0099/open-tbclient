package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.WebpTranscoder;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class WebpTranscodeProducer implements Producer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_JPEG_QUALITY = 80;
    public static final String PRODUCER_NAME = "WebpTranscodeProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor mExecutor;
    public final Producer<EncodedImage> mInputProducer;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: classes11.dex */
    public class WebpTranscodeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ProducerContext mContext;
        public TriState mShouldTranscodeWhenFinished;
        public final /* synthetic */ WebpTranscodeProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebpTranscodeConsumer(WebpTranscodeProducer webpTranscodeProducer, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webpTranscodeProducer, consumer, producerContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webpTranscodeProducer;
            this.mContext = producerContext;
            this.mShouldTranscodeWhenFinished = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, encodedImage, i2) == null) {
                if (this.mShouldTranscodeWhenFinished == TriState.UNSET && encodedImage != null) {
                    this.mShouldTranscodeWhenFinished = WebpTranscodeProducer.shouldTranscode(encodedImage);
                }
                if (this.mShouldTranscodeWhenFinished == TriState.NO) {
                    getConsumer().onNewResult(encodedImage, i2);
                } else if (BaseConsumer.isLast(i2)) {
                    if (this.mShouldTranscodeWhenFinished == TriState.YES && encodedImage != null) {
                        this.this$0.transcodeLastResult(encodedImage, getConsumer(), this.mContext);
                    } else {
                        getConsumer().onNewResult(encodedImage, i2);
                    }
                }
            }
        }
    }

    public WebpTranscodeProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, pooledByteBufferFactory, producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    public static void doTranscode(EncodedImage encodedImage, PooledByteBufferOutputStream pooledByteBufferOutputStream) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, encodedImage, pooledByteBufferOutputStream) == null) {
            InputStream inputStream = encodedImage.getInputStream();
            ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(inputStream);
            if (imageFormat_WrapIOException != DefaultImageFormats.WEBP_SIMPLE && imageFormat_WrapIOException != DefaultImageFormats.WEBP_EXTENDED) {
                if (imageFormat_WrapIOException != DefaultImageFormats.WEBP_LOSSLESS && imageFormat_WrapIOException != DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) {
                    throw new IllegalArgumentException("Wrong image format");
                }
                WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToPng(inputStream, pooledByteBufferOutputStream);
                encodedImage.setImageFormat(DefaultImageFormats.PNG);
                return;
            }
            WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToJpeg(inputStream, pooledByteBufferOutputStream, 80);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
        }
    }

    public static TriState shouldTranscode(EncodedImage encodedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, encodedImage)) == null) {
            Preconditions.checkNotNull(encodedImage);
            ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            if (DefaultImageFormats.isStaticWebpFormat(imageFormat_WrapIOException)) {
                WebpTranscoder webpTranscoder = WebpTranscoderFactory.getWebpTranscoder();
                if (webpTranscoder == null) {
                    return TriState.NO;
                }
                return TriState.valueOf(!webpTranscoder.isWebpNativelySupported(imageFormat_WrapIOException));
            } else if (imageFormat_WrapIOException == ImageFormat.UNKNOWN) {
                return TriState.UNSET;
            } else {
                return TriState.NO;
            }
        }
        return (TriState) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transcodeLastResult(EncodedImage encodedImage, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, encodedImage, consumer, producerContext) == null) {
            Preconditions.checkNotNull(encodedImage);
            this.mExecutor.execute(new StatefulProducerRunnable<EncodedImage>(this, consumer, producerContext.getListener(), PRODUCER_NAME, producerContext.getId(), EncodedImage.cloneOrNull(encodedImage)) { // from class: com.facebook.imagepipeline.producers.WebpTranscodeProducer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebpTranscodeProducer this$0;
                public final /* synthetic */ EncodedImage val$encodedImageCopy;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(consumer, r12, r13, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, consumer, r12, r13, r14, r15};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Consumer) objArr2[0], (ProducerListener) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$encodedImageCopy = r15;
                }

                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void onCancellation() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        EncodedImage.closeSafely(this.val$encodedImageCopy);
                        super.onCancellation();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void onFailure(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, exc) == null) {
                        EncodedImage.closeSafely(this.val$encodedImageCopy);
                        super.onFailure(exc);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void disposeResult(EncodedImage encodedImage2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, encodedImage2) == null) {
                        EncodedImage.closeSafely(encodedImage2);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.executors.StatefulRunnable
                public EncodedImage getResult() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        PooledByteBufferOutputStream newOutputStream = this.this$0.mPooledByteBufferFactory.newOutputStream();
                        try {
                            WebpTranscodeProducer.doTranscode(this.val$encodedImageCopy, newOutputStream);
                            CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                            EncodedImage encodedImage2 = new EncodedImage(of);
                            encodedImage2.copyMetaDataFrom(this.val$encodedImageCopy);
                            CloseableReference.closeSafely(of);
                            return encodedImage2;
                        } finally {
                            newOutputStream.close();
                        }
                    }
                    return (EncodedImage) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void onSuccess(EncodedImage encodedImage2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, encodedImage2) == null) {
                        EncodedImage.closeSafely(this.val$encodedImageCopy);
                        super.onSuccess((AnonymousClass1) encodedImage2);
                    }
                }
            });
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            this.mInputProducer.produceResults(new WebpTranscodeConsumer(this, consumer, producerContext), producerContext);
        }
    }
}
