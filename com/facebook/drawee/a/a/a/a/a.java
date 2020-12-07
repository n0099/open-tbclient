package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g pdy;
    private final h peb;
    private final com.facebook.common.time.b pei;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pei = bVar;
        this.peb = hVar;
        this.pdy = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.peb.im(this.pei.now());
        this.peb.Zm(str);
        this.peb.bl(obj);
        this.pdy.a(this.peb, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void g(String str, @Nullable f fVar) {
        this.peb.in(this.pei.now());
        this.peb.Zm(str);
        this.peb.a(fVar);
        this.pdy.a(this.peb, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.peb.io(this.pei.now());
        this.peb.Zm(str);
        this.peb.a(fVar);
        this.peb.AL(true);
        this.pdy.a(this.peb, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.peb.ip(this.pei.now());
        this.peb.Zm(str);
        this.peb.AL(false);
        this.pdy.a(this.peb, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void hB(String str) {
        super.hB(str);
        int eqX = this.peb.eqX();
        if (eqX != 3 && eqX != 5) {
            this.peb.iq(this.pei.now());
            this.peb.Zm(str);
            this.peb.AK(true);
            this.pdy.a(this.peb, 4);
        }
    }
}
