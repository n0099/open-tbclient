package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes6.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final h pvq;
    private final com.facebook.common.time.b pvx;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pvx = bVar;
        this.pvq = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.pvq.iF(this.pvx.now());
        this.pvq.setImageRequest(imageRequest);
        this.pvq.bl(obj);
        this.pvq.setRequestId(str);
        this.pvq.AU(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.pvq.iG(this.pvx.now());
        this.pvq.setImageRequest(imageRequest);
        this.pvq.setRequestId(str);
        this.pvq.AU(z);
        this.pvq.AT(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.pvq.iG(this.pvx.now());
        this.pvq.setImageRequest(imageRequest);
        this.pvq.setRequestId(str);
        this.pvq.AU(z);
        this.pvq.AT(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void Zx(String str) {
        this.pvq.iG(this.pvx.now());
        this.pvq.setRequestId(str);
        this.pvq.AS(true);
    }
}
