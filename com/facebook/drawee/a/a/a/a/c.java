package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h lJM;
    private final com.facebook.common.time.b lJT;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lJT = bVar;
        this.lJM = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lJM.ff(this.lJT.now());
        this.lJM.setImageRequest(imageRequest);
        this.lJM.bb(obj);
        this.lJM.setRequestId(str);
        this.lJM.uZ(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lJM.fg(this.lJT.now());
        this.lJM.setImageRequest(imageRequest);
        this.lJM.setRequestId(str);
        this.lJM.uZ(z);
        this.lJM.uY(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lJM.fg(this.lJT.now());
        this.lJM.setImageRequest(imageRequest);
        this.lJM.setRequestId(str);
        this.lJM.uZ(z);
        this.lJM.uY(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void OL(String str) {
        this.lJM.fg(this.lJT.now());
        this.lJM.setRequestId(str);
        this.lJM.uX(true);
    }
}
