package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g pdA;
    private final h ped;
    private final com.facebook.common.time.b pek;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pek = bVar;
        this.ped = hVar;
        this.pdA = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.ped.im(this.pek.now());
        this.ped.Zm(str);
        this.ped.bl(obj);
        this.pdA.a(this.ped, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void g(String str, @Nullable f fVar) {
        this.ped.in(this.pek.now());
        this.ped.Zm(str);
        this.ped.a(fVar);
        this.pdA.a(this.ped, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.ped.io(this.pek.now());
        this.ped.Zm(str);
        this.ped.a(fVar);
        this.ped.AL(true);
        this.pdA.a(this.ped, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.ped.ip(this.pek.now());
        this.ped.Zm(str);
        this.ped.AL(false);
        this.pdA.a(this.ped, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void hB(String str) {
        super.hB(str);
        int eqY = this.ped.eqY();
        if (eqY != 3 && eqY != 5) {
            this.ped.iq(this.pek.now());
            this.ped.Zm(str);
            this.ped.AK(true);
            this.pdA.a(this.ped, 4);
        }
    }
}
