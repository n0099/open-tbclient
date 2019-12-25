package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes11.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h lGo;
    private final com.facebook.common.time.b lGv;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lGv = bVar;
        this.lGo = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lGo.fa(this.lGv.now());
        this.lGo.setImageRequest(imageRequest);
        this.lGo.bb(obj);
        this.lGo.setRequestId(str);
        this.lGo.uO(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lGo.fb(this.lGv.now());
        this.lGo.setImageRequest(imageRequest);
        this.lGo.setRequestId(str);
        this.lGo.uO(z);
        this.lGo.uN(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lGo.fb(this.lGv.now());
        this.lGo.setImageRequest(imageRequest);
        this.lGo.setRequestId(str);
        this.lGo.uO(z);
        this.lGo.uN(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void OB(String str) {
        this.lGo.fb(this.lGv.now());
        this.lGo.setRequestId(str);
        this.lGo.uM(true);
    }
}
