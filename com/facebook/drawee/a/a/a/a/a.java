package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h mKR;
    private final com.facebook.common.time.b mKY;
    private final g mKo;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.mKY = bVar;
        this.mKR = hVar;
        this.mKo = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mKR.fK(this.mKY.now());
        this.mKR.QJ(str);
        this.mKR.aZ(obj);
        this.mKo.a(this.mKR, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.mKR.fL(this.mKY.now());
        this.mKR.QJ(str);
        this.mKR.a(fVar);
        this.mKo.a(this.mKR, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.mKR.fM(this.mKY.now());
        this.mKR.QJ(str);
        this.mKR.a(fVar);
        this.mKR.wt(true);
        this.mKo.a(this.mKR, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.mKR.fN(this.mKY.now());
        this.mKR.QJ(str);
        this.mKR.wt(false);
        this.mKo.a(this.mKR, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void fb(String str) {
        super.fb(str);
        int dAo = this.mKR.dAo();
        if (dAo != 3 && dAo != 5) {
            this.mKR.fO(this.mKY.now());
            this.mKR.QJ(str);
            this.mKR.ws(true);
            this.mKo.a(this.mKR, 4);
        }
    }
}
