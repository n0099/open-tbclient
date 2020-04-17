package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h lTL;
    private final com.facebook.common.time.b lTS;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lTS = bVar;
        this.lTL = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lTL.fK(this.lTS.now());
        this.lTL.setImageRequest(imageRequest);
        this.lTL.aT(obj);
        this.lTL.setRequestId(str);
        this.lTL.vy(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lTL.fL(this.lTS.now());
        this.lTL.setImageRequest(imageRequest);
        this.lTL.setRequestId(str);
        this.lTL.vy(z);
        this.lTL.vx(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lTL.fL(this.lTS.now());
        this.lTL.setImageRequest(imageRequest);
        this.lTL.setRequestId(str);
        this.lTL.vy(z);
        this.lTL.vx(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void Og(String str) {
        this.lTL.fL(this.lTS.now());
        this.lTL.setRequestId(str);
        this.lTL.vw(true);
    }
}
