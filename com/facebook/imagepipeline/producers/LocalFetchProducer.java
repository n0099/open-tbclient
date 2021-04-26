package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    public final Executor mExecutor;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public EncodedImage getByteBufferBackedEncodedImage(InputStream inputStream, int i2) throws IOException {
        CloseableReference of;
        CloseableReference closeableReference = null;
        try {
            if (i2 <= 0) {
                of = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream));
            } else {
                of = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream, i2));
            }
            closeableReference = of;
            return new EncodedImage(closeableReference);
        } finally {
            Closeables.closeQuietly(inputStream);
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public abstract EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException;

    public EncodedImage getEncodedImage(InputStream inputStream, int i2) throws IOException {
        return getByteBufferBackedEncodedImage(inputStream, i2);
    }

    public abstract String getProducerName();

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final StatefulProducerRunnable<EncodedImage> statefulProducerRunnable = new StatefulProducerRunnable<EncodedImage>(consumer, listener, getProducerName(), id) { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(EncodedImage encodedImage) {
                EncodedImage.closeSafely(encodedImage);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.executors.StatefulRunnable
            @Nullable
            public EncodedImage getResult() throws Exception {
                EncodedImage encodedImage = LocalFetchProducer.this.getEncodedImage(imageRequest);
                if (encodedImage == null) {
                    listener.onUltimateProducerReached(id, LocalFetchProducer.this.getProducerName(), false);
                    return null;
                }
                encodedImage.parseMetaData();
                listener.onUltimateProducerReached(id, LocalFetchProducer.this.getProducerName(), true);
                return encodedImage;
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }
}
