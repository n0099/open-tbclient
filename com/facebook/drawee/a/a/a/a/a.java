package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g pAV;
    private final com.facebook.common.time.b pBF;
    private final h pBy;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pBF = bVar;
        this.pBy = hVar;
        this.pAV = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pBy.iD(this.pBF.now());
        this.pBy.ZC(str);
        this.pBy.bl(obj);
        this.pAV.a(this.pBy, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void g(String str, @Nullable f fVar) {
        this.pBy.iE(this.pBF.now());
        this.pBy.ZC(str);
        this.pBy.a(fVar);
        this.pAV.a(this.pBy, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.pBy.iF(this.pBF.now());
        this.pBy.ZC(str);
        this.pBy.a(fVar);
        this.pBy.Bi(true);
        this.pAV.a(this.pBy, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.pBy.iG(this.pBF.now());
        this.pBy.ZC(str);
        this.pBy.Bi(false);
        this.pAV.a(this.pBy, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void gy(String str) {
        super.gy(str);
        int etO = this.pBy.etO();
        if (etO != 3 && etO != 5) {
            this.pBy.iH(this.pBF.now());
            this.pBy.ZC(str);
            this.pBy.Bh(true);
            this.pAV.a(this.pBy, 4);
        }
    }
}
