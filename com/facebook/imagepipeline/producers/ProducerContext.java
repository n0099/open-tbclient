package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes.dex */
public interface ProducerContext {
    void addCallbacks(ProducerContextCallbacks producerContextCallbacks);

    Object getCallerContext();

    String getId();

    ImageRequest getImageRequest();

    ProducerListener getListener();

    ImageRequest.RequestLevel getLowestPermittedRequestLevel();

    Priority getPriority();

    boolean isIntermediateResultExpected();

    boolean isPrefetch();
}
