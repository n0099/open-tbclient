package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final h ped;
    private final com.facebook.common.time.b pek;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pek = bVar;
        this.ped = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.ped.ir(this.pek.now());
        this.ped.setImageRequest(imageRequest);
        this.ped.bl(obj);
        this.ped.setRequestId(str);
        this.ped.AM(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.ped.is(this.pek.now());
        this.ped.setImageRequest(imageRequest);
        this.ped.setRequestId(str);
        this.ped.AM(z);
        this.ped.AL(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.ped.is(this.pek.now());
        this.ped.setImageRequest(imageRequest);
        this.ped.setRequestId(str);
        this.ped.AM(z);
        this.ped.AL(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void Zn(String str) {
        this.ped.is(this.pek.now());
        this.ped.setRequestId(str);
        this.ped.AK(true);
    }
}
