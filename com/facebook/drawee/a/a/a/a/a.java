package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h nmT;
    private final g nmq;
    private final com.facebook.common.time.b nna;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.nna = bVar;
        this.nmT = hVar;
        this.nmq = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.nmT.gk(this.nna.now());
        this.nmT.Uz(str);
        this.nmT.bb(obj);
        this.nmq.a(this.nmT, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.nmT.gl(this.nna.now());
        this.nmT.Uz(str);
        this.nmT.a(fVar);
        this.nmq.a(this.nmT, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.nmT.gm(this.nna.now());
        this.nmT.Uz(str);
        this.nmT.a(fVar);
        this.nmT.xP(true);
        this.nmq.a(this.nmT, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.nmT.gn(this.nna.now());
        this.nmT.Uz(str);
        this.nmT.xP(false);
        this.nmq.a(this.nmT, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void gv(String str) {
        super.gv(str);
        int dPF = this.nmT.dPF();
        if (dPF != 3 && dPF != 5) {
            this.nmT.go(this.nna.now());
            this.nmT.Uz(str);
            this.nmT.xO(true);
            this.nmq.a(this.nmT, 4);
        }
    }
}
