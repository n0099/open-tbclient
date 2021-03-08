package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h pDD;
    private final com.facebook.common.time.b pDK;
    private final g pDa;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pDK = bVar;
        this.pDD = hVar;
        this.pDa = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.pDD.iD(this.pDK.now());
        this.pDD.ZI(str);
        this.pDD.bn(obj);
        this.pDa.a(this.pDD, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.pDD.iE(this.pDK.now());
        this.pDD.ZI(str);
        this.pDD.a(fVar);
        this.pDa.a(this.pDD, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.pDD.iF(this.pDK.now());
        this.pDD.ZI(str);
        this.pDD.a(fVar);
        this.pDD.Bg(true);
        this.pDa.a(this.pDD, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.pDD.iG(this.pDK.now());
        this.pDD.ZI(str);
        this.pDD.Bg(false);
        this.pDa.a(this.pDD, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void gE(String str) {
        super.gE(str);
        int etX = this.pDD.etX();
        if (etX != 3 && etX != 5) {
            this.pDD.iH(this.pDK.now());
            this.pDD.ZI(str);
            this.pDD.Bf(true);
            this.pDa.a(this.pDD, 4);
        }
    }
}
