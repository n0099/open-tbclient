package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final h peb;
    private final com.facebook.common.time.b pei;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pei = bVar;
        this.peb = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.peb.ir(this.pei.now());
        this.peb.setImageRequest(imageRequest);
        this.peb.bl(obj);
        this.peb.setRequestId(str);
        this.peb.AM(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.peb.is(this.pei.now());
        this.peb.setImageRequest(imageRequest);
        this.peb.setRequestId(str);
        this.peb.AM(z);
        this.peb.AL(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.peb.is(this.pei.now());
        this.peb.setImageRequest(imageRequest);
        this.peb.setRequestId(str);
        this.peb.AM(z);
        this.peb.AL(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void Zn(String str) {
        this.peb.is(this.pei.now());
        this.peb.setRequestId(str);
        this.peb.AK(true);
    }
}
