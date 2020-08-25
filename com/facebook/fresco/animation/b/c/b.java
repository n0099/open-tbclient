package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b implements c {
    private static final Class<?> nju = b.class;
    private final com.facebook.fresco.animation.b.b nqR;
    private com.facebook.imagepipeline.animated.base.a nrj;
    private AnimatedImageCompositor nrk;
    private final AnimatedImageCompositor.a nrl = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void b(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> Lz(int i) {
            return b.this.nqR.Lv(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.nqR = bVar;
        this.nrj = aVar;
        this.nrk = new AnimatedImageCompositor(this.nrj, this.nrl);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a k = this.nrj.k(rect);
        if (k != this.nrj) {
            this.nrj = k;
            this.nrk = new AnimatedImageCompositor(this.nrj, this.nrl);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.nrj.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.nrj.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean a(int i, Bitmap bitmap) {
        try {
            this.nrk.c(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(nju, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
