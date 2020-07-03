package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a mPf;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.mPf = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.mPf.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Iv(int i) {
        return this.mPf.IB(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.mPf.getLoopCount();
    }
}
