package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes13.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h lMr;
    private final com.facebook.common.time.b lMy;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.lMy = bVar;
        this.lMr = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.lMr.fe(this.lMy.now());
        this.lMr.setImageRequest(imageRequest);
        this.lMr.bd(obj);
        this.lMr.setRequestId(str);
        this.lMr.vk(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.lMr.ff(this.lMy.now());
        this.lMr.setImageRequest(imageRequest);
        this.lMr.setRequestId(str);
        this.lMr.vk(z);
        this.lMr.vj(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.lMr.ff(this.lMy.now());
        this.lMr.setImageRequest(imageRequest);
        this.lMr.setRequestId(str);
        this.lMr.vk(z);
        this.lMr.vj(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void OY(String str) {
        this.lMr.ff(this.lMy.now());
        this.lMr.setRequestId(str);
        this.lMr.vi(true);
    }
}
