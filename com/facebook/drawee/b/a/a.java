package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a extends com.facebook.drawee.controller.b {
    private long prZ = -1;
    private long psa = -1;
    @Nullable
    private b psb;

    public a(@Nullable b bVar) {
        this.psb = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.prZ = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.psa = System.currentTimeMillis();
        if (this.psb != null) {
            this.psb.iH(this.psa - this.prZ);
        }
    }
}
