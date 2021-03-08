package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes14.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final h pDD;
    private final com.facebook.common.time.b pDK;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pDK = bVar;
        this.pDD = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.pDD.iI(this.pDK.now());
        this.pDD.setImageRequest(imageRequest);
        this.pDD.bn(obj);
        this.pDD.setRequestId(str);
        this.pDD.Bh(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.pDD.iJ(this.pDK.now());
        this.pDD.setImageRequest(imageRequest);
        this.pDD.setRequestId(str);
        this.pDD.Bh(z);
        this.pDD.Bg(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.pDD.iJ(this.pDK.now());
        this.pDD.setImageRequest(imageRequest);
        this.pDD.setRequestId(str);
        this.pDD.Bh(z);
        this.pDD.Bg(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void ZJ(String str) {
        this.pDD.iJ(this.pDK.now());
        this.pDD.setRequestId(str);
        this.pDD.Bf(true);
    }
}
