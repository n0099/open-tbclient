package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes10.dex */
public class ap extends d {
    public ap(ImageRequest imageRequest, ak akVar) {
        this(imageRequest, akVar.getId(), akVar.dqk(), akVar.dkQ(), akVar.dql(), akVar.dqm(), akVar.dqo(), akVar.dqn());
    }

    public ap(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        super(imageRequest, str, amVar, obj, requestLevel, z, z2, priority);
    }
}
