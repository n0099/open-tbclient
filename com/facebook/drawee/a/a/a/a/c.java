package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h oNq;
    private final com.facebook.common.time.b oNx;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.oNx = bVar;
        this.oNq = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.oNq.hJ(this.oNx.now());
        this.oNq.setImageRequest(imageRequest);
        this.oNq.bk(obj);
        this.oNq.setRequestId(str);
        this.oNq.Ab(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.oNq.hK(this.oNx.now());
        this.oNq.setImageRequest(imageRequest);
        this.oNq.setRequestId(str);
        this.oNq.Ab(z);
        this.oNq.Aa(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.oNq.hK(this.oNx.now());
        this.oNq.setImageRequest(imageRequest);
        this.oNq.setRequestId(str);
        this.oNq.Ab(z);
        this.oNq.Aa(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void Yh(String str) {
        this.oNq.hK(this.oNx.now());
        this.oNq.setRequestId(str);
        this.oNq.zZ(true);
    }
}
