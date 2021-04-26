package com.facebook.imagepipeline.producers;

import android.net.Uri;
import c.d;
import c.e;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class PartialDiskCacheProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "PartialDiskCacheProducer";
    public final ByteArrayPool mByteArrayPool;
    public final CacheKeyFactory mCacheKeyFactory;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final Producer<EncodedImage> mInputProducer;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: classes6.dex */
    public static class PartialDiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public static final int READ_SIZE = 16384;
        public final ByteArrayPool mByteArrayPool;
        public final BufferedDiskCache mDefaultBufferedDiskCache;
        @Nullable
        public final EncodedImage mPartialEncodedImageFromCache;
        public final CacheKey mPartialImageCacheKey;
        public final PooledByteBufferFactory mPooledByteBufferFactory;

        private void copy(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
            byte[] bArr = this.mByteArrayPool.get(16384);
            int i3 = i2;
            while (i3 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i3));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i3 -= read;
                    }
                } finally {
                    this.mByteArrayPool.release(bArr);
                }
            }
            if (i3 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
        }

        private PooledByteBufferOutputStream merge(EncodedImage encodedImage, EncodedImage encodedImage2) throws IOException {
            PooledByteBufferOutputStream newOutputStream = this.mPooledByteBufferFactory.newOutputStream(encodedImage2.getSize() + encodedImage2.getBytesRange().from);
            copy(encodedImage.getInputStream(), newOutputStream, encodedImage2.getBytesRange().from);
            copy(encodedImage2.getInputStream(), newOutputStream, encodedImage2.getSize());
            return newOutputStream;
        }

        private void sendFinalResultToConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream) {
            EncodedImage encodedImage;
            Throwable th;
            CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
            try {
                encodedImage = new EncodedImage(of);
                try {
                    encodedImage.parseMetaData();
                    getConsumer().onNewResult(encodedImage, 1);
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                } catch (Throwable th2) {
                    th = th2;
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                    throw th;
                }
            } catch (Throwable th3) {
                encodedImage = null;
                th = th3;
            }
        }

        public PartialDiskCacheConsumer(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, @Nullable EncodedImage encodedImage) {
            super(consumer);
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mPartialImageCacheKey = cacheKey;
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
            this.mByteArrayPool = byteArrayPool;
            this.mPartialEncodedImageFromCache = encodedImage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            if (BaseConsumer.isNotLast(i2)) {
                return;
            }
            if (this.mPartialEncodedImageFromCache != null) {
                try {
                    if (encodedImage.getBytesRange() != null) {
                        try {
                            sendFinalResultToConsumer(merge(this.mPartialEncodedImageFromCache, encodedImage));
                        } catch (IOException e2) {
                            FLog.e(PartialDiskCacheProducer.PRODUCER_NAME, "Error while merging image data", e2);
                            getConsumer().onFailure(e2);
                        }
                        this.mDefaultBufferedDiskCache.remove(this.mPartialImageCacheKey);
                        return;
                    }
                } finally {
                    encodedImage.close();
                    this.mPartialEncodedImageFromCache.close();
                }
            }
            if (BaseConsumer.statusHasFlag(i2, 8) && BaseConsumer.isLast(i2) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                this.mDefaultBufferedDiskCache.put(this.mPartialImageCacheKey, encodedImage);
                getConsumer().onNewResult(encodedImage, i2);
                return;
            }
            getConsumer().onNewResult(encodedImage, i2);
        }
    }

    public PartialDiskCacheProducer(BufferedDiskCache bufferedDiskCache, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mInputProducer = producer;
    }

    public static Uri createUriForPartialCacheKey(ImageRequest imageRequest) {
        return imageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    @VisibleForTesting
    @Nullable
    public static Map<String, String> getExtraMap(ProducerListener producerListener, String str, boolean z, int i2) {
        if (producerListener.requiresExtraMap(str)) {
            if (z) {
                return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i2));
            }
            return ImmutableMap.of("cached_value_found", String.valueOf(z));
        }
        return null;
    }

    public static boolean isTaskCancelled(e<?> eVar) {
        return eVar.p() || (eVar.r() && (eVar.m() instanceof CancellationException));
    }

    private d<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> consumer, final ProducerContext producerContext, final CacheKey cacheKey) {
        final String id = producerContext.getId();
        final ProducerListener listener = producerContext.getListener();
        return new d<EncodedImage, Void>() { // from class: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.d
            public Void then(e<EncodedImage> eVar) throws Exception {
                if (PartialDiskCacheProducer.isTaskCancelled(eVar)) {
                    listener.onProducerFinishWithCancellation(id, PartialDiskCacheProducer.PRODUCER_NAME, null);
                    consumer.onCancellation();
                } else if (eVar.r()) {
                    listener.onProducerFinishWithFailure(id, PartialDiskCacheProducer.PRODUCER_NAME, eVar.m(), null);
                    PartialDiskCacheProducer.this.startInputProducer(consumer, producerContext, cacheKey, null);
                } else {
                    EncodedImage n = eVar.n();
                    if (n != null) {
                        ProducerListener producerListener = listener;
                        String str = id;
                        producerListener.onProducerFinishWithSuccess(str, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(producerListener, str, true, n.getSize()));
                        BytesRange max = BytesRange.toMax(n.getSize() - 1);
                        n.setBytesRange(max);
                        int size = n.getSize();
                        ImageRequest imageRequest = producerContext.getImageRequest();
                        if (max.contains(imageRequest.getBytesRange())) {
                            listener.onUltimateProducerReached(id, PartialDiskCacheProducer.PRODUCER_NAME, true);
                            consumer.onNewResult(n, 9);
                        } else {
                            consumer.onNewResult(n, 8);
                            PartialDiskCacheProducer.this.startInputProducer(consumer, new SettableProducerContext(ImageRequestBuilder.fromRequest(imageRequest).setBytesRange(BytesRange.from(size - 1)).build(), producerContext), cacheKey, n);
                        }
                    } else {
                        ProducerListener producerListener2 = listener;
                        String str2 = id;
                        producerListener2.onProducerFinishWithSuccess(str2, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(producerListener2, str2, false, 0));
                        PartialDiskCacheProducer.this.startInputProducer(consumer, producerContext, cacheKey, n);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey, @Nullable EncodedImage encodedImage) {
        this.mInputProducer.produceResults(new PartialDiskCacheConsumer(consumer, this.mDefaultBufferedDiskCache, cacheKey, this.mPooledByteBufferFactory, this.mByteArrayPool, encodedImage), producerContext);
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!imageRequest.isDiskCacheEnabled()) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        producerContext.getListener().onProducerStart(producerContext.getId(), PRODUCER_NAME);
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, createUriForPartialCacheKey(imageRequest), producerContext.getCallerContext());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mDefaultBufferedDiskCache.get(encodedCacheKey, atomicBoolean).g(onFinishDiskReads(consumer, producerContext, encodedCacheKey));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }
}
