package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h pAY;
    private final g pAv;
    private final com.facebook.common.time.b pBf;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pBf = bVar;
        this.pAY = hVar;
        this.pAv = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pAY.iD(this.pBf.now());
        this.pAY.Zq(str);
        this.pAY.bl(obj);
        this.pAv.a(this.pAY, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void g(String str, @Nullable f fVar) {
        this.pAY.iE(this.pBf.now());
        this.pAY.Zq(str);
        this.pAY.a(fVar);
        this.pAv.a(this.pAY, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.pAY.iF(this.pBf.now());
        this.pAY.Zq(str);
        this.pAY.a(fVar);
        this.pAY.Bi(true);
        this.pAv.a(this.pAY, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.pAY.iG(this.pBf.now());
        this.pAY.Zq(str);
        this.pAY.Bi(false);
        this.pAv.a(this.pAY, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void gy(String str) {
        super.gy(str);
        int etG = this.pAY.etG();
        if (etG != 3 && etG != 5) {
            this.pAY.iH(this.pBf.now());
            this.pAY.Zq(str);
            this.pAY.Bh(true);
            this.pAv.a(this.pAY, 4);
        }
    }
}
