package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h lJR;
    private final com.facebook.common.time.b lJY;
    private final g lJo;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lJY = bVar;
        this.lJR = hVar;
        this.lJo = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lJR.fa(this.lJY.now());
        this.lJR.OK(str);
        this.lJR.bb(obj);
        this.lJo.a(this.lJR, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void onIntermediateImageSet(String str, @Nullable f fVar) {
        this.lJR.fb(this.lJY.now());
        this.lJR.OK(str);
        this.lJR.a(fVar);
        this.lJo.a(this.lJR, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lJR.fc(this.lJY.now());
        this.lJR.OK(str);
        this.lJR.a(fVar);
        this.lJR.uY(true);
        this.lJo.a(this.lJR, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFailure(String str, Throwable th) {
        this.lJR.fd(this.lJY.now());
        this.lJR.OK(str);
        this.lJR.uY(false);
        this.lJo.a(this.lJR, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onRelease(String str) {
        super.onRelease(str);
        int dkB = this.lJR.dkB();
        if (dkB != 3 && dkB != 5) {
            this.lJR.fe(this.lJY.now());
            this.lJR.OK(str);
            this.lJR.uX(true);
            this.lJo.a(this.lJR, 4);
        }
    }
}
