package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b implements c {
    private static final Class<?> oJR = b.class;
    private com.facebook.imagepipeline.animated.base.a oRD;
    private AnimatedImageCompositor oRE;
    private final AnimatedImageCompositor.a oRF = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void c(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> OW(int i) {
            return b.this.oRl.OS(i);
        }
    };
    private final com.facebook.fresco.animation.b.b oRl;

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.oRl = bVar;
        this.oRD = aVar;
        this.oRE = new AnimatedImageCompositor(this.oRD, this.oRF);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a m = this.oRD.m(rect);
        if (m != this.oRD) {
            this.oRD = m;
            this.oRE = new AnimatedImageCompositor(this.oRD, this.oRF);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.oRD.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.oRD.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean b(int i, Bitmap bitmap) {
        try {
            this.oRE.d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(oJR, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
