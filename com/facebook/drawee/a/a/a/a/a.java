package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g puN;
    private final h pvq;
    private final com.facebook.common.time.b pvx;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pvx = bVar;
        this.pvq = hVar;
        this.puN = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pvq.iA(this.pvx.now());
        this.pvq.Zw(str);
        this.pvq.bl(obj);
        this.puN.a(this.pvq, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void g(String str, @Nullable f fVar) {
        this.pvq.iB(this.pvx.now());
        this.pvq.Zw(str);
        this.pvq.a(fVar);
        this.puN.a(this.pvq, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.pvq.iC(this.pvx.now());
        this.pvq.Zw(str);
        this.pvq.a(fVar);
        this.pvq.AT(true);
        this.puN.a(this.pvq, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.pvq.iD(this.pvx.now());
        this.pvq.Zw(str);
        this.pvq.AT(false);
        this.puN.a(this.pvq, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void hm(String str) {
        super.hm(str);
        int evh = this.pvq.evh();
        if (evh != 3 && evh != 5) {
            this.pvq.iE(this.pvx.now());
            this.pvq.Zw(str);
            this.pvq.AS(true);
            this.puN.a(this.pvq, 4);
        }
    }
}
