package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class b implements c {
    private static final Class<?> pnm = b.class;
    private final com.facebook.fresco.animation.b.b puA;
    private com.facebook.imagepipeline.animated.base.a puS;
    private AnimatedImageCompositor puT;
    private final AnimatedImageCompositor.a puU = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void d(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> Pc(int i) {
            return b.this.puA.OY(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.puA = bVar;
        this.puS = aVar;
        this.puT = new AnimatedImageCompositor(this.puS, this.puU);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a m = this.puS.m(rect);
        if (m != this.puS) {
            this.puS = m;
            this.puT = new AnimatedImageCompositor(this.puS, this.puU);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.puS.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.puS.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean c(int i, Bitmap bitmap) {
        try {
            this.puT.e(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(pnm, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
