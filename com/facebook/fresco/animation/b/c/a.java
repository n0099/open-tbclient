package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes12.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a oRD;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.oRD = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.oRD.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int OR(int i) {
        return this.oRD.OX(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.oRD.getLoopCount();
    }
}
