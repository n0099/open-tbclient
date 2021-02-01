package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes3.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a pFb;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.pFb = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.pFb.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Ps(int i) {
        return this.pFb.Py(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.pFb.getLoopCount();
    }
}
