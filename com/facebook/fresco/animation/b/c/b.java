package com.facebook.fresco.animation.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.fresco.animation.b.c;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b implements c {
    private static final Class<?> paF = b.class;
    private final com.facebook.fresco.animation.b.b phM;
    private com.facebook.imagepipeline.animated.base.a pig;
    private AnimatedImageCompositor pih;
    private final AnimatedImageCompositor.a pii = new AnimatedImageCompositor.a() { // from class: com.facebook.fresco.animation.b.c.b.1
        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        public void c(int i, Bitmap bitmap) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
        @Nullable
        public com.facebook.common.references.a<Bitmap> Qv(int i) {
            return b.this.phM.Qr(i);
        }
    };

    public b(com.facebook.fresco.animation.b.b bVar, com.facebook.imagepipeline.animated.base.a aVar) {
        this.phM = bVar;
        this.pig = aVar;
        this.pih = new AnimatedImageCompositor(this.pig, this.pii);
    }

    @Override // com.facebook.fresco.animation.b.c
    public void setBounds(@Nullable Rect rect) {
        com.facebook.imagepipeline.animated.base.a m = this.pig.m(rect);
        if (m != this.pig) {
            this.pig = m;
            this.pih = new AnimatedImageCompositor(this.pig, this.pii);
        }
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicWidth() {
        return this.pig.getWidth();
    }

    @Override // com.facebook.fresco.animation.b.c
    public int getIntrinsicHeight() {
        return this.pig.getHeight();
    }

    @Override // com.facebook.fresco.animation.b.c
    public boolean b(int i, Bitmap bitmap) {
        try {
            this.pih.d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            com.facebook.common.c.a.b(paF, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
