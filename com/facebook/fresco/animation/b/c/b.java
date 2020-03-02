package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b implements c {
    private static final Class<?> lHa = b.class;
    private com.facebook.imagepipeline.animated.base.a lOD;
    private AnimatedImageCompositor lOE;
    private final AnimatedImageCompositor.a lOF = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void c(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> HY(int i) {
            return b.this.lOl.HU(i);
        }
    };
    private final com.facebook.fresco.animation.b.b lOl;

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.lOl = bVar;
        this.lOD = aVar;
        this.lOE = new AnimatedImageCompositor(this.lOD, this.lOF);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a k = this.lOD.k(rect);
        if (k != this.lOD) {
            this.lOD = k;
            this.lOE = new AnimatedImageCompositor(this.lOD, this.lOF);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.lOD.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.lOD.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean b(int i, Bitmap bitmap) {
        try {
            this.lOE.d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(lHa, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
