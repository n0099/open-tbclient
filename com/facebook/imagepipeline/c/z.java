package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e jGD;
    private final e jGE;
    private final f jGF;

    public z(e eVar, e eVar2, f fVar) {
        this.jGD = eVar;
        this.jGE = eVar2;
        this.jGF = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.jGF.c(imageRequest, obj);
        return imageRequest.cAq() == ImageRequest.CacheChoice.SMALL ? this.jGE.a(c, atomicBoolean) : this.jGD.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.jGF.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.jGE.a(c, dVar);
        } else {
            this.jGD.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cAq() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cAq();
    }
}
