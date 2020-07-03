package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long mMc = -1;
    private long mMd = -1;
    @Nullable
    private b mMe;

    public a(@Nullable b bVar) {
        this.mMe = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mMc = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.mMd = System.currentTimeMillis();
        if (this.mMe != null) {
            this.mMe.fR(this.mMd - this.mMc);
        }
    }
}
