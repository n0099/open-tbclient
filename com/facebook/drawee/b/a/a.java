package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long lLJ = -1;
    private long lLK = -1;
    @Nullable
    private b lLL;

    public a(@Nullable b bVar) {
        this.lLL = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lLJ = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lLK = System.currentTimeMillis();
        if (this.lLL != null) {
            this.lLL.ff(this.lLK - this.lLJ);
        }
    }
}
