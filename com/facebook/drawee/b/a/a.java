package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a extends com.facebook.drawee.controller.b {
    private long mUo = -1;
    private long mUp = -1;
    @Nullable
    private b mUq;

    public a(@Nullable b bVar) {
        this.mUq = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mUo = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.mUp = System.currentTimeMillis();
        if (this.mUq != null) {
            this.mUq.ge(this.mUp - this.mUo);
        }
    }
}
