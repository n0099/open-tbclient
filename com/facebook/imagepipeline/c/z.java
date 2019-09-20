package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e kjr;
    private final e kjs;
    private final f kjt;

    public z(e eVar, e eVar2, f fVar) {
        this.kjr = eVar;
        this.kjs = eVar2;
        this.kjt = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.kjt.c(imageRequest, obj);
        return imageRequest.cMw() == ImageRequest.CacheChoice.SMALL ? this.kjs.a(c, atomicBoolean) : this.kjr.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.kjt.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.kjs.a(c, dVar);
        } else {
            this.kjr.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cMw() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cMw();
    }
}
