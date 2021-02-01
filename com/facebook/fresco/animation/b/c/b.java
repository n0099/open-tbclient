package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b implements c {
    private static final Class<?> pxC = b.class;
    private final com.facebook.fresco.animation.b.b pEJ;
    private com.facebook.imagepipeline.animated.base.a pFb;
    private AnimatedImageCompositor pFc;
    private final AnimatedImageCompositor.a pFd = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void d(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> Px(int i) {
            return b.this.pEJ.Pt(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.pEJ = bVar;
        this.pFb = aVar;
        this.pFc = new AnimatedImageCompositor(this.pFb, this.pFd);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a m = this.pFb.m(rect);
        if (m != this.pFb) {
            this.pFb = m;
            this.pFc = new AnimatedImageCompositor(this.pFb, this.pFd);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.pFb.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.pFb.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean c(int i, Bitmap bitmap) {
        try {
            this.pFc.e(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(pxC, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
