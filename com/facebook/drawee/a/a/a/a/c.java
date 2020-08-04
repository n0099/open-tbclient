package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h mTc;
    private final com.facebook.common.time.b mTk;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.mTk = bVar;
        this.mTc = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.mTc.gc(this.mTk.now());
        this.mTc.setImageRequest(imageRequest);
        this.mTc.aZ(obj);
        this.mTc.setRequestId(str);
        this.mTc.wZ(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.mTc.gd(this.mTk.now());
        this.mTc.setImageRequest(imageRequest);
        this.mTc.setRequestId(str);
        this.mTc.wZ(z);
        this.mTc.wY(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.mTc.gd(this.mTk.now());
        this.mTc.setImageRequest(imageRequest);
        this.mTc.setRequestId(str);
        this.mTc.wZ(z);
        this.mTc.wY(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void Rw(String str) {
        this.mTc.gd(this.mTk.now());
        this.mTc.setRequestId(str);
        this.mTc.wX(true);
    }
}
