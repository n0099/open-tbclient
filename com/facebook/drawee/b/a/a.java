package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a extends com.facebook.drawee.controller.b {
    private long pfp = -1;
    private long pfq = -1;
    @Nullable
    private b pfr;

    public a(@Nullable b bVar) {
        this.pfr = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pfp = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.pfq = System.currentTimeMillis();
        if (this.pfr != null) {
            this.pfr.it(this.pfq - this.pfp);
        }
    }
}
