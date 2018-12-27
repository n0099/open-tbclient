package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e ipw;
    private final e ipx;
    private final f ipy;

    public z(e eVar, e eVar2, f fVar) {
        this.ipw = eVar;
        this.ipx = eVar2;
        this.ipy = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.ipy.c(imageRequest, obj);
        return imageRequest.cat() == ImageRequest.CacheChoice.SMALL ? this.ipx.a(c, atomicBoolean) : this.ipw.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.ipy.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.ipx.a(c, dVar);
        } else {
            this.ipw.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cat() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cat();
    }
}
