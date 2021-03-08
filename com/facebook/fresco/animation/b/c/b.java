package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class b implements c {
    private static final Class<?> pAh = b.class;
    private com.facebook.imagepipeline.animated.base.a pHG;
    private AnimatedImageCompositor pHH;
    private final AnimatedImageCompositor.a pHI = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void d(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> PC(int i) {
            return b.this.pHo.Py(i);
        }
    };
    private final com.facebook.fresco.animation.b.b pHo;

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.pHo = bVar;
        this.pHG = aVar;
        this.pHH = new AnimatedImageCompositor(this.pHG, this.pHI);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a m = this.pHG.m(rect);
        if (m != this.pHG) {
            this.pHG = m;
            this.pHH = new AnimatedImageCompositor(this.pHG, this.pHI);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.pHG.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.pHG.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean c(int i, Bitmap bitmap) {
        try {
            this.pHH.e(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(pAh, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
