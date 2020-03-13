package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h lKL;
    private final com.facebook.common.time.b lKS;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lKS = bVar;
        this.lKL = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lKL.fd(this.lKS.now());
        this.lKL.setImageRequest(imageRequest);
        this.lKL.bd(obj);
        this.lKL.setRequestId(str);
        this.lKL.vd(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lKL.fe(this.lKS.now());
        this.lKL.setImageRequest(imageRequest);
        this.lKL.setRequestId(str);
        this.lKL.vd(z);
        this.lKL.vc(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lKL.fe(this.lKS.now());
        this.lKL.setImageRequest(imageRequest);
        this.lKL.setRequestId(str);
        this.lKL.vd(z);
        this.lKL.vc(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void OZ(String str) {
        this.lKL.fe(this.lKS.now());
        this.lKL.setRequestId(str);
        this.lKL.vb(true);
    }
}
