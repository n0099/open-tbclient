package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
/* loaded from: classes6.dex */
public class ThumbnailBranchProducer implements Producer<EncodedImage> {
    public final ThumbnailProducer<EncodedImage>[] mThumbnailProducers;

    /* loaded from: classes6.dex */
    public class ThumbnailConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ProducerContext mProducerContext;
        public final int mProducerIndex;
        public final ResizeOptions mResizeOptions;

        public ThumbnailConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, int i2) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mProducerIndex = i2;
            this.mResizeOptions = producerContext.getImageRequest().getResizeOptions();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            if (ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
                return;
            }
            getConsumer().onFailure(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            if (encodedImage != null && (BaseConsumer.isNotLast(i2) || ThumbnailSizeChecker.isImageBigEnough(encodedImage, this.mResizeOptions))) {
                getConsumer().onNewResult(encodedImage, i2);
            } else if (BaseConsumer.isLast(i2)) {
                EncodedImage.closeSafely(encodedImage);
                if (ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
                    return;
                }
                getConsumer().onNewResult(null, 1);
            }
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage>... thumbnailProducerArr) {
        ThumbnailProducer<EncodedImage>[] thumbnailProducerArr2 = (ThumbnailProducer[]) Preconditions.checkNotNull(thumbnailProducerArr);
        this.mThumbnailProducers = thumbnailProducerArr2;
        Preconditions.checkElementIndex(0, thumbnailProducerArr2.length);
    }

    private int findFirstProducerForSize(int i2, ResizeOptions resizeOptions) {
        while (true) {
            ThumbnailProducer<EncodedImage>[] thumbnailProducerArr = this.mThumbnailProducers;
            if (i2 >= thumbnailProducerArr.length) {
                return -1;
            }
            if (thumbnailProducerArr[i2].canProvideImageForSize(resizeOptions)) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean produceResultsFromThumbnailProducer(int i2, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        int findFirstProducerForSize = findFirstProducerForSize(i2, producerContext.getImageRequest().getResizeOptions());
        if (findFirstProducerForSize == -1) {
            return false;
        }
        this.mThumbnailProducers[findFirstProducerForSize].produceResults(new ThumbnailConsumer(consumer, producerContext, findFirstProducerForSize), producerContext);
        return true;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getImageRequest().getResizeOptions() == null) {
            consumer.onNewResult(null, 1);
        } else if (produceResultsFromThumbnailProducer(0, consumer, producerContext)) {
        } else {
            consumer.onNewResult(null, 1);
        }
    }
}
