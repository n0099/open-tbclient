package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long lUW = -1;
    private long lUX = -1;
    @Nullable
    private b lUY;

    public a(@Nullable b bVar) {
        this.lUY = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.lUW = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lUX = System.currentTimeMillis();
        if (this.lUY != null) {
            this.lUY.fM(this.lUX - this.lUW);
        }
    }
}
