package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b {
    private long oOB = -1;
    private long oOC = -1;
    @Nullable
    private b oOD;

    public a(@Nullable b bVar) {
        this.oOD = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.oOB = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.oOC = System.currentTimeMillis();
        if (this.oOD != null) {
            this.oOD.hL(this.oOC - this.oOB);
        }
    }
}
