package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e ifa;
    private final e ifb;
    private final f ifc;

    public z(e eVar, e eVar2, f fVar) {
        this.ifa = eVar;
        this.ifb = eVar2;
        this.ifc = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.ifc.c(imageRequest, obj);
        return imageRequest.bXx() == ImageRequest.CacheChoice.SMALL ? this.ifb.a(c, atomicBoolean) : this.ifa.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.ifc.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.ifb.a(c, dVar);
        } else {
            this.ifa.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.bXx() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.bXx();
    }
}
