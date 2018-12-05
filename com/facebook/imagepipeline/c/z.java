package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e iml;
    private final e imm;
    private final f imn;

    public z(e eVar, e eVar2, f fVar) {
        this.iml = eVar;
        this.imm = eVar2;
        this.imn = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.imn.c(imageRequest, obj);
        return imageRequest.bZD() == ImageRequest.CacheChoice.SMALL ? this.imm.a(c, atomicBoolean) : this.iml.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.imn.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.imm.a(c, dVar);
        } else {
            this.iml.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.bZD() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.bZD();
    }
}
