package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b implements c {
    private static final Class<?> lGr = b.class;
    private final com.facebook.fresco.animation.b.b lNC;
    private com.facebook.imagepipeline.animated.base.a lNU;
    private AnimatedImageCompositor lNV;
    private final AnimatedImageCompositor.a lNW = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void c(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> HT(int i) {
            return b.this.lNC.HP(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.lNC = bVar;
        this.lNU = aVar;
        this.lNV = new AnimatedImageCompositor(this.lNU, this.lNW);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a k = this.lNU.k(rect);
        if (k != this.lNU) {
            this.lNU = k;
            this.lNV = new AnimatedImageCompositor(this.lNU, this.lNW);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.lNU.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.lNU.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean b(int i, Bitmap bitmap) {
        try {
            this.lNV.d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(lGr, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
