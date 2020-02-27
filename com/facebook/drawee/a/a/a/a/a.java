package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g lJV;
    private final com.facebook.common.time.b lKF;
    private final h lKy;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lKF = bVar;
        this.lKy = hVar;
        this.lJV = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lKy.eY(this.lKF.now());
        this.lKy.OX(str);
        this.lKy.bd(obj);
        this.lJV.a(this.lKy, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void onIntermediateImageSet(String str, @Nullable f fVar) {
        this.lKy.eZ(this.lKF.now());
        this.lKy.OX(str);
        this.lKy.a(fVar);
        this.lJV.a(this.lKy, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lKy.fa(this.lKF.now());
        this.lKy.OX(str);
        this.lKy.a(fVar);
        this.lKy.vc(true);
        this.lJV.a(this.lKy, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFailure(String str, Throwable th) {
        this.lKy.fb(this.lKF.now());
        this.lKy.OX(str);
        this.lKy.vc(false);
        this.lJV.a(this.lKy, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onRelease(String str) {
        super.onRelease(str);
        int dlO = this.lKy.dlO();
        if (dlO != 3 && dlO != 5) {
            this.lKy.fc(this.lKF.now());
            this.lKy.OX(str);
            this.lKy.vb(true);
            this.lJV.a(this.lKy, 4);
        }
    }
}
