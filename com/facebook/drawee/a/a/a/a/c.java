package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h lJR;
    private final com.facebook.common.time.b lJY;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lJY = bVar;
        this.lJR = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lJR.ff(this.lJY.now());
        this.lJR.setImageRequest(imageRequest);
        this.lJR.bb(obj);
        this.lJR.setRequestId(str);
        this.lJR.uZ(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lJR.fg(this.lJY.now());
        this.lJR.setImageRequest(imageRequest);
        this.lJR.setRequestId(str);
        this.lJR.uZ(z);
        this.lJR.uY(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lJR.fg(this.lJY.now());
        this.lJR.setImageRequest(imageRequest);
        this.lJR.setRequestId(str);
        this.lJR.uZ(z);
        this.lJR.uY(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void OL(String str) {
        this.lJR.fg(this.lJY.now());
        this.lJR.setRequestId(str);
        this.lJR.uX(true);
    }
}
