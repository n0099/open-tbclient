package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h oOU;
    private final com.facebook.common.time.b oPb;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.oPb = bVar;
        this.oOU = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.oOU.hM(this.oPb.now());
        this.oOU.setImageRequest(imageRequest);
        this.oOU.bl(obj);
        this.oOU.setRequestId(str);
        this.oOU.Ai(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.oOU.hN(this.oPb.now());
        this.oOU.setImageRequest(imageRequest);
        this.oOU.setRequestId(str);
        this.oOU.Ai(z);
        this.oOU.Ah(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.oOU.hN(this.oPb.now());
        this.oOU.setImageRequest(imageRequest);
        this.oOU.setRequestId(str);
        this.oOU.Ai(z);
        this.oOU.Ah(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void XS(String str) {
        this.oOU.hN(this.oPb.now());
        this.oOU.setRequestId(str);
        this.oOU.Ag(true);
    }
}
