package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final h pAY;
    private final com.facebook.common.time.b pBf;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pBf = bVar;
        this.pAY = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.pAY.iI(this.pBf.now());
        this.pAY.setImageRequest(imageRequest);
        this.pAY.bl(obj);
        this.pAY.setRequestId(str);
        this.pAY.Bj(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.pAY.iJ(this.pBf.now());
        this.pAY.setImageRequest(imageRequest);
        this.pAY.setRequestId(str);
        this.pAY.Bj(z);
        this.pAY.Bi(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.pAY.iJ(this.pBf.now());
        this.pAY.setImageRequest(imageRequest);
        this.pAY.setRequestId(str);
        this.pAY.Bj(z);
        this.pAY.Bi(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void Zr(String str) {
        this.pAY.iJ(this.pBf.now());
        this.pAY.setRequestId(str);
        this.pAY.Bh(true);
    }
}
