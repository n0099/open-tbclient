package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h mKU;
    private final g mKr;
    private final com.facebook.common.time.b mLb;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.mLb = bVar;
        this.mKU = hVar;
        this.mKr = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mKU.fK(this.mLb.now());
        this.mKU.QK(str);
        this.mKU.aZ(obj);
        this.mKr.a(this.mKU, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.mKU.fL(this.mLb.now());
        this.mKU.QK(str);
        this.mKU.a(fVar);
        this.mKr.a(this.mKU, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.mKU.fM(this.mLb.now());
        this.mKU.QK(str);
        this.mKU.a(fVar);
        this.mKU.wt(true);
        this.mKr.a(this.mKU, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.mKU.fN(this.mLb.now());
        this.mKU.QK(str);
        this.mKU.wt(false);
        this.mKr.a(this.mKU, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void fb(String str) {
        super.fb(str);
        int dAs = this.mKU.dAs();
        if (dAs != 3 && dAs != 5) {
            this.mKU.fO(this.mLb.now());
            this.mKU.QK(str);
            this.mKU.ws(true);
            this.mKr.a(this.mKU, 4);
        }
    }
}
