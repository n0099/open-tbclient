package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes3.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a pFB;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.pFB = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.pFB.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Pt(int i) {
        return this.pFB.Pz(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.pFB.getLoopCount();
    }
}
