package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h nME;
    private final com.facebook.common.time.b nML;
    private final g nMb;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.nML = bVar;
        this.nME = hVar;
        this.nMb = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.nME.gS(this.nML.now());
        this.nME.VP(str);
        this.nME.bg(obj);
        this.nMb.a(this.nME, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.nME.gT(this.nML.now());
        this.nME.VP(str);
        this.nME.a(fVar);
        this.nMb.a(this.nME, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.nME.gU(this.nML.now());
        this.nME.VP(str);
        this.nME.a(fVar);
        this.nME.yH(true);
        this.nMb.a(this.nME, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.nME.gV(this.nML.now());
        this.nME.VP(str);
        this.nME.yH(false);
        this.nMb.a(this.nME, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void gU(String str) {
        super.gU(str);
        int dXx = this.nME.dXx();
        if (dXx != 3 && dXx != 5) {
            this.nME.gW(this.nML.now());
            this.nME.VP(str);
            this.nME.yG(true);
            this.nMb.a(this.nME, 4);
        }
    }
}
