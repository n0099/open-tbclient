package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends com.facebook.drawee.controller.b {
    private long pwu = -1;
    private long pwv = -1;
    @Nullable
    private b pww;

    public a(@Nullable b bVar) {
        this.pww = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void f(String str, Object obj) {
        this.pwu = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.pwv = System.currentTimeMillis();
        if (this.pww != null) {
            this.pww.iH(this.pwv - this.pwu);
        }
    }
}
