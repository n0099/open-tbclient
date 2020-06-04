package com.facebook.fresco.animation.b.c;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes13.dex */
public class a implements d {
    private final com.facebook.imagepipeline.animated.base.a mti;

    public a(com.facebook.imagepipeline.animated.base.a aVar) {
        this.mti = aVar;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.mti.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Ho(int i) {
        return this.mti.Hu(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.mti.getLoopCount();
    }
}
