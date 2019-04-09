package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e jFQ;
    private final e jFR;
    private final f jFS;

    public z(e eVar, e eVar2, f fVar) {
        this.jFQ = eVar;
        this.jFR = eVar2;
        this.jFS = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.jFS.c(imageRequest, obj);
        return imageRequest.cAm() == ImageRequest.CacheChoice.SMALL ? this.jFR.a(c, atomicBoolean) : this.jFQ.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.jFS.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.jFR.a(c, dVar);
        } else {
            this.jFQ.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cAm() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cAm();
    }
}
