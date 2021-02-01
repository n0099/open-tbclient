package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b {
    private long pCj = -1;
    private long pCk = -1;
    @Nullable
    private b pCl;

    public a(@Nullable b bVar) {
        this.pCl = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pCj = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.pCk = System.currentTimeMillis();
        if (this.pCl != null) {
            this.pCl.iK(this.pCk - this.pCj);
        }
    }
}
