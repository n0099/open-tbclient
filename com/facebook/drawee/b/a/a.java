package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a extends com.facebook.drawee.controller.b {
    private long pfn = -1;
    private long pfo = -1;
    @Nullable
    private b pfp;

    public a(@Nullable b bVar) {
        this.pfp = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pfn = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.pfo = System.currentTimeMillis();
        if (this.pfp != null) {
            this.pfp.it(this.pfo - this.pfn);
        }
    }
}
