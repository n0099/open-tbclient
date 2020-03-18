package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long lNC = -1;
    private long lND = -1;
    @Nullable
    private b lNE;

    public a(@Nullable b bVar) {
        this.lNE = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lNC = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lND = System.currentTimeMillis();
        if (this.lNE != null) {
            this.lNE.fg(this.lND - this.lNC);
        }
    }
}
