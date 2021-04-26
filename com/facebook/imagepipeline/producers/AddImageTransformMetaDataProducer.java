package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
/* loaded from: classes6.dex */
public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {
    public final Producer<EncodedImage> mInputProducer;

    /* loaded from: classes6.dex */
    public static class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public AddImageTransformMetaDataConsumer(Consumer<EncodedImage> consumer) {
            super(consumer);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            if (encodedImage == null) {
                getConsumer().onNewResult(null, i2);
                return;
            }
            if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
                encodedImage.parseMetaData();
            }
            getConsumer().onNewResult(encodedImage, i2);
        }
    }

    public AddImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new AddImageTransformMetaDataConsumer(consumer), producerContext);
    }
}
