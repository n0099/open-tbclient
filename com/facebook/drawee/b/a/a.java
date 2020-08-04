package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a extends com.facebook.drawee.controller.b {
    private long mUq = -1;
    private long mUr = -1;
    @Nullable
    private b mUs;

    public a(@Nullable b bVar) {
        this.mUs = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mUq = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.mUr = System.currentTimeMillis();
        if (this.mUs != null) {
            this.mUs.ge(this.mUr - this.mUq);
        }
    }
}
