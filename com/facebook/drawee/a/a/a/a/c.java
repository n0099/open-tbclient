package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h lTP;
    private final com.facebook.common.time.b lTW;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lTW = bVar;
        this.lTP = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lTP.fK(this.lTW.now());
        this.lTP.setImageRequest(imageRequest);
        this.lTP.aU(obj);
        this.lTP.setRequestId(str);
        this.lTP.vy(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lTP.fL(this.lTW.now());
        this.lTP.setImageRequest(imageRequest);
        this.lTP.setRequestId(str);
        this.lTP.vy(z);
        this.lTP.vx(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lTP.fL(this.lTW.now());
        this.lTP.setImageRequest(imageRequest);
        this.lTP.setRequestId(str);
        this.lTP.vy(z);
        this.lTP.vx(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void Oj(String str) {
        this.lTP.fL(this.lTW.now());
        this.lTP.setRequestId(str);
        this.lTP.vw(true);
    }
}
