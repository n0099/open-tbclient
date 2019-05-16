package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e jYD;
    private final e jYE;
    private final f jYF;

    public z(e eVar, e eVar2, f fVar) {
        this.jYD = eVar;
        this.jYE = eVar2;
        this.jYF = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.jYF.c(imageRequest, obj);
        return imageRequest.cIi() == ImageRequest.CacheChoice.SMALL ? this.jYE.a(c, atomicBoolean) : this.jYD.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.jYF.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.jYE.a(c, dVar);
        } else {
            this.jYD.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cIi() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cIi();
    }
}
