package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e iqE;
    private final e iqF;
    private final f iqG;

    public z(e eVar, e eVar2, f fVar) {
        this.iqE = eVar;
        this.iqF = eVar2;
        this.iqG = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.iqG.c(imageRequest, obj);
        return imageRequest.cbb() == ImageRequest.CacheChoice.SMALL ? this.iqF.a(c, atomicBoolean) : this.iqE.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.iqG.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.iqF.a(c, dVar);
        } else {
            this.iqE.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cbb() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cbb();
    }
}
