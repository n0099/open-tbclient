package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e khC;
    private final e khD;
    private final f khE;

    public z(e eVar, e eVar2, f fVar) {
        this.khC = eVar;
        this.khD = eVar2;
        this.khE = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.khE.c(imageRequest, obj);
        return imageRequest.cJt() == ImageRequest.CacheChoice.SMALL ? this.khD.a(c, atomicBoolean) : this.khC.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.khE.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.khD.a(c, dVar);
        } else {
            this.khC.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cJt() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cJt();
    }
}
