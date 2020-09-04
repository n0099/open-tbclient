package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends com.facebook.drawee.controller.b {
    @Nullable
    private b noA;
    private long noy = -1;
    private long noz = -1;

    public a(@Nullable b bVar) {
        this.noA = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.noy = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.noz = System.currentTimeMillis();
        if (this.noA != null) {
            this.noA.gt(this.noz - this.noy);
        }
    }
}
