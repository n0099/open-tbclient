package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b implements c {
    private static final Class<?> lGm = b.class;
    private com.facebook.imagepipeline.animated.base.a lNP;
    private AnimatedImageCompositor lNQ;
    private final AnimatedImageCompositor.a lNR = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void c(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> HT(int i) {
            return b.this.lNx.HP(i);
        }
    };
    private final com.facebook.fresco.animation.b.b lNx;

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.lNx = bVar;
        this.lNP = aVar;
        this.lNQ = new AnimatedImageCompositor(this.lNP, this.lNR);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a k = this.lNP.k(rect);
        if (k != this.lNP) {
            this.lNP = k;
            this.lNQ = new AnimatedImageCompositor(this.lNP, this.lNR);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.lNP.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.lNP.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean b(int i, Bitmap bitmap) {
        try {
            this.lNQ.d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(lGm, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
