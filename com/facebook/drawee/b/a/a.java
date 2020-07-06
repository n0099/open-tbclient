package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long mMf = -1;
    private long mMg = -1;
    @Nullable
    private b mMh;

    public a(@Nullable b bVar) {
        this.mMh = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mMf = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.mMg = System.currentTimeMillis();
        if (this.mMh != null) {
            this.mMh.fR(this.mMg - this.mMf);
        }
    }
}
