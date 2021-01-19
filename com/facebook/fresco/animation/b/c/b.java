package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class b implements c {
    private static final Class<?> pnn = b.class;
    private final com.facebook.fresco.animation.b.b puB;
    private com.facebook.imagepipeline.animated.base.a puT;
    private AnimatedImageCompositor puU;
    private final AnimatedImageCompositor.a puV = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void d(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> Pc(int i) {
            return b.this.puB.OY(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.puB = bVar;
        this.puT = aVar;
        this.puU = new AnimatedImageCompositor(this.puT, this.puV);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a m = this.puT.m(rect);
        if (m != this.puT) {
            this.puT = m;
            this.puU = new AnimatedImageCompositor(this.puT, this.puV);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.puT.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.puT.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean c(int i, Bitmap bitmap) {
        try {
            this.puU.e(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(pnn, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
