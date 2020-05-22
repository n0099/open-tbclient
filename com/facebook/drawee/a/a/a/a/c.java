package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h mnH;
    private final com.facebook.common.time.b mnO;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.mnO = bVar;
        this.mnH = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.mnH.fK(this.mnO.now());
        this.mnH.setImageRequest(imageRequest);
        this.mnH.aY(obj);
        this.mnH.setRequestId(str);
        this.mnH.vW(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.mnH.fL(this.mnO.now());
        this.mnH.setImageRequest(imageRequest);
        this.mnH.setRequestId(str);
        this.mnH.vW(z);
        this.mnH.vV(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.mnH.fL(this.mnO.now());
        this.mnH.setImageRequest(imageRequest);
        this.mnH.setRequestId(str);
        this.mnH.vW(z);
        this.mnH.vV(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void PX(String str) {
        this.mnH.fL(this.mnO.now());
        this.mnH.setRequestId(str);
        this.mnH.vU(true);
    }
}
