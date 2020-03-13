package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long lLW = -1;
    private long lLX = -1;
    @Nullable
    private b lLY;

    public a(@Nullable b bVar) {
        this.lLY = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lLW = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lLX = System.currentTimeMillis();
        if (this.lLY != null) {
            this.lLY.ff(this.lLX - this.lLW);
        }
    }
}
