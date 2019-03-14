package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e jGv;
    private final e jGw;
    private final f jGx;

    public z(e eVar, e eVar2, f fVar) {
        this.jGv = eVar;
        this.jGw = eVar2;
        this.jGx = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.jGx.c(imageRequest, obj);
        return imageRequest.cAt() == ImageRequest.CacheChoice.SMALL ? this.jGw.a(c, atomicBoolean) : this.jGv.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.jGx.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.jGw.a(c, dVar);
        } else {
            this.jGv.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cAt() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cAt();
    }
}
