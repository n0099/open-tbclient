package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b implements c {
    private static final Class<?> mki = b.class;
    private final com.facebook.fresco.animation.b.b mrF;
    private com.facebook.imagepipeline.animated.base.a mrX;
    private AnimatedImageCompositor mrY;
    private final AnimatedImageCompositor.a mrZ = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void b(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> Hr(int i) {
            return b.this.mrF.Hn(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.mrF = bVar;
        this.mrX = aVar;
        this.mrY = new AnimatedImageCompositor(this.mrX, this.mrZ);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a k = this.mrX.k(rect);
        if (k != this.mrX) {
            this.mrX = k;
            this.mrY = new AnimatedImageCompositor(this.mrX, this.mrZ);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.mrX.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.mrX.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean a(int i, Bitmap bitmap) {
        try {
            this.mrY.c(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(mki, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
