package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes6.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final h pvj;
    private final com.facebook.common.time.b pvq;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pvq = bVar;
        this.pvj = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.pvj.iF(this.pvq.now());
        this.pvj.setImageRequest(imageRequest);
        this.pvj.bl(obj);
        this.pvj.setRequestId(str);
        this.pvj.AU(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.pvj.iG(this.pvq.now());
        this.pvj.setImageRequest(imageRequest);
        this.pvj.setRequestId(str);
        this.pvj.AU(z);
        this.pvj.AT(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.pvj.iG(this.pvq.now());
        this.pvj.setImageRequest(imageRequest);
        this.pvj.setRequestId(str);
        this.pvj.AU(z);
        this.pvj.AT(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void Zy(String str) {
        this.pvj.iG(this.pvq.now());
        this.pvj.setRequestId(str);
        this.pvj.AS(true);
    }
}
