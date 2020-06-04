package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b implements c {
    private static final Class<?> mls = b.class;
    private final com.facebook.fresco.animation.b.b msQ;
    private com.facebook.imagepipeline.animated.base.a mti;
    private AnimatedImageCompositor mtj;
    private final AnimatedImageCompositor.a mtk = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void b(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> Ht(int i) {
            return b.this.msQ.Hp(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.msQ = bVar;
        this.mti = aVar;
        this.mtj = new AnimatedImageCompositor(this.mti, this.mtk);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a k = this.mti.k(rect);
        if (k != this.mti) {
            this.mti = k;
            this.mtj = new AnimatedImageCompositor(this.mti, this.mtk);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.mti.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.mti.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean a(int i, Bitmap bitmap) {
        try {
            this.mtj.c(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(mls, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
