package com.facebook.drawee.b.a;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class a extends com.facebook.drawee.controller.b {
    private long mqd = -1;
    private long mqe = -1;
    @Nullable
    private b mqf;

    public a(@Nullable b bVar) {
        this.mqf = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void g(String str, Object obj) {
        this.mqd = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        this.mqe = System.currentTimeMillis();
        if (this.mqf != null) {
            this.mqf.fM(this.mqe - this.mqd);
        }
    }
}
