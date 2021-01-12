package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes6.dex */
public class c extends com.facebook.imagepipeline.g.a {
    private final h pqO;
    private final com.facebook.common.time.b pqV;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.pqV = bVar;
        this.pqO = hVar;
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.pqO.iF(this.pqV.now());
        this.pqO.setImageRequest(imageRequest);
        this.pqO.bl(obj);
        this.pqO.setRequestId(str);
        this.pqO.AQ(z);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.pqO.iG(this.pqV.now());
        this.pqO.setImageRequest(imageRequest);
        this.pqO.setRequestId(str);
        this.pqO.AQ(z);
        this.pqO.AP(true);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.pqO.iG(this.pqV.now());
        this.pqO.setImageRequest(imageRequest);
        this.pqO.setRequestId(str);
        this.pqO.AQ(z);
        this.pqO.AP(false);
    }

    @Override // com.facebook.imagepipeline.g.a, com.facebook.imagepipeline.g.c
    public void Yp(String str) {
        this.pqO.iG(this.pqV.now());
        this.pqO.setRequestId(str);
        this.pqO.AO(true);
    }
}
