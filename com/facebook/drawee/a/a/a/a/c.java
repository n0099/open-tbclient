package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes6.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final h pqP;
    private final com.facebook.common.time.b pqW;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pqW = bVar;
        this.pqP = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.pqP.iF(this.pqW.now());
        this.pqP.setImageRequest(imageRequest);
        this.pqP.bl(obj);
        this.pqP.setRequestId(str);
        this.pqP.AQ(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.pqP.iG(this.pqW.now());
        this.pqP.setImageRequest(imageRequest);
        this.pqP.setRequestId(str);
        this.pqP.AQ(z);
        this.pqP.AP(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.pqP.iG(this.pqW.now());
        this.pqP.setImageRequest(imageRequest);
        this.pqP.setRequestId(str);
        this.pqP.AQ(z);
        this.pqP.AP(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void Yq(String str) {
        this.pqP.iG(this.pqW.now());
        this.pqP.setRequestId(str);
        this.pqP.AO(true);
    }
}
