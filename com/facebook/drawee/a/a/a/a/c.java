package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h mKU;
    private final com.facebook.common.time.b mLb;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.mLb = bVar;
        this.mKU = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.mKU.fP(this.mLb.now());
        this.mKU.setImageRequest(imageRequest);
        this.mKU.aZ(obj);
        this.mKU.setRequestId(str);
        this.mKU.wu(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.mKU.fQ(this.mLb.now());
        this.mKU.setImageRequest(imageRequest);
        this.mKU.setRequestId(str);
        this.mKU.wu(z);
        this.mKU.wt(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.mKU.fQ(this.mLb.now());
        this.mKU.setImageRequest(imageRequest);
        this.mKU.setRequestId(str);
        this.mKU.wu(z);
        this.mKU.wt(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void QL(String str) {
        this.mKU.fQ(this.mLb.now());
        this.mKU.setRequestId(str);
        this.mKU.ws(true);
    }
}
