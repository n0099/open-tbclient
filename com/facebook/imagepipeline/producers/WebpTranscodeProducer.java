package com.facebook.imagepipeline.producers;

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
/* loaded from: classes6.dex */
public class WebpTranscodeProducer implements Producer<EncodedImage> {
    public static final int DEFAULT_JPEG_QUALITY = 80;
    public static final String PRODUCER_NAME = "WebpTranscodeProducer";
    public final Executor mExecutor;
    public final Producer<EncodedImage> mInputProducer;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: classes6.dex */
    public class WebpTranscodeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ProducerContext mContext;
        public TriState mShouldTranscodeWhenFinished;

        public WebpTranscodeConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.mContext = producerContext;
            this.mShouldTranscodeWhenFinished = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i) {
            if (this.mShouldTranscodeWhenFinished == TriState.UNSET && encodedImage != null) {
                this.mShouldTranscodeWhenFinished = WebpTranscodeProducer.shouldTranscode(encodedImage);
            }
            if (this.mShouldTranscodeWhenFinished == TriState.NO) {
                getConsumer().onNewResult(encodedImage, i);
            } else if (BaseConsumer.isLast(i)) {
                if (this.mShouldTranscodeWhenFinished == TriState.YES && encodedImage != null) {
                    WebpTranscodeProducer.this.transcodeLastResult(encodedImage, getConsumer(), this.mContext);
                } else {
                    getConsumer().onNewResult(encodedImage, i);
                }
            }
        }
    }

    public WebpTranscodeProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    public static void doTranscode(EncodedImage encodedImage, PooledByteBufferOutputStream pooledByteBufferOutputStream) throws Exception {
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

    public static TriState shouldTranscode(EncodedImage encodedImage) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void transcodeLastResult(EncodedImage encodedImage, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Preconditions.checkNotNull(encodedImage);
        final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
        this.mExecutor.execute(new StatefulProducerRunnable<EncodedImage>(consumer, producerContext.getListener(), PRODUCER_NAME, producerContext.getId()) { // from class: com.facebook.imagepipeline.producers.WebpTranscodeProducer.1
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onCancellation() {
                EncodedImage.closeSafely(cloneOrNull);
                super.onCancellation();
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onFailure(Exception exc) {
                EncodedImage.closeSafely(cloneOrNull);
                super.onFailure(exc);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(EncodedImage encodedImage2) {
                EncodedImage.closeSafely(encodedImage2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.executors.StatefulRunnable
            public EncodedImage getResult() throws Exception {
                PooledByteBufferOutputStream newOutputStream = WebpTranscodeProducer.this.mPooledByteBufferFactory.newOutputStream();
                try {
                    WebpTranscodeProducer.doTranscode(cloneOrNull, newOutputStream);
                    CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                    EncodedImage encodedImage2 = new EncodedImage(of);
                    encodedImage2.copyMetaDataFrom(cloneOrNull);
                    CloseableReference.closeSafely(of);
                    return encodedImage2;
                } finally {
                    newOutputStream.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(EncodedImage encodedImage2) {
                EncodedImage.closeSafely(cloneOrNull);
                super.onSuccess((AnonymousClass1) encodedImage2);
            }
        });
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new WebpTranscodeConsumer(consumer, producerContext), producerContext);
    }
}
