package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes12.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a nQS;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.nQS = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.nQS.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int MF(int i) {
        return this.nQS.ML(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.nQS.getLoopCount();
    }
}
