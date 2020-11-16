package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h oOU;
    private final g oOr;
    private final com.facebook.common.time.b oPb;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.oPb = bVar;
        this.oOU = hVar;
        this.oOr = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.oOU.hH(this.oPb.now());
        this.oOU.XR(str);
        this.oOU.bl(obj);
        this.oOr.a(this.oOU, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.oOU.hI(this.oPb.now());
        this.oOU.XR(str);
        this.oOU.a(fVar);
        this.oOr.a(this.oOU, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.oOU.hJ(this.oPb.now());
        this.oOU.XR(str);
        this.oOU.a(fVar);
        this.oOU.Ah(true);
        this.oOr.a(this.oOU, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.oOU.hK(this.oPb.now());
        this.oOU.XR(str);
        this.oOU.Ah(false);
        this.oOr.a(this.oOU, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void hg(String str) {
        super.hg(str);
        int eli = this.oOU.eli();
        if (eli != 3 && eli != 5) {
            this.oOU.hL(this.oPb.now());
            this.oOU.XR(str);
            this.oOU.Ag(true);
            this.oOr.a(this.oOU, 4);
        }
    }
}
