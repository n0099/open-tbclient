package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h oDX;
    private final com.facebook.common.time.b oEe;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.oEe = bVar;
        this.oDX = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.oDX.hn(this.oEe.now());
        this.oDX.setImageRequest(imageRequest);
        this.oDX.bk(obj);
        this.oDX.setRequestId(str);
        this.oDX.zQ(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.oDX.ho(this.oEe.now());
        this.oDX.setImageRequest(imageRequest);
        this.oDX.setRequestId(str);
        this.oDX.zQ(z);
        this.oDX.zP(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.oDX.ho(this.oEe.now());
        this.oDX.setImageRequest(imageRequest);
        this.oDX.setRequestId(str);
        this.oDX.zQ(z);
        this.oDX.zP(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void XD(String str) {
        this.oDX.ho(this.oEe.now());
        this.oDX.setRequestId(str);
        this.oDX.zO(true);
    }
}
