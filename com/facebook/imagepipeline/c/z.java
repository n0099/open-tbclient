package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e jFP;
    private final e jFQ;
    private final f jFR;

    public z(e eVar, e eVar2, f fVar) {
        this.jFP = eVar;
        this.jFQ = eVar2;
        this.jFR = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.jFR.c(imageRequest, obj);
        return imageRequest.cAm() == ImageRequest.CacheChoice.SMALL ? this.jFQ.a(c, atomicBoolean) : this.jFP.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.jFR.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.jFQ.a(c, dVar);
        } else {
            this.jFP.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cAm() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cAm();
    }
}
