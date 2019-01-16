package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e iqD;
    private final e iqE;
    private final f iqF;

    public z(e eVar, e eVar2, f fVar) {
        this.iqD = eVar;
        this.iqE = eVar2;
        this.iqF = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.iqF.c(imageRequest, obj);
        return imageRequest.cbb() == ImageRequest.CacheChoice.SMALL ? this.iqE.a(c, atomicBoolean) : this.iqD.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.iqF.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.iqE.a(c, dVar);
        } else {
            this.iqD.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cbb() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cbb();
    }
}
