package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes5.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a pzt;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.pzt = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.pzt.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int QE(int i) {
        return this.pzt.QK(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.pzt.getLoopCount();
    }
}
