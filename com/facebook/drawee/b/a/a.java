package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class a extends com.facebook.drawee.controller.b {
    private long oQf = -1;
    private long oQg = -1;
    @Nullable
    private b oQh;

    public a(@Nullable b bVar) {
        this.oQh = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.oQf = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.oQg = System.currentTimeMillis();
        if (this.oQh != null) {
            this.oQh.hO(this.oQg - this.oQf);
        }
    }
}
