package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final com.facebook.common.time.b pBF;
    private final h pBy;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pBF = bVar;
        this.pBy = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.pBy.iI(this.pBF.now());
        this.pBy.setImageRequest(imageRequest);
        this.pBy.bl(obj);
        this.pBy.setRequestId(str);
        this.pBy.Bj(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.pBy.iJ(this.pBF.now());
        this.pBy.setImageRequest(imageRequest);
        this.pBy.setRequestId(str);
        this.pBy.Bj(z);
        this.pBy.Bi(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.pBy.iJ(this.pBF.now());
        this.pBy.setImageRequest(imageRequest);
        this.pBy.setRequestId(str);
        this.pBy.Bj(z);
        this.pBy.Bi(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void ZD(String str) {
        this.pBy.iJ(this.pBF.now());
        this.pBy.setRequestId(str);
        this.pBy.Bh(true);
    }
}
