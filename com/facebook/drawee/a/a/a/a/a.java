package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h oDX;
    private final g oDu;
    private final com.facebook.common.time.b oEe;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.oEe = bVar;
        this.oDX = hVar;
        this.oDu = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.oDX.hi(this.oEe.now());
        this.oDX.XC(str);
        this.oDX.bk(obj);
        this.oDu.a(this.oDX, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.oDX.hj(this.oEe.now());
        this.oDX.XC(str);
        this.oDX.a(fVar);
        this.oDu.a(this.oDX, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.oDX.hk(this.oEe.now());
        this.oDX.XC(str);
        this.oDX.a(fVar);
        this.oDX.zP(true);
        this.oDu.a(this.oDX, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.oDX.hl(this.oEe.now());
        this.oDX.XC(str);
        this.oDX.zP(false);
        this.oDu.a(this.oDX, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void hf(String str) {
        super.hf(str);
        int ehv = this.oDX.ehv();
        if (ehv != 3 && ehv != 5) {
            this.oDX.hm(this.oEe.now());
            this.oDX.XC(str);
            this.oDX.zO(true);
            this.oDu.a(this.oDX, 4);
        }
    }
}
