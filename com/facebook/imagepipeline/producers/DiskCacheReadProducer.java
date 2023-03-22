package com.facebook.imagepipeline.producers;

import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "DiskCacheProducer";
    public final CacheKeyFactory mCacheKeyFactory;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final Producer<EncodedImage> mInputProducer;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
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

    public static boolean isTaskCancelled(s<?> sVar) {
        if (!sVar.n() && (!sVar.p() || !(sVar.k() instanceof CancellationException))) {
            return false;
        }
        return true;
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_read");
            consumer.onNewResult(null, 1);
            return;
        }
        this.mInputProducer.produceResults(consumer, producerContext);
    }

    private r<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        return new r<EncodedImage, Void>() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.r
            public Void then(s<EncodedImage> sVar) throws Exception {
                if (DiskCacheReadProducer.isTaskCancelled(sVar)) {
                    producerListener.onProducerFinishWithCancellation(producerContext, DiskCacheReadProducer.PRODUCER_NAME, null);
                    consumer.onCancellation();
                } else if (sVar.p()) {
                    producerListener.onProducerFinishWithFailure(producerContext, DiskCacheReadProducer.PRODUCER_NAME, sVar.k(), null);
                    DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                } else {
                    EncodedImage l = sVar.l();
                    if (l != null) {
                        ProducerListener2 producerListener2 = producerListener;
                        ProducerContext producerContext2 = producerContext;
                        producerListener2.onProducerFinishWithSuccess(producerContext2, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(producerListener2, producerContext2, true, l.getSize()));
                        producerListener.onUltimateProducerReached(producerContext, DiskCacheReadProducer.PRODUCER_NAME, true);
                        producerContext.putOriginExtra("disk");
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(l, 1);
                        l.close();
                    } else {
                        ProducerListener2 producerListener22 = producerListener;
                        ProducerContext producerContext3 = producerContext;
                        producerListener22.onProducerFinishWithSuccess(producerContext3, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(producerListener22, producerContext3, false, 0));
                        DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                    }
                }
                return null;
            }
        };
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        boolean z;
        BufferedDiskCache bufferedDiskCache;
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!imageRequest.isDiskCacheEnabled()) {
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
        if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            bufferedDiskCache = this.mSmallImageBufferedDiskCache;
        } else {
            bufferedDiskCache = this.mDefaultBufferedDiskCache;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCache.get(encodedCacheKey, atomicBoolean).e(onFinishDiskReads(consumer, producerContext));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }
}
