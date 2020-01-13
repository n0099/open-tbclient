package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.drawee.controller.b {
    private long lKX = -1;
    private long lKY = -1;
    @Nullable
    private b lKZ;

    public a(@Nullable b bVar) {
        this.lKZ = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lKX = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lKY = System.currentTimeMillis();
        if (this.lKZ != null) {
            this.lKZ.fh(this.lKY - this.lKX);
        }
    }
}
