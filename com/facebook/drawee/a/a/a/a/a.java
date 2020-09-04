package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g nmI;
    private final h nnl;
    private final com.facebook.common.time.b nns;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.nns = bVar;
        this.nnl = hVar;
        this.nmI = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.nnl.gm(this.nns.now());
        this.nnl.Uz(str);
        this.nnl.bb(obj);
        this.nmI.a(this.nnl, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.nnl.gn(this.nns.now());
        this.nnl.Uz(str);
        this.nnl.a(fVar);
        this.nmI.a(this.nnl, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.nnl.go(this.nns.now());
        this.nnl.Uz(str);
        this.nnl.a(fVar);
        this.nnl.xR(true);
        this.nmI.a(this.nnl, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.nnl.gp(this.nns.now());
        this.nnl.Uz(str);
        this.nnl.xR(false);
        this.nmI.a(this.nnl, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void gw(String str) {
        super.gw(str);
        int dPO = this.nnl.dPO();
        if (dPO != 3 && dPO != 5) {
            this.nnl.gq(this.nns.now());
            this.nnl.Uz(str);
            this.nnl.xQ(true);
            this.nmI.a(this.nnl, 4);
        }
    }
}
