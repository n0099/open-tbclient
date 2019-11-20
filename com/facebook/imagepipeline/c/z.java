package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e kgL;
    private final e kgM;
    private final f kgN;

    public z(e eVar, e eVar2, f fVar) {
        this.kgL = eVar;
        this.kgM = eVar2;
        this.kgN = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.kgN.c(imageRequest, obj);
        return imageRequest.cJr() == ImageRequest.CacheChoice.SMALL ? this.kgM.a(c, atomicBoolean) : this.kgL.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.kgN.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.kgM.a(c, dVar);
        } else {
            this.kgL.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cJr() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cJr();
    }
}
