package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b implements c {
    private static final Class<?> mPz = b.class;
    private final com.facebook.fresco.animation.b.b mXc;
    private com.facebook.imagepipeline.animated.base.a mXu;
    private AnimatedImageCompositor mXv;
    private final AnimatedImageCompositor.a mXw = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void b(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> IV(int i) {
            return b.this.mXc.IR(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.mXc = bVar;
        this.mXu = aVar;
        this.mXv = new AnimatedImageCompositor(this.mXu, this.mXw);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a k = this.mXu.k(rect);
        if (k != this.mXu) {
            this.mXu = k;
            this.mXv = new AnimatedImageCompositor(this.mXu, this.mXw);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.mXu.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.mXu.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean a(int i, Bitmap bitmap) {
        try {
            this.mXv.c(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(mPz, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
