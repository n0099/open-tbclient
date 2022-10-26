package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface ProducerListener2 {
    void onDecoderFinishWithFailure(ImageRequest imageRequest, EncodedImage encodedImage, Throwable th, @Nullable Map map);

    void onProducerEvent(ProducerContext producerContext, String str, String str2);

    void onProducerFinishWithCancellation(ProducerContext producerContext, String str, @Nullable Map map);

    void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th, @Nullable Map map);

    void onProducerFinishWithSuccess(ProducerContext producerContext, String str, @Nullable Map map);

    void onProducerStart(ProducerContext producerContext, String str);

    void onUltimateProducerReached(ProducerContext producerContext, String str, boolean z);

    boolean requiresExtraMap(ProducerContext producerContext, String str);
}
