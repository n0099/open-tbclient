package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a mPi;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.mPi = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.mPi.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Iv(int i) {
        return this.mPi.IB(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.mPi.getLoopCount();
    }
}
