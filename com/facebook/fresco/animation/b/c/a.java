package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a mrX;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.mrX = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.mrX.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Hm(int i) {
        return this.mrX.Hs(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.mrX.getLoopCount();
    }
}
