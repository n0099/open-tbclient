package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class a extends com.facebook.drawee.controller.b {
    private long nyw = -1;
    private long nyx = -1;
    @Nullable
    private b nyy;

    public a(@Nullable b bVar) {
        this.nyy = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.nyw = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.nyx = System.currentTimeMillis();
        if (this.nyy != null) {
            this.nyy.gH(this.nyx - this.nyw);
        }
    }
}
