package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b {
    private long pCJ = -1;
    private long pCK = -1;
    @Nullable
    private b pCL;

    public a(@Nullable b bVar) {
        this.pCL = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pCJ = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.pCK = System.currentTimeMillis();
        if (this.pCL != null) {
            this.pCL.iK(this.pCK - this.pCJ);
        }
    }
}
