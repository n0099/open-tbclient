package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h mTa;
    private final com.facebook.common.time.b mTh;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.mTh = bVar;
        this.mTa = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.mTa.gc(this.mTh.now());
        this.mTa.setImageRequest(imageRequest);
        this.mTa.aZ(obj);
        this.mTa.setRequestId(str);
        this.mTa.wZ(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.mTa.gd(this.mTh.now());
        this.mTa.setImageRequest(imageRequest);
        this.mTa.setRequestId(str);
        this.mTa.wZ(z);
        this.mTa.wY(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.mTa.gd(this.mTh.now());
        this.mTa.setImageRequest(imageRequest);
        this.mTa.setRequestId(str);
        this.mTa.wZ(z);
        this.mTa.wY(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void Rw(String str) {
        this.mTa.gd(this.mTh.now());
        this.mTa.setRequestId(str);
        this.mTa.wX(true);
    }
}
