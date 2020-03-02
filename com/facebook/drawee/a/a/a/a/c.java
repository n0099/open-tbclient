package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h lKA;
    private final com.facebook.common.time.b lKH;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lKH = bVar;
        this.lKA = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lKA.fd(this.lKH.now());
        this.lKA.setImageRequest(imageRequest);
        this.lKA.bd(obj);
        this.lKA.setRequestId(str);
        this.lKA.vd(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lKA.fe(this.lKH.now());
        this.lKA.setImageRequest(imageRequest);
        this.lKA.setRequestId(str);
        this.lKA.vd(z);
        this.lKA.vc(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lKA.fe(this.lKH.now());
        this.lKA.setImageRequest(imageRequest);
        this.lKA.setRequestId(str);
        this.lKA.vd(z);
        this.lKA.vc(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void OY(String str) {
        this.lKA.fe(this.lKH.now());
        this.lKA.setRequestId(str);
        this.lKA.vb(true);
    }
}
