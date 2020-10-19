package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b {
    private long nNP = -1;
    private long nNQ = -1;
    @Nullable
    private b nNR;

    public a(@Nullable b bVar) {
        this.nNR = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.nNP = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.nNQ = System.currentTimeMillis();
        if (this.nNR != null) {
            this.nNR.gZ(this.nNQ - this.nNP);
        }
    }
}
