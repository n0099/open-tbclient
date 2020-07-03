package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h mKR;
    private final com.facebook.common.time.b mKY;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.mKY = bVar;
        this.mKR = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.mKR.fP(this.mKY.now());
        this.mKR.setImageRequest(imageRequest);
        this.mKR.aZ(obj);
        this.mKR.setRequestId(str);
        this.mKR.wu(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.mKR.fQ(this.mKY.now());
        this.mKR.setImageRequest(imageRequest);
        this.mKR.setRequestId(str);
        this.mKR.wu(z);
        this.mKR.wt(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.mKR.fQ(this.mKY.now());
        this.mKR.setImageRequest(imageRequest);
        this.mKR.setRequestId(str);
        this.mKR.wu(z);
        this.mKR.wt(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void QK(String str) {
        this.mKR.fQ(this.mKY.now());
        this.mKR.setRequestId(str);
        this.mKR.ws(true);
    }
}
