package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final g lJX;
    private final h lKA;
    private final com.facebook.common.time.b lKH;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.lKH = bVar;
        this.lKA = hVar;
        this.lJX = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lKA.eY(this.lKH.now());
        this.lKA.OX(str);
        this.lKA.bd(obj);
        this.lJX.a(this.lKA, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void onIntermediateImageSet(String str, @Nullable f fVar) {
        this.lKA.eZ(this.lKH.now());
        this.lKA.OX(str);
        this.lKA.a(fVar);
        this.lJX.a(this.lKA, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.lKA.fa(this.lKH.now());
        this.lKA.OX(str);
        this.lKA.a(fVar);
        this.lKA.vc(true);
        this.lJX.a(this.lKA, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFailure(String str, Throwable th) {
        this.lKA.fb(this.lKH.now());
        this.lKA.OX(str);
        this.lKA.vc(false);
        this.lJX.a(this.lKA, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onRelease(String str) {
        super.onRelease(str);
        int dlQ = this.lKA.dlQ();
        if (dlQ != 3 && dlQ != 5) {
            this.lKA.fc(this.lKH.now());
            this.lKA.OX(str);
            this.lKA.vb(true);
            this.lJX.a(this.lKA, 4);
        }
    }
}
