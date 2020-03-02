package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long lLL = -1;
    private long lLM = -1;
    @Nullable
    private b lLN;

    public a(@Nullable b bVar) {
        this.lLN = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lLL = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lLM = System.currentTimeMillis();
        if (this.lLN != null) {
            this.lLN.ff(this.lLM - this.lLL);
        }
    }
}
