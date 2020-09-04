package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h nnl;
    private final com.facebook.common.time.b nns;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.nns = bVar;
        this.nnl = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.nnl.gr(this.nns.now());
        this.nnl.setImageRequest(imageRequest);
        this.nnl.bb(obj);
        this.nnl.setRequestId(str);
        this.nnl.xS(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.nnl.gs(this.nns.now());
        this.nnl.setImageRequest(imageRequest);
        this.nnl.setRequestId(str);
        this.nnl.xS(z);
        this.nnl.xR(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.nnl.gs(this.nns.now());
        this.nnl.setImageRequest(imageRequest);
        this.nnl.setRequestId(str);
        this.nnl.xS(z);
        this.nnl.xR(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void UA(String str) {
        this.nnl.gs(this.nns.now());
        this.nnl.setRequestId(str);
        this.nnl.xQ(true);
    }
}
