package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends com.facebook.drawee.controller.b {
    private long noe = -1;
    private long nof = -1;
    @Nullable
    private b nog;

    public a(@Nullable b bVar) {
        this.nog = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.noe = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.nof = System.currentTimeMillis();
        if (this.nog != null) {
            this.nog.gr(this.nof - this.noe);
        }
    }
}
