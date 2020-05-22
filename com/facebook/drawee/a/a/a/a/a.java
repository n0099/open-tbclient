package com.facebook.drawee.a.a.a.a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.a.a.a.g;
import com.facebook.drawee.a.a.a.h;
import com.facebook.imagepipeline.g.f;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b<f> {
    private final h mnH;
    private final com.facebook.common.time.b mnO;
    private final g mne;

    public a(com.facebook.common.time.b bVar, h hVar, g gVar) {
        this.mnO = bVar;
        this.mnH = hVar;
        this.mne = gVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mnH.fF(this.mnO.now());
        this.mnH.PW(str);
        this.mnH.aY(obj);
        this.mne.a(this.mnH, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    /* renamed from: a */
    public void h(String str, @Nullable f fVar) {
        this.mnH.fG(this.mnO.now());
        this.mnH.PW(str);
        this.mnH.a(fVar);
        this.mne.a(this.mnH, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable f fVar, @Nullable Animatable animatable) {
        this.mnH.fH(this.mnO.now());
        this.mnH.PW(str);
        this.mnH.a(fVar);
        this.mnH.vV(true);
        this.mne.a(this.mnH, 3);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void h(String str, Throwable th) {
        this.mnH.fI(this.mnO.now());
        this.mnH.PW(str);
        this.mnH.vV(false);
        this.mne.a(this.mnH, 5);
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void eV(String str) {
        super.eV(str);
        int dvx = this.mnH.dvx();
        if (dvx != 3 && dvx != 5) {
            this.mnH.fJ(this.mnO.now());
            this.mnH.PW(str);
            this.mnH.vU(true);
            this.mne.a(this.mnH, 4);
        }
    }
}
