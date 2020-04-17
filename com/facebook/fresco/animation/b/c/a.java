package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a lXZ;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.lXZ = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.lXZ.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int GA(int i) {
        return this.lXZ.GG(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.lXZ.getLoopCount();
    }
}
