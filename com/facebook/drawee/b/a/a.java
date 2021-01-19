package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a extends com.facebook.drawee.controller.b {
    private long psa = -1;
    private long psb = -1;
    @Nullable
    private b psc;

    public a(@Nullable b bVar) {
        this.psc = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.psa = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.psb = System.currentTimeMillis();
        if (this.psc != null) {
            this.psc.iH(this.psb - this.psa);
        }
    }
}
