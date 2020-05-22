package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long moT = -1;
    private long moU = -1;
    @Nullable
    private b moV;

    public a(@Nullable b bVar) {
        this.moV = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.moT = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.moU = System.currentTimeMillis();
        if (this.moV != null) {
            this.moV.fM(this.moU - this.moT);
        }
    }
}
