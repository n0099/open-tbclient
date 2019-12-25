package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g lFL;
    private final h lGo;
    private final com.facebook.common.time.b lGv;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lGv = bVar;
        this.lGo = hVar;
        this.lFL = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lGo.eV(this.lGv.now());
        this.lGo.OA(str);
        this.lGo.bb(obj);
        this.lFL.a(this.lGo, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void onIntermediateImageSet(String str, @Nullable f fVar) {
        this.lGo.eW(this.lGv.now());
        this.lGo.OA(str);
        this.lGo.a(fVar);
        this.lFL.a(this.lGo, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lGo.eX(this.lGv.now());
        this.lGo.OA(str);
        this.lGo.a(fVar);
        this.lGo.uN(true);
        this.lFL.a(this.lGo, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFailure(String str, Throwable th) {
        this.lGo.eY(this.lGv.now());
        this.lGo.OA(str);
        this.lGo.uN(false);
        this.lFL.a(this.lGo, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onRelease(String str) {
        super.onRelease(str);
        int djy = this.lGo.djy();
        if (djy != 3 && djy != 5) {
            this.lGo.eZ(this.lGv.now());
            this.lGo.OA(str);
            this.lGo.uM(true);
            this.lFL.a(this.lGo, 4);
        }
    }
}
