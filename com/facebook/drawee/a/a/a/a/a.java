package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g mSx;
    private final h mTc;
    private final com.facebook.common.time.b mTk;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.mTk = bVar;
        this.mTc = hVar;
        this.mSx = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mTc.fX(this.mTk.now());
        this.mTc.Rv(str);
        this.mTc.aZ(obj);
        this.mSx.a(this.mTc, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.mTc.fY(this.mTk.now());
        this.mTc.Rv(str);
        this.mTc.a(fVar);
        this.mSx.a(this.mTc, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.mTc.fZ(this.mTk.now());
        this.mTc.Rv(str);
        this.mTc.a(fVar);
        this.mTc.wY(true);
        this.mSx.a(this.mTc, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.mTc.ga(this.mTk.now());
        this.mTc.Rv(str);
        this.mTc.wY(false);
        this.mSx.a(this.mTc, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void fa(String str) {
        super.fa(str);
        int dDF = this.mTc.dDF();
        if (dDF != 3 && dDF != 5) {
            this.mTc.gb(this.mTk.now());
            this.mTc.Rv(str);
            this.mTc.wX(true);
            this.mSx.a(this.mTc, 4);
        }
    }
}
