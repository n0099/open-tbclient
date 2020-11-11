package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g oMN;
    private final h oNq;
    private final com.facebook.common.time.b oNx;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.oNx = bVar;
        this.oNq = hVar;
        this.oMN = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.oNq.hE(this.oNx.now());
        this.oNq.Yg(str);
        this.oNq.bk(obj);
        this.oMN.a(this.oNq, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.oNq.hF(this.oNx.now());
        this.oNq.Yg(str);
        this.oNq.a(fVar);
        this.oMN.a(this.oNq, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.oNq.hG(this.oNx.now());
        this.oNq.Yg(str);
        this.oNq.a(fVar);
        this.oNq.Aa(true);
        this.oMN.a(this.oNq, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.oNq.hH(this.oNx.now());
        this.oNq.Yg(str);
        this.oNq.Aa(false);
        this.oMN.a(this.oNq, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void hm(String str) {
        super.hm(str);
        int elk = this.oNq.elk();
        if (elk != 3 && elk != 5) {
            this.oNq.hI(this.oNx.now());
            this.oNq.Yg(str);
            this.oNq.zZ(true);
            this.oMN.a(this.oNq, 4);
        }
    }
}
