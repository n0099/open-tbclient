package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b implements c {
    private static final Class<?> pyc = b.class;
    private com.facebook.imagepipeline.animated.base.a pFB;
    private AnimatedImageCompositor pFC;
    private final AnimatedImageCompositor.a pFD = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void d(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> Py(int i) {
            return b.this.pFj.Pu(i);
        }
    };
    private final com.facebook.fresco.animation.b.b pFj;

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.pFj = bVar;
        this.pFB = aVar;
        this.pFC = new AnimatedImageCompositor(this.pFB, this.pFD);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a m = this.pFB.m(rect);
        if (m != this.pFB) {
            this.pFB = m;
            this.pFC = new AnimatedImageCompositor(this.pFB, this.pFD);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.pFB.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.pFB.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean c(int i, Bitmap bitmap) {
        try {
            this.pFC.e(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(pyc, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
