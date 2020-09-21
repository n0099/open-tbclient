package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes6.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a nBz;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.nBz = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.nBz.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int LZ(int i) {
        return this.nBz.Mf(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.nBz.getLoopCount();
    }
}
