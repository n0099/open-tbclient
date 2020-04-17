package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h lTL;
    private final com.facebook.common.time.b lTS;
    private final g lTi;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lTS = bVar;
        this.lTL = hVar;
        this.lTi = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.lTL.fF(this.lTS.now());
        this.lTL.Of(str);
        this.lTL.aT(obj);
        this.lTi.a(this.lTL, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.lTL.fG(this.lTS.now());
        this.lTL.Of(str);
        this.lTL.a(fVar);
        this.lTi.a(this.lTL, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lTL.fH(this.lTS.now());
        this.lTL.Of(str);
        this.lTL.a(fVar);
        this.lTL.vx(true);
        this.lTi.a(this.lTL, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.lTL.fI(this.lTS.now());
        this.lTL.Of(str);
        this.lTL.vx(false);
        this.lTi.a(this.lTL, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void el(String str) {
        super.el(str);
        int doh = this.lTL.doh();
        if (doh != 3 && doh != 5) {
            this.lTL.fJ(this.lTS.now());
            this.lTL.Of(str);
            this.lTL.vw(true);
            this.lTi.a(this.lTL, 4);
        }
    }
}
