package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.f.f;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h pqO;
    private final com.facebook.common.time.b pqV;
    private final g pql;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.pqV = bVar;
        this.pqO = hVar;
        this.pql = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pqO.iA(this.pqV.now());
        this.pqO.Yo(str);
        this.pqO.bl(obj);
        this.pql.a(this.pqO, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void g(String str, @Nullable f fVar) {
        this.pqO.iB(this.pqV.now());
        this.pqO.Yo(str);
        this.pqO.a(fVar);
        this.pql.a(this.pqO, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.pqO.iC(this.pqV.now());
        this.pqO.Yo(str);
        this.pqO.a(fVar);
        this.pqO.AP(true);
        this.pql.a(this.pqO, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.pqO.iD(this.pqV.now());
        this.pqO.Yo(str);
        this.pqO.AP(false);
        this.pql.a(this.pqO, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void ga(String str) {
        super.ga(str);
        int ern = this.pqO.ern();
        if (ern != 3 && ern != 5) {
            this.pqO.iE(this.pqV.now());
            this.pqO.Yo(str);
            this.pqO.AO(true);
            this.pql.a(this.pqO, 4);
        }
    }
}
