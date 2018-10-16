package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e idn;
    private final e ido;
    private final f idp;

    public z(e eVar, e eVar2, f fVar) {
        this.idn = eVar;
        this.ido = eVar2;
        this.idp = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.idp.c(imageRequest, obj);
        return imageRequest.bYc() == ImageRequest.CacheChoice.SMALL ? this.ido.a(c, atomicBoolean) : this.idn.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.idp.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.ido.a(c, dVar);
        } else {
            this.idn.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.bYc() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.bYc();
    }
}
