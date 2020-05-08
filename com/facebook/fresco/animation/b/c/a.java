package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a lYd;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.lYd = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.lYd.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int GA(int i) {
        return this.lYd.GG(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.lYd.getLoopCount();
    }
}
