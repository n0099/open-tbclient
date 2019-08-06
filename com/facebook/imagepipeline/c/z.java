package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e kgT;
    private final e kgU;
    private final f kgV;

    public z(e eVar, e eVar2, f fVar) {
        this.kgT = eVar;
        this.kgU = eVar2;
        this.kgV = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.kgV.c(imageRequest, obj);
        return imageRequest.cLI() == ImageRequest.CacheChoice.SMALL ? this.kgU.a(c, atomicBoolean) : this.kgT.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.kgV.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.kgU.a(c, dVar);
        } else {
            this.kgT.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cLI() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cLI();
    }
}
