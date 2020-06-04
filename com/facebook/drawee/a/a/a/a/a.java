package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h moS;
    private final com.facebook.common.time.b moZ;
    private final g mop;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.moZ = bVar;
        this.moS = hVar;
        this.mop = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.moS.fF(this.moZ.now());
        this.moS.PX(str);
        this.moS.aY(obj);
        this.mop.a(this.moS, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.moS.fG(this.moZ.now());
        this.moS.PX(str);
        this.moS.a(fVar);
        this.mop.a(this.moS, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.moS.fH(this.moZ.now());
        this.moS.PX(str);
        this.moS.a(fVar);
        this.moS.vX(true);
        this.mop.a(this.moS, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.moS.fI(this.moZ.now());
        this.moS.PX(str);
        this.moS.vX(false);
        this.mop.a(this.moS, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void eV(String str) {
        super.eV(str);
        int dvL = this.moS.dvL();
        if (dvL != 3 && dvL != 5) {
            this.moS.fJ(this.moZ.now());
            this.moS.PX(str);
            this.moS.vW(true);
            this.mop.a(this.moS, 4);
        }
    }
}
