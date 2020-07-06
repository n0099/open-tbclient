package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class ap extends d {
    public ap(ImageRequest imageRequest, ak akVar) {
        this(imageRequest, akVar.getId(), akVar.dGd(), akVar.dAH(), akVar.dGe(), akVar.dGf(), akVar.dGh(), akVar.dGg());
    }

    public ap(ImageRequest imageRequest, String str, am amVar, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        super(imageRequest, str, amVar, obj, requestLevel, z, z2, priority);
    }
}
