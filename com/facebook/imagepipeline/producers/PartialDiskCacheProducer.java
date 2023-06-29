package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
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
/* loaded from: classes9.dex */
public class PartialDiskCacheProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "PartialDiskCacheProducer";
    public final ByteArrayPool mByteArrayPool;
    public final CacheKeyFactory mCacheKeyFactory;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final Producer<EncodedImage> mInputProducer;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: classes9.dex */
    public static class PartialDiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public static final int READ_SIZE = 16384;
        public final ByteArrayPool mByteArrayPool;
        public final BufferedDiskCache mDefaultBufferedDiskCache;
        @Nullable
        public final EncodedImage mPartialEncodedImageFromCache;
        public final CacheKey mPartialImageCacheKey;
        public final PooledByteBufferFactory mPooledByteBufferFactory;

        public PartialDiskCacheConsumer(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, @Nullable EncodedImage encodedImage) {
            super(consumer);
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mPartialImageCacheKey = cacheKey;
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
            this.mByteArrayPool = byteArrayPool;
            this.mPartialEncodedImageFromCache = encodedImage;
        }

        private void copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.mByteArrayPool.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i2));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i2 -= read;
                    }
                } finally {
                    this.mByteArrayPool.release(bArr);
                }
            }
            if (i2 <= 0) {
                return;
            }
            throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (BaseConsumer.isNotLast(i)) {
                return;
            }
            if (this.mPartialEncodedImageFromCache != null) {
                try {
                    if (encodedImage.getBytesRange() != null) {
                        try {
                            sendFinalResultToConsumer(merge(this.mPartialEncodedImageFromCache, encodedImage));
                        } catch (IOException e) {
                            FLog.e(PartialDiskCacheProducer.PRODUCER_NAME, "Error while merging image data", e);
                            getConsumer().onFailure(e);
                        }
                        this.mDefaultBufferedDiskCache.remove(this.mPartialImageCacheKey);
                        return;
                    }
                } finally {
                    encodedImage.close();
                    this.mPartialEncodedImageFromCache.close();
                }
            }
            if (BaseConsumer.statusHasFlag(i, 8) && BaseConsumer.isLast(i) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                this.mDefaultBufferedDiskCache.put(this.mPartialImageCacheKey, encodedImage);
                getConsumer().onNewResult(encodedImage, i);
                return;
            }
            getConsumer().onNewResult(encodedImage, i);
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
        return imageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", YYOption.IsLive.VALUE_TRUE).build();
    }

    public static boolean isTaskCancelled(t<?> tVar) {
        if (!tVar.n() && (!tVar.p() || !(tVar.k() instanceof CancellationException))) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    @Nullable
    public static Map<String, String> getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z, int i) {
        if (!producerListener2.requiresExtraMap(producerContext, PRODUCER_NAME)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey, @Nullable EncodedImage encodedImage) {
        this.mInputProducer.produceResults(new PartialDiskCacheConsumer(consumer, this.mDefaultBufferedDiskCache, cacheKey, this.mPooledByteBufferFactory, this.mByteArrayPool, encodedImage), producerContext);
    }

    private s<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> consumer, final ProducerContext producerContext, final CacheKey cacheKey) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        return new s<EncodedImage, Void>() { // from class: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.s
            public Void then(t<EncodedImage> tVar) throws Exception {
                if (PartialDiskCacheProducer.isTaskCancelled(tVar)) {
                    producerListener.onProducerFinishWithCancellation(producerContext, PartialDiskCacheProducer.PRODUCER_NAME, null);
                    consumer.onCancellation();
                } else if (tVar.p()) {
                    producerListener.onProducerFinishWithFailure(producerContext, PartialDiskCacheProducer.PRODUCER_NAME, tVar.k(), null);
                    PartialDiskCacheProducer.this.startInputProducer(consumer, producerContext, cacheKey, null);
                } else {
                    EncodedImage l = tVar.l();
                    if (l != null) {
                        ProducerListener2 producerListener2 = producerListener;
                        ProducerContext producerContext2 = producerContext;
                        producerListener2.onProducerFinishWithSuccess(producerContext2, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(producerListener2, producerContext2, true, l.getSize()));
                        BytesRange max = BytesRange.toMax(l.getSize() - 1);
                        l.setBytesRange(max);
                        int size = l.getSize();
                        ImageRequest imageRequest = producerContext.getImageRequest();
                        if (max.contains(imageRequest.getBytesRange())) {
                            producerContext.putOriginExtra("disk", "partial");
                            producerListener.onUltimateProducerReached(producerContext, PartialDiskCacheProducer.PRODUCER_NAME, true);
                            consumer.onNewResult(l, 9);
                        } else {
                            consumer.onNewResult(l, 8);
                            PartialDiskCacheProducer.this.startInputProducer(consumer, new SettableProducerContext(ImageRequestBuilder.fromRequest(imageRequest).setBytesRange(BytesRange.from(size - 1)).build(), producerContext), cacheKey, l);
                        }
                    } else {
                        ProducerListener2 producerListener22 = producerListener;
                        ProducerContext producerContext3 = producerContext;
                        producerListener22.onProducerFinishWithSuccess(producerContext3, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(producerListener22, producerContext3, false, 0));
                        PartialDiskCacheProducer.this.startInputProducer(consumer, producerContext, cacheKey, l);
                    }
                }
                return null;
            }
        };
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
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, createUriForPartialCacheKey(imageRequest), producerContext.getCallerContext());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mDefaultBufferedDiskCache.get(encodedCacheKey, atomicBoolean).e(onFinishDiskReads(consumer, producerContext, encodedCacheKey));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }
}
