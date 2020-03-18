package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g lLO;
    private final h lMr;
    private final com.facebook.common.time.b lMy;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lMy = bVar;
        this.lMr = hVar;
        this.lLO = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lMr.eZ(this.lMy.now());
        this.lMr.OX(str);
        this.lMr.bd(obj);
        this.lLO.a(this.lMr, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void onIntermediateImageSet(String str, @Nullable f fVar) {
        this.lMr.fa(this.lMy.now());
        this.lMr.OX(str);
        this.lMr.a(fVar);
        this.lLO.a(this.lMr, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lMr.fb(this.lMy.now());
        this.lMr.OX(str);
        this.lMr.a(fVar);
        this.lMr.vj(true);
        this.lLO.a(this.lMr, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFailure(String str, Throwable th) {
        this.lMr.fc(this.lMy.now());
        this.lMr.OX(str);
        this.lMr.vj(false);
        this.lLO.a(this.lMr, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onRelease(String str) {
        super.onRelease(str);
        int dmo = this.lMr.dmo();
        if (dmo != 3 && dmo != 5) {
            this.lMr.fd(this.lMy.now());
            this.lMr.OX(str);
            this.lMr.vi(true);
            this.lLO.a(this.lMr, 4);
        }
    }
}
