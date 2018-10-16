package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public interface l {
    bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean);

    ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar);

    void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj);
}
