package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes3.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a nrB;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.nrB = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.nrB.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Lu(int i) {
        return this.nrB.LA(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.nrB.getLoopCount();
    }
}
