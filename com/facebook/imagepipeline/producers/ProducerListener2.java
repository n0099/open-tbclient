package com.facebook.imagepipeline.producers;

import androidx.annotation.NonNull;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public interface ProducerListener2 {
    void onDecoderFinishWithFailure(ImageRequest imageRequest, EncodedImage encodedImage, Throwable th, @Nullable Map<String, String> map);

    void onProducerEvent(@NonNull ProducerContext producerContext, @NonNull String str, @NonNull String str2);

    void onProducerFinishWithCancellation(@NonNull ProducerContext producerContext, @NonNull String str, @Nullable Map<String, String> map);

    void onProducerFinishWithFailure(@NonNull ProducerContext producerContext, String str, Throwable th, @Nullable Map<String, String> map);

    void onProducerFinishWithSuccess(@NonNull ProducerContext producerContext, @NonNull String str, @Nullable Map<String, String> map);

    void onProducerStart(@NonNull ProducerContext producerContext, @NonNull String str);

    void onUltimateProducerReached(@NonNull ProducerContext producerContext, @NonNull String str, boolean z);

    boolean requiresExtraMap(@NonNull ProducerContext producerContext, @NonNull String str);
}
