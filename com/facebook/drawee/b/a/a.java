package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b {
    private long oFi = -1;
    private long oFj = -1;
    @Nullable
    private b oFk;

    public a(@Nullable b bVar) {
        this.oFk = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.oFi = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.oFj = System.currentTimeMillis();
        if (this.oFk != null) {
            this.oFk.hp(this.oFj - this.oFi);
        }
    }
}
