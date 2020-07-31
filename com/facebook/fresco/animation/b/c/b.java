package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b implements c {
    private static final Class<?> mPx = b.class;
    private final com.facebook.fresco.animation.b.b mXa;
    private com.facebook.imagepipeline.animated.base.a mXs;
    private AnimatedImageCompositor mXt;
    private final AnimatedImageCompositor.a mXu = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void b(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> IV(int i) {
            return b.this.mXa.IR(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.mXa = bVar;
        this.mXs = aVar;
        this.mXt = new AnimatedImageCompositor(this.mXs, this.mXu);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a k = this.mXs.k(rect);
        if (k != this.mXs) {
            this.mXs = k;
            this.mXt = new AnimatedImageCompositor(this.mXs, this.mXu);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.mXs.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.mXs.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean a(int i, Bitmap bitmap) {
        try {
            this.mXt.c(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(mPx, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
