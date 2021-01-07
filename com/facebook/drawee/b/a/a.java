package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends com.facebook.drawee.controller.b {
    private long pwB = -1;
    private long pwC = -1;
    @Nullable
    private b pwD;

    public a(@Nullable b bVar) {
        this.pwD = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pwB = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.pwC = System.currentTimeMillis();
        if (this.pwD != null) {
            this.pwD.iH(this.pwC - this.pwB);
        }
    }
}
