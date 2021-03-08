package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends com.facebook.drawee.controller.b {
    private long pEO = -1;
    private long pEP = -1;
    @Nullable
    private b pEQ;

    public a(@Nullable b bVar) {
        this.pEQ = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.pEO = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.pEP = System.currentTimeMillis();
        if (this.pEQ != null) {
            this.pEQ.iK(this.pEP - this.pEO);
        }
    }
}
