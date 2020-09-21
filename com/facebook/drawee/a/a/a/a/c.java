package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h nxl;
    private final com.facebook.common.time.b nxs;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.nxs = bVar;
        this.nxl = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.nxl.gF(this.nxs.now());
        this.nxl.setImageRequest(imageRequest);
        this.nxl.bd(obj);
        this.nxl.setRequestId(str);
        this.nxl.yb(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.nxl.gG(this.nxs.now());
        this.nxl.setImageRequest(imageRequest);
        this.nxl.setRequestId(str);
        this.nxl.yb(z);
        this.nxl.ya(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.nxl.gG(this.nxs.now());
        this.nxl.setImageRequest(imageRequest);
        this.nxl.setRequestId(str);
        this.nxl.yb(z);
        this.nxl.ya(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void Vc(String str) {
        this.nxl.gG(this.nxs.now());
        this.nxl.setRequestId(str);
        this.nxl.xZ(true);
    }
}
