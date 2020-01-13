package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h lJM;
    private final com.facebook.common.time.b lJT;
    private final g lJj;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lJT = bVar;
        this.lJM = hVar;
        this.lJj = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lJM.fa(this.lJT.now());
        this.lJM.OK(str);
        this.lJM.bb(obj);
        this.lJj.a(this.lJM, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void onIntermediateImageSet(String str, @Nullable f fVar) {
        this.lJM.fb(this.lJT.now());
        this.lJM.OK(str);
        this.lJM.a(fVar);
        this.lJj.a(this.lJM, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lJM.fc(this.lJT.now());
        this.lJM.OK(str);
        this.lJM.a(fVar);
        this.lJM.uY(true);
        this.lJj.a(this.lJM, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFailure(String str, Throwable th) {
        this.lJM.fd(this.lJT.now());
        this.lJM.OK(str);
        this.lJM.uY(false);
        this.lJj.a(this.lJM, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onRelease(String str) {
        super.onRelease(str);
        int dkz = this.lJM.dkz();
        if (dkz != 3 && dkz != 5) {
            this.lJM.fe(this.lJT.now());
            this.lJM.OK(str);
            this.lJM.uX(true);
            this.lJj.a(this.lJM, 4);
        }
    }
}
