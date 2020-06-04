package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h moS;
    private final com.facebook.common.time.b moZ;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.moZ = bVar;
        this.moS = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.moS.fK(this.moZ.now());
        this.moS.setImageRequest(imageRequest);
        this.moS.aY(obj);
        this.moS.setRequestId(str);
        this.moS.vY(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.moS.fL(this.moZ.now());
        this.moS.setImageRequest(imageRequest);
        this.moS.setRequestId(str);
        this.moS.vY(z);
        this.moS.vX(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.moS.fL(this.moZ.now());
        this.moS.setImageRequest(imageRequest);
        this.moS.setRequestId(str);
        this.moS.vY(z);
        this.moS.vX(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void PY(String str) {
        this.moS.fL(this.moZ.now());
        this.moS.setRequestId(str);
        this.moS.vW(true);
    }
}
