package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e kfN;
    private final e kfO;
    private final f kfP;

    public z(e eVar, e eVar2, f fVar) {
        this.kfN = eVar;
        this.kfO = eVar2;
        this.kfP = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.kfP.c(imageRequest, obj);
        return imageRequest.cLn() == ImageRequest.CacheChoice.SMALL ? this.kfO.a(c, atomicBoolean) : this.kfN.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.kfP.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.kfO.a(c, dVar);
        } else {
            this.kfN.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cLn() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cLn();
    }
}
