package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes12.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a mXs;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.mXs = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.mXs.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int IQ(int i) {
        return this.mXs.IW(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.mXs.getLoopCount();
    }
}
