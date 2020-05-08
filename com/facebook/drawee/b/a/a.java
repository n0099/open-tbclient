package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long lVa = -1;
    private long lVb = -1;
    @Nullable
    private b lVc;

    public a(@Nullable b bVar) {
        this.lVc = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.lVa = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lVb = System.currentTimeMillis();
        if (this.lVc != null) {
            this.lVc.fM(this.lVb - this.lVa);
        }
    }
}
