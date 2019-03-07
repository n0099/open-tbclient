package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class z implements l {
    private final e jGk;
    private final e jGl;
    private final f jGm;

    public z(e eVar, e eVar2, f fVar) {
        this.jGk = eVar;
        this.jGl = eVar2;
        this.jGm = fVar;
    }

    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, AtomicBoolean atomicBoolean) {
        com.facebook.cache.common.b c = this.jGm.c(imageRequest, obj);
        return imageRequest.cAg() == ImageRequest.CacheChoice.SMALL ? this.jGl.a(c, atomicBoolean) : this.jGk.a(c, atomicBoolean);
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.jGm.c(imageRequest, obj);
        if (a(imageRequest, dVar) == ImageRequest.CacheChoice.SMALL) {
            this.jGl.a(c, dVar);
        } else {
            this.jGk.a(c, dVar);
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        return imageRequest.cAg() == null ? ImageRequest.CacheChoice.DEFAULT : imageRequest.cAg();
    }
}
