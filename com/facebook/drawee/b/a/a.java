package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a extends com.facebook.drawee.controller.b {
    private long lLc = -1;
    private long lLd = -1;
    @Nullable
    private b lLe;

    public a(@Nullable b bVar) {
        this.lLe = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lLc = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lLd = System.currentTimeMillis();
        if (this.lLe != null) {
            this.lLe.fh(this.lLd - this.lLc);
        }
    }
}
