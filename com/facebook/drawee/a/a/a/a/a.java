package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h pqP;
    private final com.facebook.common.time.b pqW;
    private final g pqm;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pqW = bVar;
        this.pqP = hVar;
        this.pqm = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pqP.iA(this.pqW.now());
        this.pqP.Yp(str);
        this.pqP.bl(obj);
        this.pqm.a(this.pqP, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void g(String str, @Nullable f fVar) {
        this.pqP.iB(this.pqW.now());
        this.pqP.Yp(str);
        this.pqP.a(fVar);
        this.pqm.a(this.pqP, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.pqP.iC(this.pqW.now());
        this.pqP.Yp(str);
        this.pqP.a(fVar);
        this.pqP.AP(true);
        this.pqm.a(this.pqP, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.pqP.iD(this.pqW.now());
        this.pqP.Yp(str);
        this.pqP.AP(false);
        this.pqm.a(this.pqP, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void ga(String str) {
        super.ga(str);
        int ern = this.pqP.ern();
        if (ern != 3 && ern != 5) {
            this.pqP.iE(this.pqW.now());
            this.pqP.Yp(str);
            this.pqP.AO(true);
            this.pqm.a(this.pqP, 4);
        }
    }
}
