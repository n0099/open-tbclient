package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes10.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a oTg;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.oTg = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.oTg.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Pu(int i) {
        return this.oTg.PA(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.oTg.getLoopCount();
    }
}
