package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g mSv;
    private final h mTa;
    private final com.facebook.common.time.b mTh;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.mTh = bVar;
        this.mTa = hVar;
        this.mSv = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mTa.fX(this.mTh.now());
        this.mTa.Rv(str);
        this.mTa.aZ(obj);
        this.mSv.a(this.mTa, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.mTa.fY(this.mTh.now());
        this.mTa.Rv(str);
        this.mTa.a(fVar);
        this.mSv.a(this.mTa, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.mTa.fZ(this.mTh.now());
        this.mTa.Rv(str);
        this.mTa.a(fVar);
        this.mTa.wY(true);
        this.mSv.a(this.mTa, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.mTa.ga(this.mTh.now());
        this.mTa.Rv(str);
        this.mTa.wY(false);
        this.mSv.a(this.mTa, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void fa(String str) {
        super.fa(str);
        int dDE = this.mTa.dDE();
        if (dDE != 3 && dDE != 5) {
            this.mTa.gb(this.mTh.now());
            this.mTa.Rv(str);
            this.mTa.wX(true);
            this.mSv.a(this.mTa, 4);
        }
    }
}
