package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h lTP;
    private final com.facebook.common.time.b lTW;
    private final g lTm;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lTW = bVar;
        this.lTP = hVar;
        this.lTm = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.lTP.fF(this.lTW.now());
        this.lTP.Oi(str);
        this.lTP.aU(obj);
        this.lTm.a(this.lTP, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.lTP.fG(this.lTW.now());
        this.lTP.Oi(str);
        this.lTP.a(fVar);
        this.lTm.a(this.lTP, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lTP.fH(this.lTW.now());
        this.lTP.Oi(str);
        this.lTP.a(fVar);
        this.lTP.vx(true);
        this.lTm.a(this.lTP, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Throwable th) {
        this.lTP.fI(this.lTW.now());
        this.lTP.Oi(str);
        this.lTP.vx(false);
        this.lTm.a(this.lTP, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void el(String str) {
        super.el(str);
        int doe = this.lTP.doe();
        if (doe != 3 && doe != 5) {
            this.lTP.fJ(this.lTW.now());
            this.lTP.Oi(str);
            this.lTP.vw(true);
            this.lTm.a(this.lTP, 4);
        }
    }
}
