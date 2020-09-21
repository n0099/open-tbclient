package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g nwI;
    private final h nxl;
    private final com.facebook.common.time.b nxs;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.nxs = bVar;
        this.nxl = hVar;
        this.nwI = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.nxl.gA(this.nxs.now());
        this.nxl.Vb(str);
        this.nxl.bd(obj);
        this.nwI.a(this.nxl, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.nxl.gB(this.nxs.now());
        this.nxl.Vb(str);
        this.nxl.a(fVar);
        this.nwI.a(this.nxl, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.nxl.gC(this.nxs.now());
        this.nxl.Vb(str);
        this.nxl.a(fVar);
        this.nxl.ya(true);
        this.nwI.a(this.nxl, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.nxl.gD(this.nxs.now());
        this.nxl.Vb(str);
        this.nxl.ya(false);
        this.nwI.a(this.nxl, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void gG(String str) {
        super.gG(str);
        int dTM = this.nxl.dTM();
        if (dTM != 3 && dTM != 5) {
            this.nxl.gE(this.nxs.now());
            this.nxl.Vb(str);
            this.nxl.xZ(true);
            this.nwI.a(this.nxl, 4);
        }
    }
}
