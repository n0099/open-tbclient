package com.facebook.drawee.a.a.a.a;

import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class c extends com.facebook.imagepipeline.h.a {
    private final h nmT;
    private final com.facebook.common.time.b nna;

    public c(com.facebook.common.time.b bVar, h hVar) {
        this.nna = bVar;
        this.nmT = hVar;
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.nmT.gp(this.nna.now());
        this.nmT.setImageRequest(imageRequest);
        this.nmT.bb(obj);
        this.nmT.setRequestId(str);
        this.nmT.xQ(z);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, boolean z) {
        this.nmT.gq(this.nna.now());
        this.nmT.setImageRequest(imageRequest);
        this.nmT.setRequestId(str);
        this.nmT.xQ(z);
        this.nmT.xP(true);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.nmT.gq(this.nna.now());
        this.nmT.setImageRequest(imageRequest);
        this.nmT.setRequestId(str);
        this.nmT.xQ(z);
        this.nmT.xP(false);
    }

    @Override // com.facebook.imagepipeline.h.a, com.facebook.imagepipeline.h.c
    public void UA(String str) {
        this.nmT.gq(this.nna.now());
        this.nmT.setRequestId(str);
        this.nmT.xO(true);
    }
}
