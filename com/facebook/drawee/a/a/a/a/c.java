package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final com.facebook.common.time.b lKF;
    private final h lKy;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lKF = bVar;
        this.lKy = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lKy.fd(this.lKF.now());
        this.lKy.setImageRequest(imageRequest);
        this.lKy.bd(obj);
        this.lKy.setRequestId(str);
        this.lKy.vd(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lKy.fe(this.lKF.now());
        this.lKy.setImageRequest(imageRequest);
        this.lKy.setRequestId(str);
        this.lKy.vd(z);
        this.lKy.vc(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lKy.fe(this.lKF.now());
        this.lKy.setImageRequest(imageRequest);
        this.lKy.setRequestId(str);
        this.lKy.vd(z);
        this.lKy.vc(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void OY(String str) {
        this.lKy.fe(this.lKF.now());
        this.lKy.setRequestId(str);
        this.lKy.vb(true);
    }
}
