package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h nME;
    private final com.facebook.common.time.b nML;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.nML = bVar;
        this.nME = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.nME.gX(this.nML.now());
        this.nME.setImageRequest(imageRequest);
        this.nME.bg(obj);
        this.nME.setRequestId(str);
        this.nME.yI(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.nME.gY(this.nML.now());
        this.nME.setImageRequest(imageRequest);
        this.nME.setRequestId(str);
        this.nME.yI(z);
        this.nME.yH(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.nME.gY(this.nML.now());
        this.nME.setImageRequest(imageRequest);
        this.nME.setRequestId(str);
        this.nME.yI(z);
        this.nME.yH(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void VQ(String str) {
        this.nME.gY(this.nML.now());
        this.nME.setRequestId(str);
        this.nME.yG(true);
    }
}
