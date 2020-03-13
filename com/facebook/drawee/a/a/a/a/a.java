package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h lKL;
    private final com.facebook.common.time.b lKS;
    private final g lKi;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lKS = bVar;
        this.lKL = hVar;
        this.lKi = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lKL.eY(this.lKS.now());
        this.lKL.OY(str);
        this.lKL.bd(obj);
        this.lKi.a(this.lKL, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void onIntermediateImageSet(String str, @Nullable f fVar) {
        this.lKL.eZ(this.lKS.now());
        this.lKL.OY(str);
        this.lKL.a(fVar);
        this.lKi.a(this.lKL, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lKL.fa(this.lKS.now());
        this.lKL.OY(str);
        this.lKL.a(fVar);
        this.lKL.vc(true);
        this.lKi.a(this.lKL, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFailure(String str, Throwable th) {
        this.lKL.fb(this.lKS.now());
        this.lKL.OY(str);
        this.lKL.vc(false);
        this.lKi.a(this.lKL, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onRelease(String str) {
        super.onRelease(str);
        int dlR = this.lKL.dlR();
        if (dlR != 3 && dlR != 5) {
            this.lKL.fc(this.lKS.now());
            this.lKL.OY(str);
            this.lKL.vb(true);
            this.lKi.a(this.lKL, 4);
        }
    }
}
