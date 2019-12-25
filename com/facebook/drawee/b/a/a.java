package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a extends com.facebook.drawee.controller.b {
    @Nullable
    private b lHB;
    private long lHz = -1;
    private long lHA = -1;

    public a(@Nullable b bVar) {
        this.lHB = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
        this.lHz = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.lHA = System.currentTimeMillis();
        if (this.lHB != null) {
            this.lHB.fc(this.lHA - this.lHz);
        }
    }
}
