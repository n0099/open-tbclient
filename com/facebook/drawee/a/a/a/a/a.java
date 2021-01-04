package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g puG;
    private final h pvj;
    private final com.facebook.common.time.b pvq;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pvq = bVar;
        this.pvj = hVar;
        this.puG = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pvj.iA(this.pvq.now());
        this.pvj.Zx(str);
        this.pvj.bl(obj);
        this.puG.a(this.pvj, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void g(String str, @Nullable f fVar) {
        this.pvj.iB(this.pvq.now());
        this.pvj.Zx(str);
        this.pvj.a(fVar);
        this.puG.a(this.pvj, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.pvj.iC(this.pvq.now());
        this.pvj.Zx(str);
        this.pvj.a(fVar);
        this.pvj.AT(true);
        this.puG.a(this.pvj, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.pvj.iD(this.pvq.now());
        this.pvj.Zx(str);
        this.pvj.AT(false);
        this.puG.a(this.pvj, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void hm(String str) {
        super.hm(str);
        int eva = this.pvj.eva();
        if (eva != 3 && eva != 5) {
            this.pvj.iE(this.pvq.now());
            this.pvj.Zx(str);
            this.pvj.AS(true);
            this.puG.a(this.pvj, 4);
        }
    }
}
